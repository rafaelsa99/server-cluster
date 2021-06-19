
package Monitor;

import Communication.CClient;
import Communication.CServer;
import Communication.Message;
import Communication.MessageCodes;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Monitor server to receive and process messages.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */

public class Monitor extends Thread implements I_Monitor{
    
    /** Communication Server. Basic server functions. */
    private final CServer cServer;
    /** Communication channel to the load balancer. */
    private CClient cLB;
    /** Heartbeat threshold. */
    private final int heartbeatThreshold;
    /** Servers Information. */
    private final Map<Integer, ServerInfo> servers;
    /** Servers Requests Counters. */
    private final Map<Integer, ServerCounter> serversCounters;
    /** Requests waiting to be assigned to a server. */
    private final Map<Integer, Message> waitingRequests;
    /** Servers heartbeat threads. */
    private final Map<Integer, ServerHeartbeatThread> heartbeatThreads;
    /** Monitor GUI. */
    private final Monitor_GUI monitorGUI;
    /** End flag. */
    private boolean end;
    
    /**
     * Monitor instantiation.
     * @param port server socket port
     * @param hostname load balancer host name
     * @param lbPort load balancer port
     * @param heartbeatThreshold heartbeat threshold
     * @param mGUI monitor GUI reference
     */
    public Monitor(int port, String hostname, int lbPort, int heartbeatThreshold, Monitor_GUI mGUI) {
        super("Monitor");
        this.heartbeatThreshold = heartbeatThreshold;
        this.cServer = new CServer(port);
        initLBConnection(hostname, lbPort);
        this.servers = new HashMap<>();
        this.serversCounters = new HashMap<>();
        this.waitingRequests = new HashMap<>();
        this.monitorGUI = mGUI;
        this.heartbeatThreads = new HashMap<>();
        this.end = false;
    }
    
    /**
     * Check if load balancer is up, and if so, establish the connection.
     * @param hostname load balancer host name
     * @param lbPort load balancer port
     */
    private void initLBConnection(String hostname, int lbPort){
        if(CClient.testConnection(hostname, lbPort)){
            cLB = new CClient(hostname, lbPort);
            cLB.connectToServer();
            Message msg = new Message(MessageCodes.REG_LB_M);
            cLB.sendMessage(msg);
            new ClientCommunicationsThread(cLB).start();
        }
    }
    
    /**
     * Close all sockets connected to the monitor.
     */
    public void closeSockets(){
        servers.values().forEach(server -> {
            server.closeConnection();
        });
        if(cLB != null)
            cLB.closeConnection();
        setEnd(true);
    }

    /**
     * Check if the end flag is true.
     * @return true if is end, false otherwise.
     */
    public synchronized boolean isEnd() {
        return end;
    }

    /**
     * Set the end flag. 
     * @param end value to the end flag
     */
    public synchronized void setEnd(boolean end) {
        this.end = end;
    }
    
    /**
     * Get requests of a server.
     * @param serverId server id
     * @return list of requests
     */
    public synchronized List<Message> getRequests(int serverId){
        return new ArrayList<>(servers.get(serverId).getRequests());
    }
    
    /**
     * Get current states of the requests of a server.
     * @param serverId server id
     * @return current state of the requests
     */
    public synchronized Map<Integer, String> getCurrentStates(int serverId){
        return servers.get(serverId).getCurrentState();
    }
    
    /**
     * Life cycle of the server.
     * Await new clients while server socket is open.
     */
    @Override
    public void run() {
        Socket socket;
        CClient cc;
        cServer.openServer();
        while((socket = cServer.awaitClient()) != null){
            try {
                cc = new CClient(socket);
                new ClientCommunicationsThread(cc).start();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    /**
     * Server down to update load balancer and GUI.
     * @param serverId server id
     */
    @Override
    public synchronized void serverDown(int serverId) {
        Message msg = new Message(MessageCodes.SERVER_DOWN, serverId);
        msg.setServerRequests(servers.get(serverId).getRequests());
        monitorGUI.setServerDown(serverId);
        servers.get(serverId).getRequests().forEach(m -> {
            monitorGUI.setNumRequestsServer(serverId, 0);
            monitorGUI.removeRequestFromLBTable(m.getRequestId());
            monitorGUI.removeRequestFromRequestTable(m.getRequestId());
        });
        servers.remove(serverId);
        serversCounters.remove(serverId);
        heartbeatThreads.remove(serverId);
        cLB.sendMessage(msg);
    }

    /**
     * Server heartbeat.
     * @param serverId server id
     */
    @Override
    public synchronized void serverHeartbeat(int serverId){
        heartbeatThreads.get(serverId).interrupt();
    }
    
    /**
     * New request received on Load Balancer.
     * Send the servers counters to the load balancer for the assignment decision.
     * @param request request message received
     */
    @Override
    public synchronized void newLBRequest(Message request) {
        monitorGUI.addRequestToLBTable(request);
        waitingRequests.put(request.getRequestId(), request);
        Message msg = new Message(MessageCodes.SERVERS_COUNTERS, request.getRequestId(), new ArrayList<>(serversCounters.values()));
        cLB.sendMessage(msg);
    }

    /**
     * Reply message for a given request.
     * @param reply reply message
     */
    @Override
    public synchronized void newLBReply(Message reply) {
        serversCounters.get(reply.getServerId()).decrementCounter();
        servers.get(reply.getServerId()).removeRequest(reply.getRequestId());
        monitorGUI.setNumRequestsServer(reply.getServerId(), serversCounters.get(reply.getServerId()).getCounter());
        monitorGUI.removeRequestFromLBTable(reply.getRequestId());
        monitorGUI.removeRequestFromRequestTable(reply.getRequestId());
    }

    /**
     * Message indicating that a request was rejected because there was no available servers.
     * @param requestId request id
     */
    @Override
    public synchronized void requestRejectionByNoServers(int requestId){
        monitorGUI.removeRequestFromLBTable(requestId);
        monitorGUI.removeRequestFromRequestTable(requestId);
    }
    
    /**
     * Update the current iteration of a request being processed by a server.
     * @param requestId request id
     * @param currentIter current iteration
     * @param serverId server id
     */
    @Override
    public synchronized void serverIterationsUpdate(int requestId, int currentIter, int serverId) {
        servers.get(serverId).setCurrentState(requestId, Integer.toString(currentIter));
        monitorGUI.setCurrentIterationsRequestLBTable(requestId, currentIter);
        monitorGUI.setCurrentIterationsRequestTable(requestId, currentIter);
    }

    /**
     * Request assigned to a server. 
     * @param requestId request id
     * @param serverId server id
     */
    @Override
    public synchronized void requestAssigned(int requestId, int serverId) {
        Message request = waitingRequests.remove(requestId);
        servers.get(serverId).addRequest(request);
        serversCounters.get(serverId).incrementCounter();
        monitorGUI.setRequestServer(requestId, serverId);
        monitorGUI.setNumRequestsServer(serverId, serversCounters.get(serverId).getCounter());
        monitorGUI.addRequestToTableRequest(requestId, request.getClientId(), request.getIterations(), "In Queue", serverId);
    }

    /**
     * Register a new server connected to the monitor.
     * @param serverId server id
     * @param cc communication client
     */
    @Override
    public synchronized void newServer(int serverId, CClient cc) {
        servers.put(serverId, new ServerInfo(cc));
        serversCounters.put(serverId, new ServerCounter(serverId, 0));
        monitorGUI.addServerToTable(serverId);
        heartbeatThreads.put(serverId, new ServerHeartbeatThread(serverId));
        heartbeatThreads.get(serverId).start();
    }

    /**
     * Register the load balancer.
     * @param cc communication client to the load balancer
     */
    @Override
    public synchronized void loadBalancerUp(CClient cc) {
        cLB = cc;
    }
    
    /**
     * Thread for handle the communications of a given client.
     */
    class ClientCommunicationsThread extends Thread{
        
        /** Communication client. */
        private final CClient cc;

        /**
         * Client communication thread instantiation.
         * @param cc communication client
         */
        public ClientCommunicationsThread(CClient cc) {
            super("Communication Client Thread");
            this.cc = cc;
        }

        /**
         * Client communication thread life cycle.
         */
        @Override
        public void run() {
            Message msg;
            while((msg = cc.receiveMessage()) != null){
                switch(msg.getMessageCode()){
                    case MessageCodes.REG_LB_M:
                        loadBalancerUp(cc);
                        break;
                    case MessageCodes.REG_SERVER:
                        newServer(msg.getServerId(), cc);
                        break;
                    case MessageCodes.REQUEST:
                        newLBRequest(msg);
                        break;
                    case MessageCodes.ASSIGNMENT:
                        requestAssigned(msg.getRequestId(), msg.getServerId());
                        break;
                    case MessageCodes.CUR_ITER:
                        serverIterationsUpdate(msg.getRequestId(), msg.getIterations(), msg.getServerId());
                        break;
                    case MessageCodes.REPLY:
                    case MessageCodes.REJECTION:
                        newLBReply(msg);
                        break;
                    case MessageCodes.HEARTBEAT:
                        serverHeartbeat(msg.getServerId());
                        break;
                    case MessageCodes.REJECTION_NO_SERVERS:
                        requestRejectionByNoServers(msg.getRequestId());
                        break;
                    case MessageCodes.TEST_MESSAGE:
                        cc.closeConnection();
                        return;
                }
            }
        }        
    }
    
    /**
     * Thread for handling the heartbeat control of a server.
     */
    class ServerHeartbeatThread extends Thread{

        /** Server ID. */
        private final int serverId;

        /**
         * Server heartbeat thread instantiation.
         * @param serverId server id
         */
        public ServerHeartbeatThread(int serverId) {
            super("Monitoring heartbeat of server " + serverId + " thread");
            this.serverId = serverId;
        }
        
        /**
         * Server heartbeat thread life cycle.
         */
        @Override
        public void run() {
            while(!isEnd()){
                try {
                    Thread.sleep(heartbeatThreshold);
                    break;
                } catch (InterruptedException ex) {}
            }
            if(!isEnd())
                serverDown(serverId);
        }
    }
}

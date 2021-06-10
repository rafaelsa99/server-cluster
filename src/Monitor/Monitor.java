
package Monitor;

import Communication.CClient;
import Communication.CServer;
import Communication.Message;
import Communication.MessageCodes;
import java.net.Socket;
import java.util.HashMap;
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
    private final Map<Integer, Integer> serversCounters;
    /** Requests waiting to be assigned to a server. */
    private final Map<Integer, Message> waitingRequests;

    /**
     * Monitor instantiation.
     * @param port server socket port
     * @param hostname load balancer host name
     * @param lbPort load balancer port
     * @param heartbeatThreshold heartbeat threshold
     */
    public Monitor(int port, String hostname, int lbPort, int heartbeatThreshold) {
        super("Monitor");
        this.heartbeatThreshold = heartbeatThreshold;
        this.cServer = new CServer(port);
        initLBConnection(hostname, lbPort);
        this.servers = new HashMap<>();
        this.serversCounters = new HashMap<>();
        this.waitingRequests = new HashMap<>();
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
            cc = new CClient(socket);
            new ClientCommunicationsThread(cc).start();
        }
    }

    @Override
    public synchronized void serverHeartbeat(int serverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * New request received on Load Balancer.
     * Send the servers counters to the load balancer for the assignment decision.
     * @param request request message received
     */
    @Override
    public synchronized void newLBRequest(Message request) {
        //----------> UPDATE GUI
        waitingRequests.put(request.getRequestId(), request);
        Message msg = new Message(MessageCodes.SERVERS_COUNTERS, request.getRequestId(), serversCounters);
        cLB.sendMessage(msg);
    }

    /**
     * Reply message for a given request.
     * @param reply reply message
     */
    @Override
    public synchronized void newLBReply(Message reply) {
        serversCounters.replace(reply.getServerId(), serversCounters.get(reply.getServerId()) + 1);
        servers.get(reply.getServerId()).removeRequest(reply.getRequestId());
        //----------> UPDATE GUI
    }

    /**
     * Update the current iteration of a request being processed by a server.
     * @param serverId server id
     * @param requestId request id
     * @param currentIter current iteration
     */
    @Override
    public synchronized void serverIterationsUpdate(int serverId, int requestId, int currentIter) {
        //----------> UPDATE GUI
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
        serversCounters.replace(serverId, serversCounters.get(serverId) + 1);
        //----------> UPDATE GUI
    }

    /**
     * Register a new server connected to the monitor.
     * @param serverId server id
     * @param cc communication client
     */
    @Override
    public synchronized void newServer(int serverId, CClient cc) {
        servers.put(serverId, new ServerInfo(serverId, cc));
        serversCounters.put(serverId, 0);
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
                        serverIterationsUpdate(msg.getServerId(), msg.getRequestId(), msg.getIterations());
                        break;
                    case MessageCodes.REPLY:
                    case MessageCodes.REJECTION:
                        newLBReply(msg);
                        break;
                    case MessageCodes.TEST_MESSAGE:
                        cc.closeConnection();
                        return;
                }
            }
        }        
    }
}

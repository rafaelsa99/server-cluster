
package LoadBalancer;

import Communication.CClient;
import Communication.CServer;
import Communication.Message;
import Communication.MessageCodes;
import Monitor.ServerCounter;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Load balancer server to receive and process messages.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class LoadBalancer extends Thread implements I_LoadBalancer{
    
    /** Communication Server. Basic server functions. */
    private final CServer cServer;
    /** Communication channel to the monitor. */
    private CClient cMonitor;
    /** Communication channels to the servers. */
    private final Map<Integer, CClient> cServers;
    /** Communication channels to the clients. */
    private final Map<Integer, CClient> cClients;
    /** Requests waiting to be assigned to a server. */
    private final Map<Integer, Message> waitingRequests;
    /** Load Balancer GUI. */
    private final LoadBalancer_GUI lbGUI;
    
    /**
     * Load Balancer Server instantiation.
     * @param port server socket port
     * @param mHN monitor host name
     * @param mPort monitor port
     * @param lbGUI reference to the Load Balancer GUI
     */
    public LoadBalancer(int port, String mHN, int mPort, LoadBalancer_GUI lbGUI) {
        super("Load Balancer");
        this.cServer = new CServer(port);
        this.cServers = new HashMap<>();
        this.cClients = new HashMap<>();
        this.waitingRequests = new HashMap<>();
        this.lbGUI = lbGUI;
        initMonitorConnection(mHN, mPort);
    }

    /**
     * Check if monitor is up, and if so, establish the connection.
     * @param hostname monitor host name
     * @param mPort monitor port
     */
    private void initMonitorConnection(String hostname, int mPort){
        if(CClient.testConnection(hostname, mPort)){
            cMonitor = new CClient(hostname, mPort);
            cMonitor.connectToServer();
            Message msg = new Message(MessageCodes.REG_LB_M);
            cMonitor.sendMessage(msg);
            new ClientCommunicationsThread(cMonitor).start();
        }
    }
    
    /**
     * Close all sockets connected to the load balancer.
     */
    public void closeSockets(){
        cClients.values().forEach(c -> {
            c.closeConnection();
        });
        cServers.values().forEach(c -> {
            c.closeConnection();
        });
        if(cMonitor != null)
            cMonitor.closeConnection();
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
     * New request received from a client.
     * Send the request to the Monitor.
     * @param request request message received
     */
    @Override
    public synchronized void newRequest(Message request) {
        waitingRequests.put(request.getRequestId(), request);
        cMonitor.sendMessage(request);
        lbGUI.addElemToRequestTable(request);
    }

    /**
     * Reply message for a given request.
     * Notify the monitor and send the reply message to the client.
     * @param reply reply message
     */
    @Override
    public synchronized void requestReply(Message reply) {
        cMonitor.sendMessage(reply);
        cClients.get(reply.getClientId()).sendMessage(reply);
        lbGUI.removeRequestFromTable(reply);
    }

    /**
     * Information that a server is down.
     * Distribute the request again, one by one.
     * @param serverId server id that is down
     * @param messages requests that the server down was processing
     */
    @Override
    public synchronized void serverDown(int serverId, List<Message> messages) {
        cServers.remove(serverId);
        messages.forEach(msg -> {
            lbGUI.removeRequestFromTable(msg);
            newRequest(msg);
        });
    }

    /**
     * Receive the counters of requests of the servers and assign a server to the request.
     * After assigning a server to the request, sends that information to the monitor.
     * @param requestId request id to assign to a server
     * @param serversCounters servers counters
     */
    @Override
    public synchronized void serversInfo(int requestId, List<ServerCounter> serversCounters) {
        int serverToAssign = getFreestServer(serversCounters);
        Message msg = waitingRequests.remove(requestId);
        if(serverToAssign == -1){
            msg.setMessageCode(MessageCodes.REJECTION_NO_SERVERS);
            cMonitor.sendMessage(msg);
            msg.setMessageCode(MessageCodes.REJECTION);
            cClients.get(msg.getClientId()).sendMessage(msg);
            lbGUI.removeRequestFromTable(msg);
        } else{
            Message msgToMonitor = new Message(serverToAssign, MessageCodes.ASSIGNMENT, requestId);
            cMonitor.sendMessage(msgToMonitor);
            cServers.get(serverToAssign).sendMessage(msg);
            lbGUI.setRequestServer(msgToMonitor);
        }
    }

    /**
     * Register a new client connected to the load balancer.
     * @param clientId client id
     * @param cc communication client
     */
    @Override
    public synchronized void newClient(int clientId, CClient cc) {
        cClients.put(clientId, cc);
    }

    /**
     * Register a new server connected to the load balancer.
     * @param serverId server id
     * @param cc communication client
     */
    @Override
    public synchronized void newServer(int serverId, CClient cc) {
        cServers.put(serverId, cc);
    }
    
    /**
     * Register the monitor.
     * @param cc communication client to the monitor
     */
    @Override
    public synchronized void monitorUp(CClient cc) {
        cMonitor = cc;
    }

    /**
     * Get the server handling less requests.
     * @param serversCounters servers requests counters
     * @return server id, or -1, if there is no server
     */
    private int getFreestServer(List<ServerCounter> serversCounters){
        int serverId = -1, minCounter = Integer.MAX_VALUE;
        boolean isFirst = true;
        for (ServerCounter serverCounter : serversCounters) {
            if(isFirst){
                isFirst = false;
                minCounter = serverCounter.getCounter();
                serverId = serverCounter.getServerId();
            } else if(serverCounter.getCounter()< minCounter){
                minCounter = serverCounter.getCounter();
                serverId = serverCounter.getServerId();
            }
        }
        return serverId;
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
                    case MessageCodes.REG_CLIENT:
                        newClient(msg.getClientId(), cc);
                        break;
                    case MessageCodes.REG_SERVER:
                        newServer(msg.getServerId(), cc);
                        break;
                    case MessageCodes.REG_LB_M:
                        monitorUp(cc);
                        break;
                    case MessageCodes.REQUEST:
                        newRequest(msg);
                        break;
                    case MessageCodes.SERVERS_COUNTERS:
                        serversInfo(msg.getRequestId(), msg.getServerCounters());
                        break;
                    case MessageCodes.REPLY:
                    case MessageCodes.REJECTION:
                        requestReply(msg);
                        break;
                    case MessageCodes.SERVER_DOWN:
                        serverDown(msg.getServerId(), msg.getServerRequests());
                        break;
                    case MessageCodes.TEST_MESSAGE:
                        cc.closeConnection();
                        return;
                }
            }
        }        
    }
}

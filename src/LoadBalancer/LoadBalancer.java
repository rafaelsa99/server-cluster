
package LoadBalancer;

import Communication.CClient;
import Communication.CServer;
import Communication.Message;
import Communication.MessageCodes;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

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
    private final HashMap<Integer, CClient> cServers;
    /** Communication channels to the clients. */
    private final HashMap<Integer, CClient> cClients;
    
    /**
     * Load Balancer Server instantiation.
     * @param port server socket port
     * @param mHN monitor host name
     * @param mPort monitor port
     */
    public LoadBalancer(int port, String mHN, int mPort) {
        super("Load Balancer");
        this.cServer = new CServer(port);
        this.cServers = new HashMap<>();
        this.cClients = new HashMap<>();
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
            cc = new CClient(socket);
            new ClientCommunicationsThread(cc).start();
        }
    }

    /**
     * New request received from a client.
     * @param request request message received
     */
    @Override
    public synchronized void newRequest(Message request) {
        //Envia mensagem ao monitor
        //Aguarda receber informação sobre o estado de todos os servidores
        int serverId = 1; //GetFreeServer()
        cServers.get(serverId).sendMessage(request);
    }

    @Override
    public synchronized void requestReply(Message reply) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void serverDown(int serverId, List<Message> messages) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void serversInfo(HashMap<Integer, Integer> serversOccupation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the server handling less requests.
     * @return server id
     */
    private int getFreeServer(){
        return 0;
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
                        cClients.put(msg.getClientId(), cc);
                        break;
                    case MessageCodes.REG_SERVER:
                        cServers.put(msg.getServerId(), cc);
                        break;
                    case MessageCodes.REG_LB_M:
                        cMonitor = cc;
                        break;
                    case MessageCodes.REQUEST:
                        newRequest(msg);
                        break;
                    case MessageCodes.TEST_MESSAGE:
                        cc.closeConnection();
                        return;
                }
            }
        }        
    }
}

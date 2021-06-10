
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

    public Monitor(int port, String hostname, int lbPort, int heartbeatThreshold) {
        super("Monitor");
        this.heartbeatThreshold = heartbeatThreshold;
        this.cServer = new CServer(port);
        initLBConnection(hostname, lbPort);
        this.servers = new HashMap<>();
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
    public void serverHeartbeat(int serverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newLBRequest(Message request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newLBReply(Message reply) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serverIterationsUpdate(int serverId, int requestId, int currentIter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                        cLB = cc;
                        break;
                    case MessageCodes.REG_SERVER:
                        servers.put(msg.getServerId(), new ServerInfo(msg.getServerId(), cc));
                        break;
                    case MessageCodes.REQUEST:
                        //newRequest(msg);
                        break;
                    case MessageCodes.TEST_MESSAGE:
                        cc.closeConnection();
                        return;
                }
            }
        }        
    }
}

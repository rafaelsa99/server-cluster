
package LoadBalancer;

import Communication.CClient;
import Communication.CServer;
import Communication.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

/**
 * Load balancer server to receive and process the messages.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class LoadBalancer extends Thread implements I_LoadBalancer{
    
    /**
     * Communication Server. Basic server functions.
     */
    private final CServer cServer;
    /**
     * Communication channel to the monitor.
     */
    private CClient cMonitor;
    /**
     * Communication channels to the servers.
     */
    private final HashMap<Integer, CClient> cServers;
    
    /**
     * Load Balancer Server instantiation.
     * @param port server socket port
     */
    public LoadBalancer(int port) {
        this.cServer = new CServer(port);
        this.cServers = new HashMap<>();
    }

    /**
     * Establish a connection to the monitor.
     * @param hostname host name of the monitor
     * @param port port of the monitor
     */
    public void connectToMonitor(String hostname, int port){
        this.cMonitor = new CClient(hostname, port);
        this.cMonitor.connectToServer();
    }
    
    /**
     * Life cycle of the server.
     * Await new clients while server socket is open.
     */
    @Override
    public void run() {
        Socket socket;
        cServer.openServer();
        while((socket = cServer.awaitClient()) != null)
            new ProcessingThread(socket).start();
    }

    @Override
    public void newRequest(Message request) {
        //CClient cClient = new CClient(hostnameServer, portServer);
        //Message reply = cClient.sendMessageAndWaitForReply(request);
        //return reply;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requestReply(Message reply) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serverDown(int serverId, List<Message> messages) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newServer(int serverId, String hostname, int port) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void monitorUp(String hostname, int port) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serversInfo(HashMap<Integer, Integer> serversOccupation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Thread for processing a given message and send the reply message.
     */
    class ProcessingThread extends Thread{
        
        /**
         * Socket connected to the client.
         */
        private final Socket socket;

        /**
         * Processing thread instantiation.
         * @param socket socket connected to the client
         */
        public ProcessingThread(Socket socket) {
            this.socket = socket;
        }

        /**
         * Processing thread life cycle.
         */
        @Override
        public void run() {
            try (
                    ObjectInputStream in = new ObjectInputStream (socket.getInputStream ());
                    ObjectOutputStream out = new ObjectOutputStream (socket.getOutputStream ());
                ) {
                    Message input = (Message) in.readObject();
                    // Check message code and execute corresponding function for processing
                    switch(input.getMessageCode()){ 
                        //...
                    }
                    // Reply message
                    //out.writeObject(new Message(...)); 
                    out.close();
                    in.close();
                    socket.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.toString());
                }
        }        
    }
}

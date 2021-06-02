
package LoadBalancer;

import Communication.CServer;
import Communication.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
     * Host name of the Monitor.
     */
    private String hostnameM;
    /**
     * Port of the Monitor.
     */
    private int portM;
    
    /**
     * Load Balancer Server instantiation without monitor information.
     * @param port server socket port
     */
    public LoadBalancer(int port) {
        this.cServer = new CServer(port);
    }

    /**
     * Load Balancer Server instantiation with monitor information.
     * @param port server socket port
     * @param hostnameM monitor host name
     * @param portM monitor port
     */
    public LoadBalancer(int port, String hostnameM, int portM) {
        this.cServer = new CServer(port);
        this.hostnameM = hostnameM;
        this.portM = portM;
    }
    
    /**
     * Life cycle of the server.
     * Await new clients while server socket is open.
     */
    @Override
    public void run() {
        Socket socket;
        cServer.openServer();
        while((socket = cServer.awaitMessage()) != null)
            new ProcessingThread(socket).start();
    }

    @Override
    public void newRequest(Message request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serverDown(Message message) {
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


package Communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Communication client.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class CClient {
    /** Host name of the server. */
    private final String hostName;
    /** Port of the server. */
    private final int portNumber;
    /** Socket connected to the server. */
    private Socket socket;
    /** Output stream of the communication channel. */
    private ObjectOutputStream out;
    /** Input stream of the communication channel. */
    private ObjectInputStream in;
    
    /**
     * CClient instantiation.
     * @param hostName Host name of the server
     * @param portNumber Port of the server
     */
    public CClient(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }
    
    /**
     * Connect to the server and initialize the communication channels.
     */
    public void connectToServer() {
        try {
            socket = new Socket(hostName, portNumber);
            out = new ObjectOutputStream (socket.getOutputStream ());
            in = new ObjectInputStream (socket.getInputStream ());
        } catch(IOException e){
            System.out.println("Couldn't get I/O for the connection to " + hostName);
        }
    }
    
    /**
     * Close the connection to the server.
     */
    public void closeConnection(){
        if(socket.isConnected()){
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    /**
     * Send message. 
     * Connection is established and the message is sent.
     * @param obj object to be sent
     * @return reply message received
     */
    public Message sendMessageAndWaitForReply(Object obj){
        Message reply = null;
        try{
            out.writeObject(obj);
            reply = (Message)in.readObject();
        } catch (IOException e) {
            System.out.println("Couldn't get I/O for the connection to " + hostName);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        return reply;
    }
}

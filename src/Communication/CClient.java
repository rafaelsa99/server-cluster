
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
    private String hostName;
    /** Port of the server. */
    private int portNumber;
    /** Socket connected to the server. */
    private Socket socket;
    /** Output stream of the communication channel. */
    private ObjectOutputStream out = null;
    /** Input stream of the communication channel. */
    private ObjectInputStream in = null;
    
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
     * CClient instantiation.
     * @param socket socket to client
     */
    public CClient(Socket socket){
        this.socket = socket;
    }
    
    /**
     * Connect to the server and initialize the communication channels.
     */
    public void connectToServer() {
        try {
            socket = new Socket(hostName, portNumber);
        } catch(IOException e){
            System.out.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
    
    /**
     * Test the connection to a server.
     * @param hn server host name
     * @param p server port
     * @return true, if connection was established, false otherwise
     */
    public static boolean testConnection(String hn, int p){
        try {
            Socket echo = new Socket(hn, p);
            echo.close();
        } catch(IOException e){
            return false;
        }
        return true;
    }
    
    /**
     * Close the connection to the server.
     */
    public void closeConnection(){
        if(socket.isConnected()){
            try {
                if(in != null)
                    in.close();
                if(out != null)
                    out.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean isConnected(){
        return socket.isConnected();
    }
    
    /**
     * Send a message. 
     * @param obj object to be sent
     */
    public void sendMessage(Object obj){
        try{
            if(out == null){
                System.out.println("output stream");
                out = new ObjectOutputStream (this.socket.getOutputStream ());
                System.out.println("criei output stream");
            }
            out.writeObject(obj);
        } catch (IOException e) {
            System.out.println("output: Couldn't get I/O for the connection to " + socket.getInetAddress().getHostName());
        }
        
    }
    
    /**
     * Receive a message.
     * @return message received
     */
    public Message receiveMessage(){
        Message reply = null;
        try{
            if(in == null){
                System.out.println("input stream");
                in = new ObjectInputStream (this.socket.getInputStream ());
                System.out.println("criei input stream");
            }
            reply = (Message)in.readObject();
        } catch (IOException e) {
            System.out.println("input: Couldn't get I/O for the connection to " + socket.getInetAddress().getHostName());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        return reply;
    }
}

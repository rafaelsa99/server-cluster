
package Communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Communication Server.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class CServer{

    /** Port of the server. */
    private final int portNumber;
    /** Server socket. */
    private ServerSocket serverSocket;
    
    /**
     * Communication server instantiation.
     * @param portNumber Port of the server
     */
    public CServer(int portNumber) {
        this.portNumber = portNumber;
    }
    
    /**
     * Creates the server socket.
     */
    public void openServer() {
        try {
            this.serverSocket = new ServerSocket(this.portNumber);
        } catch(IOException e){
            System.out.println(e);
            System.exit(1);
        }
    }
    
    /**
     * Await new client.
     * @return socket return from the client accept
     */
    public Socket awaitClient(){
        Socket socket = null;
        try { 
            socket = serverSocket.accept();
	} catch (IOException e) {}
        return socket;
    }
    
    /**
     * Close the server socket.
     */
    public void closeServer() {
        try {
            this.serverSocket.close();
        } catch(IOException e){System.out.println(e);}
    }  
}    

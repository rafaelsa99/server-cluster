
package Monitor;

import Communication.CClient;
import Communication.Message;
import java.util.HashMap;
import java.util.Map;

/**
 * Server information.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class ServerInfo {
    /** Server ID. */
    private final int serverId;
    /** Communication Client to the server. */
    private final CClient cClient;
    /** List of messages being processed by the server. */
    private final Map<Integer, Message> requests;
    /** Server state. */
    private boolean isActive;
    
    /**
     * Server info instantiation.
     * @param serverId server ID
     * @param cClient communication client with the server
     */
    public ServerInfo(int serverId, CClient cClient) {
        this.serverId = serverId;
        this.cClient = cClient;
        this.requests = new HashMap<>();
        this.isActive = true;
    }
    
    /**
     * Add a new request being processed by the server.
     * @param request request message
     */
    public void addRequest(Message request){
        requests.put(request.getRequestId(), request);
    }
    
    /**
     * Remove a request that was being processed by the server.
     * @param requestId request id
     */
    public void removeRequest(int requestId){
        requests.remove(requestId);
    }
    
    /**
     * Set the server state
     * @param state true, if server is active, false otherwise
     */
    public void setState(boolean state){
        this.isActive = state;
    }
    
    /**
     * Close the communication channel.
     */
    public void closeConnection(){
        cClient.closeConnection();
    }
}

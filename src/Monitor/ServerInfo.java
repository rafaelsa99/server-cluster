
package Monitor;

import Communication.CClient;
import Communication.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Server information.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class ServerInfo {
    /** Communication Client to the server. */
    private final CClient cClient;
    /** List of messages being processed by the server. */
    private final Map<Integer, Message> requests;
    /** Current iteration of requests. */
    private final Map<Integer, String> currentState;
    
    /**
     * Server info instantiation.
     * @param cClient communication client with the server
     */
    public ServerInfo(CClient cClient) {
        this.cClient = cClient;
        this.requests = new HashMap<>();
        this.currentState = new HashMap<>();
    }
    
    /**
     * Add a new request being processed by the server.
     * @param request request message
     */
    public void addRequest(Message request){
        requests.put(request.getRequestId(), request);
        currentState.put(request.getRequestId(), "In Queue");
    }
    
    /**
     * Remove a request that was being processed by the server.
     * @param requestId request id
     */
    public void removeRequest(int requestId){
        requests.remove(requestId);
        currentState.remove(requestId);
    }
    
    /**
     * Set request current state.
     * @param requestId request id
     * @param cs current state
     */
    public void setCurrentState(int requestId, String cs){
        this.currentState.replace(requestId, cs);
    }
    
    /**
     * Close the communication channel.
     */
    public void closeConnection(){
        cClient.closeConnection();
    }
    
    /**
     * Get the requests of the server.
     * @return list of requests
     */
    public List<Message> getRequests(){
        return new ArrayList<>(requests.values());
    }
    
    /**
     * Get requests current states.
     * @return requests current states
     */
    public Map<Integer, String> getCurrentState(){
        return currentState;
    }
}


package LoadBalancer;

import Communication.CClient;
import Communication.Message;
import Monitor.ServerCounter;
import java.util.List;
import java.util.Map;

/**
 * Interface for the load balancer functions.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
interface I_LoadBalancer {
    /**
     * Register a new client connected to the load balancer.
     * @param clientId client id
     * @param cc communication client
     */
    public void newClient(int clientId, CClient cc);
    /**
     * Register a new server connected to the load balancer.
     * @param serverId server id
     * @param cc communication client
     */
    public void newServer(int serverId, CClient cc);
    /**
     * Register the monitor.
     * @param cc communication client to the monitor
     */
    public void monitorUp(CClient cc);
    /**
     * New request received from a client.
     * Send the request to the Monitor.
     * @param request request message received
     */
    public void newRequest(Message request);
    /**
     * Reply message for a given request.
     * Notify the monitor and send the reply message to the client.
     * @param reply reply message
     */
    public void requestReply(Message reply);
    public void serverDown(int serverId, List<Message> messages);
    /**
     * Receive the counters of requests of the servers and assign a server to the request.
     * After assigning a server to the request, sends that information to the monitor.
     * @param requestId request id to assign to a server
     * @param serversCounters servers counters
     */
     public void serversInfo(int requestId, List<ServerCounter> serversCounters);
}

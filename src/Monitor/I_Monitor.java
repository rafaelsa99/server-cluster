
package Monitor;

import Communication.CClient;
import Communication.Message;

/**
 * Interface for the monitor functions.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public interface I_Monitor {
    /**
     * Register a new server connected to the monitor.
     * @param serverId server id
     * @param cc communication client
     */
    public void newServer(int serverId, CClient cc);
    /**
     * Register the load balancer.
     * @param cc communication client to the load balancer
     */
    public void loadBalancerUp(CClient cc);
    public void serverHeartbeat(int serverId);
    /**
     * New request received on Load Balancer.
     * Send the servers counters to the load balancer for the assignment decision.
     * @param request request message received
     */
    public void newLBRequest(Message request);
    /**
     * Reply message for a given request.
     * @param reply reply message
     */
    public void newLBReply(Message reply);
    /**
     * Request assigned to a server. 
     * @param requestId request id
     * @param serverId server id
     */
    public void requestAssigned(int requestId, int serverId);
    /**
     * Update the current iteration of a request being processed by a server.
     * @param requestId request id
     * @param currentIter current iteration
     * @param serverId server id
     */
    public void serverIterationsUpdate(int requestId, int currentIter, int serverId);
}

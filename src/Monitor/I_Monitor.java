
package Monitor;

import Communication.Message;

/**
 *
 * @author luisc
 */
public interface I_Monitor {
    public void serverHeartbeat(int serverId);
    public void newLBRequest(Message request);
    public void newLBReply(Message reply);
    public void serverIterationsUpdate(int serverId, int requestId, int currentIter);
}

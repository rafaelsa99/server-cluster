
package LoadBalancer;

import Communication.CClient;
import Communication.Message;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
interface I_LoadBalancer {
    
   public void newRequest(Message request);
   public void requestReply(Message reply);
   public void serverDown(int serverId, List<Message> messages);
   public void newConnection(CClient cc, Message msg);
   public void serversInfo(HashMap<Integer, Integer> serversOccupation);
}


package LoadBalancer;

import Communication.Message;

/**
 *
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
interface I_LoadBalancer {
    
   public void newRequest(Message request);
   
   public void serverDown(Message message);
}

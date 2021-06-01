/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadBalancer;

import Communication.Message;

/**
 *
 * @author luisc
 */
interface I_LoadBalancer {
    
   public void requestDispatcher(Message request);
   
   public void responseDispatcher(Message response);
   
   public void processMessage();
}

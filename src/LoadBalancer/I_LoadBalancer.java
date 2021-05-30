/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadBalancer;

import Request.Request;
import Response.Response;

/**
 *
 * @author luisc
 */
interface I_LoadBalancer {
    
   public void requestDispatcher(Request request);
   
   public void responseDispatcher(Response response);
   
   public void processMessage();
}

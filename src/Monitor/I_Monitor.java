/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitor;

/**
 *
 * @author luisc
 */
public interface I_Monitor {
       
    public void serverStateDown(Integer serverId);
    
    public void serverStateUp(Integer serverId);
    
    public void processMessage();
    
    public void viewServersState();
      
    
}

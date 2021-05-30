/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitor;

import Server.Server;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author luisc
 */

public class Monitor implements I_Monitor{
    
    private int serverSocket;
    private String hostnameLB;
    private int portLB;
    private int heartbeatThreshold;
    
    private HashMap<Integer, Server> serverRequests;
    
    private ArrayList<Integer> activeServers;

    public HashMap<Integer, Server> getServerRequests() {
        return serverRequests;
    }

    public ArrayList<Integer> getActiveServers() {
        return activeServers;
    }
   
    @Override
    public void serverStateDown(Integer serverId) {
        activeServers.remove(serverId);
    }

    @Override
    public void serverStateUp(Integer serverId) {
        activeServers.add(serverId);
    }

    @Override
    public void processMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkFreeServer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

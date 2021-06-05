/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitor;

import Communication.Message;
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
    public void loadBalancerUp(String hostname, int port) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serverHeartbeat(int serverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newLBRequest(Message request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newLBReply(Message reply) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serverIterationsUpdate(int serverId, int requestId, int currentIter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

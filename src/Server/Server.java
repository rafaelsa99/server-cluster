/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.ArrayList;

/**
 *
 * @author luisc
 */
public class Server {
    
    private int id;
    
    private int port;
    
    private String host;
    
    private int queueSize;
    
    private int maxRequests;
    
    private String hostLB;
    
    private int portLB;
    
    private String hostM;
    
    private int portM;
    
    private int heartbeatTimeout;
    
    private ArrayList<String> requests;

    public Server(int id, int port, String host, int queueSize, int maxRequests, String hostLB, int portLB, String hostM, int portM, int heartbeatTimeout) {
        this.id = id;
        this.port = port;
        this.host = host;
        this.queueSize = queueSize;
        this.maxRequests = maxRequests;
        this.hostLB = hostLB;
        this.portLB = portLB;
        this.hostM = hostM;
        this.portM = portM;
        this.heartbeatTimeout = heartbeatTimeout;
    }

    public int getId() {
        return id;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public int getHeartbeatTimeout() {
        return heartbeatTimeout;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

        
}

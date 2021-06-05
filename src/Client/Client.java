/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author luisc
 */
public class Client {
    
    private int id;
    
    private int port;
    
    private String host;
    
    private String lbHost;
    
    private int lbPort;

    public Client(int id, int port, String host) {
        this.id = id;
        this.port = port;
        this.host = host;
    }

    public Client(int id, String lbHost, int lbPort) {
        this.id = id;
        this.lbHost = lbHost;
        this.lbPort = lbPort;
    }
    
    
    public int getId() {
        return id;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getLbHost() {
        return lbHost;
    }

    public int getLbPort() {
        return lbPort;
    }
    
}

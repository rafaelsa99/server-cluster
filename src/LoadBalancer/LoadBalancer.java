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
public class LoadBalancer implements I_LoadBalancer{
    
    private int serverSocket;
    private String hostM;
    private int portM;

    public LoadBalancer(int serverSocket, String hostM, int portM) {
        this.serverSocket = serverSocket;
        this.hostM = hostM;
        this.portM = portM;
    }

    public int getServerSocket() {
        return serverSocket;
    }

    public String getHostM() {
        return hostM;
    }

    public int getPortM() {
        return portM;
    }
    
        
    @Override
    public void requestDispatcher(Message request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void responseDispatcher(Message response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

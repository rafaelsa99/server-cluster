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
public class Request {
    
    private int id;
    
    private int nIterations;
    
    private String reply;

    public Request(int id, int nIterations) {
        this.id = id;
        this.nIterations = nIterations;
    }

    public int getId() {
        return id;
    }

    public int getnIterations() {
        return nIterations;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
    
    
}

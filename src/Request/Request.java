/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Request;

import Client.Client;

/**
 *
 * @author luisc
 */
public class Request {
    
    private Client client;
    
    private int IterationsNumber;

    public Request(Client client, int IterationsNumber) {
        this.client = client;
        this.IterationsNumber = IterationsNumber;
    }

    public Client getClient() {
        return client;
    }

    public int getIterationsNumber() {
        return IterationsNumber;
    }    
    
}

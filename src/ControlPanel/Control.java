/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPanel;

import Client.Client;
import Server.Server;
import java.util.HashMap;

/**
 *
 * @author luisc
 */
public class Control {
    
    //Isto pode ser alterado para guardar o index num ArrayList
    private HashMap<Integer, Server> serverList;
    private HashMap<Integer, Client> clientList;

    public HashMap<Integer, Server> getServerList() {
        return serverList;
    }

    public HashMap<Integer, Client> getClientList() {
        return clientList;
    }

    public void shutdownClient(int clientID){
        clientList.remove(clientID);
    }
    
    public void shutdownServer(int serverID){
        serverList.remove(serverID);
    }
    
    //Inicializar na GUI //falta
    public void startClient(Client client){
        clientList.put(client.getId(), client);
    }
    
    public void startServer(Server server){
         serverList.put(server.getId(), server);
    }
    
}

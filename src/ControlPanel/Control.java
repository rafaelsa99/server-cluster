
package ControlPanel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class to handle the processes and the creation of new ones.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Control {
    /** List of server processes. */
    private final HashMap<Integer, Process> pServerList;
    /** List of client processes. */
    private final HashMap<Integer, Process> pClientList;
    /** Load Balancer process. */
    private Process pLoadBalancer;
    /** Monitor process. */
    private Process pMonitor;
    /** Client counter for the ID. */
    private static int CLIENT_COUNTER;
    /** Server counter for the ID. */
    private static int SERVER_COUNTER;

    /**
     * Control Instantiation.
     */
    public Control() {
        CLIENT_COUNTER = 0;
        SERVER_COUNTER = 0;
        pLoadBalancer = null;
        pMonitor = null;
        pServerList = new HashMap<>();
        pClientList = new HashMap<>();
    }

    /**
     * Function to shutdown the process a given client.
     * @param clientId client ID to kill
     */
    public void shutdownClient(int clientId){
        if(pClientList.get(clientId).isAlive()){
            pClientList.get(clientId).destroy();
        }
        pClientList.remove(clientId);
    }
    
    /**
     * Function to shutdown the process a given server.
     * @param serverId server ID to kill
     */
    public void shutdownServer(int serverId){
        if(pServerList.get(serverId).isAlive()){
            pServerList.get(serverId).destroy();
        }
        pServerList.remove(serverId);
    }
    
    /**
     * Function to start a new client process.
     * @return new client ID
     */
    public int startClient(){
        List<String> args = new ArrayList<>();
        args.add(String.valueOf(++CLIENT_COUNTER));
        ProcessBuilder pbC = getProcessBuilder(Configurations.ClientConfiguration.class, args);
        try {
            pClientList.put(CLIENT_COUNTER, pbC.start());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return CLIENT_COUNTER;
    }
    
    /**
     * Function to start a new server process.
     * @return new server ID
     */
    public int startServer(){
        List<String> args = new ArrayList<>();
        args.add(String.valueOf(++SERVER_COUNTER));
        ProcessBuilder pbS = getProcessBuilder(Configurations.ServerConfiguration.class, args);
        try {
            pServerList.put(SERVER_COUNTER, pbS.start());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return SERVER_COUNTER;
    }
    
    /**
     * Function to start a new load balancer process.
     */
    public void startLoadBalancer(){
        ProcessBuilder pbLB = getProcessBuilder(Configurations.LBConfiguration.class, new ArrayList<>());
        try {
            pLoadBalancer = pbLB.start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Function to shutdown the load balancer process.
     */
    public void endLoadBalancer(){
        if(pLoadBalancer.isAlive()){
            pLoadBalancer.destroy();
        }
    }
    
    /**
     * Function to start a new monitor process.
     */
    public void startMonitor(){
        ProcessBuilder pbM = getProcessBuilder(Configurations.MonitorConfiguration.class, new ArrayList<>());
        try {
            pMonitor = pbM.start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Function to shutdown the monitor process.
     */
    public void endMonitor(){
        if(pMonitor.isAlive()){
            pMonitor.destroy();
        }
    }
    
    /**
     * Function to create a new process.
     * @param cls main class for the process
     * @param args list of program arguments
     * @return process created
     */
    private ProcessBuilder getProcessBuilder(Class cls, List<String> args) {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = cls.getName();

        List<String> command = new ArrayList<>();
        command.add(javaBin);
        command.add("-cp");
        command.add(classpath);
        command.add(className);
        command.addAll(args);
        return new ProcessBuilder(command);
    }
}

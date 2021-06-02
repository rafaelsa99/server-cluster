
package ControlPanel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Control {
    
    private final HashMap<Integer, Process> pServerList;
    private final HashMap<Integer, Process> pClientList;
    private Process pLoadBalancer;
    private Process pMonitor;
    private static int CLIENT_COUNTER;
    private static int SERVER_COUNTER;

    public Control() {
        CLIENT_COUNTER = 0;
        SERVER_COUNTER = 0;
        pLoadBalancer = null;
        pMonitor = null;
        pServerList = new HashMap<>();
        pClientList = new HashMap<>();
    }

    public void shutdownClient(int clientId){
        if(pClientList.get(clientId).isAlive()){
            pClientList.get(clientId).destroy();
        }
        pClientList.remove(clientId);
    }
    
    public void shutdownServer(int serverId){
        if(pServerList.get(serverId).isAlive()){
            pServerList.get(serverId).destroy();
        }
        pServerList.remove(serverId);
    }
    
    public int startClient(){
        ProcessBuilder pbC = getProcessBuilder(Configurations.ClientConfiguration.class, new ArrayList<>(++CLIENT_COUNTER));
        try {
            pClientList.put(CLIENT_COUNTER, pbC.start());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return CLIENT_COUNTER;
    }
    
    public int startServer(){
        ProcessBuilder pbS = getProcessBuilder(Configurations.ServerConfiguration.class, new ArrayList<>(++SERVER_COUNTER));
        try {
            pServerList.put(SERVER_COUNTER, pbS.start());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return SERVER_COUNTER;
    }
    
    public void startLoadBalancer(){
        ProcessBuilder pbLB = getProcessBuilder(Configurations.LBConfiguration.class, new ArrayList<>());
        try {
            pLoadBalancer = pbLB.start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void endLoadBalancer(){
        if(pLoadBalancer.isAlive()){
            pLoadBalancer.destroy();
        }
    }
    
    public void startMonitor(){
        ProcessBuilder pbM = getProcessBuilder(Configurations.MonitorConfiguration.class, new ArrayList<>());
        try {
            pMonitor = pbM.start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void endMonitor(){
        if(pMonitor.isAlive()){
            pMonitor.destroy();
        }
    }
    
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

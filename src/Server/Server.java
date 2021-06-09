
package Server;

import Communication.CClient;

/**
 * Server to handle the requests.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Server extends Thread{
    
    /** Communication Client to Load Balancer. */
    private final CClient cLB;
    /** Communication Client to Monitor. */
    private final CClient cMonitor;
    /** Client GUI. */
    private final Server_GUI serverGUI;
    /** Server ID. */
    private final int serverId;
    /** Iteration timeout. */
    private final int iterationTimeout;
    /** Queue size. */
    private final int queueSize;
    /** Maximum number of simultaneous requests. */
    private final int maxRequests;

    /**
     * Server thread instantiation.
     * @param cLB communication channel to load balancer
     * @param cMonitor communication channel to monitor
     * @param serverGUI reference to the GUI
     * @param serverId server id
     * @param iterationTimeout iteration timeout, in milliseconds
     * @param queueSize queue size
     * @param maxRequests maximum number of simultaneous requests
     */
    public Server(CClient cLB, CClient cMonitor, Server_GUI serverGUI, int serverId, int iterationTimeout, int queueSize, int maxRequests) {
        super("Server " + serverId);
        this.cLB = cLB;
        this.cMonitor = cMonitor;
        this.serverGUI = serverGUI;
        this.serverId = serverId;
        this.iterationTimeout = iterationTimeout;
        this.queueSize = queueSize;
        this.maxRequests = maxRequests;
    }

    /**
     * Close the communication channels.
     */
    public void closeComChannels(){
        cLB.closeConnection();
        cMonitor.closeConnection();
    }

    /**
     * Server thread life cycle.
     */
    @Override
    public void run() {
        
    }
}

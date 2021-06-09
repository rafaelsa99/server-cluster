
package Server;

import Communication.CClient;
import Communication.Message;
import Communication.MessageCodes;

/**
 * Thread to send a periodic heartbeat to the monitor.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Heartbeat extends Thread{

    /** Communication client to the monitor. */
    private final CClient cMonitor;
    /** Heartbeat timeout. */
    private final int heartbeatTimeout;
    /** Server ID. */
    private final int serverId;

    /**
     * Heartbeat instantiation.
     * @param cMonitor reference to the communication client with the monitor
     * @param heartbeatTimeout heartbeat timeout, in milliseconds
     * @param serverId server id
     */
    public Heartbeat(CClient cMonitor, int heartbeatTimeout, int serverId) {
        super("Heartbeat Server " + serverId);
        this.cMonitor = cMonitor;
        this.heartbeatTimeout = heartbeatTimeout;
        this.serverId = serverId;
    }

    /**
     * Heartbeat thread life cycle.
     */
    @Override
    public void run() {
        Message heartbeatMessage = new Message(true, serverId, MessageCodes.HEARTBEAT);
        while(cMonitor.sendMessage(heartbeatMessage)){
            try {
                Thread.sleep(heartbeatTimeout);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}

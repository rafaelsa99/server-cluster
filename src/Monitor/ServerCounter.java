
package Monitor;

import java.io.Serializable;

/**
 * Serializable class for a server counter.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class ServerCounter implements Serializable{
    
    /** Server ID. */
    int serverId;
    /** Number of requests being processed by the server. */
    int counter;

    /**
     * Server Counter initialization.
     * @param serverId server id
     * @param counter number of requests being processed by the server
     */
    public ServerCounter(int serverId, int counter) {
        this.serverId = serverId;
        this.counter = counter;
    }
    
    /**
     * Get the server id.
     * @return server id
     */
    public int getServerId() {
        return serverId;
    }

    /**
     * Set the server id.
     * @param serverId server id.
     */
    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    /** 
     * Get server counter.
     * @return number of requests being processed by the server
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Set the server counter.
     * @param counter number of requests being processed by the server
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    /**
     * Increment counter.
     */
    public void incrementCounter(){
        counter++;
    }
    
    /**
     * Decrement counter.
     */
    public void decrementCounter(){
        counter--;
    }
}

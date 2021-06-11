
package Communication;

/**
 * Defines the several message codes.
 * @author Rafael Sá (104552), José Brás (74029)
 */
public class MessageCodes {
    
    /**
     * Request code for NA calculation.
     */
    public static final int REQUEST = 1;
    /**
     * Reply code for NA calculation.
     */
    public static final int REPLY = 2;
    /**
     * Reply code for request rejection.
     */
    public static final int REJECTION = 3;
    /**
     * Heartbeat code.
     */
    public static final int HEARTBEAT = 4;
    /**
     * Register new server code.
     */
    public static final int REG_SERVER = 5;
    /**
     * Code for the server update the current iteration on a request.
     */
    public static final int CUR_ITER = 6;
    /**
     * Server down code.
     */
    public static final int SERVER_DOWN = 7;
    /**
     * Load Balancer / Monitor register code.
     */
    public static final int REG_LB_M = 8;
    /**
     * Code for assigning a server to a request.
     */
    public static final int ASSIGNMENT = 9;
    /**
     * Code for a message to test the connection.
     */
    public static final int TEST_MESSAGE = 10;
    /**
     * Register new client code.
     */
    public static final int REG_CLIENT = 11;
    /**
     * Code for sending the counters of requests of the servers.
     */
    public static final int SERVERS_COUNTERS = 12;
    
    /**
     * It can not be instantiated.
     */
    public MessageCodes() {}
}

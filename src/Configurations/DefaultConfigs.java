
package Configurations;

/**
 * Define the Default Configurations.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class DefaultConfigs {
    /** Default Host name. */
    public static final String HOSTNAME = "localhost";
    /** Default Load Balancer Port. */
    public static final int LB_PORT = 5000;
    /** Default Monitor Port. */
    public static final int M_PORT = 5001;
    /** Default Heartbeat Threshold (in milliseconds). */
    public static final int HEARTBEAT_THRESHOLD = 30000;
    /** Default Heartbeat Timeout (in milliseconds). */
    public static final int HEARTBEAT_TIMEOUT = 10000;
    /** Default Iteration Timeout (in milliseconds). */
    public static final int ITERATION_TIMEOUT = 1000;
    /** Default Queue Size. */
    public static final int QUEUE_SIZE = 2;
    /** Default maximum number of simultaneous requests. */
    public static final int MAX_REQUESTS = 3;
    /** Default number of iterations. */
    public static final int NUMBER_ITERATIONS = 5;
    
    /**
     * It cannot be instantiated.
     */
    private DefaultConfigs(){}
}

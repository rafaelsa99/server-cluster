
package Communication;

import java.io.Serializable;

/**
 * Serializable class representing the message to be sent between the processes.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Message implements Serializable{
    
    /** Client ID. */
    private final int clientId;
    /** Request ID. */
    private final int requestId;
    /** Server ID. */
    private final int serverId;
    /** Message code. */
    private final int messageCode;
    /** Number of iterations. */
    private final int iterations;
    /** Value of NA, Avogadro Constant. */
    private final double valueNa;
    /** Host name. */
    private final String hostname;
    /** Port. */
    private final int port;

    /**
     * Constructor for the request message / current iteration on a request update.
     * @param isRequest true -> is a request message ; false -> is an iterations update
     * @param sharedArg client Id, if request message, OR server Id, if iterations update
     * @param requestId request id
     * @param messageCode message code
     * @param iterations number of iterations
     */
    public Message(boolean isRequest, int sharedArg, int requestId, int messageCode, int iterations) {
        if(isRequest){
            this.clientId = sharedArg;
            this.serverId = 0;
        } else {
            this.serverId = sharedArg;
            this.clientId = 0;
        }
        this.requestId = requestId;
        this.messageCode = messageCode;
        this.iterations = iterations;
        this.valueNa = 0;
        this.hostname = "";
        this.port = 0;
    }

    /**
     * Constructor for the reply with calculation value message.
     * @param clientId client id
     * @param requestId request id
     * @param serverId server id
     * @param messageCode message code
     * @param iterations number of iterations
     * @param valueNa NA calculation value
     */
    public Message(int clientId, int requestId, int serverId, int messageCode, int iterations, double valueNa) {
        this.clientId = clientId;
        this.requestId = requestId;
        this.serverId = serverId;
        this.messageCode = messageCode;
        this.iterations = iterations;
        this.valueNa = valueNa;
        this.hostname = "";
        this.port = 0;
    }

    /**
     * Constructor for the reply request rejection.
     * @param clientId client id
     * @param requestId request id
     * @param serverId server id
     * @param messageCode message code
     * @param iterations number of iterations
     */
    public Message(int clientId, int requestId, int serverId, int messageCode, int iterations) {
        this.clientId = clientId;
        this.requestId = requestId;
        this.serverId = serverId;
        this.messageCode = messageCode;
        this.iterations = iterations;
        this.valueNa = 0;
        this.hostname = "";
        this.port = 0;
    }

    /**
     * Constructor for the heartbeat message and server DOWN messages.
     * @param serverId server id
     * @param messageCode message code
     */
    public Message(int serverId, int messageCode) {
        this.serverId = serverId;
        this.messageCode = messageCode;
        this.clientId = 0;
        this.requestId = 0;
        this.iterations = 0;
        this.valueNa = 0;
        this.hostname = "";
        this.port = 0;
    }

    /**
     * Constructor to register a new server / assign request to server.
     * @param isAssignment false -> is to register a new server ; true -> is to assign a request to a server
     * @param serverId server id
     * @param messageCode message code
     * @param sharedArg port of the server, if register a new server, OR request id, if request assignment
     */
    public Message(boolean isAssignment, int serverId, int messageCode, int sharedArg) {
        this.serverId = serverId;
        this.messageCode = messageCode;
        if(isAssignment){
            this.port = 0;
            this.requestId = sharedArg;
        } else {
            this.port = sharedArg;
            this.requestId = 0;
        }
        this.clientId = 0;
        this.iterations = 0;
        this.valueNa = 0;
        this.hostname = "";
    }

    /**
     * Constructor for the .
     * @param serverId server id
     * @param requestId request id
     * @param messageCode message code
     * @param iterations current iteration
     */
    public Message(int serverId, int requestId, int messageCode, int iterations) {
        this.serverId = serverId;
        this.requestId = requestId;
        this.messageCode = messageCode;
        this.iterations = iterations;
        this.clientId = 0;
        this.valueNa = 0;
        this.hostname = "";
        this.port = 0;
    }

    /**
     * Constructor to register the information of the LB / M.
     * @param messageCode message code
     * @param hostname host name of the LB / M
     * @param port port of the LB / M
     */
    public Message(int messageCode, String hostname, int port) {
        this.messageCode = messageCode;
        this.hostname = hostname;
        this.port = port;
        this.clientId = 0;
        this.serverId = 0;
        this.requestId = 0;
        this.iterations = 0;
        this.valueNa = 0;
    }
    
    
    
    public int getClientId() {
        return clientId;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getServerId() {
        return serverId;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public int getIterations() {
        return iterations;
    }

    public double getValueNa() {
        return valueNa;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }
}

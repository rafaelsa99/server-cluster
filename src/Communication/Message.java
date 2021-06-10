
package Communication;

import java.io.Serializable;

/**
 * Serializable class representing the message to be sent between the processes.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Message implements Serializable{
    
    /** Client ID. */
    private  int clientId;
    /** Request ID. */
    private int requestId;
    /** Server ID. */
    private int serverId;
    /** Message code. */
    private int messageCode;
    /** Number of iterations. */
    private int iterations;
    /** Value of NA, Avogadro Constant. */
    private String valueNa;
    /** Host name. */
    private String hostname;
    /** Port. */
    private int port;

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
        this.valueNa = "0";
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
    public Message(int clientId, int requestId, int serverId, int messageCode, int iterations, String valueNa) {
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
        this.valueNa = "0";
        this.hostname = "";
        this.port = 0;
    }

    /**
     * Constructor for the heartbeat message, server DOWN, register server and register client messages.
     * @param isServer true, if is heartbeat message, server DOWN, register server, false if is register client message
     * @param sharedArg server id, if isServer, client id otherwise
     * @param messageCode message code
     */
    public Message(boolean isServer, int sharedArg, int messageCode) {
        if(isServer){
            this.serverId = sharedArg;
            this.clientId = 0;
        } else{
            this.serverId = 0;
            this.clientId = sharedArg;
        }
        this.messageCode = messageCode;
        this.requestId = 0;
        this.iterations = 0;
        this.valueNa = "0";
        this.hostname = "";
        this.port = 0;
    }

    /**
     * Constructor to assign a request to server.
     * @param serverId server id
     * @param messageCode message code
     * @param requestId request id
     */
    public Message(int serverId, int messageCode, int requestId) {
        this.serverId = serverId;
        this.messageCode = messageCode;
        this.port = 0;
        this.requestId = requestId;
        this.clientId = 0;
        this.iterations = 0;
        this.valueNa = "0";
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
        this.valueNa = "0";
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
        this.valueNa = "0";
    }

    /**
     * Constructor for a empty message.
     * @param messageCode message code
     */
    public Message(int messageCode) {
        this.messageCode = messageCode;
        this.hostname = "";
        this.port = 0;
        this.clientId = 0;
        this.serverId = 0;
        this.requestId = 0;
        this.iterations = 0;
        this.valueNa = "0";
    }
    
    /**
     * Get client id.
     * @return client id
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Get request id.
     * @return request id
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * Get server id.
     * @return server id
     */
    public int getServerId() {
        return serverId;
    }

    /**
     * Get message code.
     * @return message code
     */
    public int getMessageCode() {
        return messageCode;
    }

    /**
     * Get number of iterations.
     * @return iterations number
     */
    public int getIterations() {
        return iterations;
    }

    /**
     * Get Avogrado Number.
     * @return avogrado number
     */
    public String getValueNa() {
        return valueNa;
    }

    /**
     * Get host name.
     * @return host name
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Get port number.
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * Set client ID.
     * @param clientId client id
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Set request ID.
     * @param requestId request id
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    /**
     * Set server ID.
     * @param serverId serer id
     */
    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    /**
     * Set message code.
     * @param messageCode message code
     */
    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * Set number of iterations.
     * @param iterations iterations number
     */
    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    /**
     * Set Avogrado Number.
     * @param valueNa Avogrado Number
     */
    public void setValueNa(String valueNa) {
        this.valueNa = valueNa;
    }

    /**
     * Set host name.
     * @param hostname host name
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Set port number.
     * @param port port number
     */
    public void setPort(int port) {
        this.port = port;
    }
}

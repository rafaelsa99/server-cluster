
package Client;

/**
 * Request for NA Calculation.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Request {
    /** Request ID. */
    private final int id;
    /** Number of iterations. */
    private final int nIterations;
    /** Reply to the request. */
    private String reply;

    /**
     * Request Instantiation.
     * @param id request id
     * @param nIterations number of iterations 
     */
    public Request(int id, int nIterations) {
        this.id = id;
        this.nIterations = nIterations;
    }

    /**
     * Get the Request ID.
     * @return request id
     */
    public int getId() {
        return id;
    }
    /**
     * Get number of iterations.
     * @return number of iterations.
     */
    public int getnIterations() {
        return nIterations;
    }

    /**
     * Get reply to the request.
     * @return reply
     */
    public String getReply() {
        return reply;
    }

    /**
     * Set reply to the request.
     * @param reply reply to the request
     */
    public void setReply(String reply) {
        this.reply = reply;
    }
}

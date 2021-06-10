
package Common;

import Communication.Message;

/**
 * Interface for the FIFO.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public interface IFIFO {
    /**
     * Thread entry to FIFO. 
     * If there a request in the queue, don't wait.
     * If the queue is empty, wait for new request.
     * @return message with the request to process
     */
    public Message in();
    /**
     * Add a request to the queue and notify a thread.
     * @param request message with the new request
     * @return true if queue has space, false otherwise.
     */
    public boolean out(Message request);
}

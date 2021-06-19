
package Common;

/**
 * Interface for the FIFO.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public interface IFIFO {
    /**
     * Thread entry to FIFO.
     * @return true if not end, false otherwise.
     */
    public boolean in();
    /**
     * Notify a thread that is a request to process.
     */
    public void out();
    /**
     * Set end flag to true and remove all threads waiting on FIFO.
     */
    public void end();
}

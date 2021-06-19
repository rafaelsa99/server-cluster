
package Common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FIFO to handle the processing threads.
 * They enter the FIFO and wait for new requests.
 * 
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class FIFO implements IFIFO{

    /** Reentrant Lock for accessing the shared region. */
    private final ReentrantLock rl;
    /** Array for the waiting condition (one for processing thread). */
    private final Condition cStay[];
    /** Condition for waiting the thread to leave the FIFO. */
    private final Condition cLeaving;
    /** Array for the blocking condition. */
    private final boolean leave[];
    /** Maximum number of simultaneous requests. */
    private final int maxRequests;
    /** Next writing position on FIFO. */
    private int idxIn;
    /** Next reading position on FIFO. */
    private int idxOut;
    /** Thread Counter. */
    private int counter;
    /** End flag. */
    private boolean end;
    
    /**
     * FIFO instantiation.
     * @param queueSize queue size
     * @param maxRequests maximum number of simultaneous requests
     */
    public FIFO(int queueSize, int maxRequests) {
        this.maxRequests = maxRequests;
        this.rl = new ReentrantLock(true);
        cStay = new Condition[maxRequests];
        leave = new boolean[maxRequests];
        cLeaving = rl.newCondition();
        for (int i = 0; i < maxRequests; i++) {
            cStay[i] = rl.newCondition();
            leave[i] = false;
        }
        idxIn = 0;
        idxOut = 0;
        counter = 0;
        end = false;
    }

    
    /**
     * Thread entry to FIFO.
     * @return true if not end, false otherwise.
     */
    @Override
    public boolean in() {
        try{
            rl.lock();
            if(end) return false;
            int idx = idxIn;
            idxIn = (++idxIn) % maxRequests;
            counter++;
            while(!leave[idx])
                cStay[idx].await();
            counter--;
            leave[idx] = false;
            cLeaving.signal();
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        } finally{
            rl.unlock();
        }
        return !end;
    }

    /**
     * Notify a thread that is a request to process.
     */
    @Override
    public void out() {
        try{
            rl.lock();
            if(end) return;
            int idx = idxOut;
            idxOut = (++idxOut) % maxRequests; 
            leave[ idx ] = true;
            cStay[ idx ].signal();
            if(counter > 0){
                while(leave[idx] == true)
                    cLeaving.await();
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        } finally{
            rl.unlock();
        }
    }

    /**
     * Set end flag to true and remove all threads waiting on FIFO.
     */
    @Override
    public void end() {
        try{
            rl.lock();
            end = true;
            for (int i = 0; i < maxRequests; i++) {
                leave[ i ] = true;
                cStay[ i ].signal(); 
            }
        } finally {
            rl.unlock();
        }
    }
}

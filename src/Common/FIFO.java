
package Common;

import Communication.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FIFO to handle the server requests.
 * The processing threads enter the FIFO and wait for new requests.
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
    /** Queue size. */
    private final int queueSize;
    /** Maximum number of simultaneous requests. */
    private final int maxRequests;
    /** List of requests in queue. */
    private final List<Message> queue;
    /** Next writing position on FIFO. */
    private int idxIn;
    /** Next reading position on FIFO. */
    private int idxOut;
    /** Thread Counter. */
    private int counter;

    
    /**
     * FIFO instantiation.
     * @param queueSize queue size
     * @param maxRequests maximum number of simultaneous requests
     */
    public FIFO(int queueSize, int maxRequests) {
        this.queueSize = queueSize;
        this.maxRequests = maxRequests;
        this.rl = new ReentrantLock(true);
        cStay = new Condition[maxRequests];
        leave = new boolean[maxRequests];
        cLeaving = rl.newCondition();
        for (int i = 0; i < maxRequests; i++) {
            cStay[i] = rl.newCondition();
            leave[i] = false;
        }
        this.queue = new ArrayList<>();
        idxIn = 0;
        idxOut = 0;
        counter = 0;
    }

    
    /**
     * Thread entry to FIFO. 
     * If there a request in the queue, don't wait.
     * If the queue is empty, wait for new request.
     * @return message with the request to process
     */
    @Override
    public Message in() {
        Message msg = null;
        try{
            rl.lock();
            int idx = idxIn;
            idxIn = (++idxIn) % maxRequests;
            counter++;
            System.out.println(queue.isEmpty());
            if(queue.isEmpty()){
                while(!leave[idx] || queue.isEmpty())
                    cStay[idx].await();
            }
            leave[idx] = false;
            System.out.println("before remove: " + queue.size());
            msg = queue.remove(0);
            System.out.println("after remove: " + queue.size());
            cLeaving.signal();
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        } finally{
            rl.unlock();
        }
        return msg;
    }

    /**
     * Add a request to the queue and notify a thread.
     * @param request message with the new request
     * @return true if queue has space, false otherwise.
     */
    @Override
    public boolean out(Message request) {
        try{
            rl.lock();
            System.out.println("reqCounter->" + queue.size());
            if(queue.size() == queueSize){
                System.out.println("return false");
                return false;
            }
            queue.add(request);
            System.out.println("reqCounter after add->" + queue.size());
            if(counter > 0){
                int idx = idxOut;
                idxOut = (++idxOut) % maxRequests; 
                leave[ idx ] = true;
                cStay[ idx ].signal();
                while(leave[idx] == true)
                    cLeaving.await();
                counter--;
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        } finally{
            rl.unlock();
        }
        return true;
    }
}

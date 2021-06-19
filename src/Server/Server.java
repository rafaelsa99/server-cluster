
package Server;

import Common.FIFO;
import Communication.CClient;
import Communication.Message;
import Communication.MessageCodes;
import java.util.ArrayList;
import java.util.List;

/**
 * Server to handle the requests.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Server extends Thread{
    
    /** Avogrado Number without decimal places. */
    private static final String NA_BASIS = "6 x 10^23";
    /** Avogrado Number decimal places. */
    private static final String NA_DECIMAL_PLACES = "02214076";
    /** Communication Client to Load Balancer. */
    private final CClient cLB;
    /** Communication Client to Monitor. */
    private final CClient cMonitor;
    /** Server GUI. */
    private final Server_GUI serverGUI;
    /** Server ID. */
    private final int serverId;
    /** Iteration timeout. */
    private final int iterationTimeout;
    /** FIFO for the queue of requests. */
    private final FIFO fifo;
    /** List of requests in queue. */
    private final List<Message> queue;
    /** Queue size. */
    private final int queueSize;

    /**
     * Server thread instantiation.
     * @param cLB communication channel to load balancer
     * @param cMonitor communication channel to monitor
     * @param serverGUI reference to the GUI
     * @param serverId server id
     * @param iterationTimeout iteration timeout, in milliseconds
     * @param queueSize queue size
     * @param maxRequests maximum number of simultaneous requests
     */
    public Server(CClient cLB, CClient cMonitor, Server_GUI serverGUI, int serverId, int iterationTimeout, int queueSize, int maxRequests) {
        super("Server " + serverId);
        this.cLB = cLB;
        this.queueSize = queueSize;
        this.cMonitor = cMonitor;
        this.serverGUI = serverGUI;
        this.serverId = serverId;
        this.iterationTimeout = iterationTimeout;
        this.fifo = new FIFO(queueSize, maxRequests);
        this.queue = new ArrayList<>();
        for (int i = 1; i <= maxRequests; i++) 
            new ProcessingThread(i).start();
    }

    /**
     * Close the communication channels.
     */
    public void closeComChannels(){
        cLB.closeConnection();
        cMonitor.closeConnection();
        fifo.end();
    }
    
    /**
     * Check if queue is full.
     * @return true if queue is full, false otherwise.
     */
    public synchronized boolean queueIsFull(){
        return queue.size() >= queueSize;
    }
    
    /**
     * Add a new request to the queue.
     * @param request new request to add
     */
    public synchronized void addRequestToQueue(Message request){
        queue.add(request);
        fifo.out();
    }
    
    /**
     * Remove the first request in the queue
     * @return request removed from the queue
     */
    public synchronized Message getNextRequestOnQueue(){
        if(queue.size() > 0)
            return queue.remove(0);
        return null;
    }
    
    /**
     * Server thread life cycle.
     */
    @Override
    public void run() {
        Message msg;
        while((msg = cLB.receiveMessage()) != null){
            if(queueIsFull()){
                msg.setServerId(serverId);
                msg.setMessageCode(MessageCodes.REJECTION);
                cLB.sendMessage(msg);
                serverGUI.addRequestReceived(msg, "Rejected");
            } else {
                addRequestToQueue(msg);
                serverGUI.addRequestReceived(msg, "In Queue");
            }
        }
    }
    
    /**
     * Thread for processing requests.
     */
    class ProcessingThread extends Thread{

        /**
         * Processing thread instantiation.
         * @param id thread id
         */
        public ProcessingThread(int id) {
            super("Thread " + id);
        }

        /**
         * Processing thread life cycle.
         */
        @Override
        public void run() {
            Message msg;
            while(fifo.in()) {
                msg = getNextRequestOnQueue();
                if(msg != null){
                    Message reply = getReplyMessage(msg);
                    cLB.sendMessage(reply);
                }
            }
        }
        
        /**
         * Get the reply message for a request
         * @param request request message
         * @return reply for the request
         */
        private Message getReplyMessage(Message request){
            String reply = NA_BASIS;
            Message iterUpdate = new Message(false, serverId, request.getRequestId(), MessageCodes.CUR_ITER, 0);
            long startTime = System.nanoTime();
            for (int i = 1; i <= request.getIterations(); i++) {
                if(i == 1)
                    reply = addChar(reply, '.', i);
                iterUpdate.setIterations(i);
                cMonitor.sendMessage(iterUpdate);
                serverGUI.setRequestState(request, "Iteration " + i);
                try {
                    Thread.sleep(iterationTimeout);
                } catch (InterruptedException ex) {}
                char ch = '0';
                if(i <= 8)
                    ch = NA_DECIMAL_PLACES.charAt(i - 1);
                reply = addChar(reply, ch, i + 1);
            }
            long endTime = System.nanoTime();
            request.setServerId(serverId);
            request.setMessageCode(MessageCodes.REPLY);
            request.setValueNa(reply);
            double duration = Math.round(((double)(endTime - startTime) / 1000000000.0)*100.0)/100.0;
            serverGUI.setRequestProcessed(request, duration + "s");
            return request;
        }
        
        /**
         * Add a character to a string.
         * @param str string
         * @param ch character
         * @param position position to add
         * @return string with the character in the given position
         */
        public String addChar(String str, char ch, int position) {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(position, ch);
            return sb.toString();
        }
    }
}

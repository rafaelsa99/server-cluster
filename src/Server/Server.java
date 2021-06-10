
package Server;

import Common.FIFO;
import Communication.CClient;
import Communication.Message;
import Communication.MessageCodes;

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
    /** Client GUI. */
    private final Server_GUI serverGUI;
    /** Server ID. */
    private final int serverId;
    /** Iteration timeout. */
    private final int iterationTimeout;
    /** FIFO for the queue of requests. */
    private final FIFO fifo;

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
        this.cMonitor = cMonitor;
        this.serverGUI = serverGUI;
        this.serverId = serverId;
        this.iterationTimeout = iterationTimeout;
        this.fifo = new FIFO(queueSize, maxRequests);
        for (int i = 1; i <= maxRequests; i++) 
            new ProcessingThread(i).start();
    }

    /**
     * Close the communication channels.
     */
    public void closeComChannels(){
        cLB.closeConnection();
        cMonitor.closeConnection();
    }

    /**
     * Server thread life cycle.
     */
    @Override
    public void run() {
        Message msg;
        while((msg = cLB.receiveMessage()) != null){
            if(!fifo.out(msg)){
               msg.setServerId(serverId);
               msg.setMessageCode(MessageCodes.REJECTION);
               cLB.sendMessage(msg);
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
            while(true) { //-------------> DEVE SER NOT END
                msg = fifo.in();
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
            for (int i = 1; i <= request.getIterations(); i++) {
                if(i == 1)
                    reply = addChar(reply, '.', i);
                iterUpdate.setIterations(i);
                cMonitor.sendMessage(iterUpdate);
                try {
                    Thread.sleep(iterationTimeout);
                } catch (InterruptedException ex) {}
                char ch = NA_DECIMAL_PLACES.charAt(i - 1);
                reply = addChar(reply, ch, i + 1);
            }
            request.setServerId(serverId);
            request.setMessageCode(MessageCodes.REPLY);
            request.setValueNa(reply);
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

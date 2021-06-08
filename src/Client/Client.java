
package Client;

import Communication.CClient;
import Communication.Message;
import Communication.MessageCodes;

/**
 * Client to receive the reply messages.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Client extends Thread{
    
    /** Communication Client. */
    private final CClient cclient;
    /** Client GUI. */
    private final Client_GUI clientGUI;

    /**
     * Client instantiation.
     * @param cclient communication client
     * @param clientGUI client GUI
     */
    public Client(CClient cclient, Client_GUI clientGUI) {
        this.cclient = cclient;
        this.clientGUI = clientGUI;
    }

    /**
     * Client thread life cycle.
     */
    @Override
    public void run() {
        Message msg;
        while((msg = cclient.receiveMessage()) != null)         
           new ProcessingThread(msg).start();
    } 
    
    /**
     * Thread for processing a message received.
     */
    class ProcessingThread extends Thread{
        
        /** Message received to be processed. */
        private final Message msg;

        /**
         * Processing thread instantiation.
         * @param msg message to process
         */
        public ProcessingThread(Message msg) {
            this.msg = msg;
        }

        /**
         * Processing thread life cycle.
         */
        @Override
        public void run() {
            Request request;
            switch (msg.getMessageCode()) {
                case MessageCodes.REPLY:
                    request = new Request(msg.getRequestId(), msg.getIterations(), msg.getValueNa());
                    break;
                case MessageCodes.REJECTION:
                    request = new Request(msg.getRequestId(), msg.getIterations(), "REJECTED");
                    break;
                default:
                    return;
            }
            clientGUI.newExecutedRequest(request);
        }
    }
}

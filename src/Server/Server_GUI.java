
package Server;

import Communication.CClient;
import Communication.Message;
import Communication.MessageCodes;

/**
 * Server graphical interface.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class Server_GUI extends javax.swing.JFrame {

    private final Server server;
    private final int serverId;
    
    /**
     * Creates new form Server_GUI.
     * @param serverId server id
     * @param lbHostname load balancer host name
     * @param lbPort load balancer port
     * @param mHostname monitor host name
     * @param mPort monitor port
     * @param heartbeatTimeout heartbeat timeout, in milliseconds
     * @param iterationTimeout iteration timeout, in milliseconds
     * @param queueSize queue size
     * @param maxRequests maximum number of simultaneous requests
     */
    public Server_GUI(int serverId, String lbHostname, int lbPort, String mHostname, int mPort,
                      int heartbeatTimeout, int iterationTimeout, int queueSize, int maxRequests) {
        initComponents();
        this.serverId = serverId;
        labelChange();
        CClient cLB = initConnection(lbHostname, lbPort);
        CClient cM = initConnection(mHostname, mPort);
        new Heartbeat(cM, heartbeatTimeout, serverId).start();
        this.server = new Server(cLB, cM, this, serverId, iterationTimeout, queueSize, maxRequests);
        this.server.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jButtonEnd = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPaneReceived = new javax.swing.JScrollPane();
        jTableReceived = new javax.swing.JTable();
        jScrollPaneProcessed = new javax.swing.JScrollPane();
        jTableProcessed = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitle.setText("Server");
        jLabelTitle.setMaximumSize(new java.awt.Dimension(70, 22));

        jButtonEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEnd.setText("End");
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });

        jTableReceived.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Client", "Nº of Iterations", "State"
            }
        ));
        jScrollPaneReceived.setViewportView(jTableReceived);

        jTabbedPane.addTab("Requests Received", jScrollPaneReceived);

        jTableProcessed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Client", "Nº of Iterations", "Processing Time"
            }
        ));
        jScrollPaneProcessed.setViewportView(jTableProcessed);

        jTabbedPane.addTab("Processed Requests", jScrollPaneProcessed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEnd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 164, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jButtonEnd)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed
        server.closeComChannels();
        System.exit(0);
    }//GEN-LAST:event_jButtonEndActionPerformed

    /**
     * Initialize a communication client channel to a server.
     * @param hostname server host name
     * @param port server port
     * @return communication client reference
     */
    private CClient initConnection(String hostname, int port){
        CClient cclient = new CClient(hostname, port);
        cclient.connectToServer();
        Message msg = new Message(true, this.serverId, MessageCodes.REG_SERVER);
        cclient.sendMessage(msg);
        return cclient;
    }

    /**
     * Change GUI title label.
     */
    private void labelChange(){
        jLabelTitle.setText("Server " + this.serverId);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPaneProcessed;
    private javax.swing.JScrollPane jScrollPaneReceived;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableProcessed;
    private javax.swing.JTable jTableReceived;
    // End of variables declaration//GEN-END:variables
}

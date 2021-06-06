
package Configurations;

import Server.Server_GUI;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SpinnerNumberModel;

/**
 * Server configuration.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class ServerConfiguration extends javax.swing.JFrame {

    /** Server id. */
    private final int serverID;
    
    /**
     * Creates new form ServerConfiguration.
     * @param serverID server id
     */
    public ServerConfiguration(int serverID) {
        initComponents();
        this.serverID = serverID;
        labelChange();
        initDefaults();
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
        jLabelLBHost = new javax.swing.JLabel();
        jLabelLBPort = new javax.swing.JLabel();
        jTextFieldLBHost = new javax.swing.JTextField();
        jTextFielMHost = new javax.swing.JTextField();
        jLabelMHost = new javax.swing.JLabel();
        jLabelMPort = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jLabelQueueSize = new javax.swing.JLabel();
        jLabelMaxRequests = new javax.swing.JLabel();
        jLabelHeartbeatTimeout = new javax.swing.JLabel();
        jLabelIterationTime = new javax.swing.JLabel();
        jSpinnerHeartbeatTimeout = new javax.swing.JSpinner();
        jSpinnerMPort = new javax.swing.JSpinner();
        jSpinnerLBPort = new javax.swing.JSpinner();
        jSpinnerIterationTimeout = new javax.swing.JSpinner();
        jSpinnerMaxRequests = new javax.swing.JSpinner();
        jSpinnerQueueSize = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitle.setText("Server Configuration");

        jButtonEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEnd.setText("Exit");
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });

        jLabelLBHost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLBHost.setText("Load Balancer Hostname:");

        jLabelLBPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLBPort.setText("Load Balancer Port:");

        jTextFieldLBHost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldLBHost.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFieldLBHost.setPreferredSize(new java.awt.Dimension(75, 23));
        jTextFieldLBHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldLBHostFocusGained(evt);
            }
        });

        jTextFielMHost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFielMHost.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFielMHost.setPreferredSize(new java.awt.Dimension(75, 23));
        jTextFielMHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFielMHostFocusGained(evt);
            }
        });

        jLabelMHost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMHost.setText("Monitor Hostname:");

        jLabelMPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMPort.setText("Monitor Port:");

        jButtonStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonStart.setText("Start Server");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jLabelQueueSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelQueueSize.setText("Queue Size:");

        jLabelMaxRequests.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMaxRequests.setText("Max Nº of Requests:");

        jLabelHeartbeatTimeout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHeartbeatTimeout.setText("Heartbeat Timeout:");

        jLabelIterationTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIterationTime.setText("Iteration Timeout:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitle)
                .addGap(209, 209, 209))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEnd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonStart)
                                .addGap(228, 228, 228))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelIterationTime)
                                    .addComponent(jLabelMaxRequests)
                                    .addComponent(jLabelQueueSize))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinnerQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerMaxRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerIterationTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabelHeartbeatTimeout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerHeartbeatTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelLBHost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldLBHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelMHost)
                                    .addComponent(jLabelLBPort)
                                    .addComponent(jLabelMPort))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFielMHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerLBPort, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerMPort, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnd)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLBHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLBHost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLBPort)
                            .addComponent(jSpinnerLBPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFielMHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMHost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMPort)
                            .addComponent(jSpinnerMPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelQueueSize)
                            .addComponent(jSpinnerQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMaxRequests)
                            .addComponent(jSpinnerMaxRequests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIterationTime)
                            .addComponent(jSpinnerIterationTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHeartbeatTimeout)
                            .addComponent(jSpinnerHeartbeatTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jButtonStart)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Initialize the GUI with the default values.
     */
    private void initDefaults(){
        jSpinnerLBPort.setModel(new SpinnerNumberModel(DefaultConfigs.LB_PORT, 1, 65535, 1));
        jSpinnerMPort.setModel(new SpinnerNumberModel(DefaultConfigs.M_PORT, 1, 65535, 1));
        jSpinnerHeartbeatTimeout.setModel(new SpinnerNumberModel(DefaultConfigs.HEARTBEAT_TIMEOUT, 1, Integer.MAX_VALUE, 1));
        jSpinnerIterationTimeout.setModel(new SpinnerNumberModel(DefaultConfigs.ITERATION_TIMEOUT, 1, Integer.MAX_VALUE, 1));
        jSpinnerMaxRequests.setModel(new SpinnerNumberModel(DefaultConfigs.MAX_REQUESTS, 1, Integer.MAX_VALUE, 1));
        jSpinnerQueueSize.setModel(new SpinnerNumberModel(DefaultConfigs.QUEUE_SIZE, 1, Integer.MAX_VALUE, 1));
        jTextFieldLBHost.setText(DefaultConfigs.HOSTNAME);
        jTextFielMHost.setText(DefaultConfigs.HOSTNAME);
    }
    
    /**
     * End button action.
     * @param evt event
     */
    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonEndActionPerformed

    /**
     * Start Button Action.
     * Start server GUI with the configurations.
     * @param evt event
     */
    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        String lbhostname = jTextFieldLBHost.getText();
        String mhostname = jTextFielMHost.getText();
        if(lbhostname.isBlank()){
            jTextFieldLBHost.setBackground(Color.red);
            if(mhostname.isBlank())
                jTextFielMHost.setBackground(Color.red);
            return;
        }
        if(mhostname.isBlank()){
            jTextFielMHost.setBackground(Color.red);
            return;
        }
        int lbPort = (int)jSpinnerLBPort.getValue();
        int mPort = (int)jSpinnerMPort.getValue();
        int heartbeat = (int)jSpinnerHeartbeatTimeout.getValue();
        int iteration = (int)jSpinnerIterationTimeout.getValue();
        int queue = (int) jSpinnerQueueSize.getValue();
        int maxReq = (int)jSpinnerMaxRequests.getValue();
        this.setVisible(false);
        new Server_GUI(lbhostname, lbPort, mhostname, mPort, heartbeat, iteration, queue, maxReq).setVisible(true);
    }//GEN-LAST:event_jButtonStartActionPerformed

    /**
     * Load Balancer host name focus event.
     * Reset background color.
     * @param evt event
     */
    private void jTextFieldLBHostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLBHostFocusGained
        jTextFieldLBHost.setBackground(SystemColor.text);
    }//GEN-LAST:event_jTextFieldLBHostFocusGained

    /**
     * Monitor host name focus event.
     * Reset background color.
     * @param evt event
     */
    private void jTextFielMHostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFielMHostFocusGained
        jTextFielMHost.setBackground(SystemColor.text);
    }//GEN-LAST:event_jTextFielMHostFocusGained

    /**
     * Change GUI title label.
     */
    private void labelChange(){
        jLabelTitle.setText("Server " + this.serverID + " Configuration");
    }
    
    /**
     * Main function.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {            
            if(args.length != 1)
                System.out.println("Parameters: serverID");
            int serverID = 0;
            try{
                serverID = Integer.parseInt(args[0]);
            } catch(NumberFormatException ex){
                System.out.println("Parameters: serverID");
                System.exit(1);
            }
            new ServerConfiguration(serverID).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JLabel jLabelHeartbeatTimeout;
    private javax.swing.JLabel jLabelIterationTime;
    private javax.swing.JLabel jLabelLBHost;
    private javax.swing.JLabel jLabelLBPort;
    private javax.swing.JLabel jLabelMHost;
    private javax.swing.JLabel jLabelMPort;
    private javax.swing.JLabel jLabelMaxRequests;
    private javax.swing.JLabel jLabelQueueSize;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JSpinner jSpinnerHeartbeatTimeout;
    private javax.swing.JSpinner jSpinnerIterationTimeout;
    private javax.swing.JSpinner jSpinnerLBPort;
    private javax.swing.JSpinner jSpinnerMPort;
    private javax.swing.JSpinner jSpinnerMaxRequests;
    private javax.swing.JSpinner jSpinnerQueueSize;
    private javax.swing.JTextField jTextFielMHost;
    private javax.swing.JTextField jTextFieldLBHost;
    // End of variables declaration//GEN-END:variables
}

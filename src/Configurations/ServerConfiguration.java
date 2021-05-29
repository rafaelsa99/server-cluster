/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

/**
 *
 * @author luisc
 */
public class ServerConfiguration extends javax.swing.JFrame {

    /**
     * Creates new form ServerConfiguration
     */
    public ServerConfiguration() {
        initComponents();
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
        jTextFieldLBPort = new javax.swing.JTextField();
        jTextFielMHost = new javax.swing.JTextField();
        jTextFieldMPort = new javax.swing.JTextField();
        jLabelMHost = new javax.swing.JLabel();
        jLabelMPort = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jTextFieldPort = new javax.swing.JTextField();
        jTextFieldQueueSize = new javax.swing.JTextField();
        jTextFieldIterationTime = new javax.swing.JTextField();
        jTextFieldMaxRequests = new javax.swing.JTextField();
        jTextFieldHeartbeatTimeout = new javax.swing.JTextField();
        jLabelPort = new javax.swing.JLabel();
        jLabelQueueSize = new javax.swing.JLabel();
        jLabelMaxRequests = new javax.swing.JLabel();
        jLabelHeartbeatTimeout = new javax.swing.JLabel();
        jLabelIterationTime = new javax.swing.JLabel();

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

        jTextFieldLBPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldLBPort.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFieldLBPort.setPreferredSize(new java.awt.Dimension(75, 23));

        jTextFielMHost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFielMHost.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFielMHost.setPreferredSize(new java.awt.Dimension(75, 23));

        jTextFieldMPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldMPort.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFieldMPort.setPreferredSize(new java.awt.Dimension(75, 23));

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

        jTextFieldPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPort.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFieldPort.setPreferredSize(new java.awt.Dimension(75, 23));

        jTextFieldQueueSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldQueueSize.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFieldQueueSize.setPreferredSize(new java.awt.Dimension(75, 23));

        jTextFieldIterationTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldIterationTime.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFieldIterationTime.setPreferredSize(new java.awt.Dimension(75, 23));

        jTextFieldMaxRequests.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldMaxRequests.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFieldMaxRequests.setPreferredSize(new java.awt.Dimension(75, 23));

        jTextFieldHeartbeatTimeout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldHeartbeatTimeout.setMinimumSize(new java.awt.Dimension(75, 23));
        jTextFieldHeartbeatTimeout.setPreferredSize(new java.awt.Dimension(75, 23));

        jLabelPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPort.setText("Port:");

        jLabelQueueSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelQueueSize.setText("Queue Size:");

        jLabelMaxRequests.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMaxRequests.setText("Max Nº of Requests:");

        jLabelHeartbeatTimeout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHeartbeatTimeout.setText("Heartbeat Timeout:");

        jLabelIterationTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIterationTime.setText("Iteration Time:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonEnd)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelQueueSize)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelPort)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelIterationTime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldIterationTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelMaxRequests)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldMaxRequests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelLBHost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldLBHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLBPort, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelMHost, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelMPort, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelHeartbeatTimeout, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldLBPort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFielMHost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMPort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldHeartbeatTimeout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jButtonStart))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabelTitle)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLBHost)
                    .addComponent(jTextFieldLBHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLBPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLBPort)
                    .addComponent(jTextFieldQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQueueSize))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFielMHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMHost)
                    .addComponent(jTextFieldMaxRequests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMaxRequests))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMPort)
                    .addComponent(jTextFieldIterationTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIterationTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHeartbeatTimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHeartbeatTimeout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButtonStart)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEndActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonStartActionPerformed

    /**
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerConfiguration().setVisible(true);
            }
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
    private javax.swing.JLabel jLabelPort;
    private javax.swing.JLabel jLabelQueueSize;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFielMHost;
    private javax.swing.JTextField jTextFieldHeartbeatTimeout;
    private javax.swing.JTextField jTextFieldIterationTime;
    private javax.swing.JTextField jTextFieldLBHost;
    private javax.swing.JTextField jTextFieldLBPort;
    private javax.swing.JTextField jTextFieldMPort;
    private javax.swing.JTextField jTextFieldMaxRequests;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldQueueSize;
    // End of variables declaration//GEN-END:variables
}

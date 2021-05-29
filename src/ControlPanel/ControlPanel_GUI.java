/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPanel;

import javax.swing.JLabel;

/**
 *
 * @author omp
 */
public class ControlPanel_GUI extends javax.swing.JFrame {

    /**
     * Creates new form ControlPanel_GUI
     */
    public ControlPanel_GUI() {
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

        jButtonEnd = new javax.swing.JButton();
        jToggleButtonStartLoadBalancer = new javax.swing.JToggleButton();
        jToggleButtonStartMonitor = new javax.swing.JToggleButton();
        jButtonNewServer = new javax.swing.JButton();
        jButtonNewClient = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPaneServers = new javax.swing.JScrollPane();
        jTableServers = new javax.swing.JTable();
        jScrollPaneClients = new javax.swing.JScrollPane();
        jTableClients = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonEnd.setText("End");

        jToggleButtonStartLoadBalancer.setText("Start Load Balancer");
        jToggleButtonStartLoadBalancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonStartLoadBalancerActionPerformed(evt);
            }
        });

        jToggleButtonStartMonitor.setText("Start Monitor");
        jToggleButtonStartMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonStartMonitorActionPerformed(evt);
            }
        });

        jButtonNewServer.setText("Start New Server");
        jButtonNewServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewServerActionPerformed(evt);
            }
        });

        jButtonNewClient.setText("Start New Client");
        jButtonNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewClientActionPerformed(evt);
            }
        });

        jTableServers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Server ID", "Shutdown"
            }
        ));
        jScrollPaneServers.setViewportView(jTableServers);
        if (jTableServers.getColumnModel().getColumnCount() > 0) {
            jTableServers.getColumnModel().getColumn(0).setCellRenderer(null);
            jTableServers.getColumnModel().getColumn(1).setCellRenderer(null);
        }

        jTabbedPane.addTab("Servers", jScrollPaneServers);

        jTableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client ID", "Shutdown"
            }
        ));
        jScrollPaneClients.setViewportView(jTableClients);

        jTabbedPane.addTab("Clients", jScrollPaneClients);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEnd))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButtonStartLoadBalancer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButtonStartMonitor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNewServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNewClient)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonStartLoadBalancer)
                    .addComponent(jToggleButtonStartMonitor)
                    .addComponent(jButtonNewServer)
                    .addComponent(jButtonNewClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonStartLoadBalancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonStartLoadBalancerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonStartLoadBalancerActionPerformed

    private void jToggleButtonStartMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonStartMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonStartMonitorActionPerformed

    private void jButtonNewServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewServerActionPerformed

    private void jButtonNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewClientActionPerformed

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
            java.util.logging.Logger.getLogger(ControlPanel_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlPanel_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonNewClient;
    private javax.swing.JButton jButtonNewServer;
    private javax.swing.JScrollPane jScrollPaneClients;
    private javax.swing.JScrollPane jScrollPaneServers;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableClients;
    private javax.swing.JTable jTableServers;
    private javax.swing.JToggleButton jToggleButtonStartLoadBalancer;
    private javax.swing.JToggleButton jToggleButtonStartMonitor;
    // End of variables declaration//GEN-END:variables
}

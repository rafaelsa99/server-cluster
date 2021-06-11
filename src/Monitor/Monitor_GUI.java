/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author omp
 */
public class Monitor_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Monitor_GUI
     */
    public Monitor_GUI(int port, String hostname, int lbPort, int heartbeatThreshold) {
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
        jLayeredPaneServerRequests = new javax.swing.JLayeredPane();
        jPanelBase = new javax.swing.JPanel();
        jButtonEnd = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPaneServer = new javax.swing.JScrollPane();
        jTableServer = new javax.swing.JTable();
        jScrollPaneLB = new javax.swing.JScrollPane();
        jTableLB = new javax.swing.JTable();
        jButtonPreview = new javax.swing.JButton();
        jPanelServer = new javax.swing.JPanel();
        jButtonBack = new javax.swing.JButton();
        jLabelTitleServer = new javax.swing.JLabel();
        jScrollPaneRequests = new javax.swing.JScrollPane();
        jTableRequests = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitle.setText("Monitor");
        jLabelTitle.setMaximumSize(new java.awt.Dimension(70, 22));

        jButtonEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEnd.setText("End");
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });

        jTableServer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "Button"}
            },
            new String [] {
                "Server ID", "State", "Requests"
            }
        ));
        jTableServer.setColumnSelectionAllowed(true);
        jTableServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableServerMouseClicked(evt);
            }
        });
        jScrollPaneServer.setViewportView(jTableServer);
        jTableServer.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableServer.getColumnModel().getColumnCount() > 0) {
            jTableServer.getColumnModel().getColumn(2).setCellRenderer(new TableButtonRenderer());
        }
        jTableServer.setName("Server");
        jTableServer.setRowHeight(35);
        jTableServer.addMouseListener(new JTableButtonMouseListener(jTableServer));

        jTabbedPane.addTab("Server", jScrollPaneServer);

        jTableLB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Client", "Server", "Nº of Iterations"
            }
        ));
        jScrollPaneLB.setViewportView(jTableLB);

        jTabbedPane.addTab("Load Balancer", jScrollPaneLB);

        jButtonPreview.setText("Preview");
        jButtonPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaseLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonPreview)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonEnd)))
                .addContainerGap())
        );
        jPanelBaseLayout.setVerticalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnd)
                    .addComponent(jButtonPreview))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        jPanelServer.setEnabled(false);

        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelTitleServer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTitleServer.setText("Server Requests");
        jLabelTitleServer.setMaximumSize(new java.awt.Dimension(150, 17));
        jLabelTitleServer.setPreferredSize(new java.awt.Dimension(150, 17));

        jTableRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Client", "State", "Nº of Iterations", "Current Iteration"
            }
        ));
        jScrollPaneRequests.setViewportView(jTableRequests);

        javax.swing.GroupLayout jPanelServerLayout = new javax.swing.GroupLayout(jPanelServer);
        jPanelServer.setLayout(jPanelServerLayout);
        jPanelServerLayout.setHorizontalGroup(
            jPanelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelServerLayout.createSequentialGroup()
                        .addComponent(jButtonBack)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPaneRequests, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelServerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitleServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        jPanelServerLayout.setVerticalGroup(
            jPanelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBack)
                .addGap(4, 4, 4)
                .addComponent(jLabelTitleServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPaneRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLayeredPaneServerRequests.setLayer(jPanelBase, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPaneServerRequests.setLayer(jPanelServer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneServerRequestsLayout = new javax.swing.GroupLayout(jLayeredPaneServerRequests);
        jLayeredPaneServerRequests.setLayout(jLayeredPaneServerRequestsLayout);
        jLayeredPaneServerRequestsLayout.setHorizontalGroup(
            jLayeredPaneServerRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPaneServerRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPaneServerRequestsLayout.setVerticalGroup(
            jLayeredPaneServerRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneServerRequestsLayout.createSequentialGroup()
                .addGap(0, 62, Short.MAX_VALUE)
                .addComponent(jPanelBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPaneServerRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneServerRequestsLayout.createSequentialGroup()
                    .addGap(0, 66, Short.MAX_VALUE)
                    .addComponent(jPanelServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPaneServerRequests, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPaneServerRequests, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEndActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        jLayeredPaneServerRequests.setLayer(jPanelBase, 2);
        jLayeredPaneServerRequests.setLayer(jPanelServer, 0);
        jLayeredPaneServerRequests.repaint();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTableServerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableServerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableServerMouseClicked

    private void jButtonPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviewActionPerformed
        
        jLayeredPaneServerRequests.setLayer(jPanelServer, 2);
        jLayeredPaneServerRequests.setLayer(jPanelBase, 0);
        jLayeredPaneServerRequests.repaint();
    }//GEN-LAST:event_jButtonPreviewActionPerformed
    
    private void jTableStateMouseClicked(Object obj) {                                          
        // TODO add your handling code here: 
    }     
    
    private void jButtonServerInfoActionPerformed(Integer object) {                                           
        loadServerRequests(object);
        jLayeredPaneServerRequests.setLayer(jPanelServer, 2);
        jLayeredPaneServerRequests.setLayer(jPanelBase, 0);
        jLayeredPaneServerRequests.repaint();
    } 
    
        /**
    * Custom List Item Renderer
    */
    class TableButtonRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = -7799441088157759804L;
        private JButton button;

        TableButtonRenderer() {
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, 
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int col) {
            
            button = new JButton();
            button.setText("View Server Requests");        
            return button;
        }
        
    }
    
    public class JTableButtonMouseListener extends MouseAdapter {
      private final JTable table;

      public JTableButtonMouseListener(JTable table) {
        this.table = table;
      }

      @Override public void mouseClicked(MouseEvent e) {
        int column = table.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY()/table.getRowHeight(); 

        if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
          Object value = table.getValueAt(row, column);
            jButtonServerInfoActionPerformed((Integer)value);
        }
      }
    }
    
    private void loadServerRequests(Integer id){
        DefaultTableModel model;
        model = (DefaultTableModel) jTableServer.getModel();
        cleanTable(model);
        //Append Server Info to Table
        //model.addRow(new Object[]{"Request " + request.getId(), request.getnIterations()});
    }
    
    private void cleanTable(DefaultTableModel model){
        for(int i = 0; i < model.getRowCount(); i++){
            model.removeRow(i);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonPreview;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitleServer;
    private javax.swing.JLayeredPane jLayeredPaneServerRequests;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelServer;
    private javax.swing.JScrollPane jScrollPaneLB;
    private javax.swing.JScrollPane jScrollPaneRequests;
    private javax.swing.JScrollPane jScrollPaneServer;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableLB;
    private javax.swing.JTable jTableRequests;
    private javax.swing.JTable jTableServer;
    // End of variables declaration//GEN-END:variables
}

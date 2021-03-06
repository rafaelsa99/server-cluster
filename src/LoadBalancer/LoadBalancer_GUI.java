
package LoadBalancer;

import javax.swing.table.DefaultTableModel;
import Communication.Message;
import javax.swing.SwingUtilities;

/**
 * Load Balancer graphical interface.
 * @author Rafael Sá (104552), Luís Laranjeira (81526)
 */
public class LoadBalancer_GUI extends javax.swing.JFrame {
    
    /** Load Balancer Service. */
    private final LoadBalancer loadBalancer;
    
    /**
     * Creates new form LoadBalancer_GUI.
     * @param port load balancer server port
     * @param hostname monitor host name
     * @param mPort monitor port
     */
    public LoadBalancer_GUI(int port, String hostname, int mPort) {
        initComponents();
        this.loadBalancer = new LoadBalancer(port, hostname, mPort, this);
        this.loadBalancer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jScrollPaneRequests = new javax.swing.JScrollPane();
        jTableRequests = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Load Balancer");

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jTableRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Client", "Server", "Number of Iterations"
            }
        ));
        jScrollPaneRequests.setViewportView(jTableRequests);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119)
                .addComponent(jButtonExit)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneRequests, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExit)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addComponent(jScrollPaneRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * End button action.
     * @param evt event
     */
    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        loadBalancer.closeSockets();
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    /**
     * Add a new request to the GUI.
     * @param request new request
     */
    public synchronized void addElemToRequestTable(Message request){
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> {
                addElemToRequestTable(request);
            });
            return;
        }
        DefaultTableModel model;
        model = (DefaultTableModel) jTableRequests.getModel();
        model.addRow(new Object[]{"Request " + request.getRequestId(), "Client " + request.getClientId(), "Not Assigned", request.getIterations()});
    }
    
    /**
     * Remove a request from the GUI.
     * @param request request to remove
     */
    public synchronized void removeRequestFromTable(Message request){
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> {
                removeRequestFromTable(request);
            });
            return;
        }
        DefaultTableModel model;
        model = (DefaultTableModel) jTableRequests.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (((String)model.getValueAt(i, 0)).equals("Request " + request.getRequestId())) {
                model.removeRow(i);
            }
        }
    }
    
    /**
     * Set the server assigned to a given request on the GUI.
     * @param msg message with the request id and server id
     */
    public synchronized void setRequestServer(Message msg){
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> {
                setRequestServer(msg);
            });
            return;
        }
        DefaultTableModel model;
        model = (DefaultTableModel) jTableRequests.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (((String)model.getValueAt(i, 0)).equals("Request " + msg.getRequestId())) {
                model.setValueAt("Server " + msg.getServerId(), i, 2);
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPaneRequests;
    private javax.swing.JTable jTableRequests;
    // End of variables declaration//GEN-END:variables
}

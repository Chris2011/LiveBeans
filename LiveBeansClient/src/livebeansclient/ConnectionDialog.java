/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livebeansclient;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;

/**
 *
 * @author ooddl
 */
public class ConnectionDialog extends javax.swing.JDialog
{

    /**
     * Creates new form ConnectionDialog
     */
    public ConnectionDialog(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();

        txtClientName.setText("");
        txtServerIP.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnConnect = new javax.swing.JButton();
        lblClientName = new javax.swing.JLabel();
        lblServerIP = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        txtServerIP = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ConnectionDialog.class, "ConnectionDialog.title")); // NOI18N

        btnConnect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnConnect, org.openide.util.NbBundle.getMessage(ConnectionDialog.class, "ConnectionDialog.btnConnect.text")); // NOI18N
        btnConnect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnConnectActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lblClientName, org.openide.util.NbBundle.getMessage(ConnectionDialog.class, "ConnectionDialog.lblClientName.text")); // NOI18N
        lblClientName.setToolTipText(org.openide.util.NbBundle.getMessage(ConnectionDialog.class, "ConnectionDialog.lblClientName.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblServerIP, org.openide.util.NbBundle.getMessage(ConnectionDialog.class, "ConnectionDialog.lblServerIP.text")); // NOI18N

        txtClientName.setText(org.openide.util.NbBundle.getMessage(ConnectionDialog.class, "ConnectionDialog.txtClientName.text")); // NOI18N

        txtServerIP.setText(org.openide.util.NbBundle.getMessage(ConnectionDialog.class, "ConnectionDialog.txtServerIP.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConnect, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblClientName)
                            .addComponent(lblServerIP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientName)
                            .addComponent(txtServerIP))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientName)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServerIP)
                    .addComponent(txtServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConnect)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnConnectActionPerformed
    {//GEN-HEADEREND:event_btnConnectActionPerformed
        if (txtServerIP.getText().trim().equals("") || txtClientName.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this.getParent(), "You must input your Name & a Server IP to connect to");
        } else
        {
            LiveBeansClient client = null;
            try
            {
                client = (LiveBeansClient) LiveBeansClient.getInstance();
            } catch (RemoteException ex)
            {
                Exceptions.printStackTrace(ex);
            }

            try
            {
                client.SetName(txtClientName.getText().trim());
                client.ConnectToServer(txtServerIP.getText().trim());

                JOptionPane.showMessageDialog(this.getParent(), "You are now connected");
            } catch (RemoteException ex)
            {
                System.out.println("Error Occurred: " + ex.getMessage());
                JOptionPane.showMessageDialog(this.getParent(), "There was an error connecting to the server");
            }
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel lblClientName;
    private javax.swing.JLabel lblServerIP;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JFormattedTextField txtServerIP;
    // End of variables declaration//GEN-END:variables
}

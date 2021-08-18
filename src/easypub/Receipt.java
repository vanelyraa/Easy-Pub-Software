/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import javax.swing.table.TableModel;

/**
 *
 * @author vanel
 */
public class Receipt extends javax.swing.JFrame {

    /**
     * Creates new form Receipt Receipt to be printed to user
     */
    public Receipt() {
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }

    Double rtot;

    //String representation of receipt, retrives data from table
    public Receipt(Double tot, TableModel model) {
        initComponents();
        this.rtot = tot;

        txtprint.setText(txtprint.getText() + "*****************************************************\n");
        txtprint.setText(txtprint.getText() + "**************************RECEIPT********************\n");
        txtprint.setText(txtprint.getText() + "\n");
        txtprint.setText(txtprint.getText() + "Product" + "\t" + "Price" + "\t" + "Price" + "\t" + "Total" + "\n");
        txtprint.setText(txtprint.getText() + "\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            String product = (String) model.getValueAt(i, 0);
            String price = (String) model.getValueAt(i, 1);
            String qty = (String) model.getValueAt(i, 2);
            Double total = (Double) model.getValueAt(i, 3);

            txtprint.setText(txtprint.getText() + product + "\t" + price + "\t" + qty + "\t" + total + "\n");
        }
        txtprint.setText(txtprint.getText() + "\n");
        txtprint.setText(txtprint.getText() + "\n");

        txtprint.setText(txtprint.getText() + "          " + "Total: " + tot + "\n");

        txtprint.setText(txtprint.getText() + "***************************************************\n");
        txtprint.setText(txtprint.getText() + "***************************************************\n");
        txtprint.setText(txtprint.getText() + "**********************THANK YOU!*******************\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtprint = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtprint.setColumns(20);
        txtprint.setRows(5);
        jScrollPane1.setViewportView(txtprint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtprint;
    // End of variables declaration//GEN-END:variables
}

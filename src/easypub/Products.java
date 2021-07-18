/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vanel
 */
public class Products extends javax.swing.JFrame {

    /**
     * Creates new form Supplier
     */
    public Products() {
        initComponents();       
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProdTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        jLabel3 = new javax.swing.JLabel();
        bt_save_prod = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txproduct_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txcost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txsaleprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txunit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txleadtime = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dropcategory = new javax.swing.JComboBox<>();
        txminqty = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        dropsup = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(950, 600));
        setMinimumSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(null);

        ProdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product_ID", "Product_name", "Supplier_name", "Cost", "Sales_price", "Lead_time", "Unit", "Min_qty", "Category"
            }
        ));
        ProdTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProdTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 550, 450);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(70, 100, 117, 20);

        jLabel1.setText("Search");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 100, 33, 14);
        getContentPane().add(filler1);
        filler1.setBounds(391, 0, 0, 303);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel3.setText("Products");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 10, 200, 80);

        bt_save_prod.setText("Save");
        bt_save_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_save_prodMouseClicked(evt);
            }
        });
        bt_save_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_save_prodActionPerformed(evt);
            }
        });
        getContentPane().add(bt_save_prod);
        bt_save_prod.setBounds(630, 560, 70, 23);

        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(710, 560, 70, 23);

        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(860, 560, 57, 23);
        getContentPane().add(txproduct_name);
        txproduct_name.setBounds(600, 150, 300, 20);

        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(600, 130, 27, 14);

        jLabel4.setText("Supplier");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(600, 180, 40, 14);
        getContentPane().add(txcost);
        txcost.setBounds(600, 250, 70, 20);

        jLabel5.setText("Cost");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(600, 230, 40, 14);

        jLabel6.setText("Category");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(600, 280, 80, 14);
        getContentPane().add(txsaleprice);
        txsaleprice.setBounds(710, 250, 70, 20);

        jLabel7.setText("Sale price");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(710, 230, 60, 14);
        getContentPane().add(txunit);
        txunit.setBounds(830, 250, 70, 20);

        jLabel8.setText("Unit");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(830, 230, 40, 14);
        getContentPane().add(txleadtime);
        txleadtime.setBounds(710, 300, 70, 20);

        jLabel9.setText("Lead time(days)");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(710, 280, 80, 14);

        getContentPane().add(dropcategory);
        dropcategory.setBounds(600, 300, 70, 22);
        getContentPane().add(txminqty);
        txminqty.setBounds(830, 300, 70, 20);

        jLabel10.setText("Min. qty");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(830, 280, 80, 14);

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(790, 560, 63, 23);

        getContentPane().add(dropsup);
        dropsup.setBounds(600, 200, 220, 22);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_save_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_save_prodActionPerformed
       
      
        
    }//GEN-LAST:event_bt_save_prodActionPerformed

    private void ProdTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdTableMouseClicked
       /*df = (DefaultTableModel)ProdTable.getModel();
        int selected = ProdTable.getSelectedRow();
        int product_ID = Integer.parseInt(df.getValueAt(selected, 0).toString());
        txproduct_name.setText(df.getValueAt(selected, 1).toString());
        dropsup.setSelectedItem(df.getValueAt(selected, 2).toString());
        txcost.setText(df.getValueAt(selected, 3).toString());
        txsaleprice.setText(df.getValueAt(selected, 4).toString());
        txleadtime.setText(df.getValueAt(selected, 5).toString());
        txunit.setText(df.getValueAt(selected, 6).toString());
        txminqty.setText(df.getValueAt(selected, 7).toString());
        dropcategory.setSelectedItem(df.getValueAt(selected, 8).toString());
        
        bt_save_prod.setEnabled(false);*/
    }//GEN-LAST:event_ProdTableMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bt_save_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_save_prodMouseClicked
        
    }//GEN-LAST:event_bt_save_prodMouseClicked

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
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProdTable;
    private javax.swing.JButton bt_save_prod;
    private javax.swing.JComboBox<String> dropcategory;
    private javax.swing.JComboBox<String> dropsup;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txcost;
    private javax.swing.JTextField txleadtime;
    private javax.swing.JTextField txminqty;
    private javax.swing.JTextField txproduct_name;
    private javax.swing.JTextField txsaleprice;
    private javax.swing.JTextField txunit;
    // End of variables declaration//GEN-END:variables
}

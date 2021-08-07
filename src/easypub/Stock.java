/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author vanel
 */
public class Stock extends javax.swing.JFrame {

    /**
     * Creates new form Supplier
     */
    public Stock() {
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        
    }
    
     Connection cnct = null;
    Statement stat = null;
    ResultSet resst = null;
    PreparedStatement prepst = null;
    //java.util.Date DateTr;
   // java.sql.Date transDate;
    
    public void StockSelect() {
        try {
            cnct = DriverManager.getConnection("jdbc:mysql://localhost:3306/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            stat = cnct.createStatement();
            resst = stat.executeQuery("select date, product_name, transaction, quantity from stock");
            stockTable.setModel(DbUtils.resultSetToTableModel(resst));
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LowStockSelect() {
        try {
            cnct = DriverManager.getConnection("jdbc:mysql://localhost:3306/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            stat = cnct.createStatement();
            resst = stat.executeQuery("select product_ID, product_name, quantity, min_qty, from product");
            jTable2.setModel(DbUtils.resultSetToTableModel(resst));
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /*public class ProductDropB{
        String id;
        String product;
        
        
    
    
    public ProductDropB(String id,String product){
        this.id= id;
        this.product=product;
    
}
    
    public String toString(){
        return product;
    }
    }
    
    public void Product(){
   
            try {
                cnct = DriverManager.getConnection("jdbc:mysql://localhost:3306/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                stat = cnct.createStatement();
                resst = stat.executeQuery("select * from product");
            
            
            comboprod.removeAllItems();
            while(resst.next())
            {
            String name = resst.getString("product_name");
             comboprod.addItem(name);
            }
            }catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }   
             
        }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btDelSt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        bt_save_sup = new javax.swing.JButton();
        btEditSt = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txqtystock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txid1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        btDelSt.setBackground(new java.awt.Color(0, 102, 51));
        btDelSt.setForeground(new java.awt.Color(204, 255, 204));
        btDelSt.setText("Delete");
        btDelSt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDelStMouseClicked(evt);
            }
        });

        jLabel1.setText("Search");

        bt_save_sup.setBackground(new java.awt.Color(0, 102, 51));
        bt_save_sup.setForeground(new java.awt.Color(204, 255, 204));
        bt_save_sup.setText("Save");
        bt_save_sup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_save_supMouseClicked(evt);
            }
        });
        bt_save_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_save_supActionPerformed(evt);
            }
        });

        btEditSt.setBackground(new java.awt.Color(0, 102, 51));
        btEditSt.setForeground(new java.awt.Color(204, 255, 204));
        btEditSt.setText("Edit");
        btEditSt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditStMouseClicked(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 51));
        jButton6.setForeground(new java.awt.Color(204, 255, 204));
        jButton6.setText("Clear");
        jButton6.setActionCommand("Clear data");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("Date");

        txqtystock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txqtystockActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantity");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "goods receipt", "void", "waste" }));

        jLabel4.setText("Transaction type");

        jLabel7.setText("ID");

        jLabel2.setText("Product");

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Stock");
        jPanel2.add(jLabel3);

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Product", "Quantity"
            }
        ));
        stockTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(stockTable);

        jTabbedPane1.addTab("STOCK", jScrollPane1);
        jTabbedPane1.addTab("LOW STOCK", jTabbedPane2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product name", "Reorder point", "Quantity"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jTabbedPane1.addTab("LOW STOCK", jScrollPane3);

        jLabel8.setText("Quantity");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bt_save_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btEditSt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btDelSt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txqtystock, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txid1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(0, 14, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txqtystock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txid1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_save_sup)
                            .addComponent(btEditSt)
                            .addComponent(btDelSt)
                            .addComponent(jButton6))))
                .addGap(36, 36, 36))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btDelSt, btEditSt, bt_save_sup, jButton6});

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_save_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_save_supActionPerformed
      
            
           
    }//GEN-LAST:event_bt_save_supActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bt_save_supMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_save_supMouseClicked
       int qty = Integer.parseInt(txqtystock.getText());
        try {
            cnct = DriverManager.getConnection("jdbc:mysql://localhost:3306/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            prepst = cnct.prepareStatement("insert into stock values(?,?,?,?)");
           
            //prepst.setDate(1, transDate);
            prepst.setString(2,jTextField2.getText());            
            prepst.setString(3, jComboBox2.getSelectedItem().toString());
            prepst.setString(4, txqtystock.getText());
           

            int row = prepst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Stock updated sucesfully");
           
            cnct.close();
            StockSelect();
            
            jButton6MouseClicked(evt);

        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_save_supMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        comboprod.setSelectedItem(-1);
        jComboBox2.setSelectedItem(-1);
            txqtystock.setText("");
    }//GEN-LAST:event_jButton6MouseClicked

    private void btEditStMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditStMouseClicked
         if (txqtystock.getText().isEmpty())/*||txproduct_name.getText().isEmpty()|| dropsup.getSelectedItem()==null|| txcost.getText().isEmpty()|| txsaleprice.getText().isEmpty()|| txleadtime.getText().isEmpty()|| txunit.getText().isEmpty()|| txminqty.getText().isEmpty()|| dropcategory.getSelectedItem()==null)*/ {
            JOptionPane.showMessageDialog(this, "Select the category to be edited");
        } else { 
            try {

               // DateTr = transDate.getDate();
      // transDate = new java.sql.Date(DateTr.getTime());
                cnct = DriverManager.getConnection("jdbc:mysql://localhost:3368/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");

                prepst = cnct.prepareStatement("update stock SET date= ?, transaction= ?, quantity = ? where product_name= ?)");
                       

               // prepst.setDate(1, transDate);
                prepst.setString(2, comboprod.getSelectedItem().toString());
                prepst.setString(3, jComboBox2.getSelectedItem().toString());
                prepst.setString(4, txqtystock.getText());
            

                int row1 = prepst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Category updated sucesfully");
                cnct.close();
                StockSelect();
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
    }//GEN-LAST:event_btEditStMouseClicked

    private void btDelStMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDelStMouseClicked
         
        if (txqtystock.getText().isEmpty())/*||txproduct_name.getText().isEmpty()|| dropsup.getSelectedItem()==null|| txcost.getText().isEmpty()|| txsaleprice.getText().isEmpty()|| txleadtime.getText().isEmpty()|| txunit.getText().isEmpty()|| txminqty.getText().isEmpty()|| dropcategory.getSelectedItem()==null)*/ {
            JOptionPane.showMessageDialog(this, "Select the category to be deleted");
        } else { 
        
            try {
                cnct = DriverManager.getConnection("jdbc:mysql://localhost:3306/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");

                prepst = cnct.prepareStatement("Delete from product where product_name=?");
                prepst.setString(1, comboprod.getSelectedItem().toString());
                prepst.execute();
                StockSelect();
                JOptionPane.showMessageDialog(null, "Product deleted sucesfully");

            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }//GEN-LAST:event_btDelStMouseClicked

    private void stockTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockTableMouseClicked
        DefaultTableModel tableProd = (DefaultTableModel)stockTable.getModel();
        int rowIndex = stockTable.getSelectedRow();

        jTextField2.setText(tableProd.getValueAt(rowIndex, 1).toString());
        jComboBox2.setSelectedItem(tableProd.getValueAt(rowIndex, 2).toString());
        txqtystock.setText(tableProd.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_stockTableMouseClicked

    private void txqtystockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txqtystockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txqtystockActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelSt;
    private javax.swing.JButton btEditSt;
    private javax.swing.JButton bt_save_sup;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable stockTable;
    private javax.swing.JTextField txid;
    private javax.swing.JTextField txid1;
    private javax.swing.JTextField txqtystock;
    // End of variables declaration//GEN-END:variables
}

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
public class Products extends javax.swing.JFrame {

    /**
     * Creates new form Supplier
     */
    public Products() {
        initComponents();    
        Category();
        getProductId();
         ProductSelect();
    }
    
    Connection cnct = null;
    Statement stat = null;
    ResultSet resst = null;
    PreparedStatement prepst = null;
    
    
    
    public void getProductId() {
        try {
            cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            stat = cnct.createStatement();
            resst = stat.executeQuery("select MAX(product_ID) from product");
            resst.next();
            resst.getString("MAX(product_ID)");

            if (resst.getString("MAX(product_ID)") == null) {
                txproduct_id.setText("P000000001");
            } else {
                long prodID = Long.parseLong(resst.getString("MAX(product_ID)").substring(1, resst.getString("MAX(product_ID)").length()));
                prodID++;
                txproduct_id.setText("P" + String.format("%09d", prodID));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void ProductSelect() {
        try {
            cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            stat = cnct.createStatement();
            resst = stat.executeQuery("select product_ID, product_name, supplier_name, cost, Quantity, sales_price, lead_time, unit, min_qty, category from product");
            ProdTable.setModel(DbUtils.resultSetToTableModel(resst));
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class CategoryDropB{
        String id;
        String catgr;
        
        
    
    
    public CategoryDropB(String id,String catgr){
        this.id= id;
        this.catgr=catgr;
    
}
    
    public String toString(){
        return catgr;
    }
    }
    
    public void Category(){
   
            try {
                cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                prepst = cnct.prepareStatement("select * from category");
            
            resst = prepst.executeQuery();
            dropcategory.removeAllItems();
            while(resst.next())
            {
            //dropcategory.addItem(new CategoryDropB(resst.getString(1),resst.getString(2)));
            }
            }catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }   
             
        }
    
    public class SupplierDropB{
        String supId;
        String name;
     
    
    public SupplierDropB(String supId,String name){
        this.supId= supId;
        this.name=name;    
}

        
       
    
    public String toString(){
        return name;
    }
    }
    
    public void SupplierDb(){
   try{
         cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
         stat = cnct.createStatement();
         resst = stat.executeQuery("select supplier_name from supplier");
         while(resst.next()){
             String name = resst.getString("supplier_name");
             dropsup.addItem(name);
         }
   }catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
         
           /* try {
                cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                prepst = cnct.prepareStatement("select * from supplier");
            
            resst = prepst.executeQuery();
            dropsup.removeAllItems();
            while(resst.next())
            {
            //dropsup.addItem(new SupplierDropB(resst.getString(1),resst.getString(2)));
            }
            }catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }  
             
        }*/
            
       
    
   
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
        btEditProd = new javax.swing.JButton();
        btClearProd = new javax.swing.JButton();
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
        dropcategory = new javax.swing.JComboBox();
        txminqty = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btDeleteProd = new javax.swing.JButton();
        dropsup = new javax.swing.JComboBox();
        txproduct_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

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
                "ID", "Product", "Supplier", "Cost", "Sale price", "Lead time", "Unit", "Reorder", "Category"
            }
        ));
        ProdTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProdTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 580, 450);
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

        btEditProd.setText("Edit");
        btEditProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditProdMouseClicked(evt);
            }
        });
        btEditProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditProdActionPerformed(evt);
            }
        });
        getContentPane().add(btEditProd);
        btEditProd.setBounds(710, 560, 70, 23);

        btClearProd.setText("Clear");
        btClearProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearProdMouseClicked(evt);
            }
        });
        btClearProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearProdActionPerformed(evt);
            }
        });
        getContentPane().add(btClearProd);
        btClearProd.setBounds(860, 560, 57, 23);
        getContentPane().add(txproduct_name);
        txproduct_name.setBounds(620, 220, 300, 20);

        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(620, 190, 70, 20);

        jLabel4.setText("Supplier");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(620, 250, 40, 14);
        getContentPane().add(txcost);
        txcost.setBounds(620, 320, 70, 20);

        jLabel5.setText("Cost");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(620, 300, 40, 14);

        jLabel6.setText("Category");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(620, 350, 80, 14);
        getContentPane().add(txsaleprice);
        txsaleprice.setBounds(730, 320, 70, 20);

        jLabel7.setText("Sale price");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(730, 300, 60, 14);
        getContentPane().add(txunit);
        txunit.setBounds(850, 320, 70, 20);

        jLabel8.setText("Unit");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(850, 300, 40, 14);
        getContentPane().add(txleadtime);
        txleadtime.setBounds(730, 370, 70, 20);

        jLabel9.setText("Lead time(days)");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(730, 350, 80, 14);

        getContentPane().add(dropcategory);
        dropcategory.setBounds(620, 370, 70, 22);
        getContentPane().add(txminqty);
        txminqty.setBounds(850, 370, 70, 20);

        jLabel10.setText("Min. qty");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(850, 350, 80, 14);

        btDeleteProd.setText("Delete");
        btDeleteProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDeleteProdMouseClicked(evt);
            }
        });
        btDeleteProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteProdActionPerformed(evt);
            }
        });
        getContentPane().add(btDeleteProd);
        btDeleteProd.setBounds(790, 560, 63, 23);

        getContentPane().add(dropsup);
        dropsup.setBounds(620, 270, 220, 22);
        getContentPane().add(txproduct_id);
        txproduct_id.setBounds(620, 170, 110, 20);

        jLabel11.setText("ID");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(620, 140, 50, 20);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_save_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_save_prodActionPerformed
       
      
        
    }//GEN-LAST:event_bt_save_prodActionPerformed

    private void ProdTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdTableMouseClicked
       DefaultTableModel tableProd = (DefaultTableModel)ProdTable.getModel();
        int rowIndex = ProdTable.getSelectedRow();
        txproduct_id.setText(tableProd.getValueAt(rowIndex, 0).toString());
        txproduct_name.setText(tableProd.getValueAt(rowIndex, 1).toString());
        dropsup.setSelectedItem(tableProd.getValueAt(rowIndex, 2).toString());
        txcost.setText(tableProd.getValueAt(rowIndex, 3).toString());
        txsaleprice.setText(tableProd.getValueAt(rowIndex, 4).toString());
        txleadtime.setText(tableProd.getValueAt(rowIndex, 5).toString());
        txunit.setText(tableProd.getValueAt(rowIndex, 6).toString());
        txminqty.setText(tableProd.getValueAt(rowIndex, 7).toString());
        dropcategory.setSelectedItem(tableProd.getValueAt(rowIndex, 8).toString());
        
        bt_save_prod.setEnabled(false);
    }//GEN-LAST:event_ProdTableMouseClicked

    private void btEditProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditProdActionPerformed
      
    }//GEN-LAST:event_btEditProdActionPerformed

    private void btDeleteProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteProdActionPerformed
        
    }//GEN-LAST:event_btDeleteProdActionPerformed

    private void btClearProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearProdActionPerformed
        
    }//GEN-LAST:event_btClearProdActionPerformed

    private void bt_save_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_save_prodMouseClicked
        try {
            cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            prepst = cnct.prepareStatement("insert into product values(?,?,?,?,?,?,?,?,?,?,?)");
            prepst.setString(1, txproduct_id.getText());
            prepst.setString(2, txproduct_name.getText());
            prepst.setString(3, dropsup.getSelectedItem().toString());
            prepst.setString(4, txcost.getText());
            prepst.setString(5, txsaleprice.getText());
            prepst.setString(6, txleadtime.getText());
            prepst.setString(7, txunit.getText());
            prepst.setString(8, txminqty.getText());
            prepst.setString(9, dropcategory.getSelectedItem().toString());
            

            int row = prepst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Product created sucesfully");
           
            cnct.close();
            ProductSelect();
            
            btClearProdMouseClicked(evt);

        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_save_prodMouseClicked

    private void btEditProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditProdMouseClicked
       if (txproduct_id.getText().isEmpty())/*||txproduct_name.getText().isEmpty()|| dropsup.getSelectedItem()==null|| txcost.getText().isEmpty()|| txsaleprice.getText().isEmpty()|| txleadtime.getText().isEmpty()|| txunit.getText().isEmpty()|| txminqty.getText().isEmpty()|| dropcategory.getSelectedItem()==null)*/ {
            JOptionPane.showMessageDialog(this, "Select the category to be edited");
        } else {
            try {

                cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");

                prepst = cnct.prepareStatement("update product SET product_name = ?, supplier_name = ?, cost = ?, Quantity = ?, sales_price= ?, lead_time= ?, unit= ?, min_qty= ?, category = ? where product_ID = ?");

                prepst.setString(1, txproduct_id.getText());
            prepst.setString(2, txproduct_name.getText());
            prepst.setString(3, dropsup.getSelectedItem().toString());
            prepst.setString(4, txcost.getText());
            prepst.setString(5, txsaleprice.getText());
            prepst.setString(6, txleadtime.getText());
            prepst.setString(7, txunit.getText());
            prepst.setString(8, txminqty.getText());
            prepst.setString(9, dropcategory.getSelectedItem().toString());

                int row1 = prepst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Category updated sucesfully");
                cnct.close();
                ProductSelect();
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btEditProdMouseClicked

    private void btDeleteProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteProdMouseClicked
        if (txproduct_id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select the product to be deleted");
        } else {
            try {
                cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");

                prepst = cnct.prepareStatement("Delete from product where product_ID=?");
                prepst.setString(1, txproduct_id.getText());
                prepst.execute();
                ProductSelect();
                JOptionPane.showMessageDialog(null, "Product deleted sucesfully");

            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btDeleteProdMouseClicked

    private void btClearProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearProdMouseClicked
        txproduct_id.setText("");
            txproduct_name.setText("");
            dropsup.setSelectedItem(-1);
            txcost.setText("");
            txsaleprice.setText("");
            txleadtime.setText("");
            txunit.setText("");
            txminqty.setText("");
            dropcategory.setSelectedItem(-1);
    }//GEN-LAST:event_btClearProdMouseClicked

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
    private javax.swing.JButton btClearProd;
    private javax.swing.JButton btDeleteProd;
    private javax.swing.JButton btEditProd;
    private javax.swing.JButton bt_save_prod;
    private javax.swing.JComboBox dropcategory;
    private javax.swing.JComboBox dropsup;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txproduct_id;
    private javax.swing.JTextField txproduct_name;
    private javax.swing.JTextField txsaleprice;
    private javax.swing.JTextField txunit;
    // End of variables declaration//GEN-END:variables
}

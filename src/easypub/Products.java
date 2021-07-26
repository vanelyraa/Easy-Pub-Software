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
                
                stat = cnct.createStatement();
                resst = stat.executeQuery("select * from category");
            
            
            dropcategory.removeAllItems();
            while(resst.next())
            {
           String name = resst.getString("category");
             dropcategory.addItem(name);
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
  /* try{
         cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
         stat = cnct.createStatement();
         resst = stat.executeQuery("select * from supplier");
         dropsup.removeAllItems();
         while(resst.next()){
             String name = resst.getString("supplier_name");
             dropsup.addItem(name);
         }
   }catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }
   }*/
         
            try {
                cnct = DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                prepst = cnct.prepareStatement("select * from supplier");
            
            resst = prepst.executeQuery();
            dropsup.removeAllItems();
            while(resst.next())
            {
            dropsup.addItem(new SupplierDropB(resst.getString(1),resst.getString(2)));
            }
            }catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }  
             
        }
    
    
  
	
       
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txproduct_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dropcategory = new javax.swing.JComboBox();
        txleadtime = new javax.swing.JTextField();
        txminqty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txcost = new javax.swing.JTextField();
        txsaleprice = new javax.swing.JTextField();
        txunit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dropsup = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txproduct_name = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bt_save_prod = new javax.swing.JButton();
        btEditProd = new javax.swing.JButton();
        btDeleteProd = new javax.swing.JButton();
        btClearProd = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

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

        jLabel11.setText("ID");

        jLabel2.setText("Name");

        jLabel6.setText("Category");

        jLabel9.setText("Lead time(days)");

        jLabel10.setText("Min. qty");

        jLabel5.setText("Cost");

        jLabel7.setText("Sale price");

        jLabel8.setText("Unit");

        jLabel4.setText("Supplier");

        txproduct_name.setPreferredSize(new java.awt.Dimension(7, 30));
        txproduct_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txproduct_nameActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Products");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(383, 383, 383))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_save_prod.setBackground(new java.awt.Color(0, 102, 51));
        bt_save_prod.setForeground(new java.awt.Color(204, 255, 204));
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

        btEditProd.setBackground(new java.awt.Color(0, 102, 51));
        btEditProd.setForeground(new java.awt.Color(204, 255, 204));
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

        btDeleteProd.setBackground(new java.awt.Color(0, 102, 51));
        btDeleteProd.setForeground(new java.awt.Color(204, 255, 204));
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

        btClearProd.setBackground(new java.awt.Color(0, 102, 51));
        btClearProd.setForeground(new java.awt.Color(204, 255, 204));
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

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 90, 10));

        jButton2.setBackground(new java.awt.Color(0, 102, 51));
        jButton2.setForeground(new java.awt.Color(204, 255, 204));
        jButton2.setText("jButton2");
        jPanel4.add(jButton2);

        jButton1.setBackground(new java.awt.Color(0, 102, 51));
        jButton1.setForeground(new java.awt.Color(204, 255, 204));
        jButton1.setText("jButton1");
        jPanel4.add(jButton1);

        jButton3.setBackground(new java.awt.Color(0, 102, 51));
        jButton3.setForeground(new java.awt.Color(204, 255, 204));
        jButton3.setText("jButton3");
        jPanel4.add(jButton3);

        jButton4.setBackground(new java.awt.Color(0, 102, 51));
        jButton4.setForeground(new java.awt.Color(204, 255, 204));
        jButton4.setText("jButton4");
        jPanel4.add(jButton4);

        jButton5.setBackground(new java.awt.Color(0, 102, 51));
        jButton5.setForeground(new java.awt.Color(204, 255, 204));
        jButton5.setText("jButton5");
        jPanel4.add(jButton5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(60, 60, 60))
                                    .addComponent(txproduct_id))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(80, 80, 80))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dropcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(236, 236, 236))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txproduct_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dropsup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(bt_save_prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(14, 14, 14)
                                        .addComponent(btEditProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btDeleteProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btClearProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(228, 228, 228)))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(70, 70, 70))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txsaleprice)
                                .addGap(40, 40, 40))
                            .addComponent(txcost)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(30, 30, 30))
                                    .addComponent(txunit))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txleadtime)
                                        .addGap(10, 10, 10))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txminqty))
                                .addGap(78, 78, 78))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txproduct_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dropcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txproduct_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropsup, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txunit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txleadtime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txsaleprice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txminqty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txcost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_save_prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btEditProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDeleteProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btClearProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

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

    private void txproduct_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txproduct_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txproduct_nameActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txcost;
    private javax.swing.JTextField txleadtime;
    private javax.swing.JTextField txminqty;
    private javax.swing.JTextField txproduct_id;
    private javax.swing.JTextField txproduct_name;
    private javax.swing.JTextField txsaleprice;
    private javax.swing.JTextField txunit;
    // End of variables declaration//GEN-END:variables
}

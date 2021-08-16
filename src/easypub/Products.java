/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author vanel
 * Page where user manages products
 */
public class Products extends javax.swing.JFrame {

    Connection cnct;
    Statement stat = null;
    ResultSet resst = null;
    PreparedStatement prepst = null;
    DefaultTableModel tableProd;

    public Products() {
        initComponents();
        cnct = ConnectDB.connect();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        CategoryCombo();
        SupplierCombo();
        ProductSelect();
    }

    //method to generate custom Product ID
    public void getProductId() {
        try {
            stat = cnct.createStatement();
            resst = stat.executeQuery("select MAX(product_ID) from product");
            resst.next();
            resst.getString("MAX(product_ID)");
            if (resst.getString("MAX(product_ID)") == null) {
                tfproductId.setText("P000000001");
            } else {
                long prodID = Long.parseLong(resst.getString("MAX(product_ID)").substring(1, resst.getString("MAX(product_ID)").length()));
                prodID++;
                tfproductId.setText("P" + String.format("%09d", prodID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //method to update table with database  data
    public void ProductSelect() {
        try {
            stat = cnct.createStatement();
            resst = stat.executeQuery("select product_ID, product_name, supplier_name, cost, quantity, sales_price, lead_time, unit, min_qty, serving, category from product");
            tbProduct.setModel(DbUtils.resultSetToTableModel(resst));
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //class, constructor and to string method to combobox
    public class Category {

        String id;
        String catgr;

        public Category(String id, String catgr) {
            this.id = id;
            this.catgr = catgr;
        }

        public String toString() {
            return catgr;
        }
    }

    //method to fill combobox with Categories from database
    public void CategoryCombo() {
        try {
            stat = cnct.createStatement();
            resst = stat.executeQuery("select * from category");
            cbCategory.removeAllItems();
            while (resst.next()) {
                String name = resst.getString("category_name");
                cbCategory.addItem(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class Supplier {

        String supId;
        String name;

        public Supplier(String supId, String name) {
            this.supId = supId;
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

     //method to fill combobox with Suppliers from database
    public void SupplierCombo() {
        try {
            stat = cnct.createStatement();
            resst = stat.executeQuery("select * from supplier");
            cbSupplier.removeAllItems();
            while (resst.next()) {
                String name = resst.getString("supplier_name");
                cbSupplier.addItem(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        tfproductId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox();
        tfLeadTime = new javax.swing.JTextField();
        tfMinQty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfCost = new javax.swing.JTextField();
        tfSalePrice = new javax.swing.JTextField();
        tfUnit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbSupplier = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfServing = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        jLabel11.setText("ID");

        tfproductId.setEnabled(false);

        jLabel2.setText("Name");

        jLabel6.setText("Category");

        jLabel9.setText("Lead time(days)");

        jLabel10.setText("Min. qty");

        jLabel5.setText("Cost");

        jLabel7.setText("Sale price");

        jLabel8.setText("Unit");

        jLabel4.setText("Supplier");

        tfName.setPreferredSize(new java.awt.Dimension(7, 30));

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

        btSave.setBackground(new java.awt.Color(0, 102, 51));
        btSave.setForeground(new java.awt.Color(204, 255, 204));
        btSave.setText("Save");
        btSave.setPreferredSize(new java.awt.Dimension(57, 30));
        btSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSaveMouseClicked(evt);
            }
        });

        btEdit.setBackground(new java.awt.Color(0, 102, 51));
        btEdit.setForeground(new java.awt.Color(204, 255, 204));
        btEdit.setText("Edit");
        btEdit.setPreferredSize(new java.awt.Dimension(51, 30));
        btEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditMouseClicked(evt);
            }
        });

        btDelete.setBackground(new java.awt.Color(0, 102, 51));
        btDelete.setForeground(new java.awt.Color(204, 255, 204));
        btDelete.setText("Delete");
        btDelete.setPreferredSize(new java.awt.Dimension(63, 30));
        btDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDeleteMouseClicked(evt);
            }
        });

        btClear.setBackground(new java.awt.Color(0, 102, 51));
        btClear.setForeground(new java.awt.Color(204, 255, 204));
        btClear.setText("Clear");
        btClear.setPreferredSize(new java.awt.Dimension(57, 30));
        btClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearMouseClicked(evt);
            }
        });

        jLabel12.setText("Search");

        tfSearch.setPreferredSize(new java.awt.Dimension(7, 30));
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        jLabel13.setText("Serving");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfproductId, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfLeadTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfCost, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfMinQty, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                            .addComponent(tfServing)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(189, 189, 189)
                                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, tfCost, tfLeadTime, tfMinQty, tfSalePrice, tfServing, tfUnit});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btClear, btDelete, btEdit, btSave});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfproductId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfCost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMinQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfServing, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfLeadTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbCategory, cbSupplier, jLabel10, jLabel11, jLabel13, jLabel2, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, tfCost, tfLeadTime, tfMinQty, tfName, tfSalePrice, tfServing, tfUnit, tfproductId});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btClear, btDelete, btEdit, btSave});

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        //method fill textfields with table data
        tableProd = (DefaultTableModel) tbProduct.getModel();
        int rowIndex = tbProduct.getSelectedRow();
        tfproductId.setText(tableProd.getValueAt(rowIndex, 0).toString());        
        tfName.setText(tableProd.getValueAt(rowIndex, 1).toString());
        Object comboSup = tableProd.getValueAt(rowIndex, 2);
        cbSupplier.addItem(comboSup);
        cbSupplier.setSelectedItem(comboSup);        
        tfCost.setText(tableProd.getValueAt(rowIndex, 3).toString());
        tfSalePrice.setText(tableProd.getValueAt(rowIndex, 5).toString());
        tfLeadTime.setText(tableProd.getValueAt(rowIndex, 6).toString());
        tfUnit.setText(tableProd.getValueAt(rowIndex, 7).toString());
        tfMinQty.setText(tableProd.getValueAt(rowIndex, 8).toString());
        tfServing.setText(tableProd.getValueAt(rowIndex, 9).toString());
        Object comboCat = tableProd.getValueAt(rowIndex, 10);
        cbCategory.addItem(comboCat);
        cbCategory.setSelectedItem(comboCat);         
    }//GEN-LAST:event_tbProductMouseClicked

    private void btSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveMouseClicked
        //Save info on database when button save in clicked
        if (tfName.getText().isEmpty()||cbSupplier.getSelectedItem()==null||tfCost.getText().isEmpty()||tfSalePrice.getText().isEmpty()||tfLeadTime.getText().isEmpty()||tfUnit.getText().isEmpty()||tfMinQty.getText().isEmpty()||tfServing.getText().isEmpty()||cbCategory.getSelectedItem()==null) {
            JOptionPane.showMessageDialog(this, "All fields must be filled");
        } else if (!tfproductId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product ID already exists");
        } else {
            try {
                getProductId();
                prepst = cnct.prepareStatement("insert into product (product_name, supplier_name, cost, sales_price, lead_time, unit, min_qty, serving, category) values(?,?,?,?,?,?,?,?,?,?,?)");
                prepst.setString(1, tfproductId.getText());
                prepst.setString(2, tfName.getText().toUpperCase());
                prepst.setString(3, cbSupplier.getSelectedItem().toString());
                prepst.setString(4, tfCost.getText());
                prepst.setString(5, tfSalePrice.getText());
                prepst.setString(6, tfLeadTime.getText());
                prepst.setString(7, tfUnit.getText().toUpperCase());
                prepst.setString(8, tfMinQty.getText());
                prepst.setString(9, tfServing.getText());
                prepst.setString(10, cbCategory.getSelectedItem().toString());
                int row = prepst.executeUpdate();
                ProductSelect();
                JOptionPane.showMessageDialog(this, "Product created sucesfully");
                btClearMouseClicked(evt);
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btSaveMouseClicked

    private void btEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditMouseClicked
        //save any edition made by the user to database
        if (tfproductId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select the product ID to be edited");
        } else {
            try {
                prepst = cnct.prepareStatement("update product SET product_name = ?, supplier_name = ?, cost = ?, Quantity = ?, sales_price= ?, lead_time= ?, unit= ?, min_qty= ?, category = ? where product_ID = ?");
                prepst.setString(1, tfproductId.getText());
                prepst.setString(2, tfName.getText().toUpperCase());
                prepst.setString(3, cbSupplier.getSelectedItem().toString());
                prepst.setString(4, tfCost.getText());
                prepst.setString(5, tfSalePrice.getText());
                prepst.setString(6, tfLeadTime.getText());
                prepst.setString(7, tfUnit.getText().toUpperCase());
                prepst.setString(8, tfMinQty.getText());
                 prepst.setString(9, tfServing.getText());
                prepst.setString(10, cbCategory.getSelectedItem().toString());
                int row1 = prepst.executeUpdate();
                ProductSelect();
                JOptionPane.showMessageDialog(this, "Category updated sucesfully");
                btClearMouseClicked(evt);
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btEditMouseClicked

    private void btDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteMouseClicked
        //delete info on databse when user selects an ID from table
        if (tfproductId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select the product to be deleted");
        } else {
            try {
                prepst = cnct.prepareStatement("Delete from product where product_ID=?");
                prepst.setString(1, tfproductId.getText());
                int warningDel = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Warning", JOptionPane.YES_NO_OPTION);
                if (warningDel == JOptionPane.YES_OPTION) {
                    prepst.execute();
                    ProductSelect();
                    JOptionPane.showMessageDialog(null, "Product deleted sucesfully");
                }
                btClearMouseClicked(evt);
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btDeleteMouseClicked

    private void btClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearMouseClicked
        //clear ll dtaaon textfields
        tfproductId.setText("");
        tfName.setText("");
        cbSupplier.setSelectedItem(-1);
        tfCost.setText("");
        tfSalePrice.setText("");
        tfLeadTime.setText("");
        tfUnit.setText("");
        tfMinQty.setText("");
        tfServing.setText("");
        cbCategory.setSelectedItem(-1);
    }//GEN-LAST:event_btClearMouseClicked

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        tableProd = (DefaultTableModel) tbProduct.getModel();
        TableRowSorter<DefaultTableModel> sort = new TableRowSorter<DefaultTableModel>(tableProd);
        tbProduct.setRowSorter(sort);
        sort.setRowFilter(RowFilter.regexFilter(tfSearch.getText().toUpperCase().trim()));
    }//GEN-LAST:event_tfSearchKeyReleased

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
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox cbCategory;
    private javax.swing.JComboBox cbSupplier;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField tfCost;
    private javax.swing.JTextField tfLeadTime;
    private javax.swing.JTextField tfMinQty;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSalePrice;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfServing;
    private javax.swing.JTextField tfUnit;
    private javax.swing.JTextField tfproductId;
    // End of variables declaration//GEN-END:variables
}

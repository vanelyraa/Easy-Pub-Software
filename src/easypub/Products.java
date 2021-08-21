/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.awt.event.KeyEvent;
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
 * @author vanel Page where user manages products
 */
public class Products extends javax.swing.JFrame {

    Connection cnct;
    Statement stat = null;
    ResultSet resst = null;
    PreparedStatement prepst = null;
    DefaultTableModel tableProd;
    private boolean isDot;
    

    public Products() {
        this.isDot = false;
        initComponents();
        cnct = ConnectDB.connect();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        CategoryCombo();
        SupplierCombo();
        productSelect();
        limitChar();
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
    public void productSelect() {
        try {
            stat = cnct.createStatement();
            resst = stat.executeQuery("select product_ID, product_name, supplier_name, cost, quantity, sales_price, lead_time, unit, min_qty, serving, category from product");
            tbProduct.setModel(DbUtils.resultSetToTableModel(resst));
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
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

    //limit number of char in text field according to database
    public void limitChar() {
        tfCost.setDocument(new TextFieldLength(10));
        tfSalePrice.setDocument(new TextFieldLength(10));
        tfName.setDocument(new TextFieldLength(50));
        tfLeadTime.setDocument(new TextFieldLength(100));
        tfUnit.setDocument(new TextFieldLength(4));
        tfMinQty.setDocument(new TextFieldLength(10));
        tfServing.setDocument(new TextFieldLength(5));
        tfQty.setDocument(new TextFieldLength(10));
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
        validMsg = new javax.swing.JTextField();
        tfQty = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(java.awt.Color.white);

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Supplier", "Cost", "Quantity", "Sale price", "Lead time", "Unit", "Reorder", "Serving", "Category"
            }
        ));
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        jLabel11.setText("ID");

        tfproductId.setEditable(false);

        jLabel2.setText("Name");

        tfLeadTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLeadTimeKeyTyped(evt);
            }
        });

        tfMinQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMinQtyKeyTyped(evt);
            }
        });

        jLabel6.setText("Category");

        jLabel9.setText("Lead time(days)");

        jLabel10.setText("Reorder point");

        tfCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCostKeyTyped(evt);
            }
        });

        tfSalePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSalePriceKeyTyped(evt);
            }
        });

        tfUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUnitKeyTyped(evt);
            }
        });

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

        tfServing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfServingKeyTyped(evt);
            }
        });

        validMsg.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        validMsg.setForeground(new java.awt.Color(255, 0, 0));
        validMsg.setBorder(null);

        tfQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtyKeyTyped(evt);
            }
        });

        jLabel14.setText("Quantity");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfproductId, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(334, 334, 334)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfLeadTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfCost, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(402, 402, 402)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfMinQty, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(tfServing))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfQty)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(validMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfproductId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel5)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfLeadTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfCost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfMinQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfServing, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
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
        tfQty.setText(tableProd.getValueAt(rowIndex, 4).toString());
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
        if (tfName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field Name is mandatory");
        } else if (tfCost.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field cost is mandatory");
        } else if (tfSalePrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field price is mandatory");
        } else if (tfLeadTime.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field lead time is mandatory");
        } else if (tfUnit.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field unit is mandatory");
        } else if (tfMinQty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field reorder point is mandatory");
        } else if (tfServing.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field serving is mandatory");
        } else if (tfQty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field quantity is mandatory");
        } else if (!tfproductId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product ID already exists");
        } else {
            try {
                getProductId();
                prepst = cnct.prepareStatement("insert into product (product_ID, product_name,supplier_name, cost, quantity, sales_price, lead_time, unit, min_qty, serving, category) values(?,?,?,?,?,?,?,?,?,?,?)");
                prepst.setString(1, tfproductId.getText());
                prepst.setString(2, tfName.getText().toUpperCase());
                prepst.setString(3, cbSupplier.getSelectedItem().toString());
                prepst.setString(4, tfCost.getText());
                prepst.setString(5, tfQty.getText());
                prepst.setString(6, tfSalePrice.getText());
                prepst.setString(7, tfLeadTime.getText());
                prepst.setString(8, tfUnit.getText().toUpperCase());
                prepst.setString(9, tfMinQty.getText());
                prepst.setString(10, tfServing.getText());
                prepst.setString(11, cbCategory.getSelectedItem().toString());
                int row = prepst.executeUpdate();
                productSelect();
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
                
                prepst.setString(1, tfName.getText().toUpperCase());
                prepst.setString(2, cbSupplier.getSelectedItem().toString());
                prepst.setString(3, tfCost.getText());
                prepst.setString(4, tfSalePrice.getText());
                prepst.setString(5, tfLeadTime.getText());
                prepst.setString(6, tfUnit.getText().toUpperCase());
                prepst.setString(7, tfMinQty.getText());
                prepst.setString(8, tfServing.getText());
                prepst.setString(9, cbCategory.getSelectedItem().toString());
                prepst.setString(10, tfproductId.getText());
                int row1 = prepst.executeUpdate();
                productSelect();
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
                    productSelect();
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
        tfCost.setText("");
        tfSalePrice.setText("");
        tfLeadTime.setText("");
        tfUnit.setText("");
        tfMinQty.setText("");
        tfServing.setText("");
        tfQty.setText("");
    }//GEN-LAST:event_btClearMouseClicked

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        tableProd = (DefaultTableModel) tbProduct.getModel();
        TableRowSorter<DefaultTableModel> sort = new TableRowSorter<>(tableProd);
        tbProduct.setRowSorter(sort);
        sort.setRowFilter(RowFilter.regexFilter(tfSearch.getText().toUpperCase().trim()));
    }//GEN-LAST:event_tfSearchKeyReleased

    //textfield validations
    private void tfLeadTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLeadTimeKeyTyped
        char valid = evt.getKeyChar();
        if (!Character.isDigit(valid) || (valid == KeyEvent.VK_BACK_SPACE) || valid == KeyEvent.VK_DELETE) {
            evt.consume();
            validMsg.setText("Numbers only");
        } else {
            validMsg.setText(null);
        }
    }//GEN-LAST:event_tfLeadTimeKeyTyped

    private void tfMinQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMinQtyKeyTyped
        char valid = evt.getKeyChar();
        if (!Character.isDigit(valid) || (valid == KeyEvent.VK_BACK_SPACE) || valid == KeyEvent.VK_DELETE) {
            evt.consume();
            validMsg.setText("Numbers only");
        } else {
            validMsg.setText(null);
        }
    }//GEN-LAST:event_tfMinQtyKeyTyped

    private void tfServingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfServingKeyTyped
        char valid = evt.getKeyChar();
        if (!Character.isDigit(valid) || (valid == KeyEvent.VK_BACK_SPACE) || valid == KeyEvent.VK_DELETE) {
            evt.consume();
            validMsg.setText("Numbers only");
        } else {
            validMsg.setText(null);
        }
    }//GEN-LAST:event_tfServingKeyTyped

    private void tfUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUnitKeyTyped
        char valid = evt.getKeyChar();
        if (!Character.isLetter(valid) || (valid == KeyEvent.VK_BACK_SPACE) || valid == KeyEvent.VK_DELETE) {
            evt.consume();
            validMsg.setText("Letters only");
        } else {
            validMsg.setText(null);
        }
    }//GEN-LAST:event_tfUnitKeyTyped

    private void tfSalePriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSalePriceKeyTyped
        char isPrice = evt.getKeyChar();
        if ((Character.isDigit(isPrice)) || (isPrice == KeyEvent.VK_PERIOD) || (isPrice == KeyEvent.VK_BACK_SPACE)) {
            int isDot = 0;
            if (isPrice == KeyEvent.VK_PERIOD) {
                String s = tfSalePrice.getText();
                int Adot = s.indexOf('.');
                isDot = Adot;
                if (Adot != -1) {
                    getToolkit().beep();
                     validMsg.setText(null);
                    evt.consume();
                }
            }
        } else {
            getToolkit().beep();
            validMsg.setText("Invalid pricing format");
            evt.consume();
        }
    }//GEN-LAST:event_tfSalePriceKeyTyped

    private void tfCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCostKeyTyped
        char isPrice = evt.getKeyChar();
        if ((Character.isDigit(isPrice)) || (isPrice == KeyEvent.VK_PERIOD) || (isPrice == KeyEvent.VK_BACK_SPACE)) {
            int isDot = 0;
            if (isPrice == KeyEvent.VK_PERIOD) {
                String s = tfSalePrice.getText();
                int Adot = s.indexOf('.');
                isDot = Adot;
                if (Adot != -1) {
                    getToolkit().beep();
                    validMsg.setText(null);
                    evt.consume();
                }
            }
        } else {
            getToolkit().beep();
            validMsg.setText("Invalid pricing format");
            evt.consume();
        }
    }//GEN-LAST:event_tfCostKeyTyped

    private void tfQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyTyped
        char valid = evt.getKeyChar();
        if (!Character.isDigit(valid) || (valid == KeyEvent.VK_BACK_SPACE) || valid == KeyEvent.VK_DELETE) {
            evt.consume();
            validMsg.setText("Numbers only");
        } else {
            validMsg.setText(null);
        }
    }//GEN-LAST:event_tfQtyKeyTyped

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
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField tfQty;
    private javax.swing.JTextField tfSalePrice;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfServing;
    private javax.swing.JTextField tfUnit;
    private javax.swing.JTextField tfproductId;
    private javax.swing.JTextField validMsg;
    // End of variables declaration//GEN-END:variables
}

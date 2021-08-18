/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author vanel Page where users record sales in real time
 */
public class Sale extends javax.swing.JFrame {

    Connection cnct;
    Statement stat = null;
    ResultSet resst = null;
    PreparedStatement prepst = null;
    DefaultTableModel saleTable;

    public Sale() {
        initComponents();
        cnct = ConnectDB.connect();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ProductComboBox();
        AutoCompleteDecorator.decorate(cbProduct);
    }

    //retrieves data from database to fill combobox
    public void ProductComboBox() {

        try {
            stat = cnct.createStatement();
            resst = stat.executeQuery("select * from product");

            cbProduct.removeAllItems();
            while (resst.next()) {
                String name = resst.getString("product_name");
                cbProduct.addItem(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //fill table with info selected by the user
    public void fillTable() {
        if (tfQty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field quantity is mandatory");
        } else {
            try {
                int actQty = resst.getInt("quantity");
                String prod = (cbProduct.getSelectedItem().toString());
                double price = Double.valueOf(tfPrice.getText());
                int qty = Integer.parseInt(tfQty.getText());
                double total = qty * price;

                if (qty >= actQty) {
                    JOptionPane.showMessageDialog(this, "Not enough quantity, available: " + actQty);
                } else {
                    saleTable = (DefaultTableModel) tbSale.getModel();
                    saleTable.addRow(new Object[]{
                        cbProduct.getSelectedItem(),
                        tfPrice.getText(),
                        tfQty.getText(),
                        total,});
                    double sum = 0;

                    for (int i = 0; i < tbSale.getRowCount(); i++) {
                        sum = sum + Double.valueOf(tbSale.getValueAt(i, 3).toString());
                    }
                    tfTotal.setText(String.valueOf(sum));
                    tfPrice.setText("");
                    tfQty.setText("");
                    cbProduct.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //method to add data to database
    //inserts data to sale table, sale_item table and updates product quantity
    public void add() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String today = dtf.format(now);

        String tot = tfTotal.getText();
        int saleID = 0;
        try {
            String query = "insert into sale(date, total) values(?,?)";
            prepst = cnct.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepst.setString(1, today);
            prepst.setString(2, tot);

            prepst.executeUpdate();
            ResultSet resst1 = prepst.getGeneratedKeys();

            if (resst1.next()) {
                saleID = resst1.getInt(1);
            }
            int rows = tbSale.getRowCount();
            for (int i = 0; i < tbSale.getRowCount(); i++) {
                String prodName = (String) tbSale.getValueAt(i, 0);
                String price = (String) tbSale.getValueAt(i, 1);
                String qty = (String) tbSale.getValueAt(i, 2);
                Double total = (Double) tbSale.getValueAt(i, 3);

                String query1 = "INSERT INTO sale_item(sale_ID, product_name, sales_price, quantity, total) VALUES (?,?,?,?,?)";
                prepst = cnct.prepareStatement(query1);

                prepst.setInt(1, saleID);
                prepst.setString(2, prodName);
                prepst.setString(3, price);
                prepst.setString(4, qty);
                prepst.setDouble(5, total);
                prepst.executeUpdate();
                prepst.addBatch();
            }

            for (int i = 0; i < tbSale.getRowCount(); i++) {
                String prodName = (String) tbSale.getValueAt(i, 0);
                String qty = (String) tbSale.getValueAt(i, 2);

                String serve = tfServing.getText();
                long qtyNew = Long.valueOf(qty) + Long.valueOf(serve);

                String query2 = "update product set quantity = quantity+ ? where product_name = ?";
                prepst = cnct.prepareStatement(query2);

                prepst.setLong(1, qtyNew);
                prepst.setString(2, prodName);
                prepst.execute();
            }
            JOptionPane.showMessageDialog(this, "Sale completed");
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //method to print receipt
    public void printReceipt() {
        Double tot = Double.valueOf(tfTotal.getText());
        new Receipt(tot, tbSale.getModel()).setVisible(true);
    }

    public void limitChar() {
        tfQty.setDocument(new TextFieldLength(10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cbProduct = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfPrice = new javax.swing.JTextField();
        tfQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btPay = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btClear = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        tfServing = new javax.swing.JTextField();
        validMsg = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(java.awt.Color.white);

        cbProduct.setEditable(true);
        cbProduct.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cbProduct.setSelectedIndex(-1);
        cbProduct.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbProductPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Product");

        tfPrice.setEditable(false);
        tfPrice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        tfQty.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tfQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtyKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Price");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Quantity");

        btPay.setBackground(new java.awt.Color(0, 102, 51));
        btPay.setForeground(new java.awt.Color(204, 255, 204));
        btPay.setText("PAY");
        btPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPayActionPerformed(evt);
            }
        });

        btPrint.setBackground(new java.awt.Color(0, 102, 51));
        btPrint.setForeground(new java.awt.Color(204, 255, 204));
        btPrint.setText("Print");
        btPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Total");

        tfTotal.setEditable(false);
        tfTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        tbSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Price", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbSale);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Point of Sale");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btClear.setBackground(new java.awt.Color(0, 102, 51));
        btClear.setForeground(new java.awt.Color(204, 255, 204));
        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btRemove.setBackground(new java.awt.Color(0, 102, 51));
        btRemove.setForeground(new java.awt.Color(204, 255, 204));
        btRemove.setText("Remove");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });

        btAdd.setBackground(new java.awt.Color(0, 102, 51));
        btAdd.setForeground(new java.awt.Color(204, 255, 204));
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        tfServing.setEditable(false);
        tfServing.setBackground(java.awt.Color.white);
        tfServing.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        tfServing.setForeground(java.awt.Color.white);
        tfServing.setBorder(null);

        validMsg.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        validMsg.setForeground(new java.awt.Color(255, 0, 0));
        validMsg.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(tfServing, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(validMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btPay, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(tfServing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPay, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPayActionPerformed
        add();
    }//GEN-LAST:event_btPayActionPerformed

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        printReceipt();
    }//GEN-LAST:event_btPrintActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        //button clear table data
        saleTable = (DefaultTableModel) tbSale.getModel();
        saleTable.setRowCount(0);
        tfTotal.setText("");
    }//GEN-LAST:event_btClearActionPerformed

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed
        //remove selected item from table and recalculate total
        saleTable = (DefaultTableModel) tbSale.getModel();
        int row = tbSale.getSelectedRow();
        saleTable.removeRow(row);
        Double sum = 0.0;
        for (int i = 0; i < tbSale.getRowCount(); i++) {
            sum = sum + Double.valueOf(tbSale.getValueAt(i, 3).toString());
        }
        tfTotal.setText(Double.toString(sum));
    }//GEN-LAST:event_btRemoveActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        fillTable();
        tfPrice.setText("");
        tfQty.setText("");
    }//GEN-LAST:event_btAddActionPerformed

    private void cbProductPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbProductPopupMenuWillBecomeInvisible
        //fill textfield after jcombo selection
        try {
            String getProd = (String) cbProduct.getSelectedItem();
            prepst = cnct.prepareStatement("select * from product where product_name = ?");
            prepst.setString(1, getProd);
            resst = prepst.executeQuery();
            if (resst.next()) {
                tfPrice.setText(resst.getString("sales_price"));
                tfServing.setText(resst.getString("serving"));
                tfQty.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbProductPopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btPay;
    private javax.swing.JButton btPrint;
    private javax.swing.JButton btRemove;
    private javax.swing.JComboBox<String> cbProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSale;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQty;
    private javax.swing.JTextField tfServing;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField validMsg;
    // End of variables declaration//GEN-END:variables
}

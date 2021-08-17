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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
 * Area where user manages stock
 */
public class Stock extends javax.swing.JFrame {

    Connection cnct;
    Statement stat = null;
    ResultSet resst = null;
    PreparedStatement prepst = null;
    DefaultTableModel StockTable;

    public Stock() {
        initComponents();
        cnct = ConnectDB.connect();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        StockSelect();
    }

    //method to update table with database  data
    public void StockSelect() {
        try {
            stat = cnct.createStatement();
            resst = stat.executeQuery("select product_ID, product_name, quantity from product");
            tbStock.setModel(DbUtils.resultSetToTableModel(resst));
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btUpdate = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        tfQty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbTransaction = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tfProdId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfActQty = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfProduct = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStock = new javax.swing.JTable();
        validMsg = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setText("Search");

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        btUpdate.setBackground(new java.awt.Color(0, 102, 51));
        btUpdate.setForeground(new java.awt.Color(204, 255, 204));
        btUpdate.setText("Update");
        btUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpdateMouseClicked(evt);
            }
        });

        btClear.setBackground(new java.awt.Color(0, 102, 51));
        btClear.setForeground(new java.awt.Color(204, 255, 204));
        btClear.setText("Clear");
        btClear.setActionCommand("Clear data");
        btClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearMouseClicked(evt);
            }
        });

        tfQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtyKeyTyped(evt);
            }
        });

        jLabel6.setText("Quantity");

        cbTransaction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "goods receipt", "void", "waste" }));

        jLabel4.setText("Transaction type");

        tfProdId.setEnabled(false);

        jLabel7.setText("ID");

        jLabel2.setText("Product");

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Stock");
        jPanel2.add(jLabel3);

        tfActQty.setEnabled(false);

        jLabel8.setText("Actual quantity");

        tfProduct.setEnabled(false);

        tbStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product_ID", "Product", "Quantity"
            }
        ));
        tbStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbStock);

        validMsg.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        validMsg.setForeground(new java.awt.Color(255, 0, 0));
        validMsg.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btUpdate)
                                    .addGap(18, 18, 18)
                                    .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(validMsg)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfQty, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                    .addGap(34, 34, 34)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfActQty, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))))
                            .addComponent(tfProduct)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btClear, btUpdate});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(validMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfActQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btClear)
                            .addComponent(btUpdate))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btClear, btUpdate});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbTransaction, tfActQty, tfProdId, tfProduct, tfQty, tfSearch});

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateMouseClicked
        //method updates stock when update button is pressed
        //update stock and product table in database
        int qty = Integer.parseInt(tfQty.getText());
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String today = dtf.format(now);
            prepst = cnct.prepareStatement("insert into stock values(?,?,?,?)");

            prepst.setString(1, today);
            prepst.setString(2, tfProduct.getText());
            prepst.setString(3, cbTransaction.getSelectedItem().toString());
            prepst.setString(4, tfQty.getText());

            int row = prepst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Stock updated sucesfully");

            String prodID = tfProdId.getText();
            String qtyNew = tfQty.getText();
            String actQty = tfActQty.getText();
            String transac = cbTransaction.getSelectedItem().toString();
            
            if(transac.equals("goods receipt")){
            long totQty = Long.valueOf(qtyNew) + Long.valueOf(actQty);
             stat = cnct.createStatement();
            stat.execute("insert into stock (date,product_ID, transaction,quantity)" + "values('" + today + "','" + prodID + "','" + transac + "','" + totQty + "')");
            stat.execute("update product set quantity='" + totQty + "' where product_ID='" + prodID + "'");
            stat.close();

            StockSelect();
            btClearMouseClicked(evt);
            }else{
             long totQty = Long.valueOf(actQty) - Long.valueOf(qtyNew);   
            
            stat = cnct.createStatement();
            stat.execute("insert into stock (date,product_ID, transaction,quantity)" + "values('" + today + "','" + prodID + "','" + transac + "','" + totQty + "')");
            stat.execute("update product set quantity='" + totQty + "' where product_ID='" + prodID + "'");
            stat.close();

            StockSelect();
            btClearMouseClicked(evt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btUpdateMouseClicked

    private void btClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearMouseClicked
       //clear info from textfields when button clicked
        tfProdId.setText("");
        tfProduct.setText("");
        cbTransaction.setSelectedItem(-1);
        tfActQty.setText("");
        tfQty.setText("");
    }//GEN-LAST:event_btClearMouseClicked

    private void tbStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStockMouseClicked
        //fill textfields when table is clicked
        StockTable = (DefaultTableModel) tbStock.getModel();
        int rowIndex = tbStock.getSelectedRow();
        tfProdId.setText(tbStock.getValueAt(rowIndex, 0).toString());
        tfProduct.setText(tbStock.getValueAt(rowIndex, 1).toString());
        tfActQty.setText(tbStock.getValueAt(rowIndex, 2).toString());
    }//GEN-LAST:event_tbStockMouseClicked

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        //field searches user input throught table
        StockTable = (DefaultTableModel) tbStock.getModel();
        TableRowSorter<DefaultTableModel> sort = new TableRowSorter<>(StockTable);
        tbStock.setRowSorter(sort);
        sort.setRowFilter(RowFilter.regexFilter(tfSearch.getText().toUpperCase().trim()));
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tfQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyTyped
        char valid = evt.getKeyChar();
       if(!Character.isDigit(valid)||(valid==KeyEvent.VK_BACK_SPACE)||valid==KeyEvent.VK_DELETE){
           evt.consume();
           validMsg.setText("Numbers only");
       } else{
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
    private javax.swing.JButton btClear;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cbTransaction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbStock;
    private javax.swing.JTextField tfActQty;
    private javax.swing.JTextField tfProdId;
    private javax.swing.JTextField tfProduct;
    private javax.swing.JTextField tfQty;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField validMsg;
    // End of variables declaration//GEN-END:variables
}

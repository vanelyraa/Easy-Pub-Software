/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
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
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author vanel
 */
public class Sale extends javax.swing.JFrame {

    /**
     * Creates new form Sale
     */
    public Sale() {
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ProductComboBox();
        AutoCompleteDecorator.decorate(comboprod);
    }
    
    Connection cnct = null;
    Statement stat = null;
    ResultSet resst = null;
    PreparedStatement prepst = null;
    DefaultTableModel model;
    
    
    
    
    
    
    public void ProductComboBox(){
   
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
             
        }
    
   
    
    public void fillTable(){
        String prod = (comboprod.getSelectedItem().toString());
        int price = Integer.parseInt(txPrice.getText());
        int qty = Integer.parseInt(txQty.getText());
        int total = qty * price;

            model = (DefaultTableModel)tableSale.getModel();
             model.addRow(new Object[]
                    {
    
                        comboprod.getSelectedItem(),
                        txPrice.getText(),
                        txQty.getText(),
                        total, 
                    });
             
             
            
            int sum = 0;
            
             for(int i = 0; i<tableSale.getRowCount(); i++)
        {
            sum = sum + Integer.parseInt(tableSale.getValueAt(i, 3).toString());
        }
        
        totSale.setText(Integer.toString(sum));
        
        comboprod.setSelectedItem(-1);
        txPrice.setText("");
        txQty.setText("");
        comboprod.requestFocus();
    }
    
    public void add(){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String today = dtf.format(now);
            
            String tot = totSale.getText();
            String cash = cashSale.getText();
            String change = changeSale.getText();
            int saleID = 0;
            
            
            prepst = cnct.prepareStatement("insert into sale(date, total, cash) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
        prepst.setString(1, today);
            prepst.setString(2, totSale.getText());
            prepst.setString(3, cashSale.getText());
            prepst.executeUpdate();
            resst = prepst.getGeneratedKeys();
            
            if(resst.next()){
                saleID = resst.getInt(1);
            }
           
            PreparedStatement prepst1 = cnct.prepareStatement("insert into sale_item(date, sale_id, product_name, sales_price, quantity, total), values(?,?,?,?,?,?)");
        
            String prodName="";
            String price="";
            String qty="";
            int total=0;
            
            for (int i=0; i<tableSale.getRowCount(); i++){
              prodName = (String)tableSale.getValueAt(i,0);
              price = (String)tableSale.getValueAt(i,1);
              qty = (String)tableSale.getValueAt(i,2);
              total = (int)tableSale.getValueAt(i,3);
            }
            prepst1.setString(1,today);
            prepst1.setInt(2,saleID);
             prepst1.setString(3,prodName);
              prepst1.setString(4,price);
               prepst1.setString(5,qty);
                prepst1.setInt(6,total);
            prepst1.executeUpdate();
            
            PreparedStatement prepst2 = cnct.prepareStatement("uupdate product set quantity = quantity+ ? where product_name = ?");
        
            for (int i=0; i<tableSale.getRowCount(); i++){
              prodName = (String)tableSale.getValueAt(i,0);
              
              qty = (String)tableSale.getValueAt(i,2);
              
              
               prepst2.setString(1,qty);
               prepst2.setString(2,prodName);
                prepst2.executeUpdate();
                 prepst1.executeUpdate();
            }
                    
           JOptionPane.showMessageDialog(this, "Sale completed");         
                          
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void printReceipt(){
        String tot = totSale.getText();
            String cash = cashSale.getText();
           
            
        new Receipt(tot,cash,tableSale.getModel()).setVisible(true);
    }
        
    
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        comboprod = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txPrice = new javax.swing.JTextField();
        txQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btCash = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        changeSale = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cashSale = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        totSale = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSale = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(java.awt.Color.white);

        comboprod.setEditable(true);
        comboprod.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        comboprod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboprod.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboprodPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboprodActionPerformed(evt);
            }
        });
        comboprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboprodKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Product");

        txPrice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        txQty.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txQtyActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Price");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Quantity");

        btCash.setBackground(new java.awt.Color(0, 102, 51));
        btCash.setForeground(new java.awt.Color(204, 255, 204));
        btCash.setText("PAY");
        btCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCashActionPerformed(evt);
            }
        });

        print.setBackground(new java.awt.Color(0, 102, 51));
        print.setForeground(new java.awt.Color(204, 255, 204));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Change");

        changeSale.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Cash");

        cashSale.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cashSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashSaleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Total");

        totSale.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        totSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totSaleActionPerformed(evt);
            }
        });

        tableSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        tableSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSaleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSale);

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

        clear.setBackground(new java.awt.Color(0, 102, 51));
        clear.setForeground(new java.awt.Color(204, 255, 204));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        remove.setBackground(new java.awt.Color(0, 102, 51));
        remove.setForeground(new java.awt.Color(204, 255, 204));
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(0, 102, 51));
        add.setForeground(new java.awt.Color(204, 255, 204));
        add.setText("add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboprod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(totSale, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txQty, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeSale, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cashSale, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btCash, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCash, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cashSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSaleMouseClicked
       
    }//GEN-LAST:event_tableSaleMouseClicked

    private void btCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCashActionPerformed

        int cash = Integer.parseInt(cashSale.getText());
        int total = Integer.parseInt(totSale.getText());
        int change = Integer.parseInt(changeSale.getText());
         change  = total-cash;
        
         cashSale.setText(String.valueOf(change));
        add();       
        
        
        
    }//GEN-LAST:event_btCashActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
       printReceipt();
    }//GEN-LAST:event_printActionPerformed

    private void comboprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboprodKeyReleased
       
      
    }//GEN-LAST:event_comboprodKeyReleased

    private void totSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totSaleActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        model = (DefaultTableModel)tableSale.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_clearActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        try{
            model = (DefaultTableModel)tableSale.getModel();
            int row = tableSale.getSelectedRow();
            model.removeRow(row);
        }catch(Exception ex){
        }
        
    }//GEN-LAST:event_removeActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        fillTable();
         comboprod.setSelectedItem(-1);
        txPrice.setText("");
        txQty.setText("");
    }//GEN-LAST:event_addActionPerformed

    private void comboprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboprodActionPerformed
     
    }//GEN-LAST:event_comboprodActionPerformed

    private void cashSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashSaleActionPerformed

    private void txQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txQtyActionPerformed

    private void comboprodPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboprodPopupMenuWillBecomeInvisible
       try{
            String getProd = (String)comboprod.getSelectedItem();
                       
             prepst = cnct.prepareStatement("select * from product where product_name = ?");
            prepst.setString(1,getProd);
            resst = prepst.executeQuery();
            
            if(resst.next()){
            
            txPrice.setText( resst.getString("sales_price"));
            txQty.requestFocus();
            }
            
        
    }   catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboprodPopupMenuWillBecomeInvisible

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
    private javax.swing.JButton add;
    private javax.swing.JButton btCash;
    private javax.swing.JTextField cashSale;
    private javax.swing.JTextField changeSale;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> comboprod;
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
    private javax.swing.JButton print;
    private javax.swing.JButton remove;
    private javax.swing.JTable tableSale;
    private javax.swing.JTextField totSale;
    private javax.swing.JTextField txPrice;
    private javax.swing.JTextField txQty;
    // End of variables declaration//GEN-END:variables
}

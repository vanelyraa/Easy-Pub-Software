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

/**
 *
 * @author vanel
 */
public class Others extends javax.swing.JFrame {

    /**
     * Creates new form Others
     */
    
    int createId;
    public Others() {
        initComponents();
        getUserId();
        CategorySelect();
       
    }
    
    Connection cnct = null;
    Statement stat = null;
    ResultSet resst = null;
    
    public void getUserId(){
        try{
            cnct= DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            stat = cnct.createStatement();
            resst = stat.executeQuery("select MAX(user) from login");
        resst.next();
        resst.getString("MAX(user)");
        
        if(resst.getString("MAX(user)")== null){
            txUseuId.setText("U001");
        }else{
            long userID = Long.parseLong(resst.getString("MAX(user)").substring(1,resst.getString("MAX(user)").length()));
        userID++;
        txUseuId.setText("U"+ String.format("%03d", userID));
        }
           
    }   catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
     public void getCatId(){
        try{
            cnct= DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            stat = cnct.createStatement();
            resst = stat.executeQuery("select MAX(category_ID) from category");
        resst.next();
        resst.getString("MAX(category_ID)");
        
        if(resst.getString("MAX(category_ID)")== null){
            txUseuId.setText("C01");
        }else{
            long userID = Long.parseLong(resst.getString("MAX(category_ID)").substring(1,resst.getString("MAX(category_ID)").length()));
        userID++;
        txUseuId.setText("C"+ String.format("%02d", userID));
        }
           
    }   catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
     
     public void CategorySelect(){
        try {
            cnct= DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            stat = cnct.createStatement();
            resst = stat.executeQuery("select * from category");
            CatTable.setModel(DbUtils.resultSetTotableModel(resst));
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        btGenRep = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txusername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txpassword = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btCreateU = new javax.swing.JButton();
        textField1 = new java.awt.TextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txcategory = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CatTable = new javax.swing.JTable();
        btAddCat = new javax.swing.JButton();
        btEditCat = new javax.swing.JButton();
        btDelCat = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txlname = new javax.swing.JTextField();
        txemail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txUseuId = new javax.swing.JLabel();
        txCatId = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Categories");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(600, 290, 260, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("Users");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 20, 130, 50);

        filler1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(filler1);
        filler1.setBounds(215, 96, 0, 100);

        btGenRep.setText("Generate");
        getContentPane().add(btGenRep);
        btGenRep.setBounds(520, 230, 77, 23);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(520, 130, 380, 20);

        jLabel4.setText("Type");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(520, 110, 24, 14);

        jLabel5.setText("Dates");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(520, 170, 40, 14);

        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(470, 20, 10, 560);

        jLabel3.setText("Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 170, 40, 14);
        getContentPane().add(txusername);
        txusername.setBounds(60, 190, 350, 20);

        jLabel6.setText("Email");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 270, 24, 14);
        getContentPane().add(txpassword);
        txpassword.setBounds(60, 340, 110, 20);

        jLabel7.setText("Password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 320, 46, 14);

        jLabel8.setText("Confirm password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 370, 110, 14);

        btCreateU.setText("Create");
        btCreateU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCreateUMouseClicked(evt);
            }
        });
        btCreateU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateUActionPerformed(evt);
            }
        });
        getContentPane().add(btCreateU);
        btCreateU.setBounds(60, 430, 65, 23);

        textField1.setText("textField1");
        getContentPane().add(textField1);
        textField1.setBounds(520, 190, 60, 20);

        jPasswordField2.setText("jPasswordField2");
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(60, 390, 112, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel9.setText("Reports");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(630, 20, 190, 60);

        jLabel10.setText("New category");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(520, 430, 80, 14);
        getContentPane().add(txcategory);
        txcategory.setBounds(520, 450, 110, 20);

        CatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Category_ID", "Name"
            }
        ));
        CatTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CatTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CatTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(670, 380, 230, 140);

        btAddCat.setText("Add");
        btAddCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddCatMouseClicked(evt);
            }
        });
        btAddCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddCatActionPerformed(evt);
            }
        });
        getContentPane().add(btAddCat);
        btAddCat.setBounds(520, 550, 70, 23);

        btEditCat.setText("Edit");
        btEditCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditCatMouseClicked(evt);
            }
        });
        btEditCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditCatActionPerformed(evt);
            }
        });
        getContentPane().add(btEditCat);
        btEditCat.setBounds(600, 550, 73, 23);

        btDelCat.setText("Delete");
        btDelCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDelCatMouseClicked(evt);
            }
        });
        getContentPane().add(btDelCat);
        btDelCat.setBounds(680, 550, 70, 23);

        jLabel11.setText("Last name");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(60, 220, 60, 14);
        getContentPane().add(txlname);
        txlname.setBounds(60, 240, 350, 20);
        getContentPane().add(txemail);
        txemail.setBounds(60, 290, 350, 20);

        jLabel12.setText("User ID");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(60, 120, 40, 14);

        txUseuId.setText("ID number");
        getContentPane().add(txUseuId);
        txUseuId.setBounds(60, 140, 130, 14);

        txCatId.setText("Category ID");
        txCatId.setEnabled(false);
        getContentPane().add(txCatId);
        txCatId.setBounds(520, 400, 80, 14);

        jLabel14.setText("Category ID");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(520, 380, 80, 14);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void btCreateUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateUActionPerformed
        
    }//GEN-LAST:event_btCreateUActionPerformed

    private void btAddCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddCatActionPerformed
        
           
        
    }//GEN-LAST:event_btAddCatActionPerformed

    private void btEditCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditCatActionPerformed
        
    }//GEN-LAST:event_btEditCatActionPerformed

    private void btDelCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDelCatMouseClicked
        if(txcategory.getText().isEmpty()){
          JOptionPane.showMessageDialog(this, "Select the category to be deleted");    
        }else{
            try{
                cnct= DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
                String catg = txcategory.getText();
                Statement delete =  cnct.createStatement();
                delete.executeUpdate("Delete from easypubdatabase.category where category="+catg);
                CategorySelect();
                JOptionPane.showMessageDialog(null, "Category deleted sucesfully"); 
                
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btDelCatMouseClicked

    private void btCreateUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCreateUMouseClicked
       try{
           cnct= DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
           PreparedStatement create = cnct.prepareStatement("insert into login values(?,?,?,?,?)");
           create.setString(1,txUseuId.getText());
           create.setString(2,txpassword.getText());
           create.setString(3,txusername.getText());
           create.setString(4,txlname.getText());
           create.setString(5,txemail.getText());
           
           create.executeUpdate();
           JOptionPane.showMessageDialog(this, "User created sucesfully"); 
           //getUserId();
           cnct.close();
           
       } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btCreateUMouseClicked

    private void btAddCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddCatMouseClicked
         try {
            
            cnct= DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
           PreparedStatement add = cnct.prepareStatement("insert into category values(?)");
           add.setString(1,txCatId.getText()); 
           add.setString(2,txcategory.getText());
                    int row = add.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "New category registered"); 
            cnct.close();
            CategorySelect();
           
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddCatMouseClicked

    private void CatTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CatTableMouseClicked
        DefaultTableModel tableCat = (DefaultTableModel)CatTable.getModel();
        int rowIndex = CatTable.getSelectedRow();
        txCatId.setText(tableCat.getValueAt(rowIndex, 0).toString());
        txcategory.setText(tableCat.getValueAt(rowIndex, 1).toString());
    }//GEN-LAST:event_CatTableMouseClicked

    private void btEditCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditCatMouseClicked
          if (txcategory.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Select the category to be deleted"); 
    }else{
            try{
                cnct= DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
             PreparedStatement edit = cnct.prepareStatement("update easypubdatabase.category set category_ID='"+txCatId.getText()+"'"+",category="+txcategory.getText());
            create.executeUpdate(updateQuery);
            JOptionPane.showMessageDialog(this, "User created sucesfully"); 
            } catch (SQLException ex) {
               Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_btEditCatMouseClicked

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
            java.util.logging.Logger.getLogger(Others.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Others.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Others.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Others.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Others().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CatTable;
    private javax.swing.JButton btAddCat;
    private javax.swing.JButton btCreateU;
    private javax.swing.JButton btDelCat;
    private javax.swing.JButton btEditCat;
    private javax.swing.JButton btGenRep;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.TextField textField1;
    private javax.swing.JLabel txCatId;
    private javax.swing.JLabel txUseuId;
    private javax.swing.JTextField txcategory;
    private javax.swing.JTextField txemail;
    private javax.swing.JTextField txlname;
    private javax.swing.JTextField txpassword;
    private javax.swing.JTextField txusername;
    // End of variables declaration//GEN-END:variables

    private void registerUser(String uName, String lName, String email, String uPassword) {
        Connection conDb = DtbConnect.connectDtb();
        if(conDb != null){
        try {            
            PreparedStatement pst = (PreparedStatement)
                    conDb.prepareStatement("INSERT INTO login (name, lastname, email, password) VALUES (?,?,?,?)");
            
            pst.setString(1, uName);
            pst.setString(2, lName);
            pst.setString(3, email);
            pst.setString(4, uPassword);
            int rss=pst.executeUpdate();
           
                JOptionPane.showMessageDialog(this, "New user registered","Sucess",JOptionPane.ERROR_MESSAGE);
            
            txusername.setText("");
            txlname.setText("");
            txemail.setText("");
            txpassword.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
                System.out.println("The connection is not available");
                }
    }
}

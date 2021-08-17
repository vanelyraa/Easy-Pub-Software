/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author vanel
 * Page where new users can be created and reports generated
 */

public class Others extends javax.swing.JFrame {

    int createId;
    Connection cnct;
    Statement stat = null;
    ResultSet resst = null;
    PreparedStatement prepst = null;

    public Others() {
        initComponents();
        cnct = ConnectDB.connect();
        setResizable(false);       
        SaleSelect();
        limitChar();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }   

    //retrieve data from database to jtable
    public void SaleSelect() {
        try {
            stat = cnct.createStatement();
            resst = stat.executeQuery("SELECT date, sale_id, product_name, sales_price, quantity, total FROM sale_item");
            tbSaleRep.setModel(DbUtils.resultSetToTableModel(resst));
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //create reports in excel
    public void createExcel(String myfile) {
        try {
            File path = new File(myfile);
            Desktop.getDesktop().open(path);
        } catch (IOException io) {
            System.out.println(io);
        }
    }
    
    //limit characters of jtextfields
    public void limitChar() {
        tfUserId.setDocument(new TextFieldLength(10));
        tfPassword.setDocument(new TextFieldLength(10));
        tfName.setDocument(new TextFieldLength(30));
        tfLname.setDocument(new TextFieldLength(100));
        tfEmail.setDocument(new TextFieldLength(50));
        tfQuest.setDocument(new TextFieldLength(50));
        tfAnswer.setDocument(new TextFieldLength(50));
       
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfUserId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        btCreate = new javax.swing.JButton();
        tfLname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbUserType = new javax.swing.JComboBox<>();
        btClearUser = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tfQuest = new javax.swing.JTextField();
        tfAnswer = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        validMsg = new javax.swing.JTextField();
        validMsg1 = new javax.swing.JTextField();
        validMsg2 = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        btGenSale = new javax.swing.JButton();
        btPrintSale = new javax.swing.JButton();
        btClearSale = new javax.swing.JButton();
        dtFrom = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dtTo = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSaleRep = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btPrintStock = new javax.swing.JButton();
        btClearStock = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRepStock = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(950, 600));
        setMinimumSize(new java.awt.Dimension(950, 600));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("Users");

        jLabel12.setText("User ID");

        jLabel3.setText("Name");

        jLabel11.setText("Last name");

        tfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNameKeyTyped(evt);
            }
        });

        jLabel6.setText("Email");

        jLabel7.setText("Password");

        btCreate.setBackground(new java.awt.Color(0, 102, 51));
        btCreate.setForeground(new java.awt.Color(204, 255, 204));
        btCreate.setText("Create");
        btCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCreateMouseClicked(evt);
            }
        });

        tfLname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLnameKeyTyped(evt);
            }
        });

        jLabel13.setText("User type");

        cbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        btClearUser.setBackground(new java.awt.Color(0, 102, 51));
        btClearUser.setForeground(new java.awt.Color(204, 255, 204));
        btClearUser.setText("Clear");
        btClearUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearUserMouseClicked(evt);
            }
        });

        jLabel15.setText("Question");

        jLabel16.setText("Answer");

        validMsg.setEditable(false);
        validMsg.setBackground(java.awt.Color.white);
        validMsg.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        validMsg.setForeground(new java.awt.Color(255, 0, 0));
        validMsg.setBorder(null);

        validMsg1.setEditable(false);
        validMsg1.setBackground(java.awt.Color.white);
        validMsg1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        validMsg1.setForeground(new java.awt.Color(255, 0, 0));
        validMsg1.setBorder(null);

        validMsg2.setEditable(false);
        validMsg2.setBackground(java.awt.Color.white);
        validMsg2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        validMsg2.setForeground(new java.awt.Color(255, 0, 0));
        validMsg2.setBorder(null);

        tfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEmailFocusLost(evt);
            }
        });
        tfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEmailKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(332, 332, 332))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(btCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btClearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfQuest, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfAnswer)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tfLname, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(validMsg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(validMsg2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEmail))
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(validMsg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQuest, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btClearUser, btCreate});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbUserType, tfLname, tfName, tfPassword, tfUserId});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel13, jLabel15, jLabel16, jLabel3, jLabel6, jLabel7});

        jPanel2.setBackground(java.awt.Color.white);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel9.setText("Reports");

        btGenSale.setBackground(new java.awt.Color(0, 102, 51));
        btGenSale.setForeground(new java.awt.Color(204, 255, 204));
        btGenSale.setText("Search");
        btGenSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btGenSaleMouseClicked(evt);
            }
        });

        btPrintSale.setBackground(new java.awt.Color(0, 102, 51));
        btPrintSale.setForeground(new java.awt.Color(204, 255, 204));
        btPrintSale.setText("Print");
        btPrintSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintSaleActionPerformed(evt);
            }
        });

        btClearSale.setBackground(new java.awt.Color(0, 102, 51));
        btClearSale.setForeground(new java.awt.Color(204, 255, 204));
        btClearSale.setText("Clear");
        btClearSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearSaleMouseClicked(evt);
            }
        });

        dtFrom.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("From");

        jLabel10.setText("To");

        dtTo.setDateFormatString("yyyy-MM-dd");

        tbSaleRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Sale ID", "Product", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(tbSaleRep);
        if (tbSaleRep.getColumnModel().getColumnCount() > 0) {
            tbSaleRep.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel10))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(dtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btGenSale, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btPrintSale, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(btClearSale, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btClearSale, btGenSale, btPrintSale});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btPrintSale)
                        .addComponent(btClearSale)
                        .addComponent(btGenSale))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("SALES", jPanel4);

        jLabel14.setText("Category");

        btPrintStock.setBackground(new java.awt.Color(0, 102, 51));
        btPrintStock.setForeground(new java.awt.Color(204, 255, 204));
        btPrintStock.setText("Print");
        btPrintStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintStockActionPerformed(evt);
            }
        });

        btClearStock.setBackground(new java.awt.Color(0, 102, 51));
        btClearStock.setForeground(new java.awt.Color(204, 255, 204));
        btClearStock.setText("Clear");
        btClearStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btClearStockMouseClicked(evt);
            }
        });

        tbRepStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product", "Quanity", "Category"
            }
        ));
        jScrollPane2.setViewportView(tbRepStock);

        tfSearch.setPreferredSize(new java.awt.Dimension(60, 25));
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btPrintStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(266, 266, 266)
                                .addComponent(btClearStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPrintStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btClearStock)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btClearStock, btPrintStock});

        jTabbedPane1.addTab("STOCK", jPanel5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));

        jLabel8.setBackground(new java.awt.Color(204, 255, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Other features");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCreateMouseClicked
        //method creates new user and save on database
        try {            
            prepst = cnct.prepareStatement("insert into login (user, password,type,question, answer, user_name,user_lname,user_email)values(?,?,?,?,?,?,?,?)");
            prepst.setString(1, tfUserId.getText());
            prepst.setString(2, tfPassword.getText());
            prepst.setString(3, cbUserType.getSelectedItem().toString());
            prepst.setString(4, tfQuest.getText().toUpperCase());
            prepst.setString(4, tfAnswer.getText().toUpperCase());
            prepst.setString(4, tfName.getText().toUpperCase());
            prepst.setString(5, tfLname.getText().toUpperCase());
            prepst.setString(6, tfEmail.getText());
            prepst.executeUpdate();
            JOptionPane.showMessageDialog(this, "User created sucesfully");
            btClearUserMouseClicked(evt);
        } catch (SQLException ex) {
            Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCreateMouseClicked

    private void btGenSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btGenSaleMouseClicked
        //retrieve sales records from database to jtable     
        String fromDate = ((JTextField) dtFrom.getDateEditor().getUiComponent()).getText();
        String toDate = ((JTextField) dtTo.getDateEditor().getUiComponent()).getText();
        if (fromDate.length() > 0 && toDate.isEmpty()) {
            try {
                stat = cnct.createStatement();
                resst = stat.executeQuery("SELECT sale_id, product_name, sales_price, quantity, total FROM sale_item");
                tbSaleRep.setModel(DbUtils.resultSetToTableModel(resst));
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (fromDate.length() > 0 && toDate.length() > 0) {
            try {
                stat = cnct.createStatement();
                resst = stat.executeQuery("SELECT sale_id, product_name, sales_price, quantity, total FROM sale_item where date between" + fromDate + "and" + toDate);
                tbSaleRep.setModel(DbUtils.resultSetToTableModel(resst));
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select Date");
        }
    }//GEN-LAST:event_btGenSaleMouseClicked

    private void btClearSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearSaleMouseClicked
        //clear data from textfields
        ((JTextField) dtFrom.getDateEditor().getUiComponent()).setText("");
        ((JTextField) dtTo.getDateEditor().getUiComponent()).setText("");
        SaleSelect();
    }//GEN-LAST:event_btClearSaleMouseClicked

    private void btClearStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearStockMouseClicked
        //clear data from textfields
        tfSearch.setText("");
        SaleSelect();
    }//GEN-LAST:event_btClearStockMouseClicked

    private void tfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyPressed
        //user input on this field will search in jtable
        String cat = tfSearch.getText().toUpperCase();
        if (tfSearch.getText().length() > 0) {
            try {
                stat = cnct.createStatement();
                resst = stat.executeQuery("SELECT product_name, quantity FROM product where category =?");
                tbSaleRep.setModel(DbUtils.resultSetToTableModel(resst));
            } catch (SQLException ex) {
                Logger.getLogger(Others.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            SaleSelect();
        }
    }//GEN-LAST:event_tfSearchKeyPressed

    private void btPrintStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintStockActionPerformed
        //prints report from table to excel
        try {
            JFileChooser printExcel = new JFileChooser();
            printExcel.showSaveDialog(this);
            File saveExcel = printExcel.getSelectedFile();
            if (saveExcel != null) {
                saveExcel = new File(saveExcel.toString() + ".xlsx");
                Workbook workb = new XSSFWorkbook();
                Sheet sheet = workb.createSheet("report");
                Row myRow = sheet.createRow(0);
                for (int i = 0; i < tbRepStock.getColumnCount(); i++) {
                    Cell myCell = myRow.createCell(i);
                    myCell.setCellValue(tbRepStock.getColumnName(i));
                }
                for (int j = 0; j < tbRepStock.getRowCount(); j++) {
                    Row myRow2 = sheet.createRow(j);
                    for (int k = 0; k < tbRepStock.getColumnCount(); k++) {
                        Cell myCell = myRow2.createCell(k);

                        if (tbRepStock.getValueAt(j, k) != null) {
                            myCell.setCellValue(tbRepStock.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream oust = new FileOutputStream(new File(saveExcel.toString()));
                workb.write(oust);
                workb.close();
                oust.close();
                createExcel(saveExcel.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error on triyng to generate archive");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException io) {
            System.out.println(io);
        }
    }//GEN-LAST:event_btPrintStockActionPerformed

    private void btPrintSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintSaleActionPerformed
        //prints report from table to excel
        try {
            JFileChooser printExcel = new JFileChooser();
            printExcel.showSaveDialog(this);
            File saveExcel = printExcel.getSelectedFile();
            if (saveExcel != null) {
                saveExcel = new File(saveExcel.toString() + ".xlsx");
                Workbook workb = new XSSFWorkbook();
                Sheet sheet = workb.createSheet("report");
                Row myRow = sheet.createRow(0);
                for (int i = 0; i < tbSaleRep.getColumnCount(); i++) {
                    Cell myCell = myRow.createCell(i);
                    myCell.setCellValue(tbSaleRep.getColumnName(i));
                }
                for (int j = 0; j < tbSaleRep.getRowCount(); j++) {
                    Row myRow2 = sheet.createRow(j);
                    for (int k = 0; k < tbSaleRep.getColumnCount(); k++) {
                        Cell myCell = myRow2.createCell(k);

                        if (tbSaleRep.getValueAt(j, k) != null) {
                            myCell.setCellValue(tbSaleRep.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream oust = new FileOutputStream(new File(saveExcel.toString()));
                workb.write(oust);
                workb.close();
                oust.close();
                createExcel(saveExcel.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error on triyng to generate archive");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException io) {
            System.out.println(io);
        }
    }//GEN-LAST:event_btPrintSaleActionPerformed

    private void btClearUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btClearUserMouseClicked
        //clear all data from textfields
        tfUserId.setText("");
        tfPassword.setText("");
        tfUserId.setText("");
        tfName.setText("");
        tfEmail.setText("");
    }//GEN-LAST:event_btClearUserMouseClicked

    private void tfNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNameKeyTyped
       char valid = evt.getKeyChar();
       if(!Character.isLetter(valid)||(valid==KeyEvent.VK_BACK_SPACE)||valid==KeyEvent.VK_DELETE){
           evt.consume();
           validMsg.setText("Letters only");
       } else{
           validMsg.setText(null);
       }
    }//GEN-LAST:event_tfNameKeyTyped

    private void tfLnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLnameKeyTyped
        char valid = evt.getKeyChar();
       if(!Character.isLetter(valid)||(valid==KeyEvent.VK_BACK_SPACE)||valid==KeyEvent.VK_DELETE){
           evt.consume();
           validMsg.setText("Letters only");
       } else{
           validMsg.setText(null);
       }
    }//GEN-LAST:event_tfLnameKeyTyped

    private void tfEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailKeyTyped

    private void tfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailFocusLost

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
    private javax.swing.JButton btClearSale;
    private javax.swing.JButton btClearStock;
    private javax.swing.JButton btClearUser;
    private javax.swing.JButton btCreate;
    private javax.swing.JButton btGenSale;
    private javax.swing.JButton btPrintSale;
    private javax.swing.JButton btPrintStock;
    private javax.swing.JComboBox<String> cbUserType;
    private com.toedter.calendar.JDateChooser dtFrom;
    private com.toedter.calendar.JDateChooser dtTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbRepStock;
    private javax.swing.JTable tbSaleRep;
    private javax.swing.JTextField tfAnswer;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfLname;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfQuest;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfUserId;
    private javax.swing.JTextField validMsg;
    private javax.swing.JTextField validMsg1;
    private javax.swing.JTextField validMsg2;
    // End of variables declaration//GEN-END:variables

}

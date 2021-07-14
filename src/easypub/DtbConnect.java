/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author vanel
 */
public class DtbConnect {
    
  
    public static Connection connectDtb(){
        Connection cn = null;
        try{
           // Class.forName("com.mysql.jdbc.Driver");
            cn= DriverManager.getConnection("jdbc:mysql://localhost:3308/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            
           return cn;                    
        }
        catch(Exception e){
            System.out.println("Problem to connect to the Database");
            return null;
    }
        
}
}

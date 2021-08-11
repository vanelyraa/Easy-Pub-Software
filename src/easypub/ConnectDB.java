/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {

    public static Connection connect() {

        Connection cnct = null;
        String url = "jdbc:mysql://localhost:3306/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnct = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return cnct;
    }
}

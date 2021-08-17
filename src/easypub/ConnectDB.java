/*
 * Class connects system to database
 */
package easypub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static Connection connect() {

        Connection cnct = null;
        String url = "jdbc:mysql://localhost:3306/easypubdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";//database address
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

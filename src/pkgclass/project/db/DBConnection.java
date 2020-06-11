package pkgclass.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    Connection connection;
    ResultSet resultSet;
    Statement statement;
    PreparedStatement pStatement;
    public static String URL = "jdbc:mysql://localhost/class_project_java";
    public static String USERNAME = "root";
    public static String PASSWORD = "";
    
    public void connnectionMethod() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                statement = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
         new LoginForm().setVisible(true);
    }
}

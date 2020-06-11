package pkgclass.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginController extends DBConnection{
    public LoginController() {
        connnectionMethod();
    }
    
    public boolean loginAction(String name, String password,  boolean invalidLogin){
        invalidLogin = false;
        try {
            PreparedStatement pStatement = (PreparedStatement) connection.prepareStatement("Select user_name, user_password from users where user_name='"+name+"' and user_password='"+password+"'");
            ResultSet rs = pStatement.executeQuery();
            if(rs.next()){
                new MainForm().setVisible(true);       
            }else{
                invalidLogin = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invalidLogin;
    }
}

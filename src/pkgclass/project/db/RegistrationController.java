package pkgclass.project.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationController extends DBConnection{
    public RegistrationController() {
        connnectionMethod();
    }
    
    public boolean registerAction(String name, String password,  boolean invalidLogin){
        invalidLogin = false;
        try {
            PreparedStatement pStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO users(user_name,user_password) VALUES('"+name+"','"+password+"')");
            boolean executepS = pStatement.execute();
            if(executepS){
                new LoginForm().setVisible(true);
            }else{
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invalidLogin;
    }  
}

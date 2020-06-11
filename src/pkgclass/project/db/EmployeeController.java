package pkgclass.project.db;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class EmployeeController  extends DBConnection {
    public EmployeeController() {
        connnectionMethod();
    }
    public void create(String name,String email, int factoryId) throws SQLException{
        String query = "{CALL insert_employee('"+name+"','"+email+"','"+factoryId+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.execute();
    }
    public void select(DefaultTableModel dtm) throws SQLException{
       String sql = "SELECT * FROM employee";
       resultSet = statement.executeQuery(sql);
       Object[] data= new Object[4];
       while(resultSet.next()){
           data[0] = resultSet.getInt("employee_id");
           data[1] = resultSet.getString("factory_id");
           data[2] = resultSet.getString("name");
           data[3] = resultSet.getString("email");
           dtm.addRow(data);
       }
    }
    public void update(int id, String name, String email) throws SQLException{
        String query = "{CALL update_employee('"+name+"','"+email+"','"+id+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
    public void delete(int id ) throws SQLException{
        String query = "{CALL delete_from_employees('"+id+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
}

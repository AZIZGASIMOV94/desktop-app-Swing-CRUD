package pkgclass.project.db;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class SalaryController extends DBConnection{
        public SalaryController() {
        connnectionMethod();
    }
    public void select(DefaultTableModel dtm) throws SQLException{
       String sql = "SELECT * FROM salary";
       resultSet = statement.executeQuery(sql);
       Object[] data= new Object[4];
       while(resultSet.next()){
           data[0] = resultSet.getInt("salary_id");
           data[1] = resultSet.getString("employee_id");
           data[2] = resultSet.getString("amount");
           data[3] = resultSet.getString("currency");
           dtm.addRow(data);
       }
    }
    public void create(int amount, String currency, int employeeID) throws SQLException{
        String query = "{CALL 	insert_salary('"+amount+"','"+currency+"','"+employeeID+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.execute();
    }

    public void update(int salaryID, String amount,String currency) throws SQLException{
        String query = "{CALL update_salary('"+salaryID+"','"+amount+"','"+currency+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
    public void delete(int id ) throws SQLException{
        String query = "{CALL delete_from_salaries('"+id+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
}

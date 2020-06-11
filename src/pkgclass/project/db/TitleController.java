package pkgclass.project.db;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class TitleController extends DBConnection {
        public TitleController() {
        connnectionMethod();
    }
    public void select(DefaultTableModel dtm) throws SQLException{
       String sql = "SELECT * FROM title";
       resultSet = statement.executeQuery(sql);
       Object[] data= new Object[3];
       while(resultSet.next()){
           data[0] = resultSet.getInt("title_id");
           data[1] = resultSet.getString("employee_id");
           data[2] = resultSet.getString("title_desc");
           dtm.addRow(data);
       }
    }
    public void create(String titileDesc, int employeeID) throws SQLException{
        String query = "{CALL 	insert_title('"+titileDesc+"','"+employeeID+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.execute();
    }
    public void update(int titleID, String titleDesc) throws SQLException{
        String query = "{CALL update_title('"+titleID+"','"+titleDesc+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
    public void delete(int id ) throws SQLException{
        String query = "{CALL delete_from_titles('"+id+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
}

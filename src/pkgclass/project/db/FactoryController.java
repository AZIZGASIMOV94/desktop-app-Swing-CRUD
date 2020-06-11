package pkgclass.project.db;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class FactoryController extends DBConnection {
    public FactoryController() {
        connnectionMethod();
    }
    
    public void create(String location) throws SQLException{
        String query = "{CALL insert_factory('"+location+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.execute();
    
    }
    public void select(DefaultTableModel dtm) throws SQLException{
        String sql = "SELECT * FROM factory";
        resultSet = statement.executeQuery(sql);
        Object[] data= new Object[2];
        while(resultSet.next()){
            data[0] = resultSet.getInt("factory_id");
            data[1] = resultSet.getString("factory_location");
            dtm.addRow(data);
        }
    }
    public void update(int id, String location) throws SQLException{
        String query = "{CALL update_factory('"+id+"','"+location+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
    public void delete(int id ) throws SQLException{
        String query = "{CALL delete_from_factories('"+id+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
}



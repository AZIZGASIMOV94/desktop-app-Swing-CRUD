package pkgclass.project.db;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class WarehouseController extends DBConnection{
    public WarehouseController() {
        connnectionMethod();
    }

    public void select(DefaultTableModel dtm) throws SQLException{
       String sql = "SELECT * FROM warehouse";
       resultSet = statement.executeQuery(sql);
       Object[] data= new Object[4];
       while(resultSet.next()){
           data[0] = resultSet.getInt("warehouse_id");
           data[1] = resultSet.getString("factory_id");
           data[2] = resultSet.getString("capacity");
           dtm.addRow(data);
       }
    }
    public void create(int FactoryId, String capacity) throws SQLException{
        String query = "{CALL insert_warehouse('"+FactoryId+"','"+capacity+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.execute();
    }
    public void update(int warehouseId, String capacity) throws SQLException{
        String query = "{CALL update_warehouse('"+warehouseId+"','"+capacity+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
    public void delete(int id ) throws SQLException{
        String query = "{CALL delete_from_warehouses('"+id+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
}

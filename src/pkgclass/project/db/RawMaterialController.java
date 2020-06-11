package pkgclass.project.db;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class RawMaterialController extends DBConnection {
     public RawMaterialController() {
        connnectionMethod();
    }
    public void select(DefaultTableModel dtm) throws SQLException{
       String sql = "SELECT * FROM raw_material";
       resultSet = statement.executeQuery(sql);
       Object[] data= new Object[4];
       while(resultSet.next()){
           data[0] = resultSet.getInt("raw_material_id");
           data[1] = resultSet.getString("warehouse_id");
           data[2] = resultSet.getString("raw_material_desc");
           data[3] = resultSet.getString("amount");
           dtm.addRow(data);
       }
    }
    public void create(String desc,String amount, int warehouseID) throws SQLException{
        String query = "{CALL 	insert_raw_material('"+desc+"','"+amount+"','"+warehouseID+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.execute();
    }
    public void update(int warehouseID, String desc, String amount,int rawID) throws SQLException{
        String query = "{CALL update_raw_materials('"+warehouseID+"','"+desc+"','"+amount+"','"+rawID+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
    public void delete(int id ) throws SQLException{
        String query = "{CALL delete_raw_material('"+id+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
}

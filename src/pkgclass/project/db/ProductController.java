package pkgclass.project.db;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ProductController  extends DBConnection{
    public ProductController() {
        connnectionMethod();
    }
    public void select(DefaultTableModel dtm) throws SQLException{
       String sql = "SELECT * FROM product";
       resultSet = statement.executeQuery(sql);
       Object[] data= new Object[4];
       while(resultSet.next()){
           data[0] = resultSet.getInt("product_id");
           data[1] = resultSet.getString("warehouse_id");
           data[2] = resultSet.getString("product_desc");
           data[3] = resultSet.getString("amount");
           dtm.addRow(data);
       }
    }
    public void create(int warehouseID, String desc,String amount) throws SQLException{
        String query = "{CALL insert_product('"+warehouseID+"','"+desc+"','"+amount+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.execute();
    }
    public void update(int productId, String desc, String amount) throws SQLException{
        String query = "{CALL update_product('"+productId+"','"+desc+"','"+amount+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }
    public void delete(int id ) throws SQLException{
        String query = "{CALL delete_from_products('"+id+"')}";
        CallableStatement stmt = connection.prepareCall(query);
        stmt.executeUpdate();
    }   
}

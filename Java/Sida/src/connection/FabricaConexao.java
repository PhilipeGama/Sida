package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection getConnection() throws Exception{
        try {
            String host = "jdbc:mysql://localhost/sida?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "root";
            return DriverManager.getConnection(host,user, password);
        } catch (SQLException e) {
            throw new Exception(e);
        }
        
        
    }
}

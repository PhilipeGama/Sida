package connection;

import connection.FabricaConexao;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteConexao {
    public static void main(String[] args) {
        
        try {
            Connection con = FabricaConexao.getConnection();
            if(con != null){
                System.out.println("Conexão estabelecida com sucesso");
            }else{
                System.out.println("erro ao estabelecer conesxão");
            }
        } catch (Exception ex) {
            Logger.getLogger(TesteConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

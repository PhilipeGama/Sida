package dao.disciplina;

import connection.FabricaConexao;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import model.Curso;
import model.Disciplina;

public class DisciplinaDAO {
    
    private Connection connection;
    public DisciplinaDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    }
    
        public boolean cadastrar(Disciplina bean){
        try {
            CallableStatement call =
                    connection.prepareCall("{call cadastrarDisciplina(?,?,?)}");     
            call.setString(1,bean.getSigla());
            call.setString(2,bean.getDescricao());
            call.setInt(3,bean.getCargahoraria());
            
            
            call.execute();        
            call.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: "+ex);
        }
        return false;
    }
    
    public ArrayList<Disciplina> consultarDescricao(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarDescricaoDisciplina(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            ArrayList<Disciplina> listaBean = new ArrayList();
            while(rs.next()){
                String sigla = rs.getString("sigla");
                String descricao = rs.getString("descricao");
                int cargahoraria = rs.getInt("cargahoraria");
                Disciplina bean = new Disciplina(sigla,descricao,cargahoraria);
                listaBean.add(bean);
            }
            ps.close();
            rs.close();
            return listaBean;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar: "+ex);
        }
        return null;
    }
    
    
    
    public boolean alterar(Disciplina bean){
        try {
            PreparedStatement ps =
                    connection.prepareStatement("{call alterarDisciplina(?,?,?)}");
            ps.setString(1,bean.getSigla());
            ps.setString(2,bean.getDescricao());
            ps.setDouble(3,bean.getCargahoraria());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar: "+ex);
        }
        return false;
    }
    
    public boolean excluir(String valorBuscado){
        try {
            CallableStatement call =
                    connection.prepareCall("{call excluirDisciplina(?)}");     
            call.setString(1,valorBuscado);
            call.execute();        
            call.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir: "+ex);
        }
        return false;
     
    }
}

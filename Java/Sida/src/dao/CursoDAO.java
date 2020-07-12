package dao;

import connection.FabricaConexao;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import model.Aluno;
import model.Curso;

public class CursoDAO {
    private Connection connection;
    public CursoDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    } 
     public boolean cadastrar(Curso bean){
        try {
            CallableStatement call =
                    connection.prepareCall("{call cadastrarCurso(?,?)}");     
            call.setString(1,bean.getSigla());
            call.setString(2,bean.getDescricao());
            
            call.execute();        
            call.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: "+ex);
        }
        return false;
    }
    
    public Curso consultarSigla(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarSiglaCurso(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            Curso bean = new Curso(); 
            String sigla = rs.getString("sigla");
            String descricao = rs.getString("descricao");
            ps.close();
            rs.close();
            return bean;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar: "+ex);
        }
        return null;
    }
    
    public ArrayList<Curso> consultarDescricao(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarDescricaoCurso(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            ArrayList<Curso> listaBean = new ArrayList();
            while(rs.next()){
                Curso bean = new Curso();
                String sigla = rs.getString("sigla");
                String descricao = rs.getString("descricao");
                
                bean = new Curso(sigla,descricao);
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
    
    
    public boolean alterar(Curso bean){
        try {
            PreparedStatement ps = connection.prepareStatement("{call alterarCurso(?,?)}");
            ps.setString(1,bean.getSigla());
            ps.setString(2,bean.getDescricao());
            
            
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
                    connection.prepareCall("{call excluirCurso(?)}");     
            call.setString(1,valorBuscado);
            call.execute();        
            call.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir: "+ex.getMessage());
        }
        return false;
     
    }
}
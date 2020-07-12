/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.FabricaConexao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Aluno;
import model.Professor;

/**
 *
 * @author Ruan
 */
public class AlunoDAO {
    private Connection connection;
    public AlunoDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    } 
    
    
    
        
     public boolean cadastrar(Aluno bean){
        try {
            CallableStatement call =
                    connection.prepareCall("{call cadastrarAluno(?,?)}");     
            call.setString(1,bean.getMatricula());
            call.setString(2,bean.getNome());
            
            call.execute();        
            call.close();
            
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: "+ex);
        }
        return false;
    }
    
    public ArrayList<Aluno> consultar(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarAluno(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            ArrayList<Aluno> listaBean = new ArrayList();
            while(rs.next()){
                Aluno bean = new Aluno();
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                
                bean = new Aluno(matricula,nome);
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
    
    
    
    public boolean alterar(Aluno bean){
        try {
            PreparedStatement ps = connection.prepareStatement("{call alterarAluno(?,?)}");
            ps.setString(1,bean.getMatricula());
            ps.setString(2,bean.getNome());
            
            
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
                    connection.prepareCall("{call excluirAluno(?)}");     
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


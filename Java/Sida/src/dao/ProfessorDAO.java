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
import model.disciplina.DisciplinaProfessor;
import model.Professor;

/**
 *
 * @author Ruan
 */
public class ProfessorDAO {
    private Connection connection;
    public ProfessorDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    } 
    
    public int login(String login,String senha){
        try {
            String sql = "select fnLoginProfessor(?,?) as result";
            
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, login);
           ps.setString(2, senha);
           ResultSet rs = ps.executeQuery();
           int result = 0; 
           if(rs.next()){
               result = rs.getInt("result");
               if(result != 0 ){
                  Professor.mat = login; 
               }
           } 
            ps.close();
            connection.close();
            return result;
        } catch (Exception e) {  
           
        }  
        return 0;
    }
    public boolean cadastrar(Professor bean){
        try {
            CallableStatement call =
                    connection.prepareCall("{call cadastrarProfessor(?,?,?,?)}");     
            call.setString(1,bean.getMatricula());
            call.setString(2,bean.getNome());
            call.setString(3,bean.getFormacao());
            call.setString(4,bean.getSenha());
            call.execute();        
            call.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: "+ex);
        }
        return false;
    }
    
    public ArrayList<Professor> consultar(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarProfessor(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            ArrayList<Professor> listaBean = new ArrayList();
            while(rs.next()){
                Professor bean = new Professor();
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                String formacao = rs.getString("formacao"); 
                String senha = rs.getString("senha");
                bean = new Professor(matricula,nome,formacao,senha);
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
    
        public ArrayList<Aluno> consultarProfessorAlunos(DisciplinaProfessor bean){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarProfessorAluno(?,?,?)");
            ps.setString(1, bean.getDissigla());
            ps.setInt(2,bean.getNumero());
            ps.setString(3,bean.getPromatricula());
            ResultSet rs = ps.executeQuery();
            ArrayList<Aluno> listaBean = new ArrayList();
            while(rs.next()){
                Aluno bean2;
                String matricula = rs.getString("a.matricula");
                String nome = rs.getString("a.nome");
                bean2 = new Aluno(matricula,nome);
                listaBean.add(bean2);
            }
            ps.close();
            rs.close();
            return listaBean;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar: "+ex);
        }
        return null;
       }
    
    
        public Professor consultarSigla(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarProfessorSigla(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            System.out.println("aaaa");
             Professor bean = new Professor();
            while(rs.next()){
               
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                String formacao = rs.getString("formacao"); 
                String senha = rs.getString("senha");
                System.out.println("aaa "+matricula+nome);
                bean = new Professor(matricula,nome,formacao,senha);
            }
            ps.close();
            rs.close();
            return bean;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar: "+ex);
        }
        return null;
    }
    
    public boolean alterar(Professor bean){
        try {
            PreparedStatement ps = connection.prepareStatement("{call alterarProfessor(?,?,?)}");
            ps.setString(1,bean.getMatricula());
            ps.setString(2,bean.getNome());
            ps.setString(3,bean.getFormacao());
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
                    connection.prepareCall("{call excluirProfessor(?)}");     
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
    public boolean cadastrarProfessorDisciplina(String matricula, String disc, String num, String data){
        try {
            CallableStatement call =
                    connection.prepareCall("insert into disciplina_professor values(?,?,?,?);");
            //System.out.println(matricula + " " + disc + " " + num + " " + data);
            call.setString(1,matricula);
            call.setString(2,disc);
            call.setInt(3,Integer.parseInt(num));
            call.setString(4,data);
            call.execute();        
            call.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: "+ex);
        }
        return false;
    }
}


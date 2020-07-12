/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DisciplinaCurso;


/**
 *
 * @author Philipe
 */
public class DisciplinaCursoDAO {
      private Connection connection;
    public DisciplinaCursoDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    }
    
    public boolean cadastrar(ArrayList<DisciplinaCurso> listaBean){
        String sql = "call cadastrarDisciplinaCurso(?,?);";       
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            for (DisciplinaCurso bean : listaBean) {
               
                try {
                    System.out.println("DC :"+bean.getCursigla());
                    ps.setString(1, bean.getDissigla());
                    ps.setString(2, bean.getCursigla()); 
                    ps.execute();  
                } catch (Exception e) {
                    System.out.println("Já cadastrado");
                }
                 
            }  
            connection.close();
            return true;
        }catch(Exception er){
            System.out.println("Erro: "+er.getMessage());
            return false;
        }
        
    }
    
    public ArrayList<DisciplinaCurso> consultarDescricao(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarSiglaDisciplinaCurso(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            ArrayList<DisciplinaCurso> listaBean = new ArrayList();
            while(rs.next()){
                String dissigla = rs.getString("dissigla");
                String cursigla = rs.getString("cursigla");
                
                DisciplinaCurso bean = new DisciplinaCurso(dissigla,cursigla);
                listaBean.add(bean);
            }
            ps.close();
            rs.close();
            return listaBean;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar: "+ex.getMessage());
        }
        return null;
    }
    
    
    public boolean excluir(DisciplinaCurso bean){
        String sql = "call excluirDisciplinaCurso(?,?);";       
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bean.getDissigla());
            ps.setString(2, bean.getCursigla());
            ps.execute();
            connection.close();
            return true;
        }catch(Exception er){
            System.out.println("Erro: "+er.getMessage());
            return false;
        }
        
    }
}

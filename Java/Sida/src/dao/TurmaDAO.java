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
import model.Turma;

/**
 *
 * @author Thiago Sena
 */
public class TurmaDAO {
    private Connection connection;
    public TurmaDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    } 
    
    
    
        
     public boolean cadastrar(Turma bean){
        try {
            CallableStatement call =
                    connection.prepareCall("insert into turma values(?,?,?)");     
            call.setString(1,bean.getSigla());
            call.setString(2,bean.getDescricao());
            call.setString(3,bean.getTurno());
            call.execute();        
            call.close();
            
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: "+ex);
        }
        return false;
    }
    
    public ArrayList<Turma> consultar(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("select * from turma where sigla like ? or descricao like ? or turno like ?");
            ps.setString(1, "%"+valorBuscador+"%");
            ps.setString(2, "%"+valorBuscador+"%");
            ps.setString(3, "%"+valorBuscador+"%");
            ResultSet rs = ps.executeQuery();
            ArrayList<Turma> listaBean = new ArrayList();
            while(rs.next()){
                
                String sigla = rs.getString("sigla");
                String descricao = rs.getString("descricao");
                String turno = rs.getString("turno");
                
                Turma bean = new Turma(sigla,descricao,turno);
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
    
    
    
    public boolean alterar(Turma bean){
        try {
            PreparedStatement ps = connection.prepareStatement("update turma set descricao = ?, turno=? where sigla = ?;");
            ps.setString(1,bean.getDescricao());
            ps.setString(2,bean.getTurno());
            ps.setString(3,bean.getSigla());
            
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
                    connection.prepareCall("delete from turma where sigla = ?");     
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

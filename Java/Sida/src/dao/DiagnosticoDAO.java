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
import model.Diagnostico;

/**
 *
 * @author Philipe
 */
public class DiagnosticoDAO {
    private Connection connection;
    public DiagnosticoDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    } 
    
    
     public boolean cadastrar(Diagnostico bean){
        try {
            CallableStatement call =
                    connection.prepareCall("{call updateDiagnostico(?,?,?,?,?,?,?,?,?,?)}");     
            
            call.setInt(1,bean.getDesempenho());
            call.setInt(2,bean.getComportamento());
            call.setInt(3,bean.getFrequencia());
            call.setInt(4,bean.getPontualidade());
            call.setString(5,bean.getProblema());
            call.setString(6,bean.getSuperacao());
            call.setString(7,bean.getDisosigla());
            call.setInt(8, bean.getNumero());
            call.setString(9,bean.getDisodtinicio());
            call.setString(10,bean.getAlumatricula());
            call.execute();        
            call.close();
            
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: "+ex);
        }
        return false;
    }
     
    public ArrayList<Diagnostico> consultarDiagnosticoProfessor(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarDiagnosticoProfessor(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            ArrayList<Diagnostico> listaBean = new ArrayList();
            while(rs.next()){
                Diagnostico bean;
                int desempenho = rs.getInt("desempenho");
                int comportamento = rs.getInt("comportamento");
                int frequencia = rs.getInt("frequencia");
                int pontualidade = rs.getInt("pontualidade");
                String problema = rs.getString("problema");
                String superacao = rs.getString("superacao");
                String disosigla = rs.getString("disosigla");
                int disonumero = rs.getInt("disonumero");
                String disodtinicio = rs.getString("disodtinicio");
                String alumatricula = rs.getString("alumatricula");
                
                bean = new Diagnostico(desempenho,comportamento,frequencia,pontualidade,problema,
                        superacao,disosigla,disonumero,disodtinicio,alumatricula);
                
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
    
}

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
import model.DisciplinaOfertada;

/**
 *
 * @author Philipe
 */
public class DisciplinaOfertadaDAO {
    private Connection connection;
    public DisciplinaOfertadaDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    }
    
    public boolean cadastrar(DisciplinaOfertada bean){
        String sql = "call cadastrarDisciplinaOfertada(?,?,?,?);";       
        try{
            PreparedStatement ps = connection.prepareStatement(sql); 
            
            ps.setString(1, bean.getDissigla()); 
            ps.setInt(2, bean.getNumero()); 
            String data1 = DisciplinaOfertada.mandarBanco(bean.getDtinicio());
            ps.setString(3, data1);
            String data2 = DisciplinaOfertada.mandarBanco(bean.getDtfim());
            ps.setString(4,data2); 
            ps.execute();         
            connection.close();
            return true;
        }catch(Exception er){
            System.out.println("Erro: "+er.getMessage());
            return false;
        }
    }
    
    public ArrayList<DisciplinaOfertada> consultarDescricao(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarSiglaDisciplinaOfertada(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            ArrayList<DisciplinaOfertada> listaBean = new ArrayList();
            while(rs.next()){
                String dissigla = rs.getString("dissigla");
                int numero = rs.getInt("numero");
                String dtinicio = rs.getString("dtinicio");
                
                String dtfim = rs.getString("dtfim");
                System.out.println(dtinicio+"\n"+dtfim);
                DisciplinaOfertada bean = new DisciplinaOfertada(dissigla,numero,dtinicio,dtfim);
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
    
    
}

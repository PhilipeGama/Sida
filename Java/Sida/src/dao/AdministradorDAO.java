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
import model.Administrador;

/**
 *
 * @author philipe.gama
 */
public class AdministradorDAO {
     private Connection connection;
    public AdministradorDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    }    
    public int login(String login, String senha){
        try{
            String sql = "select fnLoginAdministrador(?, ?) as result";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            int result = 0;        
            if(rs.next()){
                result = rs.getInt("result");
                if(result != 0){
                    Administrador.loginG = login;
                }
            }
                
            ps.close();
            connection.close();
            return result;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}

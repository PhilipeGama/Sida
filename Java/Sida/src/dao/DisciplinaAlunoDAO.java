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
import model.Curso;
import model.DisciplinaAluno;

/**
 *
 * @author Philipe
 */
public class DisciplinaAlunoDAO {
    private Connection connection;
    
    public DisciplinaAlunoDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    } 
     public boolean cadastrar(DisciplinaAluno bean){
        try {
            CallableStatement call =
                    connection.prepareCall("{call cadastrarDisciplinaAluno(?,?,?,?)}");     
            call.setString(1,bean.getDisosigla());
            call.setInt(2,bean.getNumero());
            call.setString(3, bean.getDisodtinicio());
            call.setString(4,bean.getAlumatricula());
            call.execute();        
            call.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: "+ex);
        }
        return false;
    }
    
    public DisciplinaAluno consultarDisciplinaAluno(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarSiglaCurso(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            DisciplinaAluno bean = new DisciplinaAluno(); 
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
    
}

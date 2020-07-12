/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.disciplina;

import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.disciplina.DisciplinaProfessor;

/**
 *
 * @author Philipe
 */
public class DisciplinaProfessorDAO {
    private Connection connection;
    public DisciplinaProfessorDAO() throws Exception {
        this.connection = FabricaConexao.getConnection();
    }
    
       public ArrayList<DisciplinaProfessor> consultarDisciplinaProfessor(String valorBuscador){
        try {
            PreparedStatement ps = connection.prepareStatement("call consultarDisciplinaProfessor(?)");
            ps.setString(1, valorBuscador);
            ResultSet rs = ps.executeQuery();
            ArrayList<DisciplinaProfessor> listaBean = new ArrayList();
            while(rs.next()){
                    
                   String sigla = rs.getString("do1.dissigla");
                   int numero = rs.getInt("do1.numero");
                   String dtinicio = rs.getString("do1.dtinicio");
                   DisciplinaProfessor bean = new DisciplinaProfessor(sigla,numero,dtinicio);
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

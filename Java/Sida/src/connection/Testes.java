/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import dao.ProfessorDAO;

/**
 *
 * @author Philipe
 */
public class Testes {
    public static void main(String[] args) {
        try {
            ProfessorDAO dao = new ProfessorDAO();
            System.out.println(dao.consultarSigla("2019001"));
        } catch (Exception e) {
        }
    }
}

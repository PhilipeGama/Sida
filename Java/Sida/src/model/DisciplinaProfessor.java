/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Philipe
 */
public class DisciplinaProfessor {
    private String nomeProfessor;
    private ArrayList<String> nomeDisciplina;
    private int numero;
    private String dtInicio;

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    
//    public String getNomeDisciplina() {
//        return nomeDisciplina;
//    }
//
//    public void setNomeDisciplina(String nomeDisciplina) {
//        this.nomeDisciplina = nomeDisciplina;
//    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }
    
    
    
    
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.disciplina;

/**
 *
 * @author Philipe
 */
public class DisciplinaAluno {
    private String alumatricula;
    private String disosigla;
    private int numero;
    private String disodtinicio;

    public DisciplinaAluno() {
    }

    public DisciplinaAluno(String alumatricula, String disosigla, int numero, String disodtinicio) {
        this.alumatricula = alumatricula;
        this.disosigla = disosigla;
        this.numero = numero;
        this.disodtinicio = disodtinicio;
    }
 
    public String getAlumatricula() {
        return alumatricula;
    }

    public void setAlumatricula(String alumatricula) {
        this.alumatricula = alumatricula;
    }

    public String getDisosigla() {
        return disosigla;
    }

    public void setDisosigla(String disosigla) {
        this.disosigla = disosigla;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDisodtinicio() {
        return disodtinicio;
    }

    public void setDisodtinicio(String disodtinicio) {
        this.disodtinicio = disodtinicio;
    }
    
    
}

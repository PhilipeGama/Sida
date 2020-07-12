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
public class DisciplinaProfessor {
    private String promatricula;
    private String dissigla;
    private int numero;
    private String dtInicio;

    public DisciplinaProfessor(String dissigla, int numero, String dtInicio) {
        //this.promatricula = promatricula;
        this.dissigla = dissigla;
        this.numero = numero;
        this.dtInicio = dtInicio;
    }

    public String getPromatricula() {
        return promatricula;
    }

    public void setPromatricula(String promatricula) {
        this.promatricula = promatricula;
    }

    public String getDissigla() {
        return dissigla;
    }

    public void setDissigla(String dissigla) {
        this.dissigla = dissigla;
    }

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

    @Override
    public String toString() {
        return "DisciplinaProfessor{" + "promatricula=" + promatricula + ", dissigla=" + dissigla + ", numero=" + numero + ", dtInicio=" + dtInicio + '}';
    }
    
    
         
}

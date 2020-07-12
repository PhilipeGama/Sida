/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Philipe
 */
public class DisciplinaCurso {
    private String dissigla;
    private String cursigla;

    public DisciplinaCurso() {
    }
   
    public DisciplinaCurso(String dissigla, String cursigla) {
        this.dissigla = dissigla;
        this.cursigla = cursigla;
    }
    
    public String getDissigla() {
        return dissigla;
    }

    public void setDissigla(String dissigla) {
        this.dissigla = dissigla;
    }

    public String getCursigla() {
        return cursigla;
    }

    public void setCursigla(String cursigla) {
        this.cursigla = cursigla;
    }

    @Override
    public String toString() {
        return "DisciplinaCurso{" + "dissigla=" + dissigla + ", cursigla=" + cursigla + '}';
    }
    
    
    
}

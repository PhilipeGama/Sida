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
public class Disciplina {
    private String sigla;
    private String descricao;
    private int cargahoraria;

    public Disciplina() {
    }

    

    public Disciplina(String sigla, String descricao, int cargahoraria) {
        this.sigla = sigla;
        this.descricao = descricao;
        this.cargahoraria = cargahoraria;
        
    }

    
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "sigla=" + sigla + ", descricao=" + descricao + ", cargahoraria=" + cargahoraria + '}';
    }

    
    
   
  
}

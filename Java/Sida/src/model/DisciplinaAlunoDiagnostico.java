/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Philipe
 */
public class DisciplinaAlunoDiagnostico {
    private int desempenho;
    private int comportamento;
    private int frequencia;
    private int pontualidade;
    private String problema;
    private String superacao;
    
    private String disosigla;
    private String disonumero;
    private LocalDate disodtinicio;
    private String alumatricula;

    public int getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(int desempenho) {
        this.desempenho = desempenho;
    }

    public int getComportamento() {
        return comportamento;
    }

    public void setComportamento(int comportamento) {
        this.comportamento = comportamento;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public int getPontualidade() {
        return pontualidade;
    }

    public void setPontualidade(int pontualidade) {
        this.pontualidade = pontualidade;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSuperacao() {
        return superacao;
    }

    public void setSuperacao(String superacao) {
        this.superacao = superacao;
    }

    public String getDisosigla() {
        return disosigla;
    }

    public void setDisosigla(String disosigla) {
        this.disosigla = disosigla;
    }

    public String getDisonumero() {
        return disonumero;
    }

    public void setDisonumero(String disonumero) {
        this.disonumero = disonumero;
    }

    public LocalDate getDisodtinicio() {
        return disodtinicio;
    }

    public void setDisodtinicio(LocalDate disodtinicio) {
        this.disodtinicio = disodtinicio;
    }

    public String getAlumatricula() {
        return alumatricula;
    }

    public void setAlumatricula(String alumatricula) {
        this.alumatricula = alumatricula;
    }
    
    
    
    
}

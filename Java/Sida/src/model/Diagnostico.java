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
public class Diagnostico {
    private int desempenho;
    private int comportamento;
    private int frequencia;
    private int pontualidade;
    private String problema;
    private String superacao;
    private String disosigla;
    private int numero;
    private String disodtinicio;
    private String alumatricula;

    public Diagnostico() {
    }

    public Diagnostico(int desempenho, int comportamento, int frequencia, int pontualidade, String problema, String superacao, String disosigla, int numero, String disodtinicio, String alumatricula) {
        this.desempenho = desempenho;
        this.comportamento = comportamento;
        this.frequencia = frequencia;
        this.pontualidade = pontualidade;
        this.problema = problema;
        this.superacao = superacao;
        this.disosigla = disosigla;
        this.numero = numero;
        this.disodtinicio = disodtinicio;
        this.alumatricula = alumatricula;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

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

    public String getDisodtinicio() {
        return disodtinicio;
    }

    public void setDisodtinicio(String disodtinicio) {
        this.disodtinicio = disodtinicio;
    }

    public String getAlumatricula() {
        return alumatricula;
    }

    public void setAlumatricula(String alumatricula) {
        this.alumatricula = alumatricula;
    }
    
    
    
}

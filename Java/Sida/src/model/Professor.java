/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ruan
 */
public class Professor {
    public static String mat = null;
    private String matricula;
    private String nome;
    private String formacao;
    private String senha;
    
    public Professor(){
    }

    public Professor(String matricula, String nome, String formacao, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.formacao = formacao;
        this.senha = senha;
    }
           
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}

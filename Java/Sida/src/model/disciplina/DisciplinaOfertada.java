/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.disciplina;

import java.time.LocalDate;

/**
 *
 * @author Philipe
 */
public class DisciplinaOfertada {
    private String dissigla;
    private int numero;
    private String dtinicio;
    private String dtfim;

    public DisciplinaOfertada(String dissigla, int numero, String dtinicio, String dtfim) {
        this.dissigla = dissigla;
        this.numero = numero;
        this.dtinicio = dtinicio;
        this.dtfim = dtfim;
    }

    public DisciplinaOfertada() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(String dtinicio) {
        this.dtinicio = dtinicio;
    }

    public String getDtfim() {
        return dtfim;
    }

    public void setDtfim(String dtfim) {
        this.dtfim = dtfim;
    }

    public static String mandarBanco(String data){
        String dia = data.substring(0,2);
        
        String mes = data.substring(3,5);
        String ano = data.substring(6,10);
        System.out.println("--------\n"+ano+"\n"+mes+"\n"+dia);
        String retornaData = ano+"-"+mes+"-"+dia;
        return retornaData;
    } 
    
    public static String receberBanco(String data){      
        String ano = data.substring(0,4);      
        String mes = data.substring(5,7);
        String dia = data.substring(8,10);
        String retornaData = dia+"/"+mes+"/"+"/"+ano;
        return retornaData;
    } 
    
    
 
}

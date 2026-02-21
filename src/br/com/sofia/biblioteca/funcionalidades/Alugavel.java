/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sofia.biblioteca.funcionalidades;

/**
 *
 * @author lucas
 */
public interface Alugavel {
    
    public abstract void subExemplar();

    public abstract void addExemplar(int num);
    

    public abstract int getExemplares();



}
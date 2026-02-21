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
public class Ebook extends ItemDigital implements Utilizavel{
    
    
    
    public Ebook(String nome) {
        super(nome);
        super.setId(003);
    }

    @Override
    public void usar() {
        System.out.println("você");
        
        
    }

    
}
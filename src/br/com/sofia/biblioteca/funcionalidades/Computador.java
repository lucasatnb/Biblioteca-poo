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
public class Computador extends ItemFisico implements Utilizavel {
    
    public Computador( String nome, int prazoMin) {
        super(nome);
        super.setId(800);
        super.setPrazo(prazoMin);

    }

    @Override
    public void usar() {
        System.out.println("você pode ir la usar por:"+ super.getPrazo());
        }
    
    
    
    
    
    
    
    
}

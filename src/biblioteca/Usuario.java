/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author lucas
 */
public class Usuario {


    
    public void alugar(Alugavel a){
        a.alugar();
    
    }
    public void devolver(Alugavel a){
    
        a.devolver();
    
    }
    public void usar(Utilizavel u){
    
        u.usar();
    }
    
    
    
    
}

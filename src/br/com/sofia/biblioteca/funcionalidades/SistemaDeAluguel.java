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
public class SistemaDeAluguel {
    static int numerosDeSistemas = 0;
    public SistemaDeAluguel() {
        if(SistemaDeAluguel.numerosDeSistemas > 0){
            throw new SistemaUnico("sistema deve ser unico");

        }
        
        SistemaDeAluguel.numerosDeSistemas++;
    }
   

    
    
    
    public boolean alugar(Alugavel item, String nome) throws MissingObjectException, NaoAlugavel {
        System.out.println("solicitando aluguel do item");
        
        if(item.getExemplares() <= 0){
            throw new MissingObjectException("Sem exemplares");
        }
        
        System.out.println("Usuario:"+ nome  + ". alugou com sucesso");

        item.subExemplar();
        
        return true;
    }
    
    public boolean devolver(Alugavel item){
        System.out.println("solicitando Devolução");
        try{
            item.addExemplar(1);
        }
        catch(NullPointerException ex){
            System.out.println("sem item pra devolver");
        }
        return true;
    }

    
    
    
    
}

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
public class Usuario {
    private Alugavel                          alugavel = null;
    private final String nome;
    private final SistemaDeAluguel sis;

    public Usuario(String nome, SistemaDeAluguel sistema) {
        sis = sistema;
        this.nome = nome;
    }

    
    
    
    public void alugar(Alugavel a) {
        if (alugavel != null){
            throw new LoanLimitExceededException("Sò um por vez");
        }
       

        try{
            this.sis.alugar(a, this.nome);
            this.alugavel = a; 

        }catch(MissingObjectException ex){
            
            System.err.println("estamos sem esse item");
        }catch(NaoAlugavel ex){
            System.err.println("não é alugavel");
        }finally{
            System.out.println("operação concluida");
            
        }
        
        
        
    }
    public void devolver(){
        if(alugavel == null){
            throw new ItemAlreadyOwnedException("erro: sem item a devolver");            
        }
        this.sis.devolver(this.alugavel);
        alugavel = null;
    }
    public void usar(Utilizavel u){
        if( u == null){
            throw new NullPointerException("erro: sem item a usar");            
        }
        u.usar();
    }

    
    
    
    
    
}

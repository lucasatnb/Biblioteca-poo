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
    private Alugavel alugavel = null;
    
    
    public void alugado(Alugavel a) {
        if (alugavel != null){
            throw new LoanLimitExceededException("Sò um por vez");
        }
        if (a.getExemplares() <=0){
            throw new ItemAlreadyOwnedException("Não tem mais que pena");
        
        }
        boolean conseguiu = a.alugar();
        
        if(conseguiu){
            this.alugavel = a;
        
            System.out.println("alugado");
        }else System.out.println("não alugado");
        
        
        
    }
    public void devolver(){
        if(alugavel == null){
            throw new ItemAlreadyOwnedException("erro: sem item a devolver");            
        }
        this.alugavel.devolver();
        alugavel = null;
    }
    public void usar(Utilizavel u){
        if( u == null){
            throw new NullPointerException("erro: sem item a usar");            
        }
        u.usar();
    }
    
    
    
    
    
}

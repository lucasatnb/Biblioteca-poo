/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author lucas
 */
public class Revista extends ItemFisico implements Alugavel,Utilizavel {
    static int prazo = 1;
    private final SistemaDeAluguel sistema;

    
    public Revista( String nome , SistemaDeAluguel sis) {
        super(011, nome, prazo);
        this.sistema = sis;
    }

   

    @Override
    public void usar() {

        System.out.println("pode usar ai");

    }

    @Override
    public boolean alugar() { 
        try {
            sistema.alugar(this);
            return true;
        } 
        catch (MissingObjectException ex) {
            System.err.println("sem itens do tipo:" + super.getNome());
        }
        return false;
    }
    
    @Override
    public void devolver() {
            sistema.devolver(this);
         
    }
    @Override
    public int getExemplares() {
        return super.getExemplares();

    }
    
}

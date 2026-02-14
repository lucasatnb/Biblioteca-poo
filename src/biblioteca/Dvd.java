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
public class Dvd extends ItemFisico implements Alugavel {
    static int prazo = 3;
    private final SistemaDeAluguel sistema;

    public Dvd( String nome, SistemaDeAluguel sis) {
        super(010, nome, prazo);
        sistema = sis;
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

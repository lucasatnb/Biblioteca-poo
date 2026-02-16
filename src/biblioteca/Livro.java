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
public class Livro extends ItemFisico implements Alugavel,Utilizavel {
    static int prazo = 5;
    private SistemaDeAluguel sistema;
    public Livro(String nome, SistemaDeAluguel sis) {
        super(001, nome, prazo);
        super.addExemplar(1);
        this.sistema = sis;
    }


   @Override
    public boolean alugar(String nome) { 
        try {
            sistema.alugar(this, nome);
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
    public void usar() {

        System.out.println("Vai la tu pode usar por 1h30");
    }
    @Override
    public int getExemplares() {
        return super.getExemplares();

    }
    
    
    
    
    
    
    
    
    
    
    
}

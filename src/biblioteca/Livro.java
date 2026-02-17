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
    private final int prazoParaLivros = 5;
    public Livro(String nome) {
        super(nome);

        super.setId(001);
        
        super.setPrazo(prazoParaLivros);
        
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

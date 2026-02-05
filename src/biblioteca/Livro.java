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
    public Livro(String nome) {
        super(001, nome, prazo);
    }


    @Override
    public void alugar() {
        System.out.println("você tem" + prazo + " dias");
        super.setSobPosse(true);
    }

    @Override
    public void devolver() {
        super.setSobPosse(false);


    }

    @Override
    public void usar() {

        System.out.println("Vai la tu pode usar por 1h30");
    }
    
    
    
    
    
    
    
    
    
    
    
}

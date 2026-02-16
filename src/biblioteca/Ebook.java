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
public class Ebook extends ItemDigital implements Alugavel{

    public Ebook( String nome) {
        super(110, nome);
    }

     @Override
    public boolean alugar(String nome) {
        System.out.println(nome+ ": alugou");
        return true;
    }
    
    @Override
    public void devolver() {

        
    }
    @Override
    public int getExemplares() {
         return Integer.MAX_VALUE;

    }
}

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
    public void alugar() {
        System.out.println("seu livro:"+ super.getNome());
        super.setSobPosse(true);

    }

    @Override
    public void devolver() {
        super.setSobPosse(false );

    }

    
}

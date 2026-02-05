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

    public Dvd( String nome) {
        super(010, nome, prazo);
    }

    @Override
    public void alugar() {

        System.out.println("você tem " + prazo + " dias");
        super.setSobPosse(true);

    }

    @Override
    public void devolver() {

        super.setSobPosse(false);
    }
    
}

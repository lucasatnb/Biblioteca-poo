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
public class Revista extends ItemFisico implements Alugavel,Utilizavel {
    static int prazo = 1;
    public Revista( String nome) {
        super(011, nome, prazo);
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

        System.out.println("pode usar ai");

    }
    
}

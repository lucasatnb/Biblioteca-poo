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
    static final int PRAZODAREVISTA = 1;

    
    public Revista( String nome ) {
        super(nome);
        super.setId(005);
        super.setPrazo(PRAZODAREVISTA);

    }

   

    @Override
    public void usar() {

        System.out.println("pode usar ai");

    }

    
    @Override
    public int getExemplares() {
        return super.getExemplares();

    }
    
}

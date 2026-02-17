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
    static final int PRAZOPARADVD = 3;

    public Dvd( String nome) {
        super(nome);
        super.setPrazo(PRAZOPARADVD);
        super.setId(002);
     
    }



    @Override
    public int getExemplares() {
        return super.getExemplares();

    }
    
    }

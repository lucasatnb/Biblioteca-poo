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
public class Computador extends ItemFisico implements Utilizavel {
    static int prazo = 0;
    public Computador( String nome) {
        super(100, nome, prazo);
    }

    @Override
    public void usar() {
        System.out.println("você pode ir la usar por 30min");
        }
    
    
    
    
    
    
    
    
}

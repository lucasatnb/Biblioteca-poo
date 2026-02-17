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
public class Ebook extends ItemDigital implements Utilizavel{
    
    
    
    public Ebook(String nome) {
        super.setNome(nome);
        super.setId(003);
    }

    @Override
    public void usar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
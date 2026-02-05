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
public abstract class Item {
    
    private final int id;
    private  boolean sobPosse = false;
    private final String nome;

    public Item(int id, String nome) {
      
        
        this.id = id;
        this.nome = nome;
    }
    
    

    public int getId() {
        return id;
    }

    public boolean isSobposse() {
        return this.sobPosse;
    }

    public String getNome() {
        return nome;
    }

    public void setSobPosse(boolean sobPosse) {
        this.sobPosse = sobPosse;
    }

    


    
    
    
    
    
    
    
    
    
    
    
    
}

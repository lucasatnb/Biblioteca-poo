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
public class ItemFisico extends Item {
    private int prazo;
    private int diasPassados;

    public ItemFisico(int id, String nome,int prazo) {
        super(id, nome);
        this.prazo = prazo;
    }
    
    public void amanha(){
    
        this.diasPassados++;
    }
    public double multa(){
        if (this.diasPassados >= prazo){
            return (diasPassados-prazo)*0.10;
                    }
        else{
            return 0;
        }
    }
    
    


}

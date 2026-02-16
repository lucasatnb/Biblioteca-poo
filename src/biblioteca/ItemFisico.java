/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public abstract class ItemFisico extends Item {
    private int exemplares = 0;
    static List<String> LivrosAdicionados = new ArrayList<>();
    private int prazo;
    private int diasPassados;

    public ItemFisico(int id, String nome,int prazo) {
        super(id, nome);
        this.prazo = prazo;
        
        
        try{
            AdicionarItem(nome);
        }catch(ObjetoJaexistente ex){
            System.err.println("ja existe desse tipo");
            throw new ObjetoJaexistente("////////////");
        
        }
        
        
        
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
    
    private void AdicionarItem(String s){
        
            if(ItemFisico.LivrosAdicionados.contains(s)){
            throw new ObjetoJaexistente("tentou criar um item ja existente");
            }
            ItemFisico.LivrosAdicionados.add(s);

    
    }
    
    public void addExemplar(int num) {
            if (num <=0){
                throw new ValorNegativoException("Não faz sentido adicionar um numero negativo");
            }
            this.exemplares += num;
            if (num > 1){
            System.out.println(this.exemplares+"|" +num + "EXMPLARES A MAIS DE:" + this.getNome() );}
            
    }
    public void subExemplar(){
        
        try{
            if (this.exemplares <=0){
                throw new ValorNegativoException("exemplares não podem ser inferior a 0");
            }
            this.exemplares--;
            System.out.println(this.exemplares+"| UM EXEMPLAR A MENOS DE:" + this.getNome() );
        }
        catch(ValorNegativoException ex){
            System.out.println(ex.getMessage());
        }
    
    }

    public int getExemplares() {
        return this.exemplares;
    }

}

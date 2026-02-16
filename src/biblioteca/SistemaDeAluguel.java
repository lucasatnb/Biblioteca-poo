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
public class SistemaDeAluguel {
    
    
    
    public boolean alugar(ItemFisico item, String nome) throws MissingObjectException {
        System.out.println("solicitando aluguel do " + item.getClass() + ": " + item.getNome());
        
        if(item.getExemplares() <= 0){
            throw new MissingObjectException("Sem exemplares");
        }
        System.out.println("Usuario:"+ nome  + ". alugou com sucesso");

        item.subExemplar();
        
        return true;
    }
    
    public boolean devolver(ItemFisico item){
        System.out.println("solicitando aluguel");
        try{
            item.addExemplar(1);
        }
        catch(Exception ex){
            System.out.println("erro");
        }
        return true;
    }

    
    
    
    
}

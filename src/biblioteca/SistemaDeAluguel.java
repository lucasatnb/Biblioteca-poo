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
    
    
    
    public boolean alugar(ItemFisico item) throws MissingObjectException {
        System.out.println("solicitando aluguel");
        
        if(item.getExemplares() <= 0){
            throw new MissingObjectException("Sem exemplares");
        }
        
        item.subExemplar();
        
        return true;
    }
    
    public boolean devolver(ItemFisico item){
        System.out.println("solicitando aluguel");
        item.addExemplar();
        
        return true;
    }

    
    
    
    
}

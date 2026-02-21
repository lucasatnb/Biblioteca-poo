/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sofia.biblioteca.funcionalidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ItemFisicoFabrica {
    private static List<String> LivrosAdicionados = new ArrayList<>();

    private static ItemFisicoFabrica instancia = null;
    
    
    private ItemFisicoFabrica(){
    
    
    }
    
    public static ItemFisicoFabrica getInstance() {
        if (instancia == null) {
            instancia = new ItemFisicoFabrica();
        }
        return instancia;
    }
    public void AdicionarItem(ItemFisico i){
        
        
        
            if(ItemFisicoFabrica.LivrosAdicionados.contains(i.getNome())){
            throw new ObjetoJaexistente("tentou criar um item ja existente");
            }
            ItemFisicoFabrica.LivrosAdicionados.add(i.getNome());

    
    }
    
    
    
    
    
    
    
    
    
}

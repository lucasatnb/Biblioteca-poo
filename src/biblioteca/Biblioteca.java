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
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Criando o Usuário (nosso cliente)
        Usuario lucas = new Usuario();

        // 2. Criando os Itens (Polimorfismo: tudo nasce como filho, mas pode ser tratado como Interface)
        Livro livroJava = new Livro( "Java para Iniciantes");
        Revista revistaVeja = new Revista( "Veja Tecnologia");
        Ebook ebookKindle = new Ebook("O Senhor dos Anéis");
        Computador pcGamer = new Computador("PC da Biblioteca");

        // 3. Testando ALUGUEL (Interface Alugavel)
        // O usuário consegue alugar Livro, Revista e Ebook
        System.out.println("--- TESTE DE ALUGUEL ---");
        lucas.alugar(livroJava);   // Funciona (Livro é Alugável)
        lucas.alugar(revistaVeja); // Funciona (Revista é Alugável)
        lucas.alugar(ebookKindle); // Funciona (Ebook é Alugável)
        
        // lucas.alugar(pcGamer); // ERRO! O Java nem deixa compilar (PC não é Alugável)

        // 4. Testando USO LOCAL (Interface Utilizavel)
        System.out.println("\n--- TESTE DE USO LOCAL ---");
        lucas.usar(livroJava); // Funciona (Livro implementa as duas!)
        lucas.usar(pcGamer);   // Funciona (PC é utilizável)
        
        // lucas.usar(ebookKindle); // ERRO! Ebook não é para usar na mesa da biblioteca
    }
    
}

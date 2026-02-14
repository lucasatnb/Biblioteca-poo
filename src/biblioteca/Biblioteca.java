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

        // 1. PREPARAÇÃO DO AMBIENTE
        SistemaDeAluguel sistema = new SistemaDeAluguel();
        Usuario lucas = new Usuario();
        Usuario pedro = new Usuario(); // Criamos um amigo pra testar estoque

        System.out.println("=== 📚 INICIANDO SISTEMA DA BIBLIOTECA ===");

        // Criando itens (Lembre-se: Livros nascem com 1 exemplar pelo construtor)
        Livro livroJava = new Livro("Java POO", sistema);
        Revista revista = new Revista("Superinteressante", sistema);
        Computador pc = new Computador("Dell i5 da Biblioteca");
        Ebook ebook = new Ebook("Clean Code PDF");

        // ---------------------------------------------------------
        // TESTE 1: FLUXO NORMAL (ALUGAR E DEVOLVER)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 1] Fluxo Normal: Alugar e Devolver ---");
        try {
            System.out.println("Lucas tentando alugar livro...");
            lucas.alugado(livroJava); 
            
            System.out.println("Lucas tentando devolver...");
            lucas.devolver(); // Agora deve funcionar sem parâmetros
            
        } catch (Exception e) {
            System.out.println("ERRO INESPERADO: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // TESTE 2: TENTAR ALUGAR DOIS ITENS (REGRA DE 1 POR VEZ)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 2] O Guloso: Tentar pegar 2 itens ---");
        try {
            lucas.alugado(livroJava); // Pega o primeiro (ok)
            System.out.println("Lucas pegou o primeiro. Tentando o segundo...");
            
            lucas.alugado(revista); // Tenta pegar o segundo (DEVE FALHAR)
            
        } catch (LoanLimitExceededException e) {
            System.out.println("✅ SUCESSO NO TESTE! O sistema barrou: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro errado: " + e);
        } finally {
            // Limpa a mão do Lucas pro próximo teste
            try { lucas.devolver(); } catch(Exception e){} 
        }

        // ---------------------------------------------------------
        // TESTE 3: INTERFACE UTILIZAVEL (COMPUTADOR)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 3] Usando o PC (Utilizavel) ---");
        try {
            // lucas.alugado(pc); // Isso nem compila, o que é ótimo! PC não é Alugavel.
            lucas.usar(pc);
        } catch (Exception e) {
            System.out.println("Erro ao usar PC: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // TESTE 4: ESTOQUE ESGOTADO (DOIS USUÁRIOS)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 4] Estoque Esgotado ---");
        try {
            // Lucas pega o único exemplar do livro de Java
            System.out.println("Lucas pega o livro de Java...");
            lucas.alugado(livroJava);
            
            // Pedro tenta pegar o mesmo livro
            System.out.println("Pedro tenta pegar o mesmo livro...");
            pedro.alugado(livroJava);
            
        } catch (ItemAlreadyOwnedException e) { 
            // Nota: Você usou ItemAlreadyOwnedException para estoque <= 0 no Usuario
            System.out.println("✅ SUCESSO! Pedro ficou sem livro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getClass().getSimpleName());
        } finally {
             try { lucas.devolver(); } catch(Exception e){} // Devolve pra não prender
        }

        // ---------------------------------------------------------
        // TESTE 5: DEVOLVER O VENTO (SEM NADA NA MÃO)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 5] Devolver sem ter nada ---");
        try {
            lucas.devolver(); // Lucas já devolveu no finally anterior, tá vazio.
        } catch (ItemAlreadyOwnedException e) { // Sua exceção para alugavel == null
            System.out.println("✅ SUCESSO! O sistema avisou: " + e.getMessage());
        } catch (RuntimeException e) {
             System.out.println("✅ SUCESSO! Erro genérico capturado: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // TESTE EXTRA: O PROBLEMA DO EBOOK
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE EXTRA]");
        try {
            lucas.alugado(ebook);
        } catch (ItemAlreadyOwnedException e) {
             System.out.println("deu erro de estoque pois ebook não ta disponivel: " + e.getMessage());
        }

        
        
        
        // ---------------------------------------------------------
        // TESTE 6: A DISPUTA (3 USUÁRIOS, 2 LIVROS)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 6] A Disputa: 3 Usuários vs 2 Livros ---");
        
        // 1. Criando o cenário
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();
        
        // Livro nasce com 1 exemplar (pelo construtor do Livro)
        Livro domCasmurro = new Livro("Dom Casmurro", sistema); 
        
        // 2. Usando o método ADD para aumentar o estoque
        System.out.println("Estoque inicial: " + domCasmurro.getExemplares());
        domCasmurro.addExemplar(); // Agora tem 2 exemplares!
        System.out.println("Estoque após addExemplar(): " + domCasmurro.getExemplares());

        try {
            // USUÁRIO 1 TENTA (Deve conseguir)
            System.out.println("\nUsuário 1 tentando...");
            u1.alugado(domCasmurro);

            // USUÁRIO 2 TENTA (Deve conseguir - pega o último)
            System.out.println("Usuário 2 tentando...");
            u2.alugado(domCasmurro);

            // USUÁRIO 3 TENTA (Deve FALHAR - sem estoque)
            System.out.println("Usuário 3 tentando (vai dar ruim?)...");
            u3.alugado(domCasmurro);

        } catch (ItemAlreadyOwnedException e) {
            System.out.println("✅ SUCESSO! O sistema barrou o terceiro usuário: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e);
        }
        // ---------------------------------------------------------
        // TESTE 7: O CALOTEIRO (MULTA POR ATRASO)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 7] Simulando Atraso e Multa ---");
        
        // 1. Criar um livro específico para ter acesso aos métodos de tempo
        // O prazo padrão do Livro é 5 dias (definido na classe Livro)
        Livro senhorDosAneis = new Livro("O Senhor dos Anéis", sistema);
        Usuario u8 = new Usuario();
        try {
            // Aluga o livro
            u8.alugado(senhorDosAneis);
            System.out.println("Livro alugado! Prazo de devolução: 5 dias.");
            
            // 2. SIMULANDO A PASSAGEM DO TEMPO
            // Vamos avançar 8 dias (3 dias de atraso)
            System.out.println("⏳ Passando 8 dias...");
            for (int i = 1; i <= 8; i++) {
                senhorDosAneis.amanha(); // Incrementa diasPassados
            }
            
            // 3. VERIFICANDO A MULTA
            // Lógica: (8 dias passados - 5 dias prazo) * 0.10 = 0.30
            double valorMulta = senhorDosAneis.multa();
            
            System.out.println(valorMulta);
            
            // Devolve (na vida real, só aceitaria se pagasse a multa kkk)
            lucas.devolver(); 
            
        } catch (Exception e) {
            System.out.println("Erro no teste da multa: " + e.getMessage());
        }
        
        
    }
    
}

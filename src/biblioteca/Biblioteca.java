/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

public class Biblioteca {

    public static void main(String[] args) {

        // --- PREPARAÇÃO ---
        SistemaDeAluguel sisMatriz = new SistemaDeAluguel();
        SistemaDeAluguel sisFilial = new SistemaDeAluguel(); // Para o teste 6

        System.out.println("=== 📚 BATERIA DE TESTES DO SISTEMA V2.0 ===\n");

        // ---------------------------------------------------------
        // TESTE 1: FLUXO BÁSICO COM IDENTIFICAÇÃO
        // (Testa se o nome vai pro sistema corretamente)
        // ---------------------------------------------------------
        System.out.println("--- [TESTE 1] Identificação do Usuário ---");
        Usuario u1 = new Usuario("Lucas");
        Livro cleanCode = new Livro("Clean Code", sisMatriz); // Nasce com 1 exemplar

        try {
            u1.alugar(cleanCode); // Deve aparecer "Usuario: Lucas alugou..."
            u1.devolver();
        } catch (Exception e) {
            System.out.println("Erro Teste 1: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // TESTE 2: REGRA DO GULOSO (APENAS 1 POR VEZ)
        // (Testa LoanLimitExceededException)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 2] O Guloso (Erro Antigo) ---");
        Revista revista = new Revista("Vogue", sisMatriz);
        try {
            u1.alugar(cleanCode); // Pegou o primeiro
            System.out.println("Lucas tenta pegar o segundo...");
            u1.alugar(revista);   // Deve explodir erro
        } catch (LoanLimitExceededException e) {
            System.out.println("✅ SUCESSO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e);
        } finally {
            u1.devolver(); // Limpa pra não travar os próximos
        }

        // ---------------------------------------------------------
        // TESTE 3: O ATAQUE DOS CLONES (10 USUÁRIOS vs 1 LIVRO)
        // (Testa Estoque, Concorrência e addExemplar(int))
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 3] 10 Usuários alugando o mesmo título ---");
        
        Livro domCasmurro = new Livro("Dom Casmurro", sisMatriz); // Tem 1
        
        // Vamos adicionar 9 exemplares de uma vez (Total = 10)
        domCasmurro.addExemplar(9); 
        System.out.println("Estoque atual de Dom Casmurro: " + domCasmurro.getExemplares());

        // Criando 11 usuários (10 conseguem, 1 chora)
        Usuario[] torcidaDoFortaleza = new Usuario[11];
        for (int i = 0; i < 11; i++) {
            torcidaDoFortaleza[i] = new Usuario("Torcedor " + (i+1));
        }

        for (Usuario torcedor : torcidaDoFortaleza) {
            try {
                torcedor.alugar(domCasmurro);
            } catch (Exception e) {
                System.out.println("❌ " + e.getMessage() + " (Estoque acabou!)");
            }
        }

        // ---------------------------------------------------------
        // TESTE 4: VALOR NEGATIVO (NOVO ERRO)
        // (Testa ValorNegativoException no addExemplar)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 4] Tentando burlar a física (Valor Negativo) ---");
        try {
            System.out.println("Tentando adicionar -5 livros...");
            domCasmurro.addExemplar(-5);
            
        } catch (ValorNegativoException e) { // Sua exceção nova
             // Nota: No seu código você capturou com try-catch DENTRO da classe, 
             // então o erro vai aparecer no print do método, não aqui no catch do main.
             // Se você mudou para 'throws', cairia aqui.
        } catch (Exception e) {
            System.out.println("Erro genérico: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // TESTE 5: DEVOLUÇÃO FANTASMA
        // (Testa ItemAlreadyOwnedException ao devolver nada)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 5] Devolver o Vento ---");
        Usuario esquecido = new Usuario("Pedro Esquecido");
        try {
            esquecido.devolver();
        } catch (ItemAlreadyOwnedException e) {
            System.out.println("✅ SUCESSO: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // TESTE 6: MULTIVERSO (DOIS SISTEMAS DIFERENTES)
        // (Testa se o estoque de um afeta o outro)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 6] Dois Sistemas Isolados ---");
        
        // Livro A pertence à MATRIZ
        Livro livroMatriz = new Livro("Livro Exclusivo Matriz", sisMatriz);
        
        // Livro B pertence à FILIAL
        Livro livroFilial = new Livro("Livro Exclusivo Filial", sisFilial);

        Usuario viajante = new Usuario("Viajante");
        
        try {
            // Aluga na filial
            viajante.alugar(livroFilial);
            
            // Verifica estoque da matriz (não deve ter mudado o dela)
            System.out.println("Estoque Matriz (deve ser 1): " + livroMatriz.getExemplares());
            System.out.println("Estoque Filial (deve ser 0): " + livroFilial.getExemplares());
            
            viajante.devolver(); // Devolve pra filial

        } catch (Exception e) {
            System.out.println("Erro no multiverso: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // TESTE 7: O CALOTEIRO (MULTA E DIAS PASSADOS)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 7] Atraso e Multa ---");
        Livro javaAvancado = new Livro("Java Advanced", sisMatriz);
        Usuario caloteiro = new Usuario("Zé Calote");
        
        try {
            caloteiro.alugar(javaAvancado);
            
            // Simula passar 6 dias (Prazo é 5)
            System.out.println("⏳ Passando 6 dias...");
            for(int i=0; i<6; i++) javaAvancado.amanha();
            
            double multa = javaAvancado.multa();
            if(multa > 0) {
                System.out.printf("🚨 Multa gerada: R$ %.2f (Correto!)\n", multa);
            } else {
                System.out.println("Erro: Multa não cobrada.");
            }
            caloteiro.devolver();
            
        } catch (Exception e) {
            System.out.println("Erro teste 7: " + e.getMessage());
        }

        System.out.println("\n=== FIM DA BATERIA DE TESTES ===");
        // ---------------------------------------------------------
        // TESTE 8: O PORTEIRO BRAVO (UNICIDADE DE TÍTULO)
        // ---------------------------------------------------------
        System.out.println("\n--- [TESTE 8] O Porteiro Bravo (Duplicidade) ---");
        
        try {
            System.out.println("1. Criando 'O Pequeno Príncipe' (Inédito)...");
            Livro p1 = new Livro("O Pequeno Príncipe", sisMatriz); // Deve passar
            
            System.out.println("2. Tentando criar 'O Pequeno Príncipe' DE NOVO (Deve falhar)...");
            Livro p2 = new Livro("O Pequeno Príncipe", sisMatriz); // AQUI TEM QUE DAR ERRO
            
            // Se chegar aqui, a validação falhou
            System.out.println("❌ FALHA: O sistema deixou criar duplicado!");
            
        } catch (RuntimeException e) {
            // Se cair aqui, a validação funcionou!
            System.out.println("✅ SUCESSO! O sistema barrou a cópia: " + e.getMessage());
        }
    }
}
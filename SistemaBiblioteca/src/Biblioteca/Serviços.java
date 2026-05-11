package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Serviços {

    public static int opcao(Scanner scanner, Usuario usuario) {
        System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
        System.out.println("Usuário logado: " + usuario.getNome() + " [" + usuario.getCargo() + "]");
        System.out.println("1 - Listar livros");
        System.out.println("2 - Adicionar livro");
        System.out.println("3 - Emprestar livro");
        System.out.println("4 - Devolver livro");
        System.out.println("5 - Excluir livro");
        System.out.println("6 - Trocar de usuário");
        System.out.println("7 - Encerrar programa");
        System.out.print("Escolha uma opção: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        return opcao;
    }

    public void listarLivros(ArrayList<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado no acervo.");
            return;
        }
        System.out.println("\n--- LISTA DE LIVROS ---");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public Livro adicionarLivro(int id_livro, Scanner scanner, Usuario usuario) {
        if (!usuario.isFuncionario()) {
            System.out.println("\n[ERRO] Você não tem permissão para adicionar livros! (Apenas Funcionários)");
            return null;
        }
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.println("Livro adicionado com sucesso!");
        return new Livro(id_livro, titulo, autor);
    }

    public void emprestarLivro(ArrayList<Livro> livros, int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                if (livro.getDisponibilidade()) {
                    livro.setDisponibilidade(false);
                    System.out.println("Livro '" + livro.getTitulo() + "' emprestado com sucesso!");
                } else {
                    System.out.println("O livro '" + livro.getTitulo() + "' já está emprestado.");
                }
                return;
            }
        }
        System.out.println("Livro com ID " + id + " não encontrado.");
    }

    public void devolverLivro(ArrayList<Livro> livros, int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                if (!livro.getDisponibilidade()) {
                    livro.setDisponibilidade(true);
                    System.out.println("Livro '" + livro.getTitulo() + "' devolvido com sucesso!");
                } else {
                    System.out.println("O livro '" + livro.getTitulo() + "' já está na biblioteca.");
                }
                return;
            }
        }
        System.out.println("Livro com ID " + id + " não encontrado.");
    }

    // Métodos de Autenticação para o Console
    public Usuario realizarLogin(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.println("\n--- LOGIN ---");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    public Usuario realizarCadastro(Scanner scanner) {
        System.out.println("\n--- CADASTRO DE NOVO USUÁRIO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Cargo (1 - Cliente, 2 - Funcionário): ");
        int tipo = 1;
        try {
            tipo = scanner.nextInt();
        } catch (Exception e) {
            tipo = 1;
        }
        scanner.nextLine();
        
        String cargo = (tipo == 2) ? "Funcionário" : "Cliente";
        System.out.println("Cadastro realizado com sucesso!");
        return new Usuario(nome, email, senha, cargo);
    }
}

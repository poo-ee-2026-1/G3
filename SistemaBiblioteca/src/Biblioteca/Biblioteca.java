package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        // Acervo inicial de livros
        livros.add(new Livro(1, "O Morro dos Ventos Uivantes", "Emily Brontë", "Romance", 1));
        livros.add(new Livro(2, "O Nome do Vento", "Patrick Rothfuss", "Fantasia", 2));
        livros.add(new Livro(3, "Duna", "Frank Herbert", "Ficção Científica", 3));
        livros.add(new Livro(4, "A Garota no Trem", "Paula Hawkins", "Suspense", 4));
        livros.add(new Livro(5, "O Iluminado", "Stephen King", "Terror", 5));
        livros.add(new Livro(6, "O Conde de Monte Cristo", "Alexandre Dumas", "Aventura", 6));
        int proximoIdLivro = 7; // Próximo ID disponível para novos livros

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Serviços serviços = new Serviços();
        
        // Adicionar usuário administrador padrão
        usuarios.add(new Funcionario("Admin", "admin@biblioteca.com", "123"));
        
        Usuario usuarioLogado = null;
        boolean sair = false;

        System.out.println("Bem-vindo ao Sistema de Biblioteca!");

        while (!sair) {
            if (usuarioLogado == null) {
                System.out.println("\n1 - Fazer Login");
                System.out.println("2 - Cadastrar-se");
                System.out.println("3 - Sair do Programa");
                System.out.print("Escolha uma opção: ");
                
                int opcaoInicial = 0;
                try {
                    opcaoInicial = scanner.nextInt();
                } catch (Exception e) {
                    scanner.nextLine();
                }
                scanner.nextLine();

                if (opcaoInicial == 1) {
                    usuarioLogado = serviços.realizarLogin(usuarios, scanner);
                    if (usuarioLogado == null) {
                        System.out.println("[ERRO] Email ou senha incorretos!");
                    } else {
                        System.out.println("Login realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
                    }
                } else if (opcaoInicial == 2) {
                    usuarios.add(serviços.realizarCadastro(scanner));
                } else if (opcaoInicial == 3) {
                    sair = true;
                } else {
                    System.out.println("Opção inválida!");
                }
            } else {
                int opcao = Serviços.opcao(scanner, usuarioLogado);
                int id;

                switch (opcao) {
                    case 1:
                        serviços.listarLivros(livros);
                        break;
                    case 2:
                        Livro novo = serviços.adicionarLivro(proximoIdLivro++, scanner, usuarioLogado);
                        if (novo != null) livros.add(novo);
                        break;
                    case 3:
                        System.out.print("Digite o ID do livro que deseja pegar emprestado: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        serviços.emprestarLivro(livros, id);
                        break;
                    case 4:
                        System.out.print("Digite o ID do livro que deseja devolver: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        serviços.devolverLivro(livros, id);
                        break;
                    case 5:
                        System.out.print("Digite o ID do livro que deseja excluir: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        serviços.excluirLivro(livros, id, usuarioLogado);
                        break;
                    case 6:
                        usuarioLogado = null; // Logout
                        System.out.println("Sessão encerrada. Retornando ao menu inicial...");
                        break;
                    case 7:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
        System.out.println("Programa encerrado. Até logo!");
        scanner.close();
    }
}

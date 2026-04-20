package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Serviços {

    Scanner scanner = new Scanner(System.in);

    public static int opcao(Scanner scanner) {
        System.out.println("\n--- MENU DA BIBLIOTECA ---");
        System.out.println("[1] Listar livros");
        System.out.println("[2] Adicionar livro");
        System.out.println("[3] Pegar livro emprestado");
        System.out.println("[4] Devolver livro");
        System.out.println("[5] Excluir livro");
        System.out.println("[6] Encerrar programa");
        System.out.println("\nDigite o serviço desejado: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public Livro adicionarLivro(int id){
        System.out.println("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        Livro livro = new Livro(id, titulo, autor);
        System.out.println();
        System.out.println("Livro adicionado com sucesso!");
        System.out.println();
        return livro;
    }

    public void listarLivros(ArrayList<Livro> livros){
        if (livros.isEmpty()){
            System.out.println();
            System.out.println("Nenhum livro cadastrado!");
            System.out.println();
            return;
        }
        System.out.println();
        System.out.println("Lista de livros: ");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println(livros.get(i).toString());
        }
        System.out.println();
    }
}

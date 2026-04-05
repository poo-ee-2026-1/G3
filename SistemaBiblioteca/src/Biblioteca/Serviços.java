package Biblioteca;

import java.util.Scanner;

public class Serviços {

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


}

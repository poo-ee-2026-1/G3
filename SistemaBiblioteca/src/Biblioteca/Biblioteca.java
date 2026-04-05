package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Livro> livros = new ArrayList<>();
		Serviços serviços = new Serviços();
		boolean parar = false;
		
		do {
				int opcao = serviços.opcao(scanner);
				
				switch (opcao) {
	            case 1:
	            	break;
	            case 6:
	            	parar = true;
	            	System.out.println("Encerrando...");
	            }
				
		}	while (!parar);
		
		scanner.close();
	}

}


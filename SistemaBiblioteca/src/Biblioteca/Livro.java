package Biblioteca;

public class Livro {
	
	private int id;
	private String titulo;
	private String autor;
	private boolean disponibilidade;
	
	
	
	public Livro(int id, String titulo, String autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.disponibilidade = true;
	}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getTitulo() {return titulo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	
	public boolean getDisponibilidade() {return disponibilidade;}
	public void setDisponibilidade(boolean disponibilidade) {this.disponibilidade = disponibilidade;}
	
	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", disponibilidade=" + disponibilidade + "]";
	}	
}
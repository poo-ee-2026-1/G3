package Biblioteca;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int secao;
    private boolean disponibilidade;

    public Livro(int id, String titulo, String autor, String genero, int secao) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.secao = secao;
        this.disponibilidade = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getSecao() { return secao; }
    public void setSecao(int secao) { this.secao = secao; }

    public boolean getDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(boolean disponibilidade) { this.disponibilidade = disponibilidade; }

    @Override
    public String toString() {
        String status = disponibilidade ? "Disponível" : "Emprestado";
        return String.format("📚 ID: %-4d | 📖 Título: %-30s | ✍️ Autor: %-20s | 🎭 Gênero: %-20s | 📍 Seção: %-4d | 📌 Status: %s",
                             id, titulo, autor, genero, secao, status);
    }
}

package model;

public class Livro {

    private String idLivro;
    private String nome;
    private String autor;
    private String editora;

    public Livro(String nome, String autor, String editora) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
    }

    public Livro(String idLivro, String nome, String autor, String editora) {
        this.idLivro = idLivro;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return String.format(
                "Livro: id=%s - nome=%s - autor=%s - editora=%s",
                idLivro,
                nome,
                autor,
                editora
        );
    }
}
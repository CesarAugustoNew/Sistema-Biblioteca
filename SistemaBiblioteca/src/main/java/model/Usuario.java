package model;

public class Usuario {

    private String idUsuario;
    private String nome;
    private String endereco;
    private String telefone;
    private Integer idLivro;

    public Usuario(
            String nome,
            String endereco,
            String telefone,
            Integer idLivro
    ) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idLivro = idLivro;
    }

    public Usuario(
            String idUsuario,
            String nome,
            String endereco,
            String telefone,
            Integer idLivro
    ) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idLivro = idLivro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    @Override
    public String toString() {
        return String.format(
                "Usuario: id=%s - nome=%s - endereco=%s - telefone=%s - livro=%s",
                idUsuario,
                nome,
                endereco,
                telefone,
                idLivro
        );
    }
}
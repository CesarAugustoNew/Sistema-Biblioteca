package dao;

import model.Livro;
import java.util.List;

public interface ILivroDAO {

    void salvarLivro(Livro livro);

    List<Livro> listarLivros();

    Livro buscarLivroPorId(int id);

    void atualizarLivro(Livro livro);

    void excluirLivro(int id);
}
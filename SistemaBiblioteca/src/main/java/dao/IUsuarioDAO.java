package dao;

import model.Usuario;

import java.util.List;

public interface IUsuarioDAO {

    void salvarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario buscarUsuarioPorId(int id);

    void atualizarUsuario(Usuario usuario);

    void devolverLivro(int idUsuario);

    void excluirUsuario(int id);

    List<Usuario> listarUsuariosPorLivro(int idLivro);
}
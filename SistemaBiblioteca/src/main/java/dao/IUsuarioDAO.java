package dao;

import model.Usuario;
import java.util.List;

public interface IUsuarioDAO {

    void salvarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario buscarUsuarioPorId(int id);

    void excluirUsuario(int id);

    List<Usuario> listarUsuariosPorLivro(int idLivro);
}
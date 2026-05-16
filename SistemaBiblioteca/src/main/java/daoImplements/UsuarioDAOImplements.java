package daoImplements;

import Database.sqlConn;
import dao.IUsuarioDAO;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImplements implements IUsuarioDAO {

    @Override
    public void salvarUsuario(Usuario usuario) {

        String sql =
                "INSERT INTO usuario(nome, endereco, telefone, idLivro) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setString(1, usuario.getNome());
            stnt.setString(2, usuario.getEndereco());
            stnt.setString(3, usuario.getTelefone());

            if (usuario.getIdLivro() != null) {

                stnt.setInt(4, usuario.getIdLivro());

            } else {

                stnt.setNull(4, Types.INTEGER);
            }

            stnt.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {

        String sql = "SELECT * FROM usuario";

        List<Usuario> usuarios = new ArrayList<>();

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql);
                ResultSet rs = stnt.executeQuery()
        ) {

            while (rs.next()) {

                usuarios.add(new Usuario(
                        String.valueOf(rs.getInt("idUsuario")),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        (Integer) rs.getObject("idLivro")
                ));
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }

        return usuarios;
    }

    @Override
    public Usuario buscarUsuarioPorId(int id) {

        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";

        Usuario usuario = null;

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setInt(1, id);

            ResultSet rs = stnt.executeQuery();

            if (rs.next()) {

                usuario = new Usuario(
                        String.valueOf(rs.getInt("idUsuario")),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        (Integer) rs.getObject("idLivro")
                );
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        }

        return usuario;
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {

        String sql =
                "UPDATE usuario SET nome = ?, endereco = ?, telefone = ?, idLivro = ? WHERE idUsuario = ?";

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setString(1, usuario.getNome());
            stnt.setString(2, usuario.getEndereco());
            stnt.setString(3, usuario.getTelefone());

            if (usuario.getIdLivro() != null) {

                stnt.setInt(4, usuario.getIdLivro());

            } else {

                stnt.setNull(4, Types.INTEGER);
            }

            stnt.setInt(5, Integer.parseInt(usuario.getIdUsuario()));

            int linhas = stnt.executeUpdate();

            if (linhas > 0) {

                System.out.println("Usuário atualizado com sucesso!");

            } else {

                System.out.println("Usuário não encontrado.");
            }

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    @Override
    public void devolverLivro(int idUsuario) {

        String sql =
                "UPDATE usuario SET idLivro = NULL WHERE idUsuario = ?";

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setInt(1, idUsuario);

            int linhas = stnt.executeUpdate();

            if (linhas > 0) {

                System.out.println("Livro devolvido com sucesso!");

            } else {

                System.out.println("Usuário não encontrado.");
            }

        } catch (SQLException e) {

            System.out.println("Erro ao devolver livro: " + e.getMessage());
        }
    }

    @Override
    public void excluirUsuario(int id) {

        String sql = "DELETE FROM usuario WHERE idUsuario = ?";

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setInt(1, id);

            int linhas = stnt.executeUpdate();

            if (linhas > 0) {

                System.out.println("Usuário excluído!");

            } else {

                System.out.println("Usuário não encontrado.");
            }

        } catch (SQLException e) {

            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> listarUsuariosPorLivro(int idLivro) {

        String sql = "SELECT * FROM usuario WHERE idLivro = ?";

        List<Usuario> usuarios = new ArrayList<>();

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setInt(1, idLivro);

            ResultSet rs = stnt.executeQuery();

            while (rs.next()) {

                usuarios.add(new Usuario(
                        String.valueOf(rs.getInt("idUsuario")),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        (Integer) rs.getObject("idLivro")
                ));
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar usuários do livro: " + e.getMessage());
        }

        return usuarios;
    }
}
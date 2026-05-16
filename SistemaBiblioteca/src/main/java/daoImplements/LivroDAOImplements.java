package daoImplements;

import Database.sqlConn;
import dao.ILivroDAO;
import model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImplements implements ILivroDAO {

    @Override
    public void salvarLivro(Livro livro) {

        String sql =
                "INSERT INTO livro(nome, autor, editora) VALUES (?, ?, ?)";

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setString(1, livro.getNome());
            stnt.setString(2, livro.getAutor());
            stnt.setString(3, livro.getEditora());

            stnt.executeUpdate();

            System.out.println("Livro cadastrado com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao salvar livro: " + e.getMessage());
        }
    }

    @Override
    public List<Livro> listarLivros() {

        String sql = "SELECT * FROM livro";

        List<Livro> livros = new ArrayList<>();

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql);
                ResultSet rs = stnt.executeQuery()
        ) {

            while (rs.next()) {

                livros.add(new Livro(
                        String.valueOf(rs.getInt("idLivro")),
                        rs.getString("nome"),
                        rs.getString("autor"),
                        rs.getString("editora")
                ));
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar livros: " + e.getMessage());
        }

        return livros;
    }

    @Override
    public Livro buscarLivroPorId(int id) {

        String sql = "SELECT * FROM livro WHERE idLivro = ?";

        Livro livro = null;

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setInt(1, id);

            ResultSet rs = stnt.executeQuery();

            if (rs.next()) {

                livro = new Livro(
                        String.valueOf(rs.getInt("idLivro")),
                        rs.getString("nome"),
                        rs.getString("autor"),
                        rs.getString("editora")
                );
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar livro: " + e.getMessage());
        }

        return livro;
    }

    @Override
    public void atualizarLivro(Livro livro) {

        String sql =
                "UPDATE livro SET nome = ?, autor = ?, editora = ? WHERE idLivro = ?";

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setString(1, livro.getNome());
            stnt.setString(2, livro.getAutor());
            stnt.setString(3, livro.getEditora());

            stnt.setInt(4, Integer.parseInt(livro.getIdLivro()));

            int linhas = stnt.executeUpdate();

            if (linhas > 0) {

                System.out.println("Livro atualizado com sucesso!");

            } else {

                System.out.println("Livro não encontrado.");
            }

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    @Override
    public void excluirLivro(int id) {

        String sql = "DELETE FROM livro WHERE idLivro = ?";

        try (
                Connection conn = sqlConn.getConnection();
                PreparedStatement stnt =
                        conn.prepareStatement(sql)
        ) {

            stnt.setInt(1, id);

            int linhas = stnt.executeUpdate();

            if (linhas > 0) {

                System.out.println("Livro excluído!");

            } else {

                System.out.println("Livro não encontrado.");
            }

        } catch (SQLException e) {

            System.out.println("Erro ao excluir livro: " + e.getMessage());
        }
    }
}
package org.example;

import Database.sqlConn;

import daoImplements.LivroDAOImplements;
import daoImplements.UsuarioDAOImplements;

import model.Livro;
import model.Usuario;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        sqlConn.testeConnction();

        Scanner sc = new Scanner(System.in);

        LivroDAOImplements livroDAO =
                new LivroDAOImplements();

        UsuarioDAOImplements usuarioDAO =
                new UsuarioDAOImplements();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA BIBLIOTECA =====");

            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Buscar Livro");
            System.out.println("4. Atualizar Livro");
            System.out.println("5. Excluir Livro");

            System.out.println("6. Cadastrar Usuário");
            System.out.println("7. Listar Usuários");
            System.out.println("8. Buscar Usuário");
            System.out.println("9. Atualizar Usuário");
            System.out.println("10. Excluir Usuário");

            System.out.println("11. Listar usuários por livro");
            System.out.println("12. Devolver Livro");

            System.out.println("0. Sair");

            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome do livro: ");
                    String nomeLivro = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Editora: ");
                    String editora = sc.nextLine();

                    Livro livro = new Livro(
                            nomeLivro,
                            autor,
                            editora
                    );

                    livroDAO.salvarLivro(livro);

                    break;

                case 2:

                    List<Livro> livros =
                            livroDAO.listarLivros();

                    if (livros.isEmpty()) {

                        System.out.println("Nenhum livro encontrado.");

                    } else {

                        for (Livro l : livros) {
                            System.out.println(l);
                        }
                    }

                    break;

                case 3:

                    System.out.print("ID do livro: ");

                    int idLivro = sc.nextInt();
                    sc.nextLine();

                    Livro livroBuscado =
                            livroDAO.buscarLivroPorId(idLivro);

                    if (livroBuscado != null) {

                        System.out.println(livroBuscado);

                    } else {

                        System.out.println("Livro não encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("ID do livro para atualizar: ");

                    int idAtualizarLivro = sc.nextInt();
                    sc.nextLine();

                    Livro livroExistente =
                            livroDAO.buscarLivroPorId(idAtualizarLivro);

                    if (livroExistente == null) {

                        System.out.println("Livro não encontrado.");
                        break;
                    }

                    System.out.print("Novo nome (" + livroExistente.getNome() + "): ");
                    String novoNomeLivro = sc.nextLine();

                    if (!novoNomeLivro.isEmpty()) {
                        livroExistente.setNome(novoNomeLivro);
                    }

                    System.out.print("Novo autor (" + livroExistente.getAutor() + "): ");
                    String novoAutor = sc.nextLine();

                    if (!novoAutor.isEmpty()) {
                        livroExistente.setAutor(novoAutor);
                    }

                    System.out.print("Nova editora (" + livroExistente.getEditora() + "): ");
                    String novaEditora = sc.nextLine();

                    if (!novaEditora.isEmpty()) {
                        livroExistente.setEditora(novaEditora);
                    }

                    livroDAO.atualizarLivro(livroExistente);

                    break;

                case 5:

                    System.out.print("ID do livro para excluir: ");

                    int excluirLivro = sc.nextInt();
                    sc.nextLine();

                    livroDAO.excluirLivro(excluirLivro);

                    break;

                case 6:

                    System.out.print("Nome do usuário: ");
                    String nomeUsuario = sc.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("ID do livro emprestado (ou 0): ");
                    int livroEmprestado = sc.nextInt();
                    sc.nextLine();

                    Usuario usuario = new Usuario(
                            nomeUsuario,
                            endereco,
                            telefone,
                            livroEmprestado == 0 ? null : livroEmprestado
                    );

                    usuarioDAO.salvarUsuario(usuario);

                    break;

                case 7:

                    List<Usuario> usuarios =
                            usuarioDAO.listarUsuarios();

                    if (usuarios.isEmpty()) {

                        System.out.println("Nenhum usuário encontrado.");

                    } else {

                        for (Usuario u : usuarios) {
                            System.out.println(u);
                        }
                    }

                    break;

                case 8:

                    System.out.print("ID do usuário: ");

                    int idUsuario = sc.nextInt();
                    sc.nextLine();

                    Usuario usuarioBuscado =
                            usuarioDAO.buscarUsuarioPorId(idUsuario);

                    if (usuarioBuscado != null) {

                        System.out.println(usuarioBuscado);

                    } else {

                        System.out.println("Usuário não encontrado.");
                    }

                    break;

                case 9:

                    System.out.print("ID do usuário para atualizar: ");

                    int idAtualizarUsuario = sc.nextInt();
                    sc.nextLine();

                    Usuario usuarioExistente =
                            usuarioDAO.buscarUsuarioPorId(idAtualizarUsuario);

                    if (usuarioExistente == null) {

                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.print("Novo nome (" + usuarioExistente.getNome() + "): ");
                    String novoNomeUsuario = sc.nextLine();

                    if (!novoNomeUsuario.isEmpty()) {
                        usuarioExistente.setNome(novoNomeUsuario);
                    }

                    System.out.print("Novo endereço (" + usuarioExistente.getEndereco() + "): ");
                    String novoEndereco = sc.nextLine();

                    if (!novoEndereco.isEmpty()) {
                        usuarioExistente.setEndereco(novoEndereco);
                    }

                    System.out.print("Novo telefone (" + usuarioExistente.getTelefone() + "): ");
                    String novoTelefone = sc.nextLine();

                    if (!novoTelefone.isEmpty()) {
                        usuarioExistente.setTelefone(novoTelefone);
                    }

                    System.out.print("Novo ID do livro (0 para nenhum): ");

                    int novoLivro = sc.nextInt();
                    sc.nextLine();

                    usuarioExistente.setIdLivro(
                            novoLivro == 0 ? null : novoLivro
                    );

                    usuarioDAO.atualizarUsuario(usuarioExistente);

                    break;

                case 10:

                    System.out.print("ID do usuário para excluir: ");

                    int excluirUsuario = sc.nextInt();
                    sc.nextLine();

                    usuarioDAO.excluirUsuario(excluirUsuario);

                    break;

                case 11:

                    System.out.print("ID do livro: ");

                    int idLivroUsuario = sc.nextInt();
                    sc.nextLine();

                    List<Usuario> usuariosLivro =
                            usuarioDAO.listarUsuariosPorLivro(idLivroUsuario);

                    if (usuariosLivro.isEmpty()) {

                        System.out.println("Nenhum usuário possui esse livro.");

                    } else {

                        for (Usuario u : usuariosLivro) {
                            System.out.println(u);
                        }
                    }

                    break;

                case 12:

                    System.out.print("ID do usuário: ");

                    int usuarioDevolucao = sc.nextInt();
                    sc.nextLine();

                    usuarioDAO.devolverLivro(usuarioDevolucao);

                    break;

                case 0:

                    System.out.println("Saindo...");

                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
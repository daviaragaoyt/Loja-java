package entity;

import DAO.ProdutoDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Produto {
    private int codigo;
    private String nome;
    private String categoria;
    private String tamanho;
    private String cor;
    private String marca;
    private float valor;
    private int quantidade;
    private static ProdutoDAO produtoDAO = new ProdutoDAO();

    public Produto(int codigo, String nome, String categoria, String tamanho, String cor, String marca, float valor,
            int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.cor = cor;
        this.marca = marca;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    // Getters and Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public static void menuProduto(Scanner scan) {
        while (true) {
            System.out.println("\n------ Menu de Produtos ------");
            System.out.println("[1] - Cadastrar Produto");
            System.out.println("[2] - Listar Produtos");
            System.out.println("[3] - Atualizar Produto");
            System.out.println("[4] - Deletar Produto");
            System.out.println("[0] - Voltar");

            int opcao = scan.nextInt();
            scan.nextLine(); // quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarProduto(scan);
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto(scan);
                    break;
                case 4:
                    deletarProduto(scan);
                    break;
                case 0:
                    return; // Volta ao menu anterior
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void cadastrarProduto(Scanner scan) {
        System.out.println("Nome do Produto: ");
        String nome = scan.nextLine();

        System.out.println("Categoria do Produto: ");
        String categoria = scan.nextLine();

        System.out.println("Tamanho do Produto: ");
        String tamanho = scan.nextLine();

        System.out.println("Cor do Produto: ");
        String cor = scan.nextLine();

        System.out.println("Marca do Produto: ");
        String marca = scan.nextLine();

        System.out.println("Valor do Produto: ");
        float valor = scan.nextFloat();
        scan.nextLine(); // quebra de linha

        System.out.println("Quantidade do Produto: ");
        int quantidade = scan.nextInt();
        scan.nextLine(); // quebra de linha

        Produto produto = new Produto(0, nome, categoria, tamanho, cor, marca, valor, quantidade);
        try {
            produtoDAO.cadastrarProduto(produto);
            System.out.println("PRODUTO CADASTRADO!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar produto.");
        }
    }

    public static void listarProdutos() {
        try {
            List<Produto> produtos = produtoDAO.listarProdutos();
            for (Produto p : produtos) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar produtos.");
        }
    }

    public static void atualizarProduto(Scanner scan) {
        System.out.println("Código do Produto a ser atualizado: ");
        int codigo = scan.nextInt();
        scan.nextLine(); // quebra de linha

        System.out.println("Novo Nome do Produto: ");
        String nome = scan.nextLine();

        System.out.println("Nova Categoria do Produto: ");
        String categoria = scan.nextLine();

        System.out.println("Novo Tamanho do Produto: ");
        String tamanho = scan.nextLine();

        System.out.println("Nova Cor do Produto: ");
        String cor = scan.nextLine();

        System.out.println("Nova Marca do Produto: ");
        String marca = scan.nextLine();

        System.out.println("Novo Valor do Produto: ");
        float valor = scan.nextFloat();
        scan.nextLine(); // quebra de linha

        System.out.println("Nova Quantidade do Produto: ");
        int quantidade = scan.nextInt();
        scan.nextLine(); // quebra de linha

        Produto produto = new Produto(codigo, nome, categoria, tamanho, cor, marca, valor, quantidade);
        try {
            produtoDAO.atualizarProduto(produto);
            System.out.println("PRODUTO ATUALIZADO!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar produto.");
        }
    }

    public static void deletarProduto(Scanner scan) {
        System.out.println("Código do Produto a ser deletado: ");
        int codigo = scan.nextInt();
        scan.nextLine(); // quebra de linha

        try {
            produtoDAO.apagarProduto(codigo);
            System.out.println("PRODUTO DELETADO!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar produto.");
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", cor='" + cor + '\'' +
                ", marca='" + marca + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
package entity;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.ProdutoDAO;

public class Produto {
    
    private int cod;
    private float valor;
    private String nome;
    private String categoria;
    private String tamanho;
    private String cor;
    private String marca;
    private int quantidade;
    
    public Produto(int cod, float valor, String nome, String categoria, String tamanho, String cor, String marca, int quantidade) {
        this.cod = cod;
        this.valor = valor;
        this.nome = nome;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.cor = cor;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
	public static void exibirMenu(Scanner scan) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        int opcaoProduto;

        do {
            System.out.println("------ Gerenciamento de Produtos ------");
            System.out.println("[1] - Cadastrar Produto");
            System.out.println("[2] - Atualizar Produto");
            System.out.println("[3] - Buscar Produto");
            System.out.println("[4] - Apagar Produto");
            System.out.println("[0] - Voltar ao Menu Principal");
            opcaoProduto = scan.nextInt();
            scan.nextLine(); // Consome a nova linha

            switch (opcaoProduto) {
                case 1:
                    cadastrarProduto(scan, produtoDAO);
                    break;
                case 2:
                    atualizarProduto(scan, produtoDAO);
                    break;
                case 3:
                    buscarProduto(scan, produtoDAO);
                    break;
                case 4:
                    apagarProduto(scan, produtoDAO);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcaoProduto != 0);
    }

    private static void cadastrarProduto(Scanner scan, ProdutoDAO produtoDAO) {
        System.out.println("Digite o código do produto:");
        int cod = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o valor do produto:");
        float valor = scan.nextFloat();
        scan.nextLine();
        System.out.println("Digite o nome do produto:");
        String nome = scan.nextLine();
        System.out.println("Digite a categoria do produto:");
        String categoria = scan.nextLine();
        System.out.println("Digite o tamanho do produto:");
        String tamanho = scan.nextLine();
        System.out.println("Digite a cor do produto:");
        String cor = scan.nextLine();
        System.out.println("Digite a marca do produto:");
        String marca = scan.nextLine();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scan.nextInt();
        scan.nextLine();

        Produto produto = new Produto(cod, valor, nome, categoria, tamanho, cor, marca, quantidade);
        try {
            produtoDAO.cadastrarProduto(produto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarProduto(Scanner scan, ProdutoDAO produtoDAO) {
        System.out.println("Digite o código do produto que deseja atualizar:");
        int cod = scan.nextInt();
        scan.nextLine();

        try {
            Produto produto = produtoDAO.buscarProduto(cod);
            if (produto != null) {
                System.out.println("Digite o novo valor do produto:");
                float valor = scan.nextFloat();
                scan.nextLine();
                System.out.println("Digite o novo nome do produto:");
                String nome = scan.nextLine();
                System.out.println("Digite a nova categoria do produto:");
                String categoria = scan.nextLine();
                System.out.println("Digite o novo tamanho do produto:");
                String tamanho = scan.nextLine();
                System.out.println("Digite a nova cor do produto:");
                String cor = scan.nextLine();
                System.out.println("Digite a nova marca do produto:");
                String marca = scan.nextLine();
                System.out.println("Digite a nova quantidade do produto:");
                int quantidade = scan.nextInt();
                scan.nextLine();

                produto.setValor(valor);
                produto.setNome(nome);
                produto.setCategoria(categoria);
                produto.setTamanho(tamanho);
                produto.setCor(cor);
                produto.setMarca(marca);
                produto.setQuantidade(quantidade);

                produtoDAO.atualizarProduto(produto);
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void buscarProduto(Scanner scan, ProdutoDAO produtoDAO) {
        System.out.println("Digite o código do produto que deseja buscar:");
        int cod = scan.nextInt();
        scan.nextLine();

        try {
            Produto produto = produtoDAO.buscarProduto(cod);
            if (produto != null) {
                System.out.println("Produto encontrado: ");
                System.out.println("Código: " + produto.getCod());
                System.out.println("Valor: " + produto.getValor());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Categoria: " + produto.getCategoria());
                System.out.println("Tamanho: " + produto.getTamanho());
                System.out.println("Cor: " + produto.getCor());
                System.out.println("Marca: " + produto.getMarca());
                System.out.println("Quantidade: " + produto.getQuantidade());
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void apagarProduto(Scanner scan, ProdutoDAO produtoDAO) {
        System.out.println("Digite o código do produto que deseja apagar:");
        int cod = scan.nextInt();
        scan.nextLine();

        try {
            produtoDAO.apagarProduto(cod);
            System.out.println("Produto apagado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
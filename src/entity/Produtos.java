package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produtos {
	
	private int cod;
	private float valor;
	private String nome;
	private String categoria;
	private String tamanho;
	private String cor;
	private String marca;
	private int quantidade;
	
	public Produtos(int cod, float valor, String nome, String categoria, String tamanho, String cor, String marca, int quantidade){
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
	
	//List<Produto> listaProdutos
	
	public static void exibirMenu() {
        Scanner scan = new Scanner(System.in);
        List<Produtos> listaProdutos = new ArrayList<>();
        int  opcaoProduto;
        
        do {
            System.out.println("------ Gerenciamento de Produtos ------");
            System.out.println("[1] - Cadastrar Produto");
            System.out.println("[2] - Buscar Produto");
            System.out.println("[0] - Voltar ao Menu Principal");
            opcaoProduto = scan.nextInt();

            switch (opcaoProduto) {
                case 1:
                    cadastrarProdutos(listaProdutos);
                    break;
                //case 2:
                    //atualizarProduto(listaProdutos);
                    //break;
                case 2:
                    buscarProdutos(listaProdutos);
                    break;
                
                //case 4:
                   // apagarProduto(listaProdutos);
                   // break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break; // Encerra o programa
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcaoProduto != 0);
        scan.close();
    }

	/*public static void exibirMenu() {
		
		System.out.println("\n------ Gerenciamento de Produtos ------");
        System.out.println("[1] - Cadastrar Produto");
        System.out.println("[2] - Atualizar Produto");
        System.out.println("[3] - Buscar Produto");
        System.out.println("[4] - Apagar Produto");
        System.out.println("[0] - SAIR");
	}*/
	
	public static void cadastrarProdutos(List<Produtos> listaProdutos) {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		
		System.out.println("Código: ");
		int cod = scan.nextInt();
		scan.nextLine(); //quebra de linha
		
		System.out.println("Categoria: ");
		String categoria = scan.nextLine();
		
		System.out.println("Tamanho: ");
		String tamanho = scan.nextLine();
		
		System.out.println("Marca: ");
		String marca = scan.nextLine();
		
		System.out.println("Cor: ");
		String cor = scan.nextLine();
		
		System.out.println("Valor: ");
		float valor = scan.nextFloat();
		
		System.out.println("Quantidade: ");
		int quantidade = scan.nextInt();
		
		Produtos produto = new Produtos (cod, valor, nome, categoria, tamanho, cor, marca, quantidade);
		
		listaProdutos.add(produto);
		
		System.out.println("PRODUTO CADASTRADO!");
		scan.close();
	}

	
	public static void buscarProdutos(List<Produtos> listaProdutos) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\\n------ Lista de Produtos ------");
		for (Produtos produto : listaProdutos) {
			System.out.println(produto.getCod() + " - " + produto.getNome());
		}
		scan.close();
	}
	
}
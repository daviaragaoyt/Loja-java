package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
	
	public int cod;
	public float valor;
	public String nome;
	public String categoria;
	public String tamanho;
	public String cor;
	public String marca;
	public int quantidade;
	
	public Produto(int cod, float valor, String nome, String categoria, String tamanho, String cor, String marca, int quantidade){
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
	//O "Scanner scan" como parâmetro faz com que não seja necessário a declaração do Scanner em cada método
	
	public static void exibirMenu(Scanner scan) {
        //Scanner scan = new Scanner(System.in);
        List<Produto> listaProdutos = new ArrayList<>();
        int  opcaoProduto;
        
        do {
            System.out.println("------ Gerenciamento de Produtos ------");
            System.out.println("[1] - Cadastrar Produto");
            System.out.println("[2] - Atualizar Produto");
            System.out.println("[3] - Buscar Produto");
            System.out.println("[4] - Apagar Produto");
            System.out.println("[0] - Voltar ao Menu Principal");
            opcaoProduto = scan.nextInt();

            switch (opcaoProduto) {
                case 1:
                    cadastrarProduto(scan, listaProdutos); //cadastrarProduto(scan, listaProdutos);
                    break;
                case 2:
                    atualizarProduto(scan, listaProdutos);
                    break;
                case 3:
                    buscarProduto(scan, listaProdutos);
                    break;
                
                case 4:
                	apagarProduto(scan, listaProdutos);
                   	break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break; // Encerra o programa
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcaoProduto != 0);
		//scan.close();
    }
	
	public static void cadastrarProduto(Scanner scan, List<Produto> listaProdutos) {
		//Scanner scan = new Scanner (System.in);
		
		System.out.println("Código: ");
		int cod = scan.nextInt();
		scan.nextLine(); //quebra de linha
		
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		
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
		
		Produto produto = new Produto (cod, valor, nome, categoria, tamanho, cor, marca, quantidade);
		
		listaProdutos.add(produto);
		
		System.out.println("PRODUTO CADASTRADO!");
		//scan.close();
	}
	
	public static void atualizarProduto(Scanner scan, List<Produto> listaProdutos) {
		//Scanner scan = new Scanner(System.in);

	    System.out.println("Digite o código do produto que deseja atualizar: ");
	    int cod = scan.nextInt();
	  
	    for (Produto produto : listaProdutos) {
	        if (produto.getCod() == cod) {
	            System.out.println("Nome: ");
	            @SuppressWarnings("unused")
				String nome = scan.nextLine();

	            System.out.println("Categoria: ");
				@SuppressWarnings("unused")
	            String categoria = scan.nextLine();

	            System.out.println("Tamanho: ");
				@SuppressWarnings("unused")
	            String tamanho = scan.nextLine();

	            System.out.println("Marca: ");
				@SuppressWarnings("unused")
	            String marca = scan.nextLine();

	            System.out.println("Cor: ");
				@SuppressWarnings("unused")
	            String cor = scan.nextLine();

	            System.out.println("Valor: ");
				@SuppressWarnings("unused")
	            float valor = scan.nextFloat();
	          

	            System.out.println("Quantidade: ");
				@SuppressWarnings("unused")	
	            int quantidade = scan.nextInt();
	          
	            
	            System.out.println("Produto atualizado com sucesso!");
	            return;
	        }
			scan.close();
	    }
	    System.out.println("Produto não encontrado com o código fornecido.");
	}
	
	
	public static void buscarProduto(Scanner scan, List<Produto> listaProdutos) {
		//Scanner scan = new Scanner(System.in);
		
		System.out.println("------ Lista de Produtos ------");
		for (Produto produto : listaProdutos) {
			System.out.println(produto.getCod() + " - " + produto.getNome());
			System.out.println("------ ------ ------ ------");
		}
		//scan.close();
	}
	
	public static void apagarProduto(Scanner scan, List<Produto> listaProdutos) {
		//Scanner scan = new Scanner(System.in);

	    System.out.println("Digite o código do produto que deseja apagar: ");
	    int cod = scan.nextInt();
	  

	    for (Produto produto : listaProdutos) {
	        if (produto.getCod() == cod) {
	            listaProdutos.remove(produto);
	            System.out.println("Produto apagado com sucesso!");
	            return;
	        }
			//scan.close();
	    }

	    System.out.println("Produto não encontrado com o código fornecido.");
	}
	
}
package entity;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	public String dtAdmissao;
	
	public Funcionario(String nome, String dtNascimento, String num_tel, String email, int id, String dtAdmissaoStr) {
		super(nome, dtNascimento, num_tel, email, id);
		this.dtAdmissao = dtAdmissao;
	}

	public String getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(String dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}
	
	public static void exibirMenu() {
		System.out.println("\n------ Gerenciamento de Funcionários ------");
        System.out.println("[1] - Cadastrar Funcionário");
        System.out.println("[2] - Atualizar Funcionário");
        System.out.println("[3] - Buscar Funcionário");
        System.out.println("[4] - Apagar Funcionário");
        System.out.println("[0] - SAIR");
	}
	
	
	public static void cadastrarFuncionario(List<Funcionario> listaFuncionarios) {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		
		System.out.println("CPF: ");
		int id = scan.nextInt();
		scan.nextLine(); //quebra de linha
		
		System.out.println("Data de Nascimento (dd/MM/aaaa): ");
        String dtNascimento = scan.nextLine();
        
		
		System.out.println("Telefone: ");
		String num_tel = scan.nextLine();
		
		System.out.println("E-mail: ");
		String email = scan.nextLine();
		
		System.out.println("Data de Admissão (dd/MM/aaaa): ");
        String dtAdmissao = scan.nextLine();
        

		Funcionario funcionario = new Funcionario (nome, dtNascimento, num_tel, email, id,dtAdmissao);
		
		if (extracted(listaFuncionarios) == null) {
            extracted(listaFuncionarios).add(funcionario);
            System.out.println("FUNCIONÁRIO CADASTRADO!");
        } else {
            System.out.println("Erro: lista de funcionários não inicializada.");
        }
		
		scan.close();
    }

	private static List<Funcionario> extracted(List<Funcionario> listaFuncionarios) {
		return listaFuncionarios;
	}			
}
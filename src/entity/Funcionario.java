package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DAO.FuncionarioDAO;
import conexao.Conexao;

public class Funcionario extends Pessoa {
    private String dtAdmissao;
    
    public Funcionario(String nome, String dtNascimento, String num_tel, String email, int id, String dtAdmissao) {
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do funcionário:");
        String nome = scan.nextLine();
        System.out.println("Digite a data de nascimento:");
        String dtNascimento = scan.nextLine();
        System.out.println("Digite o número de telefone:");
        String numTel = scan.nextLine();
        System.out.println("Digite o email:");
        String email = scan.nextLine();
        System.out.println("Digite o ID:");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite a data de admissão:");
        String dtAdmissao = scan.nextLine();

        Funcionario funcionario = new Funcionario(nome, dtNascimento, numTel, email, id, dtAdmissao);
        listaFuncionarios.add(funcionario);

        FuncionarioDAO dao = new FuncionarioDAO();
        try {
            dao.cadastrarFuncionario(funcionario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		scan.close();
    }
	public static void atualizarFuncionario(List<Funcionario> listaFuncionarios) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o ID do funcionário que deseja atualizar:");
		int id = scan.nextInt();
		scan.nextLine(); // Consumir a quebra de linha
	
		// Procurar o funcionário na lista pelo ID
		Funcionario funcionario = null;
		for (Funcionario f : listaFuncionarios) {
			if (f.getId() == id) {
				funcionario = f;
				break;
			}
		}
	
		if (funcionario != null) {
			System.out.println("Digite o novo nome do funcionário:");
			funcionario.setNome(scan.nextLine());
			System.out.println("Digite a nova data de nascimento:");
			funcionario.setDtNascimento(scan.nextLine());
			System.out.println("Digite o novo número de telefone:");
			funcionario.setNum_tel(scan.nextLine());
			System.out.println("Digite o novo email:");
			funcionario.setEmail(scan.nextLine());
			System.out.println("Digite a nova data de admissão:");
			funcionario.setDtAdmissao(scan.nextLine());
	
			FuncionarioDAO dao = new FuncionarioDAO();
			try {
				dao.atualizarFuncionario(funcionario);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Funcionário não encontrado.");
		}
		scan.close();
	}
	
	public static void buscarFuncionario(List<Funcionario> listaFuncionarios) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o ID do funcionário que deseja buscar:");
		int id = scan.nextInt();
		scan.nextLine(); // Consumir a quebra de linha
	
		// Procurar o funcionário na lista pelo ID
		Funcionario funcionario = null;
		for (Funcionario f : listaFuncionarios) {
			if (f.getId() == id) {
				funcionario = f;
				break;
			}
		}
	
		if (funcionario != null) {
			System.out.println("Funcionário encontrado:");
			System.out.println(funcionario);
		} else {
			System.out.println("Funcionário não encontrado.");
		}
		scan.close();
	}
	
	public void apagarFuncionario(int id) throws SQLException {
    String sql = "DELETE FROM FUNCIONARIO WHERE ID = ?";
    try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
	
}

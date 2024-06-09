

import DAO.FuncionarioDAO;
import entity.Funcionario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Loja {
    private static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public static void cadastrarFuncionario(Scanner scan) {
        System.out.println("Nome: ");
        String nome = scan.nextLine();

        System.out.println("CPF: ");
        int id = scan.nextInt();
        scan.nextLine(); // quebra de linha

        System.out.println("Data de Nascimento (dd/MM/yyyy): ");
        LocalDate dtNascimento = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Telefone: ");
        String num_tel = scan.nextLine();

        System.out.println("E-mail: ");
        String email = scan.nextLine();

        System.out.println("Data de Admissão (dd/MM/yyyy): ");
        LocalDate dtAdmissao = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Funcionario funcionario = new Funcionario(nome, dtNascimento, num_tel, email, id, dtAdmissao);
        try {
            funcionarioDAO.cadastrarFuncionario(funcionario);
            System.out.println("FUNCIONÁRIO CADASTRADO!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar funcionário.");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ Gerenciamento de Funcionários ------");
            System.out.println("[1] - Cadastrar Funcionário");
            System.out.println("[0] - SAIR");

            int opcao = scan.nextInt();
            scan.nextLine(); // quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarFuncionario(scan);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scan.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

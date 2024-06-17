package entity;

import DAO.FuncionarioDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    private LocalDate dtAdmissao;
    private static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public Funcionario(String nome, LocalDate dtNascimento, String numTel, String email, int id, LocalDate dtAdmissao) {
        super(nome, dtNascimento, numTel, email, id);
        this.dtAdmissao = dtAdmissao;
    }

    public LocalDate getDtAdmissao() {
        return dtAdmissao;
    }

    public static void menuFuncionario(Scanner scan) {
        while (true) {
            System.out.println("\n------ Menu de Funcionários ------");
            System.out.println("[1] - Cadastrar Funcionário");
            System.out.println("[2] - Listar Funcionários");
            System.out.println("[3] - Atualizar Funcionário");
            System.out.println("[4] - Deletar Funcionário");
            System.out.println("[0] - Voltar");

            int opcao = scan.nextInt();
            scan.nextLine(); // quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarFuncionario(scan);
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    atualizarFuncionario(scan);
                    break;
                case 4:
                    deletarFuncionario(scan);
                    break;
                case 0:
                    return; // Volta ao menu anterior
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

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

    public static void listarFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar funcionários.");
        }
    }

    public static void atualizarFuncionario(Scanner scan) {
        System.out.println("CPF do Funcionário a ser atualizado: ");
        int id = scan.nextInt();
        scan.nextLine(); // quebra de linha

        System.out.println("Nome atualizado: ");
        String nome = scan.nextLine();

        System.out.println("Data de Nascimento atualizada (dd/MM/yyyy): ");
        LocalDate dtNascimento = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Telefone atualizado: ");
        String num_tel = scan.nextLine();

        System.out.println("E-mail atualizado: ");
        String email = scan.nextLine();

        System.out.println("Data de Admissão atualizada (dd/MM/yyyy): ");
        LocalDate dtAdmissao = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Funcionario funcionario = new Funcionario(nome, dtNascimento, num_tel, email, id, dtAdmissao);
        try {
            funcionarioDAO.atualizarFuncionario(funcionario);
            System.out.println("FUNCIONÁRIO ATUALIZADO!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar funcionário.");
        }
    }

    public static void deletarFuncionario(Scanner scan) {
        System.out.println("CPF do Funcionário a ser deletado: ");
        int id = scan.nextInt();
        scan.nextLine(); // quebra de linha

        try {
            funcionarioDAO.apagarFuncionario(id);
            System.out.println("FUNCIONÁRIO DELETADO!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar funcionário.");
        }
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", dtNascimento=" + getDtNascimento() +
                ", numTel='" + getNumTel() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", dtAdmissao=" + dtAdmissao +
                '}';
    }
}

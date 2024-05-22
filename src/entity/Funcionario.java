package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    
    private LocalDate dtAdmissao;

    public Funcionario(String nome, LocalDate dtNascimento, String num_tel, String email, int id, LocalDate dtAdmissao) {
        super(nome, dtNascimento, num_tel, email, id);
        this.dtAdmissao = dtAdmissao;
    }

    public LocalDate getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(LocalDate dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public static void exibirMenu(List<Funcionario> listaFuncionarios) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n------ Gerenciamento de Funcionários ------");
        System.out.println("[1] - Cadastrar Funcionário");
        System.out.println("[2] - Atualizar Funcionário");
        System.out.println("[3] - Buscar Funcionário");
        System.out.println("[4] - Apagar Funcionário");
        System.out.println("[0] - SAIR");
        int decisao = scan.nextInt();

        switch (decisao) {
            case 1:
                cadastrarFuncionario(listaFuncionarios);
                break;
        }
        scan.close();
    }

    public static void cadastrarFuncionario(List<Funcionario> listaFuncionarios) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = scan.nextLine();

        System.out.println("Data de Nascimento (dd/MM/aaaa): ");
        String dtNascimentoStr = scan.nextLine();
        LocalDate dtNascimento = LocalDate.parse(dtNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Telefone: ");
        String num_tel = scan.nextLine();

        System.out.println("E-mail: ");
        String email = scan.nextLine();

        System.out.println("CPF (Ultimos 4 digitos):");
        int id = scan.nextInt();
        scan.nextLine(); // Limpar buffer

        System.out.println("Data de Admissão (dd/MM/aaaa): ");
        String dtAdmissaoStr = scan.nextLine();
        LocalDate dtAdmissao = LocalDate.parse(dtAdmissaoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Funcionario funcionario = new Funcionario(nome, dtNascimento, num_tel, email, id, dtAdmissao);

        if (listaFuncionarios != null) {
            listaFuncionarios.add(funcionario);
            System.out.println("FUNCIONÁRIO CADASTRADO!");
        } else {
            System.out.println("Erro: lista de funcionários não inicializada.");
        }

        scan.close();
    }
}

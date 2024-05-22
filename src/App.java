import entity.Pessoa;
import DAO.PessoaDAO;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Pessoa p = new Pessoa();
        p.setNome("Davi");
        p.setNum_tel("6198261-1486");
        p.setEmail("daviaragaodf1@gmail.com");

        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Selecione seu tipo de Usuário:");
            System.out.println("[1] - Funcionario");
            System.out.println("[0] - Finalizar Programa");
            int opc = scan.nextInt();

            switch (opc) {
                case 1:
                    Funcionario.exibirMenu();
                    break;

                case 0:
                    continuar = false;
                    System.out.println("Programa Finalizado!");
                    break;

                default:
                    System.out.println("[ERROR]: Revise a escolha olhando as opções acima");
                    break;
            }
            break;
        }
        scan.close();

        // Exemplo de uso do DAO para salvar a pessoa
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.cadastrarPessoa(p);
    }
}

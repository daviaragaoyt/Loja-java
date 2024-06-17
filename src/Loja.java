

import java.util.Scanner;
import entity.Funcionario;
import entity.Produto;

public class Loja {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ Menu Principal ------");
            System.out.println("[1] - Gerenciamento de Funcionários");
            System.out.println("[2] - Gerenciamento de Produtos");
            System.out.println("[0] - Sair");

            int opcao = scan.nextInt();
            scan.nextLine(); // quebra de linha

            switch (opcao) {
                case 1:
                    Funcionario.menuFuncionario(scan);
                    break;
                case 2:
                    Produto.menuProduto(scan);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}

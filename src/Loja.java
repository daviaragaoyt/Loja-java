

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Funcionario;
import entity.Produto;

public class Loja {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        int opc;
        do {
            System.out.println("[1] - Iniciar Sistema");
            System.out.println("[0] - Finalizar Sistema");
            opc = scan.nextInt();

            switch (opc) {
                case 0:
                    System.out.println("Sistema Finalizado!");
                    break;

                case 1:
                    System.out.println("\n---- MENU ----");
                    System.out.println("[1] - Gerenciamento de Funcionários");
                    System.out.println("[2] - Gerenciamento de Produtos");
                    System.out.println("[3] - Realizar Vendas");
                    System.out.println("[0] - SAIR");
                    int opcao2 = scan.nextInt();

                    switch (opcao2) {
                        case 0:
                            System.out.println("Operação Finalizada!");
                            break;

                        case 1:
                            Funcionario.exibirMenu();
                           
                            break;

                        case 2:
                            Produto.exibirMenu(scan);
                            break;

                        // case 3: Realizar vendas não implementado

                        default:
                            System.out.println("Opção Inválida!");
                            System.out.println("---- Revise a Escolha ----");
                            break;
                    }
            }
        } while (opc != 0);
        scan.close();
    }
}

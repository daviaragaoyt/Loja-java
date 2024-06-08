import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Funcionario;
import entity.Produto;

public class Loja {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        @SuppressWarnings("unused")
        List<Produto> listaProdutos = new ArrayList<>();

        int opc;
        do {
            System.out.println("[1] - Iniciar Sistema");
            System.out.println("[0] - Finalizar Sistema");
            opc = scan.nextInt();
            scan.nextLine(); // Consome a nova linha

            switch (opc) {
                case 0:
                    System.out.println("Sistema Finalizado!");
                    break;

                case 1:
                    int opcao2;
                    do {
                        System.out.println("\n---- MENU ----");
                        System.out.println("[1] - Gerenciamento de Funcionários");
                        System.out.println("[2] - Gerenciamento de Produtos");
                        System.out.println("[3] - Realizar Vendas");
                        System.out.println("[0] - SAIR");
                        opcao2 = scan.nextInt();
                        scan.nextLine(); // Consome a nova linha

                        switch (opcao2) {
                            case 0:
                                System.out.println("Operação Finalizada!");
                                break;

                            case 1:
                                Funcionario.exibirMenu();
                                int opcaoFuncionario = scan.nextInt();
                                scan.nextLine(); // Consome a nova linha
                                switch (opcaoFuncionario) {
                                    case 1:
                                        Funcionario.cadastrarFuncionario(listaFuncionarios);
                                        break;
                                    // Adicione outros casos para atualizar, buscar e apagar funcionários
                                    default:
                                        System.out.println("Opção Inválida!");
                                        break;
                                }
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
                    } while (opcao2 != 0);
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opc != 0);
        scan.close();
    }
}

import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;
import DAO.EstoqueDAO;
import entity.Estoque;
import entity.Funcionario;
import entity.Produto;
import entity.Venda;

public class Loja {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        EstoqueDAO estoqueDAO = new EstoqueDAO();
          Venda venda = new Venda();

        while (true) {
            System.out.println("\n------ Menu Principal ------");
            System.out.println("[1] - Gerenciamento de Funcionários");
            System.out.println("[2] - Gerenciamento de Produtos");
            System.out.println("[3] - Listar estoque");
            System.out.println("[4] - Vender produto");
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
                case 3:
                    listarEstoque(estoqueDAO);
                    break;
                case 4:
                    // Implementar venda de produto
                    realizarVenda(scan, venda);
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

    public static void listarEstoque(EstoqueDAO estoqueDAO) {
        try {
            List<Estoque> estoques = estoqueDAO.listarEstoque();
            if (estoques.isEmpty()) {
                System.out.println("Não há itens no estoque.");
            } else {
                System.out.println("\n------ Estoque ------");
                for (Estoque estoque : estoques) {
                    System.out.println("Produto ID: " + estoque.getProdutoId() + " - Quantidade: " + estoque.getQuantidade());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar o estoque: " + e.getMessage());
        }
    }
    public static void realizarVenda(Scanner scan, Venda venda) {
        System.out.println("Código do Produto a ser vendido: ");
        int codigo = scan.nextInt();
        scan.nextLine(); // quebra de linha

        System.out.println("Quantidade a ser vendida: ");
        int quantidade = scan.nextInt();
        scan.nextLine(); // quebra de linha

        try {
            venda.realizarVenda(codigo, quantidade);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar a venda: " + e.getMessage());
        }
    }
}

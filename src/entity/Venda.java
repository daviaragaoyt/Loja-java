package entity;

import DAO.ProdutoDAO;
import DAO.VendaDAO;
import DAO.EstoqueDAO;
import DAO.FuncionarioDAO; // Importar FuncionarioDAO
import java.sql.SQLException;

public class Venda {
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private EstoqueDAO estoqueDAO = new EstoqueDAO();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); // Instanciar FuncionarioDAO

    // Adicionar código do funcionário como parâmetro
    public void realizarVenda(int codigoProduto, int quantidadeVendida, int codigoFuncionario) throws SQLException {
        // Verifica se há estoque suficiente
        Produto produto = produtoDAO.buscarProduto(codigoProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if (produto.getQuantidade() < quantidadeVendida) {
            System.out.println("Não há estoque suficiente para realizar esta venda.");
            return;
        }

        // Registra a venda na tabela VENDA
        float valorTotal = produto.getValor() * quantidadeVendida;
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.registrarVenda(codigoProduto, quantidadeVendida, valorTotal);

        // Atualiza a quantidade no estoque
        int novaQuantidade = produto.getQuantidade() - quantidadeVendida;
        Estoque estoque = new Estoque(codigoProduto, novaQuantidade);
        estoqueDAO.atualizarEstoque(estoque);

        // Busca o nome do funcionário
        String nomeFuncionario = funcionarioDAO.buscarNomeFuncionario(codigoFuncionario);

        // Mensagem de confirmação da venda
        System.out.println("Venda realizada com sucesso!");
        System.out.println("Quantidade vendida: " + quantidadeVendida);
        System.out.println("Nome do funcionário: " + nomeFuncionario);
        System.out.println("Valor total: " + valorTotal);
    }
}

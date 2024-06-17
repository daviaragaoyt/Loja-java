package DAO;

import conexao.Conexao;
import entity.Produto;
import entity.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private EstoqueDAO estoqueDAO = new EstoqueDAO();

    public void cadastrarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, CATEGORIA, TAMANHO, COR, MARCA, VALOR, QUANTIDADE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setString(3, produto.getTamanho());
            ps.setString(4, produto.getCor());
            ps.setString(5, produto.getMarca());
            ps.setFloat(6, produto.getValor());
            ps.setInt(7, produto.getQuantidade());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    produto.setCodigo(rs.getInt(1)); // Definir o código gerado automaticamente
                }
            }
            // Inserir no estoque com a quantidade inicial do produto
            Estoque estoque = new Estoque(produto.getCodigo(), produto.getQuantidade());
            estoqueDAO.atualizarEstoque(estoque);
        }
    }

    public void atualizarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET NOME = ?, CATEGORIA = ?, TAMANHO = ?, COR = ?, MARCA = ?, VALOR = ?, QUANTIDADE = ? WHERE COD = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setString(3, produto.getTamanho());
            ps.setString(4, produto.getCor());
            ps.setString(5, produto.getMarca());
            ps.setFloat(6, produto.getValor());
            ps.setInt(7, produto.getQuantidade());
            ps.setInt(8, produto.getCodigo());
            ps.executeUpdate();
            
            // Atualizar a quantidade no estoque
            Estoque estoque = new Estoque(produto.getCodigo(), produto.getQuantidade());
            estoqueDAO.atualizarEstoque(estoque);
        }
    }

    public Produto buscarProduto(int codigo) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE COD = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                        rs.getInt("COD"),
                        rs.getString("NOME"),
                        rs.getString("CATEGORIA"),
                        rs.getString("TAMANHO"),
                        rs.getString("COR"),
                        rs.getString("MARCA"),
                        rs.getFloat("VALOR"),
                        rs.getInt("QUANTIDADE")
                    );
                }
            }
        }
        return null;
    }

    public void apagarProduto(int codigo) throws SQLException {
        String sql = "DELETE FROM PRODUTO WHERE COD = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
            
            // Deletar o produto do estoque
            estoqueDAO.apagarEstoque(codigo);
        }
    }

    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("COD"),
                    rs.getString("NOME"),
                    rs.getString("CATEGORIA"),
                    rs.getString("TAMANHO"),
                    rs.getString("COR"),
                    rs.getString("MARCA"),
                    rs.getFloat("VALOR"),
                    rs.getInt("QUANTIDADE")
                );
                produtos.add(produto);
            }
        }
        return produtos;
    }
}

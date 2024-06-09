package DAO;

import conexao.Conexao;
import entity.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (ID, NOME, PRECO, QUANTIDADE) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, produto.getId());
            ps.setString(2, produto.getNome());
            ps.setDouble(3, produto.getPreco());
            ps.setInt(4, produto.getQuantidade());
            ps.executeUpdate();
        }
    }

    public void atualizarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET NOME = ?, PRECO = ?, QUANTIDADE = ? WHERE ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidade());
            ps.setInt(4, produto.getId());
            ps.executeUpdate();
        }
    }

    public Produto buscarProduto(int id) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getDouble("PRECO"),
                        rs.getInt("QUANTIDADE")
                    );
                }
            }
        }
        return null;
    }

    public void apagarProduto(int id) throws SQLException {
        String sql = "DELETE FROM PRODUTO WHERE ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("ID"),
                    rs.getString("NOME"),
                    rs.getDouble("PRECO"),
                    rs.getInt("QUANTIDADE")
                );
                produtos.add(produto);
            }
        }
        return produtos;
    }
}

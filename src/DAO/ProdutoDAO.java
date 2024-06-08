package DAO;

import conexao.Conexao;
import entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (COD, VALOR, NOME, CATEGORIA, TAMANHO, COR, MARCA, QUANTIDADE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, produto.getCod());
            ps.setFloat(2, produto.getValor());
            ps.setString(3, produto.getNome());
            ps.setString(4, produto.getCategoria());
            ps.setString(5, produto.getTamanho());
            ps.setString(6, produto.getCor());
            ps.setString(7, produto.getMarca());
            ps.setInt(8, produto.getQuantidade());
            ps.executeUpdate();
        }
    }

    public void atualizarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET VALOR = ?, NOME = ?, CATEGORIA = ?, TAMANHO = ?, COR = ?, MARCA = ?, QUANTIDADE = ? WHERE COD = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setFloat(1, produto.getValor());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getCategoria());
            ps.setString(4, produto.getTamanho());
            ps.setString(5, produto.getCor());
            ps.setString(6, produto.getMarca());
            ps.setInt(7, produto.getQuantidade());
            ps.setInt(8, produto.getCod());
            ps.executeUpdate();
        }
    }

    public Produto buscarProduto(int cod) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE COD = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cod);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                        rs.getInt("COD"),
                        rs.getFloat("VALOR"),
                        rs.getString("NOME"),
                        rs.getString("CATEGORIA"),
                        rs.getString("TAMANHO"),
                        rs.getString("COR"),
                        rs.getString("MARCA"),
                        rs.getInt("QUANTIDADE")
                    );
                }
            }
        }
        return null;
    }

    public void apagarProduto(int cod) throws SQLException {
        String sql = "DELETE FROM PRODUTO WHERE COD = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cod);
            ps.executeUpdate();
        }
    }

    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("COD"),
                    rs.getFloat("VALOR"),
                    rs.getString("NOME"),
                    rs.getString("CATEGORIA"),
                    rs.getString("TAMANHO"),
                    rs.getString("COR"),
                    rs.getString("MARCA"),
                    rs.getInt("QUANTIDADE")
                );
                produtos.add(produto);
            }
        }
        return produtos;
    }
}

package DAO;

import conexao.Conexao;
import entity.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    public void atualizarEstoque(Estoque estoque) throws SQLException {
        String sql = "INSERT INTO ESTOQUE (PRODUTO_ID, QUANTIDADE) VALUES (?, ?) " +
                     "ON DUPLICATE KEY UPDATE QUANTIDADE = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, estoque.getProdutoId());
            ps.setInt(2, estoque.getQuantidade());
            ps.setInt(3, estoque.getQuantidade());
            ps.executeUpdate();
        }
    }

    public Estoque buscarEstoque(int produtoId) throws SQLException {
        String sql = "SELECT * FROM ESTOQUE WHERE PRODUTO_ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, produtoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Estoque(
                        rs.getInt("PRODUTO_ID"),
                        rs.getInt("QUANTIDADE")
                    );
                }
            }
        }
        return null;
    }

    public void apagarEstoque(int produtoId) throws SQLException {
        String sql = "DELETE FROM ESTOQUE WHERE PRODUTO_ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, produtoId);
            ps.executeUpdate();
        }
    }

    public List<Estoque> listarEstoque() throws SQLException {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT * FROM ESTOQUE";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Estoque estoque = new Estoque(
                    rs.getInt("PRODUTO_ID"),
                    rs.getInt("QUANTIDADE")
                );
                estoques.add(estoque);
            }
        }
        return estoques;
    }
}

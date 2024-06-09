package DAO;

import conexao.Conexao;
import entity.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public void registrarVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO VENDA (ID, PRODUTO_ID, QUANTIDADE, DATA_VENDA) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, venda.getId());
            ps.setInt(2, venda.getProdutoId());
            ps.setInt(3, venda.getQuantidade());
            ps.setDate(4, Date.valueOf(venda.getDataVenda()));
            ps.executeUpdate();
        }
    }

    public Venda buscarVenda(int id) throws SQLException {
        String sql = "SELECT * FROM VENDA WHERE ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Venda(
                        rs.getInt("ID"),
                        rs.getInt("PRODUTO_ID"),
                        rs.getInt("QUANTIDADE"),
                        rs.getDate("DATA_VENDA").toLocalDate()
                    );
                }
            }
        }
        return null;
    }

    public List<Venda> listarVendas() throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM VENDA";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Venda venda = new Venda(
                    rs.getInt("ID"),
                    rs.getInt("PRODUTO_ID"),
                    rs.getInt("QUANTIDADE"),
                    rs.getDate("DATA_VENDA").toLocalDate()
                );
                vendas.add(venda);
            }
        }
        return vendas;
    }
}

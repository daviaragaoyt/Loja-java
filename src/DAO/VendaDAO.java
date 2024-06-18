package DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {
    public void registrarVenda(int produtoId, int quantidade, float valorTotal) throws SQLException {
        String sql = "INSERT INTO VENDA (PRODUTO_ID, QUANTIDADE, VALOR_TOTAL) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, produtoId);
            ps.setInt(2, quantidade);
            ps.setFloat(3, valorTotal);
            ps.executeUpdate();
        }
    }
}

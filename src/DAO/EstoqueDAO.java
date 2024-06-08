package DAO;

import conexao.Conexao;
import entity.Estoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDAO {

    public void cadastrarEstoque(Estoque estoque) throws SQLException {
        String sql = "INSERT INTO ESTOQUE(COD, VALOR, NOME, CATEGORIA, TAMANHO, COR, MARCA, QUANTIDADE, ESTADOPRODUTO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, estoque.getCod());
            ps.setFloat(2, estoque.getValor());
            ps.setString(3, estoque.getNome());
            ps.setString(4, estoque.getCategoria());
            ps.setString(5, estoque.getTamanho());
            ps.setString(6, estoque.getCor());
            ps.setString(7, estoque.getMarca());
            ps.setInt(8, estoque.getQuantidade());
            ps.setBoolean(9, estoque.isEstadoProduto());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

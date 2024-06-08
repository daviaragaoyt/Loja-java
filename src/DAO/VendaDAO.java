package DAO;

import conexao.Conexao;
import entity.Venda;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {

    public void cadastrarVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO VENDA(COD, VALOR, NOME, CATEGORIA, TAMANHO, COR, MARCA, QUANTIDADE, NOTA) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, venda.getCod());
            ps.setFloat(2, venda.getValor());
            ps.setString(3, venda.getNome());
            ps.setString(4, venda.getCategoria());
            ps.setString(5, venda.getTamanho());
            ps.setString(6, venda.getCor());
            ps.setString(7, venda.getMarca());
            ps.setInt(8, venda.getQuantidade());
            ps.setInt(9, venda.getNota());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

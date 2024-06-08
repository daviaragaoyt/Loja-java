package DAO;

import conexao.Conexao;
import entity.Pessoa;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {

    public void cadastrarPessoa(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO PESSOA(NOME, DTNASCIMENTO, NUM_TEL, EMAIL) VALUES(?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getDtNascimento());
            ps.setString(3, pessoa.getNum_tel());
            ps.setString(4, pessoa.getEmail());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

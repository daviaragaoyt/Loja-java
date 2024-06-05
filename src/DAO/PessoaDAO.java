package DAO;

import conexao.Conexao;
import entity.Pessoa;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {

    public void cadastrarPessoa(Pessoa Pessoa) throws SQLException {
        String sql = "INSERT INTO PESSOA( NOME ,DTNASCIMENTO , NUM_TEL , EMAIL) VALUE(? ,? ,? ,? )";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, Pessoa.getNome());
            ps.setInt(2, Pessoa.getId());
            ps.setString(3, Pessoa.getDtNascimento());
            ps.setString(4, Pessoa.getNum_tel());
            ps.setString(5, Pessoa.getEmail());

            ps.execute();
            ps.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}

package DAO;

import conexao.Conexao;
import entity.Pessoa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {

    public void cadastrarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO PESSOA(NOME, DTNASCIMENTO, NUM_TEL, EMAIL) VALUES(?, ?, ?, ?)";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, pessoa.getNome());
            ps.setDate(2, java.sql.Date.valueOf(pessoa.getDtNascimento())); // Correção aqui
            ps.setString(3, pessoa.getNumTel()); // Ajustei de num_tel para numTel para seguir o padrão
            ps.setString(4, pessoa.getEmail());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

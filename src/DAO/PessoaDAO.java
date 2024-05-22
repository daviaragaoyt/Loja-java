package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Pessoa;

public class PessoaDAO {
    
    public void cadastrarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO PESSOA (NOME, NUM_TEL, EMAIL) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getNum_tel());
            ps.setString(3, pessoa.getEmail());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
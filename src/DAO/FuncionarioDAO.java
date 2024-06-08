package DAO;

import conexao.Conexao;
import entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO FUNCIONARIO (NOME, DTNASCIMENTO, NUM_TEL, EMAIL, ID, DTADMISSAO) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getDtNascimento());
            ps.setString(3, funcionario.getNum_tel());
            ps.setString(4, funcionario.getEmail());
            ps.setInt(5, funcionario.getId());
            ps.setString(6, funcionario.getDtAdmissao());
            ps.executeUpdate();
        }
    }

    public void atualizarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE FUNCIONARIO SET NOME = ?, DTNASCIMENTO = ?, NUM_TEL = ?, EMAIL = ?, DTADMISSAO = ? WHERE ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getDtNascimento());
            ps.setString(3, funcionario.getNum_tel());
            ps.setString(4, funcionario.getEmail());
            ps.setString(5, funcionario.getDtAdmissao());
            ps.setInt(6, funcionario.getId());
            ps.executeUpdate();
        }
    }

    public Funcionario buscarFuncionario(int id) throws SQLException {
        String sql = "SELECT * FROM FUNCIONARIO WHERE ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                        rs.getString("NOME"),
                        rs.getString("DTNASCIMENTO"),
                        rs.getString("NUM_TEL"),
                        rs.getString("EMAIL"),
                        rs.getInt("ID"),
                        rs.getString("DTADMISSAO")
                    );
                }
            }
        }
        return null;
    }

    public void apagarFuncionario(int id) throws SQLException {
        String sql = "DELETE FROM FUNCIONARIO WHERE ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM FUNCIONARIO";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                    rs.getString("NOME"),
                    rs.getString("DTNASCIMENTO"),
                    rs.getString("NUM_TEL"),
                    rs.getString("EMAIL"),
                    rs.getInt("ID"),
                    rs.getString("DTADMISSAO")
                );
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
}

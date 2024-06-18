package DAO;

import conexao.Conexao;
import entity.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO FUNCIONARIO (NOME, DTNASCIMENTO, NUM_TEL, EMAIL, ID, DTADMISSAO) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setDate(2, Date.valueOf(funcionario.getDtNascimento()));
            ps.setString(3, funcionario.getNumTel());
            ps.setString(4, funcionario.getEmail());
            ps.setInt(5, funcionario.getId());
            ps.setDate(6, Date.valueOf(funcionario.getDtAdmissao()));
            ps.executeUpdate();
        }
    }

    public void atualizarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE FUNCIONARIO SET NOME = ?, DTNASCIMENTO = ?, NUM_TEL = ?, EMAIL = ?, DTADMISSAO = ? WHERE ID = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setDate(2, Date.valueOf(funcionario.getDtNascimento()));
            ps.setString(3, funcionario.getNumTel());
            ps.setString(4, funcionario.getEmail());
            ps.setDate(5, Date.valueOf(funcionario.getDtAdmissao()));
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
                        rs.getDate("DTNASCIMENTO").toLocalDate(),
                        rs.getString("NUM_TEL"),
                        rs.getString("EMAIL"),
                        rs.getInt("ID"),
                        rs.getDate("DTADMISSAO").toLocalDate()
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
                    rs.getDate("DTNASCIMENTO").toLocalDate(),
                    rs.getString("NUM_TEL"),
                    rs.getString("EMAIL"),
                    rs.getInt("ID"),
                    rs.getDate("DTADMISSAO").toLocalDate()
                );
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
}
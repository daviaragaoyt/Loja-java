package entity;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private LocalDate dtAdmissao;

    public Funcionario(String nome, LocalDate dtNascimento, String numTel, String email, int id, LocalDate dtAdmissao) {
        super(nome, dtNascimento, numTel, email, id);
        this.dtAdmissao = dtAdmissao;
    }

    public LocalDate getDtAdmissao() {
        return dtAdmissao;
    }
}

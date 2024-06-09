package entity;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dtNascimento;
    private String numTel;
    private String email;
    private int id;

    public Pessoa(String nome, LocalDate dtNascimento, String numTel, String email, int id) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.numTel = numTel;
        this.email = email;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}

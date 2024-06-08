package entity;

public class Pessoa {
    
    private String nome;
    private String dtNascimento;
    private String num_tel;
    private String email;
    private int id;
    
    public Pessoa(String nome, String dtNascimento, String num_tel, String email, int id) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.num_tel = num_tel;
        this.email = email;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

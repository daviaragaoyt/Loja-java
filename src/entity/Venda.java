package entity;

public class Venda extends Produto {
    private int nota;
    
    public Venda(int cod, float valor, String nome, String categoria, String tamanho, String cor, String marca, int quantidade, int nota) {
        super(cod, valor, nome, categoria, tamanho, cor, marca, quantidade);
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}

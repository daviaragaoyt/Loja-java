package entity;

public class Estoque {
    private int produtoId;
    private int quantidade;

    public Estoque(int produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

package entity;

public class Estoque extends Produto {
    private boolean estadoProduto;
    
    public Estoque(int cod, float valor, String nome, String categoria, String tamanho, String cor, String marca, int quantidade, boolean estadoProduto) {
        super(cod, valor, nome, categoria, tamanho, cor, marca, quantidade);
        this.estadoProduto = estadoProduto;
    }

    public boolean isEstadoProduto() {
        return estadoProduto;
    }

    public void setEstadoProduto(boolean estadoProduto) {
        this.estadoProduto = estadoProduto;
    }
}

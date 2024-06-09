package entity;

import java.time.LocalDate;

public class Venda {
    private int id;
    private int produtoId;
    private int quantidade;
    private LocalDate dataVenda;

    public Venda(int id, int produtoId, int quantidade, LocalDate dataVenda) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.dataVenda = dataVenda;
    }

    public int getId() {
        return id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }
}

package Pacotao;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Entregas implements Serializable {
    private String produto;
    private float valorProduto;
    private int qtProduto;
    private float valorTotal;
    private String localEntrega;
    private static final long serialVersionUID = 12348L;

    public Entregas(String produto, float valorProduto, int qtProduto, float valorTotal, String localEntrega) {
        this.produto = produto;
        this.valorProduto = valorProduto;
        this.qtProduto = qtProduto;
        this.valorTotal = valorTotal;
        this.localEntrega = localEntrega;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQtProduto() {
        return qtProduto;
    }

    public void setQtProduto(int qtProduto) {
        this.qtProduto = qtProduto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }

    @Override
    public String toString() {
        return "Entregas{" + "produto=" + produto + ", valorProduto=" + valorProduto + ", qtProduto=" + qtProduto + ", valorTotal=" + valorTotal + ", localEntrega=" + localEntrega + '}';
    }
    
}

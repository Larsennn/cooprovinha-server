/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacotao;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Entregas implements Serializable {
    private int produto;
    private float valorProduto;
    private int qtProduto;
    private float valorTotal;
    private String localEntrega;
    private int programa;
    private static final long serialVersionUID = 12348L;

    public Entregas(int produto, float valorProduto, int qtProduto, float valorTotal, String localEntrega, int programa) {
        this.produto = produto;
        this.valorProduto = valorProduto;
        this.qtProduto = qtProduto;
        this.valorTotal = valorTotal;
        this.localEntrega = localEntrega;
        this.programa = programa;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
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

    public int getPrograma() {
        return programa;
    }

    public void setPrograma(int programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Entregas{" + "produto=" + produto + ", valorProduto=" + valorProduto + ", qtProduto=" + qtProduto + ", valorTotal=" + valorTotal + ", localEntrega=" + localEntrega + ", programa=" + programa + '}';
    }

}

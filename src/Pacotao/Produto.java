/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacotao;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Produto implements Serializable  {
    private String nome;
    private String tipo;
    private float preco;
    private static final long serialVersionUID = 1234L;

    public Produto() {
    }

    public Produto(String nome, String tipo, float preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", tipo=" + tipo + ", preco=" + preco + '}';
    } 
}

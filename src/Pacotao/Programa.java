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
public class Programa implements Serializable{
    private int id;
    private String nome;
    private String sigla;
    private String orgao;
    private static final long serialVersionUID = 12349L;

    public Programa(int id, String nome, String sigla, String orgao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.orgao = orgao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    @Override
    public String toString() {
        return "Programa{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", orgao=" + orgao + '}';
    }

}

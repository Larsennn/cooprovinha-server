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
public class Produtor extends Pessoa implements Serializable  {
    private String DAP;
    private int id;
    private static final long serialVersionUID = 12345L;

    public Produtor(int id, String nome, String data_nasc, int telefone, int ddd, String email, String login, String senha, String DAP) {
        super.nome = nome; 
        super.data_nasc = data_nasc; 
        super.telefone = telefone;
        super.ddd = ddd;
        super.email = email;
        super.login = login;
        super.senha = senha;
        this.DAP = DAP;
        this.id = id;
    }

    public String getDAP() {
        return DAP;
    }

    public void setDAP(String DAP) {
        this.DAP = DAP;
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

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Produtor{" + "DAP=" + DAP + ", id=" + id + '}';
    }

    
}
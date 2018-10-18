package Pacotao;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private String nome;
    private String data_nasc;
    private int telefone;
    private int ddd;
    private String email;
    private String login;
    private String senha;

    public Pessoa(String nome, String data_nasc, int telefone, int ddd, String email, String login, String senha) {
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.telefone = telefone;
        this.ddd = ddd;
        this.email = email;
        this.login = login;
        this.senha = senha;
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

   
    
}

    
    

 
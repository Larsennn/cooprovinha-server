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
public class Administrador extends Pessoa implements Serializable {
    private String RG;
    private String CPF;
    private static final long serialVersionUID = 12347L;

    public Administrador(String nome, String data_nasc, int telefone, int ddd, String email, String login, String senha, String RG, String CPF) {
        super(nome, data_nasc, telefone, ddd, email, login, senha);
        this.RG = RG;
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    @Override
    public String toString() {
        return "Administrador{" + "RG=" + RG + ", CPF=" + CPF + '}';
    }
}

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

    public Produtor(String nome, String data_nasc, int telefone, int ddd, String email, String login, String senha, String DAP) {
        super(nome, data_nasc, telefone, ddd, email, login, senha);
        this.DAP = DAP;
    }

    public String getDAP() {
        return DAP;
    }

    public void setDAP(String DAP) {
        this.DAP = DAP;
    }
   
    

    
}

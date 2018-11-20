package servidorcomthread;

import Pacotao.Administrador;
import Pacotao.Entregas;
import Pacotao.Produto;
import Pacotao.Produtor;
import Pacotao.Programa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    String serverName = "localhost"; //endereço do banco, ip da máquina
    String mydatabase = "cooprovinha";   // nome do banco
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // string para chamar/conectar o banco
    //quando usar xamp, será "root" e senha vazia//
    String userName = "root"; // usuario do banco de dados
    String password = ""; //ifsul2016
    Connection conexao;

    Conexao() throws SQLException {
        conexao = DriverManager.getConnection(url, userName, password);
    }

    void InsereAdministrador(Administrador A) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("INSERT INTO administrador (adm_CPF,adm_RG, adm_Nome,adm_Data_Nasc, adm_Email, adm_telefone, adm_ddd, adm_login, adm_senha) VALUES ('" + A.getCPF() + "','" + A.getRG() + "','" + A.getNome() + "','" + A.getData_nasc() + "','" + A.getEmail() + "', " + A.getTelefone() + ", " + A.getDdd() + ",'" + A.getSenha() + "','" + A.getLogin() + "' ) ");
        } catch (Exception e) {
            System.out.println("Deu erro na inserção!" + e);
        }
    }

    void InsereProduto(Produto P) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("INSERT INTO produtos (pro_Nome, pro_Tipo, pro_Preco) VALUES ('" + P.getNome() + "','" + P.getTipo() + "'," + P.getPreco() + " ) ");
        } catch (Exception e) {
            System.out.println("Deu erro na inserção!" + e);
        }
    }

    void InsereProdutor(Produtor Pr) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("INSERT INTO produtores (pes_DAP, pes_Nome, pes_Data_Nasc, pes_Email,pes_telefone, pes_ddd, pes_login, pes_senha) VALUES ('" + Pr.getDAP() + "','" + Pr.getNome() + "','" + Pr.getData_nasc() + "','" + Pr.getEmail() + "'," + Pr.getTelefone() + "," + Pr.getDdd() + ",'" + Pr.getLogin() + "','" + Pr.getSenha() + "') ");
        } catch (Exception e) {
            System.out.println("Deu erro na inserção!" + e);
        }
    }

    void InserePrograma(Programa Prog) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("INSERT INTO programa (pro_Nome, pro_Sigla, pro_Orgao) VALUES ('" + Prog.getNome() + "','" + Prog.getSigla() + "','" + Prog.getOrgao() + "') ");
        } catch (Exception e) {
            System.out.println("Deu erro na inserção!" + e);
        }
    }

    void InsereEntregas(Entregas Ent) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("INSERT INTO entregas (ent_locais, ent_ValorProduto, ent_ValorTotal, ent_QtProduto, Produtos_pro_Id, Programa_pro_Id) VALUES ('" + Ent.getLocalEntrega() + "'," + Ent.getValorProduto() + "," + Ent.getValorTotal() + ", " + Ent.getQtProduto() + ", " + Ent.getProduto() + ", " + Ent.getPrograma() + ") ");
        } catch (Exception e) {
            System.out.println("Deu erro na inserção!" + e);
        }
    }

    void EditaAdmin(Administrador A) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("UPDATE administrador SET adm_CPF = '" + A.getCPF() + "',adm_RG = '" + A.getRG() + "', adm_Nome = '" + A.getNome() + "',adm_Data_Nasc = '" + A.getData_nasc() + "', adm_Email = '" + A.getEmail() + "', adm_telefone = " + A.getTelefone() + ", adm_ddd = " + A.getDdd() + " where adm_id = " + A.getId());
        } catch (Exception e) {
            System.out.println("Deu erro na Update!" + e);
        }
    }

    void EditaProdutor(Produtor Pr) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("UPDATE produtores SET pes_DAP = '" + Pr.getDAP() + "', pes_Nome = '" + Pr.getNome() + "',pes_Data_Nasc = '" + Pr.getData_nasc() + "', pes_Email = '" + Pr.getEmail() + "', pes_telefone = " + Pr.getTelefone() + ", pes_ddd= " + Pr.getDdd() + " where pes_id = " + Pr.getId());
        } catch (Exception e) { 
            System.out.println("Deu erro no Update!" + e);
        }
    }

    void EditaProdutos(Produto P) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("UPDATE produtos SET pro_Nome = '" + P.getNome() + "', pro_Tipo = '" + P.getTipo() + "', pro_Preco = " + P.getPreco() + " where pro_Id = " + P.getId());
        } catch (Exception e) {
            System.out.println("Deu erro no Update!" + e);
        }
    }
    void EditaPrograma(Programa Prog) {
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeUpdate("UPDATE programa SET pro_Nome = '" + Prog.getNome() + "', pro_Sigla = '" + Prog.getSigla() + "', pro_Orgao = '" + Prog.getOrgao() + "' where pro_Id = " + Prog.getId());
        } catch (Exception e) {
            System.out.println("Deu erro no Update!" + e);
        }
    }

    LinkedList<Administrador> ConsultaAdministrador2(String consulta) {
        LinkedList<Administrador> ListaAdmin = new LinkedList();
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeQuery(consulta);
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                int id = rs.getInt ("adm_id");
                String nome = rs.getString("adm_Nome");
                String CPF = rs.getString("adm_CPF");
                String RG = rs.getString("adm_RG");
                String data_nasc = rs.getString("adm_Data_Nasc");
                String email = rs.getString("adm_Email");
                int telefone = rs.getInt("adm_telefone");
                int ddd = rs.getInt("adm_ddd");
                String login = rs.getString("adm_login");
                String senha = rs.getString("adm_senha");
                Administrador meuAdministrador = new Administrador(id, nome, data_nasc, telefone, ddd, email, login, senha, RG, CPF);
                ListaAdmin.add(meuAdministrador);
            }
            System.out.println("Tamano da lista" + ListaAdmin.size());

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return ListaAdmin;
    }

    LinkedList<Produtor> ConsultaProdutor(String consulta) {
        LinkedList<Produtor> ListaProdutor = new LinkedList();
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeQuery(consulta);
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("pes_id");
                System.out.println("Id produtor: " + id);
                String nome = rs.getString("pes_Nome");
                String data_nasc = rs.getString("pes_Data_Nasc");
                int telefone = rs.getInt("pes_telefone");
                int ddd = rs.getInt("pes_ddd");
                String email = rs.getString("pes_Email");
                String login = rs.getString("pes_login");
                String senha = rs.getString("pes_senha");
                String DAP = rs.getString("pes_DAP");
                Produtor meuProdutor = new Produtor(id, nome, data_nasc, telefone, ddd, email, login, senha, DAP);
                ListaProdutor.add(meuProdutor);
            }
            System.out.println("Tamano da lista" + ListaProdutor.size());

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return ListaProdutor;
    }

    LinkedList<Produto> ConsultaProduto(String consulta) {
        LinkedList<Produto> ListaProdutos = new LinkedList();
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeQuery(consulta);
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("pro_Id");
                String nome = rs.getString("pro_Nome");
                String tipo = rs.getString("pro_Tipo");
                float preco = rs.getFloat("pro_Preco");
                Produto meuProduto = new Produto(id, nome, tipo, preco);
                ListaProdutos.add(meuProduto);
            }
            System.out.println("Tamano da lista" + ListaProdutos.size());

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return ListaProdutos;
    }

    LinkedList<Programa> ConsultaPrograma(String consulta) {
        LinkedList<Programa> ListaPrograma = new LinkedList();
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeQuery(consulta);
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("pro_Id");
                String nome = rs.getString("pro_Nome");
                String sigla = rs.getString("pro_Sigla");
                String orgao = rs.getString("pro_Orgao");
                Programa meuPrograma = new Programa(id, nome, sigla, orgao);
                ListaPrograma.add(meuPrograma);
            }
            System.out.println("Tamano da lista" + ListaPrograma.size());

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return ListaPrograma;
    }

    LinkedList<Entregas> ConsultaEntregas(String consulta) {
        LinkedList<Entregas> ListaEntregas = new LinkedList();
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();

            st.executeQuery(consulta);
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                int produto = rs.getInt("Produtos_pro_Id");
                float valorProduto = rs.getFloat("ent_ValorProduto");
                int qtProduto = rs.getInt("ent_QtProduto");
                float valorTotal = rs.getFloat("ent_ValorTotal");
                String localEntrega = rs.getString("ent_Locais");
                int programa = rs.getInt("Programa_pro_Id");
                Entregas minhaEntrega = new Entregas (produto, valorProduto, qtProduto, valorTotal, localEntrega, programa);
                ListaEntregas.add(minhaEntrega);
            }
            System.out.println("Tamano da lista" + ListaEntregas.size());

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return ListaEntregas;
    }
    int login(String login, String senha){
        String CPF=""; 
        int x = 0;
        try {
            Conexao con = new Conexao();
            Statement st = conexao.createStatement();
            st.executeQuery("SELECT adm_CPF from administrador where adm_login = '"+login+"' and adm_senha = '"+senha+"';");
            ResultSet rs = st.getResultSet();
            
            while (rs.next()){
                CPF=rs.getString("adm_CPF"); 
                x = 1;
            }
            if (x==0){
            st.executeQuery("SELECT pes_DAP from produtores where pes_login = '"+login+"' and pes_senha = '"+senha+"';");
            rs = st.getResultSet();
            while (rs.next()){
                String DAP = null;
                DAP=rs.getString("pes_DAP");
                x = 2;
            }
            }
        } catch (Exception e) {
            System.out.println("Deu erro no login!" + e);
        }
        return x;
        }
}

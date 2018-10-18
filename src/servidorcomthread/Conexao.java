package servidorcomthread;

import Pacotao.Administrador;
import Pacotao.Produto;
import Pacotao.Produtor;
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



                
        void InsereAdministrador (Administrador A) {
        try{
        Conexao con = new Conexao();
        Statement st = conexao.createStatement();
        
        st.executeUpdate("INSERT INTO administrador (adm_CPF,adm_RG, adm_Nome,adm_Data_Nasc, adm_Email, adm_telefone, adm_ddd, adm_login, adm_senha) VALUES ('"+A.getCPF()+"','"+A.getRG()+"','"+A.getNome()+"','"+A.getData_nasc()+"','"+A.getEmail()+"', "+A.getTelefone()+", "+A.getDdd()+",'"+A.getSenha()+"','"+A.getLogin()+"' ) ");
        } 
        catch(Exception e)
        {
            System.out.println("Deu erro na inserção!"+e);
        }
    }
        void InsereProduto (Produto P) {
        try{
        Conexao con = new Conexao();
        Statement st = conexao.createStatement();
        
        st.executeUpdate("INSERT INTO produtos (pro_Nome, pro_Tipo, pro_Preco) VALUES ('"+P.getNome()+"','"+P.getTipo()+"',"+P.getPreco()+" ) ");
        } 
        catch(Exception e)
        {
            System.out.println("Deu erro na inserção!"+e);
        }
    }
        void InsereProdutor (Produtor Pr) {
        try{
        Conexao con = new Conexao();
        Statement st = conexao.createStatement();
        
        st.executeUpdate("INSERT INTO produtores (pes_DAP, pes_Nome, pes_Data_Nasc, pes_Email,pes_telefone, pes_ddd, pes_login, pes_senha) VALUES ('"+Pr.getDAP()+"','"+Pr.getNome()+"','"+Pr.getData_nasc()+"','"+Pr.getEmail()+"',"+Pr.getTelefone()+","+Pr.getDdd()+",'"+Pr.getLogin()+"','"+Pr.getSenha()+"') ");
        } 
        catch(Exception e)
        {
            System.out.println("Deu erro na inserção!"+e);
        }
    }
         void EditaAdmin (Administrador A) {
         try{
        Conexao con = new Conexao();
        Statement st = conexao.createStatement();
        
        st.executeUpdate("UPDATE administrador SET (adm_CPF,adm_RG, adm_Nome,adm_Data_Nasc, adm_Email, adm_telefone, adm_ddd) VALUES ('"+A.getCPF()+"','"+A.getRG()+"','"+A.getNome()+"','"+A.getData_nasc()+"','"+A.getEmail()+"', "+A.getTelefone()+", "+A.getDdd()+" ) ");
        } 
        catch(Exception e)
        {
            System.out.println("Deu erro na Update!"+e);
        }
}
         void EditaProdutor (Produtor Pr) {
         try{
        Conexao con = new Conexao();
        Statement st = conexao.createStatement();
        
        st.executeUpdate("UPDATE produtores SET (pes_DAP, pes_Nome, pes_Data_Nasc, pes_Email, pes_telefone, pes_ddd) VALUES ('"+Pr.getDAP()+"','"+Pr.getNome()+"','"+Pr.getData_nasc()+"','"+Pr.getEmail()+"',"+Pr.getTelefone()+", "+Pr.getDdd()+" ) ");
        } 
        catch(Exception e)
        {
            System.out.println("Deu erro no Update!"+e);
        }
}
        void EditaProdutos (Produto P) {
         try{
        Conexao con = new Conexao();
        Statement st = conexao.createStatement();
        
        st.executeUpdate("UPDATE produtos SET pro_Nome = '"+P.getNome()+"', pro_Tipo = '"+P.getTipo()+"', pro_Preco = "+P.getPreco()+") ");
        } 
        catch(Exception e)
        {
            System.out.println("Deu erro no Update!"+e);
        }
}
  
        
          LinkedList <Administrador> ConsultaAdministrador2 (String consulta) {
              LinkedList <Administrador> ListaAdmin = new LinkedList();
            try{
                Conexao con = new Conexao();
                Statement st = conexao.createStatement();
                
                st.executeQuery(consulta);
                ResultSet rs = st.getResultSet();
                        
            while (rs.next()) {
            String nome = rs.getString("adm_Nome");
            String CPF = rs.getString("adm_CPF");
            String RG = rs.getString("adm_RG");
            String data_nasc = rs.getString("adm_Data_Nasc");
            String email = rs.getString("adm_Email");
            int telefone = rs.getInt("adm_telefone");
            int ddd = rs.getInt("adm_ddd");
            String login = rs.getString("adm_login");
            String senha = rs.getString("adm_senha");
            Administrador meuAdministrador = new Administrador (nome,  data_nasc,  telefone,  ddd,  email,  login,  senha,  RG,  CPF);
            ListaAdmin.add(meuAdministrador);  
            }
              System.out.println("Tamano da lista" + ListaAdmin.size());
                
            } catch (Exception e) {
               System.out.println(""+e); 
        }
        return ListaAdmin;
    }
           LinkedList <Produtor> ConsultaProdutor (String consulta) {
              LinkedList <Produtor> ListaProdutor = new LinkedList();
            try{
                Conexao con = new Conexao();
                Statement st = conexao.createStatement();
                
                st.executeQuery(consulta);
                ResultSet rs = st.getResultSet();
                        
            while (rs.next()) {
            String nome = rs.getString("pes_Nome");
            String data_nasc = rs.getString("pes_Data_Nasc");
            int telefone = rs.getInt("pes_telefone");
            int ddd = rs.getInt("pes_ddd");
            String email = rs.getString("pes_Email");
            String login = rs.getString("pes_login");
            String senha = rs.getString("pes_senha");
            String DAP = rs.getString("pes_DAP");
            Produtor meuProdutor = new Produtor ( nome,  data_nasc,  telefone,  ddd,  email,  login,  senha,  DAP);
            ListaProdutor.add(meuProdutor);  
            }
              System.out.println("Tamano da lista" + ListaProdutor.size());
                
            } catch (Exception e) {
               System.out.println(""+e); 
        }
        return ListaProdutor;
    }
            LinkedList <Produto> ConsultaProduto (String consulta) {
            LinkedList <Produto> ListaProdutos = new LinkedList();
            try{
                Conexao con = new Conexao();
                Statement st = conexao.createStatement();
                
                st.executeQuery(consulta);
                ResultSet rs = st.getResultSet();
                        
            while (rs.next()) {
            String nome = rs.getString("pro_Nome");
            String tipo = rs.getString("pro_Tipo");
            float preco = rs.getFloat("pro_Preco");
            Produto meuProduto = new Produto ( nome,  tipo,  preco);
            ListaProdutos.add(meuProduto);  
            }
              System.out.println("Tamano da lista" + ListaProdutos.size());
                
            } catch (Exception e) {
               System.out.println(""+e); 
        }
        return ListaProdutos;
    }
  
}

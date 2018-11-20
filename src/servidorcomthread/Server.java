package servidorcomthread;

import Pacotao.Administrador;
import Pacotao.Entregas;

import Pacotao.Produto;
import Pacotao.Produtor;
import Pacotao.Programa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Server implements Runnable {

    public Socket cliente;
    Statement st;
    LinkedList<Administrador> ListaAdmin;
    LinkedList<Produtor> ListaProdutor;
    LinkedList<Produto> ListaProdutos;
    LinkedList<Programa> ListaPrograma;
    LinkedList<Entregas> ListaEntregas;

    public Server(Socket cliente) {
        this.cliente = cliente;
    }
    static Conexao con;

    public static void main(String[] args) throws IOException, SQLException {
        con = new Conexao();
        //Cria um socket na porta 12345
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");
        // Aguarda alguém se conectar. A execução do servidor
        // fica bloqueada na chamada do método accept da classe
        // ServerSocket. Quando alguém se conectar ao servidor, o
        // método desbloqueia e retorna com um objeto da classe
        // Socket, que é uma porta da comunicação.
        System.out.println("Aguardando conexão do cliente...");

        while (true) {
            Socket cliente = servidor.accept();
            // Cria uma thread do servidor para tratar a conexão
            Server tratamento = new Server(cliente);
            Thread t = new Thread(tratamento);
            // Inicia a thread para o cliente conectado
            t.start();
        }
    }

    /* A classe Thread, que foi instancia no servidor, implementa Runnable.
       Então você terá que implementar sua lógica de troca de mensagens dentro deste método 'run'.
     */
    @Override
    public void run() {
        try {

            System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());

            ObjectInputStream Entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream Saida = new ObjectOutputStream(cliente.getOutputStream());
            Produto P;
            Administrador A;
            Produtor Pr;
            Programa Prog;
            Entregas Ent;
            Integer valor = 12;
            while (valor != 99) {

                ///recebendo um inteiro
                System.out.println("Esperando mensagem");

                valor = (Integer) Entrada.readObject();
                System.out.println("Recebido " + valor);
                if (valor == 12) {
                    System.out.println("Esperando o produto");
                    P = (Produto) Entrada.readObject();
                    System.out.println("O Nome informado foi:" + P.getNome());
                    System.out.println("O tipo informado foi:" + P.getTipo());
                    System.out.println("O preço informado foi:" + P.getPreco());
                    con.InsereProduto(P);

                } else if (valor == 14) {
                    A = (Administrador) Entrada.readObject();
                    System.out.println("O nome informado foi: " + A.getNome());
                    System.out.println("A data de nascimento informada foi: " + A.getData_nasc());
                    System.out.println("O telefone informado foi: " + A.getTelefone());
                    System.out.println("O ddd informado foi: " + A.getDdd());
                    System.out.println("O email informado foi: " + A.getEmail());
                    System.out.println("O login informado foi: " + A.getLogin());
                    System.out.println("A senha informada foi: " + A.getSenha());
                    System.out.println("O RG informado foi: " + A.getRG());
                    System.out.println("O CPF informado foi: " + A.getCPF());
                    con.InsereAdministrador(A);
                } else if (valor == 15) {
                    Pr = (Produtor) Entrada.readObject();
                    System.out.println("O nome informado foi: " + Pr.getNome());
                    System.out.println("A data de nascimento informada foi: " + Pr.getData_nasc());
                    System.out.println("O telefone informado foi: " + Pr.getTelefone());
                    System.out.println("O ddd informado foi: " + Pr.getDdd());
                    System.out.println("O email informado foi: " + Pr.getEmail());
                    System.out.println("O login informado foi: " + Pr.getLogin());
                    System.out.println("A senha informada foi: " + Pr.getSenha());
                    System.out.println("A DAP informada foi: " + Pr.getDAP());
                    con.InsereProdutor(Pr);
                } else if (valor == 16) {
                    A = (Administrador) Entrada.readObject();
                    System.out.println("O nome informado foi: " + A.getNome());
                    System.out.println("A data de nascimento informada foi: " + A.getData_nasc());
                    System.out.println("O telefone informado foi: " + A.getTelefone());
                    System.out.println("O ddd informado foi: " + A.getDdd());
                    System.out.println("O email informado foi: " + A.getEmail());
                    System.out.println("O RG informado foi: " + A.getRG());
                    System.out.println("O CPF informado foi: " + A.getCPF());
                    con.EditaAdmin(A);
                } else if (valor == 17) {
                    System.out.println("Chegou até aqui");
                    ConsultaAdministrador();
                    Saida.writeObject(ListaAdmin);
                } else if (valor == 18) {
                    Pr = (Produtor) Entrada.readObject();
                    System.out.println("O nome informado foi: " + Pr.getNome());
                    System.out.println("A data de nascimento informada foi: " + Pr.getData_nasc());
                    System.out.println("O telefone informado foi: " + Pr.getTelefone());
                    System.out.println("O ddd informado foi: " + Pr.getDdd());
                    System.out.println("O email informado foi: " + Pr.getEmail());
                    System.out.println("A DAP informada foi: " + Pr.getDAP());
                    con.EditaProdutor(Pr);
                } else if (valor == 19) {
                    ConsultaProdutor();
                    Saida.writeObject(ListaProdutor);
                } else if (valor == 20) {
                    P = (Produto) Entrada.readObject();
                    System.out.println("Recebi o produto!");
                    System.out.println("O Nome informado foi:" + P.getNome());
                    System.out.println("O tipo informado foi:" + P.getTipo());
                    System.out.println("O preço informado foi:" + P.getPreco());
                    con.EditaProdutos(P);
                } else if (valor == 21) {
                    ConsultaProduto();
                    Saida.writeObject(ListaProdutos);
                } else if (valor == 22) {
                    Ent = (Entregas) Entrada.readObject();
                    System.out.println("O produto informado foi: " + Ent.getProduto());
                    System.out.println("O valor do produto informado foi: " + Ent.getValorProduto());
                    System.out.println("A quantidade de produto informado foi: " + Ent.getQtProduto());
                    System.out.println("O valor total produto informado foi: " + Ent.getValorTotal());
                    System.out.println("O local de entrega informado foi: " + Ent.getLocalEntrega());
                    System.out.println("O programa informado foi: " + Ent.getPrograma());
                    con.InsereEntregas(Ent);
                } else if (valor == 23) {
                    ConsultaProduto();
                    Saida.writeObject(ListaProdutos);
                } else if (valor == 24) {
                    ConsultaPrograma();
                    Saida.writeObject(ListaPrograma);
                } else if (valor == 25) {
                    Prog = (Programa) Entrada.readObject();
                    System.out.println("O Nome informado foi:" + Prog.getNome());
                    System.out.println("O orgão informado foi:" + Prog.getOrgao());
                    System.out.println("A sigla informado foi:" + Prog.getSigla());
                    con.InserePrograma(Prog);
                } else if (valor == 26) {
                    ConsultaEntregas();
                    Saida.writeObject(ListaEntregas);
                } else if (valor == 13) {
                    Saida.writeObject("Login");
                    String login = (String) Entrada.readObject();
                    Saida.writeObject("Senha");
                    String senha = (String) Entrada.readObject();
                    int x = con.login(login, senha);
                    Saida.writeObject(x);
                } else if (valor == 27) {
                    Prog = (Programa) Entrada.readObject();
                    System.out.println("Recebi o produto!");
                    System.out.println("O Nome informado foi:" + Prog.getNome());
                    System.out.println("O tipo informado foi:" + Prog.getSigla());
                    System.out.println("O preço informado foi:" + Prog.getOrgao());
                    con.EditaPrograma(Prog);
                } else if (valor == 28) {
                    ConsultaPrograma();
                    Saida.writeObject(ListaPrograma);
                }
            }
            Entrada.close();    
        } catch (IOException ex) {
            System.out.println("Deu erro: " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Nao achou a classe pessoa: " + ex);
        }
    }

    public void ConsultaAdministrador() {
        String nome = null;
        String CPF = null;
        String RG = null;
        String data_nasc = null;
        String email = null;
        int telefone = 0;
        int ddd = 0;
        String login = null;
        String senha = null;

        String pesquisa = "SELECT * FROM administrador";
        int v1 = 0, v2 = 0, v3 = 0, v4 = 0, v5 = 0, v6 = 0, v7 = 0, v8 = 0, v9 = 0;

        if (v1 == 1 || v2 == 1 || v3 == 1 || v4 == 1 || v5 == 1 || v6 == 1 || v7 == 1 || v8 == 1 || v9 == 1) {
            pesquisa = pesquisa + " WHERE ";
        }
        // alterar pesquisa
        String y = "";
        if (v1 == 1) {
            pesquisa = pesquisa + " adm_nome like '%" + nome + "%'";
            y = " and ";
        }
        if (v2 == 1) {
            pesquisa = pesquisa + "" + y + " adm_Data_Nasc like '%" + data_nasc + "%'";
            y = " and ";
        }
        if (v3 == 1) {
            pesquisa = pesquisa + "" + y + " adm_CPF like '%" + CPF + "%'";
            y = " and ";
        }
        if (v4 == 1) {
            pesquisa = pesquisa + "" + y + " adm_RG like '%" + RG + "%'";
        }
        if (v5 == 1) {
            pesquisa = pesquisa + "" + y + " adm_telefone like '%" + telefone + "%'";
        }
        if (v6 == 1) {
            pesquisa = pesquisa + "" + y + " adm_ddd like '%" + ddd + "%'";
        }
        if (v7 == 1) {
            pesquisa = pesquisa + "" + y + " adm_Email like '%" + email + "%'";
        }
        if (v8 == 1) {
            pesquisa = pesquisa + "" + y + " adm_login like '%" + login + "%'";
        }
        if (v9 == 1) {
            pesquisa = pesquisa + "" + y + "adm_senha like '%" + senha + "%'";
        }
        pesquisa = pesquisa + ";";
        System.out.println("Mandei essa consulta" + pesquisa);
        ListaAdmin = con.ConsultaAdministrador2(pesquisa);
        System.out.println(ListaAdmin.size());
    }

    public void ConsultaProdutor() {
        String nome = null;
        String data_nasc = null;
        int telefone = 0;
        int ddd = 0;
        String email = null;
        String login = null;
        String senha = null;
        String DAP = null;

        String pesquisa = "SELECT * FROM produtores";
        int v1 = 0, v2 = 0, v3 = 0, v4 = 0, v5 = 0, v6 = 0, v7 = 0, v8 = 0;

        if (v1 == 1 || v2 == 1 || v3 == 1 || v4 == 1 || v5 == 1 || v6 == 1 || v7 == 1 || v8 == 1) {
            pesquisa = pesquisa + " WHERE ";
        }
        // alterar pesquisa
        String y = "";
        if (v1 == 1) {
            pesquisa = pesquisa + " pes_DAP like '%" + DAP + "%'";
            y = " and ";
        }
        if (v2 == 1) {
            pesquisa = pesquisa + "" + y + " pes_Nome like '%" + nome + "%'";
            y = " and ";
        }
        if (v3 == 1) {
            pesquisa = pesquisa + "" + y + " pes_Data_Nasc like '%" + data_nasc + "%'";
            y = " and ";
        }
        if (v4 == 1) {
            pesquisa = pesquisa + "" + y + " pes_Email like '%" + email + "%'";
        }
        if (v5 == 1) {
            pesquisa = pesquisa + "" + y + " pes_telefone like '%" + telefone + "%'";
        }
        if (v6 == 1) {
            pesquisa = pesquisa + "" + y + " pes_ddd like '%" + ddd + "%'";
        }
        if (v7 == 1) {
            pesquisa = pesquisa + "" + y + " pes_login like '%" + login + "%'";
        }
        if (v8 == 1) {
            pesquisa = pesquisa + "" + y + "pes_senha like '%" + senha + "%'";
        }
        pesquisa = pesquisa + ";";
        System.out.println("Mandei essa consulta" + pesquisa);
        ListaProdutor = con.ConsultaProdutor(pesquisa);
        System.out.println(ListaProdutor.size());
    }

    public void ConsultaProduto() {
        String nome = null;
        String tipo = null;
        float preco = 0;
        int id = 0;

        String pesquisa = "SELECT * FROM produtos";
        int v1 = 0, v2 = 0, v3 = 0, v4 = 0;

        if (v1 == 1 || v2 == 1 || v3 == 1) {
            pesquisa = pesquisa + " WHERE ";
        }
        // alterar pesquisa
        String y = "";
        if (v1 == 1) {
            pesquisa = pesquisa + " pro_Nome like '%" + nome + "%'";
            y = " and ";
        }
        if (v2 == 1) {
            pesquisa = pesquisa + "" + y + " pro_Tipo like '%" + tipo + "%'";
            y = " and ";
        }
        if (v3 == 1) {
            pesquisa = pesquisa + "" + y + " pro_Preco like '%" + preco + "%'";
        }
        if (v4 == 1) {
            pesquisa = pesquisa + "" + y + " pro_Id like '%" + id + "%'";
        }

        pesquisa = pesquisa + ";";
        System.out.println("Mandei essa consulta" + pesquisa);
        ListaProdutos = con.ConsultaProduto(pesquisa);
        System.out.println(ListaProdutos.size());

    }

    public void ConsultaPrograma() {
        String nome = null;
        String sigla = null;
        String orgao = null;
        int id = 0;

        String pesquisa = "SELECT * FROM programa";
        int v1 = 0, v2 = 0, v3 = 0, v4 = 0;

        if (v1 == 1 || v2 == 1 || v3 == 1 || v4 == 1) {
            pesquisa = pesquisa + " WHERE ";
        }
        // alterar pesquisa
        String y = "";
        if (v1 == 1) {
            pesquisa = pesquisa + " pro_Nome like '%" + nome + "%'";
            y = " and ";
        }
        if (v2 == 1) {
            pesquisa = pesquisa + "" + y + " pro_Sigla like '%" + sigla + "%'";
            y = " and ";
        }
        if (v3 == 1) {
            pesquisa = pesquisa + "" + y + " pro_Orgao like '%" + orgao + "%'";
        }
        if (v4 == 1) {
            pesquisa = pesquisa + "" + y + " pro_Id like '%" + id + "%'";
        }

        pesquisa = pesquisa + ";";
        System.out.println("Mandei essa consulta" + pesquisa);
        ListaPrograma = con.ConsultaPrograma(pesquisa);
        System.out.println(ListaPrograma.size());

    }

    public void ConsultaEntregas() {
        int produto = 0;
        float valorProduto = 0;
        int qtProduto = 0;
        float valorTotal = 0;
        String localEntrega = null;
        int programa = 0;

        String pesquisa = "SELECT * FROM entregas";
        int v1 = 0, v2 = 0, v3 = 0, v4 = 0, v5 = 0, v6 = 0;

        if (v1 == 1 || v2 == 1 || v3 == 1 || v4 == 1 || v5 == 1 || v6 == 1) {
            pesquisa = pesquisa + " WHERE ";
        }
        // alterar pesquisa
        String y = "";
        if (v1 == 1) {
            pesquisa = pesquisa + " Produtos_pro_Id = " + produto;
            y = " and ";
        }
        if (v2 == 1) {
            pesquisa = pesquisa + "" + y + " ent_ValorProduto like '%" + valorProduto + "%'";
            y = " and ";
        }
        if (v3 == 1) {
            pesquisa = pesquisa + "" + y + " ent_QtProduto like '%" + qtProduto + "%'";
        }
        if (v4 == 1) {
            pesquisa = pesquisa + "" + y + " ent_ValorTotal like '%" + valorTotal + "%'";
        }
        if (v5 == 1) {
            pesquisa = pesquisa + "" + y + " ent_Locais like '%" + localEntrega + "%'";
        }
        if (v6 == 1) {
            pesquisa = pesquisa + "" + y + " Programa_pro_Id like '%" + programa + "%'";
        }

        pesquisa = pesquisa + ";";
        System.out.println("Mandei essa consulta: " + pesquisa);
        ListaEntregas = con.ConsultaEntregas(pesquisa);
        System.out.println(ListaEntregas.size());

    }
}

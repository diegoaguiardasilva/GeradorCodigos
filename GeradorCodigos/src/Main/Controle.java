package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controle {

    //Funções do CRUD + Listar
    public void create(Dados nov) {

        String cmd_dados = "INSERT INTO dados (nome) VALUES ('" + nov.getNome() + "');";
        enviar(cmd_dados);

        int id = retorno_id("SELECT max(id) FROM dados;");

        for (int i = 0; i < nov.getCampos().size(); i++) {

            String cmd_campos = "INSERT INTO campos (id_dados, nome, tipo, a, b) VALUES (" + id + ", '" + nov.getCampos().get(i).getNome() + "', '" + nov.getCampos().get(i).getTipo() + "', '" + nov.getCampos().get(i).getA() + "', '" + nov.getCampos().get(i).getB() + "');";

            enviar(cmd_campos);
        }

    }

    public Dados read(Dados d) {
        int i = 1;
        String comando = "SELECT d.id, d.nome as 'dados', c.id as 'id_campo', c.nome, c.tipo, c.a, c.b FROM dados d INNER JOIN campos c ON d.id = id_dados WHERE d.id=" + d.getId() + " ORDER BY d.id;";
        Dados a = retorno(comando);
        if (a.getId() == d.getId()) {
            return a;

        } else {
            return new Dados();
        }

    }

    //arrumar este update
    public void update(Dados vel, Dados nov) {

        String cmd_d = "UPDATE dados SET nome = '" + nov.getNome() + "' WHERE id = " + vel.getId() + ";";
        System.out.println(cmd_d);
        enviar(cmd_d);

        String cmd_a = "DELETE FROM campos WHERE id_dados = " + vel.getId() + ";"; //exclui todos os campos dos dados
        enviar(cmd_a);
        System.out.println(cmd_a);

        for (int i = 0; i < nov.getCampos().size(); i++) {
            String cmd_c = "INSERT INTO campos (id_dados, nome, tipo, a, b) VALUES (" + vel.getId() + ", '" + nov.getCampos().get(i).getNome() + "', '" + nov.getCampos().get(i).getTipo() + "', '" + nov.getCampos().get(i).getA() + "', '" + nov.getCampos().get(i).getB() + "');";
            enviar(cmd_c);
            System.out.println(cmd_c);

        }
    }
    
    public String listar_tabelas(){
        String st = "";
        
        return st;
    }

    
    public void delete(Dados ent) {

        String comando = "DELETE FROM dados WHERE id = " + ent.getId() + ";";
        enviar(comando);

    }

    public ArrayList<Dados> listar() throws SQLException {

        try {

            String cmd1 = "SELECT id FROM dados ORDER BY id;";
            String cmd2 = "SELECT d.id, d.nome as 'dados', c.id as 'id_campo', c.nome, c.tipo, c.a, c.b FROM dados d INNER JOIN campos c ON d.id = id_dados ORDER BY d.id;";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
            

            java.sql.Statement stm1 = con.createStatement();
            java.sql.Statement stm2 = con.createStatement();

            ResultSet rs1 = stm1.executeQuery(cmd1);
            ResultSet rs2 = stm2.executeQuery(cmd2);

            System.out.println(cmd1);
            System.out.println(cmd2);
            
            Dados dados = new Dados();

            ArrayList<Dados> todos = new ArrayList<Dados>();

            ArrayList<Campo> campos = new ArrayList<Campo>();

            rs1.next();
            while (rs2.next()) {

                if (rs1.getInt("id") == rs2.getInt("id")) { //enquanto o id for o mesmo

                    dados.setId(rs2.getInt("id"));
                    dados.setNome(rs2.getString("dados"));

                    Campo c = new Campo();

                    c.setId(rs2.getInt("id_campo"));
                    c.setId_dados(rs1.getInt("id"));
                    c.setNome(rs2.getString("nome"));
                    c.setTipo(rs2.getString("tipo"));
                    c.setA(rs2.getString("a"));
                    c.setB(rs2.getString("b"));

                    campos.add(c);

                } else {
                    rs1.next();
                    dados.setCampos(campos);
                    todos.add(dados);
                    dados = new Dados();
                }
            }

            todos.add(dados);
            stm1.close();
            stm2.close();
            con.close();
            return todos;

        } catch (Exception e) {
            return null;
        }
    }

// Acesso ao Banco de Dados 
    public boolean enviar(String comando) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
            java.sql.Statement stm = con.createStatement();
            
            System.out.println(comando);

            stm.execute(comando);

            stm.close();
            con.close();

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public int retorno_id(String comando) {
        try {
            int id = 0;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(comando);
            while (rs.next()) {
                id = rs.getInt("max(id)");
            }
            stm.close();
            con.close();
            return id;

        } catch (Exception e) {
            return 0;
        }
    }

    public Dados retorno(String comando) {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");

            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(comando);

            Dados dados = new Dados();

            ArrayList<Campo> campos = new ArrayList<>();

            while (rs.next()) {

                dados.setId(rs.getInt("id"));
                dados.setNome(rs.getString("dados"));

                Campo c = new Campo();
                c.setId(rs.getInt("id_campo"));
                c.setId_dados(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTipo(rs.getString("tipo"));
                c.setA(rs.getString("a"));
                c.setB(rs.getString("b"));

                campos.add(c);
            }
            stm.close();
            con.close();

            dados.setCampos(campos);
            return dados;

        } catch (Exception e) {
            return new Dados();
        }
    }

    public String[] retorno_combo() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM dados;");

            String a = esp(42 - "0000".length(), " ") + "0000;";
            while (rs.next()) {
                String id = esp(4 - (rs.getString("id") + "").length(), "0") + rs.getString("id");
                a += (rs.getString("nome") + esp(42 - rs.getString("nome").length() - id.length(), " ") + id + ";");
            }
            stm.close();
            con.close();

            return a.split(";");

        } catch (Exception e) {
            return new String[]{""};
        }
    }
    
    public String[] retorno_combinho() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM dados;");

            String a = "boolean;String;Date;int;long;double;";
            while (rs.next()) {
                a += rs.getString("nome") + rs.getInt("id") + ";";
            }
            stm.close();
            con.close();

            return a.split(";");

        } catch (Exception e) {
            return new String[]{""};
        }
    }

    public ArrayList<Dados> Listar() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM dados ORDER BY id;");

            ArrayList<Dados> dadoss = new ArrayList<>();

            while (rs.next()) {
                Dados dados = new Dados();
                dados.setNome(rs.getString("nome"));
                dados.setId(rs.getInt("id"));
                dados.setCampos(null);
                dadoss.add(dados);
            }
            stm.close();
            con.close();

            return dadoss;

        } catch (Exception e) {
            return new ArrayList<Dados>();
        }
    }

    //Outras Funções de Controle
    public String esp(int n, String l) {
        String t = "";
        for (int i = 0; i < n; i++) {
            t += l;
        }
        return t;
    }
    
    public int retorna_posicao_tipos(String t){
        int i = 0;
        String[] stipos = new String[]{"boolean", "String", "Date", "int", "long", "double"};
        for (int j = 0; j < stipos.length; j++) {
            if (stipos[j].equalsIgnoreCase(t)) {
                return j;
            }
        }
        return i;
    }


}

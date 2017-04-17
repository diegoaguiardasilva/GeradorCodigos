package Main;

import java.io.IOException;
import java.util.ArrayList;

public class GeraEntidade {

    private Dados dados;
    private String caminho;

    public void gerar() throws IOException {

        ManipulaTxt m = new ManipulaTxt();

        String nc = ajeita(dados.getNome()) + "Entidade";

        ArrayList<Campo> campos = dados.getCampos();

        for (int i = 0; i < campos.size(); i++) {
            if ((!campos.get(i).getTipo().equalsIgnoreCase("String") && !campos.get(i).getTipo().equalsIgnoreCase("Double")
                    && !campos.get(i).getTipo().equalsIgnoreCase("boolean") && !campos.get(i).getTipo().equalsIgnoreCase("int")
                    && !campos.get(i).getTipo().equalsIgnoreCase("long")) || campos.get(i).getTipo().equalsIgnoreCase("Date")) {
                campos.get(i).setTipo("String");
            }
        }

        String st = "package gerado;\n"
                + "\n"
                + "/**\n"
                + " *\n"
                + " * @author diego\n"
                + " */\n"
                + "public class " + nc + " {\n"
                + "\n";
        for (int i = 0; i < campos.size(); i++) {
            st += "    private " + campos.get(i).getTipo() + " " + campos.get(i).getNome() + ";\n";
        }

        st += "    \n"
                + "\n"
                + "    public " + nc + "(";
        for (int i = 0; i < campos.size() - 1; i++) {
            st += campos.get(i).getTipo() + " " + campos.get(i).getNome() + ", ";
        }
        st += campos.get(campos.size() - 1).getTipo() + " " + campos.get(campos.size() - 1).getNome() + ") {\n";

        for (int i = 0; i < campos.size(); i++) {
            st += "        this." + campos.get(i).getNome() + " = " + campos.get(i).getNome() + ";\n";

        }
        st += "    }\n"
                + "    \n"
                + "    public " + nc + "(){}\n"
                + "\n";
        for (int i = 0; i < campos.size(); i++) {
            st += "    public void set" + ajeita(campos.get(i).getNome()) + "(" + campos.get(i).getTipo() + " " + campos.get(i).getNome() + ") {\n"
                    + "        this." + campos.get(i).getNome() + " = " + campos.get(i).getNome() + ";\n"
                    + "    }\n"
                    + "\n";

        }

        for (int i = 0; i < campos.size(); i++) {
            if (campos.get(i).getTipo().equals("boolean")) {
                st += "public boolean is" + ajeita(campos.get(i).getNome()) + "() {\n"
                        + "        return " + campos.get(i).getNome() + ";\n"
                        + "    }";
            } else {
                st += "    public " + campos.get(i).getTipo() + " get" + ajeita(campos.get(i).getNome()) + "() {\n"
                        + "        return " + campos.get(i).getNome() + ";\n"
                        + "    }\n"
                        + "\n";
            }
        }
        st += "\n"
                + "    \n"
                + "}";

        m.gerar("src/gerado/" + ajeita(dados.getNome()) + "Entidade.java", st);

    }

    public static String ajeita(String n) {
        return n.substring(0, 1).toUpperCase() + n.substring(1, n.length()).toLowerCase();
    }

    public void setDados(Dados dados) throws IOException {
        this.dados = dados;
        gerar();
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

}

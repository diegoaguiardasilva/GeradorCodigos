package Main;

import java.util.ArrayList;

public class Dados {
    
    private int id;
    private String nome;
    private ArrayList<Campo> campos;

    public Dados() {
    }
    
    public Dados(int id, String nome, ArrayList<Campo> campos) {
        this.id = id;
        this.nome = nome;
        this.campos = campos;
    }

    public ArrayList<Campo> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList<Campo> campos) {
        this.campos = campos;
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
    
}

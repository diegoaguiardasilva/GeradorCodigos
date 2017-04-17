/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author diego
 */
public class Campo {

    private int id;
    private int id_dados;
    private String nome;
    private String tipo;
    private String a;
    private String b;

    public Campo() {
    }

    public Campo(int id, int id_dados, String nome, String tipo, String r_ou_c, String a, String b) {
        this.id = id;
        this.id_dados = id_dados;
        this.nome = nome;
        this.tipo = tipo;
        this.a = a;
        this.b = b;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dados() {
        return id_dados;
    }

    public void setId_dados(int id_dados) {
        this.id_dados = id_dados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

}


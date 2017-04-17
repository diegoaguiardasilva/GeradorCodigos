package Main;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gerador de Códigos
 */
public class PessoaControle {

    ArrayList<PessoaEntidade> lista = new ArrayList<>();

    public void create(PessoaEntidade obj) {
        lista.add(obj);
    }

    public PessoaEntidade read(int id) {
        PessoaEntidade val = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getnome == id) {
                val = lista.get(i);
            }
        }
        return val;
    }

    public void delete(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getnome() == id) {
                lista.remove(i);
            }
        }
    }

    public void update(int id, PessoaEntidade ent) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getnome() == id) {
lista.get(i).setNome(ent.getNome());
lista.get(i).setNascimento(ent.getNascimento());
lista.get(i).setIdade(ent.getIdade());
lista.get(i).setCpf(ent.getCpf());
            }
        }
    }

}

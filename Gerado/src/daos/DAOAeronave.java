package daos;

import Entidades.Aeronave;

public class DAOAeronave extends DAOGenerico<Aeronave> {

    public DAOAeronave() {
        super(Aeronave.class);
    }

    public int autoIdAeronave() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.id) FROM Aeronave e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }
    
    public String esp(int n) {
        String t = "";
        for (int i = 0; i < n; i++) {
            t += " ";
        }
        return t;
    }

}

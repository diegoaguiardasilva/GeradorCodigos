
package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManipulaTxt {
    
    public void gerar(String caminho, String str) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
        buffWrite.append(str);
        buffWrite.close();
    }
    
    public ArrayList<String> ler(String caminho) throws IOException {
        
        BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
        String linha = "";
        ArrayList<String> str = new ArrayList<>();
        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {
                str.add(linha);
            } else {
                break;
            }
        }
        buffRead.close();
        return str;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Main.GeraEntidade.ajeita;
import java.io.IOException;
import java.util.ArrayList;

public class GeraGUI {

    private Dados dados;

    public void gerar() throws IOException {

        String t;

        ManipulaTxt m = new ManipulaTxt();

        String nc = ajeita(dados.getNome());

        ArrayList<Campo> campos = dados.getCampos();

        try {

            String st = "package gerado;\n"
                    + "\n"
                    + "import java.awt.BorderLayout;\n"
                    + "import java.awt.Color;\n"
                    + "import java.awt.Container;\n"
                    + "import java.awt.Dimension;\n"
                    + "import java.awt.FlowLayout;\n"
                    + "import java.awt.Font;\n"
                    + "import java.awt.GridLayout;\n"
                    + "import java.awt.Image;\n"
                    + "import java.awt.event.ActionEvent;\n"
                    + "import java.awt.event.ActionListener;\n"
                    + "import java.awt.event.MouseAdapter;\n"
                    + "import java.awt.event.MouseEvent;\n"
                    + "import java.io.File;\n"
                    + "import java.net.URL;\n"
                    + "import java.util.ArrayList;\n"
                    + "import javax.swing.ButtonGroup;\n"
                    + "import javax.swing.ImageIcon;\n"
                    + "import javax.swing.JButton;\n"
                    + "import javax.swing.JCheckBox;\n"
                    + "import javax.swing.JFileChooser;\n"
                    + "import javax.swing.JFrame;\n"
                    + "import javax.swing.JLabel;\n"
                    + "import javax.swing.JOptionPane;\n"
                    + "import javax.swing.JPanel;\n"
                    + "import javax.swing.JRadioButton;\n"
                    + "import javax.swing.JScrollPane;\n"
                    + "import javax.swing.JTable;\n"
                    + "import javax.swing.JTextField;\n"
                    + "import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;"
                    + "\n"
                    + "public class " + nc + "GUI extends JFrame {\n"
                    + "\n"
                    + "    Container cp;\n"
                    + "    JTextField tbuscar = new JTextField(44);\n"
                    + "    JLabel lbuscar = new JLabel(\"Buscar:   \");\n"
                    + "\n"
                    + "    " + nc + "Controle con = new " + nc + "Controle();\n"
                    + "\n"
                    + "    URL urladd = getClass().getResource(\"imagens/adicionar.png\");\n"
                    + "    ImageIcon ad = new ImageIcon(urladd);\n"
                    + "\n"
                    + "    URL urlir = getClass().getResource(\"imagens/ir.png\");\n"
                    + "    ImageIcon ir = new ImageIcon(urlir);\n"
                    + "\n"
                    + "    URL urlexc = getClass().getResource(\"imagens/excluir.png\");\n"
                    + "    ImageIcon exc = new ImageIcon(urlexc);\n"
                    + "\n"
                    + "    URL urlfechar = getClass().getResource(\"imagens/fechar.png\");\n"
                    + "    ImageIcon cl = new ImageIcon(urlfechar);\n"
                    + "\n"
                    + "    URL urlsl = getClass().getResource(\"imagens/salvar.png\");\n"
                    + "    ImageIcon sl = new ImageIcon(urlsl);\n"
                    + "\n"
                    + "    URL urlli = getClass().getResource(\"imagens/listar.png\");\n"
                    + "    ImageIcon li = new ImageIcon(urlli);\n"
                    + "\n"
                    + "    URL urlperg = getClass().getResource(\"imagens/pergunta.png\");\n"
                    + "    ImageIcon pergunta = new ImageIcon(urlperg);\n"
                    + "\n"
                    + "    URL urlalert = getClass().getResource(\"imagens/alerta.png\");\n"
                    + "    ImageIcon alerta = new ImageIcon(urlalert);\n"
                    + "\n"
                    + "    URL urlok = getClass().getResource(\"imagens/ok.png\");\n"
                    + "    ImageIcon ok = new ImageIcon(urlok);\n"
                    + "\n"
                    + "    JLabel avisos = new JLabel(\"Avisos\");\n"
                    + "    JLabel erros = new JLabel(\"Faça uma busca pela chave.\");\n"
                    + "\n"
                    + "    //aqui muda a\n";
            for (int i = 0; i < campos.size() - 1; i++) {
                if (campos.get(i).getTipo().equals("boolean")) {
                    st += "    JLabel l" + campos.get(i).getNome() + campos.get(i).getId() + " = new JLabel(\"" + ajeita(campos.get(i).getNome()) + ":\" + con.esp(54 - \"" + campos.get(i).getA() + campos.get(i).getB() + campos.get(i).getNome() + ":\".length()));\n";
                } else if (campos.get(i).getTipo().equals("Date")) {
                    st += "    JLabel l" + campos.get(i).getNome() + campos.get(i).getId() + " = new JLabel(\"" + ajeita(campos.get(i).getNome()) + ":\" + con.esp(52 - \"" + ajeita(campos.get(i).getNome()) + ":\".length()));\n";
                } else {
                    st += "    JLabel l" + campos.get(i).getNome() + campos.get(i).getId() + " = new JLabel(\"" + ajeita(campos.get(i).getNome()) + ":\" + con.esp(20 - \"" + ajeita(campos.get(i).getNome()) + ":\".length()));\n";
                }
            }
            if (campos.get(campos.size() - 1).getTipo().equals("boolean")) {
                st += "    JLabel l" + campos.get(campos.size() - 1).getNome() + campos.get(campos.size() - 1).getId() + " = new JLabel(\"" + ajeita(campos.get(campos.size() - 1).getNome()) + ":\" + con.esp(54 - \"" + campos.get(campos.size() - 1).getA() + campos.get(campos.size() - 1).getNome() + campos.get(campos.size() - 1).getB() + ":\".length()));\n";
            } else {
                st += "    JLabel l" + campos.get(campos.size() - 1).getNome() + campos.get(campos.size() - 1).getId() + " = new JLabel(\"" + ajeita(campos.get(campos.size() - 1).getNome()) + ":\" + con.esp(20 - \"" + ajeita(campos.get(campos.size() - 1).getNome()) + ":\".length()));\n";
            }

            st += "\n";
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("String") || campos.get(i).getTipo().equals("int") || campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("double")) {
                    st += "    JTextField t" + campos.get(i).getNome() + campos.get(i).getId() + " = new JTextField(42);\n";
                } else if (campos.get(i).getTipo().equals("Date")) {
                    st += "    DateTextField t" + campos.get(i).getNome() + campos.get(i).getId() + " = new DateTextField();\n";
                } else if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "    JRadioButton b" + campos.get(i).getA() + campos.get(i).getId() + " = new JRadioButton(\"" + ajeita(campos.get(i).getA()) + "\");\n"
                            + "    JRadioButton b" + campos.get(i).getB() + campos.get(i).getId() + " = new JRadioButton(\"" + ajeita(campos.get(i).getB()) + "\");\n"
                            + "    ButtonGroup bg" + campos.get(i).getNome() + campos.get(i).getId() + " = new ButtonGroup();\n";
                } else if (campos.get(i).getTipo().equals("boolean")) {
                    st += "    JCheckBox b" + campos.get(i).getNome() + campos.get(i).getId() + " = new JCheckBox(\"" + campos.get(i).getNome() + "\");\n"
                            + "    JLabel b" + campos.get(i).getNome() + campos.get(i).getId() + "preenche = new JLabel(con.esp(60 - \"c" + campos.get(i).getNome() + campos.get(i).getId() + "\".length()));\n";
                } else {
                    st += "JComboBox combo" + campos.get(i).getNome() + campos.get(i).getId() + ";\n";
                }
            }

            st += "\n"
                    + "    JButton salvar = new JButton(sl); //C\n"
                    + "    JButton buscar = new JButton(ir); //R\n"
                    + "    JButton update = new JButton(sl); //U\n"
                    + "    JButton excluir = new JButton(exc); //D\n"
                    + "\n"
                    + "    JButton add = new JButton(ad); // Mostra os campos para criar\n"
                    + "\n"
                    + "    JButton cancelar = new JButton(cl);\n"
                    + "    JButton listar = new JButton(li);\n"
                    + "\n"
                    + "    JPanel norte = new JPanel();\n"
                    + "    JPanel centro = new JPanel();\n"
                    + "    JPanel sul = new JPanel();\n"
                    + "\n"
                    + "    Font f = new Font(\"Consolas\", Font.PLAIN, 24);\n"
                    + "\n"
                    + "    \n"
                    + "    \n"
                    + "    JLabel limagem = new JLabel(\"\");\n"
                    + "    Image imagemAux;\n"
                    + "    \n"
                    + "    String origem;\n"
                    + "    String destino;\n"
                    + "    \n"
                    + "    JPanel pimagem = new JPanel();\n"
                    + "\n"
                    + "    "
                    + "    public " + nc + "GUI() {\n"
                    + "        setSize(833, 720);\n"
                    + "        setResizable(false);\n"
                    + "        setLocationRelativeTo(null);\n"
                    + "        setDefaultCloseOperation(DISPOSE_ON_CLOSE);\n"
                    + "        cp = getContentPane();\n"
                    + "        cp.setLayout(new BorderLayout());\n"
                    + "        setTitle(\"Gerenciamento de " + nc + "\");\n"
                    + "\n";
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "        b" + campos.get(i).getA() + campos.get(i).getId() + ".setSelected(true);\n";
                } else if (campos.get(i).getTipo().equals("boolean") && campos.get(i).getA().equals("") && campos.get(i).getB().equals("")) {
                    st += "        b" + campos.get(i).getNome() + campos.get(i).getId() + ".setSelected(true);\n";
                }
            }

            st += "\n"
                    + "        norte.setLayout(new FlowLayout());\n"
                    + "        norte.add(lbuscar).setFont(f);\n"
                    + "        norte.add(tbuscar).setFont(f);\n"
                    + "        norte.add(buscar).setFont(f);\n"
                    + "        norte.add(add);\n"
                    + "        norte.add(listar);\n"
                    + "\n"
                    + "        //aqui muda a\n"
                    + "        buscar.setBorder(null);\n"
                    + "        buscar.setBackground(Color.white);\n"
                    + "        buscar.setPreferredSize(new Dimension(30, 30));\n"
                    + "        add.setBorder(null);\n"
                    + "        add.setBackground(Color.white);\n"
                    + "        add.setPreferredSize(new Dimension(30, 30));\n"
                    + "        salvar.setBorder(null);\n"
                    + "        salvar.setBackground(Color.white);\n"
                    + "        salvar.setPreferredSize(new Dimension(30, 30));\n"
                    + "        listar.setBorder(null);\n"
                    + "        listar.setBackground(Color.white);\n"
                    + "        listar.setPreferredSize(new Dimension(30, 30));\n"
                    + "\n"
                    + "        //caso tenha algum boolean\n";
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "        b" + campos.get(i).getA() + campos.get(i).getId() + ".setFont(f);\n"
                            + "        b" + campos.get(i).getA() + campos.get(i).getId() + ".setBorder(null);\n"
                            + "        b" + campos.get(i).getA() + campos.get(i).getId() + ".setBackground(Color.white);\n"
                            + "        bg" + campos.get(i).getNome() + campos.get(i).getId() + ".add(b" + campos.get(i).getA() + campos.get(i).getId() + ");\n"
                            + "\n"
                            + "        b" + campos.get(i).getB() + campos.get(i).getId() + ".setFont(f);\n"
                            + "        b" + campos.get(i).getB() + campos.get(i).getId() + ".setBorder(null);\n"
                            + "        b" + campos.get(i).getB() + campos.get(i).getId() + ".setBackground(Color.white);\n"
                            + "        bg" + campos.get(i).getNome() + campos.get(i).getId() + ".add(b" + campos.get(i).getB() + campos.get(i).getId() + ");\n"
                            + "\n";
                }
            }
            st += "        //aqui muda f\n"
                    + "        update.setBorder(null);\n"
                    + "        update.setBackground(Color.white);\n"
                    + "        update.setPreferredSize(new Dimension(30, 30));\n"
                    + "        cancelar.setBorder(null);\n"
                    + "        cancelar.setBackground(Color.white);\n"
                    + "        cancelar.setPreferredSize(new Dimension(30, 30));\n"
                    + "        excluir.setBorder(null);\n"
                    + "        excluir.setBackground(Color.white);\n"
                    + "        excluir.setPreferredSize(new Dimension(30, 30));\n"
                    + "        centro.setBackground(Color.white);\n"
                    + "        sul.setBackground(Color.white);\n"
                    + "        norte.setBackground(Color.white);\n"
                    + "        cp.setBackground(Color.white);\n"
                    + "\n"
                    + "        sul.setLayout(new GridLayout(2, 1));\n"
                    + "        sul.add(avisos).setFont(new Font(\"Consolas\", Font.ITALIC, 24));\n"
                    + "        erros.setForeground(Color.BLUE);\n"
                    + "        sul.add(erros).setFont(new Font(\"Consolas\", Font.ITALIC, 16));\n"
                    + "\n"
                    + "        cp.add(norte, BorderLayout.NORTH);\n"
                    + "        cp.add(centro, BorderLayout.CENTER);\n"
                    + "        cp.add(sul, BorderLayout.SOUTH);\n"
                    + "\n"
                    + "        buscar.addActionListener(new ActionListener() {\n"
                    + "            @Override\n"
                    + "            public void actionPerformed(ActionEvent ae) {\n"
                    + "\n"
                    + "                " + nc + "Entidade a = new " + nc + "Entidade();\n"
                    + "                try {\n"
                    + "                    a = con.read(new " + nc + "Entidade(";

            if (campos.get(0).getTipo().equals("int")) {
                st += "Integer.valueOf(tbuscar.getText()), ";
            } else if (campos.get(0).getTipo().equals("Date")) {
                st += "String.valueOf(tbuscar.getText()), ";
            } else if (campos.get(0).getTipo().equals("boolean")) {
                st += "Boolean.parseBoolean(tbuscar.isSelected()), ";
            } else if (campos.get(0).getTipo().equals("double") || campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("long")) {
                st += ajeita(campos.get(0).getTipo()) + ".valueOf(tbuscar.getText()), ";
            }

            for (int i = 1; i < campos.size() - 1; i++) {
                if (campos.get(i).getTipo().equals("boolean")) {
                    st += "true, ";
                } else if (campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("int")) {
                    st += "0, ";
                } else if (campos.get(i).getTipo().equals("double")) {
                    st += "0.0, ";
                } else {
                    st += "\"\", ";
                }
            }
            if (campos.get(campos.size() - 1).getTipo().equals("boolean")) {
                st += "true));\n";
            } else if (campos.get(campos.size() - 1).getTipo().equals("long") || campos.get(campos.size() - 1).getTipo().equals("int")) {
                st += "0));\n";
            } else if (campos.get(campos.size() - 1).getTipo().equals("double")) {
                st += "0.0));\n";
            } else {
                st += "\"\"));\n";
            }

            st += "                    if (a != null) {\n"
                    + "                        norte.removeAll();\n"
                    + "                        norte.add(new JLabel((\"                                                      \"))).setFont(f);\n"
                    + "                        norte.add(update).setFont(f);\n"
                    + "                        norte.add(excluir).setFont(f);\n"
                    + "                        norte.add(cancelar).setFont(f);\n"
                    + "                        centro.setLayout(new FlowLayout(FlowLayout.LEFT));\n"
                    + "\n"
                    + "                        //aqui muda a\n";

            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("Date") || campos.get(i).getTipo().equals("String") || campos.get(i).getTipo().equals("int") || campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("double")) {
                    st += "                        centro.add(l" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        centro.add(t" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n";
                } else if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "                        centro.add(l" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        centro.add(b" + campos.get(i).getA() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        centro.add(b" + campos.get(i).getB() + campos.get(i).getId() + ").setFont(f);\n";
                } else if (campos.get(i).getTipo().equals("boolean")) {
                    st += "                        centro.add(b" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        centro.add(b" + campos.get(i).getNome() + campos.get(i).getId() + "preenche).setFont(f);\n"
                            + "";

                }
            }

            for (int i = 0; i < campos.size(); i++) {
                if (!campos.get(i).getTipo().equals("boolean") && !campos.get(i).getTipo().equals("Date") && !campos.get(i).getTipo().equals("String") && !campos.get(i).getTipo().equals("int") && !campos.get(i).getTipo().equals("long") && !campos.get(i).getTipo().equals("double")) {
                    st += "\n"
                            + "                        combo" + campos.get(i).getNome() + campos.get(i).getId() + " = new JComboBox(con.busca_relacionamento(\"" + campos.get(i).getTipo() + "\"));\n"
                            + "\n"
                            + "                        centro.add(l" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        combo" + campos.get(i).getNome() + campos.get(i).getId() + ".setBackground(Color.WHITE);\n"
                            + "                        centro.add(combo" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        ";
                }
            }

            st += " \n"
                    + "                        \n"
                    + "                        \n"
                    + "                        try {\n"
                    + "                            \n"
                    + "                            \n"
                    + "                            origem = \"fotos/\"+a.getId()+\".png\";\n"
                    + "                            \n"
                    + "                            \n"
                    + "                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));\n"
                    + "                            imagemAux = icone.getImage();\n"
                    + "                            icone.setImage(imagemAux.getScaledInstance(150, 150, Image.SCALE_FAST));\n"
                    + "                            limagem.setIcon(icone);\n"
                    + "\n"
                    + "                        } catch (Exception e) {\n"
                    + "                            System.out.println(\"erro ao  carregar a imagem\");\n"
                    + "                        }\n"
                    + "\n"
                    + "                        pimagem.add(limagem);\n"
                    + "                        centro.add(pimagem);\n"
                    + "\n"
                    + "                        ";

            st += "                        t" + campos.get(0).getNome() + campos.get(0).getId() + ".setEditable(false);\n"
                    + "\n"
                    + "                        //aqui muda f\n"
                    + "                        centro.repaint();\n"
                    + "                        norte.repaint();\n"
                    + "\n";

            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("Date") || campos.get(i).getTipo().equals("String") || campos.get(i).getTipo().equals("int") || campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("double")) {
                    st += "                        t" + campos.get(i).getNome() + campos.get(i).getId() + ".setText(a.get" + ajeita(campos.get(i).getNome()) + "() + \"\");\n";
                } else if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "\n"
                            + "                        b" + campos.get(i).getA() + campos.get(i).getId() + ".setSelected(a.is" + ajeita(campos.get(i).getNome()) + "());\n"
                            + "                        b" + campos.get(i).getB() + campos.get(i).getId() + ".setSelected(!a.is" + ajeita(campos.get(i).getNome()) + "());\n";
                } else if (campos.get(i).getTipo().equals("boolean")) {
                    st += "\n"
                            + "                        b" + campos.get(i).getNome() + campos.get(i).getId() + ".setSelected(a.is" + ajeita(campos.get(i).getNome()) + "());";
                } else if (!campos.get(i).getTipo().equals("boolean") && !campos.get(i).getTipo().equals("Date") && !campos.get(i).getTipo().equals("String") && !campos.get(i).getTipo().equals("int") && !campos.get(i).getTipo().equals("long") && !campos.get(i).getTipo().equals("double")) {
                    st += "try {\n"
                            + "                            String ind" + campos.get(i).getId() + " = a.get" + ajeita(campos.get(i).getNome()) + "().substring(a.get" + ajeita(campos.get(i).getNome()) + "().indexOf(\"[\") + 1, a.get" + ajeita(campos.get(i).getNome()) + "().indexOf(\"]\"));\n"
                            + "\n"
                            + "                            for (int i = 0; i < 1000; i++) {\n"
                            + "                                if (combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getItemAt(i).toString().substring(combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getItemAt(i).toString().indexOf(\"[\") + 1, combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getItemAt(i).toString().indexOf(\"]\")).equals(ind" + campos.get(i).getId() + ")) {\n"
                            + "                                    combo" + campos.get(i).getNome() + campos.get(i).getId() + ".setSelectedIndex(i);\n"
                            + "                                }\n"
                            + "                            }\n"
                            + "\n"
                            + "                        } catch (Exception k) {\n"
                            + "                        }";
                }

            }

            st += "\n"
                    + "                        erros.setForeground(Color.BLUE);\n"
                    + "                        erros.setFont(new Font(\"Consolas\", Font.PLAIN, 16));\n"
                    + "                        erros.setText(\"Altere os dados, exclua ou apenas retorne a página de busca!\");\n"
                    + "\n"
                    + "                    } else {\n"
                    + "\n"
                    + "                        int x = 0 / 0;\n"
                    + "\n"
                    + "                    }\n"
                    + "\n"
                    + "                } catch (Exception ex) {\n"
                    + "                    erros.setForeground(Color.RED);\n"
                    + "                    erros.setFont(new Font(\"Consolas\", Font.ITALIC, 16));\n"
                    + "                    JOptionPane.showMessageDialog(null, \"Nada encontrado!\", \"Ops!\", 0, alerta);\n"
                    + "                    erros.setText(\"Nada encontrado, adicione um novo.\");\n"
                    + "                }\n"
                    + "            }\n"
                    + "        });\n"
                    + "\n"
                    + "        add.addActionListener(new ActionListener() {\n"
                    + "\n"
                    + "            @Override\n"
                    + "            public void actionPerformed(ActionEvent ae) {\n"
                    + "                norte.removeAll();\n"
                    + "                norte.add(new JLabel((\"                                                         \"))).setFont(f);\n"
                    + "                norte.add(salvar).setFont(f);\n"
                    + "                norte.add(cancelar).setFont(f);\n"
                    + "                centro.setLayout(new FlowLayout(FlowLayout.LEFT));\n"
                    + "\n";
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("Date") || campos.get(i).getTipo().equals("String") || campos.get(i).getTipo().equals("int") || campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("double")) {
                    st += "                        centro.add(l" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        centro.add(t" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n";
                } else if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "                        centro.add(l" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        centro.add(b" + campos.get(i).getA() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        centro.add(b" + campos.get(i).getB() + campos.get(i).getId() + ").setFont(f);\n";
                } else if (campos.get(i).getTipo().equals("boolean")) {
                    st += "                        centro.add(b" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        centro.add(b" + campos.get(i).getNome() + campos.get(i).getId() + "preenche).setFont(f);\n"
                            + "";

                }
            }

            for (int i = 0; i < campos.size(); i++) {
                if (!campos.get(i).getTipo().equals("boolean") && !campos.get(i).getTipo().equals("Date") && !campos.get(i).getTipo().equals("String") && !campos.get(i).getTipo().equals("int") && !campos.get(i).getTipo().equals("long") && !campos.get(i).getTipo().equals("double")) {
                    st += "\n"
                            + "try {\n"
                            + "                        combo" + campos.get(i).getNome() + campos.get(i).getId() + " = new JComboBox(con.busca_relacionamento(\"" + campos.get(i).getTipo() + "\"));\n"
                            + "                } catch (SQLException ex) {\n"
                            + "                }"
                            + "\n"
                            + "                        centro.add(l" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        combo" + campos.get(i).getNome() + campos.get(i).getId() + ".setBackground(Color.WHITE);\n"
                            + "                        centro.add(combo" + campos.get(i).getNome() + campos.get(i).getId() + ").setFont(f);\n"
                            + "                        ";
                }
            }

            st += "                        t" + campos.get(0).getNome() + campos.get(0).getId() + ".setEditable(true);\n"
                    + "                //aqui muda f\n"
                    + "\n"
                    + "\n"
                    + "                try {\n"
                    + "                    origem = \"fotos/0.png\";\n"
                    + "                    ImageIcon icone = new ImageIcon(getClass().getResource(origem));\n"
                    + "                    imagemAux = icone.getImage();\n"
                    + "                    icone.setImage(imagemAux.getScaledInstance(150, 150, Image.SCALE_FAST));\n"
                    + "                    limagem.setIcon(icone);\n"
                    + "\n"
                    + "                } catch (Exception e) {\n"
                    + "                    System.out.println(\"erro ao carregar a imagem\");\n"
                    + "                }\n"
                    + "\n"
                    + "                pimagem.add(limagem);\n"
                    + "                centro.add(pimagem);\n"
                    + "\n"
                    + "                "
                    + "                centro.repaint();\n"
                    + "                norte.repaint();\n"
                    + "                erros.setText(\"Adicione um novo e não se esqueça de salvar!\");\n"
                    + "                erros.setForeground(Color.BLUE);\n"
                    + "            }\n"
                    + "        });\n"
                    + "\n"
                    + "        cancelar.addActionListener(new ActionListener() {\n"
                    + "\n"
                    + "            @Override\n"
                    + "            public void actionPerformed(ActionEvent ae) {\n"
                    + "                norte.removeAll();\n"
                    + "                centro.removeAll();\n"
                    + "\n"
                    + "                //aqui muda a\n"
                    + "                norte.add(lbuscar).setFont(f);\n"
                    + "                norte.add(tbuscar).setFont(f);\n"
                    + "                norte.add(buscar).setFont(f);\n"
                    + "                norte.add(add);\n"
                    + "                norte.add(listar);\n"
                    + "\n";
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("Date") || campos.get(i).getTipo().equals("String") || campos.get(i).getTipo().equals("int") || campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("double")) {
                    st += "                        t" + campos.get(i).getNome() + campos.get(i).getId() + ".setText(\"\");\n";
                }
            }
            st += "\n";

            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("Date")) {
                    st += "                t" + campos.get(i).getNome() + campos.get(i).getId() + ".setText(\"01/01/2000\");\n";
                } else if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "                b" + campos.get(i).getA() + campos.get(i).getId() + ".setSelected(true);\n";
                } else if (campos.get(i).getTipo().equals("boolean") && campos.get(i).getA().equals("") && campos.get(i).getB().equals("")) {
                    st += "                b" + campos.get(i).getNome() + campos.get(i).getId() + ".setSelected(true);\n";
                }
            }

            st += "\n"
                    + "                //aqui muda f\n"
                    + "                norte.repaint();\n"
                    + "                centro.repaint();\n"
                    + "\n"
                    + "                erros.setText(\"Busque algo pela chave!\");\n"
                    + "                erros.setForeground(Color.BLUE);\n"
                    + "                erros.setFont(new Font(\"Consolas\", Font.ITALIC, 16));\n"
                    + "            }\n"
                    + "        });\n"
                    + "\n"
                    + "        update.addActionListener(new ActionListener() {\n"
                    + "\n"
                    + "            @Override\n"
                    + "            public void actionPerformed(ActionEvent ae) {\n"
                    + "\n"
                    + "                int opcao = JOptionPane.showConfirmDialog(null, \"Deseja mesmo alterar os dados?\", \"Então?\", JOptionPane.YES_NO_OPTION, 0, pergunta);\n"
                    + "                if (opcao == 0) {\n"
                    + "\n"
                    + "                    " + nc + "Entidade a = new " + nc + "Entidade();\n"
                    + "\n"
                    + "                    //aqui muda a\n";
            //((((((((((aqui - continuar))))))))))

            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("double")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(Double.valueOf(t" + campos.get(i).getNome() + campos.get(i).getId() + ".getText().replaceAll(\",\", \".\")));\n";
                } else if (campos.get(i).getTipo().equals("int")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(Integer.valueOf(t" + campos.get(i).getNome() + campos.get(i).getId() + ".getText()));\n";
                } else if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(b" + campos.get(i).getA() + campos.get(i).getId() + ".isSelected());\n";
                } else if (campos.get(i).getTipo().equals("boolean") && campos.get(i).getA().equals("") && campos.get(i).getB().equals("")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(b" + campos.get(i).getNome() + campos.get(i).getId() + ".isSelected());\n";
                } else if (campos.get(i).getTipo().equals("long")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(Long.valueOf(t" + campos.get(i).getNome() + campos.get(i).getId() + ".getText()));\n";
                } else if (campos.get(i).getTipo().equals("Date") || campos.get(i).getTipo().equals("String")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(t" + campos.get(i).getNome() + campos.get(i).getId() + ".getText());\n";
                }
            }

            for (int i = 0; i < campos.size(); i++) {
                if (!campos.get(i).getTipo().equals("boolean") && !campos.get(i).getTipo().equals("Date") && !campos.get(i).getTipo().equals("String") && !campos.get(i).getTipo().equals("int") && !campos.get(i).getTipo().equals("long") && !campos.get(i).getTipo().equals("double")) {
                    st += "\n"
                            + "                    String n"+campos.get(i).getId()+";\n"
                            + "                    try {\n"
                            + "                        n"+campos.get(i).getId()+" = combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getSelectedItem().toString().substring(combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getSelectedItem().toString().indexOf(\"[\") + 1, combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getSelectedItem().toString().indexOf(\"]\"));\n"
                            + "                    } catch (Exception z) {\n"
                            + "                        n"+campos.get(i).getId()+" = \"null\";\n"
                            + "                    }\n"
                            + "                    \n"
                            + "\n"
                            + "                    a.set" + ajeita(campos.get(i).getNome()) + "(\"" + campos.get(i).getTipo() + "[\" + n"+campos.get(i).getId()+" + \"]\");\n"
                            + "\n"
                            + "                    ";

                }

            }

            st += "                    con.update(new " + nc + "Entidade(";
            if (campos.get(0).getTipo().equals("int")) {
                st += "Integer.valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            } else if (campos.get(0).getTipo().equals("boolean") && !campos.get(0).getA().equals("") && !campos.get(0).getB().equals("")) {
                st += "Boolean.parseBoolean(t" + campos.get(0).getA() + campos.get(0).getId() + ".isSelected()), ";
            } else if (campos.get(0).getTipo().equals("boolean") && campos.get(0).getA().equals("") && campos.get(0).getB().equals("")) {
                st += "Boolean.parseBoolean(t" + campos.get(0).getNome() + campos.get(0).getId() + ".isSelected()), ";
            } else if (campos.get(0).getTipo().equals("double") || campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("long")) {
                st += ajeita(campos.get(0).getTipo()) + ".valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            } else {
                st += "String.valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            }

            for (int i = 1; i < campos.size() - 1; i++) {
                if (campos.get(i).getTipo().equals("boolean")) {
                    st += "true, ";
                } else if (campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("int")) {
                    st += "0, ";
                } else if (campos.get(i).getTipo().equals("double")) {
                    st += "0.0, ";
                } else {
                    st += "\"\", ";
                }
            }
            if (campos.get(campos.size() - 1).getTipo().equals("boolean")) {
                st += "true), a);\n";
            } else if (campos.get(campos.size() - 1).getTipo().equals("long") || campos.get(campos.size() - 1).getTipo().equals("int")) {
                st += "0), a);\n";
            } else if (campos.get(campos.size() - 1).getTipo().equals("double")) {
                st += "0.0), a);\n";
            } else {
                st += "\"\"), a);\n";
            }

            st += "/*--------------------------------------------AQUI----------------------------------------------------------*/\n"
                    + "                    \n"
                    + "                    destino = \"src\\\\gerado\\\\fotos\\\\\"  + t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText() + \".png\";\n"
                    + "                    CopiaImagem.copiar(origem, destino);\n"
                    + "\n"
                    + "                    /*--------------------------------------------AQUI----------------------------------------------------------*/";

            st += "\n"
                    + "                    JOptionPane.showMessageDialog(null, \"Alterado com Sucesso!\", \"Tudo Certo!\", 0, ok);\n"
                    + "                    cancelar.doClick();\n"
                    + "\n"
                    + "                    //aqui muda f\n"
                    + "                } else {\n"
                    + "                    cancelar.doClick();\n"
                    + "                }\n"
                    + "\n"
                    + "            }\n"
                    + "        });\n"
                    + "\n"
                    + "        listar.addActionListener(new ActionListener() {\n"
                    + "\n"
                    + "            @Override\n"
                    + "            public void actionPerformed(ActionEvent ae) {\n"
                    + "\n"
                    + "                ArrayList<" + nc + "Entidade> entidades = con.listar();\n"
                    + "\n"
                    + "                //aqui muda a\n"
                    + "                Object[] col = new Object[]{";
            for (int i = 0; i < campos.size() - 1; i++) {
                st += "\"" + ajeita(campos.get(i).getNome()) + "\", ";
            }
            st += "\"" + ajeita(campos.get(campos.size() - 1).getNome()) + "\"};\n";
            st += "\n"
                    + "                Object[][] valores = new Object[entidades.size()][col.length];\n"
                    + "\n"
                    + "                for (int i = 0; i < entidades.size(); i++) {\n";
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "                    valores[i][" + i + "] = entidades.get(i).is" + ajeita(campos.get(i).getNome()) + "() ? \"" + ajeita(campos.get(i).getA()) + "\" : \"" + ajeita(campos.get(i).getB()) + "\";\n";
                } else if (campos.get(i).getTipo().equals("boolean") && campos.get(i).getA().equals("") && campos.get(i).getB().equals("")) {
                    st += "                    valores[i][" + i + "] = entidades.get(i).is" + ajeita(campos.get(i).getNome()) + "() ? \"true\" : \"false\";\n";
                } else {
                    st += "                    valores[i][" + i + "] = entidades.get(i).get" + ajeita(campos.get(i).getNome()) + "();\n";
                }
            }

            st += "                //aqui muda f\n"
                    + "\n"
                    + "                JTable table = new JTable(valores, col);\n"
                    + "\n"
                    + "                table.setFont(new Font(\"Arial\", Font.PLAIN, 16));\n"
                    + "                table.setRowHeight(30);\n"
                    + "                table.setEnabled(false);\n"
                    + "\n"
                    + "                JScrollPane scrollPane = new JScrollPane(table);\n"
                    + "\n"
                    + "                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);\n"
                    + "                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);\n"
                    + "\n"
                    + "                norte.removeAll();\n"
                    + "                norte.add(new JLabel((\"                                                           \"))).setFont(f);\n"
                    + "                norte.add(cancelar).setFont(f);\n"
                    + "\n"
                    + "                centro.removeAll();\n"
                    + "                centro.setLayout(new GridLayout(1, 1));\n"
                    + "                centro.add(scrollPane);\n"
                    + "\n"
                    + "                erros.setForeground(Color.BLUE);\n"
                    + "                erros.setFont(new Font(\"Consolas\", Font.ITALIC, 16));\n"
                    + "                erros.setText(\"Verifique todos os dados listados!\");\n"
                    + "\n"
                    + "                centro.repaint();\n"
                    + "                norte.repaint();\n"
                    + "            }\n"
                    + "          }\n"
                    + "        });\n"
                    + "\n"
                    + "        salvar.addActionListener(new ActionListener() {\n"
                    + "\n"
                    + "            @Override\n"
                    + "            public void actionPerformed(ActionEvent ae) {\n"
                    + "\n"
                    + "                try {\n"
                    + "\n"
                    + "                    //aqui muda a\n"
                    + "                    " + nc + "Entidade a = new " + nc + "Entidade();\n";

            if (campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("Date")) {
                st += "                        //";
            }
            st += "                    if (con.read(new " + nc + "Entidade(";
            //ajeitar aqui

            if (campos.get(0).getTipo().equals("int")) {
                st += "Integer.valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            } else if (campos.get(0).getTipo().equals("Date")) {
                st += "String.valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            } else if (campos.get(0).getTipo().equals("boolean") && !campos.get(0).getA().equals("") && !campos.get(0).getB().equals("")) {
                st += "Boolean.parseBoolean(t" + campos.get(0).getA() + campos.get(0).getId() + ".isSelected()), ";
            } else if (campos.get(0).getTipo().equals("boolean") && campos.get(0).getA().equals("") && campos.get(0).getB().equals("")) {
                st += "Boolean.parseBoolean(t" + campos.get(0).getNome() + campos.get(0).getId() + ".isSelected()), ";
            } else if (campos.get(0).getTipo().equals("double") || campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("long")) {
                st += ajeita(campos.get(0).getTipo()) + ".valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            }

            for (int i = 1; i < campos.size() - 1; i++) {
                if (campos.get(i).getTipo().equals("boolean")) {
                    st += "true, ";
                } else if (campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("int")) {
                    st += "0, ";
                } else if (campos.get(i).getTipo().equals("double")) {
                    st += "0.0, ";
                } else {
                    st += "\"\", ";
                }
            }

            if (campos.get(campos.size() - 1).getTipo().equals("boolean")) {
                st += "true))";
            } else if (campos.get(campos.size() - 1).getTipo().equals("long") || campos.get(campos.size() - 1).getTipo().equals("int")) {
                st += "0))";
            } else if (campos.get(campos.size() - 1).getTipo().equals("double")) {
                st += "0.0))";
            } else {
                st += "\"\"))";
            }

            st += " == null) {\n";

            st += "\n";
            for (int i = 0; i < campos.size(); i++) {
                if (campos.get(i).getTipo().equals("double")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(Double.valueOf(t" + campos.get(i).getNome() + campos.get(i).getId() + ".getText().replaceAll(\",\", \".\")));\n";
                } else if (campos.get(i).getTipo().equals("int")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(Integer.valueOf(t" + campos.get(i).getNome() + campos.get(i).getId() + ".getText()));\n";
                } else if (campos.get(i).getTipo().equals("boolean") && !campos.get(i).getA().equals("") && !campos.get(i).getB().equals("")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(b" + campos.get(i).getA() + campos.get(i).getId() + ".isSelected());\n";
                } else if (campos.get(i).getTipo().equals("boolean") && campos.get(i).getA().equals("") && campos.get(i).getB().equals("")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(b" + campos.get(i).getNome() + campos.get(i).getId() + ".isSelected());\n";
                } else if (campos.get(i).getTipo().equals("long")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(Long.valueOf(t" + campos.get(i).getNome() + campos.get(i).getId() + ".getText()));\n";
                } else if (campos.get(i).getTipo().equals("Date") || campos.get(i).getTipo().equals("String") || campos.get(i).getTipo().equals("long")) {
                    st += "                    a.set" + ajeita(campos.get(i).getNome()) + "(t" + campos.get(i).getNome() + campos.get(i).getId() + ".getText());\n";
                }
            }

            for (int i = 0; i < campos.size(); i++) {
                if (!campos.get(i).getTipo().equals("boolean") && !campos.get(i).getTipo().equals("Date") && !campos.get(i).getTipo().equals("String") && !campos.get(i).getTipo().equals("int") && !campos.get(i).getTipo().equals("long") && !campos.get(i).getTipo().equals("double")) {
                    st += "\n"
                            + "                    String n"+campos.get(i).getId()+";\n"
                            + "                    try {\n"
                            + "                        n"+campos.get(i).getId()+" = combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getSelectedItem().toString().substring(combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getSelectedItem().toString().indexOf(\"[\") + 1, combo" + campos.get(i).getNome() + campos.get(i).getId() + ".getSelectedItem().toString().indexOf(\"]\"));\n"
                            + "                    } catch (Exception z) {\n"
                            + "                        n"+campos.get(i).getId()+" = \"null\";\n"
                            + "                    }\n"
                            + "                    \n"
                            + "\n"
                            + "                    a.set" + ajeita(campos.get(i).getNome()) + "(\"" + campos.get(i).getTipo() + "[\" + n"+campos.get(i).getId()+" + \"]\");\n"
                            + "\n"
                            + "                    ";

                }

            }

            st += "                        con.create(a);\n"
                    + "                        JOptionPane.showMessageDialog(null, \"Salvo com sucesso!\", \"Oba!\", 0, ok);\n"
                    + "                        cancelar.doClick();\n"
                    + "/*--------------------------------------------AQUI----------------------------------------------------------*/\n"
                    + "                        \n"
                    + "                        destino = \"src\\\\gerado\\\\fotos\\\\\" + a.getId() + \".png\";\n"
                    + "                        CopiaImagem.copiar(origem, destino);\n"
                    + "\n"
                    + "                        /*--------------------------------------------AQUI----------------------------------------------------------*/"
                    + "\n"
                    + "                        //aqui muda f\n";
            if (campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("Date")) {
                st += "                        //";
            }
            st += "                    } else {\n";
            if (campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("Date")) {
                st += "                        //";
            }
            st += "                        int c = 0 / 0;\n";
            if (campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("Date")) {
                st += "                        //";
            }
            st += "                    }\n"
                    + "                } catch (Exception k) {\n"
                    + "                    JOptionPane.showMessageDialog(null, \"Vish, temos problemas. \\n 1) Certifique-se se todos os dados foram inseridos corretamente;\\n 2) Certifique-se se a chave já não está em uso.\", \"Ops!\", 0, alerta);\n"
                    + "                    erros.setText(\"Chave já utilizada, insira outra!\");\n"
                    + "                    erros.setForeground(Color.RED);\n"
                    + "                    erros.setFont(new Font(\"Consolas\", Font.ITALIC, 16));\n"
                    + "                }\n"
                    + "            }\n"
                    + "        });\n"
                    + "\n"
                    + "        excluir.addActionListener(new ActionListener() {\n"
                    + "            @Override\n"
                    + "            public void actionPerformed(ActionEvent ae) {\n"
                    + "\n"
                    + "                int opcao = JOptionPane.showConfirmDialog(null, \"Deseja mesmo excluir?\", \"Então?\", JOptionPane.YES_NO_OPTION, 0, pergunta);\n"
                    + "                if (opcao == 0) {\n"
                    + "                    //aqui muda a\n"
                    + "                    con.delete(new " + nc + "Entidade(";

            if (campos.get(0).getTipo().equals("int")) {
                st += "Integer.valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            } else if (campos.get(0).getTipo().equals("boolean") && !campos.get(0).getA().equals("") && !campos.get(0).getB().equals("")) {
                st += "Boolean.parseBoolean(t" + campos.get(0).getA() + campos.get(0).getId() + ".isSelected()), ";
            } else if (campos.get(0).getTipo().equals("boolean") && campos.get(0).getA().equals("") && campos.get(0).getB().equals("")) {
                st += "Boolean.parseBoolean(t" + campos.get(0).getNome() + campos.get(0).getId() + ".isSelected()), ";
            } else if (campos.get(0).getTipo().equals("double") || campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("long")) {
                st += ajeita(campos.get(0).getTipo()) + ".valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            } else {
                st += "String.valueOf(t" + campos.get(0).getNome() + campos.get(0).getId() + ".getText()), ";
            }

            for (int i = 1; i < campos.size() - 1; i++) {
                if (campos.get(i).getTipo().equals("boolean")) {
                    st += "true, ";
                } else if (campos.get(i).getTipo().equals("long") || campos.get(i).getTipo().equals("int")) {
                    st += "0, ";
                } else if (campos.get(i).getTipo().equals("double")) {
                    st += "0.0, ";
                } else {
                    st += "\"\", ";
                }
            }
            if (campos.get(campos.size() - 1).getTipo().equals("boolean")) {
                st += "true));\n";
            } else if (campos.get(campos.size() - 1).getTipo().equals("long") || campos.get(campos.size() - 1).getTipo().equals("int")) {
                st += "0));\n";
            } else if (campos.get(campos.size() - 1).getTipo().equals("double")) {
                st += "0.0));\n";
            } else {
                st += "\"\"));\n";
            }

            st += "                    //aqui muda f\n"
                    + "                }\n"
                    + "                cancelar.doClick();\n"
                    + "            }\n"
                    + "        });\n"
                    + "\n"
                    + "/*------------------------------------------AQUI----------------------------------------------------*/\n"
                    + "        limagem.addMouseListener(new MouseAdapter() {\n"
                    + "            public void mouseReleased(MouseEvent e) {\n"
                    + "                JFileChooser fc = new JFileChooser();\n"
                    + "                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);\n"
                    + "                if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {\n"
                    + "                    File img = fc.getSelectedFile();\n"
                    + "                    origem = fc.getSelectedFile().getAbsolutePath();\n"
                    + "                    try {\n"
                    + "                        ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());\n"
                    + "                        Image imagemAux;\n"
                    + "                        imagemAux = icone.getImage();\n"
                    + "                        icone.setImage(imagemAux.getScaledInstance(150, 150, Image.SCALE_FAST));\n"
                    + "                        limagem.setIcon(icone);\n"
                    + "\n"
                    + "                    } catch (Exception ex) {\n"
                    + "                        System.out.println(\"Erro: \" + ex.getMessage());\n"
                    + "                    }\n"
                    + "                }\n"
                    + "\n"
                    + "            }\n"
                    + "\n"
                    + "        });\n"
                    + "\n"
                    + "        /*------------------------------------------AQUI----------------------------------------------------*/"
                    + "        setVisible(true);\n"
                    + "    }\n"
                    + "\n"
                    + "}\n"
                    + "";

            m.gerar("src/gerado/" + ajeita(dados.getNome()) + "GUI.java", st);

            String main = "/*\n"
                    + " * To change this license header, choose License Headers in Project Properties.\n"
                    + " * To change this template file, choose Tools | Templates\n"
                    + " * and open the template in the editor.\n"
                    + " */\n"
                    + "package gerado;\n"
                    + "\n"
                    + "public class Main {\n"
                    + "    public static void main(String[] args){\n"
                    + "        " + nc + "GUI p = new " + nc + "GUI();\n"
                    + "    }\n"
                    + "}";

            String cpimg = "package gerado;\n"
                    + "\n"
                    + "import java.io.FileInputStream;\n"
                    + "import java.io.FileNotFoundException;\n"
                    + "import java.io.FileOutputStream;\n"
                    + "import java.io.IOException;\n"
                    + "import java.io.InputStream;\n"
                    + "import java.io.OutputStream;\n"
                    + "\n"
                    + "/**\n"
                    + " *\n"
                    + " * @author radames\n"
                    + " */\n"
                    + "public class CopiaImagem {\n"
                    + "\n"
                    + "    public static void copiar(String origem, String destino) {\n"
                    + "        //System.out.println(\"Origem >\"+origem+ \" Destino >\"+destino);\n"
                    + "        try {\n"
                    + "            InputStream in;\n"
                    + "            in = new FileInputStream(origem);\n"
                    + "            OutputStream out;\n"
                    + "            byte[] buf = new byte[1024];\n"
                    + "            out = new FileOutputStream(destino);\n"
                    + "            int len;\n"
                    + "            try {\n"
                    + "                while ((len = in.read(buf)) > 0) {\n"
                    + "                    out.write(buf, 0, len);\n"
                    + "                }\n"
                    + "            } catch (IOException ex) {\n"
                    + "                System.out.println(\"Erro na cópia\");\n"
                    + "            }\n"
                    + "            try {\n"
                    + "                in.close();\n"
                    + "                out.close();\n"
                    + "            } catch (IOException ex) {\n"
                    + "                System.out.println(\"Erro na cópia\");\n"
                    + "            }\n"
                    + "        } catch (FileNotFoundException ex) {\n"
                    + "            System.out.println(\"Erro na cópia - arquivo não encontrado\");\n"
                    + "        }\n"
                    + "    }\n"
                    + "}\n"
                    + "";

            m.gerar("src/gerado/Main.java", main);

            m.gerar("src/gerado/CopiaImagem.java", cpimg);

        } catch (Exception g) {
            g.printStackTrace();
            System.out.println(g.getLocalizedMessage());
        }

    }

    public void setDados(Dados dados) throws IOException {
        this.dados = dados;
        gerar();
    }
}

package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class GUI extends JDialog {
    
    Container cp;
    
    Controle con = new Controle();

    //Imagens
    URL urladd = getClass().getResource("imagens/adicionar.png");
    ImageIcon ad = new ImageIcon(urladd);
    
    URL urlir = getClass().getResource("imagens/ir.png");
    ImageIcon ir = new ImageIcon(urlir);
    
    URL urlexc = getClass().getResource("imagens/excluir.png");
    ImageIcon exc = new ImageIcon(urlexc);
    
    URL urlfechar = getClass().getResource("imagens/fechar.png");
    ImageIcon cl = new ImageIcon(urlfechar);
    
    URL urlsl = getClass().getResource("imagens/salvar.png");
    ImageIcon sl = new ImageIcon(urlsl);
    
    URL urlli = getClass().getResource("imagens/listar.png");
    ImageIcon li = new ImageIcon(urlli);
    
    URL urlperg = getClass().getResource("imagens/pergunta.png");
    ImageIcon pergunta = new ImageIcon(urlperg);
    
    URL urlalert = getClass().getResource("imagens/alerta.png");
    ImageIcon alerta = new ImageIcon(urlalert);
    
    URL urlok = getClass().getResource("imagens/ok.png");
    ImageIcon ok = new ImageIcon(urlok);
    
    URL urledit = getClass().getResource("imagens/edit.png");
    ImageIcon edit = new ImageIcon(urledit);
    
    URL urlimcont = getClass().getResource("imagens/imcont.png");
    ImageIcon imcont = new ImageIcon(urlimcont);
    
    URL urlimgui = getClass().getResource("imagens/imgui.png");
    ImageIcon imgui = new ImageIcon(urlimgui);
    
    URL urliment = getClass().getResource("imagens/iment.png");
    ImageIcon iment = new ImageIcon(urliment);
    
    URL urlimdados = getClass().getResource("imagens/imdados.png");
    ImageIcon imdados = new ImageIcon(urlimdados);
    
    URL urlimpk = getClass().getResource("imagens/key.png");
    ImageIcon impk = new ImageIcon(urlimpk);

    //Combos
    JComboBox combo = new JComboBox(con.retorno_combo());
    
    String[] stipos = con.retorno_combinho();
    
    JComboBox tipos = new JComboBox(stipos);

    //variaveis globais
    Dados dados = new Dados();

    //tabelas
    JTable table = new JTable();
    DefaultTableModel mtable = new DefaultTableModel();

    //Labels
    JLabel lbuscar = new JLabel("Selecionar");
    JLabel avisos = new JLabel("Avisos");
    JLabel erros = new JLabel("Escolha uma tabela da lista.");
    
    JLabel lnome = new JLabel("Nome: ");

    //TextFields
    JTextField tdados = new JTextField(48);
    
    JTextField tnome = new JTextField(18);
    JTextField ta = new JTextField(10);
    JTextField tb = new JTextField(10);

    //Botões    
    JButton salvar = new JButton(sl); //C
    JButton buscar = new JButton(ir); //C
    JButton update = new JButton(sl); //U
    JButton excluir = new JButton(exc); //D

    JButton cancelar = new JButton(cl);
    JButton listar = new JButton(li);
    
    JButton b_gui = new JButton(imgui);
    JButton b_controle = new JButton(imcont);
    JButton b_entidade = new JButton(iment);
    JButton b_banco = new JButton(imdados);

    //para  parte interna
    JButton blin_nova = new JButton(ad);
    JButton blin_excluir = new JButton(exc);
    JButton blin_update = new JButton(sl);
    JButton blin_cancelar = new JButton(cl);
    JButton blin_editar = new JButton(edit);
    JButton blin_chave = new JButton(impk);
    
    JButton bdad_novo = new JButton(ad);
    JButton bdad_excluir = new JButton(exc);
    JButton bdad_salvar = new JButton(sl);
    JButton bdad_update = new JButton(sl);
    JButton bdad_cancelar = new JButton(cl);

    //Paineis
    JPanel norte = new JPanel();
    JPanel centro = new JPanel();
    JPanel sul = new JPanel();
    
    JPanel centro_norte = new JPanel();
    JPanel centro_norte_1 = new JPanel();
    JPanel centro_norte_2 = new JPanel();

    //Fontes
    Font f = new Font("Consolas", Font.PLAIN, 24);
    
    public GUI() throws SQLException {
        
        setSize(833, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Gerador de Códigos");
        
        norte.setLayout(new FlowLayout());
        norte.add(lbuscar).setFont(f);
        norte.add(combo).setFont(f);
        norte.add(buscar);
        norte.add(bdad_novo);
        norte.add(listar);

        //combo de busca
        bdad_novo.setBorder(null);
        bdad_novo.setBackground(Color.white);
        bdad_novo.setPreferredSize(new Dimension(30, 30));
        salvar.setBorder(null);
        salvar.setBackground(Color.white);
        salvar.setPreferredSize(new Dimension(30, 30));
        listar.setBorder(null);
        listar.setBackground(Color.white);
        listar.setPreferredSize(new Dimension(30, 30));
        
        buscar.setBorder(null);
        buscar.setBackground(Color.white);
        buscar.setPreferredSize(new Dimension(30, 30));
        update.setBorder(null);
        update.setBackground(Color.white);
        update.setPreferredSize(new Dimension(30, 30));
        cancelar.setBorder(null);
        cancelar.setBackground(Color.white);
        cancelar.setPreferredSize(new Dimension(30, 30));
        excluir.setBorder(null);
        excluir.setBackground(Color.white);
        excluir.setPreferredSize(new Dimension(30, 30));
        bdad_novo.setBorder(null);
        bdad_novo.setBackground(Color.white);
        bdad_novo.setPreferredSize(new Dimension(30, 30));
        bdad_excluir.setBorder(null);
        bdad_excluir.setBackground(Color.white);
        bdad_excluir.setPreferredSize(new Dimension(30, 30));
        bdad_cancelar.setBorder(null);
        bdad_cancelar.setBackground(Color.white);
        bdad_cancelar.setPreferredSize(new Dimension(30, 30));
        bdad_update.setBorder(null);
        bdad_update.setBackground(Color.white);
        bdad_update.setPreferredSize(new Dimension(30, 30));
        blin_nova.setBorder(null);
        blin_nova.setBackground(Color.white);
        blin_nova.setPreferredSize(new Dimension(30, 30));
        bdad_salvar.setBorder(null);
        bdad_salvar.setBackground(Color.white);
        bdad_salvar.setPreferredSize(new Dimension(30, 30));
        blin_excluir.setBorder(null);
        blin_excluir.setBackground(Color.white);
        blin_excluir.setPreferredSize(new Dimension(30, 30));
        blin_cancelar.setBorder(null);
        blin_cancelar.setBackground(Color.white);
        blin_cancelar.setPreferredSize(new Dimension(30, 30));
        blin_editar.setBorder(null);
        blin_editar.setBackground(Color.white);
        blin_editar.setPreferredSize(new Dimension(30, 30));
        blin_chave.setBorder(null);
        blin_chave.setBackground(Color.white);
        blin_chave.setPreferredSize(new Dimension(30, 30));
        b_controle.setBorder(null);
        b_controle.setBackground(Color.white);
        b_controle.setPreferredSize(new Dimension(30, 30));
        b_gui.setBorder(null);
        b_gui.setBackground(Color.white);
        b_gui.setPreferredSize(new Dimension(30, 30));
        b_entidade.setBorder(null);
        b_entidade.setBackground(Color.white);
        b_entidade.setPreferredSize(new Dimension(30, 30));
        b_banco.setBorder(null);
        b_banco.setBackground(Color.white);
        b_banco.setPreferredSize(new Dimension(30, 30));
        
        combo.setBackground(Color.white);
        
        tdados.setFont(f);
        lnome.setFont(f);
        tdados.setFont(f);
        tnome.setFont(f);
        ta.setFont(f);
        tb.setFont(f);
        tipos.setBackground(Color.WHITE);
        tipos.setFont(f);
        
        centro.setBackground(Color.white);
        centro_norte.setBackground(Color.white);
        centro_norte_1.setBackground(Color.white);
        centro_norte_2.setBackground(Color.white);
        
        sul.setBackground(Color.white);
        norte.setBackground(Color.white);
        cp.setBackground(Color.white);
        
        sul.setLayout(new FlowLayout(FlowLayout.RIGHT));
        sul.add(b_gui);
        sul.add(b_controle);
        sul.add(b_entidade);
        sul.add(b_banco);
        
        cp.add(norte, BorderLayout.NORTH);
        cp.add(centro, BorderLayout.CENTER);
        cp.add(sul, BorderLayout.SOUTH);

        //Ações dos botões aqui
        buscar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try {
                    centro.removeAll();
                    centro_norte.removeAll();
                    centro_norte_1.removeAll();
                    centro_norte_2.removeAll();
                    
                    centro.setLayout(new BorderLayout());
                    
                    centro_norte_1.setLayout(new FlowLayout(FlowLayout.CENTER));
                    centro_norte_2.setLayout(new FlowLayout(FlowLayout.CENTER));
                    
                    centro_norte.setLayout(new BorderLayout());
                    centro_norte.add(centro_norte_1, BorderLayout.NORTH);
                    centro_norte.add(centro_norte_2, BorderLayout.SOUTH);
                    
                    tdados.setColumns(48);
                    centro_norte_1.add(lnome);
                    centro_norte_1.add(tdados);
                    centro_norte_1.add(bdad_update);
                    centro_norte_1.add(bdad_excluir);
                    centro_norte_1.add(bdad_cancelar);
                    
                    centro_norte_2.add(tnome);
                    centro_norte_2.add(tipos);
                    centro_norte_2.add(ta);
                    centro_norte_2.add(tb);
                    centro_norte_2.add(blin_nova);
                    centro_norte_2.add(blin_excluir);
                    centro_norte_2.add(blin_editar);
                    centro_norte_2.add(blin_chave);
                    centro_norte_2.add(blin_cancelar);
                    
                    blin_cancelar.doClick();
                    
                    if (combo.getSelectedIndex() == 0) {
                        cancelar.doClick();
                        int o = 0 / 0;
                    }
                    
                    dados = con.read(new Dados(Integer.valueOf(combo.getSelectedItem().toString().substring(38, 42)), null, null));
                    
                    tdados.setText(dados.getNome());
                    
                    ArrayList<Campo> campos = dados.getCampos();
                    Object[] col = new Object[]{"Nome", "Tipo", "Opção A", "Opção B"};
                    
                    Object[][] valores = new Object[campos.size()][col.length];

                    //arrumando a inibição da edição das células
                    table.setFont(new Font("Arial", Font.PLAIN, 16));
                    JScrollPane scrollPane = new JScrollPane(table);
                    //</nem relar>

                    for (int i = 0; i < campos.size(); i++) {
                        valores[i][0] = campos.get(i).getNome();
                        valores[i][1] = campos.get(i).getTipo();
                        valores[i][2] = campos.get(i).getA();
                        valores[i][3] = campos.get(i).getB();
                    }
                    
                    mtable = new DefaultTableModel(valores, col);
                    table.setModel(mtable);
                    
                    table.setRowHeight(30);
                    //table.setEnabled(false);

                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    
                    centro.add(centro_norte, BorderLayout.NORTH);
                    centro.add(scrollPane, BorderLayout.CENTER);
                    centro.revalidate();
                    centro.repaint();
                    
                } catch (Exception h) {
                }
            }
        });
        
        tipos.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        if (tipos.getSelectedIndex() != 0) {
                            ta.setEnabled(false);
                            tb.setEnabled(false);
                            ta.setText("");
                            tb.setText("");
                        } else {
                            ta.setEnabled(true);
                            tb.setEnabled(true);
                        }
                    }
                }
        );
        
        blin_cancelar.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        tipos.setSelectedIndex(0);
                        tnome.setText("");
                        ta.setText("");
                        tb.setText("");
                    }
                }
        );
        
        blin_excluir.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        int ind = table.getSelectedRow();
                        if (ind != -1) {
                            mtable.removeRow(ind);
                        } else {
                            JOptionPane.showMessageDialog(null, "Selecione uma linha!", "Ops!", 0, alerta);
                        }
                    }
                }
        );
        
        blin_nova.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        String erro = "";
                        
                        try {
                            if (tnome.getText().equals("")) {
                                erro = "a";
                                int x = 0 / 0;
                            }
                            if (stipos[tipos.getSelectedIndex()].equals("boolean")) {
                                if (ta.getText().equals("") || tb.getText().equals("")) {
                                    int opcao = JOptionPane.showConfirmDialog(null, "Você não inseriu as opções para o boolean, \nAssim não dá para construir um RadioButton, \npode ser um CheckBox na GUI?", "Eita,", JOptionPane.YES_NO_OPTION, 0, pergunta);
                                    if (opcao == 1) {
                                        int t = 0 / 0;
                                    }
                                } else if (ta.getText().equals(tb.getText()) && !ta.getText().equals("")) {
                                    erro = "c";
                                    int t = 0 / 0;
                                }
                            }
                            Campo c = new Campo();
                            c.setNome(tnome.getText());
                            c.setTipo(stipos[tipos.getSelectedIndex()]);
                            c.setId(WIDTH);
                            c.setA(ta.getText());
                            c.setB(tb.getText());
                            c.setId_dados(dados.getId());
                            
                            mtable.addRow(new String[]{c.getNome(), c.getTipo(), c.getA(), c.getB()});
                        } catch (Exception e) {
                            if (erro.equals("a")) {
                                JOptionPane.showMessageDialog(null, "Insira um nome para o atributo!", "Ops!", 0, alerta);
                            }
                            if (erro.equals("c")) {
                                JOptionPane.showMessageDialog(null, "Os nomes das opções são iguais!", "Ops!", 0, alerta);
                            }
                        }
                        
                    }
                }
        );
        
        blin_editar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    
                    int i = table.getSelectedRow();
                    if (i != -1) {
                        
                        ArrayList<Campo> campos = new ArrayList<>();
                        
                        tnome.setText((String) table.getModel().getValueAt(i, 0));
                        tipos.setSelectedIndex(con.retorna_posicao_tipos((String) table.getModel().getValueAt(i, 1)));
                        ta.setText((String) table.getModel().getValueAt(i, 2));
                        tb.setText((String) table.getModel().getValueAt(i, 3));
                        
                        blin_excluir.doClick();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione uma linha!", "Ops!", 0, alerta);
                    }
                    
                } catch (Exception e) {
                }
            }
            
        }
        );
        
        bdad_update.addActionListener(
                new ActionListener() { // aqui é botão salvar

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        String erro = "";
                        try {
                            
                            if (tdados.getText().equals("")) {
                                erro = "a";
                                int x = 0 / 0;
                            }
                            
                            Dados d = new Dados();
                            
                            d.setNome(tdados.getText());
                            
                            ArrayList<Campo> campos = new ArrayList<>();
                            
                            for (int i = 0; i < mtable.getRowCount(); i++) {
                                Campo c = new Campo();
                                c.setNome((String) table.getModel().getValueAt(i, 0));
                                c.setId_dados(d.getId());
                                c.setTipo((String) table.getModel().getValueAt(i, 1));
                                c.setA((String) table.getModel().getValueAt(i, 2));
                                c.setB((String) table.getModel().getValueAt(i, 3));
                                campos.add(c);
                            }
                            
                            d.setCampos(campos);
                            
                            con.update(dados, d);
                            
                            JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Eba!", 0, alerta);
                            
                            String[] itens = con.retorno_combo();
                            
                            combo = new JComboBox();
                            combo.setBackground(Color.white);
                            
                            for (int i = 0; i < itens.length; i++) {
                                combo.addItem(itens[i]);
                            }
                            
                            combo.repaint();
                            cp.repaint();
                            cancelar.doClick();
                            
                        } catch (Exception f) {
                            JOptionPane.showMessageDialog(null, "Adicione um nome para a entidade!", "Ops!", 0, alerta);
                            
                        }
                    }
                }
        );
        
        cancelar.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        centro.removeAll();
                        norte.removeAll();
                        norte.setLayout(new FlowLayout());
                        norte.add(lbuscar).setFont(f);
                        norte.add(combo).setFont(f);
                        norte.add(buscar);
                        norte.add(bdad_novo);
                        norte.add(listar);
                        norte.repaint();
                        centro.repaint();
                    }
                }
        );
        
        bdad_excluir.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        try {
                            
                            Dados d = new Dados();
                            
                            String nome = combo.getSelectedItem().toString();
                            int id = Integer.valueOf(nome.substring(38, 42));
                            nome = nome.substring(0, 36);
                            
                            d.setId(id);
                            
                            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente eliminar\n" + nome + " ?", "E então,", JOptionPane.YES_NO_OPTION, 0, pergunta);
                            if (opcao == 0) {
                                con.delete(d);
                            }
                            
                            String[] itens = con.retorno_combo();
                            
                            combo = new JComboBox();
                            combo.setBackground(Color.white);
                            
                            for (int i = 0; i < itens.length; i++) {
                                combo.addItem(itens[i]);
                            }
                            
                            combo.repaint();
                            cp.repaint();
                            cancelar.doClick();
                            
                        } catch (Exception f) {
                            JOptionPane.showMessageDialog(null, "Não foi possível excluir!", "Ops!", 0, alerta);
                            
                        }
                    }
                }
        );
        
        bdad_novo.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        
                        combo.setSelectedIndex(0);
                        tdados.setText("");
                        
                        centro.removeAll();
                        centro_norte.removeAll();
                        centro_norte_1.removeAll();
                        centro_norte_2.removeAll();
                        
                        centro.setLayout(new BorderLayout());
                        centro_norte.setLayout(new BorderLayout());
                        centro_norte_1.setLayout(new FlowLayout(FlowLayout.CENTER));
                        centro_norte_2.setLayout(new FlowLayout(FlowLayout.CENTER));
                        
                        centro_norte.add(centro_norte_1, BorderLayout.NORTH);
                        centro_norte.add(centro_norte_2, BorderLayout.SOUTH);
                        
                        tdados.setColumns(50);
                        centro_norte_1.add(lnome);
                        centro_norte_1.add(tdados);
                        centro_norte_1.add(bdad_salvar);
                        centro_norte_1.add(bdad_cancelar);
                        
                        centro_norte_2.add(tnome);
                        centro_norte_2.add(tipos);
                        centro_norte_2.add(ta);
                        centro_norte_2.add(tb);
                        centro_norte_2.add(blin_nova);
                        centro_norte_2.add(blin_excluir);
                        centro_norte_2.add(blin_editar);
                        centro_norte_2.add(blin_chave);
                        centro_norte_2.add(blin_cancelar);
                        
                        blin_cancelar.doClick();

                        //<nem relar>
                        Object[] col = new Object[]{"Nome", "Tipo", "Opção A", "Opção B"};
                        
                        Object[][] valores = new Object[0][col.length];

                        //arrumando a inibição da edição das células
                        table.setFont(new Font("Arial", Font.PLAIN, 16));
                        JScrollPane scrollPane = new JScrollPane(table);
                        
                        mtable = new DefaultTableModel(valores, col);
                        table.setModel(mtable);
                        
                        table.setRowHeight(30);
                        //table.setEnabled(false);

                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        
                        centro.add(centro_norte, BorderLayout.NORTH);
                        centro.add(scrollPane, BorderLayout.CENTER);

                        //aqui muda
                        erros.setForeground(Color.BLUE);
                        erros.setFont(new Font("Consolas", Font.ITALIC, 16));
                        erros.setText("Verifique todos os dados listados!");
                        
                        centro.repaint();
                        centro.revalidate();
                        norte.repaint();
                        
                    }
                }
        );
        
        bdad_salvar.addActionListener(
                new ActionListener() { // aqui é botão salvar

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        String erro = "";
                        try {
                            
                            if (tdados.getText().equals("")) {
                                erro = "a";
                                int x = 0 / 0;
                            }
                            
                            Dados d = new Dados();
                            
                            d.setNome(tdados.getText());
                            
                            ArrayList<Campo> campos = new ArrayList<>();
                            
                            for (int i = 0; i < mtable.getRowCount(); i++) {
                                Campo c = new Campo();
                                c.setNome((String) table.getModel().getValueAt(i, 0));
                                c.setId_dados(d.getId());
                                c.setTipo((String) table.getModel().getValueAt(i, 1));
                                c.setA((String) table.getModel().getValueAt(i, 2));
                                c.setB((String) table.getModel().getValueAt(i, 3));
                                campos.add(c);
                            }
                            
                            d.setCampos(campos);
                            
                            con.create(d);
                            
                            JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Eba!", 0, alerta);
                            
                            String[] itens = con.retorno_combo();
                            
                            combo = new JComboBox();
                            combo.setBackground(Color.white);
                            
                            for (int i = 0; i < itens.length; i++) {
                                combo.addItem(itens[i]);
                            }
                            
                            combo.repaint();
                            cp.repaint();
                            cancelar.doClick();
                            
                        } catch (Exception f) {
                            JOptionPane.showMessageDialog(null, "Adicione um nome para a entidade!", "Ops!", 0, alerta);
                            
                        }
                    }
                }
        );
        
        bdad_cancelar.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        centro.removeAll();
                        combo.setSelectedIndex(0);
                        cp.repaint();;
                    }
                }
        );
        
        listar.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        try {
                            ArrayList<Dados> ds = con.listar();
                            Object[] col = new Object[]{"Identificação", "Nome"};
                            
                            Object[][] valores = new Object[ds.size()][col.length];
                            
                            for (int i = 0; i < ds.size(); i++) {
                                valores[i][0] = con.esp(4 - (ds.get(i).getId() + "").length(), "") + ds.get(i).getId();
                                valores[i][1] = ds.get(i).getNome();
                            }
                            //aqui muda f

                            JTable table = new JTable(valores, col);
                            
                            table.setFont(new Font("Arial", Font.PLAIN, 16));
                            table.setRowHeight(30);
                            table.setEnabled(false);
                            
                            JScrollPane scrollPane = new JScrollPane(table);
                            
                            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                            
                            centro.removeAll();
                            centro.setLayout(new GridLayout(1, 1));
                            centro.add(scrollPane);
                            
                            centro.revalidate();
                            centro.repaint();
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        );
        
        b_gui.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        dados = con.read(new Dados(Integer.valueOf(combo.getSelectedItem().toString().substring(38, 42)), null, null));
                        try {
                            if (combo.getSelectedIndex() == 0) {
                                JOptionPane.showMessageDialog(null, "Selecione um item da lista!", "Ops!", 0, alerta);
                                int y = 0 / 0;
                            }
                            dados = con.read(new Dados(Integer.valueOf(combo.getSelectedItem().toString().substring(38, 42)), null, null));
                            GeraGUI gera_gui = new GeraGUI();
                            gera_gui.setDados(dados);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "A classe GUI não foi criada!", "Ops!", 0, alerta);
                        }
                        
                    }
                }
        );
        
        b_controle.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        dados = con.read(new Dados(Integer.valueOf(combo.getSelectedItem().toString().substring(38, 42)), null, null));
                        try {
                            if (combo.getSelectedIndex() == 0) {
                                JOptionPane.showMessageDialog(null, "Selecione um item da lista!", "Ops!", 0, alerta);
                                int y = 0 / 0;
                            }
                            dados = con.read(new Dados(Integer.valueOf(combo.getSelectedItem().toString().substring(38, 42)), null, null));
                            GerarControle gera = new GerarControle();
                            gera.setDados(dados);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "A classe controle não foi criada!", "Ops!", 0, alerta);
                        }
                    }
                }
        );
        
        b_entidade.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        try {
                            if (combo.getSelectedIndex() == 0) {
                                JOptionPane.showMessageDialog(null, "Selecione um item da lista!", "Ops!", 0, alerta);
                                int y = 0 / 0;
                            }
                            dados = con.read(new Dados(Integer.valueOf(combo.getSelectedItem().toString().substring(38, 42)), null, null));
                            GeraEntidade gera_entidade = new GeraEntidade();
                            gera_entidade.setDados(dados);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "A classe entidade não foi criada!", "Ops!", 0, alerta);
                        }
                    }
                }
        );
        
        b_banco.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        
                        try {
                            dados = con.read(new Dados(Integer.valueOf(combo.getSelectedItem().toString().substring(38, 42)), null, null));
                            String dp = "DROP TABLE IF EXISTS " + dados.getNome() + dados.getId() + ";\n\n";
                            String comando = "CREATE TABLE " + dados.getNome() + dados.getId() + "(\n";
                            for (int i = 0; i < dados.getCampos().size() - 1; i++) {
                                comando += "    " + dados.getCampos().get(i).getNome() + " TEXT,\n";
                            }
                            comando += "    " + dados.getCampos().get(dados.getCampos().size() - 1).getNome() + " TEXT\n);";
                            int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo criar base de dados para\n" + dados.getNome() + " ?", "E então,", JOptionPane.YES_NO_OPTION, 0, pergunta);
                            boolean b = false;
                            if (opcao == 0) {
                                con.enviar(dp);
                                b = con.enviar(comando);
                            }
                            if (!b) {
                                int l = 0 / 0;
                            };
                        } catch (Exception g) {
                            JOptionPane.showMessageDialog(null, "A base de dados não foi criada!", "Ops!", 0, alerta);
                        }
                    }
                }
        );
        
        setVisible(true);
        
    }
    
}

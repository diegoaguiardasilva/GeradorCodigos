/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Main.GeraEntidade.ajeita;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class GerarControle {

    private Dados dados;

    public void gera() throws IOException {

        ManipulaTxt m = new ManipulaTxt();

        String nc = ajeita(dados.getNome());

        ArrayList<Campo> campos = dados.getCampos();

        String st = "";

        st += "package gerado;\n"
                + "\n"
                + "import java.sql.Connection;\n"
                + "import java.sql.DriverManager;\n"
                + "import java.sql.ResultSet;\n"
                + "import java.sql.SQLException;\n"
                + "import java.sql.ResultSetMetaData;\n"
                + "import java.util.ArrayList;\n"
                + "\n"
                + "public class " + nc + "Controle {\n"
                + "    \n"
                + "    //Funções do CRUD + Listar \n"
                + "\n"
                + "\n"
                + "    public void create(" + nc + "Entidade ent) {\n"
                + "        //mudar a\n"
                + "        String comando = \"INSERT INTO " + dados.getNome() + dados.getId() + " (";
        for (int i = 0; i < campos.size() - 1; i++) {
            st += campos.get(i).getNome() + ", ";
        }
        st += campos.get(campos.size() - 1).getNome() + ") VALUES ( '\"";

        for (int i = 0; i < campos.size() - 1; i++) {
            if (campos.get(i).getTipo().equalsIgnoreCase("boolean")) {
                st += "+ ent.is" + ajeita(campos.get(i).getNome()) + "() + \"', '\"";
            } else {
                st += "+ ent.get" + ajeita(campos.get(i).getNome()) + "() + \"', '\"";
            }
        }

        if (campos.get(campos.size() - 1).getTipo().equalsIgnoreCase("boolean")) {
            st += "+ ent.is" + ajeita(campos.get(campos.size() - 1).getNome()) + "()  + \"');\";\n";
        } else if (!(campos.get(campos.size() - 1).getTipo().equalsIgnoreCase("boolean"))) {
            st += "+ ent.get" + ajeita(campos.get(campos.size() - 1).getNome()) + "() + \"');\";\n";
        }
        //st += " + ent.get" + ajeita(campos.get(campos.size() - 1).getNome()) + "() + \");\";\n";
        st += "        enviar(comando);\n"
                + "    }\n"
                + "    \n"
                + "    \n"
                + "    public " + nc + "Entidade read(" + nc + "Entidade ent) throws SQLException {\n"
                + "        \n"
                + "        //mudar a\n"
                + "        String comando = \"SELECT * FROM " + dados.getNome() + dados.getId() + " WHERE " + campos.get(0).getNome() + " = '\" + ent.get" + ajeita(campos.get(0).getNome()) + "() + \"' ;\";\n"
                + "        " + nc + "Entidade a = retorno(comando);\n"
                + "        \n";
        if (campos.get(0).getTipo().equals("String") || campos.get(0).getTipo().equals("Date") || campos.get(0).getTipo().equals("String")) {
            st += "        if (a.get" + ajeita(campos.get(0).getNome()) + "().equals(ent.get" + ajeita(campos.get(0).getNome()) + "())) {";
        } else {
            st += "        if (a.get" + ajeita(campos.get(0).getNome()) + "() == ent.get" + ajeita(campos.get(0).getNome()) + "()) {\n";
        }
        st += "            return a;\n"
                + "        //mudar f\n"
                + "        } else {\n"
                + "            return null;\n"
                + "        }\n"
                + "\n"
                + "    }\n"
                + "\n"
                + "    public void update(" + nc + "Entidade vel, " + nc + "Entidade nov) {\n"
                + "        //mudar a\n"
                + "        String comando = \"UPDATE " + dados.getNome() + dados.getId() + " SET " + campos.get(0).getNome() + " = '\" + nov.get" + ajeita(campos.get(0).getNome()) + "()";

        for (int i = 1; i < campos.size() - 1; i++) {
            if (campos.get(i).getTipo().equalsIgnoreCase("boolean")) {
                st += "+\"', " + campos.get(i).getNome() + " = '\"+";
                st += " nov.is" + ajeita(campos.get(i).getNome()) + "() ";
            } else if (!campos.get(i).getTipo().equalsIgnoreCase("boolean")) {
                st += "+\"', " + campos.get(i).getNome() + " = '\"+";
                st += " nov.get" + ajeita(campos.get(i).getNome()) + "() ";
            }
        }
        if (campos.get(campos.size() - 1).getTipo().equalsIgnoreCase("boolean")) {
            st += "+\"', " + campos.get(campos.size() - 1).getNome() + " = '\"+";
            st += " nov.is" + ajeita(campos.get(campos.size() - 1).getNome()) + "() ";
        } else if (!campos.get(campos.size() - 1).getTipo().equalsIgnoreCase("boolean")) {
            st += "+\"', " + campos.get(campos.size() - 1).getNome() + " = '\"+";
            st += " nov.get" + ajeita(campos.get(campos.size() - 1).getNome()) + "() ";
        }

        st += " + \"' WHERE " + campos.get(0).getNome() + " = '\" + vel.get" + ajeita(campos.get(0).getNome()) + "() + \"';\"; ";

        st += "        //mudar f\n"
                + "        enviar(comando);\n"
                + "    }\n"
                + "    \n"
                + "    public void delete(" + nc + "Entidade ent) {\n"
                + "        //mudar a\n"
                + "        String comando = \"DELETE FROM " + dados.getNome() + dados.getId() + " WHERE " + campos.get(0).getNome() + " = '\" + ent.get" + ajeita(campos.get(0).getNome()) + "() + \"';\";\n"
                + "        //mudar f\n"
                + "        enviar(comando);\n"
                + "    }\n"
                + "\n"
                + "\n"
                + "    public ArrayList<" + nc + "Entidade> listar() {\n"
                + "        try {\n"
                + "            //mudar a\n"
                + "            String comando = \"SELECT * FROM " + dados.getNome() + dados.getId() + " ORDER BY " + campos.get(0).getNome() + ";\";\n"
                + "            ArrayList<" + nc + "Entidade> ents = new ArrayList<" + nc + "Entidade>();\n"
                + "            //mudar f\n"
                + "            \n"
                + "            Connection con = DriverManager.getConnection(\"jdbc:mysql://localhost/db\", \"root\", \"\");\n"
                + "            \n"
                + "            java.sql.Statement stm = con.createStatement();\n"
                + "            ResultSet rs = stm.executeQuery(comando);\n"
                + "            \n"
                + "            while (rs.next()) {\n"
                + "                " + nc + "Entidade ent = new " + nc + "Entidade();\n";

        for (int i = 0; i < campos.size(); i++) {
            if ((!campos.get(i).getTipo().equalsIgnoreCase("String") && !campos.get(i).getTipo().equalsIgnoreCase("Double")
                    && !campos.get(i).getTipo().equalsIgnoreCase("boolean") && !campos.get(i).getTipo().equalsIgnoreCase("int")
                    && !campos.get(i).getTipo().equalsIgnoreCase("long")) || campos.get(i).getTipo().equalsIgnoreCase("Date")) {
                st += "                ent.set" + ajeita(campos.get(i).getNome()) + "(rs.getString(\"" + campos.get(i).getNome() + "\"));\n";
            } else {
                st += "                ent.set" + ajeita(campos.get(i).getNome()) + "(rs.get" + ajeita(campos.get(i).getTipo()) + "(\"" + campos.get(i).getNome() + "\"));\n";
            }
        }

        st += "ents.add(ent);\n"
                + "                //mudar f\n"
                + "            }\n"
                + "            stm.close();\n"
                + "            con.close();\n"
                + "            return ents;\n"
                + "\n"
                + "        } catch (Exception e) {\n"
                + "\n"
                + "            return null;\n"
                + "        }\n"
                + "    }\n"
                + "    \n"
                + "    \n"
                + "    // Acesso ao Banco de Dados \n"
                + "    \n"
                + "    public boolean enviar(String comando) {\n"
                + "        try {\n"
                + "            Connection con = DriverManager.getConnection(\"jdbc:mysql://localhost/db\", \"root\", \"\");\n"
                + "            java.sql.Statement stm = con.createStatement();\n"
                + "            stm.execute(comando);\n"
                + "            stm.close();\n"
                + "            con.close();\n"
                + "            return true;\n"
                + "        } catch (Exception e) {\n"
                + "            return false;\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + "    public " + nc + "Entidade retorno(String comando) {\n"
                + "        try {\n"
                + "            //mudar a\n"
                + "            " + nc + "Entidade ent = new " + nc + "Entidade();\n"
                + "            //mudar f\n"
                + "            Connection con = DriverManager.getConnection(\"jdbc:mysql://localhost/db\", \"root\", \"\");\n"
                + "            java.sql.Statement stm = con.createStatement();\n"
                + "            ResultSet rs = stm.executeQuery(comando);\n"
                + "            while (rs.next()) {\n"
                + "                //mudar a\n";
        for (int i = 0;
                i < campos.size();
                i++) {
            if ((!campos.get(i).getTipo().equalsIgnoreCase("String") && !campos.get(i).getTipo().equalsIgnoreCase("Double")
                    && !campos.get(i).getTipo().equalsIgnoreCase("boolean") && !campos.get(i).getTipo().equalsIgnoreCase("int")
                    && !campos.get(i).getTipo().equalsIgnoreCase("long")) || campos.get(i).getTipo().equalsIgnoreCase("Date")) {
                st += "                ent.set" + ajeita(campos.get(i).getNome()) + "(rs.getString(\"" + campos.get(i).getNome() + "\"));\n";
            } else {
                st += "                ent.set" + ajeita(campos.get(i).getNome()) + "(rs.get" + ajeita(campos.get(i).getTipo()) + "(\"" + campos.get(i).getNome() + "\"));\n";
            }
        }

        st += "                //mudar f\n"
                + "            }\n"
                + "            stm.close();\n"
                + "            con.close();\n"
                + "            return ent;\n"
                + "\n"
                + "        } catch (Exception e) {\n"
                + "            return null;\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + " /*--------------------------------------AQUI----------------------------------------------*/\n"
                + "    \n"
                + "    public String[] busca_relacionamento(String nome) throws SQLException {\n"
                + "\n"
                + "        Connection con = DriverManager.getConnection(\"jdbc:mysql://localhost/db\", \"root\", \"\");\n"
                + "        java.sql.Statement stm = con.createStatement();\n"
                + "        ResultSet rs = stm.executeQuery(\"SELECT * FROM \" + nome + \";\");\n"
                + "\n"
                + "        String junta = \"\";\n"
                + "\n"
                + "        ResultSetMetaData rsmd = rs.getMetaData();\n"
                + "        int numColumns = rsmd.getColumnCount();\n"
                + "        \n"
                + "        System.out.println(numColumns);\n"
                + "\n"
                + "        while (rs.next()) {\n"
                + "            junta += \"[\"+ rs.getString(1) + \"] \";\n"
                + "            for (int i = 2; i <= numColumns; i++) {\n"
                + "                junta += rs.getString(i) + \" | \";\n"
                + "            }\n"
                + "            junta += \";\";\n"
                + "        }\n"
                + "        stm.close();\n"
                + "        con.close();\n"
                + "\n"
                + "        return junta.split(\";\");\n"
                + "    }\n"
                + "\n"
                + "    /*--------------------------------------AQUI----------------------------------------------*/"
                + "    //Outras Funções de Controle\n"
                + "    \n"
                + "    public String esp(int n) {\n"
                + "        String t = \"\";\n"
                + "        for (int i = 0; i < n; i++) {\n"
                + "            t += \" \";\n"
                + "        }\n"
                + "        return t;\n"
                + "    }\n"
                + "\n"
                + "}\n"
                + "";

        m.gerar("src/gerado/" + ajeita(dados.getNome()) + "Controle.java", st);

        String dtf = "package gerado;\n"
                + "\n"
                + "import java.awt.BorderLayout;\n"
                + "import java.awt.Color;\n"
                + "import java.awt.Cursor;\n"
                + "import java.awt.Dialog.ModalityType;\n"
                + "import java.awt.Dimension;\n"
                + "import java.awt.FlowLayout;\n"
                + "import java.awt.Font;\n"
                + "import java.awt.GridLayout;\n"
                + "import java.awt.Point;\n"
                + "import java.awt.Window;\n"
                + "import java.awt.event.ActionEvent;\n"
                + "import java.awt.event.ActionListener;\n"
                + "import java.awt.event.MouseAdapter;\n"
                + "import java.awt.event.MouseEvent;\n"
                + "import java.text.ParseException;\n"
                + "import java.text.SimpleDateFormat;\n"
                + "import java.util.Calendar;\n"
                + "import java.util.Date;\n"
                + "\n"
                + "import javax.swing.JButton;\n"
                + "import javax.swing.JDialog;\n"
                + "import javax.swing.JLabel;\n"
                + "import javax.swing.JPanel;\n"
                + "import javax.swing.JSpinner;\n"
                + "import javax.swing.JTextField;\n"
                + "import javax.swing.SpinnerNumberModel;\n"
                + "import javax.swing.SwingConstants;\n"
                + "import javax.swing.SwingUtilities;\n"
                + "import javax.swing.border.LineBorder;\n"
                + "import javax.swing.event.ChangeEvent;\n"
                + "import javax.swing.event.ChangeListener;\n"
                + "\n"
                + "public class DateTextField extends JTextField {\n"
                + "\n"
                + "    private static String DEFAULT_DATE_FORMAT = \"dd/MM/yyyy\";\n"
                + "    private static final int DIALOG_WIDTH = 200;\n"
                + "    private static final int DIALOG_HEIGHT = 200;\n"
                + "\n"
                + "    private SimpleDateFormat dateFormat;\n"
                + "    private DatePanel datePanel = null;\n"
                + "    private JDialog dateDialog = null;\n"
                + "\n"
                + "    public DateTextField() {\n"
                + "        this(new Date(\"01/01/2000\"));\n"
                + "    }\n"
                + "\n"
                + "    public DateTextField(String dateFormatPattern, Date date) {\n"
                + "        this(date);\n"
                + "        DEFAULT_DATE_FORMAT = dateFormatPattern;\n"
                + "    }\n"
                + "\n"
                + "    public DateTextField(Date date) {\n"
                + "        setDate(date);\n"
                + "        setEditable(false);\n"
                + "        setCursor(new Cursor(Cursor.HAND_CURSOR));\n"
                + "        addListeners();\n"
                + "    }\n"
                + "\n"
                + "    private void addListeners() {\n"
                + "        addMouseListener(new MouseAdapter() {\n"
                + "            public void mouseClicked(MouseEvent paramMouseEvent) {\n"
                + "                if (datePanel == null) {\n"
                + "                    datePanel = new DatePanel();\n"
                + "                }\n"
                + "                Point point = getLocationOnScreen();\n"
                + "                point.y = point.y + 30;\n"
                + "                showDateDialog(datePanel, point);\n"
                + "            }\n"
                + "        });\n"
                + "    }\n"
                + "\n"
                + "    private void showDateDialog(DatePanel dateChooser, Point position) {\n"
                + "        Window owner = (Window) SwingUtilities\n"
                + "                .getWindowAncestor(DateTextField.this);\n"
                + "        if (dateDialog == null || dateDialog.getOwner() != owner) {\n"
                + "            dateDialog = createDateDialog(owner, dateChooser);\n"
                + "        }\n"
                + "        dateDialog.setLocation(getAppropriateLocation(owner, position));\n"
                + "        dateDialog.setVisible(true);\n"
                + "    }\n"
                + "\n"
                + "    private JDialog createDateDialog(Window owner, JPanel contentPanel) {\n"
                + "        JDialog dialog = new JDialog(owner, \"Data Selecionada\", ModalityType.MODELESS);\n"
                + "        dialog.setUndecorated(true);\n"
                + "        dialog.getContentPane().add(contentPanel, BorderLayout.CENTER);\n"
                + "        dialog.pack();\n"
                + "        dialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);\n"
                + "        return dialog;\n"
                + "    }\n"
                + "\n"
                + "    private Point getAppropriateLocation(Window owner, Point position) {\n"
                + "        Point result = new Point(position);\n"
                + "        Point p = owner.getLocation();\n"
                + "        int offsetX = (position.x + DIALOG_WIDTH) - (p.x + owner.getWidth());\n"
                + "        int offsetY = (position.y + DIALOG_HEIGHT) - (p.y + owner.getHeight());\n"
                + "\n"
                + "        if (offsetX > 0) {\n"
                + "            result.x -= offsetX;\n"
                + "        }\n"
                + "\n"
                + "        if (offsetY > 0) {\n"
                + "            result.y -= offsetY;\n"
                + "        }\n"
                + "\n"
                + "        return result;\n"
                + "    }\n"
                + "\n"
                + "    private SimpleDateFormat getDefaultDateFormat() {\n"
                + "        if (dateFormat == null) {\n"
                + "            dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);\n"
                + "        }\n"
                + "        return dateFormat;\n"
                + "    }\n"
                + "\n"
                + "    public void setText(Date date) {\n"
                + "        setDate(date);\n"
                + "    }\n"
                + "\n"
                + "    public void setDate(Date date) {\n"
                + "        super.setText(getDefaultDateFormat().format(date));\n"
                + "    }\n"
                + "\n"
                + "    public Date getDate() {\n"
                + "        try {\n"
                + "            return getDefaultDateFormat().parse(getText());\n"
                + "        } catch (ParseException e) {\n"
                + "            return new Date();\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + "    private class DatePanel extends JPanel implements ChangeListener {\n"
                + "\n"
                + "        int startYear = 1900;\n"
                + "        int lastYear = 2050;\n"
                + "\n"
                + "        Color backGroundColor = Color.BLACK;\n"
                + "        Color palletTableColor = Color.WHITE;\n"
                + "        Color todayBackColor = Color.GRAY;\n"
                + "        Color weekFontColor = Color.BLACK;\n"
                + "        Color dateFontColor = Color.black;\n"
                + "        Color weekendFontColor = Color.DARK_GRAY;\n"
                + "\n"
                + "        Color controlLineColor = Color.GRAY;\n"
                + "        Color controlTextColor = Color.white;\n"
                + "\n"
                + "        JSpinner yearSpin;\n"
                + "        JSpinner monthSpin;\n"
                + "        JButton[][] daysButton = new JButton[6][7];\n"
                + "\n"
                + "        DatePanel() {\n"
                + "            setLayout(new BorderLayout());\n"
                + "            setBorder(new LineBorder(backGroundColor, 2));\n"
                + "            setBackground(backGroundColor);\n"
                + "\n"
                + "            JPanel topYearAndMonth = createYearAndMonthPanal();\n"
                + "            add(topYearAndMonth, BorderLayout.NORTH);\n"
                + "            JPanel centerWeekAndDay = createWeekAndDayPanal();\n"
                + "            add(centerWeekAndDay, BorderLayout.CENTER);\n"
                + "\n"
                + "            reflushWeekAndDay();\n"
                + "        }\n"
                + "\n"
                + "        private JPanel createYearAndMonthPanal() {\n"
                + "            Calendar cal = getCalendar();\n"
                + "            int currentYear = cal.get(Calendar.YEAR);\n"
                + "            int currentMonth = cal.get(Calendar.MONTH) + 1;\n"
                + "\n"
                + "            JPanel panel = new JPanel();\n"
                + "            panel.setLayout(new FlowLayout());\n"
                + "            panel.setBackground(controlLineColor);\n"
                + "\n"
                + "            yearSpin = new JSpinner(new SpinnerNumberModel(currentYear, startYear, lastYear, 1));\n"
                + "            yearSpin.setPreferredSize(new Dimension(56, 20));\n"
                + "            yearSpin.setName(\"Ano\");\n"
                + "            yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, \"####\"));\n"
                + "            yearSpin.addChangeListener(this);\n"
                + "\n"
                + "            JLabel yearLabel = new JLabel(\"Ano\");\n"
                + "            yearLabel.setForeground(controlTextColor);\n"
                + "            panel.add(yearLabel);\n"
                + "            panel.add(yearSpin);\n"
                + "\n"
                + "            monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));\n"
                + "            monthSpin.setPreferredSize(new Dimension(35, 20));\n"
                + "            monthSpin.setName(\"Mês\");\n"
                + "            monthSpin.addChangeListener(this);\n"
                + "\n"
                + "            JLabel monthLabel = new JLabel(\"Mês\");\n"
                + "            monthLabel.setForeground(controlTextColor);\n"
                + "            panel.add(monthLabel);\n"
                + "            panel.add(monthSpin);\n"
                + "            return panel;\n"
                + "        }\n"
                + "\n"
                + "        private JPanel createWeekAndDayPanal() {\n"
                + "            String colname[] = {\"D\", \"S\", \"T\", \"Q\", \"Q\", \"S\", \"S\"};\n"
                + "            JPanel panel = new JPanel();\n"
                + "            panel.setFont(new Font(\"Arial\", Font.PLAIN, 10));\n"
                + "            panel.setLayout(new GridLayout(7, 7));\n"
                + "            panel.setBackground(Color.white);\n"
                + "\n"
                + "            for (int i = 0; i < 7; i++) {\n"
                + "                JLabel cell = new JLabel(colname[i]);\n"
                + "                cell.setHorizontalAlignment(JLabel.RIGHT);\n"
                + "                if (i == 0 || i == 6) {\n"
                + "                    cell.setForeground(weekendFontColor);\n"
                + "                } else {\n"
                + "                    cell.setForeground(weekFontColor);\n"
                + "                }\n"
                + "                panel.add(cell);\n"
                + "            }\n"
                + "\n"
                + "            int actionCommandId = 0;\n"
                + "            for (int i = 0; i < 6; i++) {\n"
                + "                for (int j = 0; j < 7; j++) {\n"
                + "                    JButton numBtn = new JButton();\n"
                + "                    numBtn.setBorder(null);\n"
                + "                    numBtn.setHorizontalAlignment(SwingConstants.RIGHT);\n"
                + "                    numBtn.setActionCommand(String\n"
                + "                            .valueOf(actionCommandId));\n"
                + "                    numBtn.setBackground(palletTableColor);\n"
                + "                    numBtn.setForeground(dateFontColor);\n"
                + "                    numBtn.addActionListener(new ActionListener() {\n"
                + "                        public void actionPerformed(ActionEvent event) {\n"
                + "                            JButton source = (JButton) event.getSource();\n"
                + "                            if (source.getText().length() == 0) {\n"
                + "                                return;\n"
                + "                            }\n"
                + "                            dayColorUpdate(true);\n"
                + "                            source.setForeground(todayBackColor);\n"
                + "                            int newDay = Integer.parseInt(source.getText());\n"
                + "                            Calendar cal = getCalendar();\n"
                + "                            cal.set(Calendar.DAY_OF_MONTH, newDay);\n"
                + "                            setDate(cal.getTime());\n"
                + "\n"
                + "                            dateDialog.setVisible(false);\n"
                + "                        }\n"
                + "                    });\n"
                + "\n"
                + "                    if (j == 0 || j == 6) {\n"
                + "                        numBtn.setForeground(weekendFontColor);\n"
                + "                    } else {\n"
                + "                        numBtn.setForeground(dateFontColor);\n"
                + "                    }\n"
                + "                    daysButton[i][j] = numBtn;\n"
                + "                    panel.add(numBtn);\n"
                + "                    actionCommandId++;\n"
                + "                }\n"
                + "            }\n"
                + "\n"
                + "            return panel;\n"
                + "        }\n"
                + "\n"
                + "        private Calendar getCalendar() {\n"
                + "            Calendar calendar = Calendar.getInstance();\n"
                + "            calendar.setTime(getDate());\n"
                + "            return calendar;\n"
                + "        }\n"
                + "\n"
                + "        private int getSelectedYear() {\n"
                + "            return ((Integer) yearSpin.getValue()).intValue();\n"
                + "        }\n"
                + "\n"
                + "        private int getSelectedMonth() {\n"
                + "            return ((Integer) monthSpin.getValue()).intValue();\n"
                + "        }\n"
                + "\n"
                + "        private void dayColorUpdate(boolean isOldDay) {\n"
                + "            Calendar cal = getCalendar();\n"
                + "            int day = cal.get(Calendar.DAY_OF_MONTH);\n"
                + "            cal.set(Calendar.DAY_OF_MONTH, 1);\n"
                + "            int actionCommandId = day - 2 + cal.get(Calendar.DAY_OF_WEEK);\n"
                + "            int i = actionCommandId / 7;\n"
                + "            int j = actionCommandId % 7;\n"
                + "            if (isOldDay) {\n"
                + "                daysButton[i][j].setForeground(dateFontColor);\n"
                + "            } else {\n"
                + "                daysButton[i][j].setForeground(todayBackColor);\n"
                + "            }\n"
                + "        }\n"
                + "\n"
                + "        private void reflushWeekAndDay() {\n"
                + "            Calendar cal = getCalendar();\n"
                + "            cal.set(Calendar.DAY_OF_MONTH, 1);\n"
                + "            int maxDayNo = cal.getActualMaximum(Calendar.DAY_OF_MONTH);\n"
                + "            int dayNo = 2 - cal.get(Calendar.DAY_OF_WEEK);\n"
                + "            for (int i = 0; i < 6; i++) {\n"
                + "                for (int j = 0; j < 7; j++) {\n"
                + "                    String s = \"\";\n"
                + "                    if (dayNo >= 1 && dayNo <= maxDayNo) {\n"
                + "                        s = String.valueOf(dayNo);\n"
                + "                    }\n"
                + "                    daysButton[i][j].setText(s);\n"
                + "                    dayNo++;\n"
                + "                }\n"
                + "            }\n"
                + "            dayColorUpdate(false);\n"
                + "        }\n"
                + "\n"
                + "        public void stateChanged(ChangeEvent e) {\n"
                + "            dayColorUpdate(true);\n"
                + "\n"
                + "            JSpinner source = (JSpinner) e.getSource();\n"
                + "            Calendar cal = getCalendar();\n"
                + "            if (source.getName().equals(\"Ano\")) {\n"
                + "                cal.set(Calendar.YEAR, getSelectedYear());\n"
                + "            } else {\n"
                + "                cal.set(Calendar.MONTH, getSelectedMonth() - 1);\n"
                + "            }\n"
                + "            setDate(cal.getTime());\n"
                + "            reflushWeekAndDay();\n"
                + "        }\n"
                + "    }\n"
                + "}\n"
                + "";

        m.gerar("src/gerado/DateTextField.java", dtf);
    }

    public void setDados(Dados dados) throws IOException {
        this.dados = dados;
        gera();
    }

}

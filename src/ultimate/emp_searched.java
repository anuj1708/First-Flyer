package ultimate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.sql.*;

public class emp_searched implements ActionListener {

    JFrame fr;
    JPanel frm, p2, p3;
    JLabel name, email, obj, edu, tech, project, quali, wexp, salary, field;
    Label name1, email1, quali1, wexp1, salary1, field1;
    JTextArea obj1, edu1, tech1, project1;
    JButton b1, b2, b3;
    Connection cont;
    public static ResultSet rs;
    public static String str1, str2, str3, str4;
    private JComboBox combo = new JComboBox();
    private JComboBox combo1 = new JComboBox();
    private JComboBox combo2 = new JComboBox();
    private JComboBox combo3 = new JComboBox();

    public emp_searched() throws Exception {
        

        fr = new JFrame();
        frm = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        fr.setVisible(true);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        fr.setSize(width, height);
       fr.setResizable(false);
        int a = (width / 2) + 50;

        JLabel l1 = new JLabel(new ImageIcon("header.png"));
        JLabel l2 = new JLabel(new ImageIcon("searcher.jpg"));
        name = new JLabel("Name");
        email = new JLabel("Email");
        obj = new JLabel("Objective");
        tech = new JLabel("Tech. Skills");
        project = new JLabel("Projects");
        quali = new JLabel("Qualification");
        wexp = new JLabel("Work Experience");
        salary = new JLabel("Salary");
        field = new JLabel("Field");

        name1 = new Label();
        email1 = new Label();
        quali1 = new Label();
        wexp1 = new Label();
        salary1 = new Label();
        field1 = new Label();
        obj1 = new JTextArea();
        tech1 = new JTextArea();
        project1 = new JTextArea();

        b1 = new JButton("Privious");
        b2 = new JButton("Next");
        b3 = new JButton("Home");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        obj1.setEditable(false);
        tech1.setEditable(false);
        project1.setEditable(false);


        frm.setLayout(null);
        frm.setBackground(Color.white);



        combo.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXX");
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(combo.getSelectedItem().toString());
            }
        });
        combo.addItem("SELECT NONE");
        combo.addItem("UNDER GRADUATE");
        combo.addItem("GRADUATE");
        combo.addItem("POST GRADUATE");
        combo.addItem("NOT A GRADUATE");


        combo1.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXX");
        combo1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(combo1.getSelectedItem().toString());
            }
        });
        combo1.addItem("SELECT NONE");
        combo1.addItem("MORE THEN 2 YEAR");
        combo1.addItem("1 TO 2 YEAR");
        combo1.addItem("LESS THEN A YEAR");
        combo1.addItem("NO EXPERIENCE");




        combo2.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXX");
        combo2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(combo2.getSelectedItem().toString());
            }
        });
        combo2.addItem("SELECT NONE");
        combo2.addItem("50000-80000");
        combo2.addItem("30000-50000");
        combo2.addItem("20000-30000");
        combo2.addItem("20000-10000");
        combo2.addItem("LESS THEN 10000");


        combo3.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXX");
        combo3.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(combo3.getSelectedItem().toString());
            }
        });
        combo3.addItem("SELECT NONE");
        combo3.addItem("ENGINEERING WORK");
        combo3.addItem("ACCOUNTING WORK");
        combo3.addItem("MANAGMENT WORK");
        combo3.addItem("SALES WORK");

        l1.setBounds(0, 0, width, 112);
        l2.setBounds(a - 150, height - 250, 300, 200);

        name.setBounds(100, 200, 150, 25);
        email.setBounds(100, 250, 150, 25);
        wexp.setBounds(100, 300, 150, 25);
        salary.setBounds(100, 350, 150, 25);
        field.setBounds(100, 400, 150, 25);
        quali.setBounds(100, 450, 150, 25);
        b1.setBounds(150, 550, 150, 25);

        name1.setBounds(280, 200, 350, 25);
        email1.setBounds(280, 250, 350, 25);
        wexp1.setBounds(280, 300, 350, 25);
        salary1.setBounds(280, 350, 350, 25);
        field1.setBounds(280, 400, 350, 25);
        quali1.setBounds(280, 450, 350, 25);


        obj.setBounds(a, 200, 150, 25);
        tech.setBounds(a, 300, 150, 25);
        project.setBounds(a, 400, 150, 25);
        b2.setBounds(width - 300, 550, 150, 25);
        b3.setBounds(width - 150, 120, 100, 20);

        obj1.setBounds(a + 180, 200, 350, 75);
        tech1.setBounds(a + 180, 300, 350, 75);
        project1.setBounds(a + 180, 400, 350, 75);

        getter();




        frm.add(name);
        frm.add(email);
        frm.add(obj);
        frm.add(tech);
        frm.add(project);
        frm.add(wexp);
        frm.add(salary);
        frm.add(field);
        frm.add(quali);

        frm.add(name1);
        frm.add(email1);
        frm.add(obj1);
        frm.add(tech1);
        frm.add(project1);
        frm.add(wexp1);
        frm.add(salary1);
        frm.add(field1);
        frm.add(quali1);
        frm.add(b1);
        frm.add(b2);
        frm.add(b3);
        frm.add(l1);
        frm.add(l2);
        frm.add(b3);
        fr.add(frm);


    }

    public void getter() throws Exception {
        if ((emp_search.a1) > 0) {
            emp_searched.str1 = ("quali=" + emp_search.a1);
        } else {
            emp_searched.str1 = ("quali>0");
        }

        if ((emp_search.a2) > 0) {
            emp_searched.str2 = ("wexp=" + emp_search.a2);
        } else {
            emp_searched.str2 = ("wexp>0");
        }

        if ((emp_search.a3) > 0) {
            emp_searched.str3 = ("salary=" + emp_search.a3);
        } else {
            emp_searched.str3 = ("salary>0");
        }

        if ((emp_search.a4) > 0) {
            emp_searched.str4 = ("field=" + emp_search.a4);
        } else {
            emp_searched.str4 = ("field>0");
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cont = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "system");


        //String query = "select * from cand where " + "quali>0" + " and " + "salary>0" + " and " + "wexp>0" + " and " + "field>0";
        String query = "select * from cand where "+emp_searched.str1+" and "+emp_searched.str2+" and "+emp_searched.str3+" and "+emp_searched.str4;

        Statement st = cont.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        emp_searched.rs = st.executeQuery(query);
        while (rs.next()) {
            
            name1.setText("" + rs.getString(1));
            obj1.setText("" + rs.getString(7));
            email1.setText("" + rs.getString(4));
            tech1.setText("" + rs.getString(9));
            project1.setText("" + rs.getString(10));
            int a0 = Integer.parseInt(rs.getString(11));
            combo.setSelectedIndex(a0);

            quali1.setText(combo.getSelectedItem().toString());
            int a1 = Integer.parseInt(rs.getString(12));
            combo1.setSelectedIndex(a1);
            wexp1.setText(combo1.getSelectedItem().toString());
            int a5 = Integer.parseInt(rs.getString(13));
            combo2.setSelectedIndex(a5);
            salary1.setText(combo2.getSelectedItem().toString());
            int a3 = Integer.parseInt(rs.getString(14));
            combo3.setSelectedIndex(a3);
            field1.setText(combo3.getSelectedItem().toString());
            break;

        }
        // fr.repaint();




    }
/*
    public static void main(String[] args) throws Exception {
        new emp_searched();
    }

 *
 */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            try {
                //String query = "select * from cand where "+"quali>0"+" and "+"salary>0"+" and "+"wexp>0"+" and "+"field>0";
                //String query = "select * from cand where "+emp_searched.str1+" and "+emp_searched.str2+" and "+emp_searched.str3+" and "+emp_searched.str4;

                // Statement st = cont.createStatement();
                // rs = st.executeQuery(query);
                while (emp_searched.rs.next()) {

                    name1.setText("" + rs.getString(1));
                    obj1.setText("" + rs.getString(7));
                    email1.setText("" + rs.getString(4));
                    tech1.setText("" + rs.getString(9));
                    project1.setText("" + rs.getString(10));
                    int a0 = Integer.parseInt(rs.getString(11));
                    combo.setSelectedIndex(a0);

                    quali1.setText(combo.getSelectedItem().toString());
                    int a1 = Integer.parseInt(rs.getString(12));
                    combo1.setSelectedIndex(a1);
                    wexp1.setText(combo1.getSelectedItem().toString());
                    int a5 = Integer.parseInt(rs.getString(13));
                    combo2.setSelectedIndex(a5);
                    salary1.setText(combo2.getSelectedItem().toString());
                    int a3 = Integer.parseInt(rs.getString(14));
                    combo3.setSelectedIndex(a3);
                    field1.setText(combo3.getSelectedItem().toString());
                    break;

                }
                fr.repaint();
                System.out.println("hell is here");
            } catch (Exception ertq) {
            }
            }



            if (e.getSource() == b1) {
                try {
                    int arm = rs.getRow();
                    while (rs.absolute(arm - 1)) {
                        name1.setText("" + rs.getString(1));
                        obj1.setText("" + rs.getString(7));
                        email1.setText("" + rs.getString(4));
                        tech1.setText("" + rs.getString(9));
                        project1.setText("" + rs.getString(10));
                        int a0 = Integer.parseInt(rs.getString(11));
                        combo.setSelectedIndex(a0);

                        quali1.setText(combo.getSelectedItem().toString());
                        int a1 = Integer.parseInt(rs.getString(12));
                        combo1.setSelectedIndex(a1);
                        wexp1.setText(combo1.getSelectedItem().toString());
                        int a5 = Integer.parseInt(rs.getString(13));
                        combo2.setSelectedIndex(a5);
                        salary1.setText(combo2.getSelectedItem().toString());
                        int a3 = Integer.parseInt(rs.getString(14));
                        combo3.setSelectedIndex(a3);
                        field1.setText(combo3.getSelectedItem().toString());
                        break;

                    }
                    fr.repaint();
                } catch (Exception srts) {
                }
            }


            if(e.getSource()==b3)
         {
            fr.dispose();
            try{
           new Employeraccount();
             }
            catch(Exception er)
            {}
         }
        
    }
}

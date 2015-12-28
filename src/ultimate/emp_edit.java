package ultimate;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class emp_edit implements ActionListener {

    public static JFrame fr,frm;
    JLabel lb1, lb2, lb3;
    public static JPasswordField ops, nps, nps2;
    JButton change2;
    JPanel panl, first, second;
    JLabel unm, name, pswd, edu, wxp, hwapp, jdetail, abtc, abtcr;
    Label nt_member;
    JButton sub, can, change;
    public static JTextField unm1, name1, abtc1, abtcr1;
    public static TextArea edu1, wxp1, choose1, hwapp1, jdetail1;
    JPasswordField a2;
    JCheckBox c1;
    JLabel qual, expe, salary, post;
    public static String u_name, p_word;
    private JComboBox combo = new JComboBox();
    private JComboBox combo1 = new JComboBox();
    private JComboBox combo2 = new JComboBox();
    private JComboBox combo3 = new JComboBox();

    public emp_edit() throws Exception {
        fr = new JFrame();
        fr.setLayout(null);
        fr.setVisible(true);
        fr.setResizable(false);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int hight = Toolkit.getDefaultToolkit().getScreenSize().height;
        JLabel l1 = new JLabel(new ImageIcon("header.png"));
        fr.setBounds(0, 0, width, hight);
        fr.setBackground(Color.white);
        int a = (width / 2) + 50;

        unm = new JLabel("Username");
        name = new JLabel("Name");
        pswd = new JLabel("Password");
        abtc = new JLabel("About Company");
        hwapp = new JLabel("How to Apply");
        jdetail = new JLabel("Job Details");
        abtc = new JLabel("Company name");
        abtcr = new JLabel("Location");

        hwapp1 = new TextArea("");

        jdetail1 = new TextArea();

        unm1 = new JTextField();
        name1 = new JTextField();
        abtc1 = new JTextField();
        abtcr1 = new JTextField();

        sub = new JButton("Submit data");
        can = new JButton("Cancel");
        change = new JButton("Change password");

        name1.setEditable(false);
        unm1.setEditable(false);

        sub.addActionListener(this);
        can.addActionListener(this);
        change.addActionListener(this);
        combo.setBackground(Color.white);
        combo1.setBackground(Color.white);
        combo2.setBackground(Color.white);
        combo3.setBackground(Color.white);


        JLabel pa = new JLabel(new ImageIcon("color1.jpg"));
        JLabel C1 = new JLabel(new ImageIcon("search.jpg"));

        JLabel qua = new JLabel();
        JLabel ex = new JLabel();
        JLabel sal = new JLabel();
        JLabel pos = new JLabel();


        qual = new JLabel("Qualification");
        expe = new JLabel("Work Experience");
        salary = new JLabel("Salary Demand");
        post = new JLabel("field");







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



        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cont = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "system");

        String query = "select * from employer where username='" + login.u_name + "'";
        Statement st = cont.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            name1.setText("" + rs.getString(1));
            abtc1.setText("" + rs.getString(7));
            abtcr1.setText("" + rs.getString(6));
            unm1.setText("" + rs.getString(2));
            jdetail1.setText("" + rs.getString(8));
            hwapp1.setText("" + rs.getString(9));
            int a0 = Integer.parseInt(rs.getString(10));
            combo.setSelectedIndex(a0);
            int a1 = Integer.parseInt(rs.getString(11));
            combo1.setSelectedIndex(a1);
            int a5 = Integer.parseInt(rs.getString(12));
            combo2.setSelectedIndex(a5);
            int a3 = Integer.parseInt(rs.getString(13));
            combo3.setSelectedIndex(a3);
        }






        qua.setLayout(new FlowLayout());
        ex.setLayout(new FlowLayout());
        sal.setLayout(new FlowLayout());
        pos.setLayout(new FlowLayout());


        qua.setBounds(a + 180, 200, 230, 35);
        ex.setBounds(a + 180, 200 + 72, 230, 35);
        sal.setBounds(a + 180, 200 + 144, 230, 35);
        pos.setBounds(a + 180, 200 + 216, 230, 35);


        qual.setBounds(a, 200, 150, 35);
        expe.setBounds(a, 200 + 72, 150, 35);
        salary.setBounds(a, 200 + 144, 150, 35);
        post.setBounds(a, 200 + 216, 150, 35);





        qua.add(combo);
        ex.add(combo1);
        sal.add(combo2);
        pos.add(combo3);

        l1.setBounds(0, 0, width, 112);
        unm.setBounds(50, 200, 150, 25);
        name.setBounds(50, 250, 150, 25);
        pswd.setBounds(50, 300, 150, 25);
        abtc.setBounds(50, 350, 150, 25);
        abtcr.setBounds(50, 400, 150, 25);
        jdetail.setBounds(50, 450, 150, 25);
        hwapp.setBounds(50, 550, 150, 25);

        unm1.setBounds(220, 200, 350, 25);
        name1.setBounds(220, 250, 350, 25);
        change.setBounds(220, 300, 150, 25);
        abtc1.setBounds(220, 350, 350, 25);
        abtcr1.setBounds(220, 400, 350, 25);
        jdetail1.setBounds(220, 450, 350, 75);
        hwapp1.setBounds(220, 550, 350, 75);



        sub.setBounds(a + 50, 590, 150, 25);
        can.setBounds(a + 250, 590, 150, 25);


        fr.add(l1);
        fr.add(unm);
        fr.add(name);
        fr.add(pswd);


        fr.add(hwapp);
        fr.add(jdetail);
        fr.add(abtc);
        fr.add(abtcr);

        fr.add(unm1);
        fr.add(name1);
        fr.add(change);


        fr.add(hwapp1);
        fr.add(jdetail1);
        fr.add(abtc1);
        fr.add(abtcr1);
        fr.add(sub);
        fr.add(can);
        fr.add(qua);
        fr.add(ex);
        fr.add(sal);
        fr.add(pos);
        fr.add(qual);
        fr.add(expe);
        fr.add(salary);
        fr.add(post);





    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            try {

                modifier();
                fr.dispose();
                new Employeraccount();

            } catch (Exception er2) {
            }
        }
        if (e.getSource() == can) {
            try {
                Employeraccount emp = new Employeraccount();
                fr.dispose();
            } catch (Exception er) {
            }
        }
        if (e.getSource() == change) {
            p_changer();
        }
    }
/*
    public static void main(String[] args) throws Exception {
        new emp_edit();
    }
 *
 */

    void p_changer() {
        JPanel p, p2;

        frm = new JFrame();
        p = new JPanel();
        p2 = new JPanel();
        p.setLayout(new GridLayout(4, 2));
        lb1 = new JLabel("Old password");
        lb2 = new JLabel("New Password");
        lb3 = new JLabel("Retype new Password");
        ops = new JPasswordField(10);
        nps = new JPasswordField(10);
        nps2 = new JPasswordField(10);
        change2 = new JButton("Submit");
        change2.addActionListener(this);
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        frm.setBounds((w / 2) - 150, h / 2 - 100, 300, 200);
        p.add(lb1);
        p.add(ops);
        p.add(lb2);
        p.add(nps);
        p.add(lb3);
        p.add(nps2);
        p.add(change2);
        p2.add(p);
        frm.setVisible(true);
        frm.add(p2);

    }

    void p_modifier() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cont = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "system");

        String query12 = "select * from employer where username='" + login.u_name + "'";
        Statement st2 = cont.createStatement();
        ResultSet rs = st2.executeQuery(query12);
        boolean b = false;
        while (rs.next()) {
            if ((rs.getString(3)).equals(cand_edit.ops.getText())) {

                b = true;
            }
        }
        if (b == true) {
            if (cand_edit.nps.getText().equals(cand_edit.nps2.getText())) {
                Statement st = cont.createStatement();
                String query = "update cand set password ='" + nps.getText() + "'  where username='" + login.u_name + "'";
                st.executeQuery(query);
                JOptionPane.showMessageDialog(null, "password sucessfully changed ");

                frm.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "both password should be same");
            }

        } else {
            JOptionPane.showMessageDialog(null, "you entered wrong password");
        }

    }

    void modifier() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cont = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "system");

        Statement st = cont.createStatement();


        String query8 = "update employer set company ='" + emp_edit.abtc1.getText() + "',location ='" + emp_edit.abtcr1.getText() + "',job_detail ='" + emp_edit.jdetail1.getText() + "',apply ='" + emp_edit.hwapp1.getText() + "',quali =" + combo.getSelectedIndex() + ",wexp =" + combo1.getSelectedIndex() + ",salary =" + combo2.getSelectedIndex() + ",field =" + combo3.getSelectedIndex() + "  where username='" + login.u_name + "'";
        st.executeQuery(query8);



    }
}

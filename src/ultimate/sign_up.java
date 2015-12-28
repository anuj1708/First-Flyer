package ultimate;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class sign_up implements ActionListener, MouseListener {

    public static JFrame f;
    JPanel p, p2, p3;
    JLabel fn, ln, un, ps1, ps2, eid, mb, cct, emplo, dob, dober, dd, mm, yy;
    JButton sub;
    public JTextField fn1, ln1, un1, eid1, mb1, cct1, hquali1, dober1, dober2, dober3;
    public Label er1, er2, er3, er4, er5, er6, er7, er8, er9, er10, member;
    JPasswordField ps11, ps21;
    public static JCheckBox c1;
    public static boolean bl;
    public static String str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13;

    public sign_up() throws Exception {
        f = new JFrame();

        f.setLayout(new BorderLayout());
        f.setVisible(true);
        f.setResizable(false);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int hight = Toolkit.getDefaultToolkit().getScreenSize().height;
        f.setBounds(300, 0, width - 600, hight);

        p = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p3.setLayout(new BorderLayout());

        JLabel C = new JLabel(new ImageIcon("bigpicture.jpg"));
        JLabel C1 = new JLabel(new ImageIcon("flyer.png"));

        p.setBackground(Color.white);
        p2.setBackground(Color.white);
        p3.setBackground(Color.white);


        p.setLayout(new GridLayout(11, 3));
        p.setBounds(0, 20, 309, 130);



        un = new JLabel("*  Username");
        ps1 = new JLabel("*  Password");
        ps2 = new JLabel("*  Confirm Password");
        fn = new JLabel("*  First Name");
        ln = new JLabel("   Last Name");
        eid = new JLabel("*  Email ID");
        mb = new JLabel("*  Mobile");
        cct = new JLabel("*  Location");
        emplo = new JLabel("   Are you Employer?");

        dob = new JLabel("   DOB");
        dober = new JLabel();
        dd = new JLabel("DD");
        mm = new JLabel("MM");
        yy = new JLabel("YY");
        member = new Label("     already a member?");
        member.addMouseListener(this);
        c1 = new JCheckBox();
        c1.setBackground(Color.white);



        er1 = new Label("");
        er2 = new Label("");
        er3 = new Label("");
        er4 = new Label("");
        er5 = new Label("");
        er6 = new Label("");
        er7 = new Label("");
        er8 = new Label("");
        er9 = new Label("");
        er10 = new Label("");

        un1 = new JTextField(15);
        ps11 = new JPasswordField(15);
        ps21 = new JPasswordField(15);
        fn1 = new JTextField(15);
        ln1 = new JTextField(15);
        eid1 = new JTextField(15);
        mb1 = new JTextField(15);
        cct1 = new JTextField(15);
        dober1 = new JTextField(2);
        dober2 = new JTextField(2);
        dober3 = new JTextField(2);

        sub = new JButton("Sign up");
        sub.setBorderPainted(false);
        sub.setFocusable(true);
        sub.addActionListener(this);

        dober.setLayout(new FlowLayout());
        dober.add(dober1);
        dober.add(dd);
        dober.add(dober2);
        dober.add(mm);
        dober.add(dober3);
        dober.add(yy);

        p.add(fn);
        p.add(fn1);
        p.add(er1);
        p.add(ln);
        p.add(ln1);
        p.add(er2);
        p.add(un);
        p.add(un1);
        p.add(er3);
        p.add(ps1);
        p.add(ps11);
        p.add(er4);
        p.add(ps2);
        p.add(ps21);
        p.add(er5);
        p.add(eid);
        p.add(eid1);
        p.add(er6);
        p.add(mb);
        p.add(mb1);
        p.add(er7);
        p.add(cct);
        p.add(cct1);
        p.add(er8);

        p.add(emplo);
        p.add(c1);
        p.add(er9);

        p.add(sub);
        p.add(member);
        p2.add(p);
        p3.add(BorderLayout.NORTH, C1);
        p3.add(BorderLayout.EAST, p2);
        p3.add(BorderLayout.SOUTH, C);
        f.add(p3);


    }

    public static void goer() throws Exception {

        System.out.println("die here");



        System.out.println("" + sign_up.bl);

        if (sign_up.bl == false) {
            System.out.println("entered1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con1 = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "system");
            String query1 = "select * from cand";
            System.out.println("entered2");
            Statement st1 = con1.createStatement();
            ResultSet rs = st1.executeQuery(query1);
            boolean b = false;
            while (rs.next()) {
                if ((rs.getString(3)).equals(sign_up.str3)) {
                    b = true;
                }
            }
            if (b == false) {
                System.out.println("entered3");
                String query2 = "insert into cand values('" + sign_up.str1 + "','" + sign_up.str2 + "','" + sign_up.str3 + "','" + sign_up.str4 + "','" + sign_up.str5 + "','" + sign_up.str7 + "','" + sign_up.str8 + "','','','',0,0,0,0)";
                Statement st2 = con1.createStatement();
                st2.executeQuery(query2);
                JOptionPane.showMessageDialog(null, "welcome\n now you are a meber of our team ");
                f.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "this username already exist");
            }


        }
        if (sign_up.bl == true) {
            System.out.println("entered4");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con3 = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "system");
            String query3 = "select * from employer";
            Statement st3 = con3.createStatement();
            ResultSet rs = st3.executeQuery(query3);
            boolean b = false;
            while (rs.next()) {
                if ((rs.getString(3)).equals(sign_up.str3)) {
                    b = true;
                }
            }
            if (b == false) {
                String query4 = "insert into employer values('" + sign_up.str1 + "','" + sign_up.str2 + "','" + sign_up.str3 + "','" + sign_up.str4 + "','" + sign_up.str5 + "','" + sign_up.str7 + "','" + sign_up.str8 + "','','','0','0','0','0')";
                Statement st4 = con3.createStatement();
                st4.executeQuery(query4);
                JOptionPane.showMessageDialog(null, "welcome\n now you are a meber of our team ");
                f.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "this username already exist");
            }
        }


    }

    public void actionPerformed(ActionEvent e) {
        sign_up.str1 = fn1.getText();
        sign_up.str2 = ln1.getText();
        sign_up.str3 = un1.getText();
        sign_up.str4 = ps11.getText();
        sign_up.str5 = eid1.getText();
        sign_up.str6 = ps21.getText();
        sign_up.str7 = mb1.getText();
        sign_up.str8 = cct1.getText();
        sign_up.bl = sign_up.c1.isSelected();
        System.out.println(sign_up.bl);



        boolean bl1, bl2, bl3, bl4, bl5, bl6, bl7, bl8, bl9;
        bl1 = false;
        bl2 = false;
        bl3 = false;
        bl4 = false;
        bl5 = false;
        bl6 = false;
        bl7 = false;
        bl8 = false;

        if (str1.length() > 0) {
            //er1.setForeground(null);
            er1.setText("");
            fn1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            bl1 = true;
            f.repaint();
        } else {
            er1.setForeground(Color.red);
            er1.setText("(First name can't be null)");
            fn1.setBorder(BorderFactory.createLineBorder(Color.red));
            f.repaint();
        }

        if (str3.length() > 0) {
            er3.setText("");
            un1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            bl2 = true;
            f.repaint();

        } else {
            er3.setForeground(Color.red);
            er3.setText("(Username can't be null)");
            un1.setBorder(BorderFactory.createLineBorder(Color.red));
            f.repaint();
        }

        if (str5.length() > 0) {
            er6.setText("");
            eid1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            bl3 = true;
            f.repaint();

        } else {
            er6.setForeground(Color.red);
            er6.setText("(email id can't be null)");
            eid1.setBorder(BorderFactory.createLineBorder(Color.red));
            f.repaint();
        }

        if (str4.length() > 0) {
            er4.setText("");
            ps11.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            bl4 = true;
            f.repaint();
        } else {
            er4.setForeground(Color.red);
            er4.setText("(Password can't be null)");
            ps11.setBorder(BorderFactory.createLineBorder(Color.red));
            f.repaint();
        }

        if ((str4.equals(str6))) {
            str6 = str4;
            er5.setForeground(null);
            er5.setText("");
            ps21.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            bl5 = true;
            f.repaint();
        } else {
            er5.setForeground(Color.red);
            er5.setText("(both pwd should be same)");
            ps21.setBorder(BorderFactory.createLineBorder(Color.red));
            f.repaint();
        }
        if (str7.length() == 10) {
            er7.setText("");
            mb1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            bl6 = true;
            f.repaint();
        } else {
            er7.setForeground(Color.red);
            er7.setText("(number should be of 10 digit)");
            mb1.setBorder(BorderFactory.createLineBorder(Color.red));
            f.repaint();
        }
        if (str8.length() > 0) {
            er8.setText("");
            cct1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            bl7 = true;
            f.repaint();
        } else {
            er8.setForeground(Color.red);
            er8.setText("(Current City can't be null)");
            cct1.setBorder(BorderFactory.createLineBorder(Color.red));
            f.repaint();
        }


        try {
            if ((bl1 && bl2 && bl3 && bl4 && bl5 && bl6 && bl7) == true) {
                JOptionPane.showMessageDialog(null, "Data submitting ");
                sign_up.goer();
            }
        } catch (Exception e3) {
        }
    }

    public void mouseClicked(MouseEvent e) {
        login ln = new login();
        f.dispose();
        login.fr.dispose();
        System.out.println("disposed");


    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
/*
    public static void main(String[] args) {
        try {
            sign_up sg = new sign_up();
        } catch (Exception etr) {
        }
    }
 * 
 */
}

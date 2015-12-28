package ultimate;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login implements ActionListener, MouseListener {

    public static JFrame fr;
    JPanel pan, Log, box;
    JLabel l1, l2, l3;
    Label nt_member;
    JButton sub;
    JTextField a1;
    JPasswordField a2;
    public static JCheckBox c1;
    public static String u_name, p_word;

    public login() {
        fr = new JFrame("first flyer");

        fr.setLayout(new BorderLayout());
        fr.setVisible(true);
        fr.setResizable(false);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int hight = Toolkit.getDefaultToolkit().getScreenSize().height;

        fr.setBackground(Color.white);


        pan = new JPanel();
        Log = new JPanel();
        box = new JPanel();
        box.setLayout(new BorderLayout());
        //setBackground(Color.white);
        //setForeground(Color.black);
        JLabel C = new JLabel(new ImageIcon("bigpicture.jpg"));
        JLabel C1 = new JLabel(new ImageIcon("login.png"));




        pan.setLayout(new GridLayout(5, 2));

        c1 = new JCheckBox();
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l3 = new JLabel("Are you employer");
        nt_member = new Label("  not a member? sign up now");
        nt_member.addMouseListener(this);

        a1 = new JTextField(15);

        a2 = new JPasswordField(15);
        sub = new JButton("Log in");
        sub.setBorderPainted(false);
        sub.setFocusable(true);
        sub.addActionListener(this);

        pan.setBackground(Color.white);
        Log.setBackground(Color.white);
        box.setBackground(Color.white);
        c1.setBackground(Color.white);


            pan.add(l1);
            pan.add(a1);
            pan.add(l2);
            pan.add(a2);
            pan.add(c1);
            pan.add(l3);
            pan.add(sub);
            pan.add(nt_member);
            Log.add(pan);

            try {
                box.add(BorderLayout.NORTH, C1);
                box.add(BorderLayout.CENTER, Log);
                box.add(BorderLayout.SOUTH, C);
            } catch (Exception e) {
            }
            fr.add(BorderLayout.CENTER, box);
            try {
                Thread.sleep(50);
            } catch (Exception ert) {
            }
            fr.setBounds(0, 0, width, hight);

        

    }

    public static void goner() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cont = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "system");
        if (c1.isSelected() == true) {
            String query5 = "select * from employer where username='" + login.u_name + "'";
            Statement st2 = cont.createStatement();
            ResultSet rs = st2.executeQuery(query5);
            boolean b = false;
            while (rs.next()) {
                if ((rs.getString(3)).equals(login.p_word)) {

                    b = true;
                }
            }
            if (b == true) {

                JOptionPane.showMessageDialog(null, "sucessfully logged in ");
                new Employeraccount();
                fr.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "either username or password is incorrect emp");
            }
        }

        if (c1.isSelected() == false) {
            String query5 = "select * from cand where username='" + login.u_name + "'";
            Statement st2 = cont.createStatement();
            ResultSet rs = st2.executeQuery(query5);
            boolean b = false;
            while (rs.next()) {
                if ((rs.getString(3)).equals(login.p_word)) {
                    b = true;
                }
            }
            if (b == true) {

                JOptionPane.showMessageDialog(null, "sucessfully logged in ");
                new Candidateaccount();
                fr.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "either username or password is incorrect cand");
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        //new second();
        login.u_name = a1.getText();
        login.p_word = a2.getText();
        try {
            login.goner();
        } catch (Exception ert) {
        }

    }

    public void mouseClicked(MouseEvent e) {
        try {
            new sign_up();
        } catch (Exception e2) {
            System.out.println(e2);
        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        login usn = new login();
    }
}

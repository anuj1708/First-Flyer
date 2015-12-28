package ultimate;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Candidateaccount implements ActionListener {

    public static JFrame f;
    JPanel p1, p2, p3, p4;
    JTextField t1, t2, t3, t4, t5, t6;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JPasswordField j1, j2;
    JButton b1, b2, b3;

    public Candidateaccount ()throws Exception {
        f = new JFrame("JOB PORTAL");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        f.setSize(width, height);
        f.setResizable(false);
        f.setVisible(true);


        JLabel l1 = new JLabel(new ImageIcon("cand.png"));
        JLabel C1 = new JLabel(new ImageIcon("hr.jpg"));
        l1.setLayout(null);

        //l1.setBounds(0,0,width,260);


        p2 = new JPanel();
        p3 = new JPanel();
        f.setBackground(Color.WHITE);
        p2.setBackground(Color.WHITE);
        p3.setBackground(Color.WHITE);


        p3.setBounds(500, 380, 420, 260);
        p2.setLayout(new GridLayout(6, 2));
        l3 = new JLabel("Name");
        t2 = new JTextField(15);
        t2.setBorder(BorderFactory.createEmptyBorder());
        l4 = new JLabel("City");
        t3 = new JTextField(15);
        t3.setBorder(BorderFactory.createEmptyBorder());
        l5 = new JLabel("Email");
        t4 = new JTextField(15);
        t4.setBorder(BorderFactory.createEmptyBorder());
        l6 = new JLabel("Mobile");

        t5 = new JTextField(15);
        t5.setBorder(BorderFactory.createEmptyBorder());
        l7 = new JLabel("");
        l8 = new JLabel("");

        b1 = new JButton("Click here to change account details ");
        b1.addActionListener((ActionListener) this);

        b2 = new JButton("Click here to search for Job");
        b2.addActionListener((ActionListener) this);

        b3 = new JButton("Sign out");
        b3.addActionListener((ActionListener) this);
        b3.setBounds(width - 150, 120, 100, 20);
        l1.add(b3);

         Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cont = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost", "system", "system");

        String query = "select * from cand where username='" + login.u_name + "'";
        Statement st = cont.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            t2.setText("" + rs.getString(1));
            t3.setText("" + rs.getString(6));
            t4.setText("" + rs.getString(4));
            t5.setText("" + rs.getString(5));
        }
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        p2.add(l6);

        p2.add(t5);
        p2.add(l7);
        p2.add(l8);
        p2.add(b1);
        p2.add(b2);

        p3.add(p2);

        f.add(BorderLayout.NORTH, l1);
        f.add(BorderLayout.SOUTH, C1);
        f.add(BorderLayout.CENTER, p3);

    }

    /*public static void main(String[] args) throws Exception {
        Candidateaccount ar = new Candidateaccount();

    }
     *
     */

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            try{
            new cand_edit();
            f.dispose();
            }
            catch(Exception ertr)
            {}

        }
        if(e.getSource()==b2)
        {
        new cand_search();
        }
        if(e.getSource()==b3)
        {
        new login();
        f.dispose();
        }
    }
}

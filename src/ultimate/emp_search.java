package ultimate;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class emp_search implements  MouseListener{

    JFrame fa;
    JPanel pa, pb, pc, pd;
    JLabel qual, expe, salary, post;
    JButton ba;
    JTextField ta, tb, tc, td, te, tf, tg;
    public static int a1,a2,a3,a4;
    private JComboBox combo = new JComboBox();
    private JComboBox combo1 = new JComboBox();
    private JComboBox combo2 = new JComboBox();
    private JComboBox combo3 = new JComboBox();
    Font midf = new Font("Bradley Hand ITC", Font.BOLD, 20);

    public emp_search() {
         int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        fa = new JFrame("Requirements");
        //fa.setBounds(400, 100, 690, 552);
        fa.setBounds((w-690)/2, 100, 690, 552);

        fa.setVisible(true);


        combo.setBackground(Color.white);
        combo1.setBackground(Color.white);
        combo2.setBackground(Color.white);
        combo3.setBackground(Color.white);


        //JLabel pa = new JLabel(new ImageIcon("C:\\Users\\appy\\Desktop\\project\\color1.jpg"));
        //JLabel C1 = new JLabel(new ImageIcon("C:\\Users\\appy\\Desktop\\project\\search.jpg"));

        JLabel pa = new JLabel(new ImageIcon("color1.jpg"));
        JLabel C1 = new JLabel(new ImageIcon("search.jpg"));

        JLabel qua = new JLabel();
        JLabel ex = new JLabel();
        JLabel sal = new JLabel();
        JLabel pos = new JLabel();
        ba=new JButton("Search");

        qual = new JLabel("Qualification");
        expe = new JLabel("Work Experience");
        salary = new JLabel("Salary Demand");
        post = new JLabel("Field");
        qual.setFont(midf);
        expe.setFont(midf);
        salary.setFont(midf);
        post.setFont(midf);




        pa.setBounds(10, 10, 500, 500);
        pa.setLayout(null);

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





        qua.setLayout(new FlowLayout());
        ex.setLayout(new FlowLayout());
        sal.setLayout(new FlowLayout());
        pos.setLayout(new FlowLayout());


        qua.setBounds(289, 111, 230, 35);
        ex.setBounds(289, 111 + 72, 230, 35);
        sal.setBounds(289, 111 + 144, 230, 35);
        pos.setBounds(289, 111 + 216, 230, 35);


        qual.setBounds(100, 107, 150, 35);
        expe.setBounds(100, 107 + 72, 150, 35);
        salary.setBounds(100, 107 + 144, 150, 35);
        post.setBounds(100, 107 + 216, 150, 35);
        C1.setBounds(200, 380, 130, 60);
        C1.addMouseListener(this);







        qua.add(combo);
        ex.add(combo1);
        sal.add(combo2);
        pos.add(combo3);

        pa.add(qua);
        pa.add(ex);
        pa.add(sal);
        pa.add(pos);

        pa.add(qual);
        pa.add(expe);
        pa.add(salary);
        pa.add(post);
        pa.add(C1);

        fa.setResizable(false);
        fa.add(pa);

    }
/*
    public static void main(String arg[]) {
        emp_search es = new emp_search();
    }
 *
 */

    public void mouseClicked(MouseEvent e) {
        emp_search.a1=combo.getSelectedIndex();
        emp_search.a2=combo1.getSelectedIndex();
        emp_search.a3=combo2.getSelectedIndex();
        emp_search.a4=combo3.getSelectedIndex();
        try{
        new emp_searched();

        fa.dispose();
        Employeraccount.f.dispose();
        }
        catch(Exception ert)
        {}
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}

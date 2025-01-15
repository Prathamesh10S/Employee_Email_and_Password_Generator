package XYZ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


public class Values {

    String fn = null;
    String ln = null;

    public Values(String fn, String ln) {

        this.fn=fn;
        this.ln=ln;

        JFrame f = new JFrame();
        f.setLayout(null);
        f.setBounds(550, 200, 400, 300);
        f.setResizable(false);

        Font font = new Font("Caliber", Font.BOLD, 16);

        JLabel label = new JLabel("Employee Details ");
        label.setFont(font);
        label.setBounds(115, 13, 250, 25);
        f.add(label);

        Font font1 = new Font("Caliber", Font.BOLD, 13);

        JLabel label1 = new JLabel("First name of Employee :");
        label1.setFont(font1);
        JLabel label2 = new JLabel("Last name of Employee :");
        label2.setFont(font1);

        label1.setBounds(10, 60, 170, 25);
        label2.setBounds(10, 115, 170, 25);
        f.add(label1);
        f.add(label2);

        Font font2 = new Font("Caliber", Font.BOLD, 17);

        TextField n1 = new TextField("");
        n1.setBounds(185, 60, 180, 25);
        n1.setText(fn);
        n1.setFont(font2);
        f.add(n1);

        TextField n2 = new TextField("");
        n2.setBounds(185, 115, 180, 25);
        n2.setText(ln);
        n2.setFont(font2);
        f.add(n2);

        JButton btn1 = new JButton("Submit");
        btn1.setBounds(220, 170, 100, 35);
        f.add(btn1);

        JButton btn2 = new JButton("Back");
        btn2.setBounds(70, 170, 100, 35);
        f.add(btn2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = n1.getText();
                String lname = n2.getText();
                if ( fname.isEmpty() || lname.isEmpty()){
                    JOptionPane.showMessageDialog( f,"Please Enter all Details..","Warning Massage",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    new Email(fname,lname);
                    f.setVisible(false);
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new MyFrame();
            }
        });
        f.setVisible(true);
    }

    public static void main(String[] args) {
        String fn = "",ln = "";
        new Values(fn,ln);
    }
}

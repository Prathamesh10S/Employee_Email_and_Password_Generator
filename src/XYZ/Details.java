package XYZ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Details extends JFrame implements ActionListener {

    String fn;
    String ln;
    String email;
    String password;
    int mailCapacity = 500;
    String alter_email;
    String comp;
    String dept;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton btn1,btn2,btn3,btn4,btn5;
    public Details(String fn, String ln, String comp, String dept){
        this.fn=fn;
        this.ln=ln;
        this.comp=comp;
        this.dept=dept;
        setLayout(null);
        setBounds(550,150,550,540);
        setResizable(false);

        Font font = new Font("Caliber", Font.BOLD, 16);

        l1 = new JLabel("In " + comp + " For " + dept+ " Department ");
        l1.setFont(font);
        l1.setBounds(25,30,900,25);
        add(l1);
        l2 = new JLabel("Information Generated for " + fn + " " + ln + " is :-");
        l2.setBounds(25,55,1000,25);
        l2.setFont(font);
        add(l2);

        l3 = new JLabel("NAME                                 : " + fn + " " + ln);
        l3.setBounds(45,100,500,25);
        add(l3);

        l4 = new JLabel("COMPANY NAME             : " + comp);
        l4.setBounds(45,125,500,25);
        add(l4);

        l5 = new JLabel("DEPARTMENT                 : " + dept);
        l5.setBounds(45,150,500,25);
        add(l5);

        // Combine elements to generate an email
        l6 = new JLabel("EMAIL                                 : " + fn.toLowerCase() + ln.toLowerCase() + "@" +
                dept.toLowerCase() + "." + comp.toLowerCase() + ".com");
        l6.setBounds(45,175,500,25);
        add(l6);

        // Call a method that returns a random password
        this.password = this.generate_password(8);

        l7 = new JLabel("PASSWORD                      : " + this.password);
        l7.setBounds(45,200,500,25);
        add(l7);

        l8 = new JLabel("MAILBOX CAPACITY        : " + this.mailCapacity + "mb");
        l8.setBounds(45,225,500,25);
        add(l8);

        l9 = new JLabel("ALTER EMAIL                    : " + this.alter_email);
        l9.setBounds(45,250,500,25);
        add(l9);

        btn1 = new JButton("Change Password");
        btn1.setBounds(30, 300, 200, 35);
        add(btn1);

        btn2 = new JButton("Change Mailbox Capacity");
        btn2.setBounds(270, 300, 200, 35);
        add(btn2);

        btn3 = new JButton("Set Alternate Email");
        btn3.setBounds(30, 350, 200, 35);
        add(btn3);

        btn4 = new JButton("EXIT");
        btn4.setBounds(270, 350, 200, 35);
        add(btn4);

        btn5 = new JButton("Back");
        btn5.setBounds(155, 400, 200, 35);
        add(btn5);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1 )  {
            int sel = JOptionPane.showConfirmDialog(this,"ARE YOU SURE YOU WANT TO CHANGE YOUR PASSWORD?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (sel==JOptionPane.YES_OPTION) {
                String pass =JOptionPane.showInputDialog("Enter new password");
                String check=pass;
                if(check!=null) {
                	 this.password=pass;
                     l7.setText("PASSWORD                    : " + this.password);
                     JOptionPane.showMessageDialog(this,"PASSWORD CHANGED SUCCESSFULLY!","Massage",JOptionPane.PLAIN_MESSAGE);
                }
               }
        } else if (e.getSource() == btn2 )  {
            int mail = Integer.parseInt(JOptionPane.showInputDialog("Enter new capacity"));
            String check=Integer.toString(mail);
            if(check!=null) {
            	 this.mailCapacity=mail;
                 l8.setText("MAILBOX CAPACITY       : " + this.mailCapacity + "mb");
                 JOptionPane.showMessageDialog(this,"MAILBOX CAPACITY CHANGED SUCCESSFULLY!","Massage",JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == btn3 )  {
            String alt =JOptionPane.showInputDialog("Enter new alternate email");
            String check=alt;
            if(check!=null) {
            	this.alter_email=alt;
                l9.setText("ALTER EMAIL                   : " + this.alter_email);
                JOptionPane.showMessageDialog(this,"ALTERNATE EMAIL SET SUCCESSFULLY!","Massage",JOptionPane.PLAIN_MESSAGE);
            }  
        } else if (e.getSource() == btn4 )  {
            int sel = JOptionPane.showConfirmDialog(this,"ARE YOU SURE YOU WANT EXIT?","Massage",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if (sel==JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this,"Thank You..!","Confirm",JOptionPane.PLAIN_MESSAGE);
            setVisible(false);
            }
        }else if (e.getSource() == btn5 ){
            setVisible(false);
            new Email(fn,ln);
        }
    }

    private String generate_password(int length) {
        Random r = new Random();

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars + Small_chars + numbers + symbols;

        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    public static void main(String[] args) {
        String fn = "prathmesh",ln = "salunke",comp = "",dept = "";
        new Details(fn,ln,comp,dept);
    }
}

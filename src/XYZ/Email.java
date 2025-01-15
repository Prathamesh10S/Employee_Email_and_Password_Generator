package XYZ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Email extends JFrame implements ActionListener {
    String lname;
    String fname;

    JLabel l1,l2,l3;
    JRadioButton r1,r2,r3,r4,r5,r6,r7,r8;
    ButtonGroup company,department;
    JButton btn1,btn2;
    public Email(String fname, String lname){
        this.fname = fname;
        this.lname = lname;


        setLayout(null);
        setBounds(550,150,550,450);
        setResizable(false);

        Font font = new Font("Caliber", Font.BOLD, 16);

        l1 = new JLabel("New Employee : "+ this.fname + " " + this.lname);
        l1.setBounds(25,50,700,25);
        l1.setFont(font);
        add(l1);

        Font font1 = new Font("Caliber", Font.BOLD, 13);

        l2 = new JLabel("* CHOOSE COMPANY NAME ");
        l2.setBounds(40,100,200,25);
        l2.setFont(font1);
        add(l2);

        r1 = new JRadioButton("TIAA");
        r2 = new JRadioButton("TCS");
        r3= new JRadioButton("VIPRO");
        r4 = new JRadioButton("INFOSYS");
        r1.setBounds(60,150,200,25);
        r2.setBounds(60,200,200,25);
        r3.setBounds(60,250,200,25);
        r4.setBounds(60,300,200,25);
        add(r1);
        add(r2);
        add(r3);
        add(r4);

        l3 = new JLabel("* CHOOSE DEPARTMENT NAME ");
        l3.setBounds(250,100,250,25);
        l3.setFont(font1);
        add(l3);

        r5 = new JRadioButton("Web Developer");
        r6 = new JRadioButton("Programmer");
        r7= new JRadioButton("System Analyst");
        r8 = new JRadioButton("Network architect");
        r5.setBounds(270,150,200,20);
        r6.setBounds(270,200,200,20);
        r7.setBounds(270,250,200,20);
        r8.setBounds(270,300,200,20);
        add(r5);
        add(r6);
        add(r7);
        add(r8);

        company = new ButtonGroup();
        company.add(r1);
        company.add(r2);
        company.add(r3);
        company.add(r4);

        department = new ButtonGroup();
        department.add(r5);
        department.add(r6);
        department.add(r7);
        department.add(r8);

        btn1 = new JButton("Submit");
        btn1.setBounds(270, 350, 100, 35);
        add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(120, 350, 100, 35);
        add(btn2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn1 ) {
            String comp = null,dept = null;
            if (r1.isSelected() ) {
                 comp = "TIAA";
            }
            if (r2.isSelected() ) {
                 comp = "TCS";
            }
            if (r3.isSelected() ) {
                 comp = "VIPRO";
            }
            if (r4.isSelected() ) {
                 comp = "INFOSYS";
            }
            if (r5.isSelected() ) {
                dept = "Web_Developer";
            }
            if (r6.isSelected() ) {
                dept = "Programmer";
            }
            if (r7.isSelected() ) {
                dept = "System_Analyst";
            }
             if (r8.isSelected() ) {
                dept = "Network_Architect";
            }
             if ( comp == null || dept == null){
                JOptionPane.showMessageDialog(this,"Please select Company & Department.","Warning Massage",JOptionPane.WARNING_MESSAGE);
            } else if (comp != "" || dept != "") {
                new Details(fname, lname, comp,dept);
                setVisible(false);
            }
        }
        else if (e.getSource() == btn2 ) {

                new Values(fname,lname);
                setVisible(false);

        }
    }

    public static void main(String[] args) {
        String abc = "prathmesh";
        String ABC = "salunke";
        new Email(abc,ABC);
    }

}


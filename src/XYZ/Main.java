package XYZ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

class MyFrame extends JFrame implements ActionListener
{
    String fn = null;
    String ln = null;
    Container c;
    JLabel label1,label2;
    JButton btn;

    Font font1;

    MyFrame() {
        // TODO Auto-generated constructor stub
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(375,150,830,320);
        setResizable(false);

        c=this.getContentPane();
        c.setLayout(null);

        font1 = new Font("Caliber", Font.BOLD, 13);

        label1 = new JLabel("# WELCOME TO OUR MINI PROJECT #");
        label1.setFont(font1);
        label2 = new JLabel("IN THIS PROJECT WE ARE GENERATING EMAIL AND PASSWORD FOR THE EMPLOYEES WHOSE WORKING IN IT COMPANIES");
        label2.setFont(font1);

        label1.setBounds(283,50,300,40);
        label2.setBounds(20,100,850,60);
        c.add(label1);
        c.add(label2);


        btn = new JButton("Proceed");
        btn.setBounds(343,150,100,35);
        c.add(btn);

        btn.addActionListener(this);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btn ) {
            new Values(fn,ln);
            setVisible(false);
        }
    }


}

public class Main {

    public static void main(String[] args)throws Exception {
        // TODO Auto-generated method stub
    	
    	String string="com.jtattoo.plaf.mint.MintLookAndFeel";
		UIManager.setLookAndFeel(string);
    	
        new MyFrame();

    }

}
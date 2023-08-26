//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ASimulatorSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    String pin;

    Transactions(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        this.add(l2);
        this.l1 = new JLabel("Please Select Your Transaction");
        this.l1.setForeground(Color.WHITE);
        this.l1.setFont(new Font("System", 1, 16));
        this.b1 = new JButton("DEPOSIT");
        this.b2 = new JButton("CASH WITHDRAWL");
        this.b3 = new JButton("FAST CASH");
        this.b4 = new JButton("MINI STATEMENT");
        this.b5 = new JButton("PIN CHANGE");
        this.b6 = new JButton("BALANCE ENQUIRY");
        this.b7 = new JButton("EXIT");
        this.setLayout((LayoutManager)null);
        this.l1.setBounds(235, 400, 700, 35);
        l2.add(this.l1);
        this.b1.setBounds(170, 499, 150, 35);
        l2.add(this.b1);
        this.b2.setBounds(390, 499, 150, 35);
        l2.add(this.b2);
        this.b3.setBounds(170, 543, 150, 35);
        l2.add(this.b3);
        this.b4.setBounds(390, 543, 150, 35);
        l2.add(this.b4);
        this.b5.setBounds(170, 588, 150, 35);
        l2.add(this.b5);
        this.b6.setBounds(390, 588, 150, 35);
        l2.add(this.b6);
        this.b7.setBounds(390, 633, 150, 35);
        l2.add(this.b7);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.b3.addActionListener(this);
        this.b4.addActionListener(this);
        this.b5.addActionListener(this);
        this.b6.addActionListener(this);
        this.b7.addActionListener(this);
        this.setSize(960, 1080);
        this.setLocation(500, 0);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.b1) {
            this.setVisible(false);
            (new Deposit(this.pin)).setVisible(true);
        } else if (ae.getSource() == this.b2) {
            this.setVisible(false);
            (new Withdrawl(this.pin)).setVisible(true);
        } else if (ae.getSource() == this.b3) {
            this.setVisible(false);
            (new FastCash(this.pin)).setVisible(true);
        } else if (ae.getSource() == this.b4) {
            (new MiniStatement(this.pin)).setVisible(true);
        } else if (ae.getSource() == this.b5) {
            this.setVisible(false);
            (new Pin(this.pin)).setVisible(true);
        } else if (ae.getSource() == this.b6) {
            this.setVisible(false);
            (new BalanceEnquiry(this.pin)).setVisible(true);
        } else if (ae.getSource() == this.b7) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        (new Transactions("")).setVisible(true);
    }
}

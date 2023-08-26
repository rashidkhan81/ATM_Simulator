//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ASimulatorSystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pin extends JFrame implements ActionListener {
    JPasswordField t1;
    JPasswordField t2;
    JButton b1;
    JButton b2;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        this.add(l4);
        this.l1 = new JLabel("CHANGE YOUR PIN");
        this.l1.setFont(new Font("System", 1, 16));
        this.l1.setForeground(Color.WHITE);
        this.l2 = new JLabel("New PIN:");
        this.l2.setFont(new Font("System", 1, 16));
        this.l2.setForeground(Color.WHITE);
        this.l3 = new JLabel("Re-Enter New PIN:");
        this.l3.setFont(new Font("System", 1, 16));
        this.l3.setForeground(Color.WHITE);
        this.t1 = new JPasswordField();
        this.t1.setFont(new Font("Raleway", 1, 25));
        this.t2 = new JPasswordField();
        this.t2.setFont(new Font("Raleway", 1, 25));
        this.b1 = new JButton("CHANGE");
        this.b2 = new JButton("BACK");
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.setLayout((LayoutManager)null);
        this.l1.setBounds(280, 330, 800, 35);
        l4.add(this.l1);
        this.l2.setBounds(180, 390, 150, 35);
        l4.add(this.l2);
        this.l3.setBounds(180, 440, 200, 35);
        l4.add(this.l3);
        this.t1.setBounds(350, 390, 180, 25);
        l4.add(this.t1);
        this.t2.setBounds(350, 440, 180, 25);
        l4.add(this.t2);
        this.b1.setBounds(390, 588, 150, 35);
        l4.add(this.b1);
        this.b2.setBounds(390, 633, 150, 35);
        l4.add(this.b2);
        this.setSize(960, 1080);
        this.setLocation(500, 0);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = this.t1.getText();
            String rpin = this.t2.getText();
            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog((Component)null, "Entered PIN does not match");
                return;
            }

            if (ae.getSource() == this.b1) {
                if (this.t1.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Enter New PIN");
                }

                if (this.t2.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Re-Enter new PIN");
                }

                Conn c1 = new Conn();
                String q1 = "update bank set pin = '" + rpin + "' where pin = '" + this.pin + "' ";
                String q2 = "update login set pin = '" + rpin + "' where pin = '" + this.pin + "' ";
                String q3 = "update signup3 set pin = '" + rpin + "' where pin = '" + this.pin + "' ";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                JOptionPane.showMessageDialog((Component)null, "PIN changed successfully");
                this.setVisible(false);
                (new Transactions(rpin)).setVisible(true);
            } else if (ae.getSource() == this.b2) {
                (new Transactions(this.pin)).setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    public static void main(String[] args) {
        (new Pin("")).setVisible(true);
    }
}

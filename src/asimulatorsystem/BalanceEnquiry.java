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
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class BalanceEnquiry extends JFrame implements ActionListener {
    JTextField t1;
    JTextField t2;
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        this.add(l3);
        this.l1 = new JLabel();
        this.l1.setForeground(Color.WHITE);
        this.l1.setFont(new Font("System", 1, 16));
        this.b1 = new JButton("BACK");
        this.setLayout((LayoutManager)null);
        this.l1.setBounds(190, 350, 400, 35);
        l3.add(this.l1);
        this.b1.setBounds(390, 633, 150, 35);
        l3.add(this.b1);
        int balance = 0;

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");

            while(rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception var9) {
        }

        this.l1.setText("Your Current Account Balance is Rs " + balance);
        this.b1.addActionListener(this);
        this.setSize(960, 1080);
        this.setUndecorated(true);
        this.setLocation(500, 0);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
        (new Transactions(this.pin)).setVisible(true);
    }

    public static void main(String[] args) {
        (new BalanceEnquiry("")).setVisible(true);
    }
}

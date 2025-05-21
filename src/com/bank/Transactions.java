package com.bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fast_cash, mini_stmt, pinchange, bal_enq, exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/bank/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel title = new JLabel("MENU");
        title.setBounds(290,300,200,40);
        title.setFont(new Font("Raleway", Font.BOLD,30));
        title.setForeground(Color.WHITE);
        image.add(title);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD, 15));
        deposit.setBounds(170,415,150,30);
        deposit.setBackground(Color.GRAY);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setFont(new Font("Raleway",Font.BOLD, 15));
        withdrawl.setBounds(355,415,150,30);
        withdrawl.setBackground(Color.GRAY);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fast_cash = new JButton("Fast Cash");
        fast_cash.setFont(new Font("Raleway",Font.BOLD, 15));
        fast_cash.setBounds(170,450,150,30);
        fast_cash.setBackground(Color.GRAY);
        fast_cash.addActionListener(this);
        image.add(fast_cash);
        
        mini_stmt = new JButton("Mini Statement");
        mini_stmt.setFont(new Font("Raleway",Font.BOLD, 15));
        mini_stmt.setBounds(355,450,150,30);
        mini_stmt.setBackground(Color.GRAY);
        mini_stmt.addActionListener(this);
        image.add(mini_stmt);
        
        pinchange = new JButton("Change PIN");
        pinchange.setFont(new Font("Raleway",Font.BOLD, 15));
        pinchange.setBounds(170,485,150,30);
        pinchange.setBackground(Color.GRAY);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        bal_enq = new JButton("Balance Enquiry");
        bal_enq.setFont(new Font("Raleway",Font.BOLD, 14));
        bal_enq.setBounds(355,485,150,30);
        bal_enq.setBackground(Color.GRAY);
        bal_enq.addActionListener(this);
        image.add(bal_enq);
        
        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway",Font.BOLD, 15));
        exit.setBounds(355,520,150,25);
        exit.setBackground(Color.GRAY);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == exit){
            System.exit(0);
        } else if (a.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (a.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (a.getSource() == fast_cash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(a.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(a.getSource() == bal_enq){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if(a.getSource() == mini_stmt){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
}

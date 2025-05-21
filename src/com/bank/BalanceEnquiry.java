package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/bank/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD, 15));
        back.setBounds(355,520,150,25);
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        image.add(back);
        
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("_type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            JLabel bal = new JLabel("Net Balance");
            bal.setBounds(170,300,250,30);
            bal.setFont(new Font("Raleway",Font.BOLD, 25));
            bal.setForeground(Color.WHITE);
            image.add(bal);
            
            JLabel _rs = new JLabel("Rs. ");
            _rs.setBounds(170,340,250,30);
            _rs.setFont(new Font("Raleway",Font.BOLD, 25));
            _rs.setForeground(Color.WHITE);
            image.add(_rs);
            
            JLabel amt = new JLabel(Integer.toString(balance));
            amt.setBounds(220,340,250,30);
            amt.setFont(new Font("Raleway",Font.BOLD, 25));
            amt.setForeground(Color.WHITE);
            image.add(amt);
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}

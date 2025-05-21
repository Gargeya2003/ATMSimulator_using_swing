package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    Deposit(String pinnumber){
        
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/bank/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount that you want to deposit");
        text.setBounds(170,300,400,35);
        text.setFont(new Font("Sytem", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel rs = new JLabel("Rs.");
        rs.setBounds(170,350,30,20);
        rs.setFont(new Font("Sytem", Font.BOLD, 16));
        rs.setForeground(Color.WHITE);
        image.add(rs);
        
        amount = new JTextField();
        amount.setBounds(210,350,200,20);
        amount.setFont(new Font("Sytem", Font.BOLD, 18));
        amount.setForeground(Color.BLACK);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(380,485,130,30);
        deposit.setBackground(Color.GRAY);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(380,520,130,28);
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == deposit){
            String number  = amount.getText();
            Date date =new Date();
            if (number == null){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");
            } else{
                try{
                Conn c = new Conn();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        } else if(a.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Deposit("");
    }
}

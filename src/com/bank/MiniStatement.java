package com.bank;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.sql.*;


public class MiniStatement extends JFrame{
    
    JButton back;
    String pinnumber;
    
    MiniStatement(String pinnumber){
        
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        
        JLabel stmt = new JLabel("Canara Bank");
        stmt.setFont(new Font("Raleway",Font.BOLD,20));
        stmt.setBounds(130,20,200,25);
        add(stmt);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        card.setFont(new Font("Arial",Font.BOLD,14));
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,100,400,200);
        mini.setFont(new Font("Arial",Font.BOLD,14));
        add(mini);
        
        JLabel balance = new JLabel("Your current balance is Rs.");
        balance.setBounds(20,400,300,20);
        balance.setFont(new Font("Arial",Font.BOLD,14));
        add(balance);
        
        try{
            Conn c = new Conn();
            String query = "select * from login where pin = '"+pinnumber+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int bal = 0;
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("_date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("_type") + "&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("_type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText(balance.getText() + Integer.toString(bal));
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        setSize(600,600);
        setLocation(20,20);
        setLayout(null);
        setVisible(true);
    }
//    public void actionPerformed(ActionEvent a){
//        if(a.getSource() == back){
//            setVisible(false);
//            new Transactions(pinnumber).setVisible(true);
//        }
//    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}

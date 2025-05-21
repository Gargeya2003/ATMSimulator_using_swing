package com.bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    JButton hundred, five_hundred, thousand, two_thousand, five_thousand, ten_thousand, back;
    String pinnumber;
    
    FastCash (String pinnumber){
        
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/bank/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel title = new JLabel("SELECT WITHDRAWL AMOUNT");
        title.setBounds(170,300,250,40);
        title.setFont(new Font("Raleway", Font.BOLD,30));
        title.setForeground(Color.WHITE);
        image.add(title);
        
        hundred = new JButton("Rs 100");
        hundred.setFont(new Font("Raleway",Font.BOLD, 15));
        hundred.setBounds(170,415,150,30);
        hundred.setBackground(Color.GRAY);
        hundred.addActionListener(this);
        image.add(hundred);
        
        five_hundred = new JButton("Rs 500");
        five_hundred.setFont(new Font("Raleway",Font.BOLD, 15));
        five_hundred.setBounds(355,415,150,30);
        five_hundred.setBackground(Color.GRAY);
        five_hundred.addActionListener(this);
        image.add(five_hundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setFont(new Font("Raleway",Font.BOLD, 15));
        thousand.setBounds(170,450,150,30);
        thousand.setBackground(Color.GRAY);
        thousand.addActionListener(this);
        image.add(thousand);
        
        two_thousand = new JButton("Rs 2000");
        two_thousand.setFont(new Font("Raleway",Font.BOLD, 15));
        two_thousand.setBounds(355,450,150,30);
        two_thousand.setBackground(Color.GRAY);
        two_thousand.addActionListener(this);
        image.add(two_thousand);
        
        five_thousand = new JButton("Rs 5000");
        five_thousand.setFont(new Font("Raleway",Font.BOLD, 15));
        five_thousand.setBounds(170,485,150,30);
        five_thousand.setBackground(Color.GRAY);
        five_thousand.addActionListener(this);
        image.add(five_thousand);
        
        ten_thousand = new JButton("Rs 10000");
        ten_thousand.setFont(new Font("Raleway",Font.BOLD, 15));
        ten_thousand.setBounds(355,485,150,30);
        ten_thousand.setBackground(Color.GRAY);
        ten_thousand.addActionListener(this);
        image.add(ten_thousand);
        
        back = new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD, 15));
        back.setBounds(355,520,150,25);
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        image.add(back);
        
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
        } else {
            String amount = ((JButton)a.getSource()).getText().substring(3);
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
                
                if(a.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawn Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            } catch (Exception e){
                System.out.println(e);
            }
            
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}

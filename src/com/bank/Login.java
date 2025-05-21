package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton signin, clear, signup;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    Login(){
        setTitle("ATM");

        setLayout(null);

        //Icon

        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/bank/images/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,110,98);
        add(label);

        //Welcome heading

        JLabel wel = new JLabel("Welcome!!");
        wel.setFont(new Font("Osward",Font.BOLD,38));
        wel.setBounds(300,40,400,40);
        add(wel);

        //Card Number

        JLabel cardno = new JLabel("Card No :");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(140,150,200,30);
        add(cardno);

        cardtextfield = new JTextField();
        cardtextfield.setBounds(300,150,260,30);
        cardtextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardtextfield);

        //Pin

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(140,180,200,30);
        add(pin);

        pintextfield = new JPasswordField();
        pintextfield.setBounds(300,180,260,30);
        pintextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintextfield);


        //Sign In Button

        signin = new JButton("SIGN IN");
        signin.setBounds(300, 240, 100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        //Clear Button

        clear = new JButton("CLEAR");
        clear.setBounds(460, 240, 100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        //Sign Up Button

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 280, 260,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent a){
        if(a.getSource() == clear){
            cardtextfield.setText("");
            pintextfield.setText("");
        } else if(a.getSource() == signin){
            Conn c = new Conn();
            String cardnumber = cardtextfield.getText();
            String pinnumber = pintextfield.getText();
            
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number of PIN");
                }
            } catch(Exception e){
                System.out.println(e);
            }
            
            
        } else if(a.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
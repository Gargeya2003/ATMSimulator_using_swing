
package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton savings, current,fdacc, rdacc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno){
        
        this.formno = formno;
        getContentPane().setBackground(Color.WHITE);
        setTitle("SIGN UP");
        setSize(800,750);
        setLocation(300,80);
        setLayout(null);
        
        setVisible(true);
        
        //Icon

        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/bank/images/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(30,10,110,98);
        add(label);
        
        //Title Of the page
        
        JLabel title = new JLabel("Account Details");
        title.setBounds(320,50,300,30);
        title.setFont(new Font("Raleway", Font.BOLD, 25));
        add(title);
        
        //Account Type
        
        JLabel type = new JLabel("Account Type");
        type.setBounds(100,140,200,24);
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        add(type);
        
        savings = new JRadioButton("Savings Account");
        savings.setFont(new Font("Raleway", Font.BOLD, 16));
        savings.setBackground(Color.WHITE);
        savings.setBounds(100,170,200,20);
        add(savings);
        
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBackground(Color.WHITE);
        current.setBounds(100,200,200,20);
        add(current);
        
        fdacc = new JRadioButton("Fixed Deposit Account");
        fdacc.setFont(new Font("Raleway", Font.BOLD, 16));
        fdacc.setBackground(Color.WHITE);
        fdacc.setBounds(300,170,200,20);
        add(fdacc);
        
        rdacc = new JRadioButton("Recurring Deposit Account");
        rdacc.setFont(new Font("Raleway", Font.BOLD, 16));
        rdacc.setBackground(Color.WHITE);
        rdacc.setBounds(300,200,300,20);
        add(rdacc);
        
        ButtonGroup accounts = new ButtonGroup();
        accounts.add(savings);
        accounts.add(current);
        accounts.add(fdacc);
        accounts.add(rdacc);
        
        JLabel cardno = new JLabel("Card Number:");
        cardno.setBounds(100,250,200,24);
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cardno);
        
        JLabel stmt = new JLabel("(Your 16 digit Card Number)");
        stmt.setBounds(100,272,200,24);
        stmt.setFont(new Font("Raleway", Font.BOLD, 12));
        add(stmt);
        
        JLabel card = new JLabel("XXXX-XXXX-XXXX-XXXX");
        card.setBounds(300,250,400,26);
        card.setFont(new Font("Raleway", Font.BOLD, 24));
        add(card);
        
        JLabel pinno = new JLabel("PIN:");
        pinno.setBounds(100,310,200,24);
        pinno.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pinno);
        
        JLabel stmt2 = new JLabel("(Your 4 digit Pin number)");
        stmt2.setBounds(100,332,200,24);
        stmt2.setFont(new Font("Raleway", Font.BOLD, 12));
        add(stmt2);
        
        JLabel pin = new JLabel("XXXX");
        pin.setBounds(300,310,200,26);
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        add(pin);
        
        JLabel ser = new JLabel("Services Required");
        ser.setBounds(100,370,200,24);
        ser.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ser);
        
        
        c1 = new JCheckBox("ATM Card");
        c1.setBounds(100,410,200,24);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(300,410,200,24);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(100,440,200,24);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBounds(300,440,200,24);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(100,470,200,24);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(300,470,200,24);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBounds(100,540,520,24);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.WHITE);
        add(c7);
        
        
        submit = new JButton("Submit");
        submit.setBounds(380,580,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(510,580,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == submit){
            String accountType = null;
            if(savings.isSelected()){
                accountType = "Savings Account";
            }else if(current.isSelected()){
                accountType = "Current Account";
            }else if(fdacc.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(rdacc.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            Random rand = new Random();
            String cardnumber = "" + Math.abs((rand.nextLong() % 900000000L) + 6117225000000000L);
            String pinnumber = "" + Math.abs((rand.nextLong() % 9000L) + 1000L);
            String _services = "";
            if(c1.isSelected()){
                _services += "ATM Card";
            }if(c2.isSelected()){
                _services += ", Internet Banking";
            }if(c3.isSelected()){
                _services += ", Mobile Banking";
            }if(c4.isSelected()){
                _services += ", Email & SMS Alerts";
            }if(c5.isSelected()){
                _services += ", Cheque Book";
            }if(c6.isSelected()){
                _services += ", E-Statement";
            }
            
            try{
                if(accountType == null || _services.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill in all the details");
                }else if(!c7.isSelected()){ 
                    JOptionPane.showMessageDialog(null, "Please Accept the declaration");
                    return;
                }
                else{
                    Conn c = new Conn();
                    String query1 = "insert into signup3 values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+_services+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n" + "PIN Number: " + pinnumber + "\n");
                }
                
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(a.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new SignupThree("");
    }
}

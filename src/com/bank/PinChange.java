
package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    
    JPasswordField newpin, renewpin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/bank/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel pinchange = new JLabel("CHANGE YOUR PIN");
        pinchange.setFont(new Font("Raleway",Font.BOLD, 20));
        pinchange.setBounds(240,300,200,30);
        pinchange.setForeground(Color.WHITE);
        image.add(pinchange);
        
        JLabel pintext = new JLabel("ENTER NEW PIN:");
        pintext.setFont(new Font("Raleway",Font.BOLD, 15));
        pintext.setBounds(165,340,300,20);
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        newpin = new JPasswordField();
        newpin.setFont(new Font("Raleway",Font.BOLD, 15));
        newpin.setBounds(330,340,150,20);
        newpin.setBackground(Color.WHITE);
        image.add(newpin);
        
        JLabel _pintext = new JLabel("RE-ENTER NEW PIN:");
        _pintext.setFont(new Font("Raleway",Font.BOLD, 15));
        _pintext.setBounds(165,370,300,20);
        _pintext.setForeground(Color.WHITE);
        image.add(_pintext);
        
        renewpin = new JPasswordField();
        renewpin.setFont(new Font("Raleway",Font.BOLD, 15));
        renewpin.setBounds(330,370,150,20);
        renewpin.setBackground(Color.WHITE);
        image.add(renewpin);
        
        change = new JButton("CHANGE");
        change.setFont(new Font("Raleway",Font.BOLD, 15));
        change.setBounds(355,485,150,25);
        change.setBackground(Color.GRAY);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD, 15));
        back.setBounds(355,520,150,25);
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        image.add(back);
        
        
        setLayout(null);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
        setLocation(300,0);
    }
    
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == change){
            try{
                String pin = newpin.getText();
                String _pin = renewpin.getText();
                
                if(!_pin.equals(pin)){
                    JOptionPane.showMessageDialog(null, "Entered PINs do not match");
                    return;
                }
                
                if (pin == null){
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                    return;
                }
                
                if (_pin == null){
                    JOptionPane.showMessageDialog(null, "Please Re-enter new PIN");
                    return;
                }
                
                Conn c = new Conn();
                String query = "update bank set pin = '"+_pin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+_pin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signup3 set pin = '"+_pin+"' where pin = '"+pinnumber+"'";
                
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(_pin).setVisible(true);

                    
            } catch (Exception e){
                System.out.println(e);
            }
        } else if(a.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("");
    }
}

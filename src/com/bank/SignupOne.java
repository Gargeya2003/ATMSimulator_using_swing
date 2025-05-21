package com.bank;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{

    long appno;
    JTextField nametextfield, fnametextfield, etextfield, addtextfield, ctextfield, statetextfield, pintextfield;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignupOne(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);


        setTitle("SIGN UP");
        setSize(850,800);
        setLocation(300,80);
        setVisible(true);

        //Icon

        ImageIcon i1 = new ImageIcon(getClass().getResource("/com/bank/images/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(30,10,110,98);
        add(label);

        //Title of the page

        Random ran = new Random();
        appno = Math.abs(ran.nextLong() % 9000L + 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + appno);

        formno.setFont(new Font("Arial", Font.BOLD,30));
        formno.setBounds(200,30,600,40);
        add(formno);

        JLabel title = new JLabel("Personal Details");
        title.setBounds(320,80,300,30);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        add(title);

        // Name

        JLabel name = new JLabel("Full Name:");
        name.setBounds(100,140,200,20);
        name.setFont(new Font("Arial", Font.BOLD, 20));
        add(name);

        nametextfield = new JTextField();
        nametextfield.setBounds(320,140,300,20);
        nametextfield.setFont(new Font("Arial", Font.BOLD, 20));
        add(nametextfield);

        //Father's Name

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100,180,200,20);
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        add(fname);

        fnametextfield = new JTextField();
        fnametextfield.setBounds(320,180,300,20);
        fnametextfield.setFont(new Font("Arial", Font.BOLD, 20));
        add(fnametextfield);

        //DOB

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100,220,150,20);
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(320, 220, 200, 20);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        //Gender

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100,260,150,20);
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(320,260,70,20);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(430,260,70,20);
        female.setBackground(Color.WHITE);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(550,260,70,20);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

        //Email Address

        JLabel email = new JLabel("Email Address:");
        email.setBounds(100,300,200,20);
        email.setFont(new Font("Arial", Font.BOLD, 20));
        add(email);

        etextfield = new JTextField();
        etextfield.setBounds(320,300,300,20);
        etextfield.setFont(new Font("Arial", Font.BOLD, 20));
        add(etextfield);

        //Marital Status

        JLabel mstat = new JLabel("Marital Status:");
        mstat.setBounds(100,340,200,20);
        mstat.setFont(new Font("Arial", Font.BOLD, 20));
        add(mstat);

        married = new JRadioButton("Married");
        married.setBounds(320,340,70,20);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,340,90,20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup margroup = new ButtonGroup();
        margroup.add(married);
        margroup.add(unmarried);

        //Address

        JLabel address = new JLabel("Address:");
        address.setBounds(100,380,200,20);
        address.setFont(new Font("Arial", Font.BOLD, 20));
        add(address);

        addtextfield = new JTextField();
        addtextfield.setBounds(320,380,300,20);
        addtextfield.setFont(new Font("Arial", Font.BOLD, 20));
        add(addtextfield);

        //City

        JLabel city = new JLabel("City:");
        city.setBounds(100,420,200,20);
        city.setFont(new Font("Arial", Font.BOLD, 20));
        add(city);

        ctextfield = new JTextField();
        ctextfield.setBounds(320,420,300,20);
        ctextfield.setFont(new Font("Arial", Font.BOLD, 20));
        add(ctextfield);

        //State

        JLabel state = new JLabel("State:");
        state.setBounds(100,460,200,20);
        state.setFont(new Font("Arial", Font.BOLD, 20));
        add(state);

        statetextfield = new JTextField();
        statetextfield.setBounds(320,460,300,20);
        statetextfield.setFont(new Font("Arial", Font.BOLD, 20));
        add(statetextfield);

        //Pincode

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(100,500,200,20);
        pin.setFont(new Font("Arial", Font.BOLD, 20));
        add(pin);

        pintextfield = new JTextField();
        pintextfield.setBounds(320,500,300,20);
        pintextfield.setFont(new Font("Arial", Font.BOLD, 20));
        add(pintextfield);

        //Next

        next = new JButton("Next");
        next.setBounds(550,550,70,30);
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent a){
        String formno = "" + appno;
        String name = nametextfield.getText();
        String fname = fnametextfield.getText();
        String email = etextfield.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        else if(other.isSelected()){
            gender= "Other";
        }
        String marstat = null;
        if(married.isSelected()){
            marstat = "Married";
        }
        else if(unmarried.isSelected()){
            marstat = "Unmarried";
        }

        String address = addtextfield.getText();
        String city = ctextfield.getText();
        String state = statetextfield.getText();
        String pincode = pintextfield.getText();

        try{
            if(name.equals("")|| fname.equals("") || dob.equals("") || gender == null || marstat == null || email.equals("") || city.equals("") || state.equals("") || address.equals("") || pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marstat+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupOne();
    }
}

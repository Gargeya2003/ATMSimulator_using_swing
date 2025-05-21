package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class SignupTwo extends JFrame implements ActionListener{

    JTextField pantextfield, aadharfield;
    JButton next;
    JRadioButton senyes, senno, accyes, accno;
    JComboBox religionbox, catbox, incbox, edubox, occbox;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
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

        JLabel title = new JLabel("Additional Details");
        title.setBounds(320,50,300,30);
        title.setFont(new Font("Raleway", Font.BOLD, 25));
        add(title);

        // Religion

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100,140,200,24);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);
        
        String regvalues[] = {"Hindu", "Muslim", "Christian", "Sikh", "Jain", "Other"};
        religionbox = new JComboBox(regvalues);
        religionbox.setBounds(320,140,300,20);
        religionbox.setFont(new Font("Raleway", Font.BOLD, 14));
        religionbox.setBackground(Color.WHITE);
        add(religionbox);
        

        //Category

        JLabel category = new JLabel("Category:");
        category.setBounds(100,180,200,24);
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        add(category);

        String catvalues[] = {"GEN", "GEN-EWS", "OBC", "OBC-NC", "SC", "ST","PwD"};
        catbox = new JComboBox(catvalues);
        catbox.setBounds(320,180,300,20);
        catbox.setFont(new Font("Raleway", Font.BOLD, 14));
        catbox.setBackground(Color.WHITE);
        add(catbox);

        //Income

        JLabel income = new JLabel("Income:");
        income.setBounds(100,220,150,20);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        add(income);

        String incvalues[] = {"NA", "< 1,50,000", "< 2,50,000", "< 5,00,000", "< 10,00,000", ">= 10,00,000"};
        incbox = new JComboBox(incvalues);
        incbox.setBounds(320,220,300,20);
        incbox.setFont(new Font("Raleway", Font.BOLD, 14));
        incbox.setBackground(Color.WHITE);
        add(incbox);

        //Educational Qualification

        JLabel education = new JLabel("Educational");
        education.setBounds(100,260,150,20);
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        add(education);

        JLabel email = new JLabel("Qualification:");
        email.setBounds(100,280,200,20);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);

        String eduvalues[] = {"10th", "12th", "Graduate", "Post-Graduate", "PhD", "Others"};
        edubox = new JComboBox(eduvalues);
        edubox.setBounds(320,280,300,20);
        edubox.setFont(new Font("Raleway", Font.BOLD, 14));
        edubox.setBackground(Color.WHITE);
        add(edubox);

        //Occupation

        JLabel mstat = new JLabel("Occupation:");
        mstat.setBounds(100,340,200,20);
        mstat.setFont(new Font("Raleway", Font.BOLD, 20));
        add(mstat);

        String occvalues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occbox = new JComboBox(occvalues);
        occbox.setBounds(320,340,300,20);
        occbox.setFont(new Font("Raleway", Font.BOLD, 14));
        occbox.setBackground(Color.WHITE);
        add(occbox);

        //PAN Number

        JLabel panno = new JLabel("PAN Number:");
        panno.setBounds(100,380,200,20);
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        add(panno);

        pantextfield = new JTextField();
        pantextfield.setBounds(320,380,300,20);
        pantextfield.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pantextfield);

        //Aadhar Number

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(100,420,200,20);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(aadhar);

        aadharfield = new JTextField();
        aadharfield.setBounds(320,420,300,20);
        aadharfield.setFont(new Font("Raleway", Font.BOLD, 20));
        add(aadharfield);

        //Senior Citizen

        JLabel state = new JLabel("Senior Citizen:");
        state.setBounds(100,460,200,20);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add(state);

        senyes = new JRadioButton("Yes");
        senyes.setBounds(320,460,100,20);
        senyes.setBackground(Color.WHITE);
        add(senyes);
        
        senno = new JRadioButton("No");
        senno.setBounds(420,460,100,20);
        senno.setBackground(Color.WHITE);
        add(senno);
        
        ButtonGroup sengroup = new ButtonGroup();
        sengroup.add(senyes);
        sengroup.add(senno);
        
        //Existing Account

        JLabel acc = new JLabel("Existing Account:");
        acc.setBounds(100,500,200,20);
        acc.setFont(new Font("Raleway", Font.BOLD, 20));
        add(acc);

        accyes = new JRadioButton("Yes");
        accyes.setBounds(320,500,100,20);
        accyes.setBackground(Color.WHITE);
        add(accyes);
        
        accno = new JRadioButton("No");
        accno.setBounds(420,500,100,20);
        accno.setBackground(Color.WHITE);
        add(accno);
        
        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(accyes);
        accgroup.add(accno);

        //Next

        next = new JButton("Next");
        next.setBounds(550,550,70,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent a){
        String sreligion = (String) religionbox.getSelectedItem();
        String scat = (String) catbox.getSelectedItem();
        String sinc = (String) incbox.getSelectedItem();
        String sedu = (String) edubox.getSelectedItem();
        String socc = (String) occbox.getSelectedItem();
        String span = pantextfield.getText();
        String saadhar = aadharfield.getText();
        
        String sen = null;
        if(senyes.isSelected()){
            sen = "Yes";
        }
        else if(senno.isSelected()){
            sen = "No";
        }
        
        String acc = null;
        if(accyes.isSelected()){
            acc = "Yes";
        }
        else if(accno.isSelected()){
            acc = "No";
        }

        try{
            if(span.equals("") || saadhar.equals("") || acc == null || sen == null){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup2 values('"+formno+"', '"+sreligion+"', '"+scat+"', '"+sinc+"', '"+sedu+"', '"+socc+"', '"+span+"', '"+saadhar+"', '"+sen+"', '"+acc+"')";
                c.s.executeUpdate(query);
                
                new SignupThree(formno).setVisible(true);
                setVisible(false);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}

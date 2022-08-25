package transactions;
import dashboards.*;
import loginsignups.Welcome;

import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;



public class Recipt extends Payment implements ActionListener {
    
    //attributes
    protected JFrame frame;

    protected JLabel labelReciptIcon;

    protected JButton BtnSig;
    protected JButton BtnAcNo;
    //protected JButton BtnProCo;
    protected JButton BtnBalance;

    protected JButton BtnHBackToHome;

    protected JLabel accountnoJlabel;

    Recipt(String tempAno, String tempSig, String tempbal){


        setVisibleSuper();
        




        //Frame Creation
        frame = new JFrame("Recipt");


        accountnoJlabel = new JLabel("Account No : ");
        accountnoJlabel.setBounds(120, 200, 100, 30);
        frame.add(accountnoJlabel);



        //JButton Components
        BtnAcNo = new JButton(tempAno);
        BtnAcNo.setBounds(100, 200, 250, 30);
        BtnAcNo.setFocusPainted(false);
        BtnAcNo.setBorder(null);
        BtnAcNo.setContentAreaFilled(false);
        frame.add(BtnAcNo);


        BtnBalance = new JButton(tempbal);
        BtnBalance.setBounds(220, 255, 250, 30);
        BtnBalance.setFocusPainted(false);
        BtnBalance.setBorder(null);
        BtnBalance.setContentAreaFilled(false);
        frame.add(BtnBalance);



        //BtnProCo = new JButton(tempProCo);
       // BtnProCo.setBounds(60, 255, 250, 30);
        //BtnProCo.setFocusPainted(false);
        //BtnProCo.setBorder(null);
       // BtnProCo.setContentAreaFilled(false);
        //frame.add(BtnProCo);


        BtnSig = new JButton(tempSig);
        BtnSig.setBounds(460, 385, 250, 30);
        BtnSig.setFocusPainted(false);
        BtnSig.setBorder(null);
        BtnSig.setContentAreaFilled(false);
        frame.add(BtnSig);



        BtnHBackToHome = new JButton("Back to home");
        BtnHBackToHome.setBounds(270, 500, 200, 30);
        BtnHBackToHome.setFocusPainted(false);
        BtnHBackToHome.setBackground(Color.red);
        BtnHBackToHome.setForeground(Color.white);
        BtnHBackToHome.addActionListener(this);
        frame.add(BtnHBackToHome);



        labelReciptIcon = new JLabel();
        labelReciptIcon.setIcon(new ImageIcon("images/reciptlogo.jpg"));
        labelReciptIcon.setBounds(70, 0, 645, 499);
        frame.add(labelReciptIcon);               // in the last





        //Frame Details
        frame.setSize(800, 580);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




        
        //Frame Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("valorant.png");
        frame.setIconImage(icon);
    }



    public void actionPerformed(ActionEvent e){
        if(e.getSource()==BtnHBackToHome){
            frame.setVisible(false);
            new Welcome();
        }
    }






}

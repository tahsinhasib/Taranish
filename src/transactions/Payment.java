package transactions;
import dashboards.*;

import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class Payment implements ActionListener {
    
    //attributes
    private JFrame frame;


    private JLabel labelPayMethod;     
    private JLabel labelCardNumber;
    private JLabel labelCVVNum;
    private JLabel labelPass;
    private JLabel labelAmount;
    //private JLabel labelProductCode;
    private JLabel labelSig;


    private JButton BtnPayNow;



    private JTextField TFCardNum;
    private JTextField TFcvvNum;
    private JTextField TFAmount;
    private JPasswordField PFpass;
    //protected JTextField TFproductCode;
    protected JTextField TFsig;


    private JRadioButton rb1, rb2, rb3, rb4, rb5;
    private ButtonGroup grp;


    //actionlistener temp data
    protected String paymentcardnumber;
    protected String paymentcvvnumber;
    protected String paymentpassword;
    protected String paymentSig;
    protected String paymentProductCode;
    protected String paymentAmount;



    private JLabel labelPageLogo;        //page logo




    public Payment(){

        //Frame Creation
        frame = new JFrame("Payment");






        //JRadioButton components
        rb1 = new JRadioButton();
        rb2 = new JRadioButton();
        rb3 = new JRadioButton();
        rb4 = new JRadioButton();
        rb5 = new JRadioButton();
        grp = new ButtonGroup();
        grp.add(rb1);
        grp.add(rb2);
        grp.add(rb3);
        grp.add(rb4);
        grp.add(rb5);







        //JTextField, JPassField Components
        TFCardNum = new JTextField();
        TFcvvNum = new JTextField();
        PFpass = new JPasswordField();
        TFAmount = new JTextField();
        //TFproductCode =  new JTextField();
        TFsig = new JTextField();





        //JButton Components
        BtnPayNow = new JButton("Pay Now!");







        //JLabel Components
        labelPayMethod = new JLabel("Payment Method");
        labelCardNumber = new JLabel("Card Number");
        labelCVVNum = new JLabel("CVV Number");
        labelPass = new JLabel("Password");
        labelAmount = new JLabel("Enter amount");
        //labelProductCode = new JLabel("Product code");
        labelSig = new JLabel("Signature");
        //////////////////////////////
        labelPageLogo = new JLabel();
        labelPageLogo.setIcon(new ImageIcon("images/payment.jpg"));




        //colors, shapes styles
        rb1.setFocusPainted(false);
        rb1.setOpaque(false);
        rb2.setFocusPainted(false);
        rb2.setOpaque(false);
        rb3.setFocusPainted(false);
        rb3.setOpaque(false);
        rb4.setFocusPainted(false);
        rb4.setOpaque(false);
        rb5.setFocusPainted(false);
        rb5.setOpaque(false);
        BtnPayNow.setBackground(Color.blue);
        BtnPayNow.setForeground(Color.white);
        BtnPayNow.setFocusPainted(false);






        //Allignments
        BtnPayNow.setBounds(180, 430, 90, 30);
        TFCardNum.setBounds(145, 270, 250, 30);
        TFcvvNum.setBounds(145, 330, 180, 30);
        TFAmount.setBounds(700, 330, 130, 30);
        TFAmount.setHorizontalAlignment(JTextField.CENTER);
        //TFproductCode.setBounds(470, 330, 80, 30);
        //TFproductCode.setHorizontalAlignment(JTextField.CENTER);
        TFsig.setBounds(700, 380, 130, 30);
        PFpass.setBounds(145, 390, 180, 30);
        rb1.setBounds(145, 200, 50, 20);
        rb2.setBounds(220, 200, 50, 20);
        rb3.setBounds(295, 200, 50, 20);
        rb4.setBounds(370, 200, 50, 20);
        rb5.setBounds(445, 200, 50, 20);
        labelPayMethod.setBounds(150, 150, 500, 30);
        labelCardNumber.setBounds(150, 240, 500, 30);
        labelCVVNum.setBounds(150, 300, 500, 30);
        labelPass.setBounds(150, 360, 500, 30);
        labelAmount.setBounds(720, 300, 500, 30);
        //labelProductCode.setBounds(470, 300, 500, 30);
        labelSig.setBounds(725, 420, 500, 30);
        labelPageLogo.setBounds(0, 0, 980, 560);        //in the last








        //Action Listener
        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);
        rb4.addActionListener(this);
        rb5.addActionListener(this);
        BtnPayNow.addActionListener(this);




        //Adding in Frame
        frame.add(rb1);
        frame.add(rb2);
        frame.add(rb3);
        frame.add(rb4);
        frame.add(rb5);
        frame.add(TFCardNum);
        frame.add(TFcvvNum);
        frame.add(TFAmount);
        //frame.add(TFproductCode);
        frame.add(PFpass);
        frame.add(TFsig);
        frame.add(labelSig);
        frame.add(BtnPayNow);
        frame.add(labelPayMethod);
        frame.add(labelCardNumber);
        frame.add(labelCVVNum);
        frame.add(labelPass);
        frame.add(labelAmount);
        //frame.add(labelProductCode);
        frame.add(labelPageLogo);               //in the last




        //Frame Details
        frame.setSize(995, 598);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




        //Frame Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("valorant.png");
        frame.setIconImage(icon);


    }



    public void actionPerformed(ActionEvent e){
        paymentcardnumber = TFCardNum.getText();
        paymentcvvnumber = TFcvvNum.getText();
        paymentpassword = PFpass.getText();
        paymentSig = TFsig.getText();
        //paymentProductCode = TFproductCode.getText();
        paymentAmount = TFAmount.getText();


            if(grp.isSelected(null) || paymentcardnumber.isEmpty() || paymentcvvnumber.isEmpty() || paymentpassword.isEmpty()
                || paymentSig.isEmpty() || paymentAmount.isEmpty()){
                if(e.getSource()==BtnPayNow){
                    new ConfirmationFailed();
                }
            }
            else{
                if(e.getSource()==BtnPayNow){
                    frame.setVisible(false);
                    new ConfirmationSuccess(paymentcardnumber, paymentSig, paymentAmount);
                }
            }
        }


        public void setVisibleSuper(){
            frame.setVisible(false);
        }
        
        
    }



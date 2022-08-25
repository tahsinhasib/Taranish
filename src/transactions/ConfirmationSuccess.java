package transactions;
import dashboards.*;

import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;




public class ConfirmationSuccess extends Payment implements ActionListener {
    

    //attributes
    private JFrame frame;

    protected JLabel labelpaySucc;


    protected JButton BtnContinue;

    protected String tempSig;
    protected String tempAno;
    //protected String tempProCo;
    protected String tempbal;


    ConfirmationSuccess(String paymentcardnumber, String paymentSig, String paymentAmount){


        /*
         * inhertence is used to store the string in the 'temp' variable of
         * ConfirmationSuccess class. Again passing the var for displaying in
         * recipt in the Recipt frame through constructor passing.
         */


        setVisibleSuper();      //disables base frame 


        tempSig = paymentSig;
        tempAno = paymentcardnumber;
        //tempProCo = paymentProductCode;
        tempbal = paymentAmount;






        //Frame Creation
        frame = new JFrame("Confirmation Successful");



        //JButton Components
        BtnContinue = new JButton("Continue");







        //Color, shapes sizes
        BtnContinue.setBorder(null);
        BtnContinue.setBounds(130, 408, 120, 30);
        BtnContinue.setContentAreaFilled(false);   // rectangular button mark
        BtnContinue.setForeground(Color.green);
        BtnContinue.setFocusPainted(false);
        BtnContinue.addActionListener(this);
        frame.add(BtnContinue);










        




        //JLabel Components
        labelpaySucc = new JLabel();
        labelpaySucc.setIcon(new ImageIcon("images/paymentSuccess.png"));  //in the last
        labelpaySucc.setBounds(0, 0, 385, 596);     //in the last
        frame.add(labelpaySucc);













        //Frame Details
        frame.setSize(400, 630);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        //Frame Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("paylogo.jpg");
        frame.setIconImage(icon);


    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource()==BtnContinue){
            frame.setVisible(false);
            new Recipt(tempAno, tempSig, tempbal);
        }
    }


}

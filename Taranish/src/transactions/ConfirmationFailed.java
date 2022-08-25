package transactions;
import dashboards.*;

import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;



public class ConfirmationFailed implements ActionListener {
    

    //attributes
    private JFrame frame;

    protected JLabel labelpayFail;


    protected JButton BtnRetry;


    ConfirmationFailed() {

        //Frame Creation
        frame = new JFrame("Confirmation Failed");



        //JButton Components
        BtnRetry = new JButton("Retry");





        //JLabel Components
        labelpayFail = new JLabel();
        labelpayFail.setIcon(new ImageIcon("images/paymentFailed.png"));  //in the last








        //Color, shapes sizes
        BtnRetry.setBorder(null);
        BtnRetry.setContentAreaFilled(false);   // rectangular button mark
        BtnRetry.setForeground(Color.red);
        BtnRetry.setFocusPainted(false);






        //Allignments
        BtnRetry.setBounds(130, 408, 120, 30);
        labelpayFail.setBounds(0, 0, 378, 596);     //in the last






        //Action listener
        BtnRetry.addActionListener(this);






        //adding in frames
        frame.add(BtnRetry);
        frame.add(labelpayFail);        //in the last










        //Frame Details
        frame.setSize(390, 630);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




        //Frame Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("paylogo.jpg");
        frame.setIconImage(icon);



    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource()==BtnRetry){
            frame.dispose();
        }
    }




}

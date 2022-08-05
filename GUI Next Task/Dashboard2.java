import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;


public class Dashboard2 implements ActionListener{
    //attributes
    private JFrame frame;
    private JLabel lblDBlogo2;

    private JLabel lblUserInfo;

    private JButton BtnUser;    //the user info.....

    private JButton BtnPrev;
    private JButton BtnLogOut;
    private JButton BtnExit;


    Dashboard2(String userpassing){

        //setting frames
        frame = new JFrame();


        //JButton components
        BtnPrev = new JButton("Previous");
        BtnLogOut = new JButton("Log out");
        BtnExit = new JButton("Exit");
        BtnUser = new JButton(userpassing);



        //JLabel components
        lblUserInfo = new JLabel("* Showing user info");



        //Color, shapes, outlines
        lblUserInfo.setForeground(Color.white);
        BtnPrev.setForeground(Color.white);
        BtnLogOut.setForeground(Color.white);
        BtnPrev.setBackground(Color.blue);
        BtnLogOut.setBackground(Color.red);
        BtnPrev.setFocusPainted(false);
        BtnLogOut.setFocusPainted(false);
        BtnExit.setBackground(Color.red);
        BtnExit.setForeground(Color.white);
        BtnExit.setFocusPainted(false);
        BtnUser.setFocusPainted(false);
        BtnUser.setForeground(Color.black);





        //JLabel for logos and pictures
        lblDBlogo2 = new JLabel();
        lblDBlogo2.setIcon(new ImageIcon("dblogo2.jpg"));
        



        /*_______________LIFE TIP_________________
         * Nothing can be alligned before creating 
         * 
         */





        //Allignments
        BtnPrev.setBounds(60, 500, 100, 30);
        BtnLogOut.setBounds(750, 500, 80, 30);
        BtnExit.setBounds(750, 50, 80, 30);
        lblUserInfo.setBounds(40, 20, 280, 30);
        BtnUser.setBounds(50, 50, 160, 30);

        lblDBlogo2.setBounds(0, 0, 900, 600);



        //Action Listener components
        BtnPrev.addActionListener(this);
        BtnLogOut.addActionListener(this);
        BtnExit.addActionListener(this);
        



        //Adding everything in frames
        frame.add(BtnPrev);
        frame.add(BtnLogOut);
        frame.add(BtnExit);
        frame.add(lblUserInfo);
        frame.add(BtnUser);

        frame.add(lblDBlogo2);




        //setting frame details (needed to be done in the last before icon)
        frame.setSize(900, 600);
        frame.setLayout(null);              //improper adjustment can cause issue of labels thus needed to be written above over other functions
        frame.setLocationRelativeTo(null);
        frame.setTitle("Dashboard2");
        frame.setVisible(true);




        //frame icon
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
        frame.setIconImage(icon);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==BtnPrev){
            String user = BtnUser.getText();                //getting text from that button
            frame.setVisible(false);
            new Dashboard1(user);
        }
        else if(e.getSource()==BtnLogOut){
            frame.setVisible(false);
            new Login();
        }
        else if(e.getSource()==BtnExit){
            System.exit(0);
        }
    }


}

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Dashboard1 implements ActionListener{
    //attributes
    private JFrame frame;
    private JLabel lblDBlogo;


    private JButton BtnNext;
    private JButton BtnPrev;
    private JButton BtnExit;

    private JLabel lblGender;
    private JLabel lblAgentMain;
    private JLabel lblExp;

    private JRadioButton r1, r2;
    private ButtonGroup grp;
    private JCheckBox cb1, cb2, cb3;

    private JComboBox cmb;

    public String userpassing;   // this will help to jump over another frame. Storing the value of user





    Dashboard1(String user){

        userpassing = user;


        String experience[] = new String[] {"Noob", "Amature", "Professional"};

        //settting frames
        frame = new JFrame();




        //JLabel components
        lblGender = new JLabel("* Please select your gender from below");
        lblAgentMain = new JLabel("* Please select the Agents you want to main from below");
        lblExp = new JLabel("* Please provide your experience");



        //JButton components
        BtnNext = new JButton("Next");
        BtnPrev = new JButton("Previous");
        BtnExit = new JButton("Exit");


        //JRadioButton components
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        grp = new ButtonGroup();
        grp.add(r1);
        grp.add(r2);


        //JCheckbox components
        cb1 = new JCheckBox("Jett");
        cb2 = new JCheckBox("Sage");
        cb3 = new JCheckBox("Reyna");


        //JComboBox components
        cmb = new JComboBox<>(experience);





        //Colors, Borders, Shapes
        lblGender.setForeground(Color.white);
        lblAgentMain.setForeground(Color.white);
        lblExp.setForeground(Color.white);
        BtnExit.setForeground(Color.white);
        BtnNext.setForeground(Color.white);
        BtnPrev.setForeground(Color.white);
        BtnExit.setFocusPainted(false);
        BtnNext.setFocusPainted(false);
        BtnPrev.setFocusPainted(false);
        BtnExit.setBackground(Color.red);
        BtnNext.setBackground(Color.blue);
        BtnPrev.setBackground(Color.blue);
        r1.setFocusPainted(false);
        r1.setForeground(Color.white);
        r1.setOpaque(false);
        r2.setFocusPainted(false);
        r2.setForeground(Color.white);
        r2.setOpaque(false);
        cb1.setFocusPainted(false);
        cb1.setForeground(Color.white);
        cb1.setOpaque(false);
        cb2.setFocusPainted(false);
        cb2.setForeground(Color.white);
        cb2.setOpaque(false);
        cb3.setFocusPainted(false);
        cb3.setForeground(Color.white);
        cb3.setOpaque(false);
        cmb.setOpaque(false);
        cmb.setForeground(Color.white);
        cmb.setBackground(Color.black);



        //JLabel for logos and pictures
        lblDBlogo = new JLabel();                                   // this need to be add last
        lblDBlogo.setIcon(new ImageIcon("dblogo.jpg"));






        /*_______________LIFE TIP_________________
         * Nothing can be alligned before creating 
         * 
         */



         

        //Allignments
        BtnNext.setBounds(750, 500, 80, 30);
        BtnPrev.setBounds(60, 500, 100, 30);
        BtnExit.setBounds(750, 25, 80, 30);
        lblGender.setBounds(60, 90, 280, 30);        //please select gen.........
        lblAgentMain.setBounds(60, 220, 360, 30);    //please select main agent....
        lblExp.setBounds(60, 380, 360, 30);          //please select experience....
        r1.setBounds(75, 130, 100, 20);
        r2.setBounds(75, 180, 100, 20);
        cb1.setBounds(75, 260, 80, 20);
        cb2.setBounds(75, 300, 80, 20);
        cb3.setBounds(75, 340, 80, 20);
        cmb.setBounds(75, 415, 120, 20);

        lblDBlogo.setBounds(0, 0, 900, 600);



        //Action Listener
        BtnNext.addActionListener(this);
        BtnExit.addActionListener(this);
        BtnPrev.addActionListener(this);




        //Adding everything in frames
        frame.add(BtnNext);
        frame.add(BtnPrev);
        frame.add(BtnExit);
        frame.add(lblGender);
        frame.add(lblAgentMain);
        frame.add(lblExp);
        frame.add(r1);
        frame.add(r2);
        frame.add(cb1);
        frame.add(cb2);
        frame.add(cb3);
        frame.add(cmb);

        frame.add(lblDBlogo);        // this is need to be added last




        //setting frame details (needed to be done in the last before icon)
        frame.setSize(900, 600);
        frame.setLayout(null);              //improper adjustment can cause issue of labels thus needed to be written above over other functions
        frame.setLocationRelativeTo(null);
        frame.setTitle("Dashboard1");
        frame.setVisible(true);




        //frame icon
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
        frame.setIconImage(icon);


    }



    public void actionPerformed(ActionEvent e){
        if(e.getSource()==BtnNext){
            frame.setVisible(false);
            new Dashboard2(userpassing);
        }
        else if(e.getSource()==BtnExit){
            System.exit(0);
        }
        else if(e.getSource()==BtnPrev){
            frame.setVisible(false);
            new Login();
        }
    }







}

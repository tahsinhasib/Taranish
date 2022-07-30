import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.event.*;
import java.util.function.IntFunction;
import java.awt.Color;  
import java.awt.*;

public class HomePage implements ActionListener {  

    JFrame f;
	JLabel Name;
    JLabel Id;
    JLabel MyPicture;

    JButton back;
    JButton Exit;
    JButton GoToRegistration;

    HomePage(){  

        f = new JFrame();
        back = new JButton(); 
        Exit = new JButton();

        Color ForButtonInLoginPage = new Color(18,82,255);
        Color ForButtonInHomePage = new Color(255, 0, 0);

        Font ButtonFont = new Font("Arial Black", Font.BOLD, 12);

        //----------------------------------------------------- Color Adjustments
        Color lightBlue = new Color(51,153,255);
        f.getContentPane().setBackground(lightBlue);

        //-------------------------------------------------- JPanel Borders
        JPanel border = new JPanel();
        border.setBounds(10,10,565,340);
        border.setBackground(lightBlue);
        border.setBorder(BorderFactory.createLineBorder(Color.white,4,true));

        //------------------------------------------------------ JLabel
		Name = new JLabel("Name :       Md. Tahsin Hasib");
        Id = new JLabel("ID        :       22-46026-1");
		Name.setBounds(230,50,250,20);
        Id.setBounds(230,70,250,20);


        MyPicture = new JLabel();
        MyPicture.setIcon(new ImageIcon("tahsin.jpg"));
        MyPicture.setBounds(20, 20, 180, 200);
        
        //------------------------------------------------------ JButton
        back = new JButton("Back");
        back.setBounds(35, 300, 70, 30);
        back.setBackground(ForButtonInLoginPage); 
        back.addActionListener(this);
        back.setForeground(Color.white);
        back.setFont(ButtonFont);
        back.setFocusPainted(false);       // removes the selection border

        
        Exit = new JButton("Exit");
        Exit.setBounds(480, 300, 70, 30);
        Exit.setBackground(ForButtonInLoginPage); 
        Exit.addActionListener(this);
        Exit.setForeground(Color.white);
        Exit.setFont(ButtonFont);
        Exit.setFocusPainted(false);       // removes the selection border

        GoToRegistration = new JButton("Go to Registration");
        GoToRegistration.setBounds(230, 180, 190, 30);
        GoToRegistration.setBackground(ForButtonInHomePage);
        GoToRegistration.setForeground(Color.white);
        GoToRegistration.setFont(ButtonFont);
        GoToRegistration.setFocusPainted(false);
        

		
        //------------------------------------------------ Adding in Frame
		f.add(Name);
        f.add(Id);
        f.add(MyPicture);
        f.add(back);
        f.add(Exit);
        f.add(GoToRegistration);
        f.add(border);
        
        //----------------------------------------------- JFrame settings
        f.setTitle("American International University Bangladesh");
        f.setSize(600,400);  
        f.setLocationRelativeTo(null);
        f.setLayout(null);  
        f.setVisible(true);  
        f.getContentPane().setBackground(lightBlue);

        


        //---------------------------------------- Icon Settings
        Image icon = Toolkit.getDefaultToolkit().getImage("aiub icon.PNG");
        f.setIconImage(icon);
        f.setLayout(null);
        f.setSize(600,400);
        f.setVisible(true);
    }         


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            f.setVisible(false);

            new LoginPage();
        }

        //-------------------------------------- For exiting from the program clicking "Exit"
        if(e.getSource() == Exit){
            System.exit(0);
        }
    }


    
      
}
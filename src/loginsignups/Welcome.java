package loginsignups;
import dashboards.*;
import transactions.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Welcome implements ActionListener
{  
    
	JFrame mainFrame;

    JLabel userNameLabel, passWordLabel, imageLabel;
	
	JTextField userNameTextField;  
    
	JPasswordField passWordField;
	
    JButton login, signup, exit;
    
    Icon icon = new ImageIcon("images/welcomelogo.jpg"); 
	
    
    public Welcome()
    {  
        mainFrame= new JFrame("Welcome");
        
        //labels
        imageLabel = new JLabel();
        imageLabel.setBounds(0,0,980,560);
        imageLabel.setIcon(icon);
        
		userNameLabel = new JLabel("Username");
		userNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		userNameLabel.setForeground(Color.white);
		userNameLabel.setBounds(350,40,300,40);

		passWordLabel = new JLabel("Password");
		passWordLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		passWordLabel.setForeground(Color.white);
		passWordLabel.setBounds(350,400,300,40); 		
		 
        // buttons 
        login=new JButton("Login");  
        login.setBounds(525, 350, 290, 30);
        login.setForeground(Color.white);
        login.setBackground(Color.BLUE);
        login.setFocusPainted(false);
        login.setOpaque(true);
        login.addActionListener(this);
        
        signup = new JButton("Signup");
        signup.setBounds(175, 350, 290, 30);
        signup.setForeground(Color.black);
        signup.setBackground(Color.GREEN);
        signup.setFocusPainted(false);
        signup.setOpaque(true);
        signup.addActionListener(this);
        
        exit = new JButton("Exit");
        exit.setBounds(395, 450, 200, 30);
        exit.setForeground(Color.white);
        exit.setBackground(Color.red);
        exit.setFocusPainted(false);
        exit.setOpaque(true);
        exit.addActionListener(this);
		
        //adding to mainframe
        mainFrame.add(login);
        mainFrame.add(signup);
        mainFrame.add(exit);
        mainFrame.add(imageLabel);
        mainFrame.setSize(996,599);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);  
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }         
    public void actionPerformed(ActionEvent e) 
    {   
        if(e.getSource()==login)
		{  
    		mainFrame.setVisible(false);
            new Login();
            mainFrame.dispose();
        } 
        
        if(e.getSource()==signup)
		{  
    		mainFrame.setVisible(false);
            new Signup();
            mainFrame.dispose();
		}
          
        if(e.getSource()==exit)
		{  
        	mainFrame.setVisible(false);
			System.exit(0);
		}
        
    }
}
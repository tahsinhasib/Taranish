package loginsignups;
import dashboards.*;
import transactions.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;


public class Login implements ActionListener {
    
    //attributes
    private JFrame mainFrame;

    private JLabel labelusernamelogin;
    private JLabel labeluserpasslogin;

    private JTextField userNameTextField;
    private JPasswordField passWordField;


    private JButton BtnUserLogin;
    private JButton BtnBack;

    private JLabel labelUserLogin;      //user login logo

    public Login() {

        //Frame Creation
        mainFrame = new JFrame("Login as User/Admin");


        //JButton Components
        BtnUserLogin = new JButton("Login");
        BtnBack = new JButton("Back");






        //JTextField Components
        userNameTextField = new JTextField();
        passWordField = new JPasswordField();






        //JLabel Components
        labelusernamelogin = new JLabel("Username : ");
        labeluserpasslogin = new JLabel("Password : ");

        labelUserLogin = new JLabel();
        labelUserLogin.setIcon(new ImageIcon("images/userlogin.jpg"));





        //Color, Shapes style
        BtnBack.setBackground(Color.red);
        BtnBack.setForeground(Color.white);
        BtnBack.setFocusPainted(false);
        BtnUserLogin.setBackground(Color.BLUE);
        BtnUserLogin.setForeground(Color.white);
        BtnUserLogin.setFocusPainted(false);

        






        //Allignments
        labelusernamelogin.setBounds(100, 200, 500, 30);
        labeluserpasslogin.setBounds(100, 250, 500, 30);
        userNameTextField.setBounds(200, 200, 250, 30);
        passWordField.setBounds(200, 250, 250, 30);
        BtnUserLogin.setBounds(100, 320, 350, 30);
        BtnBack.setBounds(100, 360, 350, 30);

        labelUserLogin.setBounds(0, 0, 980, 560);       //in the last



        //Action Listener
        BtnBack.addActionListener(this);
        BtnUserLogin.addActionListener(this);
    




        //Adding In Frame
        mainFrame.add(labelusernamelogin);
        mainFrame.add(labeluserpasslogin);
        mainFrame.add(userNameTextField);
        mainFrame.add(passWordField);
        mainFrame.add(BtnUserLogin);
        mainFrame.add(BtnBack);

        mainFrame.add(labelUserLogin);               // in the last





        //Frame Details
        mainFrame.setSize(995, 598);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        
        //Frame Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("valorant.png");
        mainFrame.setIconImage(icon);

    }



    public void actionPerformed(ActionEvent e){

    	if(e.getSource()==BtnUserLogin){
    	//for verifying fields are null or not
    	String username = userNameTextField.getText();
    	String password = new String(passWordField.getPassword());
    	
    	//for reading files
    	String usernameX = "Username: " + username;
        String passwordX = "Password: " + password;
        BufferedReader br = null;
		
        try {
        	File file = new File("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\account_data.txt");
        	
        	if (!file.exists()) {
                try {
					file.createNewFile();
				} 
                catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }

        finally { System.out.println("Successfully accessed/created file"); }
        
		
		if (username.length() == 0 || password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
        } 
		else {
        
			try {
            	try {
					br = new BufferedReader(new FileReader("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\account_data.txt"));
				} 
            	catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					String line;
					boolean passFlag = false; // for 'invalid' dialog
					boolean userFlag = false;
					
				
					while ((line = br.readLine()) != null) {
						if (userFlag == true) {
							if (line.equals("User type: User")) {
								JOptionPane.showMessageDialog(null, "Login Successful as: "+ username, "Welcome to Taranish",
	                                    JOptionPane.WARNING_MESSAGE);
								mainFrame.setVisible(false);
					            new UserDashboard(username); // User dashboard
					            mainFrame.dispose();
							}
							
							else if (line.equals("User type: Admin")) {
								JOptionPane.showMessageDialog(null, "Login Successful as Admin", "Welcome Boss",
	                                    JOptionPane.WARNING_MESSAGE);
								mainFrame.setVisible(false);
					            new AdminDashboard(username); // Admin dashboard
					            mainFrame.dispose();
							}
							
							break;
						}
						
						if (passFlag == true){
							if (line.equals(passwordX)){
								userFlag = true;
							}
							
							else {
								passFlag = false;
							}
						}
						
						else if (line.equals(usernameX)) {
							passFlag = true;
						}
					}
					
					
					if (passFlag == false) {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Warning!",
		                JOptionPane.WARNING_MESSAGE);
					}
					
				} 
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Server Error - Bugladins", "Warning!",
	                JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
			}
			
			finally { System.out.println("2"); }
		}
    } 
    	
    	if(e.getSource()==BtnBack){
    		mainFrame.setVisible(false);
            new Welcome();
            mainFrame.dispose();
        }
    }
}


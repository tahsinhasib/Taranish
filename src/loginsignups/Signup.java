package loginsignups;
import dashboards.*;
import transactions.*;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.*;

public class Signup implements ActionListener{

	JFrame mainFrame;
	
	JLabel imageLabel;
	
	JTextField userNameTextField, TFofEmailSignUppage; 
    
	JPasswordField passWordField, PFofRetypeuserpassSignUppage;
	
    JButton signup, BtnBack;
    
    JComboBox<String> cmbDate, cmbMonth, cmbYear;
    
    JCheckBox cb1;
	
    Icon icon = new ImageIcon("images/signup.jpg");
    
    
    Signup(){ 
    	
        mainFrame= new JFrame("Create a new Account");
        
        imageLabel = new JLabel();
        imageLabel.setBounds(-20, 0, 1000, 560);
        imageLabel.setIcon(icon);		
		
		userNameTextField=new JTextField();  
        userNameTextField.setBounds(535, 100, 250, 30);  
		
        TFofEmailSignUppage = new JTextField();
        TFofEmailSignUppage.setBounds(535, 240, 250, 30);
        
        passWordField=new JPasswordField();  
        passWordField.setBounds(535, 310, 250, 30); 
        
        PFofRetypeuserpassSignUppage = new JPasswordField();
        PFofRetypeuserpassSignUppage.setBounds(535, 380, 250, 30);
        
        signup = new JButton("Create Account");
        signup.setBounds(520, 460, 300, 30);
        signup.setForeground(Color.white);
        signup.setBackground(Color.BLUE);
        signup.setOpaque(true);
        signup.addActionListener(this);
        
        BtnBack = new JButton("Back");
        BtnBack.setBounds(520, 500, 300, 30);
        BtnBack.setBackground(Color.red);
        BtnBack.setForeground(Color.white);
        BtnBack.setFocusPainted(false);
        BtnBack.setOpaque(true);
        BtnBack.addActionListener(this);
		
        //JCheckBox Components
        cb1 = new JCheckBox("   I agree with the terms and policy");
        cb1.setBounds(535, 420, 250, 30);
        cb1.setFocusPainted(false);
        cb1.setForeground(Color.white);
        cb1.setOpaque(false);
        
        String date[] = new String[] {"1","2","3","4","5","6","7","8","9","10",
                "11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30",
                "31"};
        String month[] = new String[] {"January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"};

        String year[] = new String[] {"1990", "1991", "1992", "1993",
                "1994", "1995", "1996", "1997",
                "1998", "1999", "2000"};
        
        cmbDate = new JComboBox<>(date);
        cmbMonth = new JComboBox<>(month);
        cmbYear = new JComboBox<>(year);
        cmbDate.setBounds(535,170,50,30);
        cmbMonth.setBounds(600, 170, 100, 30);
        cmbYear.setBounds(710, 170, 80, 30);
        
        
        mainFrame.add(userNameTextField);
        mainFrame.add(passWordField);
        mainFrame.add(TFofEmailSignUppage);
        mainFrame.add(PFofRetypeuserpassSignUppage);
        mainFrame.add(signup);
        mainFrame.add(BtnBack);
        mainFrame.add(cmbDate);
        mainFrame.add(cmbMonth);
        mainFrame.add(cmbYear);
        mainFrame.add(cb1);
        mainFrame.add(imageLabel);
       
        mainFrame.setSize(995,598);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);  
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {  

        //Checking whether the button is signup
    	if(e.getSource()==signup){ 
			String username = userNameTextField.getText();
			String password = new String(passWordField.getPassword());
			String email = TFofEmailSignUppage.getText();
			String rePassword = new String(PFofRetypeuserpassSignUppage.getPassword());;
			
			String date = (String)cmbDate. getSelectedItem();
			String month = (String)cmbMonth. getSelectedItem();
			String year = (String)cmbYear. getSelectedItem();
			
			if (username.length() == 0 || password.length() == 0 || email.length() == 0 || rePassword.length() == 0) {
	            JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
	            JOptionPane.WARNING_MESSAGE);
	        }
			else{
				if (password.equals(rePassword)){
					if(cb1.isSelected()){  
						try {
							File file = new File("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\account_data.txt");
		                
							if (!file.exists()) {
								file.createNewFile();
							}
		               
							FileWriter fw = new FileWriter(file, true);
							BufferedWriter bw = new BufferedWriter(fw);
		                	PrintWriter pw = new PrintWriter(bw);
		
		                	LocalDateTime myDateObj = LocalDateTime.now();
		                	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
		
		                	String timeAndDate = myDateObj.format(myFormatObj);
		
		                	pw.println("Username: " + username);
		                	pw.println("Password: " + password);
		                	pw.println("User type: User");
			                pw.println("Email : " + email);
			                pw.println("Date of Birth : " + date + "/" + month + "/" + year);
		                	pw.println("Time & Date of registration: " + timeAndDate);
		                	pw.println("─────────────✧✧✧❁✧✧✧─────────────");
		               		pw.close();
		
						} 

						catch (Exception ex) {
							System.out.print(ex);
						}
						
						JOptionPane.showMessageDialog(null, "Registration Successfully Completed.",
			            "Registration Complete", JOptionPane.WARNING_MESSAGE);
						mainFrame.setVisible(false);
			            new Welcome();
			            mainFrame.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Please tick the 'Terms and Policy' box.", "Warning!",
			            JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Passwords do not match", "Warning!",
		            JOptionPane.WARNING_MESSAGE);
				}
			
			}
		}
    	
    	if(e.getSource()==BtnBack){
    		mainFrame.setVisible(false);
            new Welcome();
            mainFrame.dispose();
		}
	}
}


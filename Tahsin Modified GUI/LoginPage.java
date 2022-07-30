import javax.swing.*;
import java.awt.Color;
import java.awt.event.*; 
import java.awt.Font; 
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginPage implements ActionListener{  
    
	JFrame f;

    JLabel UsernameNameLabel;
	JLabel PasswordLabel;	
    JLabel LoginPageLogo;
    JLabel LogoMessage;
    JLabel UserLogo;
    JLabel PassKeyLogo;
	
	JTextField UsernameTextField;

	JPasswordField PasswordField;

    JButton Login;
    JButton ForgotPassword;
    JButton RegisterAccount;  
	
    LoginPage(){  

        f = new JFrame(); 

        //--------------------------------------------------- Color, Font initializer
        Color lightBlue = new Color(51,153,255);
        f.getContentPane().setBackground(lightBlue);

        Color ForButtonInLoginPage = new Color(18,82,255);

        Font ButtonFont = new Font("Arial Black", Font.BOLD, 12);
        Font UnderLogo = new Font("Consolas", Font.ITALIC, 10);

        //-------------------------------------------------- JPanel Borders
        JPanel border = new JPanel();
        border.setBounds(10,10,565,340);
        border.setBackground(lightBlue);
        border.setBorder(BorderFactory.createLineBorder(Color.white,4,true));

        //---------------------------------------------- JLebel bounds, color
		UsernameNameLabel = new JLabel("Username");
		UsernameNameLabel.setBounds(170,170,150,20);
        UsernameNameLabel.setForeground(Color.white);

		PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(170,200,150,20);
        PasswordLabel.setForeground(Color.white); 	
        



        //--------------------------------------------------------------- Login Page all Logo and Message
        LoginPageLogo = new JLabel();
        LoginPageLogo.setIcon(new ImageIcon("login page logo.jpg"));
        LoginPageLogo.setBounds(240, -20, 200, 200);
        //LoginPageLogo.setLayout(null);

        LogoMessage = new JLabel("American International University Bangladesh");
        LogoMessage.setBounds(160, 100, 500, 100);
        LogoMessage.setForeground(Color.white);
        LogoMessage.setFont(UnderLogo);

        UserLogo = new JLabel();
        UserLogo.setIcon(new ImageIcon("user icon.PNG"));
        UserLogo.setBounds(130, 168, 25, 25);

        PassKeyLogo = new JLabel();
        PassKeyLogo.setIcon(new ImageIcon("pass icon.png"));
        PassKeyLogo.setBounds(130, 200, 25, 25);


        

		
        //------------------------------------------------ JTextField JPasswordField bounds, color
        UsernameTextField = new JTextField();  
        UsernameTextField.setBounds(260,170,150,20);  
		
	    PasswordField = new JPasswordField();  
        PasswordField.setBounds(260,200,150,20); 
          
        //------------------------------------------------- JButton bounds
        Login = new JButton("Login");  
        Login.setBounds(150,240,90,30);  
        Login.addActionListener(this);
        Login.setBackground(ForButtonInLoginPage);
        Login.setForeground(Color.white);
        Login.setFont(ButtonFont);
        Login.setFocusPainted(false);     // removes the selection border

        ForgotPassword = new JButton("Forgot Password");
        ForgotPassword.setBounds(260, 240, 170, 30);
        ForgotPassword.setBackground(ForButtonInLoginPage);
        ForgotPassword.setForeground(Color.white);
        ForgotPassword.setFont(ButtonFont);
        ForgotPassword.setFocusPainted(false);    // removes the selection border


        RegisterAccount = new JButton("Register now");
        RegisterAccount.setBounds(215, 280, 140, 30);
        RegisterAccount.setBackground(ForButtonInLoginPage);
        RegisterAccount.setForeground(Color.white);
        RegisterAccount.setFont(ButtonFont);
        RegisterAccount.setFocusPainted(false);   // removes the selection border
	
        //---------------------------------------------------- Adding in frame
		f.add(UsernameNameLabel);
		f.add(PasswordLabel);
        f.add(UsernameTextField);
        f.add(PasswordField);
		f.add(Login); 
        f.add(ForgotPassword);
        f.add(RegisterAccount);
        f.add(LoginPageLogo);
        f.add(LogoMessage);
        f.add(UserLogo);
        f.add(PassKeyLogo);
        f.add(border);

        //---------------------------------------------------- Setting size of frame
        f.setTitle("American International University Bangladesh");
        f.setSize(600,400);
        //-------------------------------------- for centering the frame
        f.setLocationRelativeTo(null);  
        f.setLayout(null);  
        f.setVisible(true);  

        //---------------------------------------- Icon Settings
        Image icon = Toolkit.getDefaultToolkit().getImage("aiub icon.PNG");
        
        f.setIconImage(icon);
        f.setLayout(null);
        f.setSize(600,400);
        f.setVisible(true);

    }         
    public void actionPerformed(ActionEvent e){  

        int flag = 0;
         
        if(e.getSource() == Login){  
			String user = UsernameTextField.getText();
			String pass = String.valueOf(PasswordField.getPassword());  // this will not keep pass in the string pool

            if(user.equals("Tahsin") && pass.equals("java")){

                //------------------- Disabling previous frame so that new frame can emerge
				f.setVisible(false);

                //------------------------- Sample() contains new JFrame
				new HomePage();
			}
			else{
				showMessageDialog(null, "Invalid Username and password!");
			}
        }  
    }  
} 
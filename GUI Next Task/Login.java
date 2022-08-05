import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login implements ActionListener{

    //attributes
    private JFrame frame;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel lblaccount;
    
    public JTextField TFoftext;
    private JPasswordField PFofpass;

    private JButton BtnLogin;
    private JButton BtnForgotPassword;
    private JButton BtnSignUp;
    private JButton BtnExit;

    private UIManager um;  // for changing JOptionPane color



    private JLabel lbllogin;

    User u1, u2, u3, u4, u5;
    User users[];




    Login(){

        //association with user class
        u1 = new User("user1", "1111");
        u2 = new User("user2", "2222");
        u3 = new User("user3", "3333");
        u4 = new User("user4", "4444");
        u5 = new User("user5", "5555");

        users = new User[5];
        users[0] = u1;
        users[1] = u2;
        users[2] = u3;
        users[3] = u4;
        users[4] = u5;



        //creating frames
        frame = new JFrame();



        

        //JLabel components
        labelUsername = new JLabel("Username : ");
        labelPassword = new JLabel("Password : ");
        lblaccount = new JLabel("Don't have an account? want to sign up?");




        //JTextField components
        TFoftext = new JTextField();
        PFofpass = new JPasswordField();




        //JButton components
        BtnLogin = new JButton("Login");
        BtnForgotPassword = new JButton("Forgot Password");
        BtnSignUp = new JButton("Sign Up");
        BtnExit = new JButton("Exit");




        //Color, size, shapes
        labelUsername.setForeground(Color.black);
        labelPassword.setForeground(Color.black);
        lblaccount.setForeground(Color.black);
        BtnLogin.setBackground(Color.red);
        BtnForgotPassword.setBackground(Color.red);
        BtnSignUp.setBackground(Color.blue);
        BtnExit.setBackground(Color.red);
        BtnLogin.setForeground(Color.white);
        BtnForgotPassword.setForeground(Color.white);
        BtnSignUp.setForeground(Color.white);
        BtnExit.setForeground(Color.white);
        BtnLogin.setFocusPainted(false);
        BtnForgotPassword.setFocusPainted(false);
        BtnSignUp.setFocusPainted(false);
        BtnExit.setFocusPainted(false);






        //JLabel for logos and pictures
        lbllogin = new JLabel();
        lbllogin.setIcon(new ImageIcon("loginicon.png"));




        /*_______________LIFE TIP_________________
         * Nothing can be alligned before creating 
         * 
         */




        //allignment of components
        labelUsername.setBounds(100, 200, 150, 30);
        labelPassword.setBounds(100, 250, 150, 30);
        lblaccount.setBounds(100, 380, 300, 30);
        TFoftext.setBounds(200, 200, 190, 30);
        PFofpass.setBounds(200, 250, 190, 30);
        BtnLogin.setBounds(100, 300, 290, 30);
        BtnForgotPassword.setBounds(100, 340, 290, 30);
        BtnSignUp.setBounds(100, 420, 290, 30);
        BtnExit.setBounds(780, 500, 80, 30);
        lbllogin.setBounds(-16, 0, 900, 600);




        //action listener
        BtnLogin.addActionListener(this);
        BtnExit.addActionListener(this);




        //adding everything in frame
        frame.add(labelUsername);
        frame.add(labelPassword);
        frame.add(lblaccount);
        frame.add(TFoftext);
        frame.add(PFofpass);
        frame.add(BtnLogin);
        frame.add(BtnForgotPassword);
        frame.add(BtnSignUp);
        frame.add(BtnExit);
        frame.add(lbllogin);





        //setting frame details (needed to be done in the last before icon)
        frame.setSize(900, 600);
        frame.setLayout(null);              //improper adjustment can cause issue of labels thus needed to be written above over other functions
        frame.setLocationRelativeTo(null);
        frame.setTitle("Login");
        frame.setVisible(true);




        //frame icon
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
        frame.setIconImage(icon);

    
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource()==BtnLogin){
            String user = TFoftext.getText();
            String pass = String.valueOf(PFofpass.getPassword());

            int flag=0;

            if(user.isEmpty()==false && pass.isEmpty()==false){
                for(int i=0; i<users.length; i++){
                    if(users[i]!=null){
                        if(user.equals(users[i].getUsername()) && pass.equals(users[i].getPassword())){
                            flag=1;
                            break;
                        }
                    }
                }
                if(flag==1){
                    frame.setVisible(false);
                    new Dashboard1(user);
                }
                else{
                    showMessageDialog(null, "Invalid Username or Password");
                }
            }
            else{
                showMessageDialog(null, "Please fill up the fields");
            }
        }    
        else if(e.getSource()==BtnExit){
            System.exit(0);
        }      
    }


}





package loginsignups;
import dashboards.*;
import transactions.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*; 

public class Video implements ActionListener{

	JFrame mainFrame;
	Icon icon = new ImageIcon("images/background.gif");
	
	JLabel label = new JLabel();
	
	JButton skip;
	
	int skipFlag = 0;
	
	
	public Video(){
		mainFrame= new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label.setBounds(200,0,960,540);
		label.setIcon(icon);
		
		skip = new JButton("Skip");
		skip.setBounds(425,450,150,30);
		skip.setForeground(Color.white);
		skip.setBackground(Color.blue);
		skip.setFocusPainted(false);
   		skip.setOpaque(false);
		skip.setBorder(null);
		skip.setBorder(null);
		skip.addActionListener(this);
		
		mainFrame.add(skip);
		mainFrame.add(label);
		mainFrame.setSize(960,540);  
		mainFrame.getContentPane().setBackground(Color.black);        //background of frame
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(null);  
		mainFrame.setUndecorated(true);
		mainFrame.setVisible(true);
        
        Timer timer = new Timer(21_000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	if (skipFlag == 0) {
            		mainFrame.setVisible(false);
            		mainFrame.dispose();
            		new Welcome();
            	}
            }
        });
        timer.setRepeats(false);
        timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==skip){  
			mainFrame.setVisible(false);
        	mainFrame.dispose();
        	new Welcome();
        	skipFlag = 1;
		}
	}
}

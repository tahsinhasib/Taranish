package dashboards;
import loginsignups.*;
import transactions.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer; 
import java.lang.*; 

public class AdminDashboard implements ActionListener{  
      
	JFrame mainFrame;
	
	JPanel userDetailsPanel, gamesPanel, searchPanel, cartPanel, insertPanel, deletePanel;
	
	JLabel userDetailsLabel, gamesLabel, searchLabel, cartLabel, totalPriceLabel, insertLabel, deleteLabel, dashImgLabel;
	
	JTextField seaField, insNameField, insPriceField, insCategoryField, insAppIDField, delField;
	
	JButton userDetailsButton, addButton, gamesButton, searchButton, searchButton2, cartButton, cartButton2, insertButton, insertButton2, deleteButton, deleteButton2, logoutButton;
	
	JTable userDetailsTable, gameTable, cartTable;
	
	DefaultTableModel userDetailsTableModel, gameTableModel, cartTableModel;
	
	Icon dashIcon = new ImageIcon("images/dashboardlogo.jpg");
	
	String username;
	
	Double totalPrice;

    
	public AdminDashboard(String username){  
		//Initialisation
		mainFrame= new JFrame("Dashboard");
	    this.username = username;

		//////////////////////////////////////////////////////////
		//Color components
        Color lightgreen = new Color(212, 236, 72);
		/////////////////////////////////////////////////////////////
		
	    //panels
	    userDetailsPanel = new JPanel();
	    userDetailsPanel.setBounds(300,75,900,500);
	    userDetailsPanel.setBackground(new java.awt.Color(200, 255, 255));
	    
	    gamesPanel = new JPanel();
	    gamesPanel.setBounds(380,160,800,500);
        gamesPanel.setBackground(Color.black);
        
        searchPanel = new JPanel();
        searchPanel.setBounds(380,160,800,500);
        searchPanel.setBackground(Color.black);
        
        cartPanel = new JPanel();
        cartPanel.setBounds(300,75,900,500);
        cartPanel.setBackground(new java.awt.Color(150, 70, 0));
        
        insertPanel = new JPanel();
        insertPanel.setBounds(380,160,800,500);
        insertPanel.setBackground(Color.black);
        
        deletePanel = new JPanel();
        deletePanel.setBounds(380,160,800,500);
        deletePanel.setBackground(Color.black);
        
        //labels
        userDetailsLabel = new JLabel("Showing user details");
        userDetailsLabel.setBounds(300,30,300,20);
        userDetailsLabel.setForeground(Color.white);
        userDetailsLabel.setVisible(false);
        
        gamesLabel = new JLabel("Welcome " + username);
		gamesLabel.setBounds(400,75,300,20);
		gamesLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		gamesLabel.setForeground(Color.white);
		
		searchLabel = new JLabel("Search for Games");
		searchLabel.setBounds(400,75,300,20);
		searchLabel.setForeground(Color.white);
		searchLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		searchLabel.setVisible(false);
		
		cartLabel = new JLabel("Games in your cart");
		cartLabel.setBounds(300,30,300,20);
		cartLabel.setForeground(Color.white);
		cartLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		cartLabel.setVisible(false);

		insertLabel = new JLabel("Insert Games ");
		insertLabel.setBounds(400,75,300,20);
		insertLabel.setForeground(Color.white);
		insertLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		insertLabel.setVisible(false);
		
		deleteLabel = new JLabel("Delete Games ");
		deleteLabel.setBounds(400,75,300,20);
		deleteLabel.setForeground(Color.white);
		deleteLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		deleteLabel.setVisible(false);
		
		dashImgLabel = new JLabel();
        dashImgLabel.setBounds(0,0,1280,720);
        dashImgLabel.setIcon(dashIcon);
        
      //labels inside panels
  		totalPriceLabel = new JLabel("Total price is: ");
  		totalPriceLabel.setBounds(300,300,300,20);
  		totalPriceLabel.setForeground(Color.white);
        
        //textFields
        seaField = new JTextField("Type the name of the Game here");
        seaField.setBounds(200,200,500,50);


        seaField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	seaField.setText("");
            }
        });
        
        insNameField = new JTextField("Type Name Here");
        insNameField.setBounds(200,50,500,50);


        insNameField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	insNameField.setText("");
            }
        });
        
        insPriceField = new JTextField("Type Price Here");
        insPriceField.setBounds(200,150,500,50);

        insPriceField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	insPriceField.setText("");
            }
        });
        
        insCategoryField = new JTextField("Type Category Here");
        insCategoryField.setBounds(200,250,500,50);

        insCategoryField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	insCategoryField.setText("");
            }
        });
        
        insAppIDField = new JTextField("Type AppID Here");
        insAppIDField.setBounds(200,350,500,50);

        insAppIDField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	insAppIDField.setText("");
            }
        });
        
        
        delField = new JTextField("Type AppID Here");
        delField.setBounds(200,200,500,50);

        delField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	delField.setText("");
            }
        });
        
        //buttons
        userDetailsButton = new JButton("USER DETAILS");
        userDetailsButton.setBounds(50,50,200,30);
        userDetailsButton.setForeground(Color.white);
        userDetailsButton.setBackground(Color.BLACK);
        userDetailsButton.setFocusPainted(false);
        userDetailsButton.setOpaque(true);
        userDetailsButton.addActionListener(this);
        
        gamesButton = new JButton("GAMES");
        gamesButton.setBounds(60,200,200,30);
        gamesButton.setForeground(Color.black);
        gamesButton.setBackground(lightgreen);
        gamesButton.setFocusPainted(false);
        gamesButton.setOpaque(true);
        gamesButton.addActionListener(this);
        
        addButton = new JButton("Add to Cart");
        addButton.setBounds(350,450,200,30);
        addButton.setForeground(Color.black);
        addButton.setBackground(lightgreen);
        addButton.setFocusPainted(false);
        addButton.setOpaque(true);
        addButton.addActionListener(this);
        
        searchButton = new JButton("SEARCH");
        searchButton.setBounds(60,250,200,30);
        searchButton.setForeground(Color.black);
        searchButton.setBackground(lightgreen);
        searchButton.setFocusPainted(false);
        searchButton.setOpaque(true);
        searchButton.addActionListener(this);
        
        searchButton2 = new JButton("Search Game");
        searchButton2.setBounds(350,450,200,30);
        searchButton2.setForeground(Color.black);
        searchButton2.setBackground(lightgreen);
        searchButton2.setFocusPainted(false);
        searchButton2.setOpaque(true);
        searchButton2.addActionListener(this);
        
        cartButton = new JButton("CART");
        cartButton.setBounds(50,350,200,30);
        cartButton.setForeground(Color.black);
        cartButton.setBackground(lightgreen);
        cartButton.setFocusPainted(false);
        cartButton.setOpaque(true);
        cartButton.addActionListener(this);
        
        cartButton2 = new JButton("Checkout");
        cartButton2.setBounds(350,450,200,30);
        cartButton2.setForeground(Color.black);
        cartButton2.setBackground(lightgreen);
        cartButton2.setFocusPainted(false);
        cartButton2.setOpaque(true);
        cartButton2.addActionListener(this);
        
        insertButton = new JButton("INSERT");
        insertButton.setBounds(60,300,200,30);
        insertButton.setForeground(Color.black);
        insertButton.setBackground(lightgreen);
        insertButton.setFocusPainted(false);
        insertButton.setOpaque(true);
        insertButton.addActionListener(this);
        
        insertButton2 = new JButton("Insert Game");
        insertButton2.setBounds(350,450,200,30);
        insertButton2.setForeground(Color.black);
        insertButton2.setBackground(lightgreen);
        insertButton2.setFocusPainted(false);
        insertButton2.setOpaque(true);
        insertButton2.addActionListener(this);
        
        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(60,350,200,30);
        deleteButton.setForeground(Color.black);
        deleteButton.setBackground(lightgreen);
        deleteButton.setFocusPainted(false);
        deleteButton.setOpaque(true);
        deleteButton.addActionListener(this);
        
        deleteButton2 = new JButton("Delete Game");
        deleteButton2.setBounds(350,450,200,30);
        deleteButton2.setForeground(Color.black);
        deleteButton2.setBackground(lightgreen);
        deleteButton2.setFocusPainted(false);
        deleteButton2.setOpaque(true);
        deleteButton2.addActionListener(this);
		
        logoutButton = new JButton("LOGOUT");
        logoutButton.setBounds(60,400,200,30);
        logoutButton.setForeground(Color.black);
        logoutButton.setBackground(lightgreen);
        logoutButton.setFocusPainted(false);
        logoutButton.setOpaque(true);
        logoutButton.addActionListener(this);
        
        
        //tables
        gameTable = new JTable();
        gameTable.setBounds(350,75,600,500);
		//////////////////////////////////
		JTableHeader tableHeader = gameTable.getTableHeader();
		gameTable.setBackground(Color.black);
		gameTable.setForeground(Color.white);
		///////////////////////////////////////
        gameTableModel = (DefaultTableModel) gameTable.getModel();
        
        cartTable = new JTable();
        cartTable.setBounds(350,75,600,500);
        cartTableModel = (DefaultTableModel) cartTable.getModel();
        
		//IO for gameTable
        BufferedReader br = null;
		
        try {
        	File file = new File("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\game_data.txt");
        	
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
        
        finally { System.out.println("Successfully accessed/created game file"); }
        
        try {
        	try {
    			br = new BufferedReader(new FileReader("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\game_data.txt"));
    		} 
        	catch (FileNotFoundException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	try {
				String firstLine = br.readLine().trim();
				String[] columnsName = firstLine.split(" , ");
				gameTableModel.setColumnIdentifiers(columnsName);
				Object [] tableLines = br.lines().toArray();
				
				
//				gameTable.getColumn("Add").setCellRenderer(new ButtonRenderer());
//				gameTable.getColumn("Add").setCellEditor(new ButtonEditor(new JCheckBox()));
			    
				
				for(int i=0;i<tableLines.length;i++){
					String line = tableLines[i].toString().trim();
					if (!line.equals("")){
						String [] dataRow = line.split(" / ");
						gameTableModel.addRow(dataRow);
					}	
				}
			}
        	
        	finally { System.out.println("Successfully read columns and rows");}
        }
        
        catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        //adding to panel
        
        userDetailsPanel.setLayout(new FlowLayout());
        userDetailsPanel.setVisible(false);
        
        gamesPanel.add(new JScrollPane(gameTable));
//        gamesPanel.add(addButton);
        gamesPanel.setLayout(new FlowLayout());
        
        searchPanel.add(seaField);
        searchPanel.add(searchButton2);
        searchPanel.setVisible(false);
        searchPanel.setLayout(null);
        
        cartPanel.add(new JScrollPane(cartTable));
        cartPanel.add(totalPriceLabel);
        cartPanel.add(cartButton2);
        cartPanel.setVisible(false);
//      cartPanel.setLayout(null);
        
        insertPanel.add(insNameField);
        insertPanel.add(insPriceField);
        insertPanel.add(insCategoryField);
        insertPanel.add(insAppIDField);
        insertPanel.add(insertButton2);
        insertPanel.setVisible(false);
        insertPanel.setLayout(null);
        
        deletePanel.add(delField);
        deletePanel.add(deleteButton2);
        deletePanel.setVisible(false);
        deletePanel.setLayout(null);
        
        //adding to mainFrame
        mainFrame.setVisible(true);
//        mainFrame.getContentPane().add(userDetailsPanel);
        mainFrame.getContentPane().add(gamesPanel);
        mainFrame.getContentPane().add(searchPanel);
        mainFrame.getContentPane().add(cartPanel);
        mainFrame.getContentPane().add(insertPanel);
        mainFrame.getContentPane().add(deletePanel);
        
        mainFrame.add(userDetailsLabel);
        mainFrame.add(gamesLabel);
        mainFrame.add(searchLabel);
        mainFrame.add(cartLabel);
        mainFrame.add(insertLabel);
        mainFrame.add(deleteLabel);
        
//        mainFrame.add(userDetailsButton);
        mainFrame.add(gamesButton);
        mainFrame.add(searchButton);
//        mainFrame.add(cartButton);
        mainFrame.add(insertButton);
        mainFrame.add(deleteButton);
        mainFrame.add(logoutButton);
        
        mainFrame.add(dashImgLabel);      
        
        // settings for mainFrame 
		mainFrame.setSize(1280,720);  
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
	  
		//Rendering of addButton 
//	class ButtonRenderer extends JButton implements TableCellRenderer 
//	{
//		public ButtonRenderer() 
//		{
//	    setOpaque(true);
//	    }
//	    
//		public Component getTableCellRendererComponent(JTable table, Object value,
//	    boolean isSelected, boolean hasFocus, int row, int column) 
//		{
//	      setText((value == null) ? "Add To Cart" : value.toString());
//	      return this;
//	    }
//	}
//	class ButtonEditor extends DefaultCellEditor 
//	{
//	    private String label;
//	    
//	    public ButtonEditor(JCheckBox checkBox)
//	    {
//	      super(checkBox);
//	    }
//	    public Component getTableCellEditorComponent(JTable table, Object value,
//	    boolean isSelected, int row, int column) 
//	    {
//	      label = (value == null) ? "Add To Cart" : value.toString();
//	      addButton.setText(label);
//	      return addButton;
//	    }
//	    public Object getCellEditorValue() 
//	    {
//	      return new String(label);
//	    }
//	 }
    
    	  
	//action listeners

    public void actionPerformed(ActionEvent e) {


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>		
//    	if(e.getSource()==userDetailsButton)
//		{  
//    		if (userDetailsPanel.isVisible() == false)
//    		{    		
//	    		String username = new String();
//	    		String email = new String();
//	            String dob = new String();
//	            String registration = new String();
//	            
//	            String usernameX = "Username: " + username;
//	           
//	            	BufferedReader br = null;
//					try 
//	            	{
//						br  = new BufferedReader(new FileReader("src/data/account_data.txt"));
//					} 
//	            	catch (FileNotFoundException e1) 
//	            	{
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//						
//						Object [] tableLines = br.lines().toArray();
//						int userline = 0;
//						
//						for(int i=0;i<tableLines.length;i++) 
//						{
//							String line = tableLines[i].toString();
//							if (line.equals(usernameX))
//							{
//								userline = i;
//							}
//						}
//						
//						email = (String) tableLines[(userline+3)];
//						dob = (String) tableLines[(userline+4)];
//						registration = (String) tableLines[(userline+5)];
//					
//						System.out.println(userline);
//				
//	    		gamesLabel.setVisible(false);
//	    		cartLabel.setVisible(false);
//	    		searchLabel.setVisible(false);
//				insertLabel.setVisible(false);
//				deleteLabel.setVisible(false);
//	    		
//				gamesPanel.setVisible(false);
//				cartPanel.setVisible(false);
//				searchPanel.setVisible(false);
//				insertPanel.setVisible(false);
//				deletePanel.setVisible(false);
//				
//				userDetailsLabel.setVisible(true);
//				userDetailsPanel.setVisible(true);
//								
//    		}
//		}
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    	

    	if(e.getSource()==gamesButton){  
    		new AdminDashboard(username);
    		mainFrame.dispose();
		}
    	
    	if(e.getSource()==addButton){  
            
            int a=JOptionPane.showConfirmDialog(mainFrame,"Do you want to add this game to cart?");  
	          if(a==JOptionPane.YES_OPTION){  

	        	int row = gameTable.getSelectedRow();
	      		String name = gameTable.getModel().getValueAt(row, 0).toString();
	      		Double price = Double.parseDouble(gameTable.getModel().getValueAt(row, 1).toString());
	      		String category = gameTable.getModel().getValueAt(row, 2).toString();
	      		String appid = gameTable.getModel().getValueAt(row, 3).toString();
	              
	      		Games g1 = new Games(name,price,category,appid);
//	              g1.showAll();
	      		
	            int i = 0;
	            while(Cart.gamesCart[i]!=null){
	      			i++;
	      		}
	            Cart.gamesCart[i] = g1;
	              
//	              for(i=0;Cart.gamesCart[i]!=null;i++)
//	              {
//	              	Cart.gamesCart[i].showAll();
//	              }
	              
//	            new Dashboard(username);
//	      		mainFrame.dispose();
	        }
		}
    	
    	if(e.getSource()==searchButton){  
    		userDetailsLabel.setVisible(false);
    		gamesLabel.setVisible(false);
			cartLabel.setVisible(false);
			insertLabel.setVisible(false);
			deleteLabel.setVisible(false);
			
			userDetailsPanel.setVisible(false);
    		gamesPanel.setVisible(false);
			cartPanel.setVisible(false);
			insertPanel.setVisible(false);
			deletePanel.setVisible(false);
            
			searchLabel.setVisible(true);
            searchPanel.setVisible(true);
		}
    	
    	if(e.getSource()==searchButton2){  
			
			String name = seaField.getText();

			if (name.length() == 0) {
	            JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
	            JOptionPane.WARNING_MESSAGE);
	        }
			
			else {
				try {
					File file = new File("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\game_data.txt");
                
					if (!file.exists()) {
//						file.createNewFile();
						JOptionPane.showMessageDialog(null, "There is nothing to search - game_data.txt Does Not Exist", "Warning!",
			                    JOptionPane.WARNING_MESSAGE);
					}

					String line;
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\game_data.txt"));
					} 
	            	catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					Object [] tableLines = br.lines().toArray();
					
					
					boolean searchFlag = false;
					
					for(int i=0;i<tableLines.length;i++) {
						line = tableLines[i].toString().trim();
						String [] dataRow = line.split(" / ");
						
						//for discarding first line in data file
						if(i>0){
							//Name is stored in the 1st index of dataRow
							if(name.equals(dataRow[0])){
								JOptionPane.showMessageDialog(null, name + " has been successfully found at line no. " + (i+1),
					            "Game Found", JOptionPane.WARNING_MESSAGE);
								searchFlag = true;
							}
						}
					}
					

					if (searchFlag == false){
						JOptionPane.showMessageDialog(null, "Game Not Found",
			            "Search FAILED", JOptionPane.WARNING_MESSAGE);
					}
					
				}
					
				catch (Exception ex){
					System.out.print(ex);
				}
				
			}
			
				
		}
    	
    	if(e.getSource()==cartButton){  
    		if (cartPanel.isVisible() == false){    

	    		//IO for cartTable
	            totalPrice = 0.0;
	    		String[] cartColumnsName = {"Name","Price","Category","App ID"};
	    		cartTableModel.setColumnIdentifiers(cartColumnsName);

	            for (int i=0;Cart.gamesCart[i]!=null;i++){

	            	totalPrice = (totalPrice + Cart.gamesCart[i].getPrice());
	            	String name = Cart.gamesCart[i].getName();
	        		String price = String.valueOf(Cart.gamesCart[i].getPrice());
	        		String category = Cart.gamesCart[i].getCategory();
	        		String appid = Cart.gamesCart[i].getAppID();
	            	
	        		String [] dataRow = {name, price, category, appid};
	            
	            	cartTableModel.addRow(dataRow);
	            }
	            
	            totalPriceLabel.setText("Total price is: " + totalPrice);
	    		
	            userDetailsLabel.setVisible(false);
	            gamesLabel.setVisible(false);
	    		searchLabel.setVisible(false);
				insertLabel.setVisible(false);
				deleteLabel.setVisible(false);
	    		
				userDetailsPanel.setVisible(false);
				gamesPanel.setVisible(false);
				searchPanel.setVisible(false);
				insertPanel.setVisible(false);
				deletePanel.setVisible(false);
				
	            
				cartLabel.setVisible(true);
				cartPanel.setVisible(true);
    		}
		}
    	
    	if(e.getSource()==cartButton2){
    		//****
    		
    		for (int i=0;i<Cart.gamesCart.length;i++){
    			Cart.gamesCart[i] = null;
    		}
    		
    	}
    	
		if(e.getSource()==insertButton){  
			userDetailsLabel.setVisible(false);
			gamesLabel.setVisible(false);
			searchLabel.setVisible(false);
			cartLabel.setVisible(false);
			deleteLabel.setVisible(false);
			
			userDetailsPanel.setVisible(false);
			gamesPanel.setVisible(false);
    		searchPanel.setVisible(false);
    		cartPanel.setVisible(false);
			deletePanel.setVisible(false);
            
			insertLabel.setVisible(true);
			insertPanel.setVisible(true);
		}
		
		if(e.getSource()==insertButton2){  
			String name = insNameField.getText();
			String price = insPriceField.getText();
			String category = insCategoryField.getText();
			String appid = insAppIDField.getText();
			
			if (name.length() == 0 || price.length() == 0 || category.length() == 0 || appid.length() == 0) {
	            JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
	                    JOptionPane.WARNING_MESSAGE);
	        }
			
			else {
				try {
					File file = new File("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\game_data.txt");
                
					if (!file.exists()) {
						file.createNewFile();
					}
               
					FileWriter fw = new FileWriter(file, true);
					BufferedWriter bw = new BufferedWriter(fw);
                	try (PrintWriter pw = new PrintWriter(bw)) {
						pw.println(name + " / " + price + " / " + category + " / " + appid);
					}
				}
				catch (Exception ex) {
					System.out.print(ex);
				}
				JOptionPane.showMessageDialog(null, "Game Successfully Inserted.",
	            "Insertion Complete", JOptionPane.WARNING_MESSAGE);
			}	
		}
		
		if(e.getSource()==deleteButton){  
			userDetailsLabel.setVisible(false);
			gamesLabel.setVisible(false);
			searchLabel.setVisible(false);
			cartLabel.setVisible(false);
			insertLabel.setVisible(false);
			
			userDetailsPanel.setVisible(false);
			gamesPanel.setVisible(false);
    		searchPanel.setVisible(false);
    		cartPanel.setVisible(false);
			insertPanel.setVisible(false);
            
			deleteLabel.setVisible(true);
			deletePanel.setVisible(true);
		}
		
		if(e.getSource()==deleteButton2){  
			
			String appid = delField.getText();
			
			if (appid.length() == 0) {
	            JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
	            JOptionPane.WARNING_MESSAGE);
	        }
			
			else {
				try {
					File file = new File("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\game_data.txt");
                
					if (!file.exists()) {
//						file.createNewFile();
						JOptionPane.showMessageDialog(null, "There is nothing to delete - game_data.txt Does Not Exist", "Warning!",
			            JOptionPane.WARNING_MESSAGE);
					}

					String line;
					BufferedReader br = null;

					try{
						br = new BufferedReader(new FileReader("C:\\Users\\TAHSIN\\Desktop\\TARANISH OOP-1 Final Project\\Project Taranish\\src\\data\\game_data.txt"));
					} 
	            	catch (FileNotFoundException e1){
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					Object [] tableLines = br.lines().toArray();
					
					
					boolean deletionFlag = false;
					
					for(int i=0;i<tableLines.length;i++){
						line = tableLines[i].toString().trim();
						if (!line.equals("")){
							String [] dataRow = line.split(" / ");
							
							//for discarding first line in data file
							if(i>0){
								//App ID is stored in the 3rd index of dataRow
								if(appid.equals(dataRow[3])){
									Overwrite.setVariable(i+1, "");
									JOptionPane.showMessageDialog(null, "Game with App ID: " + appid + " has been successfully deleted.",
						            "Deletion Complete", JOptionPane.WARNING_MESSAGE);
									deletionFlag = true;
								}
							}
						}
					}
					
					if (deletionFlag == false){
						JOptionPane.showMessageDialog(null, "App ID Not Found - Failed To Delete",
			            "Deletion FAILED", JOptionPane.WARNING_MESSAGE);
					}
					
				}
					
				catch (Exception ex){
					System.out.print(ex);
				}
			}	
		}
		
		if(e.getSource()==logoutButton){  
			mainFrame.setVisible(false);
            new Login();
            mainFrame.dispose();
		}
	}
}
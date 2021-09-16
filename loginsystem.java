//package loginsystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.sql.*;
//import javax.swing.*;
//import org.json.JSONObject;
//import com.google.gson.*;
//import com.mashape.unirest.http.*;
//
//
//
//public class loginsystem implements ActionListener{
//	
//	static JFrame frame = new JFrame();
//	static JPanel panel = new JPanel();
//	
//	Connection con = makeconnection();
//	Statement  stm = makestatment(con); 
//	
//	static int height , width ;
//	
//	public static void main(String args[]) {
//		
//		frame.setTitle("LoginSystem");
//		frame.setVisible(true);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		height = frame.getSize().height;
//		width  = frame.getSize().width ; 
//		
//		panel.setSize(height , width);
//		panel.setBackground(Color.BLACK);
//		panel.setLayout(null);
//
//		frame.add(panel);
//		
//		loginsystem l = new loginsystem();
//		l.loginmenu(true);   // make it true to run
//	}
//	
//    public Connection makeconnection() {
//    	String username = "root";
//        String password = ""    ;
//        String url = "jdbc:mysql://localhost:3308/database";
//        
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Connection con = null;
//		try {
//			con = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//        
//    	return con ;
//    }
//    
//    public Statement makestatment(Connection con) {
//    	Statement stm = null ;
//    	try {
//			stm = con.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return stm;
//    }
//    
//	public void loginmenu(boolean ani) {
//		
//		ImageIcon background_image = new ImageIcon("src\\loginsystem\\Pictures\\b5.jpg");
//		
//		JLabel background = new JLabel(background_image);
//		panel.add(background);
//		background.setBounds(0 , 0 , width , height);
//		
//		int s = 0 , ms = 1 ; // time
//		
//		/////////////////////////////////////////  signin menu
//		
//		JButton signin = new JButton("Sign In");
//		background.add(signin);
//		signin.setFont(new Font("",Font.PLAIN,20));
//		signin.setBackground(Color.ORANGE);
//		
//		JLabel username_label = new JLabel("Username");
//		background.add(username_label);
//		username_label.setForeground(new Color(253, 65, 82 ));
//		username_label.setFont(new Font("",Font.PLAIN,24));
//		
//		JTextField username_signin = new JTextField();
//		background.add(username_signin);
//		username_signin.setBackground(Color.LIGHT_GRAY);
//		username_signin.setFont(new Font("",Font.PLAIN,24));
//		
//		JLabel password_label = new JLabel("Password");
//		background.add(password_label);
//		password_label.setForeground(new Color(253, 65, 82 ));
//		password_label.setFont(new Font("",Font.PLAIN,24));
//		
//		JPasswordField password_signin = new JPasswordField();
//		background.add(password_signin);
//		password_signin.setBackground(Color.LIGHT_GRAY);
//		password_signin.setFont(new Font("",Font.PLAIN,24));
//		
//		///////////////////////////////////////////////////////  SignUp menu
//		
//		JButton signup = new JButton("Sign Up");
//		background.add(signup);
//		signup.setBackground(Color.ORANGE);
//		signup.setFont(new Font("",Font.PLAIN,20));
//	
//		JLabel firstname_signup_label = new JLabel("First Name");
//		background.add(firstname_signup_label);
//		firstname_signup_label.setForeground(new Color(253, 65, 82 ));
//		firstname_signup_label.setFont(new Font("",Font.PLAIN,24));
//		
//		JTextField firstname_signup = new JTextField();
//		background.add(firstname_signup);
//		firstname_signup.setBackground(Color.LIGHT_GRAY);
//		firstname_signup.setFont(new Font("",Font.PLAIN,24));
//		
//		JLabel secondname_signup_label = new JLabel("Second Name");
//		background.add(secondname_signup_label);
//		secondname_signup_label.setForeground(new Color(253, 65, 82 ));
//		secondname_signup_label.setFont(new Font("",Font.PLAIN,24));
//	
//		JTextField secondname_signup = new JTextField();
//		background.add(secondname_signup);
//		secondname_signup.setBackground(Color.LIGHT_GRAY);
//		secondname_signup.setFont(new Font("",Font.PLAIN,24));
//		
//		JLabel username_signup_label = new JLabel("Username");
//		background.add(username_signup_label);
//		username_signup_label.setForeground(new Color(253, 65, 82 ));
//		username_signup_label.setFont(new Font("",Font.PLAIN,24));
//		
//		JTextField username_signup = new JTextField();
//		background.add(username_signup);
//		username_signup.setBackground(Color.LIGHT_GRAY);
//		username_signup.setFont(new Font("",Font.PLAIN,24));
//		
//		JLabel password_signup_label = new JLabel("Password");
//		background.add(password_signup_label);
//		password_signup_label.setForeground(new Color(253, 65, 82 ));
//		password_signup_label.setFont(new Font("",Font.PLAIN,24));
//		
//		JPasswordField password_signup = new JPasswordField();
//		background.add(password_signup);
//		password_signup.setBackground(Color.LIGHT_GRAY);
//		password_signup.setFont(new Font("",Font.PLAIN,24));
//
//		JLabel confirm_password_signup_label = new JLabel("<html><span>Confirm <br> Password</span></html>");
//		background.add(confirm_password_signup_label);
//		confirm_password_signup_label.setForeground(new Color(253, 65, 82 ));
//		confirm_password_signup_label.setFont(new Font("",Font.PLAIN,24));
//		
//		JPasswordField confirm_password_signup = new JPasswordField();
//		background.add(confirm_password_signup);
//		confirm_password_signup.setBackground(Color.LIGHT_GRAY);
//		confirm_password_signup.setFont(new Font("",Font.PLAIN,24));
//		
//		if(ani) {
//			
//		for(int i = -300 ; i < 300 ; i++) {
//			try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			firstname_signup_label.setBounds(i-200 , 100 , 200 , 50);
//			firstname_signup.setBounds(i , 100 , 200 , 50);
//		}
//		
//		for(int i = -300 ; i < 300 ; i++) {
//		try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			secondname_signup_label.setBounds(i-200 , 200 , 200 , 50);
//			secondname_signup.setBounds(i , 200 , 200 , 50);
//		}
//		
//		for(int i = -300 ; i < 300 ; i++) {
//		try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			username_signup_label.setBounds(i-200 , 300 , 200 , 50);
//			username_signup.setBounds(i , 300 , 200 , 50);
//		}
//		
//		for(int i = -300 ; i < 300 ; i++) {
//			try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			password_signup_label.setBounds(i-200 , 400 , 200 , 50);
//			password_signup.setBounds(i , 400 , 200 , 50);
//		}
//		
//		for(int i = -300 ; i < 300 ; i++) {
//			try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			confirm_password_signup_label.setBounds(i-200 , 500 , 200 , 50);
//			confirm_password_signup.setBounds(i , 500 , 200 , 50);
//		}
//		
//		for(int i = width ; i > width-500 ; i--) {
//			try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			username_label.setBounds(i , 400 , 200 , 50);
//			username_signin.setBounds(i+150 , 400 , 200 , 50);
//		}
//		
//		for(int i = width ; i > width-500 ; i--) {
//			try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			password_label.setBounds(i , 500 , 200 , 50);
//			password_signin.setBounds(i+150 , 500 , 200 , 50);
//		}
//			
//		for(int i = width ; i > width-350 ; i--) {
//			try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			signin.setBounds(i , 600 , 200 , 50); 
//		}
//		
//		for(int i = -300 ; i < 300 ; i++) {
//			try { Thread.sleep(s,ms);
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			signup.setBounds(i , 600 , 200 , 50); 
//		}
//		
//	}	else {
//			
//			signin.setBounds(1266 , 600 , 200 , 50);
//			signup.setBounds(300 , 600 , 200 , 50);
//			username_label.setBounds(1116 , 400 , 200 , 50);
//			username_signin.setBounds(1266 , 400 , 200 , 50);
//			password_label.setBounds(1116 , 500 , 200 , 50);
//			password_signin.setBounds(1266 , 500 , 200 , 50);
//			
//			firstname_signup_label.setBounds(100 , 100 , 200 , 50);
//			firstname_signup.setBounds(300 , 100 , 200 , 50);
//			secondname_signup_label.setBounds(100 , 200 , 200 , 50);
//			secondname_signup.setBounds(300 , 200 , 200 , 50);
//			username_signup_label.setBounds(100 , 300 , 200 , 50);
//			username_signup.setBounds(300 , 300 , 200 , 50);
//			password_signup_label.setBounds(100 , 400 , 200 , 50);
//			password_signup.setBounds(300 , 400 , 200 , 50);
//			confirm_password_signup_label.setBounds(100 , 500 , 200 , 50);
//			confirm_password_signup.setBounds(300 , 500 , 200 , 50);
//			
//		}
//		
//		JTextField er = new JTextField();
//		background.add(er);
//		er.setForeground(Color.ORANGE);
//		er.setBackground(Color.BLACK);
//		er.setFont(new Font("",Font.PLAIN,18));
//		er.setBounds(1150 , 50 , 400 , 50);
//				
//		/////////////////////////////////////////////////////////// Buttons actions
//		
//		signin.addActionListener(new ActionListener() {
//		
//		public void actionPerformed(ActionEvent event) {
//			
//			if(username_signin.getText().equals("")) {
//				er.setText(" SignIN : Username cannot be Empty");
//			}else if(password_signin.getText().equals("")) {
//				er.setText(" SignIN : Password cannot be Empty");
//			}else {
//				
//				String username = username_signin.getText() ;
//				String password = password_signin.getText() ; 
//				
//				String query2 = "SELECT  `password` FROM `logindata` WHERE `Username` = \'"+username+"\' "; 
//				
//				ResultSet result = null ;
//				try {
//					 result = stm.executeQuery(query2) ;
//				} catch (SQLException e) {
//					er.setText("SignIn : Username Not Found");
//					e.printStackTrace();
//				}
//				
//				try {
//					result.next();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				
//				try {
//					if(password.equals(result.getString("password"))) {
//						
//						er.setText("SignIn : SignIn Successfull ");
//						
//						panel.removeAll();
//						panel.updateUI();
//						
//						if(username.equals("admin")) {
//							adminmenu(0);
//						}
//						else {
//							try {
//								usermenu();
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//					}
//					
//					else {
//						er.setText("SignIn : Password Incorrect ");
//					}
//				} catch (SQLException e) {
//					er.setText("SignIn : Username Not Found");
//				}
//			}
//		}
//			});
//	
//		signup.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				
//				if(firstname_signup.getText().equals("")) {
//					er.setText("SignUp : First name cannot be Empty");
//				}else if (!(firstname_signup.getText().matches("^[A-Za-z]+$"))) {
//					er.setText("SignUp : Name Cannot have Numerics or spaces");
//				}else if(secondname_signup.getText().equals("")) {
//					er.setText("SignUp : Second name cannot be Empty");
//				}else if (!(secondname_signup.getText().matches("^[A-Za-z]+$"))) {
//					er.setText("SignUp : Name Cannot have Numerics or spaces");
//				}else if(username_signup.getText().equals("")) {
//					er.setText("SignUp : Username cannot be Empty");
//				}else if(!(username_signup.getText().matches("^[A-Za-z0-9_]+$"))) {
//					er.setText("SignUp : Username cannot have space");
//				}else if(password_signup.getText().equals("")) {
//					er.setText("SignUp : Password cannot be Empty");
//				}else if(confirm_password_signup.getText().equals("")) {
//					er.setText("SignUp : Confirm password cannot be Empty");
//				}else if(! (confirm_password_signup.getText().equals(password_signup.getText()) ) ) {
//					er.setText("SignUp : Password Mismatch");
//				}else {
//					
//					{
//						
//					String fname = firstname_signup.getText() ;
//					String sname = secondname_signup.getText();
//					String uname = username_signup.getText();
//					String pass  = password_signup.getText();
//					
//					String insertquery = "INSERT INTO `logindata` (`fname`, `sname`, `username` , `password`) "
//							+ "VALUES ( \'" + fname + "\' ,\'"+ sname +"\',\'"+ uname +"\',\'"+pass+"\' )"; 
//					
//					try {
//						stm.executeUpdate(insertquery);
//						er.setText("SignUp : Successfull");
//						
//						firstname_signup.setText("");
//						secondname_signup.setText("");
//						username_signup.setText("");
//						password_signup.setText("");
//						confirm_password_signup.setText("");
//						
//					} catch (SQLIntegrityConstraintViolationException e) {
//						er.setText("SignUp : Username already Exists");
//						}
//					catch (SQLException e) {	e.printStackTrace();	}
//					}
//				}
//			}
//		});
//	}
//
//	public void adminmenu(int printfromid) {
//		
//		int temppid = 0 ;
//		
//		ImageIcon background_image = new ImageIcon("src\\loginsystem\\Pictures\\b8.jpg");
//		
//		JLabel background = new JLabel(background_image);
//		panel.add(background);
//		background.setBounds(0 , 0 , width , height);
//		
//		////////////////////////////////////////////////////////////
//		
//		JTextField er = new JTextField();
//		background.add(er);
//		er.setForeground(Color.ORANGE);
//		er.setBackground(Color.BLACK);
//		er.setFont(new Font("",Font.PLAIN,18));
//		er.setBounds(1150 , 50 , 400 , 50);
//		
//		////////////////////////////////////////////////////////////
//		
//
//		int y = 100  , x = 100 , tempy = 800 ; 
//		
//		JLabel idLabel       = new JLabel("ID");
//		JLabel fnameLabel    = new JLabel("First Name");
//		JLabel snameLabel    = new JLabel("Second Name");
//		JLabel usernamelabel = new JLabel("User Name");
//		JLabel passwordlabel = new JLabel("Password");
//		
//		idLabel		 .setBounds(x 		, 100 , 200, 50);
//		fnameLabel	 .setBounds(x + 200 , 100 , 200, 50);
//		snameLabel	 .setBounds(x + 400 , 100 , 200, 50);
//		usernamelabel.setBounds(x + 600 , 100 , 200, 50);
//		passwordlabel.setBounds(x + 800 , 100 , 200, 50);
//		
//		idLabel		 .setFont(new Font("",Font.BOLD,22));
//		fnameLabel	 .setFont(new Font("",Font.BOLD,22));
//		snameLabel	 .setFont(new Font("",Font.BOLD,22));
//		usernamelabel.setFont(new Font("",Font.BOLD,22));
//		passwordlabel.setFont(new Font("",Font.BOLD,22));
//		
//		Color color2 = new Color(255, 170, 0);
//		
//		idLabel		 .setForeground(color2);
//		fnameLabel	 .setForeground(color2);
//		snameLabel	 .setForeground(color2);
//		usernamelabel.setForeground(color2);
//		passwordlabel.setForeground(color2);
//		
//		background.add(idLabel);	
//		background.add(fnameLabel);
//		background.add(snameLabel);
//		background.add(usernamelabel);
//		background.add(passwordlabel);
//		
//		
//		
//		String query2 = "SELECT * FROM logindata WHERE id > "+printfromid ;
//		
//		ResultSet result = null;
//		try {
//			result = stm.executeQuery(query2);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//
//		try {
//		
//			while(result.next()){ 
//				
//				y = y + 50 ;
//				
//				JLabel tempidLabel       = new JLabel(String.valueOf(result.getInt("id")));
//				JLabel tempfnameLabel    = new JLabel(result.getString("fname"));
//				JLabel tempsnameLabel    = new JLabel(result.getString("sname"));
//				JLabel tempusernamelabel = new JLabel(result.getString("username"));
//				JLabel temppasswordlabel = new JLabel(result.getString("password"));
//				
//				tempidLabel		 .setBounds(x		 , y , 200, 50);
//				tempfnameLabel	 .setBounds(x + 200  , y , 200, 50);
//				tempsnameLabel	 .setBounds(x + 400  , y , 200, 50);
//				tempusernamelabel.setBounds(x + 600  , y , 200, 50);
//				temppasswordlabel.setBounds(x + 800  , y , 200, 50);
//				
//				tempidLabel		 .setFont(new Font("",Font.PLAIN,20));
//				tempfnameLabel	 .setFont(new Font("",Font.PLAIN,20));
//				tempsnameLabel	 .setFont(new Font("",Font.PLAIN,20));
//				tempusernamelabel.setFont(new Font("",Font.PLAIN,20));
//				temppasswordlabel.setFont(new Font("",Font.PLAIN,20));
//				
//				Color color1 = new Color(255, 77, 0) ;
//				
//				tempidLabel		 .setForeground(color1);
//				tempfnameLabel	 .setForeground(color1);
//				tempsnameLabel	 .setForeground(color1);
//				tempusernamelabel.setForeground(color1);
//				temppasswordlabel.setForeground(color1);
//				
//				background.add(tempidLabel);	
//				background.add(tempfnameLabel);
//				background.add(tempsnameLabel);
//				background.add(tempusernamelabel);
//				background.add(temppasswordlabel);
//			
//				if(y>=450) {
//					
//					temppid = result.getInt("id") ;
//					
//					break;
//				}
//								
//				tempy = y ;
//			}
//		}catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		
//		////////////////////////////////////////////////////////////
//		
//		JTextField selectedid = new JTextField();
//		JTextField selectedfname = new JTextField();
//		JTextField selectedsname = new JTextField();
//		JTextField selectedusername = new JTextField();
//		JTextField selectedpassword = new JTextField();
//		
//		selectedid		 .setBounds(x		 , tempy+100 , 150, 50);
//		selectedfname	 .setBounds(x + 200  , tempy+100 , 150, 50);
//		selectedsname	 .setBounds(x + 400  , tempy+100 , 150, 50);
//		selectedusername .setBounds(x + 600  , tempy+100 , 150, 50);
//		selectedpassword .setBounds(x + 800  , tempy+100 , 150, 50);
//		
//		selectedid		 .setBackground(Color.GRAY);
//		selectedfname	 .setBackground(Color.GRAY);
//		selectedsname	 .setBackground(Color.GRAY);
//		selectedusername .setBackground(Color.GRAY);
//		selectedpassword .setBackground(Color.GRAY);
//		
//		selectedid		 .setForeground(Color.black);
//		selectedfname	 .setForeground(Color.black);
//		selectedsname	 .setForeground(Color.black);
//		selectedusername .setForeground(Color.black);
//		selectedpassword .setForeground(Color.black);
//		
//		selectedid		 .setFont(new Font("",Font.PLAIN,20));
//		selectedfname	 .setFont(new Font("",Font.PLAIN,20));
//		selectedsname	 .setFont(new Font("",Font.PLAIN,20));
//		selectedusername .setFont(new Font("",Font.PLAIN,20));
//		selectedpassword .setFont(new Font("",Font.PLAIN,20));
//		
//		background.add(selectedid);	
//		background.add(selectedfname);
//		background.add(selectedsname);
//		background.add(selectedusername);
//		background.add(selectedpassword);
//		
//		//////////////////////////////////////////////////////
//		
//		JButton select = new JButton("Select");
//		background.add(select);
//		select.setBackground(Color.ORANGE);
//		select.setFont(new Font("",Font.PLAIN,20));
//		select.setBounds(100 , 700 , 200 , 50);
//		
//		JButton edit = new JButton("Edit");
//		background.add(edit);
//		edit.setBackground(Color.ORANGE);
//		edit.setFont(new Font("",Font.PLAIN,20));
//		edit.setBounds(350 , 700 , 200 , 50);
//		
//		JButton delete = new JButton("Delete");
//		background.add(delete);
//		delete.setBackground(Color.ORANGE);
//		delete.setFont(new Font("",Font.PLAIN,20));
//		delete.setBounds(600 , 700 , 200 , 50);
//		
//		JButton next = new JButton("next");
//		background.add(next);
//		next.setBackground(Color.ORANGE);
//		next.setFont(new Font("",Font.PLAIN,20));
//		next.setBounds(850 , 700 , 200 , 50);
//		
//		JButton logout = new JButton("Log out");
//		background.add(logout);
//		logout.setBackground(Color.ORANGE);
//		logout.setFont(new Font("",Font.PLAIN,20));
//		logout.setBounds(1250 , 700 , 200 , 50);
//		
//		//////////////////////////////////////////////
//		
//		select.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				int id = 0 ;
//		
//					if(!(selectedid.getText().matches("^[0-9]+$"))) {
//						er.setText("Id Must be Numeric Value");
//					}else if(selectedid.getText().equals("")){
//						er.setText("Id Cannot be Empty");
//					}
//					else {
//						id = Integer.parseInt(selectedid.getText());
//						er.setText("Id Selected : " + id);
//						
//						String query3 = "SELECT * FROM logindata WHERE id = " + id ;
//						
//						try {
//							ResultSet result = stm.executeQuery(query3);
//							result.next();
//							
//							selectedfname.setText(result.getString("fname"));
//							selectedsname.setText(result.getString("sname"));
//							selectedusername.setText(result.getString("username"));
//							selectedpassword.setText(result.getString("password"));
//							
//						} catch (SQLException e1) {
//							er.setText("Selected ID Cannot be found , Id : " + id);
//						}
//					}
//			}});
//		
//		
//		/////////////////////////////////////////////////////////////////////////////////
//		
//		delete.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				int    id ;
//			
//				try { id     = Integer.parseInt(selectedid.getText());}
//				catch(Exception ex){  id = 0 ; }
//				
//				if(id == 0) {
//					er.setText("ID Must Be Numeric Value Greator Then 0");
//				}
//				else {
//				String query4 = "DELETE FROM logindata WHERE id = " + id ;
//				
//				try {
//					stm.execute(query4) ;
//					er.setText("Id deleted : "+id);
//					
//					panel.removeAll();
//					panel.updateUI();
//					
//					adminmenu(printfromid);
//				} catch (SQLException e1) {
//					er.setText("Error");
//				}
//			}
//		}});
//		
//		/////////////////////////////////////////////////////////////////////
//		
//		edit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		
//				String fname = selectedfname.getText() ;
//				String sname = selectedsname.getText() ;
//				String username = selectedusername.getText();
//				String password = selectedpassword.getText();
//				
//				int    id = 0 ;
//				try { id     = Integer.parseInt(selectedid.getText());}
//				catch(Exception ex){  id = 0 ; }
//				
//				if (fname.equals("")) {
//					er.setText("First Name cannot be Empty");
//				}
//				else if (!(fname.matches("^[A-Za-z]+$"))) {
//					er.setText("Name Cannot have Numeric Value");
//				}
//				else if (sname.equals("")) {
//					er.setText("Second Name cannot be Empty");
//				}
//				else if (!(sname.matches("^[A-Za-z]+$"))) {
//					er.setText("Name Cannot have Numeric Value");
//				}
//				else if(username.equals("")) {
//					er.setText("Username Cannot be Empty");
//				}
//				else if(password.equals("")) {
//					er.setText("Password Cannot be Empty");
//				}
//				else if(id == 0) {
//					er.setText("ID Must Be Numeric Value Greator Then 0");
//				}
//				else
//				{
//					String query4 = "UPDATE `logindata` SET `fname` = \'"+fname+"\' , "
//							+ "`sname` = \'"+sname+"\'  , `password` = \'"+password+"\', "
//							+ "`username` = \'"+username+"\'"
//							+ "WHERE `id` = \'" + id + "\'";
//					
//					try {
//						stm.execute(query4) ;
//						er.setText("Id Edited : "+id);
//						
//						panel.removeAll();
//						panel.updateUI();
//						
//						adminmenu(printfromid);
//						
//					} catch (SQLIntegrityConstraintViolationException e1) {
//						er.setText("Username already Exists");
//						}
//					catch (SQLException e1) {
//						er.setText("Error");
//						e1.printStackTrace();}
//				}
//				
//		
//			}});
//		
//		//////////////////////////////////////////////////////////////////////
//		
//		logout.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				
//				panel.removeAll();
//				panel.updateUI();
//				
//				loginmenu(false);
//				
//		}});
//		
//		//////////////////////////////////////////////////////////////////////////
//		
//		int xx = temppid ;
//		
//		next.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				
//				panel.removeAll();
//				panel.updateUI();
//				
//				adminmenu(xx);
//		}});		
//	}
//	
//	public void usermenu() throws Exception {
//		
//		ImageIcon background_image = new ImageIcon("src\\loginsystem\\Pictures\\b6.jpg");
//		
//		JLabel background = new JLabel(background_image);
//		panel.add(background);
//		background.setBounds(0 , 0 , width , height);
//		
//		////////////////////////////////////////////////////////////
//		
//		JTextField er = new JTextField();
//		background.add(er);
//		er.setForeground(Color.ORANGE);
//		er.setBackground(Color.BLACK);
//		er.setFont(new Font("",Font.PLAIN,18));
//		er.setBounds(1150 , 50 , 400 , 50);
//
//		JTextField input = new JTextField();
//		background.add(input);
//		input.setForeground(Color.BLUE);
//		input.setBackground(Color.BLACK);
//		input.setFont(new Font("",Font.PLAIN,18));
//		input.setBounds(150 , 50 , 200 , 50);
//		
//		JButton logout = new JButton("Log out");
//		background.add(logout);
//		logout.setBackground(Color.ORANGE);
//		logout.setFont(new Font("",Font.PLAIN,20));
//		logout.setBounds(1250 , 700 , 200 , 50);
//		
//		JButton search = new JButton("Search");
//		background.add(search);
//		search.setBackground(Color.ORANGE);
//		search.setFont(new Font("",Font.PLAIN,20));
//		search.setBounds(400 , 50 , 100 , 50);
//		
//		/////////////////////////////////////////////////////////////
//		
//		JPanel imgsection = new JPanel();
//		background.add(imgsection);
//		imgsection.setVisible(true);
//		imgsection.setBounds(1200 , 150 , 350 , 500);
//		imgsection.setBackground(Color.BLACK);
//		
//		///////////////////////////////////////////////////////////
//		
//		JPanel datasection = new JPanel();
//		datasection.setVisible(true);
//		datasection.setLayout(null);
//		datasection.setBounds(150 , 150 , 800 , 500);
//		datasection.setBackground(new Color(37, 11, 38));
//		
//		
//		JScrollPane jp = new JScrollPane(datasection);
//		jp.setViewportView (datasection);
//
//		background.add(jp);
//		jp.setVisible(true);
//		
//		
//		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
//		jp.setBounds(150 , 150 , 800 , 500);
//	
//	
//		
//		////////////////////////////////////////////////////////
//		search.addActionListener(new ActionListener() {
//		
//		public void actionPerformed(ActionEvent e) {
//				
//			String heroname = null ;
//			if(input.getText().equals("")) {
//				er.setText("Please enter a name");
//			}
//			else {
//			
//			heroname = input.getText();
//			er.setText("Searching");
//				
//			HttpResponse<String> response = null ;
//				
//				try {
//					response = Unirest.get("https://superhero-search.p.rapidapi.com/api/?hero="+heroname+"")
//								.header("x-rapidapi-host", "superhero-search.p.rapidapi.com")
//								.header("x-rapidapi-key", "d687dcad99msh3fc9fb2e826b4b6p13a74cjsnd17623d827b1")
//								.asString();
//				} catch (Exception e1) {
//					er.setText("Error: Could not connect to database");
//					e1.printStackTrace();
//				}
//				
//				if(response.getStatus() != 200 ) {
//					er.setText("Error");
//				}
//				
//				String data = null ;
//				try {
//				 Gson gson = new GsonBuilder().setPrettyPrinting().create();
//				 JsonParser jp = new JsonParser();
//				 JsonElement je = jp.parse(response.getBody().toString());
//				 data = gson.toJson(je);
//				 
//				 JSONObject dataobj = new JSONObject(data);
//				 
//				 //////////////////////////////////////////////////////////////
//				 
//				 JSONObject imagesobj = dataobj.getJSONObject("images");
//				 String picture = imagesobj.getString("md");
//				 
//				 ImageIcon heropicture = null ;
//				 JLabel heroimage = null ;
//				 
//				 URL pictureurl = null ;
//				 try {
//					pictureurl = new URL(picture);
//					imgsection.removeAll();
//					imgsection.updateUI();
//					heropicture = new ImageIcon(pictureurl) ;
//					heroimage   = new JLabel(heropicture)   ;
//				} catch (MalformedURLException e1) {
//					heroimage   = new JLabel("Image Not Found");
//					heroimage.setForeground(Color.RED);
//				}
//				 
//				 	imgsection.add(heroimage);
//				 	heroimage.setBounds(0, 50, 350 , 500);
//				 /////////////////////////////////////////////////////
//				 					 	
//				 	String[] dataparts = data.split(",");
//				 	
//				 	datasection.removeAll();
//				 	datasection.updateUI();
//				 	
//				 	int y_axis = 30 ;
//				 	int x_axis = 20 ;
//				 	for(int i=0 ; i < dataparts.length ; i++) {
//				 		
//				 		if(dataparts[i].contains("images")) {
//							break ;
//						}
//				 		 			
//				 		JLabel datalabel = new JLabel(dataparts[i]);
//						datasection.add(datalabel);
//						
//						datalabel.setForeground(Color.ORANGE);
//						datalabel.setFont(new Font("",Font.BOLD,20));
//						datalabel.setBounds(x_axis, y_axis, 800 , 50);
//						y_axis = y_axis + 50 ;
//									
//				 	}
//
//				 /////////////////////////////////////////////////////
//				 
//				 	er.setText("Found");
//				 	
//				} catch (Exception e1) {
//					
//					er.setText("Not Found");
//					
//					datasection.removeAll();
//					datasection.updateUI();
//					imgsection.removeAll();
//					imgsection.updateUI();
//					
//				}
//			
//	}		
//		}});
//
//		
//	  
//		
//		
//		
//		
//     
//	
//		///////////////////////////////////////////////////////////
//		
//		logout.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				
//				panel.removeAll();
//				panel.updateUI();
//				
//				loginmenu(false);
//				
//		}});	
//		
//	}
//	
//	
//	public void actionPerformed(ActionEvent e) {	}
//
//}
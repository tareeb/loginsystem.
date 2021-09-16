package loginsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import java.util.*;

public class Gui {
	
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	
	Database database = new Database("root","");
	HeroApi heroapi   = new HeroApi();
	
	int height , width ;
	
	Gui(String title){
		frame.setTitle(title);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		height = frame.getSize().height;
		width  = frame.getSize().width ; 
		
		panel.setSize(height , width);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);

		frame.add(panel);
		
		loginmenu(true);
		
	}
	
	public void loginmenu(boolean animation) {
		
		ImageIcon background_image = new ImageIcon("src\\loginsystem\\Pictures\\b5.jpg");
		
		JLabel background = new JLabel(background_image);
		panel.add(background);
		background.setBounds(0 , 0 , width , height);
		
		int s = 0 , ms = 1 ; // time for animation
		
		///////////////////  SignIn menu  ///////////////////////
		
		JButton signin = new JButton("Sign In");
		background.add(signin);
		signin.setFont(new Font("",Font.PLAIN,20));
		signin.setBackground(Color.ORANGE);
		
		JLabel username_label = new JLabel("Username");
		background.add(username_label);
		username_label.setForeground(new Color(253, 65, 82 ));
		username_label.setFont(new Font("",Font.PLAIN,24));
		
		JTextField username_signin = new JTextField();
		background.add(username_signin);
		username_signin.setBackground(Color.LIGHT_GRAY);
		username_signin.setFont(new Font("",Font.PLAIN,24));
		
		JLabel password_label = new JLabel("Password");
		background.add(password_label);
		password_label.setForeground(new Color(253, 65, 82 ));
		password_label.setFont(new Font("",Font.PLAIN,24));
		
		JPasswordField password_signin = new JPasswordField();
		background.add(password_signin);
		password_signin.setBackground(Color.LIGHT_GRAY);
		password_signin.setFont(new Font("",Font.PLAIN,24));
		
		///////////////////  SignUp menu  ///////////////////////
		
		JButton signup = new JButton("Sign Up");
		background.add(signup);
		signup.setBackground(Color.ORANGE);
		signup.setFont(new Font("",Font.PLAIN,20));
	
		JLabel firstname_signup_label = new JLabel("First Name");
		background.add(firstname_signup_label);
		firstname_signup_label.setForeground(new Color(253, 65, 82 ));
		firstname_signup_label.setFont(new Font("",Font.PLAIN,24));
		
		JTextField firstname_signup = new JTextField();
		background.add(firstname_signup);
		firstname_signup.setBackground(Color.LIGHT_GRAY);
		firstname_signup.setFont(new Font("",Font.PLAIN,24));
		
		JLabel secondname_signup_label = new JLabel("Second Name");
		background.add(secondname_signup_label);
		secondname_signup_label.setForeground(new Color(253, 65, 82 ));
		secondname_signup_label.setFont(new Font("",Font.PLAIN,24));
	
		JTextField secondname_signup = new JTextField();
		background.add(secondname_signup);
		secondname_signup.setBackground(Color.LIGHT_GRAY);
		secondname_signup.setFont(new Font("",Font.PLAIN,24));
		
		JLabel username_signup_label = new JLabel("Username");
		background.add(username_signup_label);
		username_signup_label.setForeground(new Color(253, 65, 82 ));
		username_signup_label.setFont(new Font("",Font.PLAIN,24));
		
		JTextField username_signup = new JTextField();
		background.add(username_signup);
		username_signup.setBackground(Color.LIGHT_GRAY);
		username_signup.setFont(new Font("",Font.PLAIN,24));
		
		JLabel password_signup_label = new JLabel("Password");
		background.add(password_signup_label);
		password_signup_label.setForeground(new Color(253, 65, 82 ));
		password_signup_label.setFont(new Font("",Font.PLAIN,24));
		
		JPasswordField password_signup = new JPasswordField();
		background.add(password_signup);
		password_signup.setBackground(Color.LIGHT_GRAY);
		password_signup.setFont(new Font("",Font.PLAIN,24));

		JLabel confirm_password_signup_label = new JLabel("<html><span>Confirm <br> Password</span></html>");
		background.add(confirm_password_signup_label);
		confirm_password_signup_label.setForeground(new Color(253, 65, 82 ));
		confirm_password_signup_label.setFont(new Font("",Font.PLAIN,24));
		
		JPasswordField confirm_password_signup = new JPasswordField();
		background.add(confirm_password_signup);
		confirm_password_signup.setBackground(Color.LIGHT_GRAY);
		confirm_password_signup.setFont(new Font("",Font.PLAIN,24));
		
		if(animation) {
			
		for(int i = -300 ; i < 300 ; i++) {
			try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			firstname_signup_label.setBounds(i-200 , 100 , 200 , 50);
			firstname_signup.setBounds(i , 100 , 200 , 50);
		}
		
		for(int i = -300 ; i < 300 ; i++) {
		try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			secondname_signup_label.setBounds(i-200 , 200 , 200 , 50);
			secondname_signup.setBounds(i , 200 , 200 , 50);
		}
		
		for(int i = -300 ; i < 300 ; i++) {
		try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			username_signup_label.setBounds(i-200 , 300 , 200 , 50);
			username_signup.setBounds(i , 300 , 200 , 50);
		}
		
		for(int i = -300 ; i < 300 ; i++) {
			try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			password_signup_label.setBounds(i-200 , 400 , 200 , 50);
			password_signup.setBounds(i , 400 , 200 , 50);
		}
		
		for(int i = -300 ; i < 300 ; i++) {
			try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			confirm_password_signup_label.setBounds(i-200 , 500 , 200 , 50);
			confirm_password_signup.setBounds(i , 500 , 200 , 50);
		}
		
		for(int i = width ; i > width-500 ; i--) {
			try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			username_label.setBounds(i , 400 , 200 , 50);
			username_signin.setBounds(i+150 , 400 , 200 , 50);
		}
		
		for(int i = width ; i > width-500 ; i--) {
			try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			password_label.setBounds(i , 500 , 200 , 50);
			password_signin.setBounds(i+150 , 500 , 200 , 50);
		}
			
		for(int i = width ; i > width-350 ; i--) {
			try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			signin.setBounds(i , 600 , 200 , 50); 
		}
		
		for(int i = -300 ; i < 300 ; i++) {
			try { Thread.sleep(s,ms);
				} catch (InterruptedException e) { e.printStackTrace(); }
			signup.setBounds(i , 600 , 200 , 50); 
		}
	 }	
	 else {
			
			signin.setBounds(1266 , 600 , 200 , 50);
			signup.setBounds(300 , 600 , 200 , 50);
			username_label.setBounds(1116 , 400 , 200 , 50);
			username_signin.setBounds(1266 , 400 , 200 , 50);
			password_label.setBounds(1116 , 500 , 200 , 50);
			password_signin.setBounds(1266 , 500 , 200 , 50);
			
			firstname_signup_label.setBounds(100 , 100 , 200 , 50);
			firstname_signup.setBounds(300 , 100 , 200 , 50);
			secondname_signup_label.setBounds(100 , 200 , 200 , 50);
			secondname_signup.setBounds(300 , 200 , 200 , 50);
			username_signup_label.setBounds(100 , 300 , 200 , 50);
			username_signup.setBounds(300 , 300 , 200 , 50);
			password_signup_label.setBounds(100 , 400 , 200 , 50);
			password_signup.setBounds(300 , 400 , 200 , 50);
			confirm_password_signup_label.setBounds(100 , 500 , 200 , 50);
			confirm_password_signup.setBounds(300 , 500 , 200 , 50);
			
		}
		
		JTextField er = new JTextField();
		background.add(er);
		er.setForeground(Color.ORANGE);
		er.setBackground(Color.BLACK);
		er.setFont(new Font("",Font.PLAIN,18));
		er.setBounds(1150 , 50 , 400 , 50);
				
		///////////////////  Buttons Actions  ///////////////////////
		///////////////////  SignIn  Button  ///////////////////////

		signin.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event) {
					
					String username = username_signin.getText() ;
					String password = password_signin.getText() ; 
					
					int temp = database.signin(username, password);
					
					if(temp==4) {
						er.setText(" SignIN : Username cannot be Empty");
					}else if(temp==5) {
						er.setText(" SignIN : Password cannot be Empty");
					}
					else if(temp==2) {
						er.setText("SignIn : Username Not Found");
					}
					else if(temp==0) {
						
						er.setText("Admin : SignIn Successfull");
						panel.removeAll();
						panel.updateUI();
						adminmenu(0);
						
					}
					else if(temp==1) {
						
						er.setText("User : SignIn Successfull");
						panel.removeAll();
						panel.updateUI();
						usermenu();
						
					}
					else if(temp==3) {
						er.setText("Password Incorrect");
					}
					
		}});
		
		///////////////////  SignUp Button  ///////////////////////
		
		signup.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event) {
				
				String fname = firstname_signup.getText() ;
				String sname = secondname_signup.getText();
				String uname = username_signup.getText();
				String pass  = password_signup.getText();
				String cpass = confirm_password_signup.getText();
				
				int testid = 1234 ;
				
				User u = new User(testid,fname,sname,uname,pass) ;
				
				int temp = database.signup(u , cpass);
				
				if(temp == 1) {
					er.setText("SignUp : First name cannot be Empty");
				}else if (temp == 2) {
					er.setText("SignUp : Name Cannot have Numerics or spaces");
				}else if(temp == 3) {
					er.setText("SignUp : Second name cannot be Empty");
				}else if (temp == 4) {
					er.setText("SignUp : Name Cannot have Numerics or spaces");
				}else if(temp == 5) {
					er.setText("SignUp : Username cannot be Empty");
				}else if(temp == 6) {
					er.setText("SignUp : Username cannot have space");
				}else if(temp == 7) {
					er.setText("SignUp : Password cannot be Empty");
				}else if(temp == 8) {
					er.setText("SignUp : Confirm password cannot be Empty");
				}else if(temp == 9) {
					er.setText("SignUp : Password Mismatch");
				}else if(temp == 10){
					er.setText("SignUp : Username already Exists");
				}else if(temp == 11){
					er.setText("Signup : Error");
				}else if(temp == 0) {
					
					er.setText("SignUp : Successfull");
					
					firstname_signup.setText("");
					secondname_signup.setText("");
					username_signup.setText("");
					password_signup.setText("");
					confirm_password_signup.setText("");
				}
		}});
	}
	
	public void adminmenu(int printfromid) {
		
		int temppid = 0 ;
		final int entries = 7 ;
		
		///////////////////  Admin Menu View  ///////////////////////

		
		ImageIcon background_image = new ImageIcon("src\\loginsystem\\Pictures\\b8.jpg");
		
		JLabel background = new JLabel(background_image);
		panel.add(background);
		background.setBounds(0 , 0 , width , height);
		
		JTextField er = new JTextField();
		background.add(er);
		er.setForeground(Color.ORANGE);
		er.setBackground(Color.BLACK);
		er.setFont(new Font("",Font.PLAIN,18));
		er.setBounds(1150 , 50 , 400 , 50);
		
		int y = 100  , x = 100 , tempy = 800 ; 
		
		JLabel idLabel       = new JLabel("ID");
		JLabel fnameLabel    = new JLabel("First Name");
		JLabel snameLabel    = new JLabel("Second Name");
		JLabel usernamelabel = new JLabel("User Name");
		JLabel passwordlabel = new JLabel("Password");
		
		idLabel		 .setBounds(x 		, 100 , 200, 50);
		fnameLabel	 .setBounds(x + 200 , 100 , 200, 50);
		snameLabel	 .setBounds(x + 400 , 100 , 200, 50);
		usernamelabel.setBounds(x + 600 , 100 , 200, 50);
		passwordlabel.setBounds(x + 800 , 100 , 200, 50);
		
		idLabel		 .setFont(new Font("",Font.BOLD,22));
		fnameLabel	 .setFont(new Font("",Font.BOLD,22));
		snameLabel	 .setFont(new Font("",Font.BOLD,22));
		usernamelabel.setFont(new Font("",Font.BOLD,22));
		passwordlabel.setFont(new Font("",Font.BOLD,22));
		
		Color color2 = new Color(255, 170, 0);
		
		idLabel		 .setForeground(color2);
		fnameLabel	 .setForeground(color2);
		snameLabel	 .setForeground(color2);
		usernamelabel.setForeground(color2);
		passwordlabel.setForeground(color2);
		
		background.add(idLabel);	
		background.add(fnameLabel);
		background.add(snameLabel);
		background.add(usernamelabel);
		background.add(passwordlabel);
		
		JTextField selectedid = new JTextField();
		JTextField selectedfname = new JTextField();
		JTextField selectedsname = new JTextField();
		JTextField selectedusername = new JTextField();
		JTextField selectedpassword = new JTextField();
		
		selectedid		 .setBounds(x		 , tempy+100 , 150, 50);
		selectedfname	 .setBounds(x + 200  , tempy+100 , 150, 50);
		selectedsname	 .setBounds(x + 400  , tempy+100 , 150, 50);
		selectedusername .setBounds(x + 600  , tempy+100 , 150, 50);
		selectedpassword .setBounds(x + 800  , tempy+100 , 150, 50);
		
		selectedid		 .setBackground(Color.GRAY);
		selectedfname	 .setBackground(Color.GRAY);
		selectedsname	 .setBackground(Color.GRAY);
		selectedusername .setBackground(Color.GRAY);
		selectedpassword .setBackground(Color.GRAY);
		
		selectedid		 .setForeground(Color.black);
		selectedfname	 .setForeground(Color.black);
		selectedsname	 .setForeground(Color.black);
		selectedusername .setForeground(Color.black);
		selectedpassword .setForeground(Color.black);
		
		selectedid		 .setFont(new Font("",Font.PLAIN,20));
		selectedfname	 .setFont(new Font("",Font.PLAIN,20));
		selectedsname	 .setFont(new Font("",Font.PLAIN,20));
		selectedusername .setFont(new Font("",Font.PLAIN,20));
		selectedpassword .setFont(new Font("",Font.PLAIN,20));
		
		background.add(selectedid);	
		background.add(selectedfname);
		background.add(selectedsname);
		background.add(selectedusername);
		background.add(selectedpassword);
				
		JButton select = new JButton("Select");
		background.add(select);
		select.setBackground(Color.ORANGE);
		select.setFont(new Font("",Font.PLAIN,20));
		select.setBounds(100 , 700 , 200 , 50);
		
		JButton edit = new JButton("Edit");
		background.add(edit);
		edit.setBackground(Color.ORANGE);
		edit.setFont(new Font("",Font.PLAIN,20));
		edit.setBounds(350 , 700 , 200 , 50);
		
		JButton delete = new JButton("Delete");
		background.add(delete);
		delete.setBackground(Color.ORANGE);
		delete.setFont(new Font("",Font.PLAIN,20));
		delete.setBounds(600 , 700 , 200 , 50);
		
		JButton next = new JButton("next");
		background.add(next);
		next.setBackground(Color.ORANGE);
		next.setFont(new Font("",Font.PLAIN,20));
		next.setBounds(850 , 700 , 200 , 50);
		
		JButton logout = new JButton("Log out");
		background.add(logout);
		logout.setBackground(Color.ORANGE);
		logout.setFont(new Font("",Font.PLAIN,20));
		logout.setBounds(1250 , 700 , 200 , 50);
		
		
		///////////////////  Getting User Data  ///////////////////////

		ArrayList<User> userdatalist = database.getuserdata(printfromid , entries);
		
		Iterator<User> itr = userdatalist.iterator();
		
		while(itr.hasNext()){ 
			
			y = y + 50 ;
			
			User u = itr.next();
			
			JLabel tempidLabel       = new JLabel(String.valueOf(u.getid()));
			JLabel tempfnameLabel    = new JLabel(u.getfirstname());
			JLabel tempsnameLabel    = new JLabel(u.getsecondname());
			JLabel tempusernamelabel = new JLabel(u.getusername());
			JLabel temppasswordlabel = new JLabel(u.getpassword());
			
			tempidLabel		 .setBounds(x		 , y , 200, 50);
			tempfnameLabel	 .setBounds(x + 200  , y , 200, 50);
			tempsnameLabel	 .setBounds(x + 400  , y , 200, 50);
			tempusernamelabel.setBounds(x + 600  , y , 200, 50);
			temppasswordlabel.setBounds(x + 800  , y , 200, 50);
			
			tempidLabel		 .setFont(new Font("",Font.PLAIN,20));
			tempfnameLabel	 .setFont(new Font("",Font.PLAIN,20));
			tempsnameLabel	 .setFont(new Font("",Font.PLAIN,20));
			tempusernamelabel.setFont(new Font("",Font.PLAIN,20));
			temppasswordlabel.setFont(new Font("",Font.PLAIN,20));
			
			Color color1 = new Color(255, 77, 0) ;
			
			tempidLabel		 .setForeground(color1);
			tempfnameLabel	 .setForeground(color1);
			tempsnameLabel	 .setForeground(color1);
			tempusernamelabel.setForeground(color1);
			temppasswordlabel.setForeground(color1);
			
			background.add(tempidLabel);	
			background.add(tempfnameLabel);
			background.add(tempsnameLabel);
			background.add(tempusernamelabel);
			background.add(temppasswordlabel);
		
			temppid = u.getid() ;
			
			}
							
			tempy = y ;
			
			///////////////// Admin Action Buttons ////////////////
			/////////////////////// logout ////////////////////////
						
			logout.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					panel.removeAll();
					panel.updateUI();
					
					loginmenu(false);
					
			}});
			
			//////////////////////// Next ///////////////////////////
			
			int lastid = temppid ;
			next.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					panel.removeAll();
					panel.updateUI();
					
					adminmenu(lastid);
			}});	
			  
			/////////////////////// Select  ////////////////////////
			
			select.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int id = 0 ;
			
						if(!(selectedid.getText().matches("^[0-9]+$"))) {
							er.setText("Id Must be Numeric Value");
						}else if(selectedid.getText().equals("")){
							er.setText("Id Cannot be Empty");
						}
						else {
							
							id = Integer.parseInt(selectedid.getText());
							
							User u =  database.selectuser(id);
							
							if(u==null) {
								er.setText("Selected ID Cannot be found , Id : " + id);
								
								selectedfname.setText("");
								selectedsname.setText("");
								selectedusername.setText("");
								selectedpassword.setText("");
								
							}
							else {
								er.setText("Id Selected : " + id);
								
								selectedfname.setText(u.getfirstname());
								selectedsname.setText(u.getsecondname());
								selectedusername.setText(u.getusername());
								selectedpassword.setText(u.getpassword());
							}
						}
				}});
			
			/////////////////////// Delete ////////////////////////
			
			delete.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					int    id ;
				
					try { id     = Integer.parseInt(selectedid.getText());}
					catch(Exception ex){  id = 0 ; }
					
					if(id == 0) {
						er.setText("ID Must Be Numeric Value Greator Then 0");
					}
					else {
						
						int temp = database.deleteuserdata(id);
						
						if(temp==0) {
							er.setText("Id deleted : "+id);
							panel.removeAll();
							panel.updateUI();
							adminmenu(printfromid);
						}
						else if(temp==1) {
							er.setText("Error : Id could not be deleted");
						}
				}
					
			}});
			
			/////////////////////// Edit ////////////////////////	
			
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String fname = selectedfname.getText() ;
					String sname = selectedsname.getText() ;
					String username = selectedusername.getText();
					String password = selectedpassword.getText();
					
					int    id = 0 ;
					try { id     = Integer.parseInt(selectedid.getText());}
					catch(Exception ex){  id = 0 ; }
					
					User u = new User(id, fname , sname , username , password);
					
					int temp = database.edituserdata(u);
					
					if (temp == 1 ) {
						er.setText("First Name cannot be Empty");
					}
					else if (temp == 2 ) {
						er.setText("Name Cannot have Numeric Value");
					}
					else if (temp == 3 ) {
						er.setText("Second Name cannot be Empty");
					}
					else if (temp == 4 ) {
						er.setText("Name Cannot have Numeric Value");
					}
					else if(temp == 5) {
						er.setText("Username Cannot be Empty");
					}
					else if(temp == 6 ) {
						er.setText("Password Cannot be Empty");
					}
					else if(temp == 7 ) {
						er.setText("ID Must Be Numeric Value Greator Then 0");
					}
					else if(temp == 0)
					{
							er.setText("Id Edited : "+id);
							panel.removeAll();
							panel.updateUI();
							adminmenu(printfromid);
					}
					else if(temp == 8) {
						er.setText("Username already Exists");
					}
					else if(temp == 9) {
						er.setText("Error");
					}
					
				}});
		}
			
	public void usermenu() {
		
		/////////////////////// Usermenu View ////////////////////////
		
		ImageIcon background_image = new ImageIcon("src\\loginsystem\\Pictures\\b6.jpg");
		
		JLabel background = new JLabel(background_image);
		panel.add(background);
		background.setBounds(0 , 0 , width , height);
				
		JTextField er = new JTextField();
		background.add(er);
		er.setForeground(Color.ORANGE);
		er.setBackground(Color.BLACK);
		er.setFont(new Font("",Font.PLAIN,18));
		er.setBounds(1150 , 50 , 400 , 50);

		JTextField input = new JTextField();
		background.add(input);
		input.setForeground(Color.BLUE);
		input.setBackground(Color.BLACK);
		input.setFont(new Font("",Font.PLAIN,18));
		input.setBounds(150 , 50 , 200 , 50);
		
		JButton logout = new JButton("Log out");
		background.add(logout);
		logout.setBackground(Color.ORANGE);
		logout.setFont(new Font("",Font.PLAIN,20));
		logout.setBounds(1250 , 700 , 200 , 50);
		
		JButton search = new JButton("Search");
		background.add(search);
		search.setBackground(Color.ORANGE);
		search.setFont(new Font("",Font.PLAIN,20));
		search.setBounds(400 , 50 , 100 , 50);
				
		JPanel imgsection = new JPanel();
		background.add(imgsection);
		imgsection.setVisible(true);
		imgsection.setBounds(1200 , 150 , 350 , 500);
		imgsection.setBackground(Color.BLACK);
				
		JPanel datasection = new JPanel();
		datasection.setVisible(true);
		datasection.setLayout(null);
		datasection.setBounds(150 , 150 , 800 , 500);
		datasection.setBackground(new Color(37, 11, 38));
		
		JScrollPane jp = new JScrollPane(datasection);
		jp.setViewportView (datasection);
		background.add(jp);
		jp.setVisible(true);
		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		jp.setBounds(150 , 150 , 800 , 500);
	
		////////////////// User Action Buttons /////////////////
		/////////////////////// logout ////////////////////////
		
		logout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				loginmenu(false);
		}});	

		/////////////////////// Search ////////////////////////
		
		search.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
				String heroname = null ;
				JLabel heroimage = null ;
				
				if(input.getText().equals("")) {
					er.setText("Please enter a name");
				}
				else {
				
				heroname = input.getText();
				
				/////////////////// Searching Hero Details ////////////////
				
				int temp = heroapi.searchhero(heroname);
				
				if(temp == 1) {
					er.setText("Error : Could not Connect to DataBase");
				}else if(heroapi.getstatus() == 3) {
					er.setText("Not found");
					
				}else if(heroapi.getstatus() == 4 ) {
					er.setText("Not found");
					datasection.removeAll();
					datasection.updateUI();
					imgsection.removeAll();
					imgsection.updateUI();
				}else {
					
					/////////////////////// Getting Image ////////////////////////
					
					imgsection.removeAll();
					imgsection.updateUI();
					
					heroimage   = new JLabel(heroapi.getHeroImage())   ;
					imgsection.add(heroimage);
					heroimage.setBounds(0, 50, 350 , 500);
					
					if(heroapi.getstatus() == 2) {
						er.setText("Image Not Found");
						heroimage   = new JLabel("Image Not Found");
						heroimage.setForeground(Color.RED);
					}
					
					/////////////////////// Getting Data ////////////////////////

					 	String[] dataparts = heroapi.getHeroData();
					 	
					 	datasection.removeAll();
					 	datasection.updateUI();
					 	
					 	int y_axis = 30 ;
					 	int x_axis = 20 ;
					 	
					 	for(int i=0 ; i < dataparts.length ; i++) {
					 		
					 		if(dataparts[i].contains("images")) {
								break ;
							}
					 		 			
					 		JLabel datalabel = new JLabel(dataparts[i]);
							datasection.add(datalabel);
							
							datalabel.setForeground(Color.ORANGE);
							datalabel.setFont(new Font("",Font.BOLD,20));
							datalabel.setBounds(x_axis, y_axis, 800 , 50);
							y_axis = y_axis + 50 ;
										
					 	}
					 	
					 	er.setText("Found");
		
					}
				}		
			}});
	}
		
}
		


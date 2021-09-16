package loginsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	Connection con = null ;
	Statement  stm = null ;
	
	Database(String username , String password ){
		con = makeconnection(username , password)  ;
		stm = makestatment(con) ; 
	}

	public Connection makeconnection(String username , String password) {
    	
		//		String username = "root" ;
		//      String password = ""     ;
		
        String url = "jdbc:mysql://localhost:3308/database";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    	return con ;
    }
    
    public Statement makestatment(Connection con) {
    	
    	Statement stm = null ;
    	try {
			stm = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stm;
		
    }
    
    public int signin(String username , String password) {
    	
		if(username.equals("")) {
			return 4 ; 				//username cannot be empty
		}
		else if(password.equals("")) {
			return 5 ; 				// password cannot be empty
		}
		
    	String query2 = "SELECT  `password` FROM `logindata` WHERE `Username` = \'"+username+"\' ";
    	
    	ResultSet result = null ;
		
    	try {	result = stm.executeQuery(query2) ;
		} catch (SQLException e) {	e.printStackTrace();
			return 2 ;   					// User name not found	
		}
    	
    	try {	result.next();
		} catch (SQLException e) {	e.printStackTrace(); 	}
    	

		try {
			if(password.equals(result.getString("password"))) {

				if(username.equals("admin")) {
					return 0 ;			//Sign in as admin
				}
				else {
					return 1 ;			//sign in as user
				}
			}
			
			else {
				return 3 ; 				// Password Incorrect 
			}
			
			} catch (SQLException e) {
			return 2 ; 					// username not found
		}
	}	
    
    public int signup(User u , String cpass) {
    	
    	if(u.getfirstname().equals("")) {
			return 1 ;
		}else if (!(u.getfirstname().matches("^[A-Za-z]+$"))) {
			return 2 ;
		}else if(u.getsecondname().equals("")) {
			return 3 ;
		}else if (!(u.getsecondname().matches("^[A-Za-z]+$"))) {
			return 4 ;
		}else if(u.getusername().equals("")) {
			return 5 ;
		}else if(!(u.getusername().matches("^[A-Za-z0-9_]+$"))) {
			return 6 ;
		}else if(u.getpassword().equals("")) {
			return 7 ;
		}else if(cpass.equals("")) {
			return 8 ;
		}else if(! (cpass.equals(u.getpassword()) ) ) {
			return 9 ;
		}else {
		
			String insertquery = "INSERT INTO `logindata` (`fname`, `sname`, `username` , `password`) "
					+ "VALUES ( \'" + u.getfirstname() + "\' "
					+ ",\'"+ u.getsecondname() +"\',\'"+ u.getusername() +"\',\'"+u.getpassword()+"\' )"; 
			
			try {
				stm.executeUpdate(insertquery);
				return 0 ;
				
			} catch (SQLIntegrityConstraintViolationException e) {
				
				return 10 ;
				}
			
			catch (SQLException e) {	e.printStackTrace();	}
			
		}
    	
    	return 11 ;
    }
    
    public ArrayList<User> getuserdata(int getfromid , int entries) {
    	
    	ArrayList<User> userdata =new ArrayList<User>();
    	
    	String query2 = "SELECT * FROM logindata WHERE id > "+ getfromid ;
		
		ResultSet result = null;
		try {
			result = stm.executeQuery(query2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			
			int i = 0 ;
			
			while(result.next()){ 
			
				int    tempid       = result.getInt("id");
				String tempfname    = result.getString("fname");
				String tempsname    = result.getString("sname");
				String tempusername = result.getString("username");
				String temppassword = result.getString("password");
				
				userdata.add(new User(tempid , tempfname, tempsname , tempusername , temppassword ));
				
				i++;
				
				if( i >= entries) {
					break;
				}
								
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return userdata;
    }
    
    public User selectuser(int id) {
    	String query3 = "SELECT * FROM logindata WHERE id = " + id ;
		
		try {
			ResultSet result = stm.executeQuery(query3);
			result.next();
			
		return new User(result.getInt("id"),result.getString("fname"),
		                result.getString("sname"),result.getString("username"),
		                result.getString("password"));
			
		} catch (SQLException e1) {
			return null;
		}
		
    }

    public int deleteuserdata(int id) {
    	String query4 = "DELETE FROM logindata WHERE id = " + id ;
		
		try {
			stm.execute(query4) ;
			return 0 ;
			
		} catch (SQLException e1) {
			return 1 ;
		}
    }

    public int edituserdata(User u) {
    	
    	if (u.getfirstname().equals("")) {
			return 1 ;
		}
		else if (!(u.getfirstname().matches("^[A-Za-z]+$"))) {
			return 2 ;
		}
		else if (u.getsecondname().equals("")) {
			return 3 ;
		}
		else if (!(u.getsecondname().matches("^[A-Za-z]+$"))) {
			return 4 ;
		}
		else if(u.getusername().equals("")) {
			return 5 ;
		}
		else if(u.getpassword().equals("")) {
			return 6 ;
		}
		else if(u.getid() == 0) {
			return 7 ;
		}
		else
		{
			String query4 = "UPDATE `logindata` SET `fname` = \'"+u.getfirstname()+"\' , "
					+ "`sname` = \'"+u.getsecondname()+"\'  , `password` = \'"+u.getpassword()+"\', "
					+ "`username` = \'"+u.getusername()+"\'"
					+ "WHERE `id` = \'" + u.getid() + "\'";
			
			try {
				stm.execute(query4) ;
				return 0 ;
				
		} catch (SQLIntegrityConstraintViolationException e1) {
				return 8 ;
			}
		catch(SQLException e) {
			return 9 ;
		}
    	
    	
    }
}

}


    	
		
		
    	

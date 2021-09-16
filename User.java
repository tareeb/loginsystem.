package loginsystem;

public class User {

	private int    id 		  ;
	private String firstname  ; 
	private String secondname ; 
	private String username   ;
	private String password   ;
	
	User(int id , String firstname , String secondname, String username, String password ){
		this.id = id ; 
		this.firstname = firstname ; 
		this.secondname = secondname ; 
		this.username = username ;
		this.password = password ;
	}
	
	public void setid(int id) {
		this.id = id ;
	}
	
	public void setfirstname(String firstname) {
		this.firstname = firstname ;
	}
	
	public void setsecondname(String secondname) {
		this.secondname = secondname ;
	}
	
	public void setusername(String username) {
		this.username = username ;
	}
	
	public void setpassword(String password) {
		this.password = password ;
	}
	
	public int getid() {
		return id ;
	}
	
	public String getfirstname() {
		return firstname ;
	}
	
	public String getsecondname() {
		return secondname ;
	}
	
	public String getusername() {
		return username ;
	}
	
	public String getpassword() {
		return password ;
	}
	
	
}

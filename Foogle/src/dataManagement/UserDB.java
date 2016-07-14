package dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB {
	
	private DatabaseManager dbm = DatabaseManager.getSoleInstance();
	private Statement stmt = DatabaseManager.getStmt();
	
	public boolean isAuthenticated(String username, String password){
		if(password == null || password.equals(""))
			return false;
		else{
			ResultSet rset = null;
			String query = "select * from Restaurant_Owners where username = '"+username+"' and password = '"+password+"'";
			try {
				rset = stmt.executeQuery(query);
				if(rset.next()){
					return true; 
				}
				else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}	
		}
		
	}
	
	public boolean createRestaurantOwnerAccount(String username, String password, String email){
		if(doesUsernameExist(username) || username == null || password == null || email == null )
			return false;
		else{
			String query = "INSERT INTO Restaurant_Owners VALUE (NULL,'"+ username + "','"+ password + "','"+ email+"');" ;  
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} //Restaurant Owner creation in database
			System.out.println("Created!");
			return true;
		}
	}
	
	public boolean isUsernameValid(String username){
		if(username == null || username.equals(""))
			return false;
		else{
			ResultSet rset = null;
			String query = "select * from Restaurant_Owners where username = '" + username + "'";//search in the database table whether if the specified username exists or not
			try {
				rset = stmt.executeQuery(query);
				if(!rset.next()){					
					return true;
				}
				else 
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}			
		}
	}
	
	public boolean doesUsernameExist(String username){
		if(username == null || username.equals(""))
			return false;
		else{
			ResultSet rset = null;
			String query = "select * from Restaurant_Owners where username = '" + username + "'";//search in the database table whether if the specified username exists or not
			try {
				rset = stmt.executeQuery(query);
				if(rset.next()){					
					return true;
				}
				else 
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}			
		}
	}
	
	public boolean doesEmailExist(String email){
		if(email == null || email.equals(""))
			return false;
		else{
			ResultSet rset = null;
			String query = "select * from Restaurant_Owners where email = '" + email + "'";
			try {
				rset = stmt.executeQuery(query);
				if(rset.next()){					
					return true;
				}
				else 
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}			
		}
	}
	
	public static void main(String[] args){
		UserDB udb = new UserDB();
		udb.isAuthenticated("test2", "asd");
		udb.createRestaurantOwnerAccount("test3", "test3", "test3");
		System.out.println(udb.isUsernameValid("adasfdf"));
		System.out.println(udb.doesUsernameExist("test3"));
		System.out.println(udb.doesEmailExist("asdasdfdf"));
		
	}
	
}

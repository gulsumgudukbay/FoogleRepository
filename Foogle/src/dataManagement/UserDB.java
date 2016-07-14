package dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB {
	
	private DatabaseManager dbm = DatabaseManager.getSoleInstance();
	private Statement stmt = DatabaseManager.getStmt();
	
	public boolean isPassValid(String username, String password){
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
	
	public static void main(String[] args){
		UserDB udb = new UserDB();
		udb.isPassValid("test2", "asd");
	}
	
}

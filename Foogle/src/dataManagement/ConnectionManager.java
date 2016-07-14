package dataManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	private static ConnectionManager dbl = new ConnectionManager();
	private static Connection con;
	private static Statement stmt;
	
	private ConnectionManager(){	
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?useSSL=false", "root", "gulsumg");
			stmt = con.createStatement();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
			
	}
	
	public static ConnectionManager getSoleInstance(){
		return dbl;
	}
	
	public static Statement getStmt(){
		return stmt;
	}
	
	
}
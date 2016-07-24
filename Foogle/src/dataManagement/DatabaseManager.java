package dataManagement;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

	private static ConnectionManager cm = null;
	private Statement stmt = null;
	private static DatabaseManager dbSoleInstance  = null;
	
	private DatabaseManager() throws SQLException{
		cm = ConnectionManager.getSoleInstance();
		stmt = cm.createStmt();
		if(dbSoleInstance == null)
			dbSoleInstance = new DatabaseManager();
	}
	
	//Creates a statement
	public static Statement createStmt(){
		return cm.createStmt();
	}
	
	//Returns the sole instance for singleton pattern 
	public static DatabaseManager getSoleInstance(){
		return dbSoleInstance;
	}
	
}

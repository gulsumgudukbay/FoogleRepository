package dataManagement;

import java.sql.Statement;

public class DatabaseManager {

	private static ConnectionManager cm = null;
	private static DatabaseManager dbSoleInstance = new DatabaseManager();
	private static Statement stmt = null;
	
	private DatabaseManager(){
		cm = ConnectionManager.getSoleInstance();
		stmt = ConnectionManager.getStmt();
	}
	
	public static Statement getStmt(){
		return stmt;
	}
	
	public static DatabaseManager getSoleInstance(){
		return dbSoleInstance;
	}
	
}

package dataManagement;

import java.sql.Statement;

public class PendingDB {
	
	private DatabaseManager dbm = DatabaseManager.getSoleInstance();
	private Statement stmt = DatabaseManager.createStmt();
	private static PendingDB pdb = new PendingDB();
	
	public static PendingDB getSoleInstance(){
		return pdb;
	}

}

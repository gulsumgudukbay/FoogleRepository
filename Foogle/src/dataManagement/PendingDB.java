package dataManagement;

import java.sql.Statement;

public class PendingDB {
	
	private DatabaseManager dbm = DatabaseManager.getSoleInstance();
	private Statement stmt = DatabaseManager.createStmt();
	private static PendingDB pdb = new PendingDB();
	
	public static PendingDB getSoleInstance(){
		return pdb;
	}

	
	public static void main(String[] args){
		PendingDB pdb = PendingDB.getSoleInstance();
		System.out.println(pdb.getSoleInstance().toString()); 
	}
	
	public void confirmIngredient(String name){
		
	}
	
	public int getTheFoodIDOfIngredient(String name){
		return -1;
	}
	
	public boolean isOtherIngredientConfirmed(String name){
		return true;
	}
	
	public boolean isAllOtherIngredientsConfirmedFor(String foodName){
		return true;
	}
}

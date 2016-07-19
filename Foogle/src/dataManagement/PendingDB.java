package dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restaurantAndFoodManagement.Ingredient;

public class PendingDB {

	private static PendingDB pdb = new PendingDB();
	
	public static PendingDB getSoleInstance(){
		return pdb;
	}
	
	public static void main(String[] args){
		PendingDB pdb = PendingDB.getSoleInstance();
		System.out.println(pdb.toString()); 
		pdb.confirmIngredient("testing");
		pdb.confirmRestaurant("testpendingrest");
		System.out.println(pdb.isAllOtherIngredientsConfirmedFor("2"));
		System.out.println(pdb.getTheFoodNameOfPendingIngredient("testing2"));
	}
	
	public void confirmIngredient(String name){
		Statement stmtconfi = DatabaseManager.createStmt();

		String query = "update Pending_Ingredients set isConfirmed = 'T' where name='" + name + "'";
		try {
			stmtconfi.executeUpdate(query);
			System.out.println("CONFIRMED INGREDIENT");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public void confirmRestaurant(String name){
    	Statement stmtconfr = DatabaseManager.createStmt();

		String query = "update Pending_Restaurants set isConfirmed = 'T' where name='" + name + "'";
		try {
			stmtconfr.executeUpdate(query);
			System.out.println("CONFIRMED Restaurant");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public void rejectIngredient(String name){
    	Statement stmtreji = DatabaseManager.createStmt();

		String query = "update Pending_Ingredients set isConfirmed = 'F' where name='" + name + "'";
		try {
			stmtreji.executeUpdate(query);
			System.out.println("REJECTED INGREDIENT");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public void rejectRestaurant(String name){
    	Statement stmtrejr = DatabaseManager.createStmt();

		String query = "update Pending_Restaurants set isConfirmed = 'F' where name='" + name + "'";
		try {
			stmtrejr.executeUpdate(query);
			System.out.println("REJECTED Restaurant");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getTheFoodNameOfPendingIngredient(String name){
		String foodname = "";
		Statement stmtgfn = DatabaseManager.createStmt();

		String query = "select * from Pending_Ingredients where name = '" + name +"'";
		ResultSet rset;
		try {
			rset = stmtgfn.executeQuery(query);
			if (rset.next())
				foodname = rset.getString("foodName");
			return foodname;
		} catch (SQLException e) {
			e.printStackTrace();
			return foodname;
		}

	}
	
	
	public ArrayList<Ingredient> getAllOtherIngredientsForAFood(String foodname){

		ArrayList<Ingredient> ings = new ArrayList<Ingredient>();
		ResultSet rset = null;
    	Statement stmto = DatabaseManager.createStmt();

		String query = "select * from Pending_Ingredients where foodName = '" + foodname + "'";
		try {

			rset = stmto.executeQuery(query);
			while (rset.next()) {
				Ingredient ingr = new Ingredient();
				ingr.setName(rset.getString("name"));
				ings.add(ingr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return ings;
	}
	
	public boolean isAllOtherIngredientsConfirmedFor(String foodName){

		ResultSet rset = null;
    	Statement stmtoi = DatabaseManager.createStmt();

		String query = "select * from Pending_Ingredients where foodName = '" + foodName + "'";	
	
		try{
			rset = stmtoi.executeQuery(query);
			boolean b = true;
			while(rset.next()){
				if(!rset.getString("isConfirmed").equals("T"))
					b = false;
			}
			return b;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean isAllIngredientsProcessed(){
		ResultSet rset = null;
    	Statement stmtp = DatabaseManager.createStmt();

		String query = "select * from Pending_Ingredients";	
	
		try{
			rset = stmtp.executeQuery(query);
			boolean b = true;
			while(rset.next()){
				if(!rset.getString("isConfirmed").equals("T") && !rset.getString("isConfirmed").equals("F"))
					b = false;
			}
			return b;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean isAllRestaurantsProcessed(){
		ResultSet rset = null;
    	Statement stmtrp = DatabaseManager.createStmt();

		String query = "select * from Pending_Restaurants";	
	
		try{
			rset = stmtrp.executeQuery(query);
			boolean b = true;
			while(rset.next()){
				if(!rset.getString("isConfirmed").equals("T") && !rset.getString("isConfirmed").equals("F"))
					b = false;
			}
			return b;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void removeAllPendingRestaurants(){
    	Statement stmtremr = DatabaseManager.createStmt();
		String query = "DELETE from Pending_Restaurants";	

		try{
			stmtremr.executeUpdate(query);			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void removeAllPendingIngredients(){
    	Statement stmtremi = DatabaseManager.createStmt();
		String query = "DELETE from Pending_Ingredients";	
	
		try{
			stmtremi.executeUpdate(query);			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
}

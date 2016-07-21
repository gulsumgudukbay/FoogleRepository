package dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;

public class PendingDB {

	private static PendingDB pdb = new PendingDB();
	UserDB udb = UserDB.getSoleInstance();
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
	
	public ArrayList<Ingredient> getAllPendingIngredients(){
		ArrayList<Ingredient> ings = new ArrayList<Ingredient>();
		Statement stmtpi = DatabaseManager.createStmt();
		ResultSet rset = null;

		String query = "select * from Pending_Ingredients";
		try {
			rset = stmtpi.executeQuery(query);
			while (rset.next()) {
				Ingredient ingr = new Ingredient();
				ingr.setName(rset.getString("name"));
				if(rset.getString("isConfirmed").equals("T"))
					ingr.setConfirmed(true);
				else
					ingr.setConfirmed(false);
				ings.add(ingr);
			}

			System.out.println("INGS"+ ings.toString());
			return ings;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Restaurant> getAllPendingRestaurants(){
		ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
		Statement stmtpr = DatabaseManager.createStmt();
		ResultSet rset = null;

		String query = "select * from Pending_Restaurants";
		try {
			rset = stmtpr.executeQuery(query);
			while (rset.next()) {
				Restaurant rest = new Restaurant();
				rest.setName(rset.getString("name"));
				if(rset.getString("isConfirmed").equals("T"))
					rest.setConfirmed(true);
				else
					rest.setConfirmed(false);
				rests.add(rest);
			}

			System.out.println("RESTS"+rests.toString());
			return rests;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void insertToPendingIngredients(Ingredient ing, String foodName){
		Statement stmtip = DatabaseManager.createStmt();
		
		String isconfirmed = "";
		if(ing.isConfirmed())
			isconfirmed = "T";
		else
			isconfirmed = "F";
		
		String query = "INSERT INTO `Foogle`.`Pending_Ingredients` (`name`, `isConfirmed`, `foodname`) VALUES ('"
				+ ing.getName() + "', '" + isconfirmed + "', '" + foodName + "');";
		try {
			stmtip.executeUpdate(query);
			System.out.println("added INGREDIENT");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertToPendingRestaurants(String ownerUN, String rest){
		Statement stmtrp = DatabaseManager.createStmt();
		String query = "INSERT INTO `Foogle`.`Pending_Restaurants` (`idRestaurant_Owner`, `name`, `isConfirmed`) VALUES ('"
				+ udb.getRestaurantOwnerID(ownerUN)+ "', 'F');";
		try {
			stmtrp.executeUpdate(query);
			System.out.println("added rest");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public boolean isRestaurantConfirmed(String rest){

		ResultSet rset = null;
    	Statement stmtirc = DatabaseManager.createStmt();

		String query = "select * from Pending_Restaurants where name = '" + rest + "'";	
	
		try{
			rset = stmtirc.executeQuery(query);
			
			boolean b = true;
			if(rset.next()){
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

package dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestDB {
	private static RestDB rdb = new RestDB();
	private DatabaseManager dbm = DatabaseManager.getSoleInstance();
	private Statement stmt = DatabaseManager.getStmt();
	private static UserDB udb = UserDB.getSoleInstance();
	
	public static RestDB getSoleInstance(){
		return rdb;
	}
	
	//TODO process ingredients add food to the restaurant and to the foods table
	public boolean createFoodToExistingRestaurant(String restaurantName,String restaurantOwnerUsername, String foodName, String ingredients){
		if(doesRestaurantExist(restaurantName,  restaurantOwnerUsername) || restaurantName == null || foodName == null || foodName == null )
			return false;
		else{
			String query = "INSERT INTO Restaurant_Owners VALUE (NULL,'" + "','"  + "','"+"');" ;  
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			System.out.println("Created!");
			return true;
		}
	}
	
	//called if the restaurant is confirmed in the pending list!!!
	public boolean createRestaurant(String name, String restaurantOwnerUsername){
		if(doesRestaurantExist(name,  restaurantOwnerUsername) || name == null || name.equals(""))
			return false;
		else{
			int id = udb.getRestaurantOwnerID(restaurantOwnerUsername);
			String query = "INSERT INTO Restaurants VALUE ('"+ name+ "'," + id + "," + "NULL);" ;  
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			System.out.println("Created restaurant!");
			return true;
		}
	}
	
	
	
	
	public boolean doesRestaurantExist(String name, String restaurantOwnerUsername){
		if(name == null || name.equals("") || restaurantOwnerUsername == null || restaurantOwnerUsername.equals(""))
			return false;
		else{
			int restaurantOwnerID = udb.getRestaurantOwnerID(restaurantOwnerUsername);
			ResultSet rset = null;
			String query = "select * from Restaurants where name = '" + name + "' and Restaurant_Owners_id = "+restaurantOwnerID;//search in the database table whether if the specified username exists or not
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
	
	public int getRestaurantID(String restaurantName){
		int id = -1;
		String query = "select * from Restaurants where name = '" + restaurantName + "'";
		ResultSet rset;
		try {
			rset = stmt.executeQuery(query);
			if(rset.next()) id = rset.getInt("id");
				return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		} 	
	}
	
	public boolean doesFoodExist(String name, String restaurantName){
		if(name == null || name.equals("") || restaurantName == null || restaurantName.equals(""))
			return false;
		else{
			ResultSet rset = null;
			int restaurantID = getRestaurantID(restaurantName);
			String query = "select * from Foods where name = '" + name + "' and Restaurants_id = "+ restaurantID;
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
		RestDB rdb = RestDB.getSoleInstance();
		System.out.println(rdb.doesFoodExist("food1", "testRestaurant"));
		System.out.println(rdb.createRestaurant("testRestaurant", "test2"));
		System.out.println(rdb.doesRestaurantExist("testlkjRestaurant", "test"));
	}
	
}

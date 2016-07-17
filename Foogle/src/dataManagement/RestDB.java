package dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;

public class RestDB {
	private static RestDB rdb = new RestDB();
	private DatabaseManager dbm = DatabaseManager.getSoleInstance();
	private Statement stmt = DatabaseManager.createStmt();
	private static UserDB udb = UserDB.getSoleInstance();
	
	
	public static RestDB getSoleInstance(){
		return rdb;
	}

	
	//TODO process ingredients add food to the restaurant and to the foods table
	public boolean createFoodToExistingRestaurant(String restaurantName, String restaurantOwnerUsername, String foodName, String ingredients){
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

	public ArrayList<Ingredient> getAllIngredients(){
		ArrayList<Ingredient> ings = new ArrayList<Ingredient>();
		ResultSet rset = null;
		
		String query = "select * from Ingredients";
		try{
			Ingredient ingr = new Ingredient();
			rset = stmt.executeQuery(query);
			while(rset.next()){
				ingr.setName(rset.getString("name"));
				ings.add(ingr);
				System.out.println(ingr.getName());
			}
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return ings;		
	}
	
	//called if the restaurant is confirmed in the pending list!!!
	public boolean createRestaurant(String name, String restaurantOwnerUsername){
		if(doesRestaurantExist(name,  restaurantOwnerUsername) || name == null || name.equals(""))
			return false;
		else{
			int id = udb.getRestaurantOwnerID(restaurantOwnerUsername);
			Statement stmtr = DatabaseManager.createStmt();

			String query = "INSERT INTO Restaurants VALUE ('"+ name+ "'," + id + "," + "NULL);" ;  
			try {
				stmtr.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			System.out.println("Created restaurant!");
			return true;
		}
	}
	
	public String getFoodNameFromID(int id){
		String un = "";
		String query = "select * from Foods where id = " + id ;
		ResultSet rset;
		Statement stmtn = DatabaseManager.createStmt();

		try {
			rset = stmtn.executeQuery(query);
			if(rset.next()) un = rset.getString("name");
				return un;
		} catch (SQLException e) {
			e.printStackTrace();
			return un;
		} 	
	}
	
	public String getFoodTypeFromName(String name){
		String type = "";
		String query = "select * from Foods where name = '" + name + "'";
		ResultSet rset;
		Statement stmtt = DatabaseManager.createStmt();

		try {
			rset = stmtt.executeQuery(query);
			if(rset.next()) type = rset.getString("type");
				return type;
		} catch (SQLException e) {
			e.printStackTrace();
			return type;
		} 	
	}
	
	public String getFoodCuisineFromName(String name){
		String cuisine = "";
		String query = "select * from Foods where name = '" + name + "'";
		ResultSet rset;
		Statement stmtc = DatabaseManager.createStmt();

		try {
			rset = stmtc.executeQuery(query);
			if(rset.next()) cuisine = rset.getString("cuisine");
				return cuisine;
		} catch (SQLException e) {
			e.printStackTrace();
			return cuisine;
		} 	
	}
	
	public double getFoodPriceFromName(String name){
		double price = -1.00;
		String query = "select * from Foods where name = '" + name + "'";
		ResultSet rset;
		Statement stmtp = DatabaseManager.createStmt();

		try {
			rset = stmtp.executeQuery(query);
			if(rset.next()) price = rset.getDouble("price");
				return price;
		} catch (SQLException e) {
			e.printStackTrace();
			return price;
		} 	
	}
	
	public ArrayList<Food> getFoodList(ArrayList<String> wanted, ArrayList<String> unwanted, String type){
		ArrayList<Food> result = new ArrayList<Food>();

		ResultSet rset = null;
	
		String query = "select * from Ingredients";
		
		try{
			Statement stmtfl = DatabaseManager.createStmt();

			rset = stmtfl.executeQuery(query);
			while(rset.next()){
				Food fd = new Food();
				fd.setName(getFoodNameFromID(rset.getInt("Foods_id")));
				fd.setType(getFoodTypeFromName(fd.getName()));
				fd.setPrice(getFoodPriceFromName(fd.getName()));
				fd.setCuisine(getFoodCuisineFromName(fd.getName()));
				fd.setIngredients(getAllIngredientsForAFood(fd.getName()));
				result.add(fd);
			}
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
		
		ArrayList<Food> finalresult = null;
		
		if(result != null){
			
			for(int i = 0; i < result.size(); i++)
				if(!(result.get(i).getType()).equals(type)){
					result.remove(i--);
				}
			
			for(int j = 0; j < result.size();j++){
				for(int i = 0; i < unwanted.size();i++){
					if(result.get(j).searchInIngredients(unwanted.get(i))){
						result.remove(j);
						i--;
					}


				}
			}
			for(int i = 0; i < result.size();i++)
				System.out.println(" dasdasd " +result.get(i).getName());
			
			
			//removing duplicates
			
			HashSet<Food> set = new HashSet<>(result);

			// Create ArrayList from the set.
			finalresult = new ArrayList<Food>(set);
			
			for(int i = 0; i < finalresult.size();i++)
				System.out.println(" final " +finalresult.get(i).getName());
		     
		}
		return finalresult;
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
	
	public boolean doesFoodExist(String name){
		if(name == null || name.equals(""))
			return false;
		else{
			ResultSet rset = null;
			String query = "select * from Foods where name = '" + name + "'";
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
	
	public boolean doesRestaurantExist(String name){
		if(name == null || name.equals(""))
			return false;
		else{
			ResultSet rset = null;
			String query = "select * from Restaurants where name = '" + name + "'";
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

	public boolean doesIngredientExistInFood(String ingname, String foodname){
		if(ingname == null || ingname.equals("") ||foodname == null || foodname.equals(""))
			return false;
		else{
			ResultSet rset = null;
			int foodID = getFoodID(foodname);
			String query = "select * from Ingredients where name = '" + ingname + "' and Foods_id = "+foodID;
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
	
	public boolean doesIngredientExist(String name){
		if(name == null || name.equals("") )
			return false;
		else{
			ResultSet rset = null;
			String query = "select * from Ingredients where name = '" + name + "'";
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
	
	public int getFoodID(String foodName){
		int id = -1;
		String query = "select * from Foods where name = '" + foodName + "'";
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
	
	public ArrayList<Ingredient> getAllIngredientsForAFood(String foodName){
		
		if(doesFoodExist(foodName)){
			ArrayList<Ingredient> ings = new ArrayList<Ingredient>();
			ResultSet rset = null;
			
			int foodID = getFoodID(foodName);
			String query = "select * from Ingredients where Foods_id = '" + foodID + "'";
			try{
				
				rset = stmt.executeQuery(query);
				while(rset.next()){
					Ingredient ingr = new Ingredient();
					ingr.setName(rset.getString("name"));
					ings.add(ingr);
				}
			} catch(SQLException e){
				e.printStackTrace();
				return null;
			}
			
			return ings;
		}
		else
			return null;		
	}
	
	public ArrayList<Food> getAllFoods(String restaurantName){
		 
		if(doesRestaurantExist(restaurantName)){
			Statement stmt2 = null;
			stmt2 = DatabaseManager.createStmt();

			ArrayList<Food> fds = new ArrayList<Food>();
			ResultSet rset = null;
			int restaurantID = getRestaurantID(restaurantName);
			String query = "select * from Foods where Restaurants_id = '" + restaurantID + "'";
			try{
				Food fd = new Food();
				rset = stmt2.executeQuery(query);
				while(rset.next()){
					String name = rset.getString("name"); 
					fd.setName(name);
					fd.setIngredients(getAllIngredientsForAFood(name));
					fds.add(fd);
					System.out.println(fd.getName()+ " INGREDIENTS: "+ fd.getIngredients().toString());
				}
			} catch(SQLException e){
				e.printStackTrace();
				return null;
			}	
			return fds;
		}
		else
			return null;		
	}
	
	public static void main(String[] args){
		RestDB rdb = RestDB.getSoleInstance();
		System.out.println(rdb.doesFoodExist("food1", "testRestaurant"));
		System.out.println(rdb.createRestaurant("testRestaurant", "test2"));
		System.out.println(rdb.doesRestaurantExist("testlkjRestaurant", "test"));
		rdb.getAllIngredientsForAFood("food1");
		rdb.getAllIngredients();
		rdb.getAllFoods("testRestaurant");
		
		ArrayList<String> wanted = new ArrayList();
		wanted.add("ing2");
		wanted.add("ing4");
		wanted.add("ing10");
		wanted.add("ing11");
		wanted.add("ing7");
		wanted.add("ing6");
		
		ArrayList<String> unwanted = new ArrayList();
		unwanted.add("ing5");
		unwanted.add("ing3");
		
		rdb.getFoodList(wanted,unwanted,"meal");
		
	}
	
}

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

	public static RestDB getSoleInstance() {
		return rdb;
	}

	// TODO is called if all of its other ingredients are confirmed or if there
	// aren't any other ingredients specified
	public boolean createFoodToExistingRestaurant(String restaurantName, String restaurantOwnerUsername,
			String foodName, String type, String cuisine, double price, ArrayList<Ingredient> ingredients) {
		if (doesFoodExist(foodName, restaurantName, restaurantOwnerUsername)
				|| !doesRestaurantExist(restaurantName, restaurantOwnerUsername) || restaurantName == null
				|| foodName == null || cuisine == null || cuisine.equals("") || foodName.equals("")) {
			return false;
		} else {
			String query = "INSERT INTO `Foogle`.`Foods` (`name`, `type`, `cuisine`, `price`, `Restaurants_id`) VALUES ('"
					+ foodName + "', '" + type + "', '" + cuisine + "', '" + price + "', '"
					+ getRestaurantID(restaurantName, restaurantOwnerUsername) + "');";
			Statement stmtcr = DatabaseManager.createStmt();
			try {
				stmtcr.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			for (int i = 0; i < ingredients.size(); i++) {
				String query2 = "INSERT INTO `Foogle`.`Ingredients` (`name`, `Foods_id`) VALUES ('" + ingredients.get(i)
						+ "', '" + getFoodID(foodName) + "');";
				Statement stmtcr2 = DatabaseManager.createStmt();
				try {
					stmtcr2.executeUpdate(query2);
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
			System.out.println("Created!");
			return true;
		}
	}

	// returns all of the ingredients in the database
	public ArrayList<Ingredient> getAllIngredients() {
		ArrayList<Ingredient> ings = new ArrayList<Ingredient>();
		ArrayList<Ingredient> finalResult = new ArrayList<Ingredient>();

		ResultSet rset = null;

		String query = "select * from Ingredients";
		try {
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				Ingredient ingr = new Ingredient();
				ingr.setName(rset.getString("name"));
				ings.add(ingr);
			}

			for (int i = 0; i < ings.size(); i++)
				if (!searchInIngredientArrayList(finalResult, ings.get(i))) {
					finalResult.add(ings.get(i));
				}

			return finalResult;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// called if the restaurant is confirmed in the pending list!!!
	public boolean createRestaurant(String name, String restaurantOwnerUsername) {
		if (doesRestaurantExist(name, restaurantOwnerUsername) || name == null || name.equals(""))
			return false;
		else {
			int id = udb.getRestaurantOwnerID(restaurantOwnerUsername);
			Statement stmtr = DatabaseManager.createStmt();

			String query = "INSERT INTO Restaurants VALUE ('" + name + "'," + id + "," + "NULL);";
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

	// returns the name of the food in which the id is given
	public String getFoodNameFromID(int id) {
		String un = "";
		String query = "select * from Foods where id = " + id;
		ResultSet rset;
		Statement stmtn = DatabaseManager.createStmt();

		try {
			rset = stmtn.executeQuery(query);
			if (rset.next())
				un = rset.getString("name");
			return un;
		} catch (SQLException e) {
			e.printStackTrace();
			return un;
		}
	}

	// returns the type of the food in which the name is given
	public String getFoodTypeFromName(String name) {
		String type = "";
		String query = "select * from Foods where name = '" + name + "'";
		ResultSet rset;
		Statement stmtt = DatabaseManager.createStmt();

		try {
			rset = stmtt.executeQuery(query);
			if (rset.next())
				type = rset.getString("type");
			return type;
		} catch (SQLException e) {
			e.printStackTrace();
			return type;
		}
	}

	// returns the cuisine of the food in which the name is given
	public String getFoodCuisineFromName(String name) {
		String cuisine = "";
		String query = "select * from Foods where name = '" + name + "'";
		ResultSet rset;
		Statement stmtc = DatabaseManager.createStmt();

		try {
			rset = stmtc.executeQuery(query);
			if (rset.next())
				cuisine = rset.getString("cuisine");
			return cuisine;
		} catch (SQLException e) {
			e.printStackTrace();
			return cuisine;
		}
	}

	// returns the price of the food in which the name is given
	public double getFoodPriceFromName(String name) {
		double price = -1.00;
		String query = "select * from Foods where name = '" + name + "'";
		ResultSet rset;
		Statement stmtp = DatabaseManager.createStmt();

		try {
			rset = stmtp.executeQuery(query);
			if (rset.next())
				price = rset.getDouble("price");
			return price;
		} catch (SQLException e) {
			e.printStackTrace();
			return price;
		}
	}

	// MAIN SEARCH METHOD
	public ArrayList<Food> getFoodList(ArrayList<String> wanted, ArrayList<String> unwanted, String type) {
		ArrayList<Food> result = new ArrayList<Food>();

		ResultSet rset = null;

		String query = "select * from Ingredients";

		try {
			Statement stmtfl = DatabaseManager.createStmt();

			rset = stmtfl.executeQuery(query);
			while (rset.next()) {
				Food fd = new Food();
				fd.setName(getFoodNameFromID(rset.getInt("Foods_id")));
				fd.setType(getFoodTypeFromName(fd.getName()));
				fd.setPrice(getFoodPriceFromName(fd.getName()));
				fd.setCuisine(getFoodCuisineFromName(fd.getName()));
				fd.setIngredients(getAllIngredientsForAFood(fd.getName()));
				result.add(fd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		ArrayList<Food> finalresult = null;

		if (result != null) {

			for (int i = 0; i < result.size(); i++)
				if (!(result.get(i).getType()).equals(type)) {
					result.remove(i--);
				}

			for (int i = 0; i < unwanted.size(); i++) {
				for (int j = 0; j < result.size(); j++) {
					if (result.get(j).searchInIngredients(unwanted.get(i))) {
						result.remove(j);
						j--;
					}

				}
			}
			
		
			for(int i = 0; i < result.size();i++){
				for(int j = 0; j < wanted.size(); j++){
					if (!result.get(i).searchInIngredients(wanted.get(j)) && j == wanted.size()-1){
						result.remove(i);
						//i--;
					}
					else if(result.get(i).searchInIngredients(wanted.get(j))){
						break;
					}
			
				
				}
			}
			

			finalresult = new ArrayList<Food>();
			// removing duplicates
			for (int i = 0; i < result.size(); i++)
				if (!searchInFoodArrayList(finalresult, result.get(i)))
					finalresult.add(result.get(i));

			for (int i = 0; i < finalresult.size(); i++)
				System.out.println("search: " + finalresult.get(i).getName());

		}
		return finalresult;
	}

	// Searches for an ingredient in an ingredient arraylist
	private boolean searchInIngredientArrayList(ArrayList<Ingredient> ings, Ingredient ing) {
		for (int i = 0; i < ings.size(); i++)
			if (ings.get(i).getName().equals(ing.getName()))
				return true;
		return false;

	}

	// Searches for a food in a food arraylist
	private boolean searchInFoodArrayList(ArrayList<Food> fds, Food fd) {
		for (int i = 0; i < fds.size(); i++)
			if (fds.get(i).getName().equals(fd.getName()))
				return true;
		return false;
	}

	// Determines whether if the restaurant exists in a restaurant owner's
	// database
	public boolean doesRestaurantExist(String name, String restaurantOwnerUsername) {
		if (name == null || name.equals("") || restaurantOwnerUsername == null || restaurantOwnerUsername.equals(""))
			return false;
		else {
			int restaurantOwnerID = udb.getRestaurantOwnerID(restaurantOwnerUsername);
			ResultSet rset = null;
			Statement stmtdre = DatabaseManager.createStmt();

			String query = "select * from Restaurants where name = '" + name + "' and Restaurant_Owners_id = "
					+ restaurantOwnerID;
			try {
				rset = stmtdre.executeQuery(query);
				if (rset.next()) {
					return true;
				} else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	// Returns the id of the specified restaurant owner
	private int getRestaurantOwnerID(String restOwnerName) {
		int id = -1;
		String query = "select * from Restaurant_Owners where username = '" + restOwnerName + "'";
		ResultSet rset;
		Statement stmtgroid = DatabaseManager.createStmt();

		try {
			rset = stmtgroid.executeQuery(query);
			if (rset.next())
				id = rset.getInt("idRestaurant_Owners");
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		}
	}

	// Returns the restaurant id of a restaurant of a restaurant owner
	private int getRestaurantID(String restaurantName, String restOwnerName) {
		int id = -1;
		int restID = getRestaurantOwnerID(restOwnerName);
		String query = "select * from Restaurants where Restaurant_Owners_id = " + restID + " and name = '"
				+ restaurantName + "'";
		ResultSet rset;
		try {
			rset = stmt.executeQuery(query);
			if (rset.next())
				id = rset.getInt("id");
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		}
	}

	// Determines whether if the food exists in a given restaurant of a given
	// restaurant owner
	public boolean doesFoodExist(String name, String restaurantName, String restaurantOwnerUsername) {
		if (name == null || name.equals("") || restaurantName == null || restaurantName.equals(""))
			return false;
		else {
			ResultSet rset = null;
			int restaurantID = getRestaurantID(restaurantName, restaurantOwnerUsername);
			String query = "select * from Foods where name = '" + name + "' and Restaurants_id = " + restaurantID;
			try {
				rset = stmt.executeQuery(query);
				if (rset.next()) {
					return true;
				} else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	// Determines whether if the food exists in the database
	public boolean doesFoodExist(String name) {
		if (name == null || name.equals(""))
			return false;
		else {
			ResultSet rset = null;
			String query = "select * from Foods where name = '" + name + "'";
			try {
				rset = stmt.executeQuery(query);
				if (rset.next()) {
					return true;
				} else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	// Determines whether if the restaurant exists in the database
	public boolean doesRestaurantExist(String name) {
		if (name == null || name.equals(""))
			return false;
		else {
			ResultSet rset = null;
			String query = "select * from Restaurants where name = '" + name + "'";
			try {
				rset = stmt.executeQuery(query);
				if (rset.next()) {
					return true;
				} else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	// Determines whether if the ingredient exists in a food
	public boolean doesIngredientExistInFood(String ingname, String foodname) {
		if (ingname == null || ingname.equals("") || foodname == null || foodname.equals(""))
			return false;
		else {
			ResultSet rset = null;
			int foodID = getFoodID(foodname);
			String query = "select * from Ingredients where name = '" + ingname + "' and Foods_id = " + foodID;
			try {
				rset = stmt.executeQuery(query);
				if (rset.next()) {
					return true;
				} else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	// Determines whether if the ingredient exists in the database
	public boolean doesIngredientExist(String name) {
		if (name == null || name.equals(""))
			return false;
		else {
			ResultSet rset = null;
			String query = "select * from Ingredients where name = '" + name + "'";
			try {
				rset = stmt.executeQuery(query);
				if (rset.next()) {
					return true;
				} else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	// Returns the food id of a given food name
	private int getFoodID(String foodName) {
		int id = -1;
		String query = "select * from Foods where name = '" + foodName + "'";
		ResultSet rset;
		try {
			rset = stmt.executeQuery(query);
			if (rset.next())
				id = rset.getInt("id");
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		}

	}

	// Returns all the ingredients belonging to a food
	public ArrayList<Ingredient> getAllIngredientsForAFood(String foodName) {

		if (doesFoodExist(foodName)) {
			ArrayList<Ingredient> ings = new ArrayList<Ingredient>();
			ResultSet rset = null;

			int foodID = getFoodID(foodName);
			String query = "select * from Ingredients where Foods_id = '" + foodID + "'";
			try {

				rset = stmt.executeQuery(query);
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
		} else
			return null;
	}

	// Returns all the foods in a restaurant of a specified restaurant owner as
	// an ArrayList of Food objects
	public ArrayList<Food> getAllFoods(String restaurantName, String restaurantOwnerName) {

		if (doesRestaurantExist(restaurantName)) {
			Statement stmt2 = null;
			stmt2 = DatabaseManager.createStmt();

			ArrayList<Food> fds = new ArrayList<Food>();
			ResultSet rset = null;
			int restaurantID = getRestaurantID(restaurantName, restaurantOwnerName);
			String query = "select * from Foods where Restaurants_id = '" + restaurantID + "'";
			try {
				Food fd = new Food();
				rset = stmt2.executeQuery(query);
				while (rset.next()) {
					String name = rset.getString("name");
					fd.setName(name);
					fd.setIngredients(getAllIngredientsForAFood(name));
					fds.add(fd);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return fds;
		} else
			return null;
	}

	public static void main(String[] args) {
		RestDB rdb = RestDB.getSoleInstance();
		System.out.println(rdb.doesFoodExist("food1", "testRestaurant", "test"));
		System.out.println(rdb.createRestaurant("testRestaurant", "test2"));
		System.out.println(rdb.doesRestaurantExist("testlkjRestaurant", "test"));
		rdb.getAllIngredientsForAFood("food1");
		rdb.getAllIngredients();
		rdb.getAllFoods("testRestaurant", "test2");

		ArrayList<String> wanted = new ArrayList<String>();
		wanted.add("ing13");
		wanted.add("ing3");
		wanted.add("ing5");
		

		ArrayList<String> unwanted = new ArrayList<String>();
		unwanted.add("ing6");
		unwanted.add("ing12");

		Ingredient ing1 = new Ingredient();
		ing1.setName("ing5");
		Ingredient ing2 = new Ingredient();
		ing2.setName("ing3");

		ArrayList<Ingredient> ings = new ArrayList<Ingredient>();
		ings.add(ing1);
		ings.add(ing2);

		rdb.createFoodToExistingRestaurant("testRestaurant", "test2", "CREATEDFOOD", "meal", "Chinese", 19.99, ings);

		rdb.getFoodList(wanted, unwanted, "meal");

	}

}

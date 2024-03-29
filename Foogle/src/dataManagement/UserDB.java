package dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restaurantAndFoodManagement.Restaurant;
import userManagement.RestaurantOwner;

public class UserDB {
	private static UserDB udb = new UserDB();
	private DatabaseManager dbm = DatabaseManager.getSoleInstance();
	private Statement stmt = DatabaseManager.createStmt();

	public static UserDB getSoleInstance() {
		return udb;
	}
	
	//Returns all the restaurant owners as an arraylist of RestaurantOwner objects
	public ArrayList<RestaurantOwner> getAllRestOwners(){
		ArrayList<RestaurantOwner> owners = new ArrayList<RestaurantOwner>();
		ResultSet rset = null;
		Statement stmtgar = DatabaseManager.createStmt();

		String query = "select * from Restaurant_Owners";
		try {

			rset = stmtgar.executeQuery(query);
			while (rset.next()) {
				RestaurantOwner owner = new RestaurantOwner();
				owner.setUsername(rset.getString("username"));
				owner.setEmail(rset.getString("email"));
				owner.setPassword("password");
				owner.setRestaurants(getAllRestaurantsOfARestaurantOwner(owner.getUsername()));
				owners.add(owner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return owners;
	}
	
	//Returns all the restaurants of a restaurant owner as an arraylist of Restaurant objects
	public ArrayList<Restaurant> getAllRestaurantsOfARestaurantOwner(String username){
		ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
		ResultSet rset = null;
		Statement stmtgar = DatabaseManager.createStmt();

		int roID = getRestaurantOwnerID(username);
		String query = "select * from Restaurants where Restaurant_Owners_id = '" + roID + "'";
		try {

			rset = stmtgar.executeQuery(query);
			while (rset.next()) {
				Restaurant rest = new Restaurant();
				rest.setName(rset.getString("name"));
				rests.add(rest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return rests;
	}
	
	//Returns the id of a specified restaurant owner
	public int getRestaurantOwnerID(String username) {
		int id = -1;
		String query = "select * from Restaurant_Owners where username = '" + username + "'";
		ResultSet rset;
		try {
			rset = stmt.executeQuery(query);
			if (rset.next())
				id = rset.getInt("idRestaurant_Owners");
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		}

	}

	//Returns the username of a id specified restaurant owner
	private String getRestaurantOwnerUN(int id) {
		String un = "";
		String query = "select * from Restaurant_Owners where idRestaurant_Owners = " + id ;
		ResultSet rset;
		try {
			rset = stmt.executeQuery(query);
			if (rset.next())
				un = rset.getString("username");
			return un;
		} catch (SQLException e) {
			e.printStackTrace();
			return un;
		}

	}
	
	//Returns true if the entered password matches the username
	public boolean isAuthenticated(String username, String password) {
		if (password == null || password.equals(""))
			return false;
		else {
			ResultSet rset = null;
			String query = "select * from Restaurant_Owners where username = '" + username + "' and password = '"
					+ password + "'";
			try {
				rset = stmt.executeQuery(query);
				if (rset.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

	}

	//Creates a new Restaurant Owner row in the db table
	public boolean createRestaurantOwnerAccount(String username, String password, String email) {
		if (doesUsernameExist(username) || username == null || password == null || email == null)
			return false;
		else {
			String query = "INSERT INTO Restaurant_Owners VALUE (NULL,'" + username + "','" + password + "','" + email
					+ "');";
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} // Restaurant Owner creation in database
			return true;
		}
	}

	//Checks whether if the username entered is valid. i.e. it doesn't exist.
	private boolean isUsernameValid(String username) {
		if (username == null || username.equals(""))
			return false;
		else {
			ResultSet rset = null;
			String query = "select * from Restaurant_Owners where username = '" + username + "'";
			try {
				rset = stmt.executeQuery(query);
				if (!rset.next()) {
					return true;
				} else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	//Checks whether if the specified username exists
	public boolean doesUsernameExist(String username) {
		if (username == null || username.equals(""))
			return false;
		else {
			ResultSet rset = null;
			String query = "select * from Restaurant_Owners where username = '" + username + "'";
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

	//Checks the uniqueness of the email
	public boolean doesEmailExist(String email) {
		if (email == null || email.equals(""))
			return false;
		else {
			ResultSet rset = null;
			String query = "select * from Restaurant_Owners where email = '" + email + "'";
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

	public static void main(String[] args) {
		UserDB udb = UserDB.getSoleInstance();
		udb.isAuthenticated("test2", "asd");
		udb.createRestaurantOwnerAccount("test3", "test3", "test3");
		System.out.println(udb.isUsernameValid("adasfdf"));
		System.out.println(udb.doesUsernameExist("test3"));
		System.out.println(udb.doesEmailExist("asdasdfdf"));
		ArrayList<RestaurantOwner> arr = udb.getAllRestOwners();
		for(int i = 0; i < arr.size();i++)
			System.out.println(arr.get(i).getUsername());

	}

}

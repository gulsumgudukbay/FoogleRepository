package dataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;

public class UserDB {
	private static UserDB udb = new UserDB();
	private DatabaseManager dbm = DatabaseManager.getSoleInstance();
	private Statement stmt = DatabaseManager.createStmt();

	public static UserDB getSoleInstance() {
		return udb;
	}
	
	
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

	public String getRestaurantOwnerUN(int id) {
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
			System.out.println("Created!");
			return true;
		}
	}

	public boolean isUsernameValid(String username) {
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

	}

}

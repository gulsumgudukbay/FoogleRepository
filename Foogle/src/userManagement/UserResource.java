package userManagement;

import java.util.ArrayList;

import dataManagement.RestDB;
import dataManagement.UserDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import searchManagement.SearchController;

public class UserResource {
	// MARK: Properties
	private ArrayList<User> users;
	RestDB rdb = RestDB.getSoleInstance();
	UserDB udb = UserDB.getSoleInstance();
	SearchController sc = new SearchController();
	
	// MARK: Constructors
	public UserResource() {
		users = new ArrayList<User>();
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public ArrayList<User> getUsers() {
		return this.users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	// Utility methods 
	public void listAllUsers() {
		for(int i = 0; i < this.users.size(); i++) {
			System.out.println("User #" + i + "\t" + users.get(i));
		}
	}
	
	// Search method, returns list of food
	public ArrayList<Food> searchFood(ArrayList<Ingredient> wanted, ArrayList<Ingredient> unwanted, String types) {
		return sc.showResults(wanted, unwanted, types);
	}
}
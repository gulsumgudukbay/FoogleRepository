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
	// TODO: Database instance
	
	// TODO: Constructors
	
	// MARK: Methods
	// Accessors and Mutators
	public ArrayList<User> getUsers() {
		return this.users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	// TODO: Utility methods
}
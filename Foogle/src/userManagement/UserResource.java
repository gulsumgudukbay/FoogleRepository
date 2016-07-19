package userManagement;

import java.util.ArrayList;

import dataManagement.RestDB;
import dataManagement.UserDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import searchManagement.SearchController;

public class UserResource {
	// MARK: Properties
	RestDB rdb = RestDB.getSoleInstance();
	UserDB udb = UserDB.getSoleInstance();
	SearchController sc = new SearchController();
	
	private ArrayList<RestaurantOwner> owners;
	Customer customer;
	Admin admin;
	ArrayList<Ingredient> allIngredients = rdb.getAllIngredients();
	
	// MARK: Constructors
	public UserResource() {
		owners = new ArrayList<RestaurantOwner>();
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public ArrayList<RestaurantOwner> getOwners() {
		return this.owners;
	}
	public void setOwners(ArrayList<RestaurantOwner> owners) {
		this.owners = owners;
	}

	// Utility methods 
	public void listAllUsers() {
		for(int i = 0; i < this.owners.size(); i++) {
			System.out.println("User #" + i + "\t" + owners.get(i));
		}
	}
	
	// Search method, returns list of food
	public ArrayList<Food> searchFood(ArrayList<Ingredient> wanted, ArrayList<Ingredient> unwanted, String types) {
		return sc.showResults(wanted, unwanted, types);
	}
}
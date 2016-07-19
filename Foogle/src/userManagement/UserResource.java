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
	
	// FIXME: Get owners from UserDB. Waiting for database methods
	static ArrayList<RestaurantOwner> owners;
	Customer customer;
	Admin admin;
	// FIXME: Customer has the same property. From database or from customer?
	ArrayList<Ingredient> allIngredients = rdb.getAllIngredients();
	
	// MARK: Constructors
	public UserResource() {
		// TODO: Set owners and other properties
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public ArrayList<RestaurantOwner> getOwners() {
		return owners;
	}
	public void setOwners(ArrayList<RestaurantOwner> theOwners) {
		owners = theOwners;
	}

	// Utility methods 
	// Display users
	public void listAllOwners() {
		for(int i = 0; i < owners.size(); i++) {
			System.out.println("Owner #" + i + "\t" + owners.get(i));
		}
	}
	// Search method, returns list of food
	public ArrayList<Food> searchFood(ArrayList<Ingredient> wanted, ArrayList<Ingredient> unwanted, String types) {
		return sc.showResults(wanted, unwanted, types);
	}
	// Get all ingredients for GUI
	public ArrayList<Ingredient> getAllIngredients() {
		return this.allIngredients;
	}
	// Appends new owner to owners list
	public static void appendOwner(RestaurantOwner owner) {
		owners.add(owner);
	}
}
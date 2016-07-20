package userManagement;

import java.util.ArrayList;

import dataManagement.RestDB;
import dataManagement.UserDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;
import searchManagement.SearchController;

public class UserResource {
	// MARK: Properties
	static RestDB rdb = RestDB.getSoleInstance();
	static UserDB udb = UserDB.getSoleInstance();
	SearchController sc = new SearchController();
	
	static ArrayList<RestaurantOwner> owners = udb.getAllRestOwners();
	Customer customer = new Customer();
	Admin admin = new Admin();
	ArrayList<Ingredient> allIngredients = customer.getAllIngredients();
	
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
	// Returns restaurant owner with the given name, in owners list.
	public RestaurantOwner getRestaurantOwner(String name) {
		for(RestaurantOwner owner: owners) {
			if(owner.getUsername().equals(name)) {
				return owner;
			}
		}
		return null;
	}
}
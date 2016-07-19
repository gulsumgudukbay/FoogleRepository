package userManagement;

import java.util.ArrayList;

import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;

public class Admin extends User{
	// MARK: Properties
	private ArrayList<Ingredient> pendingIngredients;
	private ArrayList<Restaurant> pendingRestaurants;
	
	// MARK: Constructors
	public Admin() {
		this.pendingIngredients = new ArrayList<Ingredient>();
		this.pendingRestaurants = new ArrayList<Restaurant>();
	}
	public Admin(ArrayList<Ingredient> pendingIngredients, ArrayList<Restaurant> pendingRestaurants) {
		this.pendingIngredients = pendingIngredients;
		this.pendingRestaurants = pendingRestaurants;
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public ArrayList<Ingredient> getPendingIngredients() {
		return this.pendingIngredients;
	}
	public ArrayList<Restaurant> getPendingRestaurants() {
		return this.pendingRestaurants;
	}
	public void setPendingIngredients(ArrayList<Ingredient> pendingIngredients) {
		this.pendingIngredients = pendingIngredients;
	}
	public void setPendingRestaurants(ArrayList<Restaurant> pendingRestaurants) {
		this.pendingRestaurants = pendingRestaurants;
	}
	
	// Utility methods
	// TODO: confirmIngredient
	// TODO: confirmRestaurant
	
}
package userManagement;

import java.util.ArrayList;

import dataManagement.RestDB;
import dataManagement.UserDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import searchManagement.SearchController;

public class Admin extends User{
	// MARK: Properties
	private ArrayList<Ingredient> pendingIngredients;
	private ArrayList<Restaurant> pendingRestaurants;
	
	// TODO: Constructors
	
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
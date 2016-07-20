package userManagement;

import java.util.ArrayList;

import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import dataManagement.PendingDB;
import restaurantAndFoodManagement.Restaurant;
import userManagement.RestaurantOwner;

public class Admin extends User{
	PendingDB pdb = PendingDB.getSoleInstance();
	private static Admin a = new Admin();
	
	public static Admin getSoleInstance() {
		return a;
	}
	
	
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
	// FIXME: Needs checking
	// Returns merged list
	public void confirmIngredients(ArrayList<Food> foods, ArrayList<Ingredient> guiList, ArrayList<Ingredient> otherList) {
		// Call respective methods depending on whether it's isConfirmed() or not
		for(Ingredient ingredient: pendingIngredients) {
			if(ingredient.isConfirmed()) {
				pdb.confirmIngredient(ingredient.getName());
			} else {
				pdb.rejectIngredient(ingredient.getName());
			}
		}
		
		if(pdb.isAllIngredientsProcessed()) {
			for( Food food: foods) {
				ArrayList<Ingredient> newList = RestaurantOwner.mergeLists(guiList, otherList);
				food.setIngredients(newList);
			}
			pdb.removeAllPendingIngredients();	
		}	
	}
	// FIXME: Needs checking
	public void confirmRestaurants() {
		// Call respective methods depending on whether it's isConfirmed() or not
		for(Restaurant restaurant: pendingRestaurants) {
			if(restaurant.isConfirmed()) {
				pdb.confirmRestaurant(restaurant.getName());
			} else {
				pdb.rejectRestaurant(restaurant.getName());
			}
		}
		
		pdb.removeAllPendingRestaurants();
	}
	
}
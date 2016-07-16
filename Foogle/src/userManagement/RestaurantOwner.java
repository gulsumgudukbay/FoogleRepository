package userManagement;

import java.util.ArrayList;

import dataManagement.RestDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import searchManagement.SearchController;

public class RestaurantOwner extends User {
	RestDB rdb = RestDB.getSoleInstance();
	SearchController sc = new SearchController();
	
	// MARK: Properties
	private String username;
	private String password;
	private String email;
	private ArrayList<Restaurant> restaurants;
	private Int restaurantNo;
	
	// MARK: Contructors
	public RestaurantOwner() {
		this.username = "";
		this.password = "";
		this.email = "";
		this.restaurants = new ArrayList<Restaurant>();
		this.restaurantNo = 0;
	}
	public RestaurantOwner(String username, String password, String email) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		
		this.restaurants = new ArrayList<Restaurant>();
		this.restaurantNo = 0;
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}
	public Int getRestaurantNo() {
		return restaurantNo;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRestaurants(ArrayList<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	public void setRestaurantNo(Int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	
	// Utility methods
	// Creates a new restaurant by calling db method and appends it to restaurants list.
	public void addRestaurant(Restuarant restaurant) {
		rdb.createRestaurant(restaurant.getName(), this.getUsername());
		restaurants.add(restaurant);
	}
	public void addFoodToRestaurant(Food food, Restaurant restaurant, ArrayList<Ingredient> ingredients) {
		String ingredientStr = "";
		
		for(Ingredient ingredient: ingredients) {
			ingredientStr += ingredient.getName();
		}
	}
	// Foods of a specific restaurant? All restaurants?
	public void viewFoods() {
		/*for(Restaurant restaurant: restaurants) {
			sb.getAllFoods(restaurant.getName());
		}*/
	}
	public void viewRestaurants() {
		// sb.getAllRestaurants(this.getName());
	}
	public Restaurant getRestaurant(name) {
		for(Restaurant restaurant: restaurants) {
			if(restaurant.getName() == name) {
				return restaurant;
			}
		}
		return null;
	}
}

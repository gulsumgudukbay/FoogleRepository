package userManagement;
import java.util.ArrayList;

import dataManagement.RestDB;
import dataManagement.UserDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;
import restaurantAndFoodManagement.Restaurant;
import userManagement.UserResource;
import searchManagement.SearchController;

public class RestaurantOwner extends User {
	RestDB rdb = RestDB.getSoleInstance();
	UserDB udb = UserDB.getSoleInstance();
	SearchController sc = new SearchController();
	
	// MARK: Properties
	private String username;
	private String password;
	private String email;
	private ArrayList<Restaurant> restaurants;
	
	// MARK: Contructors
	public RestaurantOwner() {
		this.username = "";
		this.password = "";
		this.email = "";
		this.restaurants = new ArrayList<Restaurant>();
	}
	public RestaurantOwner(String username, String password, String email) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		
		this.restaurants = new ArrayList<Restaurant>();
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
	
	// Utility methods
	// Creates a new restaurant by calling db method and appends it to restaurants list.
	public void addRestaurant(Restaurant restaurant) {
		rdb.createRestaurant(restaurant.getName(), this.getUsername());
		restaurants.add(restaurant);
	}
	// TODO: Check if the food is confirmed using PendingDB, using loop
	public void addFoodToRestaurant(Food food, Restaurant restaurant, ArrayList<Ingredient> ingredients) {
		rdb.createFoodToExistingRestaurant(restaurant.getName(),this.getUsername(), food.getName(), food.getType(), food.getCuisine(), food.getPrice(), ingredients);
	}
	// FIXME: Ambiguous method decleration
	// Foods of a specific restaurant? All restaurants?
	public void viewFoods() {
		/*for(Restaurant restaurant: restaurants) {
			rdb.getAllFoods(restaurant.getName());
		}*/
	}
	public void viewRestaurants() {
		for(int i = 0; i < this.restaurants.size(); i++) {
			System.out.println("Restaurant #" + i + "\t" + restaurants.get(i));
		}
	}
	// Returns restaurant with the given name, in restaurants list.
	public Restaurant getRestaurant(String name) {
		for(Restaurant restaurant: restaurants) {
			if(restaurant.getName() == name) {
				return restaurant;
			}
		}
		return null;
	}
	
	// Sign Up method
	// Append it to Users owners list
	public void createRestaurantOwnerAccount(String username, String password, String email) {
		RestaurantOwner owner = new RestaurantOwner(username, password, email);
		UserResource.appendOwner(owner);
		udb.createRestaurantOwnerAccount(username, password, email);
	}
	// Login method
	public boolean loginAsRestaurantOwner(String username, String password) {
		return udb.isAuthenticated(username, password);
	}
	
	// Username and Email Checks
	public boolean doesUsernameExist(String username) {
		return udb.doesUsernameExist(username);
	}
	public boolean doesEmailExist(String email) {
		return udb.doesEmailExist(email);
	}
}

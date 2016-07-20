package restaurantAndFoodManagement;

import java.util.ArrayList;

import dataManagement.PendingDB;
import dataManagement.RestDB;
import userManagement.RestaurantOwner;

public class Restaurant {
	RestDB rdb = RestDB.getSoleInstance();
	// MARK: Properties
	private String name;
	private ArrayList<Food> foods;
	private boolean isConfirmed;
	
	// MARK: Constructors
	public Restaurant() {
		this.name = "";
		foods = null;
		isConfirmed = false;
	}
	
	public Restaurant(String name) {
		this.setName(name);
	}
	
	public Restaurant(String name, ArrayList<Food> foods, RestaurantOwner owner) {
		this.setName(name);
		this.setFoods(rdb.getAllFoods(name, owner.getUsername()));
		this.setConfirmed(false);
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public String getName() {
		return this.name;
	}
	public ArrayList<Food> getFoods() {
		return this.foods;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}
	public boolean isConfirmed() {
		return isConfirmed;
	}
	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
	// Utility methods
	// Returns the food with the given name
	public Food getFood(String name) {
		for(Food temp: foods) {
			if(temp.getName().equals(name)) {
				// TEST
				System.out.println("Found: " + name);
				return temp;
			}
		}
		System.out.println("Ingredient " + name + " not found.");
		return null;
	}
	
	// Checks occurences of a food with the given name. Returns true if the given food is already in foods list.
	public boolean checkFoodOccurance(String name) {
		for(Food temp: foods) {
			if(temp.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	// Creates a new food with given parameters, and adds the food to foods list (if it's not already on the list)
	public void addFood(String name, String restOwner, String cuisine, String type, Double price, ArrayList<Ingredient> ingredients) {
		if (this.checkFoodOccurance(name)) {
			// TEST
			System.out.println("Food " + name + " is already on the list");
		} else {
			
			// TEST
			System.out.println("Food " + name + " is added to the list");
		}
		Food temp = new Food(name, cuisine, type, price, ingredients);
		temp.setIngredients(rdb.getAllIngredientsForAFood(name));
		rdb.createFoodToExistingRestaurant(this.getName(), restOwner, temp.getName(), temp.getType(), temp.getCuisine(), temp.getPrice(), ingredients);

	}
	
	// TEST
	public static void main(String[] args) {
		Ingredient myTomato = new Ingredient("tomato");
		Ingredient myChicken = new Ingredient("chicken");
		Ingredient myFries = new Ingredient("fries");
		Ingredient myLettuce = new Ingredient("lettuce");
		Ingredient myPotato = new Ingredient("potato");
		
		ArrayList<Ingredient> myFirstIngredients = new ArrayList<Ingredient>();
		myFirstIngredients.add(myTomato);
		myFirstIngredients.add(myChicken);
		myFirstIngredients.add(myFries);
		
		ArrayList<Ingredient> mySecondIngredients = new ArrayList<Ingredient>();
		mySecondIngredients.add(myLettuce);
		mySecondIngredients.add(myPotato);
		
		//Food myFirstFood = new Food("donner", 10.0, myFirstIngredients);
		//Food mySecondFood = new Food("donmez", 8.0, mySecondIngredients);
		
		ArrayList<Food> myFoods = new ArrayList<Food>();
		//myFoods.add(myFirstFood);
		//myFoods.add(mySecondFood);
		
		//Restaurant myRestaurant = new Restaurant("hd iskender", myFoods);
		
		//myRestaurant.getFood("donner");
		//myRestaurant.addFood("kumpir", 8.5, myFirstIngredients);
	}
}
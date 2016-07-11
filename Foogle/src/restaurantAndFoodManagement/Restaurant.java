package restaurantAndFoodManagement;

import java.io.*;
import java.util.*;

public class Restaurant {
	// MARK: Properties
	private String name;
	private ArrayList<Food> foods;
	
	// MARK: Constructors
	public Restaurant() {
		this.name = "";
		this.foods = new ArrayList<Food>();
	}
	public Restaurant(String name, ArrayList<Food> foods) {
		this.setName(name);
		this.setFoods(foods);
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
	
	// Utility methods
	// Returns the food with the given name
	public Food getFood(String name) {
		boolean found = false;
		for(Food temp: foods) {
			if(temp.name == name) {
				found = true;
				// TEST
				System.out.println("Found: " + name);
				return temp;
			}
		}
		if(!found) {
			System.out.println("Ingredient " + name + " not found.");
			return null;
		}
		return null;
	}
	
	// Checks occurences of a food with the given name. Returns true if the given food is already in foods list.
	public boolean checkFoodOccurance(String name) {
		for(Food temp: foods) {
			if(temp.name == name) {
				return true;
			}
		}
		return false;
	}
	
	// Creates a new food with given parameters, and adds the food to foods list (if it's not already on the list)
	// FIXME: right now it only accepts name, price and ingredients. CHECKFOODOCCURANCE
	public void addFood(String name, Double price, ArrayList<Ingredient> ingredients) {
		Food temp = new Food(name, price, ingredients);
		
		if (this.checkFoodOccurance(name)) {
			// TEST
			System.out.println("Food " + name + " is already on the list");
		} else {
			this.foods.add(temp);
		}
	}
}
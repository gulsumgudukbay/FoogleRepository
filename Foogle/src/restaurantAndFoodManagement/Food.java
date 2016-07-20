package restaurantAndFoodManagement;

import java.io.*;
import java.util.*;

import dataManagement.RestDB;

public class Food {
	// MARK: Properties
	private String name;
	private String cuisine;
	private String type;
	private double price;
	private ArrayList<Ingredient> ingredients;
	public RestDB rdb = RestDB.getSoleInstance();
	
	// MARK: Constructors
	public Food(String name, String cuisine, String type, double price, ArrayList<Ingredient> ingredients) {
		this.setCuisine(cuisine);
		this.setName(name);
		this.setPrice(price);
		this.setIngredients(rdb.getAllIngredientsForAFood(name));
		this.setType(type);
	}
	public Food() {
		this.cuisine = "";
		this.type = "";
		this.name = "";
		this.price = 0.0;
		this.ingredients = rdb.getAllIngredientsForAFood(name);
	}
	
	// MARK: Methods
	// Accessors and Mutators
	
	public ArrayList<Restaurant> getAllRestaurantsOfFood(String foodName){
		return rdb.getAllRestaurantsOfFood(foodName);
	}
	
	public String getCuisine() {
		System.out.println("CUISINE "+ cuisine);
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		System.out.println("SETTING "+cuisine);
		this.cuisine = cuisine;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	public ArrayList<Ingredient> getIngredients() {
		return this.ingredients;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	// Utility methods
	public boolean searchInIngredients(String nameOfIngredient){
		for(int i = 0; i < ingredients.size();i++)
			if(ingredients.get(i).getName().equals(nameOfIngredient))
				return true;
		return false;
	}
	
	public String toString(){
		String result = "";
		result+= name+" "+type+" "+price+" ingredients: ";
		for(int i = 0; i < ingredients.size();i++)
			result+= ingredients.get(i)+" ";
		return result;
	}
	
	// Finds the ingredient with given name, in ingredients array list and returns it
	public Ingredient getIngredient(String name) {
		for(Ingredient temp: ingredients) {
			if(temp.getName() == name) {
				// TEST
				System.out.println("Found: " + name);
				return temp;
			}
		}
		System.out.println("Ingredient " + name + " not found.");
		return null;
	}
	
	public String listToString() {
	    String result = "Ingredients: ";
	    for (int i = 0; i < ingredients.size(); i++) {
	    	if(i != ingredients.size() -1 )
	    		result += ingredients.get(i).getName() + ",";
	    	else
	    		result += ingredients.get(i).getName();
	    }
	    return result;
	}
	
	public String listToRestaurant(){
		String result = "Restaurants: ";
		ArrayList<Restaurant> restaurantsForFood = getAllRestaurantsOfFood(this.getName()); 
		for (int i = 0; i < restaurantsForFood.size(); i++) {
	    	if(i != restaurantsForFood.size() -1 )
	    		result += restaurantsForFood.get(i).getName() + ",";
	    	else
	    		result += restaurantsForFood.get(i).getName();
	    }
	    return result;
		
	}
	
	// TEST
	public static void main(String[] args) {
		Ingredient myTomato = new Ingredient("tomato");
		Ingredient myChicken = new Ingredient("chicken");
		Ingredient myFries = new Ingredient("fries");
		
		ArrayList<Ingredient> myIngredients = new ArrayList<Ingredient>();
		myIngredients.add(myTomato);
		myIngredients.add(myChicken);
		myIngredients.add(myFries);
		
		//Food myFood = new Food("donner", 10.0, myIngredients);
		
		//System.out.println(myFood.getName());
		//System.out.println(myFood.getPrice());
		//System.out.println(myFood.getIngredients());
		
		//myFood.getIngredient("tomato");
	}
}

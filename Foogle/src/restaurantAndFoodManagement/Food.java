package restaurantAndFoodManagement;

import java.io.*;
import java.util.*;

public class Food {
	// MARK: Properties
	private String name;
	private Double price;
	private ArrayList<Ingredient> ingredients;
	// TODO: private OtheringProcessor oip;
	// TODO: private String otheringBuff; 
	// TODO: enum type & cuisine
	
	// MARK: Constructors
	public Food(String name, Double price, ArrayList<Ingredient> ingredients) {
		this.setName(name);
		this.setPrice(price);
		this.setIngredients(ingredients);
	}
	public Food() {
		this.name = "";
		this.price = 0.0;
		this.ingredients = new ArrayList<Ingredient>();
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public String getName() {
		return this.name;
	}
	public Double getPrice() {
		return this.price;
	}
	public ArrayList<Ingredient> getIngredients() {
		return this.ingredients;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	// Utility methods
	// Finds the ingredient with given name, in ingredients array list and returns it
	public Ingredient getIngredient(String name) {
		boolean found = false;
		for(Ingredient temp: ingredients) {
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
	// TODO: insertToPending(otheringBuf)
	
	// TEST
	public static void main(String[] args) {
		Ingredient myTomato = new Ingredient("tomato");
		Ingredient myChicken = new Ingredient("chicken");
		Ingredient myFries = new Ingredient("fries");
		
		ArrayList<Ingredient> myIngredients = new ArrayList<Ingredient>();
		myIngredients.add(myTomato);
		myIngredients.add(myChicken);
		myIngredients.add(myFries);
		
		Food myFood = new Food("donner", 10.0, myIngredients);
		
		System.out.println(myFood.getName());
		System.out.println(myFood.getPrice());
		System.out.println(myFood.getIngredients());
		
		myFood.getIngredient("tomato");
	}
}

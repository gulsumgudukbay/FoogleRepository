package userManagement;

import java.util.ArrayList;

import dataManagement.RestDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import searchManagement.SearchController;

public class Customer extends User {
	RestDB rdb = RestDB.getSoleInstance();
	SearchController sc = new SearchController();
	
	// TODO: Uncomment the property below
	// private Event input;
	
	public ArrayList<Ingredient> getAllIngredients(){
		return rdb.getAllIngredients();
	}
	
	public ArrayList<Food> search(ArrayList<String> wanted, ArrayList<String> unwanted, String types){
		return sc.showResults(wanted, unwanted, types);
	}
	
	// FIXME: Login and Sign Up
	// How do we login and sign up user? Customer doesn't have username or anything. 
	// Where should we write these methods? Where should we call them?
}		
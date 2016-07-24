package userManagement;

import java.util.ArrayList;

import dataManagement.RestDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import searchManagement.SearchController;

public class Customer extends User {
	RestDB rdb = RestDB.getSoleInstance();
	SearchController sc = new SearchController();
	private static Customer c = new Customer();
	ArrayList<Ingredient> ings = rdb.getAllIngredients();
	
	public static Customer getSoleInstance() {
		return c;
	}
	
	public ArrayList<Ingredient> getAllIngredients(){
		//System.out.println("HERE"+ings.toString());
		return rdb.getAllIngredients();
	}
	
	public ArrayList<Food> search(ArrayList<Ingredient> wanted, ArrayList<Ingredient> unwanted, String types){
		return sc.showResults(wanted, unwanted, types);
	}
}		
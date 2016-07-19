package searchManagement;

import java.util.ArrayList;

import dataManagement.RestDB;
import restaurantAndFoodManagement.Food;

public class SearchController {

	RestDB rdb = RestDB.getSoleInstance();
	
	// gets the input from gui as int arraylist and returns the wanted ingredients' 
	//names as string arraylist by finding corresponding indexed ingredients from 
	//getAllIngredients() mathod and getting their names and placing into arraylist
	public static ArrayList<String> getUnwantedIngredients(ArrayList<Integer> guiInput){
		//fake
		ArrayList<String> unwntd = new ArrayList<String>();
		unwntd.add("ing5");
		return unwntd;
	}
	
	
	// gets the input from gui as int arraylist and returns the wanted ingredients' 
	//names as string arraylist by finding corresponding indexed ingredients from 
	//getAllIngredients() mathod and getting their names and placing into arraylist
	public static ArrayList<String> getWantedIngredients(ArrayList<Integer> guiInput){
		
		//fake
		ArrayList<String> wntd = new ArrayList<String>();
		wntd.add("ing1");
		wntd.add("ing2");
		wntd.add("ing3");
		wntd.add("ing4");
		return wntd;
		
	}
	
	
	// Gets lists of Ingredients and calls search controller's method with lists of Strings (Ingredient names)
	public ArrayList<Food> showResults(ArrayList<Ingredient> wanted, ArrayList<Ingredient> unwanted, String types){
		ArrayList<String> wantedList = new ArrayList<String>();
		ArrayList<String> unwantedList = new ArrayList<String>();
		
		for(Ingredient ingredient: wanted) {
			wantedList.add(ingredient.getName());
		}
		
		for(Ingredient ingredient: unwanted) {
			unwantedList.add(ingredient.getName());
		}
		
		return rdb.getFoodList(wantedList, unwantedList, types);
	}
}

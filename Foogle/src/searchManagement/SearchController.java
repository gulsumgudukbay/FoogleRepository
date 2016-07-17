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
	
	
	
	public ArrayList<Food> showResults(ArrayList<String> wanted, ArrayList<String> unwanted, String types){
		return rdb.getFoodList(wanted, unwanted, types);
	}
}

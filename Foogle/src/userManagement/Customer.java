package userManagement;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.*
import java.io*
>>>>>>> branch 'master' of https://github.com/gulsumgudukbay/FoogleRepository.git

<<<<<<< HEAD
import dataManagement.RestDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import searchManagement.SearchController;

public class Customer extends User {
	RestDB rdb = RestDB.getSoleInstance();
	SearchController sc = new SearchController();
	
	public ArrayList<Ingredient> getAllIngredients(){
		return rdb.getAllIngredients();
	}
	
	public ArrayList<Food> search(ArrayList<String> wanted, ArrayList<String> unwanted, String types){
		return sc.showResults(wanted, unwanted, types);
	}
	
		
=======
public class Customer extends User {
>>>>>>> branch 'master' of https://github.com/gulsumgudukbay/FoogleRepository.git
	
}

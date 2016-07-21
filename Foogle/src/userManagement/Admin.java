package userManagement;

import java.util.ArrayList;

import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import dataManagement.PendingDB;
import restaurantAndFoodManagement.Restaurant;
import userManagement.RestaurantOwner;

public class Admin extends User{
	PendingDB pdb = PendingDB.getSoleInstance();
	private static Admin a = new Admin();
	public static ArrayList<Food> pendingFoods = new ArrayList<Food>();
	public static ArrayList<ArrayList<Restaurant>> restsforCorrFoods = new ArrayList<ArrayList<Restaurant>>();
	public static ArrayList<Restaurant> pendingRests = new ArrayList<Restaurant>();
	
	public static Admin getSoleInstance() {
		return a;
	}
	
	
	// MARK: Properties
	private ArrayList<Ingredient> pendingIngredients;
	private ArrayList<Restaurant> pendingRestaurants;
	
	// MARK: Constructors
	public Admin() {
		this.pendingIngredients = new ArrayList<Ingredient>();
		this.pendingRestaurants = new ArrayList<Restaurant>();
	}

	public Admin(ArrayList<Ingredient> pendingIngredients, ArrayList<Restaurant> pendingRestaurants) {
		this.pendingIngredients = pendingIngredients;
		this.pendingRestaurants = pendingRestaurants;
	}
	
	public void addToRestsForCorrFoods(ArrayList<Restaurant> arr){
		restsforCorrFoods.add(arr);
	}
	
	public void addToPendingFoods(Food fd){
		pendingFoods.add(fd);
	}
	public void addToPendingFoodRestaurants(ArrayList<Restaurant> rests){
		restsforCorrFoods.add(rests);
	}
	public void addToPendingRestaurants(Restaurant r){
		pendingRests.add(r);
	}
	
	public boolean isAllIngredientsProcessed(){
		return pdb.isAllIngredientsProcessed();
	}
	
	public boolean isAllRestaurantsProcessed(){
		return pdb.isAllRestaurantsProcessed();
	}
	public void traverseAllFoods(RestaurantOwner restOwner){
		for(int i = 0; i < pendingFoods.size(); i++){
			if(pdb.isAllOtherIngredientsConfirmedFor(pendingFoods.get(i).getName()))
				restOwner.addFoodToRestaurants(pendingFoods.get(i), restsforCorrFoods.get(i));	
		}
		//removeAllPendingIngredients();
	}
	
	public void removeAllPendingIngredients(){
		pdb.removeAllPendingIngredients();
	}
	
	public void removeAllPendingRestaurants(){
		pdb.removeAllPendingRestaurants();
	}
	
	public void traverseAllRestaurants(RestaurantOwner restOwner){
		for(int i = 0; i < pendingRests.size(); i++)
			if(pdb.isRestaurantConfirmed(pendingRests.get(i).getName()))
				restOwner.addRestaurant(pendingRests.get(i));
		
	}
	
	public ArrayList<Ingredient> getAllPendingIngredients(){
		return pdb.getAllPendingIngredients();
	}
	
	public ArrayList<Restaurant> getAllPendingRestaurants(){
		return pdb.getAllPendingRestaurants();
	}
	
	
	
	
	// MARK: Methods
	// Accessors and Mutators
	public ArrayList<Ingredient> getPendingIngredients() {
		return this.pendingIngredients;
	}
	public ArrayList<Restaurant> getPendingRestaurants() {
		return this.pendingRestaurants;
	}
	public void setPendingIngredients(ArrayList<Ingredient> pendingIngredients) {
		this.pendingIngredients = pendingIngredients;
	}
	public void setPendingRestaurants(ArrayList<Restaurant> pendingRestaurants) {
		this.pendingRestaurants = pendingRestaurants;
	}
	
	public void confirmIngredient(String name){
		pdb.confirmIngredient(name);
	}
	
	public void rejectIngredient(String name){
		pdb.rejectIngredient(name);
	}
	
	public void confirmRestaurant(String name){
		pdb.confirmRestaurant(name);
	}
	
	public void rejectRestaurant(String name){
		pdb.rejectRestaurant(name);
	}
	
	public void addToPendingIngredients(Ingredient ing, String foodname){
		pdb.insertToPendingIngredients(ing, foodname);
	}
	
	public void addToPendingRestaurants(String ownerUN, String rest){
		pdb.insertToPendingRestaurants(ownerUN, rest);
	}
	
	// Utility methods
	// FIXME: Needs checking
	// Returns merged list
	public void confirmIngredients(ArrayList<Food> foods, ArrayList<Ingredient> guiList, ArrayList<Ingredient> otherList) {
		// Call respective methods depending on whether it's isConfirmed() or not
		for(Ingredient ingredient: pendingIngredients) {
			if(ingredient.isConfirmed()) {
				pdb.confirmIngredient(ingredient.getName());
			} else {
				pdb.rejectIngredient(ingredient.getName());
			}
		}
		
		if(pdb.isAllIngredientsProcessed()) {
			for( Food food: foods) {
				ArrayList<Ingredient> newList = RestaurantOwner.mergeLists(guiList, otherList);
				food.setIngredients(newList);
			}
			pdb.removeAllPendingIngredients();	
		}	
	}
	// FIXME: Needs checking
	public void confirmRestaurants() {
		// Call respective methods depending on whether it's isConfirmed() or not
		for(Restaurant restaurant: pendingRestaurants) {
			if(restaurant.isConfirmed()) {
				pdb.confirmRestaurant(restaurant.getName());
			} else {
				pdb.rejectRestaurant(restaurant.getName());
			}
		}
		
		if(pdb.isAllRestaurantsProcessed()) {
			pdb.removeAllPendingRestaurants();
		}
	}
	
}
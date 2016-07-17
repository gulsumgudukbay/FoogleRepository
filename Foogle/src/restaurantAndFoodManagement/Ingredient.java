package restaurantAndFoodManagement;

import java.util.ArrayList;

import dataManagement.RestDB;

public class Ingredient {
	String name;
	RestDB rdb = RestDB.getSoleInstance();
	
	public Ingredient() {
		this.name = "";
	}
	public Ingredient(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return name;
	}
}

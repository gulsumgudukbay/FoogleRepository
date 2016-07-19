package restaurantAndFoodManagement;

import java.util.ArrayList;

import dataManagement.RestDB;

public class Ingredient {
	private String name;
	private boolean isConfirmed;
	//RestDB rdb = RestDB.getSoleInstance();
	
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
	public boolean isConfirmed() {
		return isConfirmed;
	}
	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
}

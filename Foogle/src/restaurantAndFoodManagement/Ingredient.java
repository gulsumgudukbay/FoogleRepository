package restaurantAndFoodManagement;

public class Ingredient {
	String name;
	
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
}

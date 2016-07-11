package restaurantAndFoodManagement;

public class Food {
	// MARK: Properties
	private String name;
	private ArrayList<Ingredient> ingredients;
	private Double price
	private OtheringProcessor oip;
	private String otheringBuff; 
	// TODO: enum type & cuisine
	
	// MARK: Constructors
	public Food(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	public Food() {
		this.name = "";
		this.price = 0.0;
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public String getName() {
		return this.name
	}
	public Double getPrice() {
		return this.price
	}
	// TODO: get method for ingredients
	public void setName(String name) {
		this.name = name
	}
	public void setPrice(Double price) {
		this.price = price
	}
	// TODO: set method for ingredients
	
	// Utility methods
	// Finds the ingredient with given name, in ingredients array list and returns it
	// TODO: test this method after creating Ingredient
	public Ingredient getIngredient(String name) {
		boolean found = false;
		for(Ingredient temp: ingredients) {
			if(temp.name == name) {
				found = true;
				return temp;
			}
		}
		if(!found) {
			return null;
		}
	}
	// TODO: insertToPending(otheringBuf)
}

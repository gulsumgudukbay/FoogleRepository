package restaurantAndFoodManagement;

public class Restaurant {
	// MARK: Properties
	private ArrayList<Food> foods;
	private String name;
	
	// MARK: Constructors
	public Restaurant() {
		this.name = "";
		// TODO: foods initialization
	}
	public Restaurant(String name) {
		
	}
	
	// MARK: Methods
	// Accessors and Mutators
	public String getName() {
		return this.name
	}
	public void setName(String name) {
		this.name = name
	}
	
	// Utility methods
}
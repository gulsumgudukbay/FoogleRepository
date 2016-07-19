package dataManagement;

import java.util.ArrayList;
import java.util.StringTokenizer;

import restaurantAndFoodManagement.Ingredient;


public class OtherIngredientProcessor {

	private StringTokenizer st;
	private String otherBuffer;
	
	public OtherIngredientProcessor(String ings) {
		otherBuffer = ings;
	}
	
	public ArrayList<Ingredient> insertToPending(String ings) {
		ArrayList<Ingredient> ingsSeperated = new ArrayList<Ingredient> ();
			
		st = new StringTokenizer(ings);
		while(st.hasMoreTokens()){
			ingsSeperated.add(new Ingredient(st.nextToken()));
		}
			
		return ingsSeperated;
	}
}
package dataManagement;

import java.util.ArrayList;

import restaurantAndFoodManagement.Ingredient;


public class OtherIngredientProcessor {

	private String otherBuffer;
	
	public OtherIngredientProcessor(String ings) {
		otherBuffer = ings;
	}
	
	public ArrayList<Ingredient> insertToPending(String ings) {
		ArrayList<Ingredient> ingsSeperated = new ArrayList<Ingredient> ();
		int currentFirst = 0;
		
		// Test ettim, düzgün çalışıyor tek problem son ing tek harfli olursa hata veriyor. Bu da bir problem olmaz zaten ama test ederken dikkat edin.
		for(int i = 0; i < ings.length(); i++) { 
			
			if(i == ings.length() - 1) { 
				Ingredient currentIng = new Ingredient (ings.substring(currentFirst, i + 1)); 
				ingsSeperated.add(currentIng);
			}
			
			if(ings.charAt(i) == ' ') {
				Ingredient currentIng = new Ingredient (ings.substring(currentFirst, i)); 
				i++;
				currentFirst = i;
				ingsSeperated.add(currentIng);
			}
		}
		
		return ingsSeperated;
	}
}
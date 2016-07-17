package dataManagement;

import java.util.ArrayList;

import restaurantAndFoodManagement.Ingredient;


public class OtherIngProcessor {

	private String otherBuffer;
	
	public OtherIngProcessor(String ings) {
		otherBuffer = ings;
	}
	
	public ArrayList<Ingredient> insertToPending(String ings) {
		ArrayList<Ingredient> ingsSeperated = new ArrayList<Ingredient> ();
		int currentFirst = 0;
		
		for(int i = 0; i < ings.length(); i++) { // Test ettim, düzgün çalışıyor 
			
			// Son ingredient tespiti, aslında burayı -2 değil de -1 ile, aşağıyı da i+1 ile değil de i ile yapmak istedim ama hata verdi.
			if(i == ings.length() - 2) {  
				Ingredient currentIng = new Ingredient (ings.substring(currentFirst, i + 1)); 
				i++;
				currentFirst = i;
				ingsSeperated.add(currentIng);
			}
			
			if(ings.charAt(i) == ' ') {
				Ingredient currentIng = new Ingredient (ings.substring(currentFirst, i)); 
				i++;
				currentFirst = i;
				ingsSeperated.add(currentIng);
			}
		}
		
		return ingsSeperated; // Bu return hiç gerekli olmuyor 
	}
}
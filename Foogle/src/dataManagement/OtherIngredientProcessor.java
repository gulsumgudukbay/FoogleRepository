package dataManagement;

import java.util.ArrayList;
import java.util.StringTokenizer;

import restaurantAndFoodManagement.Ingredient;


public class OtherIngredientProcessor {

	private StringTokenizer st;
	public static void main(String[] args){
		OtherIngredientProcessor oip = new OtherIngredientProcessor();
		ArrayList<Ingredient> arr= oip.insertToPending("cilek sut misir");
		System.out.println(arr.toString());
	}
	
	public ArrayList<Ingredient> insertToPending(String ings) {
		ArrayList<Ingredient> ingsSeperated = new ArrayList<Ingredient> ();
			
		st = new StringTokenizer(ings, " ");
		while(st.hasMoreTokens()){
			ingsSeperated.add(new Ingredient(st.nextToken()));
		}
			
		return ingsSeperated;
	}
}
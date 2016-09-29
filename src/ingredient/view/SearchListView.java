package ingredient.view;

import java.util.ArrayList;

import ingredient.vo.Ingredient;

public class SearchListView {



	public SearchListView() {

	}


	public void SearchListView(ArrayList<Ingredient> ingredientList) {

		System.out.println("번호\t원재료명\t원가\t적재량\t최대적재량\t단위");
		System.out.println("-------------------------------------------------------");

		for(int i = 0; i < ingredientList.size(); i++) {

			System.out.print(ingredientList.get(i).getIngredient_Number() + "\t");
			System.out.print(ingredientList.get(i).getIngredient_Name() + "\t");
			System.out.print(ingredientList.get(i).getIngredient_Price() + "\t");
			System.out.print(ingredientList.get(i).getIngreient_Inventory() + "\t");
			System.out.print(ingredientList.get(i).getIngredient_Inventory_MAX() + "\t");
			System.out.println(ingredientList.get(i).getIngredient_unit());

		}
		
		System.out.println("-------------------------------------------------------");
	}
}
package ingredient.view;

import java.util.ArrayList;

import ingredient.vo.Ingredient;
import mainController.MainController;
import mainView.AlertView;

public class SearchListView {



	public SearchListView() {

	}


	public void SearchList(ArrayList<Ingredient> ingredientList) {

		System.out.println("[번호]\t[원재료명]\t[원가]\t[적재량]\t[최대적재량]\t[단위]");
		System.out.println("-------------------------------------------------------");

		if(ingredientList.size() == 0) {
			
			new AlertView().alert("찾으시는 제품이 없습니다.");
			MainController.getIngredientController().requestIngredientMainMenu();
			
		} else {
			
			for(int i = 0; i < ingredientList.size(); i++) {
				
				System.out.print(ingredientList.get(i).getIngredient_Number() + "\t");
				System.out.print(ingredientList.get(i).getIngredient_Name() + "\t");
				System.out.print(ingredientList.get(i).getIngredient_Price() + "\t");
				System.out.print(ingredientList.get(i).getIngreient_Inventory() + "\t");
				System.out.print(ingredientList.get(i).getIngredient_Inventory_MAX() + "\t\t");
				System.out.println(ingredientList.get(i).getIngredient_unit());
				
			}
		}
		
		
		System.out.println("-------------------------------------------------------");
	}
}
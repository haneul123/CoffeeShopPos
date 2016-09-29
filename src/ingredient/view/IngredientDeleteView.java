package ingredient.view;

import java.util.Scanner;

import ingredient.vo.Ingredient;
import mainView.AlertView;

public class IngredientDeleteView {

	private Scanner keyboard;
	
	public IngredientDeleteView() {
		
		keyboard = new Scanner(System.in);
	}

	public Ingredient deleteIngredient() {
		
		new AlertView().alert("[원재료 삭제 모드]");
		System.out.print("삭제할 제품 이름 입력 : ");
		String deleteIngredientName = keyboard.next();
		
		Ingredient deleteIngredientGetNmae = new Ingredient(deleteIngredientName);
		
		return deleteIngredientGetNmae;
		
	}
	
	public int deleteIngredientNum() {
		
		System.out.print("삭제 제품번호 입력 : ");
		
		int deleteIngredientGetNum = keyboard.nextInt();
		
		return deleteIngredientGetNum;
	}
	
	
}

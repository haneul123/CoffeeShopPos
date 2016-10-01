package ingredient.view;

import java.util.Scanner;

import mainController.MainController;

public class IngredientDeleteView {

	private Scanner keyboard;

	public IngredientDeleteView() {

		keyboard = new Scanner(System.in);
	}


	public void deleteIngredientNum() {

		System.out.print("삭제 제품번호 입력 : ");

		int deleteIngredientGetNum = keyboard.nextInt();

		MainController.getIngredientController().requestDeleteIngredient(deleteIngredientGetNum);

	}


}

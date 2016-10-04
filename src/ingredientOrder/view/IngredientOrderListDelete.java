package ingredientOrder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class IngredientOrderListDelete {

	private Scanner keyboard;

	public IngredientOrderListDelete() { 

		this.keyboard = new Scanner(System.in);

	}


	//주문리스트 삭제 뷰
	public void ingredientOrderListDelete() {

		int selectedingredientOrderNumber = 0;

		try{

			System.out.println("삭제할 번호를 입력하세요.");

			try{

				selectedingredientOrderNumber = keyboard.nextInt();

			} catch(InputMismatchException e) {

				System.out.println("숫자를 입력해 주세요");

				MainController.getProductController().requestDeleteProductNumber();
			}

			MainController.getIngredientOrderController().requestOrderIngredientDelete(selectedingredientOrderNumber);

		}catch (InputMismatchException e) {

			System.out.println("잘못입력 하셨습니다.");
		}
	}
}



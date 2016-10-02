package ingredientPayment.view;

import java.util.Scanner;

import mainController.MainController;

public class IngredientPaymentView {
	
	// variable
	private Scanner keyboard;

	// constructor
	public IngredientPaymentView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	
	//결제 받기 뷰
	public void ingredientOrderPay() {

		System.out.println("결제 하시겠습니다?");
		System.out.println("[1]결제  [2]취소");
		int seletedMenu = keyboard.nextInt();

		if(seletedMenu == 1){

			System.out.println("결제가 완료 되었습니다.");
			MainController.getIngredientPaymentController().requestIngredientPayment();
			
		} else {

			System.out.println("결제가 취소되었습니다.");
			System.out.println("메인메뉴로 돌아갑니다.");
			
		}
	}
}

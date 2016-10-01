package ingredientPayment.view;

import java.util.Scanner;

public class IngredientPaymentView {
	
	private Scanner keyboard;


	public IngredientPaymentView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	
	//결제 받기 뷰
	public void ingredientOrderPay() {

		System.out.println("결제 하시겠습니다?");
		System.out.println("[1]결제  [2]취소");
		int seletedMenu = keyboard.nextInt();

		if(seletedMenu == 1){

			System.out.println("결제가 완료 되었슴니다.");
		}else {

			System.out.println("결제가 취소되었습니다.");
			System.out.println("메인메뉴로 돌아갑니다.");
			
		}
	}
}

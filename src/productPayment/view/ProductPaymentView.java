package productPayment.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class ProductPaymentView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public ProductPaymentView() {

		this.keyboard = new Scanner(System.in);
		
	}
	
	// 주문된 상품을 결제할 것인지 확인받음
	public void productPaymentView() {
			
		int selectedMenu = 0;
		
		System.out.println("해당 상품들을 결제하시겠습니까?");
		System.out.println("1. 결제하기  2. 결제 취소하기");
		
		try{
			selectedMenu = keyboard.nextInt();	
		} catch(InputMismatchException e) {
			System.out.println("숫자 1과 2중 하나를 선택하여 주십시오");
		}
		
		if(selectedMenu == 1){
			
			MainController.getProductPaymentController().requestSelectPaymentMethodView();
			
		} else if(selectedMenu == 2){
			
			System.out.println("정말 취소하시겠습니까? 취소하시면 주문부터 다시 실행하셔야 합니다. <y / n>");
			char yesOrNo = keyboard.next().charAt(0);
			if(yesOrNo == 'y'){
				
				MainController.getProductPaymentController().requestProductPaymentDelete();
				
			} else if(yesOrNo == 'n'){
				
				MainController.getProductOrderController().requestProductOrderMainMenuView();
				
			} else {
				
				System.out.println("잘못 선택하셨습니다");
				
			}
			
		} else {
			
			System.out.println("1번과 2번중 하나를 입력하여 주십시오");
			
		}
			
	}

}

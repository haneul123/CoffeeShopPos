package productPayment.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class SelectPaymentMethodView {

	
	// variable
	private Scanner keyboard;
	
	
	// constructor
	public SelectPaymentMethodView() {

		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// 결제 방법 선택
	public void selectPaymentMethodView() {
	
		int paymentMethod = 0;
		
		System.out.println("결제방법을 선택하십시오");
		System.out.println("1. 카드로 결제  2. 현금으로 결제");
		try{
			paymentMethod = keyboard.nextInt();	
		} catch(InputMismatchException e) {
			System.out.println("숫자로 입력하셔야 합니다");
		}
		
		if(paymentMethod == 1){
			
			System.out.println("카드 결제를 신청하셨습니다");
			
		} else if(paymentMethod == 2){
			
			System.out.println("현금 결제를 신청하셨습니다");
			
		} else {
			
			System.out.println("선택하신 숫자는 없는 번호입니다");
			
		}
		
		MainController.getProductPaymentController().requestInsertProductPayment(paymentMethod);
		
	}
	
}

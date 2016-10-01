package productOrder.view;

import java.util.Scanner;

import mainController.MainController;

public class CheckUserPhoneNumberView {
	
	
	// variable
	private Scanner keyboard;
	
	
	// constructor
	public CheckUserPhoneNumberView() {
		
		this.keyboard = new Scanner(System.in);
		
	} 
	
	
	// 주문한 회원의 전화번호 받기
	public void checkUserPhoneNumberView(){

		System.out.println("상품 주문 메뉴 입니다");
		System.out.println("주문한 회원의 전화번호를 입력하십시오");
		String userPhoneNumber = keyboard.next();
		MainController.getProductOrderController().requestCheckUser(userPhoneNumber);

	}


}

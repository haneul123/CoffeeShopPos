package productOrder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class ChoiceGuestOrMember {

	
	// variable
	private Scanner keyboard;
	
	
	// constructor
	public ChoiceGuestOrMember() {
	
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	// 비회원으로 주문할지 회원으로 주문할지 결정
	public void choiceGuestOrMember(int userNumber) {
	
		int selectedMenu = 0;
		
		System.out.println("입력하신 번호는 없는 번호 입니다");
		System.out.println("원하시는 메뉴를 선택하여 주십시오");
		System.out.println("[1] 비회원 주문하기  [2] 회원 가입하기");
		
		try{
			selectedMenu = keyboard.nextInt();	
		} catch(InputMismatchException e) {
			System.out.println("잘못입력하셨습니다. 1 혹은 2를 입력해 주십시오");
			choiceGuestOrMember(0);
		}
		
		if(selectedMenu == 1){
			
			MainController.getProductOrderController().requestProductOrderView(userNumber);
			
		} else if(selectedMenu == 2){
			
			MainController.getUserController().requestUserSignUpView();
			
		} else {
			
			System.out.println("없는 번호입니다. 다시 입력해 주십시오.");
			
		}
		
	}

}

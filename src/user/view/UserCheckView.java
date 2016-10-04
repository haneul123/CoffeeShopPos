package user.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class UserCheckView {
	
	// variable
	private Scanner keyboard;
	
	// constructor
	public UserCheckView() {
	
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// method
	// 수정할 회원번호 입력
	public void selectUpdateUserNumber() {

		int selectedNumber = 0;

		System.out.println("업데이트 할 회원 번호를 입력하십시오");
		try{
			selectedNumber = keyboard.nextInt();
		} catch(InputMismatchException e) {	
			System.out.println("번호를 입력해 주십시오");
		}	

		MainController.getUserController().requestCheckUser(selectedNumber, 1);

	}

	// 삭제할 회원번호 입력
	public void selectDeleteUserNumber(){
		
		int selectedNumber = 0;	
		System.out.println("삭제 할 회원 번호를 입력하십시오");
		
		try{
			selectedNumber = keyboard.nextInt();
		} catch(InputMismatchException e) {	
			System.out.println("번호를 입력해 주십시오");
		}	

		MainController.getUserController().requestCheckUser(selectedNumber, 2);
		
	}
	
	
	
}

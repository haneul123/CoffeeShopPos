package user.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;
import user.vo.User;

public class UserUpdateView {


	// variable
	private Scanner keyboard;


	// constructor
	public UserUpdateView() {

		this.keyboard = new Scanner(System.in);

	}


	// method
	// 수정할 회원번호 입력
	public void selectUserNumber() {

		int selectedNumber = 0;

		System.out.println("업데이트 할 회원 번호를 입력하십시오");
		try{
			selectedNumber = keyboard.nextInt();
		} catch(InputMismatchException e) {	
			System.out.println("번호를 입력해 주십시오");
		}	
		
		MainController.getUserController().requestCheckUser(selectedNumber);

	}


	// 회원 업데이트 정보 받기
	public void userUpdateView(int selectedNumber){

		System.out.println("수정하실 유저 휴대폰 번호를 입력하십시오");
		String userPhoneNumber = keyboard.next();
		
		User updateUser = new User(selectedNumber, userPhoneNumber);
		MainController.getUserController().requestUserUpdate(updateUser);

	}

}

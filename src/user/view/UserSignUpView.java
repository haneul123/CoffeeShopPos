package user.view;

import java.util.Scanner;

import mainController.MainController;
import user.vo.User;

public class UserSignUpView {

	
	// variable
	private Scanner keyboard;
	
	
	// constructor
	public UserSignUpView() {
	
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// method
	// 회원 가입을 위한 정보 받기
	public void userSignUpView() {

		System.out.println("회원가입을 위해서는 휴대폰 번호만 입력하시면 됩니다");
		System.out.println("휴대폰 번호를 입력하세요 >");
		String userPhoneNumber = keyboard.next();
		User newUser = new User(userPhoneNumber);
		MainController.getUserController().requestUserSignUp(newUser);
		
	}

}

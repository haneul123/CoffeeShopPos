package login.view;

import java.util.Scanner;

import admin.vo.Admin;
import mainController.MainController;

public class LoginView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public LoginView() {
	
		this.keyboard = new Scanner(System.in);
		
	}


	// 로그인 정보 입력 창 출력
	public void loginView() {
			
		System.out.println("관리자 로그인 창입니다");
		
		System.out.println("관리자 아이디를 입력하십시오");
		String adminId = keyboard.next();
		
		System.out.println("관리자 비밀번호를 입력하십시오");
		String adminPassword = keyboard.next();
		
		Admin admin = new Admin(adminId, adminPassword);
		
		MainController.getLoginController().requestLogin(admin);
		
	}

}

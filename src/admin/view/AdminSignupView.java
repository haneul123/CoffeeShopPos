package admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import admin.vo.Admin;
import mainController.MainController;

public class AdminSignupView {

	// variable
	private Scanner keyboard;

	// constructor
	public AdminSignupView() {

		this.keyboard = new Scanner(System.in);

	}


	// 관리자 회원가입 정보 받음
	public void adminSignupView() {

		String adminId = null;
		String adminPassword = null;
		String adminName = null;
		int authority = 0;

		System.out.println("관리자 아이디를 입력하세요");
		adminId = keyboard.next();	

		System.out.println("관리자 비밀번호를 입력하세요");
		adminPassword = keyboard.next();
	
		System.out.println("관리자 이름을 입력하세요");
		adminName = keyboard.next();	

		System.out.println("관리자 권한번호를 입력하세요 (1 = 점장, 2 = 직원)");
		try{
			authority = keyboard.nextInt();	
		} catch(InputMismatchException e){
			System.out.println("잘못입력하셨습니다. 다시 입력해주시기 바랍니다");
			adminSignupView();
		}

		Admin newAdmin = new Admin(adminId, adminPassword, adminName, authority);
		MainController.getAdminController().requestSignUp(newAdmin);

	}

}

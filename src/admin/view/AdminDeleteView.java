package admin.view;

import java.util.Scanner;

import mainController.MainController;

public class AdminDeleteView {
	
	
	// variable
	private Scanner keyboard;

	
	// constructor
	public AdminDeleteView() {

		this.keyboard = new Scanner(System.in);

	}

	
	// 수정할 관리자 번호 입력 받기
	public void adminNumberView(){

		System.out.println("관리자 삭제 페이지 입니다");
		System.out.println("수정을 원하시는 관리자 번호를 선택해 주십시오");
		int selectedAdmin = keyboard.nextInt();
		MainController.getAdminController().requestCheckAdmin(selectedAdmin);

	}
	
}

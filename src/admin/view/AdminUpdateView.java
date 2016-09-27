package admin.view;

import java.util.Scanner;

import mainView.AlertView;

public class AdminUpdateView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public AdminUpdateView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// 관리자 수정 정보 입력 받기
	public void adminUpdateView() {
		
		System.out.println("관리자 수정 페이지 입니다");
		System.out.println("수정을 원하시는 관리자 메뉴를 선택해 주십시오");
		int selectedAdmin = keyboard.nextInt();
		
		
		
	}

}

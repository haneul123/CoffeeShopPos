package admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class StaffMainMenu {

	// variable
	private Scanner keyboard;

	// constructor
	public StaffMainMenu() {

		this.keyboard = new Scanner(System.in);

	}


	// 스태프 메인 메뉴 
	public void staffMainMenu(){

		int selectedMenu = 0;
		System.out.println("직원 메뉴 입니다");

		String[] mainMenu = {"1. 상품조회, 2. 재고조회, 3. 회원등록, 4. 회원조회, 5. 로그아웃"};

		// 메인메뉴 출력
		for(int i=0; i<mainMenu.length; i++){
			System.out.println(mainMenu[i]);
		}

		while(true){

			try{

				System.out.println("원하시는 메뉴를 선택하십시오");
				selectedMenu = keyboard.nextInt();

			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 메뉴 번호를 입력해주세요");
				MainController.getAdminController().requestMainMenuViewStaff();
			}

			if(selectedMenu == 1) {

				// 상품조회
				MainController.getProductController().requestProductlist();

			} else if (selectedMenu == 2) {

				// 재고조회

			} else if (selectedMenu == 3) {

				// 회원등록

			} else if (selectedMenu == 4) {

				// 회원조회

			} else if (selectedMenu == 5) {

				// 로그아웃
				MainController.getAdminController().requestAdminManagementView();

			} else {

				System.out.println("없는 메뉴입니다. 다시 입력해주세요");

			}
		}
	}
}

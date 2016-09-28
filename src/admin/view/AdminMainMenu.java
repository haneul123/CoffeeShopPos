package admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class AdminMainMenu {

	// variable
	private Scanner keyboard;


	// constructor
	public AdminMainMenu() {

		this.keyboard = new Scanner(System.in);

	}


	// 관리자 메인 메뉴 출력
	public void adminMainMenu(){

		System.out.println("관리자 메인 메뉴 입니다");

		String[] mainMenu = {"1. 상품관리, 2. 재고관리, 3. 매출관리, 4. 회원관리, 5. 직원관리, 6. 로그아웃"};

		// 메인메뉴 출력
		for(int i=0; i<mainMenu.length; i++){
			System.out.println(mainMenu[i]);
		}

		while(true){
			
			try{
				
				System.out.println("원하시는 메뉴를 선택하십시오");
				int selectedMenu = keyboard.nextInt();
				
				if(selectedMenu == 1) {

					// 상품관리 메뉴 출력
					MainController.getProductController().requestProductMainMenu();

				} else if (selectedMenu == 2) {

					// 재고관리 메뉴 출력
					MainController.getIngredientController().requestIngredient();

				} else if (selectedMenu == 3) {

					// 메출관리 메뉴 출력
					// MainController ???

				} else if (selectedMenu == 4) {

					// 회원관리 메뉴 출력
					// MainController.getUserController().requestMainMenuView();

				} else if (selectedMenu == 5) {

					// 직원관리 메뉴 출력
					MainController.getAdminController().requestAdminManagementView();

				} else if (selectedMenu == 6){

					MainController.getLoginController().requestLogout();

				} else {

					System.out.println("없는 메뉴입니다. 다시 입력해주세요");

				}

			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 메뉴 번호를 입력해주세요");
				MainController.getAdminController().requestMainMenuView();
			}
			
		}
	}

}

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

		while(true){


				int selectedMenu = 0;
				System.out.println("관리자 메인 메뉴 입니다");
				String[] mainMenu = {"1. 상품관리, 2. 주문관리, 3. 재고관리, 4. 재무관리, 5. 회원관리, 6. 직원관리, 7. 로그아웃"};

				// 메인메뉴 출력
				for(int i=0; i<mainMenu.length; i++){
					System.out.println(mainMenu[i]);
				}

				try{

					System.out.println("원하시는 메뉴를 선택하십시오");
					selectedMenu = keyboard.nextInt();

				} catch(InputMismatchException e) {
					System.out.println("잘못 입력하셨습니다. 메뉴 번호를 입력해주세요");
					MainController.getAdminController().requestMainMenuView();
				}

				if(selectedMenu == 1) {

					// 상품관리 메뉴 출력
					MainController.getProductController().requestProductMainMenu();

				} else if (selectedMenu == 2){

					// 주문관리 메뉴 출력
					MainController.getProductOrderController().requestProductOrderMainMenuView();

				} else if (selectedMenu == 3) {

					// 재고관리 메뉴 출력
					MainController.getIngredientController().requestIngredientMainMenu();

				} else if (selectedMenu == 4) {

					// 재무관리 메뉴 출력
					MainController.getSalesManagementController().requestSalesManagementMenu();

				} else if (selectedMenu == 5) {

					// 회원관리 메뉴 출력
					MainController.getUserController().requestUserManagementView();

				} else if (selectedMenu == 6) {

					// 직원관리 메뉴 출력
					MainController.getAdminController().requestAdminManagementView();

				} else if (selectedMenu == 7){

					// 로그 아웃
					MainController.getLoginController().requestLogout();

				} else {

					System.out.println("없는 메뉴입니다. 다시 입력해주세요");
					break;

				}
			}
		}
	}


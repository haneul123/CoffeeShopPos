package admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class AdminManagementView {

	// variable
	private Scanner keyboard;

	// constructor
	public AdminManagementView() {

		this.keyboard = new Scanner(System.in);

	}


	// 직원 관리 메뉴 뷰
	public void adminManagemnetView() {

		int selectedMenu = 0;
		
		while(true){

			System.out.println("직원관리 메뉴입니다");

			String[] mgmMenu = {"1. 직원 계정 등록", "2. 직원 리스트 보기", "3. 직원 계정 수정", "4. 직원 계정 삭제", "5. 급여 관리", "6. 나가기"};

			for(int i=0; i<mgmMenu.length; i++){
				System.out.println(mgmMenu[i]);
			}

			try{

				selectedMenu = keyboard.nextInt();
				
			} catch(InputMismatchException e){

				System.out.println("잘못입력하셨습니다. 메뉴번호를 입력해 주십시오");
				MainController.getAdminController().requestMainMenuView();

			}

			if(selectedMenu == 1){

				MainController.getAdminController().requestSignUpInfo();

			} else if(selectedMenu == 2) {

				MainController.getAdminController().requestListView();

			} else if(selectedMenu == 3) {

				MainController.getAdminController().requestUpdateView();

			} else if(selectedMenu == 4) {

				MainController.getAdminController().requestDelete();

			} else if(selectedMenu == 5){
				
				MainController.getAdminController().requestManagementSalary();
				
			} else if(selectedMenu == 6){

				break;

			} else {

				System.out.println("잘못 입력하셨습니다");

			}
		}
	}
}

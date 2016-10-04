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

			System.out.println("[1]직원 계정 등록, [2]직원 리스트 보기, [3]직원 출퇴근 조회, [4]직원 계정 수정, [5]직원 계정 삭제, [6]급여 관리, [7]나가기");

		
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

				MainController.getAdminController().adminCommuteSearchView();

			} else if(selectedMenu == 4) {

				MainController.getAdminController().requestUpdateView();

			} else if(selectedMenu == 5) {

				MainController.getAdminController().requestDelete();

			} else if(selectedMenu == 6){
				
				MainController.getAdminSalaryController().requestAdminSalaryMenuView();
				
			} else if(selectedMenu == 7){

				MainController.getAdminController().requestMainMenuView();

			} else {

				System.out.println("잘못 입력하셨습니다");

			}
		}
	}
}

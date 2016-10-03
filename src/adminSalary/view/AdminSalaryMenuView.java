package adminSalary.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class AdminSalaryMenuView {


	// variable
	private Scanner keyboard;


	// constructor
	public AdminSalaryMenuView() {

		this.keyboard = new Scanner(System.in);

	}


	// 관리자 메인 메뉴 출력
	public void adminSalaryMainMenu(){

		while(true){


			int selectedMenu = 0;
			System.out.println("급여관리 메인 메뉴 입니다");
			System.out.println("[1]급여조회  [2]급여지급 목록  [3]급여지급  [4]이전");

		
			try{

				System.out.println("원하시는 메뉴를 선택하십시오");
				selectedMenu = keyboard.nextInt();

			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 메뉴 번호를 입력해주세요");
				MainController.getAdminController().requestMainMenuView();
			}

			if(selectedMenu == 1) {

				// 급여조회 메뉴 출력
				MainController.getAdminSalaryController().requestSalarySearchView();

			} else if (selectedMenu == 2){

				//급여지급 목록 메뉴 출력
				MainController.getAdminSalaryController().requestSalaryList();

			} else if (selectedMenu == 3) {

				// 급여지급 메뉴 출력
				MainController.getAdminSalaryController().requestSalary();

			} else if (selectedMenu == 4) {

				// 이전 메뉴로
				MainController.getAdminController().requestAdminManagementView();

			} else {

				System.out.println("없는 메뉴입니다. 다시 입력해주세요");
				break;

			}
		}
	}

}

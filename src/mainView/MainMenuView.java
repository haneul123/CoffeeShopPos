package mainView;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class MainMenuView {

	private Scanner keyboard;


	//구조
	public MainMenuView() {

		this.keyboard = new Scanner(System.in);

	}


	//메인메뉴
	public void mainMenuView() {
		
		int selectedMenu = 0;
				
		while(true){
			
			System.out.println("	   SmartCoffeeFos		");
			System.out.println("	   관리자 정보가 필요한 시스템 입니다.");
			System.out.println("	접근 가능한 계정 정보를 입력하시기 바랍니다.");
			System.out.println("------------------------------------------");
			System.out.println("	 [안내]:메뉴를 선택해 주세요.");
			System.out.println("[1] 관리자 로그인   [2] 관리자 등록  [3] 프로그램 종료");

			try{
				selectedMenu = keyboard.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("메뉴 번호를 입력해 주시기 바랍니다");
				MainController.mainMenuView();
			}
		
			if(selectedMenu == 1) {

				MainController.getLoginController().requestLoginInfo();

			} else if(selectedMenu == 2) {

				MainController.getAdminController().requestSignUpInfo();

			} else if(selectedMenu == 3){

				MainController.getDbController().requestExitProgram();

			} else {

				System.out.println("메뉴를 잘못 선택하셨습니다.");

			}
		}
	}
}

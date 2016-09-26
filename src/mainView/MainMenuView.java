package mainView;

import java.util.Scanner;

public class MainMenuView {
	
	private Scanner keyboard;
	
	
	//구조
	public MainMenuView() {
		
		this.keyboard = new Scanner(System.in);
		
	}

	
	//메인메뉴
	public void mainMenuView() {
		
		System.out.println("	   SmartCoffeeFos		");
		System.out.println("	   관리자 정보가 필요한 시스템 입니다.");
		System.out.println("	접근 가능한 계정 정보를 입력하시기 바랍니다.");
		System.out.println("------------------------------------------");
		System.out.println("	 [안내]:메뉴를 선택해 주세요.");
		System.out.println("	[1]관리자 로그인   [2]관리자 등록");
		
		int selectedMenu = keyboard.nextInt();
		
		if(selectedMenu == 1) {
			
			
			
		} else if(selectedMenu == 2) {
			
			
			
		} else {
			
			System.out.println("메뉴를 잘못 선택하셨습니다.");
			
		}
	}
	
}

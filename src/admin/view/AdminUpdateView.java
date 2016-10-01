package admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import admin.vo.Admin;
import mainController.MainController;

public class AdminUpdateView {

	// variable
	private Scanner keyboard;

	// constructor
	public AdminUpdateView() {

		this.keyboard = new Scanner(System.in);

	}

	// 수정할 관리자 번호 입력 받기
	public void adminNumberView(){

		int selectedAdmin = 0;
		System.out.println("관리자 수정 페이지 입니다");
		System.out.println("수정을 원하시는 관리자 번호를 선택해 주십시오");
		try{
			selectedAdmin = keyboard.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못입력하셨습니다");
		}

		MainController.getAdminController().requestCheckAdmin(selectedAdmin);

	}


	// 관리자 수정 정보 입력 받기
	public void adminUpdateView(int selectedAdmin) {

		String adminPassword = null;
		String adminName = null;
		int selectedMenu = 0;
		int authority = 0;

		while(true){

			System.out.println("수정을 원하시는 메뉴를 선택하여 주십시오");
			System.out.println("1. 관리자 비밀번호  2. 관리자 이름  3. 관리자 권한  4. 나가기");

			try{
				selectedMenu = keyboard.nextInt();	
			} catch(InputMismatchException e){
				System.out.println("잘못 입력하셨습니다");
			}

			if(selectedMenu == 1) {

				System.out.println("수정할 비밀번호를 입력하십시오");
				adminPassword = keyboard.next();

			} else if(selectedMenu == 2) {

				System.out.println("수정할 이름을 입력하십시오");
				adminName = keyboard.next();

			} else if(selectedMenu == 3) {

				System.out.println("수정할 권한을 입력하십시오 (단, 1은 점장, 2는 직원입니다)");
				try{
					authority = keyboard.nextInt();	
				} catch(InputMismatchException e){
					System.out.println("잘못 입력하셨습니다");
				}

			} else if(selectedMenu == 4){

				break;

			} else {

				System.out.println("잘못 입력하셨습니다.");

			}

			Admin updatedAdmin = new Admin(selectedAdmin, adminPassword, adminName, authority);
			MainController.getAdminController().requestUpdate(updatedAdmin);

		}
	}

}


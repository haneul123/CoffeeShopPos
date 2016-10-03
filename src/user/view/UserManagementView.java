package user.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class UserManagementView {

	// variable
	private Scanner keyboard;


	// constructor
	public UserManagementView() {

		this.keyboard = new Scanner(System.in);

	}


	// method
	public void userManagementView() {

		int selectedMenu = 0;
		while(true){
			System.out.println("회원관리 모드입니다.");
			System.out.println("원하시는 모드를 선택하세요");
			System.out.println("[1] 회원가입   [2] 회원리스트 보기   [3] 회원 정보 수정   [4] 회원 정보 삭제   [5] 나가기");

			try{
				selectedMenu = keyboard.nextInt();	
			} catch(InputMismatchException e) {
				System.out.println("메뉴는 번호로 입력해 주시기 바랍니다.");
				userManagementView();
			}

			if(selectedMenu == 1){

				// 회원 가입 요청
				MainController.getUserController().requestUserSignUpView();
				
			} else if(selectedMenu == 2){

				// 회원리스트 요청
				MainController.getUserController().requestUserList();

			} else if(selectedMenu == 3){

				// 회원 정보 수정 뷰 요청
				MainController.getUserController().requestUserUpdateView();

			} else if (selectedMenu == 4){

				// 회원 정보 삭제 뷰 요청
				MainController.getUserController().requestUserDeleteView();

			} else if (selectedMenu == 5){
				
				break;
				
			} else {

				System.out.println("선택하시는 메뉴번호는 없는 번호입니다. 다시 확인해 주시기 바랍니다");
			}
		}
	}
}

package salesManagement.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class SalesManagementMenuView {

	
	// variable
	private Scanner keyboard;
	
	
	// constructor
	public SalesManagementMenuView() {
	
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// 매출관리 메뉴 뷰 출력
	public void salesManagementMenuView() {

		int selectedMenu = 0;
		
		while(true){
			
			System.out.println("원하시는 메뉴를 선택해 주십시오");
			System.out.println("1. 매출 통계 보기, 2. 손익 분기점 계산, 3. 부가가치세 계산, 4. 사업소득세 계산, 5. 예상 매출 계산, 6. 나가기");
			
			try{
				selectedMenu = keyboard.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("메뉴 번호를 입력해 주십시오");
			}
			
			if(selectedMenu == 1) {
				
				MainController.getSalesManagementController().requestSalesStatsView();
				
			} else if(selectedMenu == 2) {
				
				MainController.getSalesManagementController().requestBEPView();
				
			} else if(selectedMenu == 3) {
				
				MainController.getSalesManagementController().requestVATView();
				
			} else if(selectedMenu == 4) {
				
				MainController.getSalesManagementController().requestBizTaxView();
				
			} else if(selectedMenu == 5) {
				
				MainController.getSalesManagementController().requestExpectedSalesView();
				
			} else if(selectedMenu == 6) {
				
				break;
				
			} else {
				
				System.out.println("잘못 입력하셨습니다");
				
			}	
		}	
	}
}

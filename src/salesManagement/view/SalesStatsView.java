package salesManagement.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class SalesStatsView {

	
	// variable
	private Scanner keyboard;
	
	
	// constructor
	public SalesStatsView() {

		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// method
	// 매출 통계 뷰
	public void salesStatsView() {
		
		int selectedMenu = 0;
		
		while(true){
			
			System.out.println("원하시는 매출 통계 메뉴를 선택하십시오");
			System.out.println("1. 일별매출, 2. 월별매출, 3. 반기별매출, 4. 연매출, 5. 나가기");
			
			try{
				selectedMenu = keyboard.nextInt();	
			} catch(InputMismatchException e){
				System.out.println("메뉴 번호를 입력하여 주십시오");
				MainController.getSalesManagementController().requestSalesStatsView();
			}
			
			if(selectedMenu == 1){
				
				// 일별 매출 뷰 요청
				MainController.getSalesManagementController().requestDailyStatsView();
				
			} else if(selectedMenu == 2){
				
				// 월별 매출 뷰 요청
				MainController.getSalesManagementController().requestMonthlyStatsView();
				
			} else if(selectedMenu == 3){
				
				// 반기별 매출 뷰 요청
				MainController.getSalesManagementController().requestSemiAnnualStatsView();
				
			} else if(selectedMenu == 4){
				
				// 연 매출 뷰 요청
				MainController.getSalesManagementController().requestAnnualStatsView();
				
			} else if(selectedMenu == 5){
				
				break;
				
			} else {
				
				System.out.println("없는 번호입니다. 재입력바랍니다");
				
			}
			
		}	
	}
}

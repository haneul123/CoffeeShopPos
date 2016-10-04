package adminSalary.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class ManagementSalary {

	// variable
	private Scanner keyboard;
	
	// constructor
	public ManagementSalary() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// 급여 지급 뷰
	public void managementSalary() {
		
		int selectedMenu = 0;
		int adminNumber = 0;
		int salary = 0;
		
		while(true){
			
			System.out.println("[1] 급여 지급  [2] 나가기");
			
			try{
				selectedMenu = keyboard.nextInt();	
			} catch(InputMismatchException e){
				System.out.println("잘못 입력하셨습니다");
				MainController.getAdminController().requestAdminManagementView();
			}
			
			if(selectedMenu == 1){
				
				System.out.println("급여를 지급할 직원 번호를 입력하세요");
				try{
					adminNumber = keyboard.nextInt();	
				} catch(InputMismatchException e){
					System.out.println("잘못 입력하셨습니다");
				}
				
				System.out.println("급여액을 입력하세요");
				
				try{
					salary = keyboard.nextInt();	
				} catch(InputMismatchException e){
					System.out.println("잘못 입력하셨습니다");
				}
				
				MainController.getAdminSalaryController().requestInputSalary(adminNumber, salary);
				
			} else if(selectedMenu == 2){
				
				break;
				
			}		
		}
	}
}

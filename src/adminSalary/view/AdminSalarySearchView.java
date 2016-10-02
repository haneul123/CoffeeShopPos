package adminSalary.view;

import java.util.Scanner;

import adminSalary.vo.AdminSalary;
import mainController.MainController;

public class AdminSalarySearchView {
	
	private Scanner keyboard;
	
	
	public AdminSalarySearchView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	
	public void adminSalarySearchView(){
		
		
		System.out.println("급여조회 검색 모드 입니다.");
		System.out.println("찾으시는 관리자의 이름을 입력 하세요.");
		System.out.print("관리자 명 : ");
		String searchName = keyboard.next();
		
		AdminSalary salarySearch = new AdminSalary(searchName);
		MainController.getAdminSalaryController().requestSalarySearch(salarySearch);
		

		
	}
	

}

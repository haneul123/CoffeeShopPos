package adminSalary.view;

import java.util.ArrayList;

import admin.vo.Admin;
import adminSalary.vo.AdminSalary;
import mainController.MainController;

public class AdminSalaryList {
	
	
	public AdminSalaryList() {

	}


	public void adminSalarylist( ArrayList<AdminSalary> adminSalaryLists) {

		System.out.println("번호\t관리자 이름\t급여지급액\t급여 지급 날짜");
		System.out.println("-------------------------------------------------------");

		if(adminSalaryLists.size() == 0) {
			
			MainController.getAdminController().requestAdminManagementView();
			
		} else {
			
			for(int i = 0; i < adminSalaryLists.size(); i++) {
				
				System.out.print(adminSalaryLists.get(i).getSalaryNumber() + "\t");
				System.out.print(adminSalaryLists.get(i).getAdminName() + "\t");
				System.out.print(adminSalaryLists.get(i).getSalary() + "\t");
				System.out.println(adminSalaryLists.get(i).getSalaryDate());
			
			}
		}
		
		System.out.println("-------------------------------------------------------");
	}

}

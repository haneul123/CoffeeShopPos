package adminSalary.controller;

import java.util.ArrayList;

import adminSalary.dao.AdminSalaryDao;
import adminSalary.view.AdminSalaryList;
import adminSalary.view.AdminSalaryMenuView;
import adminSalary.view.AdminSalarySearchView;
import adminSalary.view.ManagementSalary;
import adminSalary.vo.AdminSalary;
import mainView.AlertView;

public class AdminSalaryController {

	private AdminSalaryDao adminSalayDao;


	// constructor
	public AdminSalaryController() {

		this.adminSalayDao = new AdminSalaryDao();

	}


	// 급여 메뉴 관리 뷰호출
	public void requestAdminSalaryMenuView() {

		AdminSalaryMenuView adminSalaryMenuView = new AdminSalaryMenuView();
		adminSalaryMenuView.adminSalaryMainMenu();

	}


	// 급여지급 메뉴 관리 
	public void requestSalary() {

		ManagementSalary managementSalary = new ManagementSalary();
		managementSalary.managementSalary();

	}

	
	// 급여 데이터 입력
	public void requestInputSalary(int adminNumber, int salary) {

		boolean success = adminSalayDao.salary(adminNumber, salary);

		AlertView alertView = new AlertView();

		if(success){

			alertView.alert("급여가 지급되었습니다");	

		} else {

			alertView.alert("급여지급에 실패하였습니다");

		}

	}


	//급여 지급 목록
	public void requestSalaryList() {


		ArrayList<AdminSalary> adminSalaryLists = adminSalayDao.salaryList();

		AdminSalaryList adminList = new AdminSalaryList();
		adminList.adminSalarylist(adminSalaryLists);


	}

	
	//급여 조회 뷰
	public void requestSalarySearchView() {
		
		AdminSalarySearchView adminSalarySearch = new AdminSalarySearchView();
		adminSalarySearch.adminSalarySearchView();
	
	}
	
	
	//급여 조회 
	public void requestSalarySearch(AdminSalary salarySearch) {
		
		ArrayList<AdminSalary> adminSalarysSearch = adminSalayDao.salayListSearch(salarySearch);
		
		AdminSalaryList adminList = new AdminSalaryList();
		adminList.adminSalarylist(adminSalarysSearch);

	}
			
}

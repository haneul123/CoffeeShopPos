package admin.controller;

import java.util.ArrayList;

import admin.dao.AdminDao;
import admin.view.AdminCommuteSearch;
import admin.view.AdminDeleteView;
import admin.view.AdminListView;
import admin.view.AdminMainMenu;
import admin.view.AdminManagementView;
import admin.view.AdminSignupView;
import admin.view.AdminUpdateView;
import admin.view.StaffMainMenu;
import admin.vo.Admin;
import mainController.MainController;
import mainView.AlertView;



public class AdminController {


	// variable
	private AdminDao adminDao;


	// constructor
	public AdminController() {

		this.adminDao = new AdminDao();

	}


	// method
	// 관리자 회원가입 정보 요청
	public void requestSignUpInfo(){

		AdminSignupView adminSignupView = new AdminSignupView();
		adminSignupView.adminSignupView();

	}


	// 관리자 회원가입 요청
	public void requestSignUp(Admin newAdmin){

		boolean success = adminDao.signUp(newAdmin);

		if(success){

			requestMainMenuView();

		} else {

			System.out.println("회원가입에 실패하였습니다");
			MainController.mainMenuView();

		}

	}


	// 관리자 메인메뉴 뷰 요청
	public void requestMainMenuView(){

		AdminMainMenu adminMainMenu = new AdminMainMenu();
		adminMainMenu.adminMainMenu();

	}

	
	// 직원 메인메뉴 뷰 요청
	public void requestMainMenuViewStaff(){
		
		StaffMainMenu staffMainMenu = new StaffMainMenu();
		staffMainMenu.staffMainMenu();
		
	}
	
	
	// 직원관리 메뉴 뷰 출력요청
	public void requestAdminManagementView() {

		AdminManagementView adminManagementView = new AdminManagementView();
		adminManagementView.adminManagemnetView();

	}


	// 관리자 목록보기
	public void requestListView(){

		ArrayList<Admin> adminList = adminDao.listView();
		AdminListView adminListView = new AdminListView();
		adminListView.adminListView(adminList);
		
	}


	// 관리자 수정을 위한 정보요청 뷰 출력
	public void requestUpdateView(){

		requestListView();
		AdminUpdateView adminUpdateView = new AdminUpdateView();
		adminUpdateView.adminNumberView();
		
	}

	
	// 입력받은 관리자가 있는지 없는지 체크 (수정시)
	public void requestCheckAdmin(int selectedAdmin) {
		
		boolean success = adminDao.checkAdmin(selectedAdmin);
		
		if(success){
			
			AdminUpdateView adminUpdateView = new AdminUpdateView();
			adminUpdateView.adminUpdateView(selectedAdmin);
			
		} else {
		
			AlertView alertView = new AlertView();
			alertView.alert("없는 관리자 입니다.");
		}
		
	}
	
	
	// 입력받은 관리자가 있는지 없는지 체크 (삭제시)
	public void requestCheckAdmin(int selectedAdmin, int delete){
		
		boolean success = adminDao.checkAdmin(selectedAdmin);
		
		if(success){
			
			adminDao.delete(selectedAdmin);
			
		} else {
			
			AlertView alertView = new AlertView();
			alertView.alert("없는 관리자 입니다.");
			
		}
		
	}
	
	
	// 관리자 수정 요청
	public void requestUpdate(Admin updatedAdmin){
		
		boolean success = adminDao.update(updatedAdmin);
		
		AlertView alertView = new AlertView();
		
		if(success){
			alertView.alert("수정이 정상처리되었습니다");
		} else {
			alertView.alert("수정에 실패하였습니다");
		}
		
	}
	
	
	// 관리자 삭제하기
	public void requestDelete(){

		requestListView();
		AdminDeleteView adminDeleteView = new AdminDeleteView();
		adminDeleteView.adminNumberView();

	}

	//관리자 출퇴근 조회 뷰
	public void adminCommuteSearchView() {
		
		AdminCommuteSearch adminCommuteSearch = new AdminCommuteSearch();
		adminCommuteSearch.adminListGetNameView();
	
	}
	
	
	//관리자 출퇴근 조회
	public void adminCommuteSearch(Admin adminCommuteList) {
		
		ArrayList<Admin> adminCommuteLists = adminDao.adminCommuteSearch(adminCommuteList);
		
		AdminCommuteSearch adminCommuteSearch = new AdminCommuteSearch();
		adminCommuteSearch.adminCommuteListView(adminCommuteLists);
		
		
	}

}

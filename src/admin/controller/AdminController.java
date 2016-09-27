package admin.controller;

import java.util.ArrayList;

import admin.dao.AdminDao;
import admin.view.AdminListView;
import admin.view.AdminMainMenu;
import admin.view.AdminManagementView;
import admin.view.AdminSignupView;
import admin.view.AdminUpdateView;
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
		adminUpdateView.adminUpdateView();
		
	}


	// 관리자 수정 요청
	public void requestUpdate(Admin updateAdmin){
		
		boolean success = adminDao.update(updateAdmin);
		
		AlertView alertView = new AlertView();
		
		if(success){
			alertView.alert("수정이 정상처리되었습니다");
		} else {
			alertView.alert("수정에 실패하였습니다");
		}
		
	}
	
	
	// 관리자 삭제하기
	public void requestDelete(){

		

	}

}

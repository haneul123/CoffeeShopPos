package login.controller;

import admin.vo.Admin;
import login.dao.LoginDao;
import login.view.LoginView;
import mainController.MainController;
import mainView.AlertView;

public class LoginController {

	// variable
	private LoginDao loginDao;
	
	// constructor
	public LoginController(){
		
		loginDao = new LoginDao();
	
	}

	
	// 로그인 정보 요청
	public void requestLoginInfo(){
		
		LoginView loginView = new LoginView();
		loginView.loginView();
		
	}

	
	// 로그인 요청
	public void requestLogin(Admin admin){
		
		Admin loginAdmin = loginDao.Login(admin);
		
		AlertView alertView = new AlertView();
		
		if(loginAdmin != null){
		
			alertView.alert("로그인에 성공하였습니다");
			requestLoginInfoSave(loginAdmin);
			MainController.getAdminController().requestMainMenuView();
			
		} else {
			
			
			alertView.alert("로그인에 실패하였습니다");
			
		}
		
	}
	
	
	// 현재 로그인 정보 LoginRepository에 저장
	public void requestLoginInfoSave(Admin loginAdmin){
		
		// 현재 로그인한 관리자의 정보를 로그인 repository에 저장요청
		loginDao.LoginRepo(loginAdmin);
		
	}
	

	// 로그아웃 요청
	public void requestLogout(){
		
		loginDao.Logout();

	}
	
}
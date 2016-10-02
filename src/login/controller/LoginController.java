package login.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		Date date = new Date();
		SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd, a hh:mm:ss");
		AlertView alertView = new AlertView();
		
		if(loginAdmin != null){
		
			// 관리자 권한인 경우
			if(loginAdmin.getAuthority() == 1){
				
				alertView.alert("안녕하세요 " + loginAdmin.getAdminName() + "님");
				System.out.println("현재 시간은 " + nowDate.format(date).toString());
				System.out.println(loginAdmin.getAdminName() + "님의 출근 시간이 기록되었습니다");
				requestLoginInfoSave(loginAdmin);
				MainController.getAdminController().requestMainMenuView();
				
			// 직원 권한인 경우
			} else if(loginAdmin.getAuthority() == 2){
				
				alertView.alert("안녕하세요 " + loginAdmin.getAdminName() + "님");
				System.out.println("현재 시간은 " + nowDate.format(date).toString());
				System.out.println(loginAdmin.getAdminName() + "님의 출근 시간이 기록되었습니다");
				requestLoginInfoSave(loginAdmin);
				MainController.getAdminController().requestMainMenuViewStaff();
				
			}
			
		} else {
						
			alertView.alert("로그인에 실패하였습니다. 계정을 확인해 주시기 바랍니다.");
			MainController.mainMenuView();
			
		}
		
	}
	
	
	// 현재 로그인 정보 LoginRepository에 저장
	public void requestLoginInfoSave(Admin loginAdmin){
		
		// 현재 로그인한 관리자의 정보를 로그인 repository에 저장요청
		loginDao.LoginRepo(loginAdmin);
		
	}
	

	// 로그아웃 요청
	public void requestLogout(){
		
		Date date = new Date();
		SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-mm-dd, a hh:mm:ss");
		
		Admin logoutAdmin = loginDao.Logout();
		AlertView alertView = new AlertView();
		System.out.println("현재 시간은 " + nowDate.format(date).toString());
		System.out.println(logoutAdmin.getAdminName() + "님의 퇴근 시간이 기록되었습니다");
		alertView.alert("로그아웃 되었습니다");
		MainController.mainMenuView();

	}
	
}
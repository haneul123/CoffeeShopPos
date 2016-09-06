package login.controller;

import login.dao.LoginDao;

public class LoginController {

	private LoginDao loginDao;
	
	
	public LoginController(){
		
		loginDao = new LoginDao();
		
	}

	
	public void RequestLogin(){
		
		loginDao.Login();

	}


	public void RequestLogout(){
		
		loginDao.Logout();

	}
	
	
}



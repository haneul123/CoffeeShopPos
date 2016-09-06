package user.controller;

import user.dao.UserDao;

public class UserController {

	private UserDao userDao;


	public UserController(){

		userDao = new UserDao();
	}


	public void requestOrder(){

		userDao.order();

	}


	public void requestUserSignUp(){

		userDao.userSignUp();

	}


	public void requestUserUpdate(){

		userDao.userUpdate();

	}


	public void requestInfoView(){

		userDao.userInfoView();

	}
}

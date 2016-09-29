package user.controller;

import java.util.ArrayList;

import mainView.AlertView;
import user.dao.UserDao;
import user.view.UserListView;
import user.view.UserManagementView;
import user.view.UserSignUpView;
import user.view.UserUpdateView;
import user.vo.User;

public class UserController {


	// variable
	private UserDao userDao;


	// constructor
	public UserController(){

		userDao = new UserDao();
	}


	// method
	// 회원 가입을 위한 정보요청
	public void requestUserSignUpView() {

		UserSignUpView userSignUpView = new UserSignUpView();
		userSignUpView.userSignUpView();
		
	}
	
	
	// 데이터 베이스에 회원 가입 요청
	public void requestUserSignUp(){
		
		
		
	}
	
	
	// 유저 관리 메뉴뷰
	public void requestUserManagementView(){

		UserManagementView userManagementView = new UserManagementView();
		userManagementView.userManagementView();

	}


	// 유저 리스트 정보 요청
	public void requestUserList() {

		ArrayList<User> userList = userDao.userList();
		AlertView alertView = new AlertView();

		if(userList.size() == 0){

			alertView.alert("가입한 회원이 없습니다");

		} else {

			UserListView userListView = new UserListView();
			userListView.userListView(userList);

		}

	}


	// 유저 정보 수정 요청을 위한 회원 번호 요청
	public void requestUserUpdateView() {

		UserUpdateView userUpdateView = new UserUpdateView();
		userUpdateView.selectUserNumber();

	}


	// 받은 회원 번호에 대한 유효성 체크
	public void requestCheckUser(int selectedNumber) {

		boolean success = userDao.checkUser(selectedNumber);
		AlertView alertView = new AlertView();

		if(success){

			UserUpdateView userUpdateView = new UserUpdateView();
			userUpdateView.userUpdateView(selectedNumber);

		} else {

			alertView.alert("선택하신 번호는 없는 유저 번호입니다");

		}

	}


	// 받은 회원 번호의 유저 정보를 수정
	public void requestUserUpdate(User updateUser){

		boolean success = userDao.updateUser(updateUser);
		AlertView alertView = new AlertView();

		if(success){

			alertView.alert("회원정보 수정 되었습니다");

		} else {

			alertView.alert("회원정보 수정 실패하였습니다.");

		}

	}


	// 유저 정보 삭체 요청
	public void requestUserDelete() {



	}

}

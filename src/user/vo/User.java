package user.vo;

import java.sql.Date;

public class User {

	// variable
	private int userNumber;
	private String userPhoneNumber;
	private int couponCount;
	private Date signUpDate;
	private int isWithdrawUser;
	private Date withdrawDate;
	

	// constructor
	public User(){

	}


	// 회원 가입시 필요한 생성자
	public User(String userPhoneNumber) {
		
		this.userPhoneNumber = userPhoneNumber;
		
	}

	
	// 회원 업데이트 시 필요한 생성자
	public User(int selectedNumber, String userPhoneNumber) {

		this.userNumber = selectedNumber;
		this.userPhoneNumber = userPhoneNumber;

	}


	// getter and setter
	public int getUserNumber() {
		return userNumber;
	}


	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}


	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public int getCouponCount() {
		return couponCount;
	}


	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}


	public Date getSignUpDate() {
		return signUpDate;
	}


	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}


	public int getIsWithdrawUser() {
		return isWithdrawUser;
	}


	public void setIsWithdrawUser(int isWithdrawUser) {
		this.isWithdrawUser = isWithdrawUser;
	}


	public Date getWithdrawDate() {
		return withdrawDate;
	}


	public void setWithdrawDate(Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

}

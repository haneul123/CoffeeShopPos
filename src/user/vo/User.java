package user.vo;

public class User {

	// variable
	private int userNumber;
	private String userPhoneNumber;
	private int couponCount;


	// constructor
	public User(){

	}


	public User(int userNumber, String userPhoneNumber, int couponCount) {

		this.userNumber = userNumber;
		this.userPhoneNumber = userPhoneNumber;
		this.couponCount = couponCount;
		
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
	
}

package user.vo;

public class User {
	
	private String number;
	private String id;
	private String name;
	private String loginTime;
	private int couponCount;
	
	
	public User(){
		
	}
	
	
	public User(String id, String name, String loginTime, int couponCount){
		
		this.number = number;
		this.id = id;
		this.name = name;
		this.loginTime = loginTime;
		this.couponCount = couponCount;
		
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLoginTime() {
		return loginTime;
	}


	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}


	public int getCouponCount() {
		return couponCount;
	}


	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}
	
	

}

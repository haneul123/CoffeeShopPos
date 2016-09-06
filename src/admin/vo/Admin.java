package admin.vo;

import java.util.Date;

public class Admin {

	
	// variable
	private int adminNumber;
	private String adminId;
	private String adminPw;
	private String adminName;
	private Date loginTime;
	private Date logoutTime;
	private int authority;
	
	
	// constructor
	public Admin() {
	
		
	}

	
	// getter and setter
	public int getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
}

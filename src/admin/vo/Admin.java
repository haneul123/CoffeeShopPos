package admin.vo;

public class Admin {

	// variable
	private int adminNumber;
	private String adminId;
	private String adminPassword;
	private String adminName;
	private int authority;
	
	// constructor
	public Admin() {
	
		
	}

	// 로그인을 위한 admin 생성
	public Admin(String adminId, String adminPassword){
		
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		
	}
	
	
	// 회원가입을 위한 admin 생성
	public Admin(String adminId, String adminPassword, String adminName, int authority){
		
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
		this.authority = authority;
		
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

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}
		
}

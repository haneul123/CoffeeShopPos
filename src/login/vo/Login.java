package login.vo;

public class Login {
	
	
	private String adminId;
	private String adminPassword;
	private int adminNumber;
	
	
	public Login(){
		
	}

	
	public Login(String ID, String PW){
		
		this.adminId = ID;
		this.adminPassword = PW;
				
	}
	
	
	public String getID() {
		return adminId;
	}

	public void setID(String adminId) {
		this.adminId = adminId;
	}

	public String getPW() {
		return adminPassword;
	}

	public void setPW(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

}

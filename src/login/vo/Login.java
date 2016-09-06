package login.vo;

public class Login {
	
	
	private String ID;
	private String PW;
	private int adminNumber;
	
	
	public Login(){
		
	}

	
	public Login(String ID,String PW){
		
		this.ID = ID;
		this.PW = PW;
		this.adminNumber = adminNumber;
		
	}
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public int getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

}

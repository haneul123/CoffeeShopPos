package login.repository;

public class LoginRepository {

	// variable
	public static String loginAdminId;
	public static String loginAdminPassword;
	public static int authorityNumber;
	
	
	// constructor
	public LoginRepository() {

	}
	
	
	// getter and setter	
	public static String getLoginAdminId() {
		return loginAdminId;
	}

	public static void setLoginAdminId(String loginAdminId) {
		LoginRepository.loginAdminId = loginAdminId;
	}

	public static String getLoginAdminPassword() {
		return loginAdminPassword;
	}

	public static void setLoginAdminPassword(String loginAdminPassword) {
		LoginRepository.loginAdminPassword = loginAdminPassword;
	}

	public static int getAuthorityNumber() {
		return authorityNumber;
	}

	public static void setAuthorityNumber(int authorityNumber) {
		LoginRepository.authorityNumber = authorityNumber;
	}
		
}

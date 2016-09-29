package login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import admin.vo.Admin;
import login.repository.LoginRepository;
import mainController.MainController;

public class LoginDao {

	// variable
	LoginRepository loginRepository;
	
	
	// constructor
	public LoginDao() {
	
		this.loginRepository = new LoginRepository();
		
	}

	
	// 로그인 정보 받아서 확인
	public Admin Login(Admin admin){

		Admin loginAdmin = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		try {

			String sql = "select * from admin_list where admin_id = ? and admin_pw = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, admin.getAdminId());
			pstmt.setString(2, admin.getAdminPassword());
			rs = pstmt.executeQuery();

			if(rs.next()){

				loginAdmin = new Admin();
				loginAdmin.setAdminNumber(rs.getInt(1));
				loginAdmin.setAuthority(rs.getInt(2));
				loginAdmin.setAdminId(rs.getString(3));
				loginAdmin.setAdminPassword(rs.getString(4));
				loginAdmin.setAdminName(rs.getString(5));
				
				sql = "insert into login_record(login_number, admin_number, start_time) values(login_number_seq.nextval, ?, sysdate)";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, loginAdmin.getAdminNumber());
				pstmt2.executeUpdate();
						
				sql = "select max(login_number) from login_record";
				stmt = MainController.getDbController().getConnection().createStatement();
				rs2 = stmt.executeQuery(sql);
				
				if(rs2.next()){
					LoginRepository.setLoginNumber(rs2.getInt(1));
				}
				
			} else {

				return loginAdmin;
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			
			if(stmt != null){try{stmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(pstmt2 != null){try{pstmt2.close();} catch(SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch(SQLException e){e.printStackTrace();}}
			
		}

		return loginAdmin;

	}

	
	// 현재 로그인한 사람의 정보를 로그인 repository에 저장
	public void LoginRepo(Admin loginAdmin) {

		LoginRepository.setLoginAdminId(loginAdmin.getAdminId());
		LoginRepository.setLoginAdminPassword(loginAdmin.getAdminPassword());
		LoginRepository.setAuthorityNumber(loginAdmin.getAuthority());

	}

	
	// 로그아웃 처리
	public void Logout(){

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int adminNumber = 0;
		
		try {
			
			adminNumber = LoginRepository.getLoginNumber();
			String sql = "update login_record set end_time = sysdate where login_number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, adminNumber);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		
		// 로그인 저장소 초기화
		new LoginRepository();
			
	}

}

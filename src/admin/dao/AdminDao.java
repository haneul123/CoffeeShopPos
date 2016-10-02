package admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.vo.Admin;
import adminSalary.vo.AdminSalary;
import mainController.MainController;
import mainView.AlertView;

public class AdminDao {


	// 관리자 회원가입 
	public boolean signUp(Admin newAdmin){

		boolean success = false;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;

		try {

			String sql = "select * from admin_list where admin_id = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newAdmin.getAdminId());
			rs = pstmt.executeQuery();

			if(rs.next()){

				AlertView alertView = new AlertView();
				alertView.alert("이미 아이디가 있습니다");

			} else {

				sql = "insert into admin_list values(admin_number_seq.nextval,?,?,?,?)";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, newAdmin.getAuthority());
				pstmt2.setString(2, newAdmin.getAdminId());
				pstmt2.setString(3, newAdmin.getAdminPassword());
				pstmt2.setString(4, newAdmin.getAdminName());
				pstmt2.executeUpdate();
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt2 != null){try{pstmt2.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
		}

		return success;
	}


	// 관리자 리스트 정보 
	public ArrayList<Admin> listView(){

		ArrayList<Admin> adminList = new ArrayList<Admin>();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from admin_list order by admin_number";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()){

				Admin admin = new Admin();
				admin.setAdminNumber(rs.getInt(1));
				admin.setAuthority(rs.getInt(2));
				admin.setAdminId(rs.getString(3));
				admin.setAdminPassword(rs.getString(4));
				admin.setAdminName(rs.getString(5));
				adminList.add(admin);

			} 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(stmt != null){try {stmt.close();} catch (SQLException e) {e.printStackTrace();}}
		}

		return adminList;

	}


	// 입력받은 관리자가 데이터베이스에 있는지 확인
	public boolean checkAdmin(int selectedAdmin) {

		boolean success = false;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from admin_list where admin_number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedAdmin);
			rs = pstmt.executeQuery();

			if(rs.next()){
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
		}

		return success;

	}


	// 관리자 정보 수정
	public boolean update(Admin updateAdmin){

		boolean success = false;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

		try {

			if(updateAdmin.getAdminPassword() != null){

				String sql = "update admin_list set admin_pw = ? where admin_number = ?";
				pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt1.setString(1, updateAdmin.getAdminPassword());
				pstmt1.setInt(2, updateAdmin.getAdminNumber());
				pstmt1.executeUpdate();
				success = true;

			}

			if(updateAdmin.getAdminName() != null){

				String sql = "update admin_list set admin_name = ? where admin_number = ?";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setString(1, updateAdmin.getAdminName());
				pstmt2.setInt(2, updateAdmin.getAdminNumber());
				pstmt2.executeUpdate();
				success = true;

			}

			if(updateAdmin.getAuthority() != 0){

				String sql = "update admin_list set authorityNumber = ? where admin_number = ?";
				pstmt3 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt3.setInt(1, updateAdmin.getAuthority());
				pstmt3.setInt(2, updateAdmin.getAdminNumber());
				pstmt3.executeUpdate();
				success = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt3 != null){try {pstmt3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try {pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}
		}

		return success;

	}


	// 관리자 정보 삭제
	public void delete(int selectedAdmin){

		PreparedStatement pstmt = null;

		try {

			String sql = "delete from admin_list where admin_number = ?";	
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedAdmin);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
		}

	}


	//관리자 출퇴근 조회
	public ArrayList<Admin> adminCommuteSearch(Admin adminCommuteList) {
		
		ArrayList<Admin> adminCommuteLists = new ArrayList<Admin>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
		String sql = "select lr.login_number, al.admin_name, lr.START_TIME, lr.END_TIME  "
				+ "from login_record lr, admin_list al "
				+ "where al.admin_name LIKE '%'||?||'%'  and lr.ADMIN_NUMBER = al.ADMIN_NUMBER";
		
		pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
		pstmt.setString(1, adminCommuteList.getAdminName());
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Admin adminCommute = new Admin();
			adminCommute.setLoginNumber(rs.getInt("login_number"));
			adminCommute.setAdminName(rs.getString("admin_name"));
			adminCommute.setStartTime(rs.getDate("start_time"));
			adminCommute.setEndTime(rs.getDate("END_TIME"));
			adminCommuteLists.add(adminCommute);
			
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
		}
		
		return adminCommuteLists;	
	}
}

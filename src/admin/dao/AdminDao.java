package admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.vo.Admin;
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
			if(rs != null){try{pstmt2.close();}catch(SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt2.close();}catch(SQLException e){e.printStackTrace();}}
		}
		
		return success;
	}


	// 관리자 리스트 정보 
	public ArrayList<Admin> listView(){

		ArrayList<Admin> adminList = new ArrayList<Admin>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from admin_list";
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


	// 관리자 정보 수정
	public boolean update(Admin updateAdmin){

		boolean success = false;
		
		
		
		
		return success;

	}


	// 관리자 정보 삭제
	public void delete(){


	}
	
}

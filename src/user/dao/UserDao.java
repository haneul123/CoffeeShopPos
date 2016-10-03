package user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import user.vo.User;

public class UserDao {
	
	// 유저리스트 정보 받아오기
	public ArrayList<User> userList() {
	
		ArrayList<User> userList = new ArrayList<User>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from user_list";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				User user = new User();
				user.setUserNumber(rs.getInt(1));
				user.setCouponCount(rs.getInt(2));
				user.setUserPhoneNumber(rs.getString(3));
				user.setSignUpDate(rs.getDate(4));
				user.setIsWithdrawUser(rs.getInt(5));
				user.setWithdrawDate(rs.getDate(6));
				userList.add(user);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
		
	}

	
	// 회원번호 체크
	public boolean checkUser(int selectedNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select user_number from user_list where user_number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedNumber);
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


	// 회원 정보 수정
	public boolean updateUser(User updateUser) {
		
		boolean success = false;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select user_phone_number from user_list";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				return success;
			}
			
			sql = "update user_list set user_phone_number = ? where user_number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, updateUser.getUserPhoneNumber());
			pstmt.setInt(2, updateUser.getUserNumber());
			pstmt.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(stmt != null){try{stmt.close();}catch(SQLException e){e.printStackTrace();}}
		}
		
		return success;
		
	}


	// 회원가입 데이터 저장
	public void userSignUp(User newUser) {

		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "insert into user_list values(user_number_seq.nextval, 0, ?, sysdate, 1, null)";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newUser.getUserPhoneNumber());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}


	// 선택한 회원 삭제
	public boolean deleteUser(int selectedNumber) {

		boolean success = false;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from user_list where user_number = ? and is_withdraw_user = 2";
			pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt1.setInt(1, selectedNumber);
			rs = pstmt1.executeQuery();
			
			if(rs.next()){
				return success;
			}
			
			sql = "update user_list set is_withdraw_user = 2, withdraw_date = sysdate where user_number = ? and is_withdraw_user = 1";
			pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt2.setInt(1, selectedNumber);
			pstmt2.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return success;
		
	}

}

package adminSalary.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import adminSalary.vo.AdminSalary;
import mainController.MainController;

public class AdminSalaryDao {


	// 급여 데이터 입력
	public boolean salary(int adminNumber, int salary) {

		boolean success = false;
		PreparedStatement pstmt = null;

		try {

			String sql = "insert into salary values(salary_number_seq.nextval, ?, ?, sysdate)";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, adminNumber);
			pstmt.setInt(2, salary);
			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}

		}

		return success;

	}


	//급여 지급 목록 보기
	public ArrayList<AdminSalary> salaryList() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AdminSalary> Salarylists = new ArrayList<AdminSalary>();

		try {

			String sql = "select sl.SALARY_NUMBER ,al.ADMIN_NAME, sl.SALARY, sl.SALARY_DATE "
					+ "from salary sl, admin_list al "
					+ "where sl.ADMIN_NUMBER = al.ADMIN_NUMBER "
					+ "order by sl.salary_number desc";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				AdminSalary adminSalary = new AdminSalary();
				adminSalary.setSalaryNumber(rs.getInt("salary_number"));
				adminSalary.setAdminName(rs.getString("admin_name"));
				adminSalary.setSalary(rs.getInt("salary"));
				adminSalary.setSalaryDate(rs.getDate("salary_date"));
				Salarylists.add(adminSalary);

			}

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(stmt != null){ try{stmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){ try{rs.close();}catch(SQLException e){e.printStackTrace();}}

		}

		return Salarylists;

	}


	//급여 지급 조회 
	public ArrayList<AdminSalary> salayListSearch(AdminSalary salarySearch) {

		ArrayList<AdminSalary> adminSalarySearch = new ArrayList<AdminSalary>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select sl.SALARY_NUMBER, al.ADMIN_NAME, sl.SALARY, sl.SALARY_DATE "
					+ "from salary sl, admin_list al  "
					+ "where ADMIN_NAME LIKE '%'||?||'%'  and sl.ADMIN_NUMBER = al.ADMIN_NUMBER ORDER BY SALARY_NUMBER";
			
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, salarySearch.getAdminName());
			rs = pstmt.executeQuery();

			while(rs.next()) {

				AdminSalary adminSalary = new AdminSalary();
				adminSalary.setSalaryNumber(rs.getInt("salary_number"));
				adminSalary.setAdminName(rs.getString("admin_name"));
				adminSalary.setSalary(rs.getInt("salary"));
				adminSalary.setSalaryDate(rs.getDate("salary_date"));
				adminSalarySearch.add(adminSalary);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
		}

		return adminSalarySearch;

	}
}

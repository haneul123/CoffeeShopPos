package mainController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import mainView.AlertView;

public class DBcontroller {
	
	private Connection conn;
	private AlertView alertView;
	
	
	//오라클 드라이버 연결하기
	public DBcontroller(){
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 최원재
			   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","csp_admin","123456");
			
			// 김하늘
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");

		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {	
			e.printStackTrace();
		}
	}

	
	public Connection getConnection() {
		
		return conn;
		
	}
	
	
	//프로그램 종료
	public void requestExitProgram() {
		
		if(conn != null) {
			
			try{
				
				conn.close();
				
			}catch (SQLException e){
				e.printStackTrace();
			}
			
		}
		
		alertView.alert("프로그램을 종료합니다.");
		System.exit(0);
		
	}
	
}

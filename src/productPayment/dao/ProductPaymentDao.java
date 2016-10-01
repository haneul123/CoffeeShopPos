package productPayment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mainController.MainController;

public class ProductPaymentDao {

	// 주문 된 상품 결제처리
	public void payment(int paymentMethod) {

		Statement stmt = null;
		ResultSet rs = null;
		
		// 결제 처리가 안된 주문 데이터 가져오기
		try {
			
			String sql = "select * from product_order_list where isAgreePaid = 1";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);	
			
			while(rs.next()){
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	
}

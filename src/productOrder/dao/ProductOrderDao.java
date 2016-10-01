package productOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mainController.MainController;
import productOrder.vo.ProductOrder;

public class ProductOrderDao {


	// 입력된 회원 전화번호가 있는 번호인지 체크
	public int checkUser(String userPhoneNumber) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int userNumber = 0;
		
		try {
			
			// 입력된 회원의 휴대폰 번호와 일치하는 회원 번호를 검색한다
			String sql = "select user_number from user_list where user_phone_number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, userPhoneNumber);
			rs = pstmt.executeQuery();	

			if(rs.next()){
				userNumber = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userNumber;
		
	}


	//주문상품을 주문 리스트에 넣기
	public boolean orderProductInsert(ProductOrder orderProduct) {

		boolean isSuccess = false;		
		PreparedStatement pstmt = null;
	
		try {

			String sql = "insert into product_order_list values(product_order_number_seq.nextval, ?, ?, ?, sysdate, ?, 0)";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, orderProduct.getUserNumber());
			pstmt.setInt(2, orderProduct.getProductNumber());
			pstmt.setInt(3, orderProduct.getOrderCount());
			pstmt.setInt(4, orderProduct.getPaymentMethod());
			pstmt.executeUpdate();
			isSuccess = true;

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
	
			if(pstmt != null){try{pstmt.close();} catch (SQLException e) {e.printStackTrace();}}

		}

		return isSuccess;

	}


	// 현재 주문된 리스트 확인하기
	public ArrayList<ProductOrder> orderList() {

		ArrayList<ProductOrder> orderList = new ArrayList<ProductOrder>(); 
		
		String sql = "select * from product_order_list where isAgreePaid = 1";
		
		 
		return orderList;
		
	}	

}



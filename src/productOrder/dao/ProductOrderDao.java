package productOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import productOrder.vo.ProductOrder;
import productPaymentRepository.ProductOrderRepository;

public class ProductOrderDao {


	// 입력된 회원 전화번호가 있는 번호인지 체크
	public int checkUser(String userPhoneNumber) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int userNumber = 1;
		
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

			String sql = "insert into product_order_list values(product_order_number_seq.nextval, ?, ?, ?, sysdate, 1)";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, orderProduct.getUserNumber());
			pstmt.setInt(2, orderProduct.getProductNumber());
			pstmt.setInt(3, orderProduct.getOrderCount());
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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalPrice = 0;
		
		try {
			
			String sql = "select pol.PRODUCT_ORDER_NUMBER, pl.PRODUCT_NAME, pol.ORDER_COUNT, pol.ORDER_DATE, pl.PRODUCT_PRICE,";
				   sql += " (pl.PRODUCT_PRICE * pol.ORDER_COUNT) as totalprice";
			       sql += " from product_order_list pol, product_list pl";
				   sql += " where pol.ISAGREEPAID = 1 and pol.PRODUCT_NUMBER = pl.PRODUCT_NUMBER order by product_order_number";
				   
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				ProductOrder order = new ProductOrder();
				order.setProductOrderNumber(rs.getInt(1));
				order.setProductName(rs.getString(2));
				order.setOrderCount(rs.getInt(3));
				order.setOrderDate(rs.getDate(4));
				order.setProductPrice(rs.getInt(5));
				order.setTotalPrice(rs.getInt(6));
				orderList.add(order);
				
			}
			
			for(int i = 0; i<orderList.size(); i++){
				totalPrice = totalPrice + orderList.get(i).getTotalPrice();
			}
			
			ProductOrderRepository.setTotalPrice(totalPrice);
			ProductOrderRepository.setRealPrice(totalPrice);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderList;
		
	}


	// 선택한 주문번호가 존재하는지 확인
	public boolean checkOrderNumber(int deleteOrderNumber) {
		
		boolean isFind = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
		
			String sql = "select * from product_order_list where product_order_number = ? and isAgreePaid = 1";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteOrderNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				isFind = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
		}
			
		return isFind;
		
	}


	// 선택된 주문번호를 삭제 (물리적 삭제가 아닌, 논리적 삭제, 주문단에서 취소된 주문은 isAgreePaid가 3번이다)
	public boolean deleteOrderNumber(int deleteOrderNumber) {

		boolean isSuccess = false;
		PreparedStatement pstmt = null;
	
		try {
			
			String sql = "update product_order_list set isAgreePaid = 3 where product_order_number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteOrderNumber);
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return isSuccess;
		
	}


	// 전체 주문 삭제 (물리적 삭제가 아닌, 논리적 삭제, 결제단에서 취소된 주문은 isAgreePaid가 4번이다)
	public boolean deleteAllOrder() {
		
		boolean isSuccess = false;
		Statement stmt = null;
	
		try {
			
			String sql = "update product_order_list set isAgreePaid = 4 where isAgreePaid = 1";
			stmt = MainController.getDbController().getConnection().createStatement();
			stmt.executeUpdate(sql);
			isSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return isSuccess;
		
	}	

}



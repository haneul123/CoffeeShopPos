package productOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mainController.MainController;
import productOrder.repository.ProductOrderRepository;
import productOrder.vo.ProductOrder;

public class ProductOrderDao {


	public void order(){

		new ProductOrderRepository();

	}


	//주문한 상품  저장 하기
	public int orderproduct(ProductOrder orderProduct) {

		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		int orderProcessNumber = 0;

		//수량만 증가
		for(int i=0; i<ProductOrderRepository.getProductOrders().size(); i++) {
			if(ProductOrderRepository.getProductOrders().get(i).getProductNumber() == orderProduct.getProductNumber()) {
				ProductOrderRepository.getProductOrders().get(i).setOrderCount(orderProduct.getOrderCount());
				orderProcessNumber = 1;
				return orderProcessNumber;
			}
		}

		//상품 정보 불러오기

		try {

			String sql = "select product_Name, product_Price from product_list where product_Number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, orderProduct.getProductNumber());
			rs = pstmt.executeQuery();

			if(rs.next()) {

				ProductOrderRepository.getProductOrders().add(orderProduct);
				ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber()).setProductName(rs.getString(1));
				ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber()).setProductPrice(rs.getInt(2));
				ProductOrderRepository.setLastProductOrderNumber(ProductOrderRepository.getLastProductOrderNumber() + 1);
				orderProcessNumber = 2;

			}

			sql = "select user_number from user_list where user_phone_number = ?";
			pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt1.setString(1, orderProduct.getUserPhoneNumber());
			rs1 = pstmt1.executeQuery();
			
			if(rs1.next()) {
				
				ProductOrderRepository.getProductOrders().add(orderProduct);
				ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber()).setUserNumber(rs.getInt(1));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
		}

		return orderProcessNumber;
	}


	//주문상품을 주문 리스트에 넣기
	public boolean orderProductInsert() {

		boolean success = false;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;

		ResultSet rs1 = null;
		ResultSet rs2 = null;

		int userNumber = 0;

		try {
			
		for(int i = 0; i<ProductOrderRepository.getProductOrders().size(); i++){
//				String sql = "select user_number from user_list where user_phone_number = ?";
//				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
//				pstmt2.setInt(1, ProductOrderRepository.getProductOrders().get(i).getUserNumber());
//				rs2 = pstmt2.executeQuery();
//
//			if(rs2.next()){

					String sql = "insert into product_order_list(product_order_number, user_number, product_number, order_Count, order_date) values(?,?,?,?,?) where product_number = ? ";
					pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
					pstmt1.setInt(1, ProductOrderRepository.getProductOrders().get(i).getProductOrderNumber());
					pstmt1.setInt(2, ProductOrderRepository.getProductOrders().get(i).getUserNumber());
					pstmt1.setInt(3, ProductOrderRepository.getProductOrders().get(i).getProductNumber());
					pstmt1.setInt(4, ProductOrderRepository.getProductOrders().get(i).getOrderCount());
					pstmt1.setDate(5, ProductOrderRepository.getProductOrders().get(i).getOrderDate());
					pstmt1.executeUpdate();
					success = true;

				}
			

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(rs1 != null){try{rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try{pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}

		}

		return success;

	}
}

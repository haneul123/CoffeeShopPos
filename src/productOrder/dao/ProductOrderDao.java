package productOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import productOrder.repository.ProductOrderRepository;
import productOrder.vo.ProductOrder;
import productPayment.vo.ProductPayment;

public class ProductOrderDao {


	private static final ProductPayment productPayment = null;


	public void order(){

		new ProductOrderRepository();

	}


	//주문한 상품  저장 하기
	public boolean orderproduct(ProductOrder orderProduct) {

	 boolean success = ProductOrderRepository.getProductOrders().add(orderProduct);
	 return success;

	}


	//주문상품을 주문 리스트에 넣기
	public ProductPayment orderProductInsert(ProductOrder orderProduct) {

		Statement stmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;	
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		int userNumber = 0;	
		int freeCoupon = 0;
		int remainCoupon = 0;

		try {

			String sql = "select user_number from user_list where user_phone_number = ?";
			pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt1.setString(1, orderProduct.getUserPhoneNumber());
			rs1 = pstmt1.executeQuery();	

			if(rs1.next()){
				userNumber = rs1.getInt(1);		
			}

			for(int i = 0; i<ProductOrderRepository.getProductOrders().size(); i++){

				sql = "insert into product_order_list values(product_order_number_seq.nextval, ?, ?, ?, sysdate, ?)";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, userNumber);
				pstmt2.setInt(2, ProductOrderRepository.getProductOrders().get(i).getProductNumber());
				pstmt2.setInt(3, ProductOrderRepository.getProductOrders().get(i).getOrderCount());
				pstmt2.setInt(4, ProductOrderRepository.getProductOrders().get(i).getSelectPaymentMethod());
				pstmt2.executeUpdate();

			}

			sql = "select trunc((ul.coupon_count + pol.order_count) / 10, 0) as freecoupon,"; 
			sql += " mod((ul.coupon_count + pol.order_count) , 10) as remaincoupon";
			sql += " from user_list ul, product_order_list pol";
			sql += " where ul.user_number = pol.user_number";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs2 = stmt.executeQuery(sql);

			if(rs2.next()) {

				freeCoupon = rs2.getInt(1);
				remainCoupon = rs2.getInt(2);

			} else {
				for(int i = 0; i<ProductOrderRepository.getProductOrders().size(); i++){

					sql = "insert into user_list values(user_number_seq.nextval,?,?)";
					pstmt3 = MainController.getDbController().getConnection().prepareStatement(sql);
					pstmt3.setInt(1, remainCoupon);
					pstmt3.setString(2, ProductOrderRepository.getProductOrders().get(i).getUserPhoneNumber());
					
				}
			}

			sql = "select pl.product_price * pol.ORDER_COUNT as totalprice,";
			sql += " (pl.product_price * pol.ORDER_COUNT) - (pl.product_price * ?) as realprice";
			sql += " from product_list pl, product_order_list pol";
			sql += " where pl.product_number = pol.product_number";
			pstmt4 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt4.setInt(1, freeCoupon);

			rs3 = pstmt3.executeQuery();

			if(rs3.next()) {

				ProductPayment productPayment = new ProductPayment();
				productPayment.setTotalPrice(rs3.getInt(1));
				productPayment.setRealPrice(rs3.getInt(2));

			}

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(rs1 != null){try{rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try{pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}

		}

		ProductOrderRepository.getProductOrders().clear();

		return productPayment;

	}

}

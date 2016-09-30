package productOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mainController.MainController;
import productOrder.vo.ProductOrder;
import productPayment.vo.ProductPayment;

public class ProductOrderDao {


	//주문상품을 주문 리스트에 넣기
	public ProductPayment orderProductInsert(ProductOrder orderProduct) {

		ProductPayment productPayment = new ProductPayment();
		Statement stmt = null;
		Statement stmt2 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;	
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;
		int userNumber = 0;	
		int freeCoupon = 0;
		int remainCoupon = 0;
		int maxProductOrderNumber = 0;

		try {

			String sql = "select user_number from user_list where user_phone_number = ?";
			pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt1.setString(1, orderProduct.getUserPhoneNumber());
			rs1 = pstmt1.executeQuery();	

			if(rs1.next()){
				userNumber = rs1.getInt(1);		
			}

			sql = "insert into product_order_list values(product_order_number_seq.nextval, ?, ?, ?, sysdate, ?)";
			pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt2.setInt(1, userNumber);
			pstmt2.setInt(2, orderProduct.getProductNumber());
			pstmt2.setInt(3, orderProduct.getOrderCount());
			pstmt2.setInt(4, orderProduct.getSelectPaymentMethod());
			pstmt2.executeUpdate();

			sql = "select trunc((ul.coupon_count + pol.order_count) / 10, 0) as freecoupon,"; 
			sql += " mod((ul.coupon_count + pol.order_count) , 10) as remaincoupon";
			sql += " from user_list ul, product_order_list pol";
			sql += " where ul.user_number = pol.user_number";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs2 = stmt.executeQuery(sql);

			if(rs2.next()) {

				freeCoupon = rs2.getInt(1);
				remainCoupon = rs2.getInt(2);

			} 

			sql = "update user_list set coupon_count = ? where user_number = ?";
			pstmt3 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt3.setInt(1, remainCoupon);
			pstmt3.setInt(2, userNumber);
			pstmt3.executeUpdate();

			sql = "select (pl.product_price * pol.ORDER_COUNT) as totalPrice, ((pl.product_price * pol.ORDER_COUNT) - (pl.product_price * ?)) as realPrice from product_list pl, product_order_list pol where pl.product_number = pol.product_number";
			pstmt4 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt4.setInt(1, freeCoupon);

			rs3 = pstmt4.executeQuery();

			if(rs3.next()) {

				productPayment.setTotalPrice(rs3.getInt(1));
				productPayment.setRealPrice(rs3.getInt(2));

			}

			sql = "select max(product_order_number) from product_order_list";
			stmt2 = MainController.getDbController().getConnection().createStatement();
			rs4 = stmt2.executeQuery(sql);

			if(rs4.next()){
				maxProductOrderNumber = rs4.getInt(1);
			}

			sql = "select * from product_order_list where product_order_number = ?";
			pstmt5 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt5.setInt(1, maxProductOrderNumber);
			rs5 = pstmt5.executeQuery();

			if(rs5.next()){

				productPayment.setProductOrderNumber(rs5.getInt(1));
				productPayment.setUserNumber(rs5.getInt(2));
				productPayment.setProductNumber(rs5.getInt(3));
				productPayment.setPaymentCount(rs5.getInt(4));
				productPayment.setPaymentDate(rs5.getDate(5));
				productPayment.setPaymentMethod(rs5.getInt(6));

			}

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(rs5 != null){try{rs5.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt5 != null){try{pstmt5.close();} catch (SQLException e) {e.printStackTrace();}}	
			if(rs4 != null){try{rs4.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt2 != null){try{pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}		
			if(rs3 != null){try{rs3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt4 != null){try{pstmt4.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt3 != null){try{pstmt3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs2 != null){try{rs2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt2 != null){try{pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt != null){try{pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}	
			if(rs1 != null){try{rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try{pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}

		}

		return productPayment;

	}

}

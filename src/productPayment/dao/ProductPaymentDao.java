package productPayment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import productPayment.vo.ProductPayment;
import productPaymentRepository.ProductOrderRepository;
import productPaymentRepository.UseIngredientAmount;

public class ProductPaymentDao {

	// 주문 된 상품 결제처리
	public boolean payment(int paymentMethod) {

		boolean isSuccess = false;
		Statement stmt1 = null;
		Statement stmt2 = null;
		Statement stmt3 = null;
		Statement stmt4 = null;
		Statement stmt5 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		int freeCoupon = 0;
		int remainCoupon = 0;
		ArrayList<ProductPayment> paymentList = new ArrayList<ProductPayment>();
		ArrayList<UseIngredientAmount> useAmountList = new ArrayList<UseIngredientAmount>();

		try {

			// 트랜잭션 처리
//			MainController.getDbController().getConnection().setAutoCommit(false);
			
			// 결제 처리가 안된 주문 데이터 가져오기
			String sql = "select product_order_number, user_number from product_order_list where isAgreePaid = 1";
			stmt1 = MainController.getDbController().getConnection().createStatement();
			rs1 = stmt1.executeQuery(sql);	

			while(rs1.next()){

				ProductPayment productPayment = new ProductPayment();
				productPayment.setProductOrderNumber(rs1.getInt(1));
				productPayment.setUserNumber(rs1.getInt(2));
				productPayment.setPaymentNumber(paymentMethod);
				paymentList.add(productPayment);

			}


			// 가져온 주문 데이터를 결제 데이터에 저장하기
			for(int i = 0; i<paymentList.size(); i++){

				sql = "insert into product_pay_list values(product_pay_number_seq.nextval, ?, ?, 1)";
				pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt1.setInt(1, paymentList.get(i).getProductOrderNumber());
				pstmt1.setInt(2, paymentList.get(i).getPaymentNumber());
				pstmt1.executeUpdate();

			}


			// 쿠폰처리 (비회원은 쿠폰수를 계산하지 않는다)
			if(paymentList.get(0).getUserNumber() != 1){


				// 주문한 만큼의 쿠폰 계산 및 무료로 나가야 할 쿠폰 수 계산
				sql = "select trunc((ul.coupon_count + pol.order_count) / 10, 0) as freecoupon,"; 
				sql += " mod((ul.coupon_count + pol.order_count) , 10) as remaincoupon";
				sql += " from user_list ul, product_order_list pol";
				sql += " where ul.user_number = pol.user_number and isAgreePaid = 1";
				stmt2 = MainController.getDbController().getConnection().createStatement();
				rs2 = stmt2.executeQuery(sql);

				if(rs2.next()) {

					freeCoupon = rs2.getInt(1);
					remainCoupon = rs2.getInt(2);

				} 


				// 계산된 쿠폰수 만큼 업데이트
				sql = "update user_list set coupon_count = ? where user_number = ?";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, remainCoupon);
				pstmt2.setInt(2, paymentList.get(0).getUserNumber());
				pstmt2.executeUpdate();


				// 쿠폰을 반영한 실제 결제 가격 계산
				sql = "select (pl.product_price * pol.ORDER_COUNT) as totalPrice, ";
				sql += "((pl.product_price * pol.ORDER_COUNT) - (pl.product_price * ?)) as realPrice ";
				sql	+= "from product_list pl, product_order_list pol ";
				sql	+= "where pl.product_number = pol.product_number and pol.isAgreePaid = 1";
				pstmt3 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt3.setInt(1, freeCoupon);
				rs3 = pstmt3.executeQuery();

				if(rs3.next()) {

					ProductOrderRepository.setRealPrice(rs3.getInt(2));
					ProductOrderRepository.setTotalPrice(rs3.getInt(1));

				}
			}
	
			// 주문 데이터 결제 상태로 변경하기
			sql = "update product_order_list set isAgreePaid = 2 where isAgreePaid = 1";
			stmt3 = MainController.getDbController().getConnection().createStatement();
			stmt3.executeUpdate(sql);
			
			
			// 완료된 주문에 해당하는 원재료 감소 처리를 위한 정보 수집
			sql = "select pui.product_number, pui.ingredient_number, (pui.use_amount * oc.order_count) "; 
			sql += "from product_use_ingredient pui, order_count oc ";	
			sql += "where pui.product_number = oc.PRODUCT_NUMBER";
			stmt4 = MainController.getDbController().getConnection().createStatement();
			rs4 = stmt4.executeQuery(sql);
			while(rs4.next()){

				UseIngredientAmount useAmount = new UseIngredientAmount();
				useAmount.setProductNumber(rs4.getInt(1));
				useAmount.setIngredientNumber(rs4.getInt(2));
				useAmount.setTotalAmount(rs4.getInt(3));
				useAmountList.add(useAmount);

			}

		
			// 원재료 감소 처리
			for(int i=0; i<useAmountList.size(); i++){

				sql =  "update ingredient_list ";
				sql += "set ingredient_inventory = (ingredient_inventory - ?) ";
				sql += "where ingredient_number = ?";
				pstmt4 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt4.setInt(1, useAmountList.get(i).getTotalAmount());
				pstmt4.setInt(2, useAmountList.get(i).getIngredientNumber());
				pstmt4.executeUpdate();

			}

			
			// 원재료 감소처리 확인 플래그 설정
			sql = "update product_pay_list set use_ingredient = 2 where use_ingredient = 1";
			stmt5 = MainController.getDbController().getConnection().createStatement();
			stmt5.executeUpdate(sql);
			
			isSuccess = true;
//			MainController.getDbController().getConnection().commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
//			try {
//				MainController.getDbController().getConnection().rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
		} finally {
			if(stmt5 != null){try {stmt5.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt4 != null){try {pstmt4.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs4 != null){try {rs4.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt4 != null){try {stmt4.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs3 != null){try {rs3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt3 != null){try {pstmt3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs2 != null){try {rs2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt3 != null){try {stmt3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try {pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt2 != null){try {stmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs1 != null){try {rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt1 != null){try {stmt1.close();} catch (SQLException e) {e.printStackTrace();}}
			
//			try {
//				MainController.getDbController().getConnection().setAutoCommit(true);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			
		}

		return isSuccess;

	}

}

package productPayment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import productPayment.vo.ProductPayment;

public class ProductPaymentDao {

	// 주문 된 상품 결제처리
	public void payment(int paymentMethod) {

		Statement stmt1 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ArrayList<ProductPayment> paymentList = new ArrayList<ProductPayment>();

		// 결제 처리가 안된 주문 데이터 가져오기
		try {

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

				sql = "insert into product_pay_list values(product_pay_number_seq.nextval, ?, ?)";
				pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt1.setInt(1, paymentList.get(i).getProductOrderNumber());
				pstmt1.setInt(2, paymentList.get(i).getPaymentNumber());

			}

			// 주문한 만큼 쿠폰 수 올려주기
			sql = "update user_list set coupon_count = ? where userNumber = ?";
			pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try {pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs1 != null){try {rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt1 != null){try {stmt1.close();} catch (SQLException e) {e.printStackTrace();}}
		}

	}


	// 결제된 정보 리스트 가져가기 (유저 핸드폰번호를 이용하여 검색)



}

package productPayment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import productPayment.vo.ProductPayment;

public class ProductPaymentDao {


	// 주문 상품 데이터를 결제 데이터베이스에 저장하기
	public void insertOrderData(ProductPayment productPayment) {

		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "insert into product_pay_list values(product_pay_number_seq.nextval, ?)";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, productPayment.getProductOrderNumber());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
		}
		
	}


	//주문 상품 리스트 가져오기
	public ArrayList<ProductPayment> productPaymentList() {

		ArrayList<ProductPayment> productPaymentList = new ArrayList<ProductPayment>();
		Statement stmt = null;
		ResultSet rs = null;

		try{

			String sql = "select * from product_order_list_view ";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				ProductPayment productPayment = new ProductPayment();
				productPayment.setProductOrderNumber(rs.getInt(1));
				productPayment.setProductNumber(rs.getInt(2));
				productPayment.setProductName(rs.getString(3));
				productPayment.setProductPrice(rs.getInt(4));
				productPayment.setUserNumber(rs.getInt(5));
				productPayment.setPaymentCount(rs.getInt(6));
				productPayment.setPaymentMethod(rs.getInt(7));
				productPayment.setPaymentDate(rs.getDate(8));
				productPaymentList.add(productPayment);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
		}

		return productPaymentList;

	}

}

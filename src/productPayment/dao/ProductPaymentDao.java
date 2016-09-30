package productPayment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import productOrder.repository.ProductOrderRepository;
import productPayment.vo.ProductPayment;

public class ProductPaymentDao {

	public void ProductPayment() {

		new ProductOrderRepository();
	}


	//주문상품 리스트 어레이리스트에 저장하기.
	public ArrayList<ProductPayment> orderProductList() {
	
		ArrayList<ProductPayment> orderProductList = new ArrayList<ProductPayment>();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from product_order_list_view";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				ProductPayment productpayment = new ProductPayment();
				productpayment.setProductOrderNumber(rs.getInt(1));
				productpayment.setProductNumber(rs.getInt(2));
				productpayment.setProductName(rs.getString(3));
				productpayment.setProductPrice(rs.getInt(4));
				productpayment.setUserNumber(rs.getInt(5));
				productpayment.setPaymentCount(rs.getInt(6));
				productpayment.setPaymentDate(rs.getDate(7));
				productpayment.setPaymentMethod(rs.getInt(8));
				orderProductList.add(productpayment);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
		}
		
		return orderProductList;
	}

	
	//주문상품리스트를 결제 리스트로 넣기
	public boolean orderProductInsert(ArrayList<ProductPayment> productPayments) {

		boolean success = false;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;

		try {

			for(int i = 0; i<productPayments.size(); i++){

				String sql = "insert into product_pay_list values(payment_number_seq.nextval, ?)";
				pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt1.setInt(1, productPayments.get(i).getProductOrderNumber());
				pstmt1.executeUpdate();
				
			}
			
			success = true;

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(rs1 != null){try{rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try{pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}

		}

		return success;

	}
	
	
	//페이먼트 리스트
	public ArrayList<ProductPayment> productPaymentlist() {

		ArrayList<ProductPayment> productPaymentlist = new ArrayList<ProductPayment>();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from product_pay_list";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				ProductPayment productpayment = new ProductPayment();
				
				productpayment.setPaymentListNumber(rs.getInt(1));
<<<<<<< HEAD
				productpayment.setProductOrderNumber(rs.getInt(2));
				productPaymentlist.add(productpayment);
=======
				productpayment.setProductOrderNumber(rs.getInt(2));		
				orderProductInsert.add(productpayment);
>>>>>>> refs/remotes/choiwj1012/master

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
		}
		
		return productPaymentlist;
	}
}

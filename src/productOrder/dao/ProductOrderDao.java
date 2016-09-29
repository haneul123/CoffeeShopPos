package productOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import productOrder.repository.ProductOrderRepository;
import productOrder.vo.ProductOrder;

public class ProductOrderDao {


	public void order(){

		new ProductOrderRepository();

	}


	//주문한 상품  저장 하기
	public int orderproduct(ProductOrder orderProduct) {

		int orderProcessNumber = 0;

		//수량만 증가

		if(ProductOrderRepository.getProductOrders().size() == 0){

			ProductOrderRepository.getProductOrders().add(orderProduct);

		}else{

			for(int i=0; i<ProductOrderRepository.getProductOrders().size(); i++) {

				if(ProductOrderRepository.getProductOrders().get(i).getProductNumber() == orderProduct.getProductNumber()) {		
					ProductOrderRepository.getProductOrders().get(i).setOrderCount(orderProduct.getOrderCount());
					orderProcessNumber = 1;

				}else {

					ProductOrderRepository.getProductOrders().add(orderProduct);

				}
			}
		}

		return orderProcessNumber;

	}


	//주문상품을 주문 리스트에 넣기
	public boolean orderProductInsert(ProductOrder orderProduct) {

		boolean success = false;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int userNumber = 0;	
		ResultSet rs1 = null;

		try {

			String sql = "select user_number from user_list where user_phone_number = ?";
			pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt1.setString(1, orderProduct.getUserPhoneNumber());
			rs1 = pstmt1.executeQuery();	

			if(rs1.next()){

				userNumber = rs1.getInt(1);
			
			}

			for(int i = 0; i<ProductOrderRepository.getProductOrders().size(); i++){

				sql = "insert into product_order_list values(product_order_number_seq.nextval,?,?,?,sysdate) ";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, userNumber);
				pstmt2.setInt(2, ProductOrderRepository.getProductOrders().get(i).getProductNumber());
				pstmt2.setInt(3, ProductOrderRepository.getProductOrders().get(i).getOrderCount());
				pstmt2.executeUpdate();
				success = true;
			}


		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(rs1 != null){try{rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try{pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}

		}

		ProductOrderRepository.getProductOrders().clear();
		ProductOrderRepository.setLastProductOrderNumber(0);

		return success;

	}


	//주문 상품 리스트 가져오기

	public  ArrayList<ProductOrder> productOrderList() {

		ArrayList<ProductOrder> productOrderList = new ArrayList<ProductOrder>();
		Statement stmt = null;
		ResultSet rs = null;
		

		try{

			String sql = "select * from product_order_list_view ";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				
				ProductOrder productOrder = new ProductOrder();
				productOrder.setProductOrderNumber(rs.getInt(1));
				productOrder.setUserNumber(rs.getInt(2));
				productOrder.setProductNumber(rs.getInt(3));
				productOrder.setProductName(rs.getString(4));
				productOrder.setOrderCount(rs.getInt(5));
				productOrder.setOrderDate(rs.getDate(6));
				productOrderList.add(productOrder);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
		}

		return productOrderList;

	}


	public  ArrayList<ProductOrder> productOrders() {

		ArrayList<ProductOrder> productOrders = ProductOrderRepository.getProductOrders();

		return productOrders;

	}

}

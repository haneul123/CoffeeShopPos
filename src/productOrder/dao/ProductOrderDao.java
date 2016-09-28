package productOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			
		} else {
			
			ProductOrderRepository.getProductOrders().add(orderProduct);				
			ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber()).setProductNumber(orderProduct.getProductNumber());
			ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber()).setOrderCount(orderProduct.getOrderCount());
			ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber()).setUserPhoneNumber(orderProduct.getUserPhoneNumber());
			ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber() +1 );
		
		}
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


public  ArrayList<ProductOrder> productOrders() {

	ArrayList<ProductOrder> productOrders = ProductOrderRepository.getProductOrders();

	return productOrders;

}

}

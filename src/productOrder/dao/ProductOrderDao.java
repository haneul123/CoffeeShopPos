package productOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mainController.MainController;
import productOrder.repository.ProductOrderRepository;
import productOrder.vo.ProductOrder;

public class ProductOrderDao {

	
	public void order(){
		
		new ProductOrderRepository();
		
	}
	
	
	//주문한 상품 오더에 저장 하기
	public int orderInProduct(ProductOrder orderProduct) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
				ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber()).setProductOrderNumber(ProductOrderRepository.getLastProductOrderNumber() + 1);
				ProductOrderRepository.getProductOrders().get(ProductOrderRepository.getLastProductOrderNumber())
				
			}
		}
	}
	
}

package productOrder.repository;

import java.util.ArrayList;

import productOrder.vo.ProductOrder;

public class ProductOrderRepository {
	
	static private ArrayList<ProductOrder> productOrders = new ArrayList<ProductOrder>();
	static private int lastProductOrderNumber;
	
	
	public ProductOrderRepository() {
		
	}


	public static ArrayList<ProductOrder> getProductOrders() {
		return productOrders;
	}


	public static void setProductOrders(ArrayList<ProductOrder> productOrders) {
		ProductOrderRepository.productOrders = productOrders;
	}


	public static int getLastProductOrderNumber() {
		return lastProductOrderNumber;
	}


	public static void setLastProductOrderNumber(int lastProductOrderNumber) {
		ProductOrderRepository.lastProductOrderNumber = lastProductOrderNumber;
	}
	
	
	

}

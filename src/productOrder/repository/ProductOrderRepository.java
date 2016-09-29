package productOrder.repository;

import java.util.ArrayList;

import productOrder.vo.ProductOrder;
import productPayment.vo.ProductPayment;

public class ProductOrderRepository {
	
	static private ArrayList<ProductOrder> productOrders = new ArrayList<ProductOrder>();
	static private ArrayList<ProductPayment> productPayment = new ArrayList<ProductPayment>();
	static private int lastProductOrderNumber;
	
	
	public static ArrayList<ProductPayment> getProductPayment() {
		return productPayment;
	}


	public static void setProductPayment(ArrayList<ProductPayment> productPayment) {
		ProductOrderRepository.productPayment = productPayment;
	}


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

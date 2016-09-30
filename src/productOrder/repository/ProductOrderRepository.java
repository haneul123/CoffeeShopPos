package productOrder.repository;

import java.util.ArrayList;

import productOrder.vo.ProductOrder;
import productPayment.vo.ProductPayment;

public class ProductOrderRepository {

	// variable
	static private ArrayList<ProductOrder> productOrders = new ArrayList<ProductOrder>();
	static private ArrayList<ProductPayment> productPayment = new ArrayList<ProductPayment>();

	// constructor
	public ProductOrderRepository() {

	}
	
	// getter and setter
	public static ArrayList<ProductOrder> getProductOrders() {
		return productOrders;
	}

	public static void setProductOrders(ArrayList<ProductOrder> productOrders) {
		ProductOrderRepository.productOrders = productOrders;
	}

	public static ArrayList<ProductPayment> getProductPayment() {
		return productPayment;
	}

	public static void setProductPayment(ArrayList<ProductPayment> productPayment) {
		ProductOrderRepository.productPayment = productPayment;
	}

}

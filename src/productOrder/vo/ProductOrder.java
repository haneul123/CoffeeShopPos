package productOrder.vo;

import java.sql.Date;

public class ProductOrder {

	// variable
	private int productOrderNumber;
	private int productNumber;
	private String productName;
	private int productPrice;
	private int userNumber;
	private int orderCount;
	private int orderSum;
	private Date orderDate;
	private int payment;
	private String userPhoneNumber;
	
	
	// constructor
	public ProductOrder() {
		
		
	}
	
	
	public ProductOrder(int productNumber, int orderCount, String userPhoneNumber) {
		
		this.productNumber = productNumber;
		this.orderCount = orderCount;
		this.userPhoneNumber = userPhoneNumber;
		
	}


	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public int getProductOrderNumber() {
		return productOrderNumber;
	}


	public void setProductOrderNumber(int productOrderNumber) {
		this.productOrderNumber = productOrderNumber;
	}


	public int getProductNumber() {
		return productNumber;
	}


	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public int getUserNumber() {
		return userNumber;
	}


	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}


	public int getOrderCount() {
		return orderCount;
	}


	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}


	public int getOrderSum() {
		return orderSum;
	}


	public void setOrderSum(int orderSum) {
		this.orderSum = orderSum;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public int getPayment() {
		return payment;
	}


	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	
	

		
}

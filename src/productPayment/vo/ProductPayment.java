package productPayment.vo;

import java.sql.Date;

public class ProductPayment {

	
	// variable
	private int productPayNumber;
	private int productOrderNumber;
	private int paymentNumber;
	private int userNumber;
	private int productNumber;
	private int orderCount;
	private Date orderDate;

	
	// constructor
	public ProductPayment() {
		
		
	}
	
	
	// getter and setter
	public int getProductPayNumber() {
		return productPayNumber;
	}
	
	public void setProductPayNumber(int productPayNumber) {
		this.productPayNumber = productPayNumber;
	}
	
	public int getProductOrderNumber() {
		return productOrderNumber;
	}
	
	public void setProductOrderNumber(int productOrderNumber) {
		this.productOrderNumber = productOrderNumber;
	}
	
	public int getPaymentNumber() {
		return paymentNumber;
	}
	
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	
	public int getUserNumber() {
		return userNumber;
	}
	
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	public int getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	
	public int getOrderCount() {
		return orderCount;
	}
	
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}

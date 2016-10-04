package productOrder.vo;

import java.sql.Date;

public class ProductOrder {

	// variable
	private int productOrderNumber;
	private int userNumber;	
	private int productNumber;
	private String productName;
	private int productPrice;
	private int orderCount;
	private Date orderDate;
	private int totalPrice;
	
	// constructor
	public ProductOrder() {
	
	}
	
	// 주문 시 생성되는 생성자
	public ProductOrder(int userNumber, int productNumber, int orderCount) {
		
		this.userNumber = userNumber;
		this.productNumber = productNumber;
		this.orderCount = orderCount;
		
	}
		
	// getter and setter
	public int getProductOrderNumber() {
		return productOrderNumber;
	}

	public void setProductOrderNumber(int productOrderNumber) {
		this.productOrderNumber = productOrderNumber;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
		
}

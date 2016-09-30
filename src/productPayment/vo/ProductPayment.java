package productPayment.vo;

import java.sql.Date;

public class ProductPayment {

	
	// variable
	private int paymentListNumber;
	private int productOrderNumber;
	private int productNumber;
	private String productName;
	private int productPrice;
	private int userNumber;
	private String userPhoneNumber;
	private int PaymentCount;
	private int paymentMethod;
	private Date paymentDate;	
	private int totalPrice;
	private int realPrice;

	
	// constructor
	public ProductPayment() {

	}

	
	// getter and setter
	public int getPaymentListNumber() {
		return paymentListNumber;
	}


	public void setPaymentListNumber(int paymentListNumber) {
		this.paymentListNumber = paymentListNumber;
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


	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public int getPaymentCount() {
		return PaymentCount;
	}


	public void setPaymentCount(int paymentCount) {
		PaymentCount = paymentCount;
	}


	public int getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getRealPrice() {
		return realPrice;
	}


	public void setRealPrice(int realPrice) {
		this.realPrice = realPrice;
	}

}

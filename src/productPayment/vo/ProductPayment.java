package productPayment.vo;

import java.sql.Date;

public class ProductPayment {

	private int paymentListNumber;
	private int productOrderNumber;
	private int productNumber;
	private int userNumber;
	private String productName;
	private int PaymentCount;
	private int paymentMethod;
	private Date paymentDate;
	private int productPrice;


	public ProductPayment() {

	}

	public ProductPayment(int productOrderNumber, int productNumber, int userNumber, String productName, int PaymentCount, int paymentMethod, Date paymentDate, int productPrice) {

		this.productOrderNumber = productOrderNumber;
		this.productNumber = productNumber;
		this.userNumber = userNumber;
		this.productName = productName;
		this.PaymentCount = PaymentCount;
		this.paymentMethod = paymentMethod;
		this.productPrice = productPrice;
		this.paymentDate = paymentDate;		

	}
	
	public int getProductOrderNumber() {
		return productOrderNumber;
	}


	public void setProductOrderNumber(int productOrderNumber) {
		this.productOrderNumber = productOrderNumber;
	}


	public int getPaymentListNumber() {
		return paymentListNumber;
	}


	public void setPaymentListNumber(int paymentListNumber) {
		this.paymentListNumber = paymentListNumber;
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





}

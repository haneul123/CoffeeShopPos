package productOrder.vo;

public class ProductOrder {

	// variable
	private int productOrderNumber;
	private int userNumber;
	private int productNumber;
	private int orderCount;
	private int paymentMethod;
	
	
	// constructor
	public ProductOrder(int userNumber, int productNumber, int orderCount, int paymentMethod) {
		
		this.userNumber = userNumber;
		this.productNumber = productNumber;
		this.orderCount = orderCount;
		this.paymentMethod = paymentMethod;
		
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

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}

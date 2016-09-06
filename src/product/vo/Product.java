package product.vo;

public class Product {
	
	
	private int prductNumber;
	private String productName;
	private int price;
	private int cost;
	private String irgredient1;
	private String irgredient2;
	private String irgredient3;
	private String irgredient4;
	
	
	public Product(){
		
		
	}
	
	public Product(String productName, int price, int cost, String irgredient1,
					String irgredient2, String irgredient3, String irgredient4){
		
		
		this.prductNumber = prductNumber;
		this.productName = productName;
		this.price = price;
		this.cost = cost;
		this.irgredient1 = irgredient1;
		this.irgredient2 = irgredient2;
		this.irgredient3 = irgredient3;
		this.irgredient4 = irgredient4;	
			
	}

	public int getPrductNumber() {
		return prductNumber;
	}

	public void setPrductNumber(int prductNumber) {
		this.prductNumber = prductNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getIrgredient1() {
		return irgredient1;
	}

	public void setIrgredient1(String irgredient1) {
		this.irgredient1 = irgredient1;
	}

	public String getIrgredient2() {
		return irgredient2;
	}

	public void setIrgredient2(String irgredient2) {
		this.irgredient2 = irgredient2;
	}

	public String getIrgredient3() {
		return irgredient3;
	}

	public void setIrgredient3(String irgredient3) {
		this.irgredient3 = irgredient3;
	}

	public String getIrgredient4() {
		return irgredient4;
	}

	public void setIrgredient4(String irgredient4) {
		this.irgredient4 = irgredient4;
	}
	
	
	
}

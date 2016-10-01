package product.vo;

public class Product {
	
	private int productNumber;
	private String productName;
	private int productPrice;
	private String productComment;
	private int productIngredientNumber;
	private int useAmount;
	
	
	public Product() {
		
	}
	
	
	//상품등록
	public Product(String productName, int productPrice, String productComment) {
		
		this.productName = productName;
		this.productPrice = productPrice;
		this.productComment = productComment;
		
	}

	
	//상품수정
	public Product(int productNumber, String productName, int productPrice, String productComment) {
		
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productComment = productComment;
		
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


	public String getProductComment() {
		return productComment;
	}


	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}


	public int getProductIngredientNumber() {
		return productIngredientNumber;
	}


	public void setProductIngredientNumber(int productIngredientNumber) {
		this.productIngredientNumber = productIngredientNumber;
	}


	public int getUseAmount() {
		return useAmount;
	}


	public void setUseAmount(int useAmount) {
		this.useAmount = useAmount;
	}

}

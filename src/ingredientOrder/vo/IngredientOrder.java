package ingredientOrder.vo;

import java.sql.Date;

public class IngredientOrder {

	private int ingredientOrderNumber;
	private int adminNumber;	
	private int ingredientNumber;
	private String ingredientName;
	private int ingredientPrice;
	private int orderCount;
	private Date orderDate;
	private int totalPrice;
	private String adminId;
	
	
	public IngredientOrder() {
	
	}
	
	
	// 주문 시 생성되는 생성자
	public IngredientOrder(String adminId, int ingredientNumber, int orderCount) {
		
		this.adminId = adminId;
		this.ingredientNumber = ingredientNumber;
		this.orderCount = orderCount;
		
	}


	public int getIngredientOrderNumber() {
		return ingredientOrderNumber;
	}


	public void setIngredientOrderNumber(int ingredientOrderNumber) {
		this.ingredientOrderNumber = ingredientOrderNumber;
	}


	public int getAdminNumber() {
		return adminNumber;
	}


	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}


	public int getIngredientNumber() {
		return ingredientNumber;
	}


	public void setIngredientNumber(int ingredientNumber) {
		this.ingredientNumber = ingredientNumber;
	}


	public String getIngredientName() {
		return ingredientName;
	}


	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}


	public int getIngredientPrice() {
		return ingredientPrice;
	}


	public void setIngredientPrice(int ingredientPrice) {
		this.ingredientPrice = ingredientPrice;
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

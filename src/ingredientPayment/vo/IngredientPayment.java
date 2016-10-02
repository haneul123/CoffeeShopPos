package ingredientPayment.vo;

public class IngredientPayment {

	// variable
	private int ingredietnOrderpayNumber;
	private int ingredientOrderNumber;
	private int ingredientInventory;
	private int ingredientOrderCount;
	private int ingredientNumber;


	// constructor
	public IngredientPayment() {

	}

	
	public IngredientPayment (int ingredietnOrderpayNumber,int ingredientOrderNumber,int ingredientInventory,int ingredientOrderCount) {

		this.ingredietnOrderpayNumber = ingredietnOrderpayNumber;
		this.ingredientOrderNumber = ingredientOrderNumber;
		this.ingredientInventory = ingredientInventory;
		this.ingredientOrderCount = ingredientOrderCount;

	}
	
	
	public IngredientPayment (int ingredietnOrderpayNumber,int ingredientOrderCount) {

		this.ingredietnOrderpayNumber = ingredietnOrderpayNumber;
		this.ingredientOrderCount = ingredientOrderCount;

	}
	
	
	// getter and setter
	public int getIngredietnOrderpayNumber() {
		return ingredietnOrderpayNumber;
	}

	public void setIngredietnOrderpayNumber(int ingredietnOrderpayNumber) {
		this.ingredietnOrderpayNumber = ingredietnOrderpayNumber;
	}

	public int getIngredientOrderNumber() {
		return ingredientOrderNumber;
	}

	public void setIngredientOrderNumber(int ingredientOrderNumber) {
		this.ingredientOrderNumber = ingredientOrderNumber;
	}

	public int getIngredientInventory() {
		return ingredientInventory;
	}

	public void setIngredientInventory(int ingredientInventory) {
		this.ingredientInventory = ingredientInventory;
	}

	public int getIngredientOrderCount() {
		return ingredientOrderCount;
	}

	public void setIngredientOrderCount(int ingredientOrderCount) {
		this.ingredientOrderCount = ingredientOrderCount;
	}

	public int getIngredientNumber() {
		return ingredientNumber;
	}

	public void setIngredientNumber(int ingredientNumber) {
		this.ingredientNumber = ingredientNumber;
	}

}

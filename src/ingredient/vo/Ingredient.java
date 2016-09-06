package ingredient.vo;

public class Ingredient {

	
	// variable
	private int ingredientNumber;
	private String ingredientName;
	private int ingredientQuentity;
	private int optimalStorageLevel;
	private int unitCost;
	
	
	// constructor
	public Ingredient() {
	
	
	}


	// getter and setter
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

	public int getIngredientQuentity() {
		return ingredientQuentity;
	}

	public void setIngredientQuentity(int ingredientQuentity) {
		this.ingredientQuentity = ingredientQuentity;
	}

	public int getOptimalStorageLevel() {
		return optimalStorageLevel;
	}

	public void setOptimalStorageLevel(int optimalStorageLevel) {
		this.optimalStorageLevel = optimalStorageLevel;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
	
}

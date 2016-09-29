package ingredient.vo;

public class Ingredient {

	
	// variable
	private int ingredient_Number;
	private String ingredient_Name;
	private int ingredient_Price;
	private int ingreient_Inventory;
	private int ingredient_Inventory_MAX;
	private String ingredient_unit;	  

	// constructor
	public Ingredient() {
	
	
	}

	// 원재료 등록시 사용되는 생성자
	public Ingredient(String ingredient_Name, int ingredient_Price, int ingredient_Inventory_MAX, String ingredient_unit) {
		
		this.ingredient_Name = ingredient_Name;
		this.ingredient_Price = ingredient_Price;
		this.ingredient_Inventory_MAX = ingredient_Inventory_MAX;
		this.ingredient_unit = ingredient_unit;
		
	}


	// 원재료 검색시 사용되는 생성자
	public Ingredient(String searchName) {
		
		this.ingredient_Name = searchName;
		
	}

	// getter and setter
	public String getIngredient_Name() {
		
		return ingredient_Name;
		
	}


	public void setIngredient_Name(String ingredient_Name) {
		
		this.ingredient_Name = ingredient_Name;
		
	}


	public int getIngredient_Price() {
		
		return ingredient_Price;
	}


	public void setIngredient_Price(int ingredient_Price) {
		
		this.ingredient_Price = ingredient_Price;
		
	}


	public int getIngreient_Inventory() {
		
		return ingreient_Inventory;
		
	}


	public void setIngreient_Inventory(int ingreient_Inventory) {
		
		this.ingreient_Inventory = ingreient_Inventory;
		
	}


	public int getIngredient_Inventory_MAX() {
		
		return ingredient_Inventory_MAX;
		
	}


	public void setIngredient_Inventory_MAX(int ingredient_Inventory_MAX) {
		
		this.ingredient_Inventory_MAX = ingredient_Inventory_MAX;
		
	}


	public int getIngredient_Number() {
		
		return ingredient_Number;
		
	}
	

	public void setIngredient_Number(int ingredient_Number) {
		
		this.ingredient_Number = ingredient_Number;
		
	}
	

	public String getIngredient_unit() {
		
		return ingredient_unit;
		
	}
	

	public void setIngredient_unit(String ingredient_unit) {
		
		this.ingredient_unit = ingredient_unit;
		
	}
	
}

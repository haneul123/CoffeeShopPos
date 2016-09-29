package ingredient.view;

import java.util.Scanner;

import ingredient.vo.Ingredient;

public class AddIngredientView {

	private Scanner keyboard;

	public AddIngredientView() {

		this.keyboard = new Scanner(System.in);

	}

	// 원재료 등록
	public Ingredient insertIngredientView() {

		System.out.println("[재고관리] 원재료 관리 모드 입니다.");
		System.out.print("원재료 명 : ");
		String ingredient_Name = keyboard.next();
		System.out.print("원재료 가격(단위당) : ");
		int ingredient_Price = keyboard.nextInt();
		System.out.print("원재료 MAX 용량 : ");
		int ingredient_Inventory_MAX = keyboard.nextInt();
		System.out.println("단위입력(g, Kg, ml) :");
		String ingredient_unit = keyboard.next();

		Ingredient ingredients = new Ingredient(ingredient_Name, ingredient_Price, ingredient_Inventory_MAX, ingredient_unit);

		return ingredients;
	}

}

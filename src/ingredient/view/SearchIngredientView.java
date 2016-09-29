package ingredient.view;

import java.util.Scanner;

import ingredient.vo.Ingredient;
import mainView.AlertView;

public class SearchIngredientView {
	
	private Scanner keyboard;
	
	public SearchIngredientView() {
		
		keyboard = new Scanner(System.in);
	}
	
	public Ingredient searchIngredient() {
		
		new AlertView().alert("원재료 검색 모드 입니다.");
		System.out.println("찾으시는 원재료 이름을 입력 하세요.");
		System.out.print("원재료 명 : ");
		String searchName = keyboard.next();
		
		Ingredient getName = new Ingredient(searchName);
		
		return getName;
	}

}

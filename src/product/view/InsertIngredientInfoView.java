package product.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;
import product.vo.Product;

public class InsertIngredientInfoView {

	// variable
	private Scanner keyboard;

	// constructor
	public InsertIngredientInfoView() {

		this.keyboard = new Scanner(System.in);

	}


	// 원재료 체크
	public void insertIngredientInfoView(Product insertProduct) {

		int selectedIngredient = 0;
		int useAmount = 0;
		ArrayList<Product> ingredientList = new ArrayList<Product>();

		while(true){

			Product ingredient = new Product();
			MainController.getIngredientController().requestListIngredient();
		
			try{
				
				System.out.println("사용할 원재료 번호를 입력해 주세요. 등록이 완료되었으면 0을 눌러주세요");
				selectedIngredient = keyboard.nextInt();
				
				if(selectedIngredient == 0){
					break;
				}
				
				System.out.println("사용되는 양을 입력해 주세요.");
				useAmount = keyboard.nextInt();	
				
			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다. 숫자를 입력하십시오");
			}
							
			ingredient.setProductIngredientNumber(selectedIngredient);
			ingredient.setUseAmount(useAmount);
			
			// 배열에 삽입 전에 올바른 원재료 번호인지 체크
			MainController.getProductController().requestCheckIngredientNumber(ingredient);
			
			ingredientList.add(ingredient);

		}
		
		MainController.getProductController().requestInsertProduct(insertProduct, ingredientList);
		
	}
}

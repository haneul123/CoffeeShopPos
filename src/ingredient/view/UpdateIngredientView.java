package ingredient.view;

import java.util.Scanner;
import ingredient.vo.Ingredient;
import mainController.MainController;

public class UpdateIngredientView {
	
	private Scanner keyboard;
	
	
	public UpdateIngredientView() {

		this.keyboard = new Scanner(System.in);

	}
	
	
	// 수정할 원재료 번호 입력 받기
		public void updateingredientNumberView(){

			System.out.println("상품수정 모드입니다");
			System.out.println("수정을 원하시는 원재료 번호를 선택하십시오");
			int selectedIngredientNumber = keyboard.nextInt();
			
			MainController.getIngredientController().requestIngredientUpdateInfo(selectedIngredientNumber);
		}

		// 원재료 수정 정보 입력
		public void updateProductInfo(int selectedIngredientNumber) {

			String ingredientName = null;
			int ingredientPrice = 0;
			int ingredientInventoryMax = 0;
			String ingredientUnit = null;
			
			while(true){

				System.out.println("변경을 원하시는 메뉴를 선택하십시오");
				System.out.println("[1]재고이름 [2]재고원가 [3]최대적재량 [4]원재료 단위 [5]이전");
				int selectedMenu = keyboard.nextInt();

				if(selectedMenu == 1){

					System.out.println("수정할 원재료 이름 : ");
					ingredientName = keyboard.next();

				} else if(selectedMenu == 2){

					System.out.println("수정할 원재료 가격 : ");
					ingredientPrice = keyboard.nextInt();

				} else if(selectedMenu == 3){

					System.out.println("수정할 원재료 최대적재량 : ");
					ingredientInventoryMax = keyboard.nextInt();

				} else if(selectedMenu == 4){

					System.out.println("수정할 원재료 단위 : ");
					ingredientUnit = keyboard.next();

				} else if(selectedMenu == 5){

					break;
					
				} else {

					System.out.println("잘못 입력하셨습니다");
				

				}

				Ingredient updateIngredient = new Ingredient(selectedIngredientNumber,ingredientName, ingredientPrice, ingredientInventoryMax, ingredientUnit);
				MainController.getIngredientController().requestUpdateIngredient(updateIngredient);

			}

		}


}

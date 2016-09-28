package ingredient.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class IngredientMainMenu {

	private Scanner keyboard;

	public IngredientMainMenu() {
		keyboard = new Scanner(System.in);
	}

	public void ingredientMenu() {

		System.out.println("[재고관리 메뉴]");

		String[] ingredMenu = {"1.재고등록, 2.재고수정, 3.재고조회, 4.재고삭제"};

		for(int i = 0; i < ingredMenu.length; i++) {

			System.out.print(ingredMenu[i] + "/t");

		}
		

		while(true) {

			try {

				System.out.print("메뉴선택 : ");
				int selectedMenu = keyboard.nextInt();

				if(selectedMenu == 1) {

					System.out.println("재고등록을 선택 하셨습니다.");
					MainController.getIngredientController().requestAddIngredient();

				}else if(selectedMenu == 2) {

					System.out.println("재고수정을 선택 하셨습니다.");
					// MainController.getIngredientController().requestAddIngredient();

				}else if(selectedMenu == 3) {

					System.out.println("재고조회을 선택 하셨습니다.");
					// MainController.getIngredientController().requestAddIngredient();

				}else if(selectedMenu == 4) {

					System.out.println("재고삭제를 선택 하셨습니다.");
					// MainController.getIngredientController().requestAddIngredient();

				}else {

					System.out.println("메뉴를 잘못 선택 하셨습니다.");

				}
				
			} catch (InputMismatchException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}


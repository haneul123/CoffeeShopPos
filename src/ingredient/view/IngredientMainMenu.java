package ingredient.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;
import mainView.AlertView;

public class IngredientMainMenu {

	private Scanner keyboard;

	public IngredientMainMenu() {

		keyboard = new Scanner(System.in);
	}

	public void ingredientMenu() {


		while(true) {

			try {

				int selectedMenu = 0;
				System.out.println("[재고관리 메뉴]");
				System.out.println("[1]재고등록  [2]재고수정  [3]재고조회  [4]재고삭제  [5]재고목록  [6]재고주문  [7]나가기");

				System.out.print("메뉴선택 : ");
				selectedMenu = keyboard.nextInt();

				if(selectedMenu == 1) {

					System.out.println("재고등록을 선택 하셨습니다.");
					MainController.getIngredientController().requertAddInfredientView();

				}else if(selectedMenu == 2) {

					System.out.println("재고수정을 선택 하셨습니다.");
					 MainController.getIngredientController().requestIngredientUpdateNumber();

				}else if(selectedMenu == 3) {

					System.out.println("재고조회을 선택 하셨습니다.");
					MainController.getIngredientController().requestSearchIngredient();

				}else if(selectedMenu == 4) {

					System.out.println("재고삭제를 선택 하셨습니다.");
					MainController.getIngredientController().requerstDeleteIngredientView();

				}else if(selectedMenu == 5) {

					System.out.println("재고목록을 선택 하셨습니다.");
					MainController.getIngredientController().requestListIngredient();

				}else if(selectedMenu == 6) {

					MainController.getIngredientOrderController().requestIngredientOrderMainMenuView();
					
				}else if(selectedMenu == 7) {

					MainController.getAdminController().requestMainMenuView();
					
				} else {

					System.out.println("메뉴를 잘못 선택 하셨습니다.");
					MainController.getIngredientController().requestIngredientMainMenu();

				}

			} catch (InputMismatchException e) {
				new AlertView().alert("잘못입력하셨습니다.");
				MainController.getIngredientController().requestIngredientMainMenu();
			}
		}
	}

}

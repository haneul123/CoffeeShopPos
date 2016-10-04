package ingredientOrder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import ingredientOrder.vo.IngredientOrder;
import mainController.MainController;

public class IngredientOrderView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public IngredientOrderView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// 주문 정보 입력 받기
	public void orderingredientView() {

		int ingredientNumber = 0;
		int orderCount = 0;
		
		try{
			
			System.out.println("관리자의 아이디를 입력하세요.");
			String adminId = keyboard.next();


			System.out.println("주문하실 원재료의 번호를 입력하세요.");
			ingredientNumber = keyboard.nextInt();

			System.out.println("몇개 주문하시겠습니까?");
			orderCount = keyboard.nextInt();
			
			IngredientOrder orderingredient = new IngredientOrder(adminId, ingredientNumber, orderCount);

			MainController.getIngredientOrderController().requestOrderIngredient(orderingredient);

		}catch(InputMismatchException e){	
			System.err.println("잘못입력하셨습니다. 다시 입력해 주십시오");		
		}
	}
}

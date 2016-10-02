package productOrder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;
import productOrder.vo.ProductOrder;

public class ProductOrderView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public ProductOrderView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// 주문 정보 입력 받기
	public void orderProductView(int userNumber) {

		int productNumber = 0;
		int orderCount = 0;
		
		try{

			System.out.println("주문하실 상품의 번호를 입력하세요.");
			productNumber = keyboard.nextInt();

			System.out.println("몇개 주문하시겠습니까?");
			orderCount = keyboard.nextInt();
			
			ProductOrder orderProduct = new ProductOrder(userNumber, productNumber, orderCount);

			MainController.getIngredientController().requestCheckIngredient(orderProduct);

		}catch(InputMismatchException e){	
			System.err.println("잘못입력하셨습니다. 다시 입력해 주십시오");		
		}
	}
}

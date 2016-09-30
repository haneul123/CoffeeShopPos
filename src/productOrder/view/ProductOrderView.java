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
	
	
	//주문 번호 수량 받기
	public void orderProductView() {

		int selectedProductNumber = 0;
		int orderProductCount = 0;
		String userPhoneNumber = null;
		int selectPaymentMethod = 0;
		
		try{

			System.out.println("주문하실 상품의 번호를 입력하세요.");
			selectedProductNumber = keyboard.nextInt();

			System.out.println("몇개 주문하시겠습니까?");
			orderProductCount = keyboard.nextInt();
			
			System.out.println("회원 전화번호를 입력하세요");
			userPhoneNumber = keyboard.next();
			
			System.out.println("결제 방법을 입력하세요");
			System.out.println("[1]카드  [2]현금");
			selectPaymentMethod = keyboard.nextInt();

			ProductOrder orderProduct = new ProductOrder(selectedProductNumber, orderProductCount, userPhoneNumber, selectPaymentMethod);

			MainController.getProductOrderController().requestOrderProduct(orderProduct);

		}catch(InputMismatchException e){	
			
			System.err.println("잘못입력하셨습니다");		
		}
	}
}

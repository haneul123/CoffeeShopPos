package productOrder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;
import productOrder.vo.ProductOrder;

public class ProductOrderView {

	private Scanner keyboard;
	
	
	public ProductOrderView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	//주문 번호 수량 받기
	public void orderProductView() {

		try{

			System.out.println("주문하실 상품의 번호를 입력하세요.");
			int selectedProductNumber = keyboard.nextInt();

			System.out.println("몇개 주문하시겠습니까?");
			int orderProductCount = keyboard.nextInt();
			
			System.out.println("회원 전화번호를 입력하세요");
			String userPhoneNumber = keyboard.next();

			ProductOrder orderProduct = new ProductOrder(selectedProductNumber, orderProductCount, userPhoneNumber);

			MainController.getProductOrderController().requestOrderProduct(orderProduct);

		}catch(InputMismatchException e){	
			
			System.err.println("잘못입력하셨습니다");		
		}
	}
	
	
}

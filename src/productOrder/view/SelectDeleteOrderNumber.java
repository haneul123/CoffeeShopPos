package productOrder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class SelectDeleteOrderNumber {

	
	// variable
	private Scanner keyboard;
	
	
	// constructor
	public SelectDeleteOrderNumber() {

		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// method
	// 주문 삭제할 주문 번호 받음
	public void selectDeleteOrderNumber() {

		int deleteOrderNumber = 0;
		System.out.println("주문 삭제할 번호를 입력하십시오");
		try{
			deleteOrderNumber = keyboard.nextInt();	
		} catch(InputMismatchException e) {
			System.out.println("주문 번호를 입력하셔야 합니다.");
		}
		
		MainController.getProductOrderController().requestCheckProductOrderNumber(deleteOrderNumber);
		
	}

}

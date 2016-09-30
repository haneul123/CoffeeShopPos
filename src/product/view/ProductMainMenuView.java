package product.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class ProductMainMenuView {

	// variable
	private Scanner keyboard;


	// constructor
	public ProductMainMenuView() {

		this.keyboard = new Scanner(System.in);

	}


	// method
	public void productMainMenuView() {

		int selectedMenu = 0;

		while(true){

			System.out.println("상품 관리");
			MainController.getProductController().requestProductlist();
			System.out.println("[1]상품등록  [2]상품조회  [3]상품수정  [4]상품삭제  [5]상품주문  [6]이전");
			
			try{
				selectedMenu = keyboard.nextInt();	
			} catch(InputMismatchException e){
				System.out.println("1번부터 6번까지의 숫자를 입력해주십시오");
				MainController.getProductController().requestProductMainMenu();
			}

			if (selectedMenu == 1) {

				MainController.getProductController().requestInsertProductInfo();

			} else if (selectedMenu == 2) {

				MainController.getProductController().requestSearch();

			} else if (selectedMenu == 3) {

				MainController.getProductController().requestUpdateView();

			} else if (selectedMenu == 4) {

				MainController.getProductController().requestDeleteProductNumber();

			} else if (selectedMenu == 5) {

				MainController.getProductOrderController().requestProductOrderView();

			}else if (selectedMenu == 6) {

				MainController.getProductPaymentController().requestPaymentListView();

			} else {

				System.out.println("잘못 입력하셨습니다.");

			}
		}
	}
}



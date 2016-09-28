package product.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class ProductMainMenuView {

	private Scanner keyboard;


	public ProductMainMenuView() {

		this.keyboard = new Scanner(System.in);

	}


	public void productMainMenuView() {

		try{

			while(true){


				System.out.println("상품 관리");
				
				MainController.getProductController().requestProductlist();
				
				System.out.println("[1]상품등록  [2]상품조회  [3]상품수정  [4]상품삭제  [5]상품주문  [6]이전");
				int seletedMainMenuNumber = keyboard.nextInt();
				
				if (seletedMainMenuNumber == 1) {
					
					MainController.getProductController().requestInsertProductInfo();
					
				} else if (seletedMainMenuNumber == 2) {
					
					MainController.getProductController().requestSearch();
					
				} else if (seletedMainMenuNumber == 3) {
					
					MainController.getProductController().requestUpdateView();
					
				} else if (seletedMainMenuNumber == 4) {
					
					MainController.getProductController().requestDeleteProductNumber();
					
				} else if (seletedMainMenuNumber == 5) {
					
					MainController.getProductOrderController().requestOrderListView();
					
					MainController.getProductOrderController().requestProductOrderView();
					
				}else if (seletedMainMenuNumber == 6) {
					
					MainController.getAdminController().requestMainMenuView();
									
				} else {
					
					System.out.println("잘못 입력하셨습니다.");
					MainController.getProductController().requestProductMainMenu();
					
				}
			}
			
		}catch(InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다.");
			MainController.getAdminController().requestMainMenuView();
		}
	}
	
}

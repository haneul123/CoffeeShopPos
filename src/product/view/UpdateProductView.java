package product.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import mainController.MainController;
import product.vo.Product;

public class UpdateProductView {
	
	private Scanner keyboard;
	
	
	public UpdateProductView() {

		this.keyboard = new Scanner(System.in);

	}
	
	
	// 수정할 사움 번호 입력 받기
		public void updateProductNumberView(){
			
			try{
			
			System.out.println("상품수정 모드입니다");
			System.out.println("수정을 원하시는 상품번호를 선택하십시오");
			int selectedProductNumber = keyboard.nextInt();
			MainController.getProductController().requestUpdateProductInfo(selectedProductNumber);
		
			}catch (InputMismatchException e) {
				System.out.println("잘못입력하셨습니다.");
			}
		}

	// 상품 수정 정보 입력
	public void updateProductInfo(int selectedProductNumber) {

		String updateProductName = null;
		int updateProductPrice = 0;
		String updateProductComment = null;

		while(true){
			
			System.out.println("변경을 원하시는 메뉴를 선택하십시오");
			System.out.println("[1] 상품이름 [2] 상품가격 [3]상품정보 [4] 이전");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				System.out.println("수정할 상품 이름 : ");
				updateProductName = keyboard.next();
				
			} else if(selectedMenu == 2){

				System.out.println("수정할 상품 가격 : ");
				updateProductPrice = keyboard.nextInt();
				
			} else if(selectedMenu == 3){

				System.out.println("수정할 상품 내용 : ");
				updateProductComment = keyboard.next();
				
			} else if(selectedMenu == 4){
				
				MainController.getProductController().requestProductMainMenu();
				
			} else {

				System.out.println("잘못 입력하셨습니다");
				
			}
			
			Product updateProduct = new Product(selectedProductNumber, updateProductName, updateProductPrice, updateProductComment);
			MainController.getProductController().requestUpdate(updateProduct);
			
		}
		
	}

}

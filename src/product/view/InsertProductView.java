package product.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;
import product.vo.Product;

public class InsertProductView {

	private Scanner keyboard;


	public InsertProductView() {

		this.keyboard = new Scanner(System.in);

	}


	//상품등록 뷰
	public void insertProductView() {
		
		int productPrice = 0;

		System.out.println("상품등록 모드입니다.");
		System.out.println("등록할 상품 정보를 입력해 주세요.");
		
		System.out.println("상품 이름:");
		String productName = keyboard.next();

		System.out.println("상품 가격:");
		try{
			productPrice = keyboard.nextInt();
		}catch(InputMismatchException e){
			System.out.println("숫자로 입력하셔야 합니다.");
			MainController.getProductController().requestInsertProductInfo();
		}

		System.out.println("상품 코멘트:");
		String productComment = keyboard.next();

		Product insertProduct = new Product(productName, productPrice, productComment);
		MainController.getProductController().requestInsertIngredientInfo(insertProduct);
		
	}

}

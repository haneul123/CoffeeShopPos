package product.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import mainController.MainController;

public class RemoveProductView {

	private Scanner keyboard;


	public RemoveProductView(){

		this.keyboard = new Scanner(System.in);

	}


	//삭제할 상품번호 받기
	public void deleteProductNumber() {

		int selectedProductDeleteNumber = 0;
		
		try{

			System.out.println("삭제할 번호를 입력하세요.");
			try{
				selectedProductDeleteNumber = keyboard.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("숫자를 입력해 주세요");
				deleteProductNumber();
			}
			
			MainController.getProductController().requestDelete(selectedProductDeleteNumber);

		}catch (InputMismatchException e) {
			System.out.println("잘못입력 하셨습니다.");
		}
	}
}

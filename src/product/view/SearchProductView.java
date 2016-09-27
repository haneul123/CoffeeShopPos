package product.view;

import java.util.Scanner;

import product.vo.Product;

public class SearchProductView {

	private Scanner keyboard;
	
	
	public SearchProductView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	//상품조회뷰
	public int searchProductNumber() {
		
		int searchProductNumber;
		
		System.out.println("조회하실 상품의 번호를 입력하세요.");
		searchProductNumber = keyboard.nextInt();
		
		return searchProductNumber;
		
	}
	
	
	public void printProduct(Product searchProduct){
		
		System.out.println("상품번호\t상품이름\t상품가격\t상품설명");
		
			System.out.print(searchProduct.getProductNumber() + "\t" );
			System.out.print(searchProduct.getProductName() + "\t");
			System.out.print(searchProduct.getProductPrice() + "\t");
			System.out.println(searchProduct.getProductComment());
			
	}
	
}

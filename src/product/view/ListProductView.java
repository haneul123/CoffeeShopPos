package product.view;

import java.util.ArrayList;

import product.vo.Product;

public class ListProductView {
	
	// 상품 리스트 출력하기
	public void productList(ArrayList<Product> products) {
		
		System.out.println("[상품번호]\t[상품이름]\t[상품가격]\t[상품설명]\t\t\t[판매여부]");
		
		for(int i=0; i<products.size(); i++) {
			
			System.out.print(products.get(i).getProductNumber() + "\t");
			System.out.print(products.get(i).getProductName() + "\t");
			System.out.print(products.get(i).getProductPrice() + "\t");
			System.out.print(products.get(i).getProductComment() + "\t");
			if(products.get(i).getIsDeleteProduct() == 1){
				System.out.println("판매중");	
			} else {
				System.out.println("판매중단");
			}
			
			
		}
	}

}

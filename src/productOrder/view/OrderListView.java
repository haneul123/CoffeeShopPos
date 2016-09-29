package productOrder.view;

import java.util.ArrayList;
import java.util.Scanner;

import productOrder.vo.ProductOrder;

public class OrderListView {

	private Scanner keyboard;


	public OrderListView() {

		this.keyboard = new Scanner(System.in);

	}


	// 장바구니 리스트 보기
	public void OrderListView(ArrayList<ProductOrder> productOrders) {

		if(productOrders.size() == 0){

			System.out.println("주문상품이 없습니다");
			return;

		} else {

			System.out.println("주문번호\t상품번호\t상품이름\t유저번호\t주문수량\t주문일자");
			for(int i=0; i<productOrders.size(); i++){

				System.out.print(productOrders.get(i).getProductOrderNumber() + "\t");
				System.out.print(productOrders.get(i).getProductNumber() + "\t");
				System.out.print(productOrders.get(i).getProductName() + "\t");
				System.out.print(productOrders.get(i).getUserNumber() + "\t");
				System.out.print(productOrders.get(i).getOrderCount() + "\t");
				System.out.println(productOrders.get(i).getOrderDate());

			}	

		}



	}

}

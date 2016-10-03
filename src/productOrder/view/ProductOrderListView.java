package productOrder.view;

import java.util.ArrayList;

import productOrder.vo.ProductOrder;

public class ProductOrderListView {

	
	public void productOrderListView(ArrayList<ProductOrder> orderList) {
	
		int totalOrderPrice = 0;
		System.out.println("상품 주문 내역입니다");
		System.out.println("[주문 번호]\t[주문한 상품]\t[주문 수량]\t[주문 일자]\t[주문 가격]\t[총 주문 가격]");
		
		for(int i=0; i<orderList.size(); i++){
			
			System.out.print(orderList.get(i).getProductOrderNumber() + "\t\t");
			System.out.print(orderList.get(i).getProductName() + "\t\t");
			System.out.print(orderList.get(i).getOrderCount() + "개\t\t");
			System.out.print(orderList.get(i).getOrderDate() + "\t");
			System.out.print(orderList.get(i).getProductPrice() + "원\t\t");
			System.out.println(orderList.get(i).getTotalPrice() + "원");
			totalOrderPrice = totalOrderPrice +  orderList.get(i).getTotalPrice();
			
		}
		
		System.out.println("최종 가격 : " + totalOrderPrice + "원 입니다");
		
	}

	
}

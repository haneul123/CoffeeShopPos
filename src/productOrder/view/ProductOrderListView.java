package productOrder.view;

import java.util.ArrayList;

import productOrder.vo.ProductOrder;

public class ProductOrderListView {

	
	public void productOrderListView(ArrayList<ProductOrder> orderList) {
	
		int totalOrderPrice = 0;
		System.out.println("상품 주문 내역입니다");
		System.out.println("주문 번호\t주문한 상품\t주문 수량\t주문 일자\t\t주문 가격\t총 주문 가격");
		
		for(int i=0; i<orderList.size(); i++){
			
			System.out.print(orderList.get(i).getProductOrderNumber() + "\t");
			System.out.print(orderList.get(i).getProductName() + "\t");
			System.out.print(orderList.get(i).getOrderCount() + "개\t");
			System.out.print(orderList.get(i).getOrderDate() + "\t");
			System.out.print(orderList.get(i).getProductPrice() + "원\t");
			System.out.println(orderList.get(i).getTotalPrice() + "원");
			totalOrderPrice = totalOrderPrice +  orderList.get(i).getTotalPrice();
			
		}
		
		System.out.println("최종 가격 : " + totalOrderPrice + "원 입니다");
		
	}

	
}

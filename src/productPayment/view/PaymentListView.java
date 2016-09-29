package productPayment.view;

import java.util.ArrayList;

import productPayment.vo.ProductPayment;

public class PaymentListView {

	// 장바구니 리스트 보기
	public void productOrders(ArrayList<ProductPayment> productPayments) {
		
		if(productPayments.size() == 0){

			System.out.println("주문상품이 없습니다");

		} else {

			System.out.println("주문번호\t상품번호\t상품이름\t유저번호\t주문수량\t결제방법\t주문일자");
			for(int i=0; i<productPayments.size(); i++){

				System.out.print(productPayments.get(i).getProductOrderNumber() + "\t");
				System.out.print(productPayments.get(i).getUserNumber() + "\t");
				System.out.print(productPayments.get(i).getProductName() + "\t");
				System.out.print(productPayments.get(i).getProductNumber() + "\t");
				System.out.print(productPayments.get(i).getPaymentCount() + "\t");
				System.out.print(productPayments.get(i).getPaymentMethod() + "\t");
				System.out.println(productPayments.get(i).getPaymentDate());

			}	
		}
	}
}

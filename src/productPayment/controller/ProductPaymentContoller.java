package productPayment.controller;


import java.util.ArrayList;

import mainView.AlertView;
import productPayment.dao.ProductPaymentDao;
import productPayment.view.PaymentListView;
import productPayment.vo.ProductPayment;

public class ProductPaymentContoller {

	
	// variable
	private ProductPaymentDao productPaymentDao;


	// constructor
	public ProductPaymentContoller() {

		this.productPaymentDao = new ProductPaymentDao();

	}


	// method
	// 결제 리스트 부르기
	public void requestPaymentList(){

		ArrayList<ProductPayment> orderProductList = productPaymentDao.orderProductList();
		boolean success = productPaymentDao.orderProductInsert(orderProductList);
		
		AlertView alertView = new AlertView();
		
		if(success){
		
			alertView.alert("리스트 삽입 성공");
			
		} else {
			
			alertView.alert("리스트 삽입 실패");
			
		}
		
		PaymentListView paymentListView = new PaymentListView();
		paymentListView.productOrders(orderProductList);
		
	}
	
}

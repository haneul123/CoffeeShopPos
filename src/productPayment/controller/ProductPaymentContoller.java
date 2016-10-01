package productPayment.controller;

import java.util.ArrayList;

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

	
	// 결제 데이터 베이스에 주문 데이터를 저장하기
	public void requestInsertOrderData(ProductPayment productPayment){

		productPaymentDao.insertOrderData(productPayment);

	}

	
	// 결제 리스트 뷰 요청
	public void requestPaymentList(){
		
		
	}
		
	// 결제 리스트 부르기
	public void requestPaymentListView(){

		// 결제리스트 데이터 가져오기
		ArrayList<ProductPayment> orderProductList = productPaymentDao.productPaymentList();
		PaymentListView paymentListView = new PaymentListView();
		paymentListView.productOrders(orderProductList);

	}



}

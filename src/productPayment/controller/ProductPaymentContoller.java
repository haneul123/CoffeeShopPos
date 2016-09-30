package productPayment.controller;

import java.util.ArrayList;

import mainView.AlertView;
import productPayment.dao.ProductPaymentDao;
import productPayment.view.PaymentListView;
import productPayment.vo.ProductPayment;

public class ProductPaymentContoller {
<<<<<<< HEAD
=======

	
	// variable
	private ProductPaymentDao productPaymentDao;
>>>>>>> refs/remotes/choiwj1012/master

	// variable
	private ProductPaymentDao productPaymentDao;

	// constructor
	public ProductPaymentContoller() {

		this.productPaymentDao = new ProductPaymentDao();

	}


<<<<<<< HEAD
	// 결제 리스트 부르기
	public void requestPaymentList(){

		ArrayList<ProductPayment> productPaymentlist = productPaymentDao.productPaymentlist();
		PaymentListView paymentListView = new PaymentListView();
		paymentListView.productOrders(productPaymentlist);

	}

=======
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
	
>>>>>>> refs/remotes/choiwj1012/master
}

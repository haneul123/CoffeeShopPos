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


	// 결제 리스트 부르기
	public void requestPaymentList(){

		ArrayList<ProductPayment> productPaymentlist = productPaymentDao.productPaymentlist();
		PaymentListView paymentListView = new PaymentListView();
		paymentListView.productOrders(productPaymentlist);

	}

}

package productPayment.controller;

import mainController.MainController;
import productPayment.dao.ProductPaymentDao;
import productPayment.view.ProductPaymentView;
import productPayment.view.SelectPaymentMethodView;

public class ProductPaymentContoller {


	// variable
	private ProductPaymentDao productPaymentDao;


	// constructor
	public ProductPaymentContoller() {

		this.productPaymentDao = new ProductPaymentDao();

	}

	
	// 주문한 상품을 결제할 것인지 확인
	public void requestProductPaymentView() {

		ProductPaymentView productPaymentView = new ProductPaymentView();
		productPaymentView.productPaymentView();

	}

	
	// 결제를 위한 결제방법 선택하기
	public void requestSelectPaymentMethodView(){
		
		SelectPaymentMethodView selectPaymentMethodView = new SelectPaymentMethodView();
		selectPaymentMethodView.selectPaymentMethodView();
		
	}
	
	
	// 결제 확정된 제품 결제 데이터에 저장
	public void requestInsertProductPayment(int paymentMethod){
		
		productPaymentDao.payment(paymentMethod);
		
	}
	
	
	// 결제 취소 요청
	public void requestProductPaymentDelete() {

		// 주문된 데이터를 모두 결제 취소 상태로 바꿈
		MainController.getProductOrderController().requestProductOrderAllDelete();
		
	}
	
	
	// 결제된 상품 리스트 보기
	public void requestProductPaymentListView() {



	}

}

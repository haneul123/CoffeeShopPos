package productPayment.controller;

import mainController.MainController;
import mainView.AlertView;
import productPayment.dao.ProductPaymentDao;
import productPayment.view.ProductPaymentView;
import productPayment.view.SelectPaymentMethodView;
import productPaymentRepository.ProductOrderRepository;

public class ProductPaymentContoller {


	// variable
	private ProductPaymentDao productPaymentDao;


	// constructor
	public ProductPaymentContoller() {

		this.productPaymentDao = new ProductPaymentDao();

	}

	
	// 주문한 상품을 결제할 것인지 확인
	public void requestProductPaymentView() {

		MainController.getProductOrderController().requestProductOrderListView();
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
		
		boolean success = productPaymentDao.payment(paymentMethod);
		AlertView alertView = new AlertView();
		if(success){
			
			alertView.alert("총 결제액 : " + ProductOrderRepository.getTotalPrice());
			alertView.alert("쿠폰을 반영한 결제액 : " + ProductOrderRepository.getRealPrice());
			alertView.alert("결제가 완료되었습니다. 감사합니다.");
			
		} else {
			
			alertView.alert("결제에 실패하였습니다");
			
		}
		
	}
	
	
	// 결제 취소 요청
	public void requestProductPaymentDelete() {

		// 주문된 데이터를 모두 결제 취소 상태로 바꿈
		MainController.getProductOrderController().requestProductOrderAllDelete();
		
	}

}

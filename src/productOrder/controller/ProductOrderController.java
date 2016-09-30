package productOrder.controller;

import mainController.MainController;
import productOrder.dao.ProductOrderDao;
import productOrder.view.ProductOrderView;
import productOrder.vo.ProductOrder;
import productPayment.vo.ProductPayment;

public class ProductOrderController {


	// variable
	private ProductOrderDao productOrderDao;


	//constructor
	public ProductOrderController() {

		this.productOrderDao = new ProductOrderDao();

	}


	// 상품주문 뷰 호출
	public void requestProductOrderView() {

		ProductOrderView productOrderView = new ProductOrderView();
		productOrderView.orderProductView();

	}


	//선택 상품 주문에 저장
	public void requestOrderProduct(ProductOrder orderProduct) {

		ProductPayment productPayment = productOrderDao.orderProductInsert(orderProduct);
		MainController.getProductPaymentController().requestInsertOrderData(productPayment);
		
	}

	
	
}

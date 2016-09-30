package productOrder.controller;

import mainView.AlertView;
import productOrder.dao.ProductOrderDao;
import productOrder.view.ProductOrderView;
import productOrder.vo.ProductOrder;

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

		// 주문 사항을 productOrderRepository에 저장
		productOrderDao.orderproduct(orderProduct);
		
		// 주문 데이터베이스에 주문 사항 저장
		boolean success = productOrderDao.orderProductInsert(orderProduct);

		AlertView alertView = new AlertView();

		if(success) {

			alertView.alert("주문 완료");

		} else {

			alertView.alert("주문 실패");

		}

	}

}

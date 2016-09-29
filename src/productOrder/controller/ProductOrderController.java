package productOrder.controller;

import java.util.ArrayList;

import mainView.AlertView;
import productOrder.dao.ProductOrderDao;
import productOrder.view.OrderListView;
import productOrder.view.ProductOrderView;
import productOrder.vo.ProductOrder;

public class ProductOrderController {


	// variable
	private ProductOrderDao productOrderDao;


	//constructor
	public ProductOrderController() {

		this.productOrderDao = new ProductOrderDao();

	}


	// 상품주분 뷰 호출
	public void requestProductOrderView() {

		ProductOrderView productOrderView = new ProductOrderView();
		productOrderView.orderProductView();

	}


	//선택 상품 주문에 저장
	public void requestOrderProduct(ProductOrder orderProduct) {
		
		boolean success = productOrderDao.orderproduct(orderProduct);
		
		productOrderDao.orderProductInsert(orderProduct);
		
		AlertView alertView = new AlertView();

		if(success) {

			alertView.alert("주문 완료");

		} else   {

			alertView.alert("주문 완료");

		}
	
	}

		
	// 주문 리스트 요청
		public void requestOrderListView(){

			ArrayList<ProductOrder> productOrders = productOrderDao.productOrderList();
			OrderListView orderListView = new OrderListView();
			orderListView.OrderListView(productOrders);

		}

}

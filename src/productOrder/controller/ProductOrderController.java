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
		
		int orderProcessNumber = productOrderDao.orderproduct(orderProduct);
		
		AlertView alertView = new AlertView();

		if(orderProcessNumber==1) {

			alertView.alert("이미 주문하신 상품입니다. 수량  조정합니다.");
			alertView.alert("주문 완료");

		} else   {

			alertView.alert("주문 완료");

		}
		
		requestOrderListView();
	
	}


	//상품주문 리스트에 저장
	public void requestOrderProductInsert(ProductOrder orderProduct){
		
		productOrderDao.orderProductInsert(orderProduct);
		
	}
	
	
	// 주문 리스트 요청
		public void requestOrderListView(){

			ArrayList<ProductOrder> productOrders = productOrderDao.productOrders();
			OrderListView orderListView = new OrderListView();
			orderListView.OrderListView(productOrders);

		}

}

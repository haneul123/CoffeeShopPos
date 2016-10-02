package productOrder.controller;

import java.util.ArrayList;

import mainController.MainController;
import mainView.AlertView;
import productOrder.dao.ProductOrderDao;
import productOrder.view.CheckUserPhoneNumberView;
import productOrder.view.ChoiceGuestOrMember;
import productOrder.view.ProductOrderListView;
import productOrder.view.ProductOrderMainMenu;
import productOrder.view.ProductOrderView;
import productOrder.view.SelectDeleteOrderNumber;
import productOrder.vo.ProductOrder;

public class ProductOrderController {


	// variable
	private ProductOrderDao productOrderDao;


	//constructor
	public ProductOrderController() {

		this.productOrderDao = new ProductOrderDao();

	}


	// 상품 주문 메인 메뉴 뷰 요청
	public void requestProductOrderMainMenuView() {

		ProductOrderMainMenu productOrderMainMenu = new ProductOrderMainMenu();
		productOrderMainMenu.productOrderMainMenu();

	}


	// 주문한 회원의 식별을 위한 전화번호를 입력
	public void requestCheckUserPhoneNumber() {

		CheckUserPhoneNumberView checkUserPhoneNumberView = new CheckUserPhoneNumberView();
		checkUserPhoneNumberView.checkUserPhoneNumberView();

	}


	// 입력한 회원의 전화번호가 회원 가입이 된 번호인지 확인
	public void requestCheckUser(String userPhoneNumber){

		int userNumber = productOrderDao.checkUser(userPhoneNumber);
		
		if(userNumber == 1){

			// 가입된 회원 번호가 없는 경우 비회원으로 처리할지 가입 후 주문할지 확인
			ChoiceGuestOrMember choiceGuestOrMember = new ChoiceGuestOrMember();
			choiceGuestOrMember.choiceGuestOrMember(userNumber);

		} else if(userNumber > 0){

			requestProductOrderView(userNumber);

		}

	}


	// 상품 주문 뷰 요청
	public void requestProductOrderView(int userNumber) {

		MainController.getProductController().requestProductlist();
		ProductOrderView productOrderView = new ProductOrderView();
		productOrderView.orderProductView(userNumber);

	}

	
	// 주문된 상품의 원재료가 적정량 남아 있는지 체크
	public void requestCheckIngredient(ProductOrder orderProduct){
		
		int statusNumber = productOrderDao.checkIngredient(orderProduct);
		AlertView alertView = new AlertView();
		
		// 만약 원재료 양이 최대 원재료 양의 10% 미만인 경우 주문을 중지하고 먼저 원재료 주문을 한다  
		if(statusNumber == 1){
			
			alertView.alert("현재 남아있는 재고량이 10% 미만입니다. 원재료 주문을 먼저 한 후 재주문 바랍니다");
			
		// 만약 원재료 양이 최대 원재료 양의 30% 미만인 경우 경고 메시지를 출력한다.
		} else if(statusNumber == 2) {
				
			alertView.alert("현재 남아있는 재고량이 최대 재고량의 30% 미만입니다. 추가 주문 바랍니다");
			MainController.getProductOrderController().requestOrderProduct(orderProduct);
		
		// 원재료 양이 최대 원재료 양의 30% 이상인 경우 그대로 주문을 진행한다.
		} else {
			
			MainController.getProductOrderController().requestOrderProduct(orderProduct);	
			
		}
		
	}
	
	
	// 주문된 상품 주문 데이터베이스에 저장
	public void requestOrderProduct(ProductOrder orderProduct) {

		boolean isSuccess = productOrderDao.orderProductInsert(orderProduct);

		AlertView alertView = new AlertView();
		if(isSuccess){

			alertView.alert("주문이 정상 처리 되었습니다");

		} else {

			alertView.alert("주문이 처리 되지 못했습니다. 다시 주문해 주십시오");

		}

	}


	// 주문 내역 확인 뷰 요청
	public void requestProductOrderListView() {

		ArrayList<ProductOrder> orderList = productOrderDao.orderList();
		ProductOrderListView productOrderListView = new ProductOrderListView();
		productOrderListView.productOrderListView(orderList);

	}


	// 주문 삭제를 위한 주문 번호 요청
	public void requestSelectDeleteOrderNumber(){

		MainController.getProductOrderController().requestProductOrderListView();
		SelectDeleteOrderNumber selectDeleteOrderNumber = new SelectDeleteOrderNumber();
		selectDeleteOrderNumber.selectDeleteOrderNumber();

	}


	// 선택한 주문 번호에 대한 유효성 체크
	public void requestCheckProductOrderNumber(int deleteOrderNumber){

		boolean success = productOrderDao.checkOrderNumber(deleteOrderNumber);

		if(success){

			MainController.getProductOrderController().requestProductOrderCancelView(deleteOrderNumber);

		} else {

			AlertView alertView = new AlertView();
			alertView.alert("없는 주문 번호입니다. 다시 확인하시기 바랍니다");

		}

	}


	// 상품 주문 취소 뷰 요청
	public void requestProductOrderCancelView(int deleteOrderNumber){

		boolean success = productOrderDao.deleteOrderNumber(deleteOrderNumber);

		AlertView alertView = new AlertView();
		if(success){

			alertView.alert("주문이 정상적으로 삭제되었습니다");

		} else {

			alertView.alert("주문 삭제에 실패하였습니다. 재시도 바랍니다");

		}

	}


	// 주문 전체 취소 요청 (결제단에서 요청됨)
	public void requestProductOrderAllDelete(){

		boolean success = productOrderDao.deleteAllOrder();

		AlertView alertView = new AlertView();
		if(success){

			alertView.alert("결제가 정상적으로 취소되었습니다");

		} else {

			alertView.alert("결제 삭제에 실패하였습니다. 재시도 바랍니다");

		}

	}

}

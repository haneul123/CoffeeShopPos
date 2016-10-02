package ingredientOrder.controller;

import java.util.ArrayList;

import ingredientOrder.dao.IngredientOrderDao;
import ingredientOrder.view.IngredientOrderList;
import ingredientOrder.view.IngredientOrderListDelete;
import ingredientOrder.view.IngredientOrderMainMenu;
import ingredientOrder.view.IngredientOrderView;
import ingredientOrder.vo.IngredientOrder;
import mainController.MainController;
import mainView.AlertView;

public class IngredientOrderController {


	private IngredientOrderDao ingredientOrderDao;


	public IngredientOrderController() {

		this.ingredientOrderDao = new IngredientOrderDao();

	}


	// 원재료주문 메인 메뉴 뷰 요청
	public void requestIngredientOrderMainMenuView() {

		IngredientOrderMainMenu ingredientOrderMainMenu = new IngredientOrderMainMenu();
		ingredientOrderMainMenu.ingredientOrderMainMenu();

	}


	// 원재료주문 주문 뷰 요청
	public void requestIngredientOrderView() {

		MainController.getIngredientController().requestListIngredient();
		IngredientOrderView ingredientOrderView = new IngredientOrderView();
		ingredientOrderView.orderingredientView();

	}


	// 원재료주문  데이터베이스에 저장
	public void requestOrderIngredient(IngredientOrder orderIngredient) {

		boolean success = ingredientOrderDao.orderIngredientInsert(orderIngredient);

		AlertView alertView = new AlertView();
		
		if(success){

			alertView.alert("주문이 정상 처리 되었습니다");

		} else {

			alertView.alert("주문이 처리 되지 못했습니다. 다시 주문해 주십시오");

		}

	}


	//원재료 주문 리스트 뷰
	public void requestOrderIngredientList() {
		
		ArrayList<IngredientOrder> ingredietnOrderList = ingredientOrderDao.orderInfredientList();
		IngredientOrderList ingredientOrderList = new IngredientOrderList();
		ingredientOrderList.ingredientOrderList(ingredietnOrderList);
		
	}


	//원재료주문 리스트 삭제 뷰
	public void requestOrderIngredientDeleteView() {
		
		requestOrderIngredientList();
	
		IngredientOrderListDelete ingredientOrderListDelete = new IngredientOrderListDelete();
		ingredientOrderListDelete.ingredientOrderListDelete();
		
	}
	
	
	//원재료주문 리스트 삭제 
	public void requestOrderIngredientDelete(int deleteIngredientOrder) {
		
		boolean success = ingredientOrderDao.deleteIngredientOrder(deleteIngredientOrder);
		AlertView alertView = new AlertView();
		
		if(success){
			alertView.alert("삭제 성공");
		}else {
			alertView.alert("삭제실패");
		}
		
		
		
	}
}


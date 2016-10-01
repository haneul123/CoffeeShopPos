package ingredientOrder.controller;

import ingredientOrder.dao.IngredientOrderDao;
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


}


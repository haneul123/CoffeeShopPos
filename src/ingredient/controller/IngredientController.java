package ingredient.controller;

import ingredient.dao.IngredientDao;
import ingredient.view.AddIngredientView;
import ingredient.vo.Ingredient;
import mainController.MainController;
import mainView.AlertView;

public class IngredientController {

	// variable
	private IngredientDao ingredientDao; 

	// constructor
	public IngredientController() {

		this.ingredientDao = new IngredientDao();

	}


	// method
	// 재고관리
	public void requestIngredient() {
		

	}



	// 원재료 등록
	public void requestAddIngredient() {

		AddIngredientView adv = new AddIngredientView();
		Ingredient insertIngredients = adv.insertIngredientView();
		boolean success = ingredientDao.addIngredient(insertIngredients);

		if(success) {
			new AlertView().alert("원재료 등록을 성공하였습니다.");
		} else {
			new AlertView().alert("원재료 등록에 실채 하였습니다.");
		}

		MainController.mainMenuView();

	}


	// 원재료 조회
	public void requestReadIngredient() {


	}


	// 원재료 업데이트
	public void requestUpdateIngredient(){


	}


	// 원재료 삭제
	public void requestDeleteIngredient() {


	}

}

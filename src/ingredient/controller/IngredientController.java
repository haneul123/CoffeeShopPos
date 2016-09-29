package ingredient.controller;

import java.util.ArrayList;

import ingredient.dao.IngredientDao;
import ingredient.view.AddIngredientView;
import ingredient.view.GetKeywordView;
import ingredient.view.IngredientMainMenu;
import ingredient.view.SearchIngredientView;
import ingredient.view.SearchListView;
import ingredient.vo.Ingredient;
import mainView.AlertView;

public class IngredientController {

	// variable
	private IngredientDao ingredientDao; 

	// constructor
	public IngredientController() {

		this.ingredientDao = new IngredientDao();

	}

	//사용자가 입력한 키워드 호출
	public void requestInputKeyword(String getName) {
		
		GetKeywordView gkv = new GetKeywordView();
		gkv.requestGetKeywordName(getName);
		
	}

	
	// method
	// 재고관리
	public void requestIngredient() {
		
		IngredientMainMenu ingredientMenu = new IngredientMainMenu();
		ingredientMenu.ingredientMenu();
		
	}


	// 원재료 등록
	public void requestAddIngredient() {

		AddIngredientView adv = new AddIngredientView();
		Ingredient insertIngredients = adv.insertIngredientView();
		boolean success = ingredientDao.addIngredient(insertIngredients);

		if(success) {
			new AlertView().alert("원재료 등록을 성공하였습니다.");
		} else {
			new AlertView().alert("원재료 등록에 실패 하였습니다.");
		}

		requestIngredient();

	}


	// 원재료 조회
	public void requestSearchIngredient() {
		
		//뷰호출
		SearchIngredientView aiv = new SearchIngredientView();
		Ingredient getName  = aiv.searchIngredient();
		ArrayList<Ingredient> ingredientList = ingredientDao.searchIngredient(getName);

		SearchListView searchList = new SearchListView();
		searchList.SearchListView(ingredientList);

	}


	// 원재료 업데이트
	public void requestUpdateIngredient(){


	}


	// 원재료 삭제
	public void requestDeleteIngredient() {


	}

}

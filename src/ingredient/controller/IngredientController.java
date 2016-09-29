package ingredient.controller;

import java.util.ArrayList;

import ingredient.dao.IngredientDao;
import ingredient.view.AddIngredientView;
import ingredient.view.GetKeywordView;
import ingredient.view.IngredientDeleteView;
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
	// 재고관리 메인메뉴 호출
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

	}


	// 원재료 조회
	public void requestSearchIngredient() {
		
		//뷰호출
		SearchIngredientView siv = new SearchIngredientView();
		Ingredient getName  = siv.searchIngredient();
		
		//Dao호출
		ArrayList<Ingredient> ingredientList = ingredientDao.searchIngredient(getName);

		SearchListView searchList = new SearchListView();
		searchList.SearchList(ingredientList);

	}


	// 원재료 업데이트
	public void requestUpdateIngredient(){
		
		//뷰호출
		

	}


	// 원재료 삭제
	public void requestDeleteIngredient() {

		//뷰호출
		IngredientDeleteView idv = new IngredientDeleteView();
		Ingredient deleteIngredientGetNmae = idv.deleteIngredient();
		
		//Dao호출
		ArrayList<Ingredient> ingredientList = ingredientDao.searchIngredient(deleteIngredientGetNmae);
		SearchListView searchList = new SearchListView();
		searchList.SearchList(ingredientList);
		
		//삭제할 제품번호
		 int deleteIngredientGetNum = idv.deleteIngredientNum();
		
		boolean success = ingredientDao.deleteIngredient(deleteIngredientGetNum);
		
		if(success) {
			new AlertView().alert("삭제성공");
		} else {
			new AlertView().alert("삭제실패");
		}

	}

}

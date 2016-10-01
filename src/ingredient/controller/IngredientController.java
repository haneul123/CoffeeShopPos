package ingredient.controller;

import java.util.ArrayList;

import ingredient.dao.IngredientDao;
import ingredient.view.AddIngredientView;
import ingredient.view.GetKeywordView;
import ingredient.view.IngredientDeleteView;
import ingredient.view.IngredientMainMenu;
import ingredient.view.SearchIngredientView;
import ingredient.view.SearchListView;
import ingredient.view.UpdateIngredientView;
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
	public void requestIngredientMainMenu() {

		IngredientMainMenu ingredientMenu = new IngredientMainMenu();
		ingredientMenu.ingredientMenu();

	}


	//원재료 등록 뷰 호출
	public void requertAddInfredientView() {

		AddIngredientView adv = new AddIngredientView();
		adv.insertIngredientView();

	}


	// 원재료 등록
	public void requestAddIngredient(Ingredient insertIngredients) {

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


	//원재료 수정전 조회
	public void requestIngredientUpdateNumber() {
		
		requestSearchIngredient();
		
		UpdateIngredientView updateIngredientNum = new UpdateIngredientView();
		updateIngredientNum.updateingredientNumberView();
		
	}
	
	
	//원재료 정보 입력 뷰
	public void requestIngredientUpdateInfo(int selectedIngredientNumber) {
		
		UpdateIngredientView updateIngredientInfo = new UpdateIngredientView();
		updateIngredientInfo.updateProductInfo(selectedIngredientNumber);
		
		
	}
	
	
	// 원재료 업데이트
	public void requestUpdateIngredient(Ingredient updateingredient){

		boolean success = ingredientDao.updateIngredient(updateingredient);

		AlertView alert = new AlertView();
		
		
		if(success) {
			alert.alert("수정성공");
		} else {
			alert.alert("수정실패");
		}

	}


	//원재료 삭제 뷰 호출
	public void requerstDeleteIngredientView() {

		requestSearchIngredient();

		IngredientDeleteView deleteIngredientGetNum = new IngredientDeleteView();
		deleteIngredientGetNum.deleteIngredientNum();


	}


	// 원재료 삭제
	public void requestDeleteIngredient(int deleteIngredientGetNum) {
		

		boolean success = ingredientDao.deleteIngredient(deleteIngredientGetNum);
		
		AlertView alert = new AlertView();

		if(success) {
			alert.alert("삭제성공");
		} else {
			alert.alert("삭제실패");
		}

	}


	//원재료 목록
	public void requestListIngredient() {

		ArrayList<Ingredient> ingredientList = ingredientDao.listInfredient();

		SearchListView IngredientlistView = new SearchListView();
		IngredientlistView.SearchList(ingredientList);

	}
}

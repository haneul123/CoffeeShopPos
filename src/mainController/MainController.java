package mainController;

import admin.controller.AdminController;
import ingredient.controller.IngredientController;
import login.controller.LoginController;
import mainView.MainMenuView;

public class MainController {
	
	private static DBcontroller dbController;
	private static AdminController adminController;
	private static LoginController loginController;
	private static IngredientController ingredientController;
	
	//구조
	public MainController() {
		
		dbController = new DBcontroller();
		adminController = new AdminController();
		loginController = new LoginController();
		ingredientController = new IngredientController();
		
	}


	public static DBcontroller getDbController() {
		return dbController;
	}

	
	public static AdminController getAdminController() {
		return adminController;
	}


	public static LoginController getLoginController() {
		return loginController;
	}

	
	public static IngredientController getIngredientController() {
		return ingredientController;
	}
	

	public static void setIngredientController(IngredientController ingredientController) {
		MainController.ingredientController = ingredientController;
	}


	//메인메뉴보기
	public static void mainMenuView() {
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.mainMenuView();
		
	}
	
}

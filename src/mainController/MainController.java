package mainController;

import admin.controller.AdminController;
import ingredient.controller.IngredientController;
import login.controller.LoginController;
import mainView.MainMenuView;
import product.controller.ProductController;

public class MainController {
	
	private static DBcontroller dbController;
	private static AdminController adminController;
	private static LoginController loginController;
<<<<<<< HEAD
	private static ProductController productController;
=======
	private static IngredientController ingredientController;
>>>>>>> refs/remotes/origin/pr/8
	
	//구조
	public MainController() {
		
		dbController = new DBcontroller();
		adminController = new AdminController();
		loginController = new LoginController();
<<<<<<< HEAD
		productController = new ProductController();
=======
		ingredientController = new IngredientController();
>>>>>>> refs/remotes/origin/pr/8
		
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


	public static ProductController getProductController() {
		return productController;
	}


	//메인메뉴보기
	public static void mainMenuView() {
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.mainMenuView();
		
	}
	
}

package mainController;

import admin.controller.AdminController;
import login.controller.LoginController;
import mainView.MainMenuView;
import product.controller.ProductController;
import productOrder.controller.ProductOrderController;

public class MainController {
	
	private static DBcontroller dbController;
	private static AdminController adminController;
	private static LoginController loginController;
	private static ProductController productController;
	private static ProductOrderController productOrderController; 
	
	//구조
	public MainController() {
		
		dbController = new DBcontroller();
		adminController = new AdminController();
		loginController = new LoginController();
		productController = new ProductController();
		productOrderController = new ProductOrderController();
		
	}


	public static ProductOrderController getProductOrderController() {
		return productOrderController;
	}


	public static void setProductOrderController(ProductOrderController productOrderController) {
		MainController.productOrderController = productOrderController;
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


	public static ProductController getProductController() {
		return productController;
	}


	//메인메뉴보기
	public static void mainMenuView() {
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.mainMenuView();
		
	}
	
}

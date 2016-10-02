package mainController;


import admin.controller.AdminController;
import adminSalary.controller.AdminSalaryController;
import ingredient.controller.IngredientController;
import ingredientOrder.controller.IngredientOrderController;
import ingredientPayment.controller.IngredientPaymentController;
import login.controller.LoginController;
import mainView.MainMenuView;
import product.controller.ProductController;
import productOrder.controller.ProductOrderController;
import productPayment.controller.ProductPaymentContoller;
import salesManagement.controller.SalesManagementController;
import user.controller.UserController;

public class MainController {
	
	private static DBcontroller dbController;
	private static AdminController adminController;
	private static LoginController loginController;
	private static ProductController productController;
	private static ProductOrderController productOrderController; 
	private static IngredientController ingredientController;
	private static UserController userController;
	private static SalesManagementController salesManagementController;
	private static ProductPaymentContoller productPaymentController;
	private static IngredientOrderController ingredientOrderController;
	private static IngredientPaymentController ingredientPaymentController;
	private static AdminSalaryController adminSalaryController;
	
	//구조
	public MainController() {
		
		dbController = new DBcontroller();
		adminController = new AdminController();
		loginController = new LoginController();
		productController = new ProductController();
		productOrderController = new ProductOrderController();
		ingredientController = new IngredientController();
		userController = new UserController();
		salesManagementController = new SalesManagementController();
		productPaymentController = new ProductPaymentContoller();
		ingredientOrderController = new IngredientOrderController();
		ingredientPaymentController = new IngredientPaymentController();
		adminSalaryController = new AdminSalaryController();
		
	}


	// getter and setter
	public static ProductOrderController getProductOrderController() {
		return productOrderController;
	}


	public static ProductPaymentContoller getProductPaymentController() {
		return productPaymentController;
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

	
	public static ProductController getProductController() {
		return productController;
	}


	public static UserController getUserController() {
		return userController;
	}

	
	public static SalesManagementController getSalesManagementController() {
		return salesManagementController;
	}


	public static IngredientOrderController getIngredientOrderController() {
		return ingredientOrderController;
	}


	public static IngredientPaymentController getIngredientPaymentController() {
		return ingredientPaymentController;
	}


	public static AdminSalaryController getAdminSalaryController() {
		return adminSalaryController;
	}


	//메인메뉴보기
	public static void mainMenuView() {
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.mainMenuView();
		
	}
	
}

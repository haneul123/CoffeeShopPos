package mainController;

import mainView.MainMenuView;

public class MainController {
	
	private static DBcontroller dbController;
	
	
	//구조
	public MainController() {
		
		dbController = new DBcontroller();
		
	}


	public static DBcontroller getDbController() {
		return dbController;
	}


	public static void setDbController(DBcontroller dbController) {
		MainController.dbController = dbController;
	}


	//메인메뉴보기
	public static void mainMenuView() {
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.mainMenuView();
		
	}
	
}

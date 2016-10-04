package ingredientPayment.controller;

import ingredientPayment.dao.IngredientPaymentDao;
import ingredientPayment.view.IngredientPaymentView;

public class IngredientPaymentController {
	
	private IngredientPaymentDao ingredientPaymentDao;
	
	
	public IngredientPaymentController() {
		
		ingredientPaymentDao = new IngredientPaymentDao();
		
	}
	
	
	// 결제 요청 뷰
	public void requestIngredientPaymentView() {
					
		IngredientPaymentView ingredientPayment = new IngredientPaymentView();
		ingredientPayment.ingredientOrderPay();
			
	}

	
	// 결제 요청
	public void requestIngredientPayment(){
		
		ingredientPaymentDao.IngredientPayment();
		
	}
	
}

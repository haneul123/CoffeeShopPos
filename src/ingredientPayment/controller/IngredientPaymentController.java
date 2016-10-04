package ingredientPayment.controller;

import ingredientPayment.dao.IngredientPaymentDao;
import ingredientPayment.view.IngredientPaymentView;

public class IngredientPaymentController {
	
	private IngredientPaymentDao ingredientPaymentDao;
	
	
	public IngredientPaymentController() {
		
		ingredientPaymentDao = new IngredientPaymentDao();
		
	}
	
	
	//결제하기
	public void ingredientPayment() {
		
		ingredientPaymentDao.IngredientPayment();
		
		IngredientPaymentView ingredientPayment = new IngredientPaymentView();
		ingredientPayment.ingredientOrderPay();
		
	}

}

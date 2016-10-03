package ingredientOrder.view;

import java.util.ArrayList;

import ingredientOrder.vo.IngredientOrder;

public class IngredientOrderList {
	

	public IngredientOrderList() {
		
		
	}
	
	
	//원재료 주문 리스트
	public void ingredientOrderList(ArrayList<IngredientOrder> ingredietnOrders) {
		
		
		System.out.println("원재료 주문 리스트 ");
		System.out.println("번호      주문관리자  원재료명  원재료가격   주문수량   총주문가격      주문날짜");
		System.out.println("---------------------------------------------------------");
		for(int i = 0; i<ingredietnOrders.size(); i++) {

		System.out.print(ingredietnOrders.get(i).getIngredientOrderNumber()+"\t");
		System.out.print(ingredietnOrders.get(i).getAdminId()+"\t");
		System.out.print(ingredietnOrders.get(i).getIngredientName()+"\t");
		System.out.print(ingredietnOrders.get(i).getIngredientPrice()+ "\t");
		System.out.print(ingredietnOrders.get(i).getOrderCount()+"\t");
		System.out.print(ingredietnOrders.get(i).getTotalPrice()+"\t");
		System.out.println(ingredietnOrders.get(i).getOrderDate());
		
		}
	
	}

}

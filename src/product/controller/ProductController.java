package product.controller;

import java.util.ArrayList;
import mainController.MainController;
import mainView.AlertView;
import product.dao.ProductDao;
import product.view.InsertProductView;
import product.view.ListProductView;
import product.view.ProductMainMenuView;
import product.view.SearchProductView;
import product.vo.Product;

public class ProductController {

	private ProductDao productDao;

	//구조
	public ProductController(){

		productDao = new ProductDao();
		
	}


	//상품 리스트
	public void requestProductlist() {
		
		ArrayList<Product> products = productDao.productList();
		
		AlertView alertView = new AlertView();
		
		if(products.size() == 0) {
			
			alertView.alert("상품이 없습니다.");
			
		} else {
			
			ListProductView listProductView = new ListProductView();
			listProductView.productList(products);
			
		}
		
	}
	
	
	//상품등록을 위한 정보 입력
	public void requestInsertProductInfo(){
		
		InsertProductView insertProductView = new InsertProductView();
		insertProductView.insertProductView();
		
	}
	
	
	//상품등록
	public void requestInsertProduct(Product insertProduct){
		
		boolean success = productDao.productInsert(insertProduct);
		
		AlertView alertView = new AlertView();
		
		if(success) {
			
			alertView.alert("성공적으로 상품이 등록되었습니다.");
			
		} else {
			
			alertView.alert("이미 같은 상품이 존재합니다.");
			
		}

	}


	//상품조회
	public void requestSearch(){
		
		SearchProductView searchProductView = new SearchProductView();
		
		int searchNumber = searchProductView.searchProductNumber();
		AlertView alertView = new AlertView();
		Product product = productDao.productSearch(searchNumber);
		
		if(product != null) {
			
			searchProductView.printProduct(product);
			
		}else {
			
			alertView.alert("조회하신 상품이 없습니다.");
			MainController.getProductController().requestProductlist();
			
		}

	}


	public void requestDelete(){

		

	}


	public void requestUpdate(){

		

	}
	
	
	//상품관리 메뉴
	public void requestProductMainMenu() {
		
		ProductMainMenuView productMainMenuView = new ProductMainMenuView();
		productMainMenuView.productMainMenuView();
		
	}
	
}

package product.controller;

import java.util.ArrayList;

import mainController.MainController;
import mainView.AlertView;
import product.dao.ProductDao;
import product.view.InsertIngredientInfoView;
import product.view.InsertProductView;
import product.view.ListProductView;
import product.view.ProductMainMenuView;
import product.view.RemoveProductView;
import product.view.SearchProductView;
import product.view.UpdateProductView;
import product.vo.Product;

public class ProductController {

	
	// variable
	private ProductDao productDao;

	
	// constructor
	public ProductController(){

		productDao = new ProductDao();

	}


	// 상품 리스트 표시를 위한 데이터 요청
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


	// 상품등록을 위한 정보 입력
	public void requestInsertProductInfo(){

		InsertProductView insertProductView = new InsertProductView();
		insertProductView.insertProductView();

	}


	// 사용될 원재료 정보 입력
	public void requestInsertIngredientInfo(Product insertProduct){
		
		InsertIngredientInfoView insertIngredientInfoView = new InsertIngredientInfoView();
		insertIngredientInfoView.insertIngredientInfoView(insertProduct);
		
	}
	
	
	// 입력한 원재료 번호 유효성 체크 (완성되면 원재료 controller로 이동되어야 함)
	public void requestCheckIngredientNumber(Product ingredient){
	
		boolean isFind = productDao.checkIngredientNumber(ingredient);
		AlertView alertView = new AlertView();
		
		if(isFind){
			
			alertView.alert("사용 원재료가 등록되었습니다");
			
		} else {
			
			alertView.alert("선택하신 원재료 번호는 없는 번호입니다");
			MainController.getProductController().requestInsertProductInfo();
			
		}
		
	}


	// 상품등록
	public void requestInsertProduct(Product insertProduct, ArrayList<Product> ingredientList){
		
		boolean success = productDao.productInsert(insertProduct, ingredientList);

		AlertView alertView = new AlertView();

		if(success) {

			alertView.alert("성공적으로 상품이 등록되었습니다.");

		} else {

			alertView.alert("이미 같은 상품이 존재합니다.");

		}

	}


	// 상품조회
	public void requestSearch(){

		SearchProductView searchProductView = new SearchProductView();
		int searchNumber = searchProductView.searchProductNumber();
		
		Product product = productDao.productSearch(searchNumber);
		
		if(product != null) {

			searchProductView.printProduct(product);

		} else {
			
			AlertView alertView = new AlertView();
			alertView.alert("조회하신 상품이 없습니다.");
			MainController.getProductController().requestProductlist();

		}

	}


	// 상품삭제를 위한 번호입력
	public void requestDeleteProductNumber(){

		RemoveProductView removeProductView = new RemoveProductView();
		removeProductView.deleteProductNumber();	

	}


	// 상품삭제
	public void requestDelete(int deleteProductNumber){

		boolean success = productDao.deleteProduct(deleteProductNumber);
		AlertView alertView = new AlertView();

		if(success) {

			alertView.alert("삭제에 성공 하였습니다.");

		} else {

			alertView.alert("삭제에 실패 하였습니다.");

		}

	}


	// 상품 수정 정보요청 뷰
	public void requestUpdateView() {

		UpdateProductView updateProductView = new UpdateProductView();
		updateProductView.updateProductNumberView();

	}


	// 상품 정보 입력 뷰 호출
	public void requestUpdateProductInfo(int selectedProductNumber) {

		UpdateProductView updateProductView = new UpdateProductView();
		updateProductView.updateProductInfo(selectedProductNumber);

	}


	// 상품수정
	public void requestUpdate(Product updateProduct){

		boolean success = productDao.productUpdate(updateProduct);

		AlertView alertView = new AlertView();

		if(success){
			alertView.alert("수정이 정상처리되었습니다");
		} else {
			alertView.alert("수정에 실패하였습니다");
		}

	}


	//상품관리 메뉴
	public void requestProductMainMenu() {

		ProductMainMenuView productMainMenuView = new ProductMainMenuView();
		productMainMenuView.productMainMenuView();

	}

}

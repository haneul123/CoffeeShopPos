package product.controller;

import product.dao.ProductDao;

public class ProductController {

	private ProductDao productDao;


	public ProductController(){

		productDao = new ProductDao();
	}


	public void requestAdd(){

		productDao.add();

	}


	public void requestSearch(){

		productDao.search();	

	}


	public void requestDelete(){

		productDao.delete();

	}


	public void requestUpdate(){

		productDao.update();

	}
	
	
}

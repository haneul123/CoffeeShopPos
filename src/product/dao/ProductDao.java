package product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import product.vo.Product;

public class ProductDao {

	// 상품 리스트
	public ArrayList<Product> productList() {

		ArrayList<Product> products = new ArrayList<Product>();

		Statement stmt = null;
		ResultSet rs = null;

		try{

			stmt = MainController.getDbController().getConnection().createStatement();
			String sql = "select * from product_list";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Product product = new Product();
				product.setProductNumber(rs.getInt("product_Number"));
				product.setProductName(rs.getString("product_Name"));
				product.setProductPrice(rs.getInt("product_Price"));
				product.setProductComment(rs.getString("product_Comment"));
				product.setIsDeleteProduct(rs.getInt("is_delete_product"));
				products.add(product);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(stmt != null){ try{stmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){ try{rs.close();}catch(SQLException e){e.printStackTrace();}}

		}

		return products;

	}


	// 선택된 원재료 번호가 있는 번호인지 체크
	public boolean checkIngredientNumber(Product ingredient) {

		boolean isFind = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from ingredient_list where ingredient_number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, ingredient.getProductIngredientNumber());
			rs = pstmt.executeQuery();
			if(rs.next()){
				isFind = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}} 
		}

		return isFind;

	}


	// 상품 등록
	public boolean productInsert(Product insertProduct, ArrayList<Product> ingredientList){

		boolean success = false;

		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		try {

			// 트랜잭션
			MainController.getDbController().getConnection().setAutoCommit(false);
			
			// 등록하려는 상품 이름이 이미 존재하는 것인지 검토
			String sql = "select * from product_list where product_Name = ?";
			pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt1.setString(1, insertProduct.getProductName());
			rs1 = pstmt1.executeQuery();

			if(rs1.next()) {

				return success;

			} else {

				// 이미 존재하는 상품이 아니라면 상품 리스트에 추가
				sql = "insert into product_list values(product_number_seq.nextval, ?, ?, ?, 1)";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setString(1, insertProduct.getProductName());
				pstmt2.setInt(2, insertProduct.getProductPrice());
				pstmt2.setString(3, insertProduct.getProductComment());
				pstmt2.executeUpdate();

				
				// 새로 등록된 상품의 상품 번호 가져오기
				sql = "select product_number from product_list where product_name = ?";
				pstmt3 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt3.setString(1, insertProduct.getProductName());
				rs2 = pstmt3.executeQuery();
				if(rs2.next()){
					insertProduct.setProductNumber(rs2.getInt(1));
				}
				
				
				// 상품이 사용하는 원재료의 번호와 양 등록
				for(int i = 0; i<ingredientList.size(); i++){

					sql = "insert into product_use_ingredient values(use_number_seq.nextval, ?, ?, ?)";
					pstmt4 = MainController.getDbController().getConnection().prepareStatement(sql);
					pstmt4.setInt(1, ingredientList.get(i).getProductIngredientNumber());
					pstmt4.setInt(2, insertProduct.getProductNumber());
					pstmt4.setInt(3, ingredientList.get(i).getUseAmount());
					pstmt4.executeUpdate();
					success = true;

				}

			}
			
			MainController.getDbController().getConnection().commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				MainController.getDbController().getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {

			if(pstmt4 != null){try {pstmt4.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs2 != null){try {rs2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt3 != null){try {pstmt3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs1 != null){try {rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try {pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}

			try {
				MainController.getDbController().getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return success;

	}


	//상품조회
	public Product productSearch(int searchProductNumber){

		Product searchProduct = new Product();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from product_list where product_Number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchProductNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {

				searchProduct.setProductNumber(rs.getInt(1));
				searchProduct.setProductName(rs.getString(2));
				searchProduct.setProductPrice(rs.getInt(3));
				searchProduct.setProductComment(rs.getString(4));
				searchProduct.setIsDeleteProduct(rs.getInt(5));

			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally{

			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}

		}

		return searchProduct;

	}


	//상품삭제
	public boolean deleteProduct(int deleteProductNumber){

		boolean success = false;
		PreparedStatement pstmt = null;

		try {

			String sql = "update product_list set is_delete_product = 2 where product_number = ? and is_delete_product = 1";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteProductNumber);
			pstmt.executeUpdate();
			success = true;

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}

		}

		return success;

	}


	//상품수정
	public boolean productUpdate(Product updateProduct) {

		boolean success = false;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

		try {

			if(updateProduct.getProductName() != null){

				String sql = "update product_list set product_name = ? where product_number = ?";
				pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt1.setString(1, updateProduct.getProductName());
				pstmt1.setInt(2, updateProduct.getProductNumber());
				pstmt1.executeUpdate();
				success = true;

			}

			if(updateProduct.getProductPrice() != 0){

				String sql = "update product_list set product_price = ? where product_number = ?";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, updateProduct.getProductPrice());
				pstmt2.setInt(2, updateProduct.getProductNumber());
				pstmt2.executeUpdate();
				success = true;

			}

			if(updateProduct.getProductComment() != null){

				String sql = "update product_list set product_comment = ? where product_number = ?";
				pstmt3 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt3.setString(1, updateProduct.getProductComment());
				pstmt3.setInt(2, updateProduct.getProductNumber());
				pstmt3.executeUpdate();
				success = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt3 != null){try {pstmt3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try {pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}
		}

		return success;

	}

}


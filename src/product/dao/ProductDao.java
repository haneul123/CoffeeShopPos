package product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainController.MainController;
import product.vo.Product;

public class ProductDao {

	
	//상품리스트
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
				products.add(product);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			if(stmt != null){

				try{

					stmt.close();

				}catch (SQLException e){
					e.printStackTrace();
				}if(rs !=null){try{rs.close();}catch (SQLException e){e.printStackTrace();}
				}
			}
		}

		return products;

	}


	//상품등록
	public boolean productInsert(Product insertProduct){

		boolean success = false;

		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;

		try {

			String sql = "select * from product_list where product_Name = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, insertProduct.getProductName());
			rs = pstmt.executeQuery();

			if(rs.next()) {

				return success;

			} else {

				sql = "insert into product_list values(product_number_seq.nextval,?,?,?)";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setString(1, insertProduct.getProductName());
				pstmt2.setInt(2, insertProduct.getProductPrice());
				pstmt2.setString(3, insertProduct.getProductComment());
				pstmt2.executeQuery();
				success = true;

			}

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {

			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}

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
	public void delete(){

	}


	//상품수정
	public boolean productUpdate(int selecteNumber, Product updateProduct) {
		
		boolean success = false;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		Product product = new Product();
		
		try {
			
			String sql = "select * product_list where product_Number = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selecteNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				
			}
		}
		
		
		

	}


}

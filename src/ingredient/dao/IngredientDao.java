package ingredient.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ingredient.vo.Ingredient;
import mainController.MainController;
import mainView.AlertView;
import productOrder.vo.ProductOrder;

public class IngredientDao {

	// 재고관리_원재료 등록
	public boolean addIngredient(Ingredient insertIngredients){

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "insert into ingredient_list values(INGREDIENT_NUMBER_SEQ.NEXTVAL,?,?,?,?,?)";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, insertIngredients.getIngredient_Name());
			pstmt.setInt(2, insertIngredients.getIngredient_Price());
			pstmt.setInt(3, insertIngredients.getIngreient_Inventory());
			pstmt.setInt(4, insertIngredients.getIngredient_Inventory_MAX());
			pstmt.setString(5, insertIngredients.getIngredient_unit());
			rs = pstmt.executeQuery();
			success = true;

		} catch (SQLException e) {
			new AlertView().alert("데이터베이스 연결에 실패 했습니다.");
			e.printStackTrace();
		} finally {
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
		}

		return success;

	}


	// 재고관리_원재료 조회
	public ArrayList<Ingredient> searchIngredient(Ingredient getName){

		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from INGREDIENT_LIST where INGREDIENT_NAME LIKE '%'||?||'%' ORDER BY ingredient_number";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, getName.getIngredient_Name());
			rs = pstmt.executeQuery();

			MainController.getIngredientController().requestInputKeyword(getName.getIngredient_Name());

			while(rs.next()) {

				Ingredient ingredient = new Ingredient();
				ingredient.setIngredient_Number(rs.getInt("ingredient_Number"));
				ingredient.setIngredient_Name(rs.getString("Ingredient_Name"));
				ingredient.setIngredient_Price(rs.getInt("Ingredient_Price"));
				ingredient.setIngredient_Inventory_MAX(rs.getInt("Ingredient_Inventory_MAX"));
				ingredient.setIngredient_unit(rs.getString("Ingredient_unit"));
				ingredientList.add(ingredient);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
		}

		return ingredientList;

	}


	// 재고관리_원재료 수정
	public boolean updateIngredient(Ingredient updateingredient){

		boolean success = false;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;

		try{

			if(updateingredient.getIngredient_Name() != null){

				String sql = "update ingredient_list set ingredient_name = ? where ingredient_number = ?";
				pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt1.setString(1, updateingredient.getIngredient_Name());
				pstmt1.setInt(2, updateingredient.getIngredient_Number());
				pstmt1.executeUpdate();
				success = true;

			}

			if(updateingredient.getIngredient_Price() != 0){

				String sql = "update ingredient_list set ingredient_price = ? where ingredient_number = ?";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, updateingredient.getIngredient_Price());
				pstmt2.setInt(2, updateingredient.getIngredient_Number());
				pstmt2.executeUpdate();
				success = true;

			}

			if(updateingredient.getIngredient_Inventory_MAX() != 0){

				String sql = "update ingredient_list set ingredient_Inventory_MAX = ? where ingredient_number = ?";
				pstmt3 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt3.setInt(1, updateingredient.getIngredient_Inventory_MAX());
				pstmt3.setInt(2, updateingredient.getIngredient_Number());
				pstmt3.executeUpdate();
				success = true;

			}

			if(updateingredient.getIngredient_unit() != null){

				String sql = "update ingredient_list set ingredient_unit = ? where ingredient_number = ?";
				pstmt4 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt4.setString(1, updateingredient.getIngredient_unit());
				pstmt4.setInt(2, updateingredient.getIngredient_Number());
				pstmt4.executeUpdate();
				success = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt4 != null){try {pstmt3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt3 != null){try {pstmt3.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try {pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}
		}

		return success;

	}


	// 재고관리_원재료 삭제
	public boolean deleteIngredient(int deleteIngredientGetNum){

		boolean success = false;
		PreparedStatement pstmt = null;

		try {

			String sql = "delete from INGREDIENT_LIST where INGREDIENT_NUMBER = ?";	
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteIngredientGetNum);
			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
		}

		return success;

	}


	//재고관리 목록 보기
	public ArrayList<Ingredient> listInfredient() {

		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>(); 

		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = MainController.getDbController().getConnection().createStatement();
			String sql = "select * from INGREDIENT_LIST";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Ingredient ingredient = new Ingredient();

				ingredient.setIngredient_Number(rs.getInt("ingredient_Number"));
				ingredient.setIngredient_Name(rs.getString("ingredient_name"));
				ingredient.setIngredient_Price(rs.getInt("ingredient_price"));
				ingredient.setIngreient_Inventory(rs.getInt("ingredient_inventory"));
				ingredient.setIngredient_Inventory_MAX(rs.getInt("ingredient_inventory_max"));
				ingredient.setIngredient_unit(rs.getString("ingredient_unit"));
				ingredients.add(ingredient);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(stmt != null){ try{stmt.close();}catch(SQLException e){e.printStackTrace();}}
			if(rs != null){ try{rs.close();}catch(SQLException e){e.printStackTrace();}}

		}

		return ingredients;
	}


	// 원재료 잔량 체크
	public int checkIngredient(ProductOrder orderProduct) {
	
		int statusNumber = 0;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		
		try {
			
			String sql = "select distinct pol.PRODUCT_NUMBER, pui.INGREDIENT_NUMBER, ";
			sql += "il.INGREDIENT_INVENTORY, il.INGREDIENT_INVENTORY_MAX ";
			sql += "from product_order_list pol, product_use_ingredient pui, ingredient_list il ";
			sql += "where pol.PRODUCT_NUMBER = pui.PRODUCT_NUMBER and pui.INGREDIENT_NUMBER = il.INGREDIENT_NUMBER ";
			sql += "order by pol.PRODUCT_NUMBER";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				Ingredient inventory = new Ingredient();
				inventory.setIngredient_Number(rs.getInt(2));
				inventory.setIngreient_Inventory(rs.getInt(3));
				inventory.setIngredient_Inventory_MAX(rs.getInt(4));
				ingredientList.add(inventory);
				
			}
			
			// 현재 재고량과 최대 재고량의 차이를 비교
			for(int i = 0; i<ingredientList.size(); i++){				
				if(ingredientList.get(i).getIngreient_Inventory() < (ingredientList.get(i).getIngredient_Inventory_MAX() * 0.1)){				
					statusNumber = 1;
				} else if(ingredientList.get(i).getIngreient_Inventory() < (ingredientList.get(i).getIngredient_Inventory_MAX() * 0.3)){					
					statusNumber = 2;					
				}		
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt != null){try {stmt.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		
		return statusNumber;
		
	}

}

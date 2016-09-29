package ingredient.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ingredient.vo.Ingredient;
import mainController.MainController;
import mainView.AlertView;

public class IngredientDao {

	boolean success = false;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 재고관리_원재료 등록
	public boolean addIngredient(Ingredient insertIngredients){

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
	public void updateIngredient(){


	}


	// 재고관리_원재료 삭제
	public void deleteIngredient(){


	}


}

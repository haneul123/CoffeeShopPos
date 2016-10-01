package ingredientOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ingredientOrder.vo.IngredientOrder;
import mainController.MainController;
import productOrder.vo.ProductOrder;

public class IngredientOrderDao {


	//주문상품을 주문 리스트에 넣기
	public boolean orderIngredientInsert(IngredientOrder orderIngredient) {

		boolean success = false;		
		Statement stmt= null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int adminNumber = 0;

		try {
			
			String sql = "select admin_number from admin_list where admin_id = ?";
			pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
			rs = pstmt1.executeQuery();
			
			if(rs.next()) {
				
				adminNumber = rs.getInt(1);
			}

			sql = "insert into ingredient_order_list values(ingredient_order_number_seq.nextval, ?, ?, ?, sysdate)";
			pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt2.setInt(1, orderIngredient.getAdminNumber());
			pstmt2.setInt(2, orderIngredient.getIngredientNumber());
			pstmt2.setInt(3, adminNumber);
			
			pstmt2.executeUpdate();
			success = true;

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(pstmt2 != null){try{pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt != null){try{stmt.close();} catch (SQLException e) {e.printStackTrace();}}
		}

		return success;

	}


	



}



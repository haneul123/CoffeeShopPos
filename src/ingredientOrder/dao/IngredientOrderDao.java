package ingredientOrder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ingredientOrder.vo.IngredientOrder;
import mainController.MainController;

public class IngredientOrderDao {


	//주문상품을 주문 리스트에 넣기
	public boolean orderIngredientInsert(IngredientOrder orderIngredient) {

		boolean success = false;		
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int adminNumber = 0;

		try {

			String sql = "select admin_number from admin_list where admin_id = ?";
			pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt1.setString(1, orderIngredient.getAdminId());
			rs = pstmt1.executeQuery();

			if(rs.next()) {

				adminNumber = rs.getInt(1);
			}

			sql = "insert into ingredient_order_list values(ingredient_order_number_seq.nextval, ?, ?, ?, sysdate)";
			pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt2.setInt(1, adminNumber);
			pstmt2.setInt(2, orderIngredient.getIngredientNumber());
			pstmt2.setInt(3, orderIngredient.getOrderCount());

			pstmt2.executeUpdate();
			success = true;

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(pstmt2 != null){try{pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try{pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}

		}

		return success;

	}


	//주문 리스트 보기
	public ArrayList<IngredientOrder> orderInfredientList() {

		ArrayList<IngredientOrder> orderInfredientList = new ArrayList<IngredientOrder>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from ingredient_order_list_view";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				IngredientOrder ingredientOrder = new IngredientOrder();
				ingredientOrder.setIngredientOrderNumber(rs.getInt("ingredient_order_number"));
				ingredientOrder.setAdminId(rs.getString("admin_name"));
				ingredientOrder.setIngredientName(rs.getString("ingredient_name"));
				ingredientOrder.setIngredientPrice(rs.getInt("ingredient_price"));
				ingredientOrder.setOrderCount(rs.getInt("order_count"));
				ingredientOrder.setTotalPrice(rs.getInt("totalprice"));
				ingredientOrder.setOrderDate(rs.getDate("order_date"));
				orderInfredientList.add(ingredientOrder);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();}catch(SQLException e){e.printStackTrace();}}
		}

		return orderInfredientList;
	}


	//주문 리스트 삭제
	public boolean deleteIngredientOrder (int deleteIngredientOrder) {
		
		boolean success = false;
		PreparedStatement pstmt = null;

		try {

			String sql = "delete from ingredient_order_list where INGREDIENT_ORDER_NUMBER =?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteIngredientOrder);
			pstmt.executeUpdate();
			success = true;

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}

		}

		return success;

	}

}









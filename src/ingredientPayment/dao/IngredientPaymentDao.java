package ingredientPayment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ingredientPayment.vo.IngredientPayment;
import mainController.MainController;

public class IngredientPaymentDao {


	//상품 결제시 결제 테이블에 저장
	public boolean IngredientPayment() {

		boolean success = false;
		Statement stmt1 = null;
		Statement stmt2 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ArrayList<IngredientPayment> IngredientPayments = new ArrayList<IngredientPayment>();
		int ingredientOrderNumber = 0;
		int ingredientOrderCount = 0;


		try {

			String sql = "select ingredient_order_number from ingredient_order_list";
			stmt1 = MainController.getDbController().getConnection().createStatement();
			rs1 = stmt1.executeQuery(sql);

			while(rs1.next()) {

				IngredientPayment ingredientPayment = new IngredientPayment();
				ingredientPayment.setIngredientOrderNumber(rs1.getInt(1));
				IngredientPayments.add(ingredientPayment);

			}

			for(int i = 0; i<IngredientPayments.size(); i++){

				//결제 테이블에 주문 정보 저장하기
				sql = "insert into ingredient_pay_list values(ingredient_pay_number_seq.nextval,?)";
				pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt1.setInt(1, IngredientPayments.get(i).getIngredientOrderNumber());
				pstmt1.executeUpdate();
				success = true;

			}
			
			sql = " select iol.INGREDIENT_ORDER_NUMBER,iol.ORDER_COUNT";
			sql +=" from ingredient_order_list iol, ingredient_list il, INGREDIENT_PAY_LIST ipl";
			sql +=" where iol.INGREDIENT_NUMBER = il.INGREDIENT_NUMBER and iol.INGREDIENT_order_NUMBER = ipl.INGREDIENT_ORDER_NUMBER";
			stmt2 = MainController.getDbController().getConnection().createStatement();
			rs2 = stmt2.executeQuery(sql);

			if(rs2.next()) {

				ingredientOrderNumber = rs2.getInt(1);
				ingredientOrderCount = rs2.getInt(2);

			}

			for(int i = 0; i<IngredientPayments.size(); i++){

				sql =  "update ingredient_list ";
				sql += "set ingredient_inventory = (ingredient_inventory + ?) ";
				sql += "where ingredient_number = ?";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, ingredientOrderCount);
				pstmt2.setInt(2,ingredientOrderNumber);
				pstmt2.executeUpdate();

			}
			
			 IngredientPayments.clear();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs2 != null){try {rs2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt2 != null){try {stmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt1 != null){try {pstmt1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs1 != null){try {rs1.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt1 != null){try {stmt1.close();} catch (SQLException e) {e.printStackTrace();}}
		}

		return success;
	}
}

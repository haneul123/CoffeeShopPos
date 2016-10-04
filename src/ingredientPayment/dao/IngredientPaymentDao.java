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
		Statement stmt3 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ArrayList<IngredientPayment> IngredientPayments = new ArrayList<IngredientPayment>();

		try {
		
			// 주문 번호 저장
			String sql = "select ingredient_order_number from ingredient_order_list";
			stmt1 = MainController.getDbController().getConnection().createStatement();
			rs1 = stmt1.executeQuery(sql);

			while(rs1.next()) {

				IngredientPayment ingredientPayment = new IngredientPayment();
				ingredientPayment.setIngredientOrderNumber(rs1.getInt(1));
				IngredientPayments.add(ingredientPayment);

			}

			
			// 결제 테이블에 주문 정보 저장하기
			for(int i = 0; i<IngredientPayments.size(); i++){

				sql = "insert into ingredient_pay_list values(ingredient_pay_number_seq.nextval,?)";
				pstmt1 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt1.setInt(1, IngredientPayments.get(i).getIngredientOrderNumber());
				pstmt1.executeUpdate();
				success = true;

			}
			
			
			// 주문 번호와 주문 량 저장
			sql =  "select iol.INGREDIENT_NUMBER, iol.ORDER_COUNT ";
			sql += "from ingredient_order_list iol, ingredient_list il ";
			sql += "where iol.INGREDIENT_NUMBER = il.INGREDIENT_NUMBER and iol.ISAGREEPAID = 1";
			stmt2 = MainController.getDbController().getConnection().createStatement();
			rs2 = stmt2.executeQuery(sql);

			while(rs2.next()) {

				IngredientPayment payment = new IngredientPayment(); 
				payment.setIngredientNumber(rs2.getInt(1));
				payment.setIngredientOrderCount(rs2.getInt(2));
				IngredientPayments.add(payment);

			}
			
	
			// 주문한 만큼 재고량 증가 시키기
			for(int i = 0; i<IngredientPayments.size(); i++){

				sql =  "update ingredient_list ";
				sql += "set ingredient_inventory = (ingredient_inventory + ?) ";
				sql += "where ingredient_number = ?";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, IngredientPayments.get(i).getIngredientOrderCount());
				pstmt2.setInt(2, IngredientPayments.get(i).getIngredientNumber());
				pstmt2.executeUpdate();

			}

			
			// 결제가 완료된 리스트들의 isAgreePaid 정보를 1 에서 2로 변경
			sql = "update ingredient_order_list set isAgreePaid = 2 where isAgreePaid = 1";
			stmt3 = MainController.getDbController().getConnection().createStatement();
			stmt3.executeUpdate(sql);
			
		} catch (SQLException e) {
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

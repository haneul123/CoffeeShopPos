package salesManagement.controller;

import java.util.ArrayList;

import salesManagement.dao.SalesManagementDao;
import salesManagement.view.AnnualStatsView;
import salesManagement.view.BEPView;
import salesManagement.view.BizTaxView;
import salesManagement.view.DailyStatsView;
import salesManagement.view.ExpectedSalesView;
import salesManagement.view.MonthlyStatsView;
import salesManagement.view.SalesManagementMenuView;
import salesManagement.view.SalesStatsView;
import salesManagement.view.SemiAnnualStatsView;
import salesManagement.view.VATView;
import salesManagement.vo.SalesManagement;

public class SalesManagementController {

	
	// variable
	private SalesManagementDao salesManagementDao;
	
	
	// constructor
	public SalesManagementController() {
	
		this.salesManagementDao = new SalesManagementDao();
		
	}
	
	
	// method
	// 매출관리 메인메뉴 뷰 요청
	public void requestSalesManagementMenu() {

		SalesManagementMenuView salesManagementMenuView = new SalesManagementMenuView();
		salesManagementMenuView.salesManagementMenuView();	
	
	}

	
	// 매출통계 뷰 요청
	public void requestSalesStatsView() {
		
		SalesStatsView salesStatsView = new SalesStatsView();
		salesStatsView.salesStatsView();
		
	}

	
	// 일일 매출 통계 뷰 요청
	public void requestDailyStatsView() {
		
		ArrayList<SalesManagement> dailyStats = salesManagementDao.dailyStats();
		DailyStatsView dailyStatsView = new DailyStatsView();
		dailyStatsView.dailyStatsView(dailyStats);
		
	}
	
	
	// 월별 매출 통계 뷰 요청
	public void requestMonthlyStatsView() {
		
		ArrayList<SalesManagement> monthlyStats = salesManagementDao.monthlyStats();
		MonthlyStatsView monthlyStatsView = new MonthlyStatsView();
		monthlyStatsView.monthlyStatsView(monthlyStats);
		
	}
	
	
	// 반기별 매출 통계 뷰 요청
	public void requestSemiAnnualStatsView() {
		
		ArrayList<SalesManagement> semiAnnualStats = salesManagementDao.semiAnnualStats();
		SemiAnnualStatsView semiAnnualStatsView = new SemiAnnualStatsView();
		semiAnnualStatsView.semiAnnualStatsView(semiAnnualStats);
		
	}
	
	
	// 연간 매출 통계 뷰 요청
	public void requestAnnualStatsView() {
		
		ArrayList<SalesManagement> annualStats = salesManagementDao.AnnualStats();
		AnnualStatsView annualStatsView = new AnnualStatsView(); 
		annualStatsView.annualStatsView(annualStats);
		
	}
	
	
	// 손익분기점 뷰 요청
	public void requestBEPView() {

		BEPView bepView = new BEPView();
		bepView.bepView();
		
	}

	
	// 부가가치세 뷰 요청
	public void requestVATView() {

		VATView vatView = new VATView();
		vatView.vatView();
		
	}

	
	// 사업소득세 뷰 요청
	public void requestBizTaxView() {

		BizTaxView bizTaxView = new BizTaxView();
		bizTaxView.bizTaxView();
		
	}

	
	// 예상매출 뷰 요청
	public void requestExpectedSalesView() {

		ExpectedSalesView expectedSalesView = new ExpectedSalesView();
		expectedSalesView.expectedSalesView();
		
	}

}

package adminSalary.vo;

import java.sql.Date;

public class AdminSalary {
	
	private int salaryNumber;
	private String adminName;
	private int salary;
	private Date salaryDate;
	
	
	public AdminSalary() {
		
	}
	
	
	//조회시 사용
	public AdminSalary(String adminName) {

		this.adminName = adminName;
		
	}
	
	
	public AdminSalary(int salaryNumber, String adminName, int salary, Date salaryDate ) {
		
		this.salaryNumber = salaryNumber;
		this.adminName = adminName;
		this.salary = salary;
		this.salaryDate = salaryDate;
		
	}


	public int getSalaryNumber() {
		return salaryNumber;
	}


	public void setSalaryNumber(int salaryNumber) {
		this.salaryNumber = salaryNumber;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Date getSalaryDate() {
		return salaryDate;
	}


	public void setSalaryDate(Date salaryDate) {
		this.salaryDate = salaryDate;
	}
	
	
	
}

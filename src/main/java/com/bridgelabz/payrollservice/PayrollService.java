package com.bridgelabz.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PayrollService {
	
	public boolean Query() {
		
		boolean check = true;
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollservice","root","root");
			System.out.println("DataBase Connection Established....");
			PreparedStatement statement = connect.prepareStatement("insert into employee_payroll(Name, Gender, Salary, Start_Date, Department, Address, PhoneNumber, Basic_Pay, Deductions, Taxable_pay, Income_Tax, Net_Pay) values(?,?,?,?,?,?,?,?,?,?,?,?);");
			statement.setString(1, "Mohan");
			statement.setString(2, "M");
			statement.setInt(3, 5000000);
			statement.setString(4, "2022-02-08");
			statement.setString(5, "HR");
			statement.setString(6, "Chennai");
			statement.setString(7, "9632145870");
			statement.setInt(8, 50000);
			statement.setInt(9, 5000);
			statement.setInt(10, 2000);
			statement.setInt(11, 3000);
			statement.setInt(12, 40000);
			int data = statement.executeUpdate();
			System.out.println("Rows Inserted......");
		}catch(SQLException e) {
			check = false;
			System.out.println("Database Not Connected !!!.......");
			e.printStackTrace();
		}
		return check;
	}
	
	public static void main(String[] args) throws SQLException {
		
			PayrollService payroll = new PayrollService();
			payroll.Query();
			
	}
}

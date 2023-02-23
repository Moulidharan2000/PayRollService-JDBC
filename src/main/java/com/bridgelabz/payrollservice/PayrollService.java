package com.bridgelabz.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayrollService {
	
	public boolean Query() {
		
		boolean check = true;
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollservice","root","root");
			System.out.println("DataBase Connection Established....");
			PreparedStatement statement = connect.prepareStatement("select * from employee_payroll WHERE Start_Date BETWEEN CAST('2021-04-05' AS DATE) AND DATE(NOW());");
			ResultSet result = statement.executeQuery();
			while(result.next()){
				System.out.println("ID : "+result.getInt(1));
				System.out.println("Name : "+result.getString(2));
				System.out.println("Gender : "+result.getString(3));
				System.out.println("Salary : "+result.getInt(4));
				System.out.println("Start_Date : "+result.getDate(5));
				System.out.println("Department : "+result.getString(6));
				System.out.println("Address : "+result.getString(7));
				System.out.println("Phone Number : "+result.getLong(8));
				System.out.println("Basic_Pay : "+result.getInt(9));
				System.out.println("Deductions : "+result.getInt(10));
				System.out.println("Taxable_Pay : "+result.getInt(11));
				System.out.println("Income_Tax : "+result.getInt(12));
				System.out.println("Net_Pay : "+result.getInt(13)+"\n");
			}
			
		}catch(SQLException e) {
			System.out.println("DataBase is Not Connected....");
			check = false;
			e.printStackTrace();
		}
		return check;
	}

	public static void main(String[] args) {
		
		PayrollService payroll = new PayrollService();
		payroll.Query();
	}
}

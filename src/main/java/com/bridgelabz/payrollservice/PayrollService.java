package com.bridgelabz.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PayrollService {

	public static void main(String[] args) {
		
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollservice","root","root");
			System.out.println("DataBase Connection Established....");
			Statement statement = connect.createStatement();
			statement.execute("UPDATE employee_payroll SET Salary = 3000000 WHERE Name = 'Terissa';");
			ResultSet result = statement.executeQuery("select * from employee_payroll;");
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
				System.out.println("Net_Pay : "+result.getInt(13));
			}
		}catch(SQLException e) {
			System.out.println("DataBase is Not Connected....");
			e.printStackTrace();
		}
	}
}

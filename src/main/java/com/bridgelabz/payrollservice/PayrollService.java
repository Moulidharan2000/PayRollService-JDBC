package com.bridgelabz.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayrollService {
	
	public void SumQuery(Connection connect) throws SQLException {
		
		PreparedStatement statement = connect.prepareStatement("select SUM(Salary) from employee_payroll WHERE Gender = ? GROUP BY Gender;");
		statement.setString(1, "M");
		ResultSet result1 = statement.executeQuery();
		while(result1.next()){
			System.out.println("Sum of Salary for Male Employees : "+result1.getInt(1));
		}
		statement.setString(1, "F");
		ResultSet result2 = statement.executeQuery();
		while(result2.next()){
			System.out.println("Sum of Salary for Female Employees : "+result2.getInt(1));
		}
	}
	
	public void AvgQuerys(Connection connect) throws SQLException {
		
		PreparedStatement statement = connect.prepareStatement("select AVG(Salary) from employee_payroll WHERE Gender = ? GROUP BY Gender;");
		statement.setString(1, "M");
		ResultSet result1 = statement.executeQuery();
		while(result1.next()){
			System.out.println("Average of Salary for Male Employees : "+result1.getInt(1));
		}
		statement.setString(1, "F");
		ResultSet result2 = statement.executeQuery();
		while(result2.next()){
			System.out.println("Average of Salary for Female Employees : "+result2.getInt(1));
		}
	}
	
	public void CountQuery(Connection connect) throws SQLException {

		PreparedStatement statement = connect.prepareStatement("select COUNT(Salary) from employee_payroll WHERE Gender = ? GROUP BY Gender;");
		statement.setString(1, "M");
		ResultSet result1 = statement.executeQuery();
		while(result1.next()){
			System.out.println("Count of Male Employees : "+result1.getInt(1));
		}
		statement.setString(1, "F");
		ResultSet result2 = statement.executeQuery();
		while(result2.next()){
			System.out.println("Count of Female Employees : "+result2.getInt(1));
		}
	}
	
	public void MinQuery(Connection connect) throws SQLException {

		PreparedStatement statement = connect.prepareStatement("select MIN(Salary) from employee_payroll WHERE Gender = ? GROUP BY Gender;");
		statement.setString(1, "M");
		ResultSet result1 = statement.executeQuery();
		while(result1.next()){
			System.out.println("Minimum Salary of Male Employees : "+result1.getInt(1));
		}
		statement.setString(1, "F");
		ResultSet result2 = statement.executeQuery();
		while(result2.next()){
			System.out.println("Minimum Salary of Female Employees : "+result2.getInt(1));
		}
	}
	
	public void MaxQuery(Connection connect) throws SQLException {

		PreparedStatement statement = connect.prepareStatement("select MAX(Salary) from employee_payroll WHERE Gender = ? GROUP BY Gender;");
		statement.setString(1, "M");
		ResultSet result1 = statement.executeQuery();
		while(result1.next()){
			System.out.println("Maximum Salary of Male Employees : "+result1.getInt(1));
		}
		statement.setString(1, "F");
		ResultSet result2 = statement.executeQuery();
		while(result2.next()){
			System.out.println("Maximum Salary of Female Employees : "+result2.getInt(1));
		}
	}

	public static void main(String[] args) throws SQLException {
		
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollservice","root","root");
			System.out.println("DataBase Connection Established....");
			PayrollService payroll = new PayrollService();
			payroll.SumQuery(connect);
			payroll.AvgQuerys(connect);
			payroll.CountQuery(connect);
			payroll.MinQuery(connect);
			payroll.MaxQuery(connect);
		}catch(SQLException e) {
			System.out.println("Database Not Connected !!!.......");
			e.printStackTrace();
		}
	}
}

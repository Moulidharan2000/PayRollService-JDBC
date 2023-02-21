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
			ResultSet result = statement.executeQuery("show tables;");
			
		}catch(SQLException e) {
			System.out.println("DataBase is Not Connected....");
		}
	}
}

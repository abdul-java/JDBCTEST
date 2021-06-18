package com.mdts.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicInsert2 {
	
	public static void main(String[] args) {

		try {
			
			String driver = "com.mysql.cj.jdbc.Driver";
			
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "root";
			String password = "1234";
			
		Class.forName(driver);
		
		
		Connection conn = DriverManager.getConnection(url,username,password);
	
		String insertquery = "insert into city(Name,CountryCode) value (?,?)";
		
		PreparedStatement ptst =  conn.prepareStatement(insertquery);
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Name : ");
		String name = br.readLine();
		
		System.out.println("Enter CountryCode : ");
		String countryCode = br.readLine();
		
		ptst.setString(1,name);
		ptst.setString(2,countryCode);
		
		ptst.executeUpdate();
		System.out.println("inserted");
		
		 conn.close();
		
		// to check sql query
//		SELECT * FROM world.city
//		where name = "Hyderabad";
		
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block	
			e.printStackTrace();
			}
	
		finally {
			
		}
		
	}

}

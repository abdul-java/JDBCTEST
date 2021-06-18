package com.mdts.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicInsert {
	
	public static void main(String[] args) throws SQLException {

		Connection conn=null;
		PreparedStatement ptst = null;
		
		try {
			
			String driver = "com.mysql.cj.jdbc.Driver";
			
			String url = "jdbc:mysql://localhost:3306/jdbc_example";
			String username = "root";
			String password = "1234";
			
		Class.forName(driver);
		
		
		 conn = DriverManager.getConnection(url,username,password);
	
		String insertquery = "insert into emp( name, salary) values(?,?)";
		
		ptst =  conn.prepareStatement(insertquery);
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Name : ");
		String name = br.readLine();
			
		System.out.println("Enter Salary : ");
		String salary = br.readLine();
		
	
		ptst.setString(1,name);
		ptst.setString(2,salary);
		
		ptst.executeUpdate();
		System.out.println("inserted");
		
		 conn.close();
		
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block	
			e.printStackTrace();
			}
	
		finally {
			 conn.close();
			
		}
		
	}

}

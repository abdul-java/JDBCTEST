package com.mdts.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedstmtInsert {

	public static void main(String[] args) {

		try {
			
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "root";
			String password = "root";
			
		Class.forName(driver);
		
		
		Connection conn = DriverManager.getConnection(url,username,password);
		
		String insertquery = "insert into city(ID,Name) value (?,?)";
		
		
		PreparedStatement ptst =  conn.prepareStatement(insertquery);
		
		ptst.setInt(1,5066);
		ptst.setString(2,"kolkatta");
		
		ptst.executeUpdate();
		
		System.out.println("inserted");
		
		conn.close();
		
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block	
			e.printStackTrace();
			}
	
		finally {
			
		}
		
	}

}

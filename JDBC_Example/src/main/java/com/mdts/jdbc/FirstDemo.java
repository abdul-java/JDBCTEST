package com.mdts.jdbc;

import java.sql.*;
class FirstDemo {

	public static void main(String []args) throws SQLException {
	
		String username =  "root";
		String password = "1234";
		Connection con =  null;
		
		try{
			//Loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("creating connection");
			
			//creating connection
			 con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/jdbc_example",username,password);

			PreparedStatement pst=con.prepareStatement("insert into emp values(?,?,?)");

			pst.setInt(1,101);
			pst.setString(2,"Adam");
			pst.setString(3,"12000");
			
			pst.executeUpdate();
			System.out.println("inserted");

		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			con.close();    //closing connection
		}
	}
}


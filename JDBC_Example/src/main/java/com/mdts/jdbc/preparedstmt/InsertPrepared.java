package com.mdts.jdbc.preparedstmt;

import java.sql.*;

public class InsertPrepared{  

	// crud operations 
	//  create read update delete 
	public static void main(String args[]){  
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/jdbc_example";
			String username = "root";
			String password = "1234";

			Class.forName(driver);

			Connection con = DriverManager.getConnection(url,username,password);

			// for insert

		// 	PreparedStatement stmt=con.prepareStatement("insert into Emp(id,name,salary) values(?,?,?)"); 

//			stmt.setInt(1,106);//1 specifies the first parameter in the query  
//			stmt.setString(2,"Rajesh");  
//			stmt.setString(3,"10000"); 
//
//			int i=stmt.executeUpdate();   

			// System.out.println(i + " records inserted");  

			//  for Delete
				PreparedStatement stmt=con.prepareStatement("delete from emp where id=?");  
				stmt.setInt(1,101);  
				  
				int i=stmt.executeUpdate();  
				System.out.println(i+" records deleted");  

			con.close();  

		}catch(Exception e)
		{ 
			System.out.println(e);}  
	}  

}  
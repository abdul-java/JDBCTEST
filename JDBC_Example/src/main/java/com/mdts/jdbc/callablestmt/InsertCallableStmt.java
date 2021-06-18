package com.mdts.jdbc.callablestmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertCallableStmt{  

	public static void main(String args[]){  
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/jdbc_example";
			String username = "root";
			String password = "1234";
			
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url,username,password);
		  
		// for getting employee details
		
//		CallableStatement stmt=con.prepareCall("{call getEmpDetails}");  
//		
//		ResultSet rs = stmt.executeQuery();  
//	    while(rs.next())
//	    {  
//	    System.out.println(" "+ rs.getString(1)+" "+ rs.getString(2) );  
//	    }
		
		CallableStatement stmt=con.prepareCall("{call insertValue(?,?,?)}");  
		stmt.setInt(1, 133);
		stmt.setString(2,"sohan");  
		stmt.setString(3,"18000");  
		
		int i= stmt.executeUpdate();  
	   
		System.out.println( i +" records inserted" );   
		
		System.out.println("success");  
		
		
			con.close();  
			
		}catch(Exception e){ System.out.println(e);}  

	}  

}  

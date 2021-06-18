package com.ibm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_Retrieve {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/ibm2021";
	    String username= "root";
	    String password = "1234";
	    	
	    Connection con = DriverManager.getConnection(url,username,password);
	    
	     // retrieving the value 
	    
		PreparedStatement pst = con.prepareStatement("select * from emp" );
		
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1)+ " " + rs.getString(2));
		}
		
		
		// update
		
		pst = con.prepareStatement("update emp set name=? where id =?");
				pst.setString(1, "SURAJ");
				pst.setInt(2, 102);
				
				int i = pst.executeUpdate();
				System.out.println(i + " records updated");
				
		
		con.close();
			
		}
	}



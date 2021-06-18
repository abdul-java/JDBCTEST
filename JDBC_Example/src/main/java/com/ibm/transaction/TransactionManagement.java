package com.ibm.transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagement {

	public static void main(String[] args) throws SQLException, IOException {
		
	
	String url = "jdbc:mysql://localhost:3306/ibm2021";
    String username= "root";
    String password = "1234";
    	
    Connection con = DriverManager.getConnection(url,username,password);
    
    con.setAutoCommit(false);
    
    PreparedStatement pst = con.prepareStatement("insert into student values (?,?,?)");
    BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
    
    while(true) {
    	System.out.println("enter Id : ");
    	
    	String s1 = br.readLine();
    	int id =Integer.parseInt(s1);
    	
    	
    	System.out.println("enter name : ");
    	String name = br.readLine();
    	
    	System.out.println("enter subject : ");
    	String subject = br.readLine();
    	
    	pst.setInt(1, id);
    	pst.setString(2, name);
    	pst.setString(3, subject);
    	
    	pst.executeUpdate();
    	
    	System.out.println(" Commit / Rollback ");
    	
    	String result = br.readLine();
    	if(result.equals("commit")) {
    		con.commit();
    		
    	}
    	if(result.equals("rollback")) {
    		con.rollback();
    	}
    	

    	System.out.println("want to add another record y/n ");
    	String retry = br.readLine();
    	
    	if(retry.equals("n")) {
    		break;
    	}
    	
    }
    
    con.commit();
    System.out.println("record is successfully saved");
    
    con.close();
    
	}
	
}

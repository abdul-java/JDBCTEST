package com.ibm.storingpicture;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPicture {

	public static void main(String[] args) throws SQLException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/ibm2021";
	    String username= "root";
	    String password = "1234";
	    	
	    Connection con = DriverManager.getConnection(url,username,password);
		
		PreparedStatement pst = con.prepareStatement("insert into picture values(?,?)");
		
		pst.setInt(1, 3);  
		
		FileInputStream fis = new FileInputStream("src\\main\\resources\\images\\car.jpg");
	    
	    pst.setBinaryStream(2,fis,fis.available());
	    
	    int i = pst.executeUpdate();
	    System.out.println(i + " image is added");
	    con.close();
	    
	    
	    
	}
	
}

package com.ibm.storingpicture;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiveImage {

	
public static void main(String[] args) throws SQLException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/ibm2021";
	    String username= "root";
	    String password = "1234";
	    	
	    Connection con = DriverManager.getConnection(url,username,password);
		
	    PreparedStatement pst = con.prepareStatement("select * from picture");
	    
	    ResultSet rs = pst.executeQuery();
	    
	    if (rs.next()){
	    	
	    	Blob bl = rs.getBlob(2); // here 2 represent column
	    	
	    	
	    	byte[] byarr = bl.getBytes(1, (int)bl.length());
	    	// here 1 represent as 1st row value
	    	
	    	FileOutputStream fos = new FileOutputStream("src\\main\\resources\\images\\car2.jpg");
	    	
	    	fos.write(byarr);
	    	
	    	fos.close();
	    	}
	    	
	    System.out.println("success");
	    	
	    	
	    }
	    
}


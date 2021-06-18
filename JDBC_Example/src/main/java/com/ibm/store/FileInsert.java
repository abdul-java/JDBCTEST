package com.ibm.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileInsert {

	public static void main(String[] args) throws SQLException, FileNotFoundException {

		String url = "jdbc:mysql://localhost:3306/ibm2021";
	    String username= "root";
	    String password = "1234";
	    	
	    Connection con = DriverManager.getConnection(url,username,password);
		
	    // storing file into database
	    
		PreparedStatement pst = con.prepareStatement("insert into filedb values(?,?)");
		
		File file = new File("E:\\JAVA\\ALL_Examples\\workspace\\jdbc\\JDBC_Example\\src\\main\\resources\\textfile.txt");
		
		FileReader fr = new FileReader(file);
		pst.setInt(1, 101);
		pst.setCharacterStream(2, fr, (int)file.length());
		int i = pst.executeUpdate();
		System.out.println(i + " file text added");
		
		
		
	}

}

package com.mdts.jdbc.store;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertImage{  

	public static void main(String args[]){  
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/jdbc_example";
			String username = "root";
			String password = "1234";
			
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url,username,password);
		   
		// for insert image
		
//		PreparedStatement ps=con.prepareStatement("insert into picture values(?,?)"); 
//		// change the value
//		ps.setInt(1,4);  
//		  
//		FileInputStream fin=new 
//				FileInputStream("E:\\JAVA\\ALL_Examples\\workspace\\jdbc\\jdbc-image-file\\car1.jpg");  
//		ps.setBinaryStream(2,fin,fin.available());  
//		int i=ps.executeUpdate();  
//		System.out.println(i+" records affected");  
//		          
		
		// for retrieve image 
		
		PreparedStatement ps=con.prepareStatement("select * from picture");  
		ResultSet rs=ps.executeQuery();  
		if(rs.next()){//now on 1st row  
		              
		Blob b=rs.getBlob(2);//2 means 2nd column data  
		byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
  // change carnumbers from car1, car2, car3 with this name it will store back and saved in th perticular location 
		FileOutputStream fout=new FileOutputStream("E:\\JAVA\\ALL_Examples\\workspace\\jdbc\\jdbc-image-file\\car3.jpg");  
		fout.write(barr);  
		              
		fout.close();  
		}//end of if  
		System.out.println("success");  
		
		
		
		
		
		
		con.close();  
		}catch (Exception e) {e.printStackTrace();}  
		}  
		}  

package com.mdts.jdbc.preparedstmt;

import java.sql.*;  
import java.io.*;  

public class DynamicallyAdd{  
	public static void main(String args[])throws Exception{  
			
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbc_example";
	String username = "root";
	String password = "1234";
			
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url,username,password);
	
		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");  

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

		do{  
			System.out.println("enter id:");  
			int id=Integer.parseInt(br.readLine());  
			
			System.out.println("enter name:");  
			String name=br.readLine();  
			
			System.out.println("enter salary:");  
			float salary=Float.parseFloat(br.readLine());  

			ps.setInt(1,id);  
			ps.setString(2,name);  
			ps.setFloat(3,salary);  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  

			System.out.println("Do you want to continue: y/n");  
			String s=br.readLine();  
			if(s.startsWith("n")){  
				break;  
			}  
		}while(true);  

		con.close();  
	}
	//}catch(Exception e){ System.out.println(e);}  
}
		
	
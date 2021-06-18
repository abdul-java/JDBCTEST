package com.mdts.jdbc.callablestmt;

import java.sql.*;  
import java.io.*;  
public class TransactionManagement{  
	public static void main(String args[]){  
		try{  

			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/databasename";
			String username= "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url,username,password);

			con.setAutoCommit(false);  

			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");  

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			
			while(true){  

				System.out.println("enter id");  
				String s1=br.readLine();  
				int id=Integer.parseInt(s1);  

				System.out.println("enter name");  
				String name=br.readLine();  

				System.out.println("enter subject");  
				String subject=br.readLine();  
				//String subject=Integer.parseInt(s3);  

				ps.setInt(1,id);  
				ps.setString(2,name);  
				ps.setString(3,subject);  
				ps.executeUpdate();  

				System.out.println("commit/rollback");  
				String answer=br.readLine();  
				if(answer.equals("commit")){  
					con.commit();  
				}  
				if(answer.equals("rollback")){  
					con.rollback();  
				}  

				System.out.println("Want to add more records y/n");  
				String ans=br.readLine();  
				if(ans.equals("n")){  
					break;  
				}  
			}  
			con.commit();  
			System.out.println("record successfully saved");  

			con.close();//before closing connection commit() is called  
		}catch(Exception e){System.out.println(e);}  
	}
	}  

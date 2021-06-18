package com.mdts.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL      = "jdbc:mysql://localhost:3306/world";

	// Database credentials
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";

	public static void main( String[] args ) throws SQLException{

		JDBCDemo jdbcDemo = new JDBCDemo();
		jdbcDemo.getCityInformation();

	}

	private void getCityInformation() throws SQLException
	{
		Connection connection = null;
		Statement stmt = null;
		try
		{
			/*
			 * STEP 1: Register JDBC driver
			 */
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			/*
			 * STEP 2: Open a connection
			 */
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			/*
			 * STEP 3: Execute a query
			 */
			stmt = connection.createStatement();
			
	String sql = 
		"select ID,Name,CountryCode,District, Population from city where id<21";
			
		//	Select * from city;
			
			ResultSet rs = stmt.executeQuery(sql);

			/*
			 * STEP 4: Extract data from result set
			 */
			while( rs.next() )
			{
				/*
				 * Retrieve by column name
				 */
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String countryCode = rs.getString("CountryCode");
				String district = rs.getString("District");
				int population = rs.getInt("Population");

				/*
				 * Display values
				 */
				System.out.print("ID: " + id);
				System.out.print(", Name: " + name);
				System.out.print(", CountryCode: " + countryCode);
				System.out.print(", District: " + district);
				System.out.println(", Population: " + population);
			}
			/*
			 * STEP 5: close resources
			 */
			// connection.close();
			
		}
		catch( SQLException se )
		{
			
			se.printStackTrace();
		}
		catch( ClassNotFoundException e )
        {
	        e.printStackTrace();
        }
		
		finally {
			connection.close();
		}
		

	}

}

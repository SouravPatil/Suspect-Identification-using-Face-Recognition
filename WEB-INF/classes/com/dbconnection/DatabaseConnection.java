package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection 
{
	static Connection con=null;
	public static Connection getConnection() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/personeidentification", "root", "");
			return con;
		}
		catch (Exception e) 
		{
			System.out.println("Exception is 1 " + e);
		}
		
		return con;
	}
	


}

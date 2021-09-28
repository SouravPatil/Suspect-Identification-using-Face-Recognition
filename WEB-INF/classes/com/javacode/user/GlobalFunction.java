package com.javacode.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbconnection.DatabaseConnection;

public class GlobalFunction 
{
	

	static Connection con=DatabaseConnection.getConnection();
	
	public String getMaxCustID()
	{
		String result="";
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT MAX(u_id) FROM `user_details`");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString(1);
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exc in Max get "+e);
		}
		return result;
	}
	
	public String getPoliceEmailID(String id)
	{
		String result="";
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `police_details`");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString("email");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exc in Max get "+e);
		}
		return result;
	}
	
	public String getPoliceName(String email)
	{
		String result="";
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `police_details` where email='"+email+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString("p_name");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exc in Max get "+e);
		}
		return result;
	}
	
	public String getUserName(String email)
	{
		String result="";
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `user_details` where email='"+email+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString("fname");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exc in Max get "+e);
		}
		return result;
	}

	public String getUserMobile(String email)
	{
		String result="";
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `user_details` where email='"+email+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString("mobile");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exc in Max get "+e);
		}
		return result;
	}
	
	
	public String getMaxCriminalID()
	{
		String result="";
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT MAX(c_id) FROM `criminal_details`");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString(1);
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exc in Max get "+e);
		}
		return result;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

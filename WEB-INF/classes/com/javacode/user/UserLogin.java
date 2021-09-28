package com.javacode.user;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbconnection.DatabaseConnection;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	Connection con=null;
	PreparedStatement ps;
	public void init(ServletConfig config) throws ServletException 
	{
		try 
		{
			con=DatabaseConnection.getConnection();
		} 
		catch (Exception e) 
		{
			System.out.println("Exception "+e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("User name "+email);
		System.out.println("password "+password);
		
		String lt= request.getParameter("lt");
		String lng= request.getParameter("lng");
		
		HttpSession session = request.getSession();
		
		
		
		try {
			
			PreparedStatement ps1= con.prepareStatement("SELECT * FROM `user_details` where email='"+ email + "' AND password='" + password + "'");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) 
			{
				
				String name=rs.getString("fname");
				session.setAttribute("name", name);
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				session.setAttribute("lt", lt);
				session.setAttribute("lng", lng);
				session.setAttribute("u_type", "User");
				
				session.setAttribute("mobile", rs.getString("mobile"));
				session.setAttribute("address", rs.getString("address"));
				
				System.out.println("Login Done");
				response.sendRedirect("userHome.jsp?login=done");

			} 
			else
			{
				PreparedStatement ps2= con.prepareStatement("SELECT * FROM `police_details` where email='"+ email + "' AND password='" + password + "'");
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next())
				{
					session.setAttribute("pname", rs2.getString("p_name"));
					session.setAttribute("email", rs2.getString("email"));
					session.setAttribute("username", email);
					session.setAttribute("password", password);
					session.setAttribute("u_type", "Police");
					
					System.out.println(" Police Login Done");
					response.sendRedirect("policeHome.jsp?login=done");
				}
				else
				{
					System.out.println("Login fail");
					response.sendRedirect("userLogin.jsp?login=fail");
				}
			}
			
			
		} catch (SQLException e) {
			System.out.println("Exception Occure :- " + e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

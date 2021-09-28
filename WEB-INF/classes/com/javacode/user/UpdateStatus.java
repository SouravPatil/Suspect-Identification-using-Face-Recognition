package com.javacode.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconnection.DatabaseConnection;

/**
 * Servlet implementation class UpdateStatus
 */
@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String sts=request.getParameter("sts");
		
		try 
		{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps1=con.prepareStatement("UPDATE `complaints_details` SET `status`='"+sts+"' WHERE `id`='"+id+"'");
			int i=ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Update Done");
			}
			response.sendRedirect("viewAllComplaints.jsp?sts=update");
			
		} catch (Exception e) 
		{
			System.out.println("Exc "+e);
		}
		
		
	}

}
 
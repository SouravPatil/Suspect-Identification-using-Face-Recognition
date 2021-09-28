package com.javacode.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import call_python.CallPython;

import com.dbconnection.DatabaseConnection;

/**
 * Servlet implementation class AddCriminalRecord
 */
@WebServlet("/AddCriminalRecord")
public class AddCriminalRecord extends HttpServlet {
	static Connection con=null;
	public void init(ServletConfig config) throws ServletException {
		try {
			con = DatabaseConnection.getConnection();

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String full_name=fname+" "+lname;
		String c_type = request.getParameter("c_type");
		String about_criminal = request.getParameter("about_criminal");
		
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		
		try 
		{
			
			PreparedStatement ps1=con.prepareStatement("INSERT INTO `criminal_details`(`criminal_name`, `c_type`, `about_c`,`add_by`) VALUES ('"+full_name+"','"+c_type+"','"+about_criminal+"','"+username+"')");
			int i=ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Reg Done");
			}
			
			GlobalFunction gf=new GlobalFunction();
			String max_id=gf.getMaxCriminalID();
			System.out.println("Max Ciminal ID ID "+max_id);
			
			String result =  CallPython.sendName(max_id);
			System.out.println("result "+result);
			if(result.contains("OK Register Sucessfully!!!!")) 
			{
				response.sendRedirect("addCriminalRecord.jsp?reg=done");
			}
			else
			{
				response.sendRedirect("addCriminalRecord.jsp?fail=reg");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception " + e);
		}
	}
}

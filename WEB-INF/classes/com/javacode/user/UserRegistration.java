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

import call_python.CallPython;

import com.dbconnection.DatabaseConnection;


/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet 
{
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
		String uid = request.getParameter("uid");
		String email = request.getParameter("email");
		
		String mnumber = request.getParameter("mnumber");
		String address = request.getParameter("address");
		
		String password = request.getParameter("password");
		
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM  `user_details` where email='"+email+"' OR uid='"+uid+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("userRegistration.jsp?already=done");
			}
			else
			{
				PreparedStatement ps1=con.prepareStatement("INSERT INTO `user_details`(`fname`, `uid`, `mobile`, `address`, `email`, `password`) VALUES ('"+fname+"','"+uid+"','"+mnumber+"','"+address+"','"+email+"','"+password+"')");
				int i=ps1.executeUpdate();
				if(i>0)
				{
					
					System.out.println("Reg Done");
				}
				GlobalFunction gf=new GlobalFunction();
				String max_id=gf.getMaxCustID();
				System.out.println("Max ID "+max_id);
				
				
				String result =  CallPython.sendName(max_id);
				System.out.println("result "+result);
				if(result.contains("OK Register Sucessfully!!!!")) 
				{
					String msg=" Dear user Your Account Creat Successfuly..! Email ID:- "+email+" Passwprd:- "+password;
					SendMailSMTP sms=new SendMailSMTP();
					sms.EmailSending(email,"Account Details",msg);
					
					response.sendRedirect("userLogin.jsp?reg=done");
				}
				else
				{
					response.sendRedirect("createAccount.jsp?fail=reg");
				}
						
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception " + e);
		}
	}
}

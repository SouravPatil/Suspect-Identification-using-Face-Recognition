package com.javacode.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

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
 * Servlet implementation class AddSubUser
 */
@WebServlet("/AddSubUser")
public class AddSubUser extends HttpServlet 
{
	static Connection con=null;
	public void init(ServletConfig config) throws ServletException 
	{
		try 
		{
			con = DatabaseConnection.getConnection();
		} catch (Exception e) 
		{
			System.out.println("Exception:" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String full_name=fname+" "+lname;
		String uid = request.getParameter("uid");
		String relation = request.getParameter("relation");
		
		String gender = request.getParameter("gender");
		String p_address = request.getParameter("p_address");
		String c_address = request.getParameter("c_address");
		String ref_name = request.getParameter("ref_name");
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dateobj = new Date();
		String c_date_time = df.format(dateobj);
		System.out.println("Current Date "+c_date_time);
		
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		System.out.println("Emai "+email);
		/*String lt=session.getAttribute("lt").toString();
		String lng=session.getAttribute("lng").toString();
		*/
		String address=session.getAttribute("address").toString();
		System.out.println("Address "+address);
		String mobile=session.getAttribute("mobile").toString();
		System.out.println("Mobile "+mobile);
		
		
		
		//TreeMap<Double, String> first_loc=nearestPlace.firstEntry();
		//System.out.println("Nearest "+

		
		
		
		try 
		{
			
			String result = CallPython.CheckUser();
			if (result.contains(" User authenticated!!!!")) 
			{
				System.out.println("Criminal Detect ");
				// HttpSession session=request.getSession(true);
				String name = result.substring(result.indexOf("OK") + 2,
				result.indexOf("User authenticated!!!!"));
				String id = name.replaceAll("_", " ");
				//session.setAttribute("UserName", name.replaceAll("_", " "));
				id = id.trim();
				System.out.println("Criminal ID " + id.trim());
				
				CalculateDistance cd=new CalculateDistance();
				String nearestPlace = cd.getNearestPlace(request);
				System.out.println("Nearest P ID "+nearestPlace);
				
				GlobalFunction gf=new GlobalFunction();
				String p_email=gf.getPoliceEmailID(nearestPlace);
				SendMailSMTP sms=new SendMailSMTP();
				String msg="Hello sir Suspect Detection on below Address "+address+" Or Please Contact below Details\n Email"+email+"\n"+"Mobile Number "+mobile;
				sms.EmailSending(p_email, "Suspect Detection Alert", msg);
				response.sendRedirect("addSubUser.jsp?suspect=detection");

			}
			else
			{
				System.out.println("Non Criminal Person");
			
					PreparedStatement ps1=con.prepareStatement("INSERT INTO `sub_details`(`user_fname`, `user_uid`, `p_address`, `c_address`, `refenrnce_name`, `c_date`, `user_add_by`, `gender`,`u_relation`) VALUES ('"+full_name+"','"+uid+"','"+p_address+"','"+c_address+"','"+ref_name+"','"+c_date_time+"','"+email+"','"+gender+"','"+relation+"')");
					int i=ps1.executeUpdate();
					if(i>0)
					{
						System.out.println("Reg Done");
					}
				response.sendRedirect("addSubUser.jsp?normal=persone");
				
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception " + e);
		}
	}
}

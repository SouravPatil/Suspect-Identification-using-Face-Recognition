package com.javacode.user;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.File; 

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;



import com.dbconnection.DatabaseConnection;

/**
 * Servlet implementation class ComplaintsDetails
 */
@WebServlet("/ComplaintsDetails")
public class ComplaintsDetails extends HttpServlet {
	static Connection con;
	final String UPLOAD_DIRECTORY = "E:/SGM_2021_workspace2/PersoneIdentificationR3/WebContent/complaints/";
	static int i = 0;
	
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) 
		{
			try 
			{
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				System.out.println("ABCD");
				String FileName = "";
				String FileExtention = "";
				long FileSize = 0;

				for (FileItem item1 : multiparts)
				{
					if (!item1.isFormField()) 
					{

						System.out.println("4");
						String name = new File(item1.getName()).getName();
						item1.write(new File(UPLOAD_DIRECTORY + File.separator+name));
						FileName = item1.getName();
						FileExtention = item1.getContentType();
						FileSize = item1.getSize();
					}
				}

				String complaint="";
				
				
				
				for (FileItem item : multiparts)
				{
					if ((item.getFieldName()).equals("complaints"))
					{
						complaint = (String) item.getString();
					}
				}

				System.out.println("FileName " + FileName);
				System.out.println("File Extension " + FileExtention);
				System.out.println("File Size " + FileSize);

				HttpSession session=request.getSession();
				String email_id=session.getAttribute("email").toString();
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date dateobj = new Date();
				String c_date = df.format(dateobj);
				System.out.println("C Date " + c_date);

				String email=session.getAttribute("email").toString();
				
				String lt=session.getAttribute("lt").toString();
				String lng=session.getAttribute("lng").toString();
				CalculateDistance cd=new CalculateDistance();
				String nearestPlace = cd.getNearestPlace(request);
				
				PreparedStatement ps1 = con.prepareStatement("INSERT INTO `complaints_details`(`complaint_details`, `c_date`, `complaint_by`, `assogn_to`, `img_name`, `status`) VALUES ('"+complaint+"','"+c_date+"','"+email+"','"+nearestPlace+"','"+FileName+"','Waitting')");
				int rs = ps1.executeUpdate();
				if (rs > 0) 
				{
					System.out.println("Complaint Send Done ");
					response.sendRedirect("addComplaints.jsp?add=complaint");
				} else 
				{
					System.out.println("Fail Complaints Send  ");
					response.sendRedirect("addComplaints.jsp?fail=upload");
				}
			}
			catch (Exception ex) {
				System.out.println("Exception e" +ex);
			}
		}
		else 
		{
			System.out.println("Condition False");
			response.sendRedirect("addComplaints.jsp?fail=uplaod");
		}
	}
}
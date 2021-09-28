package com.javacode.user;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dbconnection.DatabaseConnection;

public class CalculateDistance 
{

	static Connection con=DatabaseConnection.getConnection();
	
	public String getNearestPlace(HttpServletRequest request)
	{
		
		CalculateDistance cd=new CalculateDistance();
		CalcDist cdd=new CalcDist();
		HttpSession session=request.getSession();
		
		double c_latt=Double.parseDouble(session.getAttribute("lt").toString());
		double c_longi=Double.parseDouble(session.getAttribute("lng").toString());
		
		//HashMap<Double, String> result=new HashMap<>();
		TreeMap<Double, String> result=new TreeMap<Double, String>();
		
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `police_details`");
			ResultSet rs=ps.executeQuery();
			System.out.println("PS "+ps);
			while(rs.next())
			{
				//String username=rs.getString("username");
				String user_id=rs.getString("email");
				double db_latt=Double.parseDouble(rs.getString("p_lat"));
				double db_longi=Double.parseDouble(rs.getString("p_long"));
				
				double dist=cdd.distance(c_latt, c_longi,  db_latt, db_longi,"K");
				
				System.out.println("Dist "+dist);
				
				result.put(dist, user_id);
				
				//result.put(String.valueOf(dist), cropt_name);
			}
			// TreeMap<Double, String> result1=result.sorted.entrySet();
			
		} catch (Exception e) 
		{
			System.out.println("Exc "+e);
		}	
		
		TreeMap<Double, String> sorted_result =CalculateDistance.sortbykey(result);
		
		Double neares_p_id=sorted_result.firstKey();
		String n_p_id=sorted_result.get(neares_p_id);
		return n_p_id;
		
	}
	
	
	
	
	public static double distance(double lat1, double lat2, double lon1, double lon2, char a1) 
	
	{

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    System.out.println("Distance "+distance);
	    /*
	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);
*/
	    return Math.sqrt(distance);
	    
	    
	}
	
	public static TreeMap<Double, String> sortbykey(TreeMap<Double, String> map)
    {
		TreeMap<Double, String> result = new TreeMap<>();
		// TreeMap to store values of HashMap
        TreeMap<Double, String> sorted = new TreeMap<>();
 
        // Copy all data from hashMap into TreeMap
        sorted.putAll(map);
 
        // Display the TreeMap which is naturally sorted
        for (Map.Entry<Double, String> entry : sorted.entrySet())
        {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        	result.put(entry.getKey(), entry.getValue());
        }	
        
        return result;
    }
	
	
	/*public double distance(double lat1, double lat2, double lon1, double lon2) {

		// The math module contains a function
		// named toRadians which converts from
		// degrees to radians.
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of earth in kilometers. Use 3956
		// for miles
		double r = 6371;

		// calculate the result
		return (c * r);
	}

*/	
	public static void main(String[] args) 
	{
		double lat1 = 53.32055555555556;
		double lat2 = 53.31861111111111;
		double lon1 = -1.7297222222222221;
		double lon2 = -1.6997222222222223;
		
		//System.out.println(distance(lat1, lat2, lon1, lon2) + " K.M");

	}

}

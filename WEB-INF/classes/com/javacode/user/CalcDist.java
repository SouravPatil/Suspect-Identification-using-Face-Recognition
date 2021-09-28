package com.javacode.user;

public class CalcDist {

	public double distance(double lat1, double lon1, double lat2, double lon2, String unit)
	{
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
	
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

	public static void main(String[] args) {
		try 
		{
			CalcDist cd=new CalcDist();

			System.out.println(cd.distance(32.9697, -96.80322, 29.46786,-98.53506, "M") + " Miles\n");
			System.out.println(cd.distance(32.9697, -96.80322, 29.46786,-98.53506, "K") + " Kilometers\n");
			System.out.println(cd.distance(32.9697, -96.80322, 29.46786,-98.53506, "N") + " Nautical Miles\n");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

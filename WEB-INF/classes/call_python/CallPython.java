package call_python;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;

import common.Common;

public class CallPython {
	
	public static String sendName(String name) {
		System.out.println("sendTestDataSet");
		String result ="";
		try {

			//file path of expediaFetchData.py file 
			//Change this path accordingly
			//"C:\\ProgramData\\Anaconda3\\envs\\parth\\python",
				
			String filePath=Common.Filepath+"/Create_Database.py";
			String[] cmd={
					//path where python.exe is stored 
					//Change this path accordingly
					Common.AnacondaPath,
					filePath,
					name,
					Common.Filepath
			};
			
			//This command is used to call the program
			Runtime rt= Runtime.getRuntime();
			Process pr=rt.exec(cmd);
			
			//Get the error message or input stream message from expediaFetchData.py
			BufferedReader bre = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
			BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line="";
			
			//print the message
			result ="ERROR ";
			while((line=bre.readLine())!= null){
				result +=line;
				System.err.println(line);
			}
			result ="OK ";
			while((line=bfr.readLine())!= null){
				result +=line;
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String sendReName(String name) {
		System.out.println("sendTestDataSet");
		String result ="";
		try {

			//file path of expediaFetchData.py file 
			//Change this path accordingly
			//"C:\\ProgramData\\Anaconda3\\envs\\parth\\python",
				
			String filePath=Common.Filepath+"/re_Create_Database.py";
			String[] cmd={
					//path where python.exe is stored 
					//Change this path accordingly
					Common.AnacondaPath,
					filePath,
					name,
					Common.Filepath
			};
			
			//This command is used to call the program
			Runtime rt= Runtime.getRuntime();
			Process pr=rt.exec(cmd);
			
			//Get the error message or input stream message from expediaFetchData.py
			BufferedReader bre = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
			BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line="";
			
			//print the message
			result ="ERROR ";
			while((line=bre.readLine())!= null){
				result +=line;
				System.err.println(line);
			}
			result ="OK ";
			while((line=bfr.readLine())!= null){
				result +=line;
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String CheckUser() 
	{
		System.out.println("sendTestDataSet");
		String result ="";
		try {

			//file path of expediaFetchData.py file 
			//Change this path accordingly
			//"C:\\ProgramData\\Anaconda3\\envs\\parth\\python",
				
			String filePath=Common.Filepath+"/Recognise_User.py";
			String[] cmd={
					//path where python.exe is stored 
					//Change this path accordingly
					Common.AnacondaPath,
					filePath,
					Common.Filepath
			};
			
			//This command is used to call the program
			Runtime rt= Runtime.getRuntime();
			Process pr=rt.exec(cmd);
			
			//Get the error message or input stream message from expediaFetchData.py
			BufferedReader bre = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
			BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line="";
			
			//print the message
			result ="ERROR ";
			while((line=bre.readLine())!= null){
				result +=line;
				System.err.println(line);
			}
			result ="OK ";
			while((line=bfr.readLine())!= null){
				result +=line;
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String args[]) {
		//CallPython.sendTestDataSet("","","","","","");
	}
}

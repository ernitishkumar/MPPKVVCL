package com.mppkvvcl.rdu.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	private static Connection connection=null;
	
	public static Connection getConnection()
	{
		if(connection == null){
			try {
				//System.out.println("In Driver1");
			Class.forName("org.mariadb.jdbc.Driver");
				//System.out.println("In Driver2");
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rdu","root", "");
			//connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rdu?user=rdu&password=rdu#1010");
			//connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rdu","root", "1010");
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
}

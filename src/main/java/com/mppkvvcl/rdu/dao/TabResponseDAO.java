package com.mppkvvcl.rdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mppkvvcl.rdu.bean.TabResponse;
import com.mppkvvcl.rdu.bean.ViewDetail;
import com.mppkvvcl.rdu.connection.GetConnection;

public class TabResponseDAO {

	
	public boolean checkTabResponseN(String deviceSelected)
	{
		
		boolean hasRowWithNstatus=false;
		
		int updatedRows=0;
		Connection connection=GetConnection.getConnection();
		
		try {
			//PreparedStatement preparedStatement=connection.prepareStatement("select * from tab_response where device_name=? and status=?");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from tab_responce where device_name=? and status=?");
			
			preparedStatement.setString(1, deviceSelected);
			preparedStatement.setString(2,"N");
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("Id");
				String deviceName=rs.getString("device_name").trim();
				String t1=rs.getString("T1").trim();
				String t2=rs.getString("T2").trim();
				String t3=rs.getString("T3").trim();
				String t4=rs.getString("T4").trim();
				String t5=rs.getString("T5").trim();
				String t6=rs.getString("T6").trim();
				String status=rs.getString("status").trim();
				
				hasRowWithNstatus=true;
			}
			System.out.println("In Check Tab Response");
			
			
		} 
		
		catch(java.sql.SQLIntegrityConstraintViolationException e)
		{
			
			
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		return hasRowWithNstatus;
		
		
		
		
	}
	
	public TabResponse addTabResponse(TabResponse tabResponse)
	{		
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		
		Date dateNow=new Date();
		String dateTime=sdf.format(dateNow);
		String arr[]=dateTime.trim().split(" ");
		System.out.println(sdf.format(dateNow));
		System.out.println(arr[0]+" "+arr[1]);
		
		
		int updatedRows=0;
		Connection connection=GetConnection.getConnection();
			
		tabResponse=prepareProperResponse(tabResponse);
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into tab_responce(device_name,T1,T2,T3,T4,T5,T6,op_date,op_time,status) values(?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, tabResponse.getDeviceName());
			preparedStatement.setString(2,tabResponse.getT1());
			preparedStatement.setString(3,tabResponse.getT2());
			preparedStatement.setString(4,tabResponse.getT3());
			preparedStatement.setString(5,tabResponse.getT4());
			preparedStatement.setString(6,tabResponse.getT5());
			preparedStatement.setString(7,tabResponse.getT6());
			preparedStatement.setString(8, arr[0]);
			preparedStatement.setString(9, arr[1]);
			preparedStatement.setString(10,tabResponse.getStatus());
			
			updatedRows=preparedStatement.executeUpdate();
			
			System.out.println("inserted Add Tab Response"+updatedRows+"device");
			
			
		} 
		
		catch(java.sql.SQLIntegrityConstraintViolationException e)
		{
		 updatedRows=-1;	
			
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		return tabResponse;
		
		
		}

	public TabResponse prepareProperResponse(TabResponse tabResponse) {

		tabResponse.setStatus("N");
		
		System.out.println(tabResponse.getTerminalNumber().charAt(0));
		switch (tabResponse.getTerminalNumber().charAt(0)) {
		
		case '1':
		
		if(tabResponse.getT1().equalsIgnoreCase("0"))
		{
			tabResponse.setT1("1");
			
		}
		else{
			
			tabResponse.setT1("0");
		}
			
		break;

		case '2':
				

			if(tabResponse.getT2().equalsIgnoreCase("0"))
			{
				tabResponse.setT2("1");
				
			}
			else{
				
				tabResponse.setT2("0");
			}
				break;
		case '3':
			

			if(tabResponse.getT3().equalsIgnoreCase("0"))
			{
				tabResponse.setT3("1");
				
			}
			else{
				
				tabResponse.setT3("0");
			}
				break;
				
				
		case '4':

			if(tabResponse.getT4().equalsIgnoreCase("0"))
			{
				tabResponse.setT4("1");
				
			}
			else{
				
				tabResponse.setT4("0");
			}	
				break;

		case '5':

			if(tabResponse.getT5().equalsIgnoreCase("0"))
			{
				tabResponse.setT5("1");
				
			}
			else{
				
				tabResponse.setT5("0");
			}		
		break;
		
		
		case '6':

			if(tabResponse.getT6().equalsIgnoreCase("0"))
			{
				tabResponse.setT6("1");
				
			}
			else{
				
				tabResponse.setT6("0");
			}		
		break;
				
		default:
			break;
		}
		
		
			
		return tabResponse;
	}
	
	
	
}

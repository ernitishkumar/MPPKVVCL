package com.mppkvvcl.rdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mppkvvcl.rdu.bean.Device;
import com.mppkvvcl.rdu.bean.ViewDetail;
import com.mppkvvcl.rdu.connection.GetConnection;

public class ViewDAO {

	
	public List<ViewDetail> getAll(String deviceName)
	{
		ViewDetail device=null;
		List<ViewDetail> deviceList=new ArrayList<ViewDetail>();
		
		Connection connection=GetConnection.getConnection();
		
		try {
			//PreparedStatement preparedStatement=connection.prepareStatement("select t.device,t.accountnumber,t.terminalnumber,t.name,d.* from consumer t,device_data d where t.device=d.device_name");
			
			PreparedStatement preparedStatement=connection.prepareStatement("select t.device,t.accountnumber,t.terminalnumber,t.name,d.* from consumer t,device_data d where t.device=d.device_name and t.device=? order by t.terminalnumber");
			
			preparedStatement.setString(1, deviceName);
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				device=new ViewDetail();
				
				device.setDevice(rs.getString("device"));
				device.setAccountNumber(rs.getString("accountnumber"));
				device.setTerminalNumber(rs.getString("terminalnumber"));
				device.setName(rs.getString("name"));
				device.setT1(rs.getString("T1"));
				device.setT2(rs.getString("T2"));
				device.setT3(rs.getString("T3"));
				device.setT4(rs.getString("T4"));
				device.setT5(rs.getString("T5"));
				device.setT6(rs.getString("T6"));
				
				deviceList.add(device);
				
			}
			deviceList=filterViewData(deviceList);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deviceList;
		
	}
	
	public static String getStatus(char input)
	{
		
		if(input=='0')
		{
			return "ON";	
			
		}
		else{
			
			return "OFF";
				
		}
		
		
		
	}
	public static List<ViewDetail> filterViewData(List<ViewDetail> device)
	{
		
		
		
		
		for(ViewDetail v:device){
			
		switch (v.getTerminalNumber().trim().charAt(0)) {
		case '1':
			
			v.setStatus(getStatus(v.getT1().trim().charAt(0)));
			
			break;

		case '2':
			v.setStatus(getStatus(v.getT2().trim().charAt(0)));
			break;
		
		case '3':
			v.setStatus(getStatus(v.getT3().trim().charAt(0)));
			break;
		case '4':
			v.setStatus(getStatus(v.getT4().trim().charAt(0)));
			break;
		case '5':
			v.setStatus(getStatus(v.getT5().trim().charAt(0)));
			break;
		case '6':
			v.setStatus(getStatus(v.getT6().trim().charAt(0)));
			break;
			default:
				
			
				break;
		}
		
		
		}
		
		
		
		
		return device;
		
		
	}
		
		
	
}

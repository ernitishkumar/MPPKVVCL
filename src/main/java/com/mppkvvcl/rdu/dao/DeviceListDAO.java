package com.mppkvvcl.rdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mppkvvcl.rdu.bean.Device;
import com.mppkvvcl.rdu.connection.GetConnection;

public class DeviceListDAO {
		public List<Device> getAllDevice()
		{
		Device device=null;
		List<Device> deviceList=new ArrayList<Device>();
		Connection connection=GetConnection.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from device");
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				device=new Device();
				device.setId(rs.getInt("id"));
				device.setDevice(rs.getString("device_name"));
				device.setNameOfFeeder(rs.getString("nameOfFeeder"));
				device.setPoleNumber(rs.getString("poleNumber"));
				device.setSimNo(rs.getLong("SimNo"));
				device.setZoneName(rs.getString("zoneName"));
				device.setDateOfInstallation(rs.getDate("dateOfInstallation"));
				deviceList.add(device);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deviceList;
		}	
	}
	


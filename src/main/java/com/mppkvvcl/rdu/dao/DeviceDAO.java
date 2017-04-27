package com.mppkvvcl.rdu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mppkvvcl.rdu.bean.Device;
import com.mppkvvcl.rdu.connection.GetConnection;

public class DeviceDAO {

	public int addDevice(Device device)
	{
	int updatedRows=0;
	Connection connection=GetConnection.getConnection();
		
	try {
		PreparedStatement preparedStatement=connection.prepareStatement("insert into device(device_name,nameOfFeeder,poleNumber,dateOfInstallation,zoneName,SimNo) values(?,?,?,?,?,?)");
		
		preparedStatement.setString(1, device.getDevice());
		preparedStatement.setString(2, device.getNameOfFeeder());
		preparedStatement.setString(3, device.getPoleNumber());
		preparedStatement.setDate(4, new java.sql.Date(device.getDateOfInstallation().getTime()));
		preparedStatement.setString(5,device.getZoneName() );
		preparedStatement.setLong(6,device.getSimNo() );		
		
		updatedRows=preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return updatedRows;
	
	
	}
	
	
	
	
	
}

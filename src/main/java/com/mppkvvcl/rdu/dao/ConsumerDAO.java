package com.mppkvvcl.rdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mppkvvcl.rdu.bean.Consumer;
import com.mppkvvcl.rdu.connection.GetConnection;

public class ConsumerDAO {

	public int addConsumer(Consumer consumer)
	{
	int updatedRows=0;
	Connection connection=GetConnection.getConnection();
		
	try {
		PreparedStatement preparedStatement=connection.prepareStatement("insert into consumer(device,accountnumber,name,address,polenumber,terminalnumber) values(?,?,?,?,?,?)");
		
		preparedStatement.setString(1, consumer.getDevice());
		preparedStatement.setString(2, consumer.getAccountNumber());
		preparedStatement.setString(3, consumer.getName());
		preparedStatement.setString(4, consumer.getAddress());
		preparedStatement.setString(5, consumer.getPoleNumber());
		preparedStatement.setString(6, consumer.getTerminalNumber());
	
		updatedRows=preparedStatement.executeUpdate();
		
		System.out.println("inserted "+updatedRows+"consumer");
		
		
	} 
	
	catch(java.sql.SQLIntegrityConstraintViolationException e)
	{
	return updatedRows=-1;	
		
	}
	catch (SQLException e) {
	e.printStackTrace();
	}
	return updatedRows;
	
	
	}
	
	public int updateConsumer(Consumer consumer)
	{
	int updatedRows=0;
	Connection connection=GetConnection.getConnection();
		
	try {
		PreparedStatement preparedStatement=connection.prepareStatement("update consumer set polenumber=?,terminalnumber=?) where accountnumber=?");
		
		preparedStatement.setString(1, consumer.getPoleNumber());
		preparedStatement.setString(2, consumer.getTerminalNumber());
		preparedStatement.setString(3, consumer.getAccountNumber());
	
		updatedRows=preparedStatement.executeUpdate();
		
		System.out.println("Updated  "+updatedRows+"consumer");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return updatedRows;
	
	
	}
	
	public List<Consumer> getConsumersByDeviceId(String deviceId){
		List<Consumer> consumers = new ArrayList<Consumer>();
		Connection connection=GetConnection.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from consumer where device=?");
			preparedStatement.setString(1, deviceId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
			 Consumer consumer = new Consumer();
			 consumer.setDevice(rs.getString(2).trim());
			 consumer.setAccountNumber(rs.getString(3).trim());
			 consumer.setName(rs.getString(4).trim());
			 consumer.setAddress(rs.getString(5).trim());
			 consumer.setPoleNumber(rs.getString(6).trim());
			 consumer.setTerminalNumber(rs.getString(7).trim());
			 consumers.add(consumer);
			}
		} catch (SQLException e) {
			System.out.println("Exception in class ConsumerDAO : method : getConsumersByDeviceId(String) ");
			e.printStackTrace();
		}
		return consumers;
	}
	
	public List<Consumer> getConsumersByDeviceIdWithStatus(String deviceId){
		List<Consumer> consumers = new ArrayList<Consumer>();
		Connection connection=GetConnection.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select c.*,dts.status from consumer c "+
					"join device_terminal_status dts on dts.device=c.device and dts.terminal_no=c.terminalnumber "+
					"where c.device=? ");
			preparedStatement.setString(1, deviceId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
			 Consumer consumer = new Consumer();
			 consumer.setDevice(rs.getString(2).trim());
			 consumer.setAccountNumber(rs.getString(3).trim());
			 consumer.setName(rs.getString(4).trim());
			 consumer.setAddress(rs.getString(5).trim());
			 consumer.setPoleNumber(rs.getString(6).trim());
			 consumer.setTerminalNumber(rs.getString(7).trim());
			 consumer.setTerminalStatus(rs.getInt(8));
			 consumers.add(consumer);
			}
		} catch (SQLException e) {
			System.out.println("Exception in class ConsumerDAO : method : getConsumersByDeviceId(String) ");
			e.printStackTrace();
		}
		return consumers;
	}
}

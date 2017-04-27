package com.mppkvvcl.rdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mppkvvcl.rdu.bean.Consumer;
import com.mppkvvcl.rdu.bean.LoginBean;
import com.mppkvvcl.rdu.connection.GetConnection;

public class LoginDAO {

	public boolean checkLogin(LoginBean loginBean)
	{
		
	boolean authenticate=false;

	Connection connection=GetConnection.getConnection();
		
	try {
		PreparedStatement preparedStatement=connection.prepareStatement("select * from login where username=? and password=?");
		
		preparedStatement.setString(1,loginBean.getUsername() );
		preparedStatement.setString(2,loginBean.getPassword() );
		ResultSet rs=preparedStatement.executeQuery();
		
		while(rs.next())
		{
			
			authenticate=true;
		}
		
		
		
	} 
	
	catch(java.sql.SQLIntegrityConstraintViolationException e)
	{
		
		
	}
	catch (SQLException e) {
	e.printStackTrace();
	}
	return authenticate;
	
	
	}
	
	
}

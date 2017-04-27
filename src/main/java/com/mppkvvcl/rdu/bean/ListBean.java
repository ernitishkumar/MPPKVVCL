package com.mppkvvcl.rdu.bean;

import java.util.List;

import com.mppkvvcl.rdu.dao.DeviceListDAO;

public class ListBean {
	 public List<Device> list;

	  
	  public ListBean()
      {
		  System.out.println("Calling get all devices..");
      	this.list=new DeviceListDAO().getAllDevice();
      	
      	System.out.println("Size of list  "+list.size());
      }

	  
	  
	  public List<Device> getItems() {
        return this.list;
        
	  }
      
	}
	


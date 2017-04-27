package com.mppkvvcl.rdu.bean;

import java.util.Date;

public class Device {
	
	private int id;
	private String device;
	private String nameOfFeeder;
	private String poleNumber;
	private Date dateOfInstallation;
	private String zoneName;
	private long SimNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getNameOfFeeder() {
		return nameOfFeeder;
	}
	public void setNameOfFeeder(String nameOfFeeder) {
		this.nameOfFeeder = nameOfFeeder;
	}
	public String getPoleNumber() {
		return poleNumber;
	}
	public void setPoleNumber(String poleNumber) {
		this.poleNumber = poleNumber;
	}
	public Date getDateOfInstallation() {
		return dateOfInstallation;
	}
	public void setDateOfInstallation(Date dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public long getSimNo() {
		return SimNo;
	}
	public void setSimNo(long simNo) {
		SimNo = simNo;
	}
	
	
	
	
}

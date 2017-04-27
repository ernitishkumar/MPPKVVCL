package com.mppkvvcl.rdu.bean;

public class Consumer {
	
private int id;
private String device;
private String accountNumber;
private String name;
private String address;
private String poleNumber;
private String terminalNumber;
private int terminalStatus;

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
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPoleNumber() {
	return poleNumber;
}
public void setPoleNumber(String poleNumber) {
	this.poleNumber = poleNumber;
}
public String getTerminalNumber() {
	return terminalNumber;
}
public void setTerminalNumber(String terminalNumber) {
	this.terminalNumber = terminalNumber;
}
public int getTerminalStatus() {
	return terminalStatus;
}
public void setTerminalStatus(int terminalStatus) {
	this.terminalStatus = terminalStatus;
}
}

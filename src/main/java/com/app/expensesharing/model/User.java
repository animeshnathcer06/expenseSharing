package com.app.expensesharing.model;

import java.util.HashMap;
import java.util.Map;

public class User {
	private String userId;
	private String name;
	private String emailId;
	private String mobileNumber;
	private Map<User, Double> balanceMap;

	
	public User(String userId, String name, String emailId, String mobileNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.balanceMap = new HashMap<>();
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Map<User, Double> getBalanceMap() {
		return balanceMap;
	}	
}

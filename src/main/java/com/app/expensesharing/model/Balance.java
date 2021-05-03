package com.app.expensesharing.model;

import java.util.List;

public class Balance {

	private double amount;
	private User fromUser;
	private List<User> toUser;
	
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public User getFromUser() {
		return fromUser;
	}
	
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	
	public List<User> getToUser() {
		return toUser;
	}
	
}

package com.app.expensesharing.service;

import java.util.Collection;
import java.util.Map;

import com.app.expensesharing.model.User;

public class ShowService {

	UserService userService = UserService.getInstance();

	public void printAll() {
		String allBalances = getAllBalances(userService.fetchAll());
		if (allBalances.isEmpty()) System.out.println("No Balances");
		else System.out.println(allBalances);
	}
	
	public void print(String userId) throws Exception {
		User user = userService.fetchUser(userId);
		String balance = printOne(user);
		if (balance.isEmpty()) System.out.println("No Balances");
		else System.out.println(balance);
	}
	
	private String getAllBalances(Collection<User> allUsers) {
		StringBuilder  builder = new StringBuilder();
		for (User user : allUsers) {
			String balance = printOne(user);
			if (!balance.isEmpty()) builder.append(balance).append("\n");
		}
		return builder.toString();
	}

	private String printOne(User user) {
		String uid = user.getUserId();
		Map<User, Double> balanceMap = user.getBalanceMap();
		StringBuilder builder = new StringBuilder();
		if (balanceMap.isEmpty()) return "";
		for (Map.Entry<User, Double> entry : balanceMap.entrySet()) {
			if (entry.getValue() > 0)
				builder.append(uid).append(" owes ").append(entry.getKey().getUserId()).append(" : ").append(entry.getValue());
		}
		return builder.toString();
	}

	public static ShowService getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}

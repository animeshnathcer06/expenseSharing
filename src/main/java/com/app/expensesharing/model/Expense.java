package com.app.expensesharing.model;

import java.util.List;

import com.app.expensesharing.util.ExpenseType;

public class Expense {

	ExpenseType type;
	double amount;
	User toUser;
	List<User> expenseUsers;
	
	void updateBalances() {
		
	}
}

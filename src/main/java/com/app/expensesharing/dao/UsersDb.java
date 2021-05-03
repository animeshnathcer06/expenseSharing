package com.app.expensesharing.dao;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import com.app.expensesharing.model.User;

public final class UsersDb {
	
	private static final UsersDb INSTANCE = new UsersDb();
	private ConcurrentHashMap<String, User> users;
	private UsersDb() {users = new ConcurrentHashMap<>();}

	// for creation only
	public User add(String userId, String name, String emailId, String mobileNumber) throws Exception {
		validateDuplicateUser(userId);
		User user = new User(userId, name, emailId, mobileNumber);
		return users.put(userId, user);
	}

	public Collection<User> fetchAll() {
		return users.values();
	}

	public User fetchUser(String userId) throws Exception {
		validateNoSuchUser(userId);
		return users.get(userId);
	}
	
	private void validateNoSuchUser(String userId) throws Exception {
		if (users.containsKey(userId))
			throw new Exception("No such user: " + userId);
	}

	private void validateDuplicateUser(String user) throws Exception {
		if (users.containsKey(user))
			throw new Exception("User is already present: " + user);
	}
	
	public static synchronized UsersDb getInstance() {
		return INSTANCE;
	}
}

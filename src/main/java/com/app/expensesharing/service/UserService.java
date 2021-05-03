package com.app.expensesharing.service;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import com.app.expensesharing.dao.UsersDb;
import com.app.expensesharing.model.User;

public class UserService {

	private static final UserService INSTANCE = new UserService();
	
	private UsersDb userdb = UsersDb.getInstance();
	
	public User createUser(String userId, String name, String emailId, String mobileNumber) throws Exception {
		validateInputs(userId, name, emailId, mobileNumber);
		return userdb.add(userId, name, emailId, mobileNumber);
	}
	
	public User fetchUser(String userId) throws Exception {
		return userdb.fetchUser(userId);
	}
	
	public Collection<User> fetchAll() {
		return userdb.fetchAll();
	}
	
	private void validateInputs(String userId, String name, String emailId, String mobileNumber) throws Exception {
		if (StringUtils.isAllEmpty(userId)) throw new Exception("UserId is Blank");
		validateMobileNumber(mobileNumber);
		validateEmailId(emailId);
	}

	private void validateEmailId(String emailId) throws Exception {
		if (StringUtils.isAllEmpty(emailId)) throw new Exception("Email Address is Blank");
		
	}

	private void validateMobileNumber(String mobileNumber) throws Exception {
		// India requires 10 digits
		// same mobile number for other user
		if (StringUtils.isAllEmpty(mobileNumber)) throw new Exception("Mobile Number is Blank");
		
	}
	
	public static UserService getInstance() {
		return INSTANCE;
	}
}

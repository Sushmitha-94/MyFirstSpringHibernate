package com.sush.first.dao;

import com.sush.first.model.User;

public interface UserDAO {
	
	public User userLogin(User user);
	public User updatePassword(User user, String newPassword);
	public User updateEmail(User user,String newEmail);
	public int deleteUser(User user);
	public User setUpUser(User user);
}

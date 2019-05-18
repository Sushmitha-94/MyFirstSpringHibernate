package com.sush.first.service;

import org.springframework.stereotype.Controller;

import com.sush.first.model.User;


public interface UserService {
	
	public User userLogin(String username, String password);
	public User updatePassword(User user, String newPassword);
	public User updateEmail(User user,String newEmail);
	public void deleteUser(User user);
	public User setUpUser(User user);
}

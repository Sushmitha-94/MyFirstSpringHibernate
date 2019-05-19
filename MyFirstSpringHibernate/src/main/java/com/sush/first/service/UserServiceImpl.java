package com.sush.first.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sush.first.dao.UserDAO;
import com.sush.first.model.User;

@Controller
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	public User userLogin(String username,String password) {		
		User user = userDAO.getUserDetails(username);
		if(user.getPassword().equals(password))
			return user;
		else
			return null;
	}

	public User updatePassword(User user, String newPassword) {
		user.setPassword(newPassword);
		user = userDAO.updateUser(user);
		return user;
	}

	public User updateEmail(User user, String newEmail) {
		user.setEmail(newEmail);
		User user1 = userDAO.updateUser(user);
		return user1;
	}

	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	public User setUpUser(User user) {
		return userDAO.insertUser(user);
	}

}

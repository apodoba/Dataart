package com.dataart.service;

import java.util.List;

import com.dataart.domain.Account;
import com.dataart.domain.User;

public interface UserService {

	public List<User> listUsers();
	
	/*public void addUser(User user);

	public void removeUser(Integer id);*/

	public User getLoginUser(String userName);
		
}
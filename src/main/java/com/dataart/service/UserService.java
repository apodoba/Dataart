package com.dataart.service;

import java.util.List;

import com.dataart.domain.User;

public interface UserService {

	public List<User> listUsers();

	public User getLoginUser();
	
	public List<User> listSimpleUsers();
		
}
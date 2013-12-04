package com.dataart.dao;

import java.util.List;

import com.dataart.domain.User;

public interface UserDAO {

    public List<User> listUsers();
    	
	public User getUserByName(String userName);
	
	public List<User> listUsersForRole(String role);

}
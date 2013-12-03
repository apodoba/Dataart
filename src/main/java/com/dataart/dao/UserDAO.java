package com.dataart.dao;

import java.util.List;

import com.dataart.domain.Account;
import com.dataart.domain.User;

public interface UserDAO {

    public List<User> listUsers();
    
/*	public void addUser(User user);

	public void removeUser(Integer id);*/
	
	public User getUserByName(String userName);

}
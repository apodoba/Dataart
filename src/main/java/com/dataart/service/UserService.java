package com.dataart.service;

import java.util.List;

import com.dataart.domain.User;

public interface UserService {

    public void addUser(User user);

    public List<User> listUsers();

    public void removeUser(Integer id);

	public User getProfile(User user);
	
}
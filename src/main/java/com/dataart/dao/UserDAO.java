package com.dataart.dao;

import java.util.List;

import com.dataart.domain.User;

public interface UserDAO {

    public void addUser(User user);

    public List<User> listUsers();

    public void removeUser(Integer id);

	public User getProfile(User user);
}
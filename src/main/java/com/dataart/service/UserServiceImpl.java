package com.dataart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.dao.UserDAO;
import com.dataart.domain.Account;
import com.dataart.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
		
	private User currentUser;

	@Transactional
	public List<User> listUsers() {
		return userDAO.listUsers();
	}

/*	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}


	@Transactional
	public void removeUser(Integer id) {
		userDAO.removeUser(id);
	}
*/
	@Override
	@Transactional
	public User getLoginUser(String userName) {
		if (currentUser == null) {
			currentUser = userDAO.getUserByName(userName);
		}
		return currentUser;
	}
	
}
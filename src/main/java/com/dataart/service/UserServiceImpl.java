package com.dataart.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.dao.RoleDAO;
import com.dataart.dao.UserDAO;
import com.dataart.domain.Role;
import com.dataart.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
		
	private User currentUser;
	private final static String USER_ROLE = "ROLE_USER";

	@Transactional
	public List<User> listUsers() {
		return userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getLoginUser() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if (currentUser == null) {
			currentUser = userDAO.getUserByName(userName);
		}
		return currentUser;
	}

	@Override
	@Transactional
	public List<User> listSimpleUsers() {
		Role role = roleDAO.getRoleByName(USER_ROLE);
		if(role != null)
			return userDAO.listUsersForRole(USER_ROLE);
		return Collections.emptyList();
	}
	
}
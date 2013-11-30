package com.dataart.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.dao.UserDAO;
import com.dataart.domain.User;
 
@Service
public class UserServiceImpl implements UserService {

	  @Autowired
	    private UserDAO userDAO;
	 
		@Transactional
	    public void addUser(User user) {
	        userDAO.addUser(user);
	    }
	 
	    @Transactional
	    public List<User> listUsers() {
	        return userDAO.listUsers();
	    }
	 
	    @Transactional
	    public void removeUser(Integer id) {
	        userDAO.removeUser(id);
	    }

		@Override
		public User getProfile(User user) {
			return userDAO.getProfile(user);

		}
}
package com.dataart.dao;


import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml"})
@Transactional
public class UserDaoTest {
	
	@Autowired
	private UserDAO userDAO;

	@Test
	public void testGetUsers() {
		List<User> users = userDAO.listUsers();
		Assert.assertNotNull(users);
	}
	
	@Test
	public void testGetUsersByName() {
		String userName = "admin";
		User user = userDAO.getUserByName(userName);
		Assert.assertNotNull(user);
		Assert.assertEquals("ROLE_ADMIN", user.getRole().getRole());
	}
	
	@Test
	public void testGetUsersById() {
		String userName = "admin";
		User user = userDAO.getUserByName(userName);
		Assert.assertEquals("ROLE_ADMIN", user.getRole().getRole());
	}
	
	@Test
	public void testErrorGetUsersById() {
		String userName = "user";
		User user = userDAO.getUserByName(userName);
		Assert.assertNotSame("ROLE_ADMIN", user.getRole().getRole());
	}
	
}
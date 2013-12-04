package com.dataart.dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.domain.User;

/**
 * 
 * @author Arina Podoba
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml"})
@Transactional
public class UserDaoIT {
	
	@Autowired
	private UserDAO userDAO;

	@Test
	public void testGetUsers() {
		List<User> users = userDAO.listUsersForRole("ROLE_USER");
		System.out.println(users.size());
	}
	
}
package com.dataart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dataart.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from Users").list();
    }

    public void removeUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
/*
	public User getProfile(Long id) {
		Query q = sessionFactory.getCurrentSession().createQuery("from Users where id = :id");
        q.setLong("id", id);
        return (User) q.uniqueResult();
	}*/

	@Override
	public User getProfile(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
    
    public User getUserByID(int id){
    	return (User) sessionFactory.getCurrentSession().get(User.class, id); 
    }
}
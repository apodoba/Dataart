package com.dataart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dataart.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
    
    @SuppressWarnings("unchecked")
	public List<User> listUsersForRole(String role) {
    	Query query = sessionFactory.getCurrentSession().createQuery("from User u right join u.role as r where r.role=:roleName").setParameter("roleName", role);
    	
//    	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
//		criteria.add(Restrictions.eq("role", role));
    	return query.list();
    }
	
	@Override
    public User getUserByName(String userName){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		return  (User) criteria.uniqueResult();
    }
}
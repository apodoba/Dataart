package com.dataart.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dataart.domain.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public Role getRoleByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("role", name));
		return (Role) criteria.uniqueResult();
	}

}

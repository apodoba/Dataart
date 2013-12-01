package com.dataart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dataart.domain.Service;

@Repository
public class ServiceDAOImpl implements ServiceDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> getServices() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Service.class);
		return  (List<Service>) criteria.list();
	}

}

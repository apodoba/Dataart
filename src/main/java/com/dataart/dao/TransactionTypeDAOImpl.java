package com.dataart.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dataart.domain.TransactionType;

@Repository
public class TransactionTypeDAOImpl implements TransactionTypeDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public TransactionType getTransactionTypeByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TransactionType.class);
		criteria.add(Restrictions.eq("name", name));
		return  (TransactionType) criteria.uniqueResult();
	}

}

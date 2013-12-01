package com.dataart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dataart.domain.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Transaction> getTransactionsByType(String type) {
		return null;
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		sessionFactory.getCurrentSession().save(transaction);
	}

}

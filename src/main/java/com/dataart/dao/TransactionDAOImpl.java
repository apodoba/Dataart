package com.dataart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dataart.domain.Transaction;

public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Transaction> getTransactionsByType(String type) {
		return null;
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub

	}

}

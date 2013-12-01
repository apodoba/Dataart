package com.dataart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dataart.domain.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void decreaseBalance(Account account, double count) {
		account.setBalance(account.getBalance() - count);
		sessionFactory.getCurrentSession().merge(account);
	}

	@Override
	public void increaseBalance(Account account, double count) {
		account.setBalance(account.getBalance() + count);
		sessionFactory.getCurrentSession().merge(account);
	}

}
package com.dataart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dataart.domain.Account;
import com.dataart.domain.Transaction;

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
	
	@Override
    public Account getAccountByName(String accountName){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Account.class);
		criteria.add(Restrictions.eq("name", accountName));
		return  (Account) criteria.uniqueResult();
    }
	
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Transaction> getTransactions(Account account){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Transaction.class);
		criteria.add(Restrictions.eq("account", account));
		criteria.addOrder(Order.asc("date"));
		return  (List<Transaction>) criteria.list();
    }

}

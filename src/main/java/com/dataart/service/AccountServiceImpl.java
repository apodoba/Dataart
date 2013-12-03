package com.dataart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.dao.AccountDAO;
import com.dataart.domain.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
    private AccountDAO accountDAO;
	
	@Override
	@Transactional
	public void decreaseBalance(Account account, double count) {
		accountDAO.decreaseBalance(account, count);
	}

	@Override
	@Transactional
	public void increaseBalance(Account account, double count) {
		accountDAO.increaseBalance(account, count);
	}

	@Override
	@Transactional
	public Account getAccount(String accountName) {
		return accountDAO.getAccountByName(accountName);
	}
	
	
}

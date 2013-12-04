package com.dataart.dao;

import java.util.List;

import com.dataart.domain.Account;
import com.dataart.domain.Transaction;

public interface AccountDAO {
	
	public void decreaseBalance(Account account,double count);
	
	public void increaseBalance(Account account,double count);
	
	public Account getAccountByName(String accountName);
	
	public List<Transaction> getTransactions(Account account);
	
}

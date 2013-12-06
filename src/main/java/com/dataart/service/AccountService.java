package com.dataart.service;

import java.util.List;

import com.dataart.domain.Account;
import com.dataart.domain.Transaction;
import com.dataart.domain.User;

public interface AccountService {
	
	public void decreaseBalance(Account account, double count);

	public void increaseBalance(Account account, double count);

	public Account getAccount(String accountName);
	
	public void payForService(User loginUser, double money, String numberForPay);
	
	public void payForAccount(User loginUser, double money, Account accountForPay);
	
	public void putMoneyForAccount(User loginUser, double money);
	
	List<Transaction> getTransactions(Account account);
}

package com.dataart.service;

import com.dataart.domain.Account;
import com.dataart.domain.User;

public interface AccountService {
	
	public void decreaseBalance(Account account, double count);

	public void increaseBalance(Account account, double count);

	public Account getAccount(String accountName);
	
	public void payForService(User loginUser, double money);
	
	public void payForAccount(User loginUser, String accountForPay, double money);
}

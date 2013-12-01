package com.dataart.service;

import com.dataart.domain.Account;

public interface AccountService {
	
	public void decreaseBalance(Account account, double count);

	public void increaseBalance(Account account, double count);

}

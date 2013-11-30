package com.dataart.dao;

import com.dataart.domain.Account;

public interface AccountDAO {
	
	public void decreaseBalance(Account account,double count);
	
	public void increaseBalance(Account account,double count);
	
}

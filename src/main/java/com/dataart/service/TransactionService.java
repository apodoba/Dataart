package com.dataart.service;

import com.dataart.domain.Account;
import com.dataart.domain.Transaction;

public interface TransactionService {
	
	public void saveTransaction(Transaction transaction);
	public void saveTransactionWithType(String type, Double money, Account account, String numberForPay);
}

package com.dataart.dao;

import java.util.List;

import com.dataart.domain.Transaction;


public interface TransactionDAO {
	public List<Transaction> getTransactionsByType(String type);
	public void saveTransaction(Transaction transaction);
}

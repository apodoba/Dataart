package com.dataart.dao;

import com.dataart.domain.TransactionType;

public interface TransactionTypeDAO {
	public TransactionType getTransactionTypeByName(String name);
}

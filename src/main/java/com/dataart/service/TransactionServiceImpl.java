package com.dataart.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.dao.TransactionDAO;
import com.dataart.dao.TransactionTypeDAO;
import com.dataart.domain.Account;
import com.dataart.domain.Transaction;
import com.dataart.domain.TransactionType;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private TransactionTypeDAO transactionTypeDAO;

	@Override
	@Transactional
	public void saveTransaction(Transaction transaction) {
		transactionDAO.saveTransaction(transaction);
	}

	@Override
	@Transactional
	public void saveTransactionWithType(String type, Double money, Account account, String numberForPay) {
		TransactionType transactionType = transactionTypeDAO.getTransactionTypeByName(type);
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setDate(new Date());
		transaction.setAmount(money);
		transaction.setTransactionType(transactionType);
		if(numberForPay != null){
			transaction.setDescription(numberForPay);
		}
		transactionDAO.saveTransaction(transaction);		
	}
}

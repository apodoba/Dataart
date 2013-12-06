package com.dataart.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.dao.AccountDAO;
import com.dataart.domain.Account;
import com.dataart.domain.Transaction;
import com.dataart.domain.User;
import com.dataart.enums.TransactionsTypeEnum;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
    private AccountDAO accountDAO;
	
	@Autowired
    private TransactionService transactionService;
	
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
	
	@Override
	@Transactional
	public void putMoneyForAccount(User loginUser, double money){
		increaseBalance(loginUser.getAccount(), money);
		transactionService.saveTransactionWithType(TransactionsTypeEnum.INCREASE_ACCOUNT_PAYMENT.toString(), money, loginUser.getAccount(), null);
	}
	
	@Override
	@Transactional
	public void payForService(User loginUser, double money, String numberForPay){
		decreaseBalance(loginUser.getAccount(), money);
		transactionService.saveTransactionWithType(TransactionsTypeEnum.SERVICE_PAYMENT.toString(), money, loginUser.getAccount(), numberForPay);
	}
	
	@Override
	@Transactional
	public void payForAccount(User loginUser, double money, Account accountForPay){
		if(accountForPay!=null && accountForPay.getId()!=loginUser.getAccount().getId()){
			increaseBalance(accountForPay, money);
			decreaseBalance(loginUser.getAccount(), money);
			transactionService.saveTransactionWithType(TransactionsTypeEnum.HUMAN_PAYMENT.toString(), money,loginUser.getAccount(), null);
		}
	}
	
	@Override
	@Transactional
	public List<Transaction> getTransactions(Account account){
		return accountDAO.getTransactions(account);
	}
}

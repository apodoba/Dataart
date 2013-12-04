package com.dataart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.dao.AccountDAO;
import com.dataart.domain.Account;
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
	public void payForService(User loginUser, double money){
		decreaseBalance(loginUser.getAccount(), money);
		transactionService.saveTransactionWithType(TransactionsTypeEnum.SERVICE_PAYMENT.toString(), money, loginUser.getAccount());
	}
	
	@Override
	@Transactional
	public void payForAccount(User loginUser, String accountForPay, double money){
		Account account = accountDAO.getAccountByName(accountForPay);
		if(account!=null){
			increaseBalance(account, money);
			decreaseBalance(loginUser.getAccount(), money);
			transactionService.saveTransactionWithType(TransactionsTypeEnum.HUMAN_PAYMENT.toString(), money,loginUser.getAccount());
		}else{
			//TODO send error
		}
	}
}

package com.dataart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.domain.User;
import com.dataart.service.AccountService;
import com.dataart.service.TransactionService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
    @Autowired
    private AccountService accountService;
    
	@Autowired
	private TransactionService transactionService;
    
    private User currentUser;
    
    @RequestMapping(value = "/moveBalance/Service", method = RequestMethod.POST)
    public String moveBalanceToService(@ModelAttribute("money") Double money) {
    	if(currentUser.getAccount().getBalance() >= money && money > 0){
    		accountService.payForService(currentUser, money);
    	}else{
    		//TODO return error
    	}
        return "service";
    }
    
    @RequestMapping(value = "/moveBalance/Human", method = RequestMethod.POST)
    public String moveBlToHuman(@ModelAttribute("account") String accountName, @ModelAttribute("money") Double money) {
    	if(currentUser.getAccount().getBalance() >= money && money > 0){
    		accountService.payForAccount(currentUser, accountName, money);
    	}else{
    		//TODO return error
    	}
        return "service";
    }
}
package com.dataart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.service.AccountService;
import com.dataart.service.TransactionService;
import com.dataart.service.UserService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private UserService userService;
    
	@Autowired
	private TransactionService transactionService;
    
    @RequestMapping(value = "/moveBalance/Service", method = RequestMethod.POST)
    public String moveBalanceToService(@ModelAttribute("money") Double money) {
    	if(userService.getLoginUser().getAccount().getBalance() >= money && money > 0){
    		accountService.payForService(userService.getLoginUser(), money);
    	}else{
    		//TODO return error
    	}
        return "redirect:/payment/service";
    }
    
    @RequestMapping(value = "/moveBalance/Human", method = RequestMethod.POST)
    public String moveBlToHuman(@ModelAttribute("account") String accountName, @ModelAttribute("money") Double money) {
    	if(userService.getLoginUser().getAccount().getBalance() >= money && money > 0){
    		accountService.payForAccount(userService.getLoginUser(), accountName, money);
    	}else{
    		//TODO return error
    	}
        return "redirect:/payment/account";
    }
}